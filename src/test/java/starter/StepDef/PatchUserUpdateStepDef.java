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

public class PatchUserUpdateStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch update user with valid json and id {int}")
    public void patchUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"PatchUpdateUserReqBody.json");
        reqresAPI.patchUpdateUser(id, json);
    }

    @When("Send patch update user")
    public void sendPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @Then("Status code Patch update user should be {int} OK")
    public void statusCodeShouldBeOKPatchUpdateUser(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body Patch update user name should be {string} and job should be {string}")
    public void responseBodyIdShouldBeAndNameShouldBeAndJobShouldBe(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate patch update user JSON Schema")
    public void validatePatchUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"PatchUpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
