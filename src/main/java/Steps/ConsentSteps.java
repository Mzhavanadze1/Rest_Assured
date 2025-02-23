package Steps;

import Models.SMSModule.GetConsent.GetSMSRequestModel;
import Models.SMSModule.GetConsent.GetSMSResponseModel;
import Models.SMSModule.PostConsent.PostSmsRequestModel;
import io.restassured.response.Response;
import org.testng.Assert;

public class ConsentSteps {
    public GetSMSResponseModel getConsent(GetSMSRequestModel getSMSRequestModel){

        GetSMSResponseModel getSMSResponseModel=new GetSMSResponseModel();
        ConsentCalls consentCalls=new ConsentCalls();
        Response response= consentCalls.getConsentCalls(getSMSRequestModel);
        getSMSResponseModel= response.as(GetSMSResponseModel.class);

        return getSMSResponseModel;
    }

    public void postConsent(PostSmsRequestModel postSmsRequestModel){

        ConsentCalls consentCalls=new ConsentCalls();
        consentCalls.postConsentCalls(postSmsRequestModel);

    }

    public void compareConsent(GetSMSResponseModel getSMSResponseModel, PostSmsRequestModel postSmsRequestModel){
        Assert.assertEquals(getSMSResponseModel.getData().getConsentStatusId(), postSmsRequestModel.getStatus());
    }
}
