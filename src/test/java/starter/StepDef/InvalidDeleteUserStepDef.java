package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class InvalidDeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete User with invalid {string} id")
    public void invalidDeleteUser(String id) {
        reqresAPI.InvalidDeleteUser(id);
    }
    
    @When("Send delete user with invalid id")
    public void sendInvalidDeleteUser(){
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    
    @Then("Delete user with invalid id Status code should be {int} No Content")
    public void deleteUserInvalidIdCode(int badRequest){
        SerenityRest.then().statusCode(badRequest);
    }
}
