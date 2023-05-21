package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;
    // Get list users
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsersValidParamPage(page);
    }

    @When("Send get lists users")
    public void sendGetListsUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and().body("page",equalTo(page));
    }

    @And("Validate get list user JSON Schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Post create new user
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate post create user JSON Schema")
    public void validatePostCreateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"CreateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // put update user
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Then("Status code Put Update user should be {int} OK")
    public void statusCodePutUpdateUserShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response Put Update body name was {string} and job was {string}")
    public void responsePutUpdateBodyNameWasAndJobWasAndUpdatedAtWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate put update user JSON Schema")
    public void validatePutUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    // delete user
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }


}
