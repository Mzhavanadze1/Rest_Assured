
import Models.SMSModule.GetConsent.GetSMSRequestModel;
import Models.SMSModule.GetConsent.GetSMSResponseModel;
import Models.SMSModule.PostConsent.PostSmsRequestModel;
import Steps.ConsentSteps;

import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static DataController.SMSModule.*;
import static io.restassured.RestAssured.given;

public class Task4 extends ConfigTest {


    ConsentSteps consentSteps = new ConsentSteps();
    GetSMSRequestModel getSMSRequestModel=new GetSMSRequestModel();


    @Test(dataProvider = "PostSMSModuleTest")
    public void SMSModulePostMethod(PostSmsRequestModel postSmsRequestModel) throws SQLException, ClassNotFoundException {
        consentSteps.postConsent(postSmsRequestModel);
        getSMSRequestModel.setTelNumber(postSmsRequestModel.getTelNumber());
        getSMSRequestModel.setPersonId(postSmsRequestModel.getPersonId());
        GetSMSResponseModel getSMSResponseModel = consentSteps.getConsent(getSMSRequestModel);
        consentSteps.compareConsent(getSMSResponseModel, postSmsRequestModel);

    }


}