package org.credobankTestAutomation.CssLibraryDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.credobankTestAutomation.CssLibraryDemo.Models.CreatePersonResponseModel;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

public class CreatePersonSteps {
    public CreatePersonResponseModel createPerson(JSONObject jsonObject, String accessToken) throws JsonProcessingException {
        CreatePersonCall createPersonCall=new CreatePersonCall();
        Response applicationResponse=createPersonCall.response(jsonObject,accessToken);
        int statusCode=applicationResponse.getStatusCode();
        CreatePersonResponseModel createPersonResponseModel=null;
        if (statusCode==200){
            createPersonResponseModel=applicationResponse.as(CreatePersonResponseModel.class);
            System.out.println(createPersonResponseModel.result);

        }else {
            createPersonResponseModel=new CreatePersonResponseModel();
            createPersonResponseModel.setError(String.format("Eror occured: status code %d, Response:%s ",statusCode,applicationResponse.getBody().peek()));


        }
        return createPersonResponseModel;

    }
}
