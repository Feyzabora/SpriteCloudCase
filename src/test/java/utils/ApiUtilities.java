package utils;

import io.cucumber.core.api.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ApiUtilities {

    public static JSONObject serverResponse = new JSONObject();
    public static JSONObject contextJSON= new JSONObject();

    JsonUtilities jsonUtilities = new JsonUtilities();
    Properties properties = new Properties();

    public String url;
    public String uri;

    public ApiUtilities(){
        try {
            properties.load(new FileReader("src/test/resources/test.properties"));
            url = properties.getProperty("current.url");
            uri = properties.getProperty("current.uri");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response performApiCall(String requestType, Object body){

        Response response = null;

        RequestSpecification request;

        String requestUrl = "https://"+url+uri;

        System.out.println("Performing "+ requestType+" request at: \""+requestUrl+"\"");

        try{
            switch (requestType.toLowerCase()){
                case "post":
                    request = RestAssured.given().header("Content-Type","application/json").header("Accept","application/json");

                    if (body!=null && body!="")
                        request.body(body);
                    else
                        Assert.fail("The input cannot be null");

                    response = request.post(requestUrl);

                    printStatusCode(response);

                    if (response.getStatusCode()==200)
                        serverResponse = jsonUtilities.str2json(response.asString());

                    return response;

                case "get":
                    response = RestAssured.get(requestUrl);

                    printStatusCode(response);

                    if(response.getStatusCode()==200){
                        contextJSON = jsonUtilities.str2json(response.asString());
                        serverResponse = jsonUtilities.str2json(response.asString());

                    }

                    return response;

                case "put":
                    request = RestAssured.given().header("Content-Type","application/json").header("Accept","application/json");

                    if (body!=null && body!="")
                        request.body(body);
                    else
                        Assert.fail("The input cannot be null");

                    response = request.put(requestUrl);

                    printStatusCode(response);

                    if (response.getStatusCode()==200)
                        serverResponse = jsonUtilities.str2json(response.asString());

                    return response;

                case "delete":
                    request = RestAssured.given().header("Accept","application/json");

                    response = request.delete(requestUrl);

                    printStatusCode(response);

                    System.out.println(response.asString());

                    if (response.getStatusCode()==200)
                        serverResponse = jsonUtilities.str2json(response.asString());

                    return response;

                default:
                    System.out.println("Undefined request type: "+requestType);
                    Assert.fail();
                    return null;

            }
        }catch (Exception gamma){
            Assert.fail("Could not perform requests for the reason: "+gamma.fillInStackTrace());
        }

        return response;
    }

    public Response uploadFile(Object file, String fileUrl){

        Response response = null;

        RequestSpecification request;

        String requestUrl = "https://"+url+uri;

        System.out.println("Performing "+"post"+" request at: \""+requestUrl+"\"");

        request = RestAssured.given().multiPart("file", new File(fileUrl), "image/jpeg");

        if (file!=null && file!="")
            request.body(file);
        else
            Assert.fail("The input cannot be null");

        response = request.post(requestUrl);

        printStatusCode(response);

        serverResponse = jsonUtilities.str2json(response.asString());

        return response;

    }

    public Response performSampleRequest(String requestType, Object input) {

        Response response = null;

        try{
            properties.load(new FileReader("src/test/java/resources/test.properties"));
            String url = properties.getProperty("request.url");

            switch (requestType.toLowerCase()){
                case "get":
                    response = RestAssured.get(url);
                    if(response.getStatusCode()==200)
                        jsonUtilities.saveJson(jsonUtilities.str2json(response.asString()), "ApiResponse");
                    else {
                        System.out.println("Server responded: "+response.getStatusCode());
                    }
                    break;

                case "post":
                    RequestSpecification request = RestAssured.given();

                    request.body(input);

                    response = request.post(url);

                    break;

                default:
                    System.out.println("Undefined request type: "+requestType);
                    Assert.fail();
                    break;

            }

        }catch (Exception gamma){
            Assert.fail("Could not perform requests for the reason: "+gamma.fillInStackTrace());
        }
        return response;
    }

    public Response uploadReport(File report, File ss, Scenario scenario){

        Response response;

        RequestSpecification request;

        String requestUrl = "https://"+url+uri;

        System.out.println("Performing "+"post"+" request at: \""+requestUrl+"\"");

        if (scenario.isFailed()){
            request = RestAssured.given()
                    .header("Accept","application/json")
                    .header("x-api-key", "ZmVlMThjN2RkODJiNjA3MGZjZWU4YTAyMDgxOTViMDM4M2YxODNlMGE1ZDcxYjk5YWU5MjEwY2NjZjI1YjE1Yzc5")
                    .header("Content-Type", "multipart/form-data")
                    .multiPart("file[]", report, "type=text/xml")
                    .multiPart("file[]", ss, "type=text/xml")
                    .formParam("envelope", "false")
                    .formParam("smart", "true");
        }
        else {
            request = RestAssured.given()
                    .header("Accept","application/json")
                    .header("x-api-key", "ZmVlMThjN2RkODJiNjA3MGZjZWU4YTAyMDgxOTViMDM4M2YxODNlMGE1ZDcxYjk5YWU5MjEwY2NjZjI1YjE1Yzc5")
                    .header("Content-Type", "multipart/form-data")
                    .multiPart("file[]", report, "type=text/xml")
                    .formParam("envelope", "false")
                    .formParam("smart", "true");
        }

        response = request.post(requestUrl);

        printStatusCode(response);

        if (response.getStatusCode() == 200)
            serverResponse = jsonUtilities.str2json(response.asString());
        else
            response.prettyPrint();

        return response;

    }

    public static int printStatusCode(Response response){
        System.out.println("Server response: "+response.getStatusCode());
        return response.getStatusCode();
    }

}

