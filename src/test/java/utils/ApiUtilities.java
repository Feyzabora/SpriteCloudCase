package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public Response performApiCall(String requestType, Object input, Boolean fatal){

        Response response = null;

        RequestSpecification request;

        String requestUrl = "https://"+url+uri;

        System.out.println("Performing "+ requestType+" request at: \""+requestUrl+"\"");

        try{
            switch (requestType.toLowerCase()){
                case "post":
                    request = RestAssured.given().header("Content-Type","application/json").header("Accept","application/json");

                    if (input!=null && input!="")
                        request.body(input);
                    else if(fatal)
                        Assert.fail("The input cannot be null");

                    response = request.post(requestUrl);

                    printStatusCode(response);

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

                    if (input!=null && input!="")
                        request.body(input);
                    else if(fatal)
                        Assert.fail("The input cannot be null");

                    response = request.put(requestUrl);

                    printStatusCode(response);

                    serverResponse = jsonUtilities.str2json(response.asString());

                    return response;

                case "delete":
                    request = RestAssured.given().header("Accept","application/json");

                    response = request.delete(requestUrl);

                    printStatusCode(response);

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

    public static int printStatusCode(Response response){
        if (response.getStatusCode()==200)
            System.out.println("Server response: "+response.getStatusCode());
        else if (response.getStatusCode()==500)
            System.out.println("Server response: "+response.getStatusCode());
        else if (response.getStatusCode()==404)
            System.out.println("Server response: "+response.getStatusCode());
        else
            System.out.println("Server response: "+response.getStatusCode());

        return response.getStatusCode();
    }

}

