package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class UserDataStep {
    RequestSpecification request;
    Response response;
    Response byID;

    public UserDataStep() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        request = RestAssured.given()
                .header("app-id", "63283b9d74cc7198f1a385e6")
                .header("Content-Type", "application/json");
    }


    @Given("I perform Get Operation For {string}")
    public void iPerformGetOperationFor(String url) {
        response = request.
//                given().contentType(ContentType.JSON)
//                   .header("app-id", "63283b9d74cc7198f1a385e6").
//                    when()
        get("/user");
    }

    @And("I perform GET For the list of user by{string}")
    public void iPerformGETForTheListOfUserBy(String user) {
//        response = when().get("https://dummyapi.io/data/v1/user");
    }

    @Then("I should see all the list of user")
    public void iShouldSeeAllTheListOfUser() {
        System.out.println(response.asString());
    }

    @Given("I perform Get Operation For query parameter {string}")
    public void iPerformGetOperationForQueryParameter(String id) {
        byID = (Response) request
//    given()
//    .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
//   .when()
                .get("/user/60d0fe4f5311236168a109ca");
//                      .then()
//                     .extract().response();
    }

    @Then("I should see  list of user by registration date")
    public void iShouldSeeListOfUserByRegistrationDate() {
        assertThat(byID.getStatusCode(), is(200));
        System.out.println(byID.asString());
    }

    @Given("I perform POST Operation for first name last name and email")
    public void iPerformPOSTOperationForFirstNameLastNameAndEmail() {
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("firstName", "tufyal");
        postContent.put("lastName", "ahmmed");
        postContent.put("email", "qaahaaaaaammed@example.com");

        response = request
//        given()
//                        .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
                        .with()
                .body(postContent).
                when()
                .post("/user/create");
//                        .then()
//                        .extract().response();
    }

    @Then("I should see the created data")
    public void iShouldSeeTheCreatedData() {
        assertThat(response.getStatusCode(), is(200));
        System.out.println(response.asString());
    }

    @Given("I should perform update user data by ID")
    public void iShouldPerformUpdateUserDataByID() {
        HashMap<String, String> postContent = new HashMap<>();
//        postContent.put("id","6329460cb8cd810e77621d14");
        postContent.put("firstName", "atuf");
        postContent.put("lastName", "yal Aahmmed");
        //postContent.put("email","ahaaaaammed@example.com");
        response = request
//                given()
//                        .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
                .with()
                .body(postContent).
                when()
                .put("/user/632ab2f80dc51c7bed5a7b5c/");
//        .then()
//                        .extract().response();
    }

    @Then("I should return Updated Data")
    public void iShouldReturnUpdatedData() {
        assertThat(response.getStatusCode(), is(200));
        System.out.println(response.asString());
    }

    @Given("I should perform Delete Data")
    public void iShouldPerformDeleteData() {
        response = (Response) request
//                given()
//                        .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
//                        . when()
                .delete("/user/632ab2f80dc51c7bed5a7b5c/");
//                        .then()
////                        .statusCode(204)
////                        .log().all();
//                        .extract().response();
    }

    @Then("i Should return Deleted data with status")
    public void iShouldReturnDeletedDataWithStatus() {
        assertThat(response.getStatusCode(), is(200));
        System.out.println(response.asString());
    }
}
