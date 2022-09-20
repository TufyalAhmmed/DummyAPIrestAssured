package pages;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExtension {
    public static RequestSpecification Request;
    public RestAssuredExtension(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://dummyapi.io/data/v1/");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }
}
