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

public class LoginSuccessStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Login user")
    public void loginUser(){
        File json = new File(Constants.REQ_BODY_DIR+"LoginUserReqBody.json");
        reqresAPI.loginUser(json);
    }

    @When("Send login user")
    public void sendLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @Then("After send login status code should be {int} OK")
    public void statusCodeShouldBeOKLogin(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate login user JSON Schema")
    public void validateLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
