package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String LOGIN_USER = Constants.BASE_URL+"/api/login";
    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";

    @Step("Get lists user with valid parameter page")
    public void getListUsersValidParamPage(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Login User")
    public void loginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Login user unsuccesful")
    public void loginUserUnsuccesful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Register user unsuccesful")
    public void registerUserUnsuccesful(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Get single user by id")
    public void getSingleUserById(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Invalid delete user")
    public void InvalidDeleteUser(String id) {
        SerenityRest.given().pathParam("id",id);
    }


}
