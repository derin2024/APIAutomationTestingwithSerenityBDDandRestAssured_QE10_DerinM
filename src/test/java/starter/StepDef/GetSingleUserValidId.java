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

public class GetSingleUserValidId {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get user by Id {int}")
    public void getUserById(int id){
        reqresAPI.getSingleUserById(id);
    }

    @When("Send get user by Id")
    public void sendGetUserById() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Get single user Status code should be {int} OK")
    public void statusCodeShouldBeOKGetSingleUser(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body id should be {int} and first name should be {string} and last name should be {string}")
    public void responseBodyIdShouldBeAndFirstNameShouldBeAndLastNameShouldBe(int id, String firstName, String lastName) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID,equalTo(id))
                .body(ReqresResponses.DATA_FIRST_NAME,equalTo(firstName))
                .body(ReqresResponses.DATA_LAST_NAME,equalTo(lastName));
    }

    @And("Validate get single user JSON Schema")
    public void validateGetSingleUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"GetSingleUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
