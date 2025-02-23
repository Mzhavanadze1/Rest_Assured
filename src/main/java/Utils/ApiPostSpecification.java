package Utils;

import Models.SMSModule.PostConsent.PostSmsRequestModel;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ApiPostSpecification {
    private static String baseURL = "http://10.195.105.66:7000";

    public static RequestSpecification postMethodReqSpec(){
        return given()
                .baseUri(baseURL)
                .basePath("/api/Consent")
                .headers("content-type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);


    }

    public static ResponseSpecification postMethodRespSpec(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }
}
