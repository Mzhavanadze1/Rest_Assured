package Utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ApiGetSpecification {
    private static String baseURL = "http://10.195.105.66:7000";
    public static RequestSpecification getMethodReqSpec(){
        return given()
                .baseUri(baseURL)
                .headers("content-type", "application/json");

    }
    public static ResponseSpecification getMethodRespSpec(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }
}
