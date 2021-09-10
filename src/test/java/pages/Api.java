package pages;

import io.restassured.response.Response;
import org.junit.Assert;
import utils.ApiUtilities;

public class Api {

    ApiUtilities apiUtil = new ApiUtilities();

    public void deletePet(String name, String id){

        apiUtil.uri = apiUtil.uri + "/" + id;

        Response response = apiUtil.performApiCall("delete", null, true);

        if (response.getStatusCode() == 200){
            System.out.println("The pet with id: "+id+" was successfully deleted.");
            apiUtil.contextJSON.put(name, apiUtil.serverResponse);
        }
        else Assert.fail("The server response was unexpectedly "+response.getStatusCode());
    }
}
