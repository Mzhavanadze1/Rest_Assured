package org.credobankTestAutomation.CssLibraryDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.credobankTestAutomation.CssLibraryDemo.Models.CreatePersonResponseModel;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class CreatePersonTest {
    DataControlerCreateUser dataControllerCreateUser = new DataControlerCreateUser();
    CreatePersonSteps createPersonSteps = new CreatePersonSteps();
    String token = "";
    CreatePersonResponseModel createPersonResponseModel = new CreatePersonResponseModel();

    public CreatePersonResponseModel Create(String channel) throws Exception {
        CreatePersonResponseModel createPersonResponseModel = new CreatePersonResponseModel();

        try {
            String jsonString = Files.readString(Path.of("src/main/java/org/credobankTestAutomation/CssLibraryDemo/Data/AddUserFields.json"));
            JSONObject jsonObject=new JSONObject(jsonString);
            token=dataControllerCreateUser.getCssToken();
            String phone= dataControllerCreateUser.generateRandomNumber();
            String personalN= String.valueOf(dataControllerCreateUser.generatePersonalN());
            jsonObject.put("Mobile",phone);
            jsonObject.put("PersonalN",personalN);
            jsonObject.put("ChannelTypeId",channel);
            jsonObject.put("ChannelId",channel);
            createPersonResponseModel= createPersonSteps.createPerson(jsonObject, token.split(" ")[1]);

        } catch (SQLException | ClassNotFoundException | JsonProcessingException e) {
            createPersonResponseModel.setError(e.toString());
            throw new Exception(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return createPersonResponseModel;
    }

}