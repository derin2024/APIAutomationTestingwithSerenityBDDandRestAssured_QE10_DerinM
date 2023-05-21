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

public class LoginUnsuccesfulStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Login user unsuccesful")
    public void loginUserUnsuccesful(){
        File json = new File(Constants.REQ_BODY_DIR+"LoginUserUnsuccesfulReqBody.json");
        reqresAPI.loginUserUnsuccesful(json);
    }

    @When("Send login user unsuccesful")
    public void sendLoginUserUnsuccesful() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate login user unsuccesful JSON Schema")
    public void validateLoginUnsuccesfulUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginUserUnsuccesfulJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
