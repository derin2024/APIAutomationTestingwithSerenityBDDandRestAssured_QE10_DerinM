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

public class RegisterUnsuccesfulStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Register user unsuccesful")
    public void registerUserUnsuccesful(){
        File json = new File(Constants.REQ_BODY_DIR+"RegisterUserUnsuccesfulReqBody.json");
        reqresAPI.registerUserUnsuccesful(json);
    }

    @When("Send register user unsuccesful")
    public void sendRegisterUserUnsuccesful() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @Then("Register unsuccessful Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequestRegisterUnsuccessful(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Register unsuccessful Response body error should be {string}")
    public void responseBodyErrorShouldBeRegisterUnsuccesful(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate register user unsuccesful JSON Schema")
    public void validateRegisterUnsuccesfulUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserUnsuccesfulJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
