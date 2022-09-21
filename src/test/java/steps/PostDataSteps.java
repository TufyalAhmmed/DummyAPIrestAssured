package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostDataSteps {

    RequestSpecification request;
    Response response;
    public PostDataSteps() {
        RestAssured.baseURI =  "https://dummyapi.io/data/v1";
        request = RestAssured.given()
                .header("app-id", "63283b9d74cc7198f1a385e6")
                .header("Content-Type", "application/json");
    }

    @Given("I perform GET operation for {string} by Creation date")
    public void iPerformGETOperationForByCreationDate(String url) {
        response = request
//                given().contentType(ContentType.JSON)
//                    .header("app-id", "63283b9d74cc7198f1a385e6").
//                    when()
                    .get("/post/");
    }
    @Then("I should see the Get list")
    public void iShouldSeeTheGetList() {
        assertThat(response.getStatusCode(),is(200));
        System.out.println(response.asString());
    }

    @Given("Get list of posts for specific user sorted by creation date.")
    public void getListOfPostsForSpecificUserSortedByCreationDate() {
       response = (Response) request
//               given()
//                .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
//                .when()
                .get("/user/60d0fe4f5311236168a109ca/post/");
//                .then()
//                .extract().response();
    }

    @Then("I should see the get list by user")
    public void iShouldSeeTheGetListByUser() {
        assertThat(response.getStatusCode(),is(200));
        System.out.println(response.asString());
    }

    @Given("I perform GET operation for the list created by {string}")
    public void iPerformGETOperationForTheListCreatedBy(String url) {
        response = (Response) request
//                given()
//                .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
//                .when()
                .get("/tag/60d0fe4f5311236168a109ca/post/");
//                .then()
//                .extract().response();
    }

    @Then("I should see the get liSt by Tag")
    public void iShouldSeeTheGetLiStByTag() {
        assertThat(response.getStatusCode(),is(200));
        System.out.println(response.asString());
    }

    @Given("I perform GET operation for the full data of a post id")
    public void iPerformGETOperationForTheFullDataOfAPostId() {
        response = (Response) request
//                given()
//                .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
//                .when()
                .get("/post/60d21b4667d0d8992e610c85/");
//                .then()
//                .extract().response();
    }

    @Then("I should see the data by post id")
    public void iShouldSeeTheDataByPostId() {
        assertThat(response.getStatusCode(),is(200));
        System.out.println(response.asString());
    }

    @Given("I perform POST Operation for owner and post data")
    public void iPerformPOSTOperationForOwnerAndPostData() {
        HashMap<String ,String> postContent = new HashMap<>();
        postContent.put("text","tufyal");
        postContent.put("image","");
        postContent.put("likes","");
        postContent.put("tags","[\"animel\",dog\"]");
        postContent.put("owner","60d0fe4f5311236168a109ca");

        response = (Response) request
        //given()
                       // .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
                        .with()
                        .body(postContent)
                       // when()
                        .post("/post/create");
//                .then()
//                        .extract().response();
    }

    @Then("I should see the created post data")
    public void iShouldSeeTheCreatedPostData() {
        assertThat(response.getStatusCode(),is(200));
        System.out.println(response.asString());
    }

    @Given("I should perform update post data by ID")
    public void iShouldPerformUpdatePostDataByID() {
        HashMap<String ,String> postContent = new HashMap<>();
        postContent.put("text","Tufyal Ahmmede");
        postContent.put("image","");
        postContent.put("likes","");
        postContent.put("tags","[\"animel\",dog\"]");
       // postContent.put("owner","60d0fe4f5311236168a109ca");

        response = request
               // given()
               //         .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
                        .with()
                        .body(postContent)
                       // when()
                        .put("/post/63296a86300dfa5a8d1d1c15/");
//     //   . then()
//                        .extract().response();
    }

    @Then("I should return Updated post Data")
    public void iShouldReturnUpdatedPostData() {
        assertThat(response.getStatusCode(),is(200));
        System.out.println(response.asString());
    }

    @Given("I should perform Delete post Data by id")
    public void iShouldPerformDeletePostDataById() {
        response =(Response) request

                      //  given()
                             //   .contentType(ContentType.JSON).header("app-id", "63283b9d74cc7198f1a385e6")
                                //. when()
                                .delete("/post/60d0fe4f5311236168a109ca/");
//                                .then()
////                        .statusCode(204)
////                        .log().all();
//                                .extract().response();
    }

    @Then("i Should return Deleted data for the id")
    public void iShouldReturnDeletedDataForTheId() {
        assertThat(response.getStatusCode(),is(204));
        System.out.println(response.asString());
    }
}

