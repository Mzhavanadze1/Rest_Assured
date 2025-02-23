package Steps;

import Models.SMSModule.GetConsent.GetSMSRequestModel;
import Models.SMSModule.PostConsent.PostSmsRequestModel;
import Utils.ApiGetSpecification;
import Utils.ApiPostSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ConsentCalls {
    RequestSpecification requestSpecificationGet = ApiGetSpecification.getMethodReqSpec();
    RequestSpecification requestSpecificationPost= ApiPostSpecification.postMethodReqSpec();

    public Response getConsentCalls(GetSMSRequestModel getSMSRequestModel) {
        Response response ;

        if (getSMSRequestModel.getTelNumber() == null) {
          response = requestSpecificationGet
                .when()
                .get("/api/Consent?PersonId=" + getSMSRequestModel.getPersonId());
        }
        else {
               response = requestSpecificationGet
                        .when()
                        .get("/api/Consent?TelNumber=" + getSMSRequestModel.getTelNumber());
        }

        response.then().spec(ApiGetSpecification.getMethodRespSpec());
        return response;

    }


    public void postConsentCalls(PostSmsRequestModel postSmsRequestModel) {
        Response response = requestSpecificationPost
                .body(postSmsRequestModel)
                .post();
        response.then().spec(ApiPostSpecification.postMethodRespSpec());
    }
}