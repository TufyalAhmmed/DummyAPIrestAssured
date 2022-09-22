package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NestedPostSteps {
    RequestSpecification request;
    Response response;

    public NestedPostSteps() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        request = RestAssured.given()
                .header("app-id", "63283b9d74cc7198f1a385e6")
                .header("Content-Type", "application/json");
    }

    @Given("user perform nestedPOST Operation for owner and post data")
    public void user_perform_nested_post_operation_for_owner_and_post_data() {
        HashMap<String, Object> postContent = new HashMap<String, Object>();
       HashMap<String, Object> newContent = new HashMap<String, Object>();
//
////        Map<String, String> postContent(<String>){
////            Map<String, String> newContent = new HashMap<String, String>();
//////       JSONObject newContent = new JSONObject();
        newContent.put("street", "9614,sondermarksvej");
        newContent.put("city", "Kongsvinger");
        newContent.put("state", "Nordjylland");
        newContent.put("country", "Denmark");
        newContent.put("timezone", "-9:00");

        postContent.put("firstName", "tufyal");
        postContent.put("lastName", "ahmmed");
        postContent.put("email", "arifrobbanizezun@example.com");
        postContent.put("location", newContent);


//        Employee employee = new Employee();
//        employee.setFirstName("arif");
//        employee.setLastName("zesun");
//        employee.setEmail("arifzezun@example.com");
//
//        Location location = new Location();
//        location.setStreet("9614,sondermarksvej");
//        location.setCity("kongvinger");
//        location.setState("Nordjylland");
//        location.setCountry("Denmark");
//        location.setTimezone("-9:00");
//        employee.setLocation(location);


        response = request
//        given()
//                        .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
                .with()
                .body(postContent)
                .when()
                .post("/user/create/")
                .then()
                .extract().response();
    }

    @Then("user should see the created nestedpost data")
    public void user_should_see_the_created_nestedpost_data() {
        assertThat(response.getStatusCode(), is(200));
        System.out.println(response.asString());
    }
}
