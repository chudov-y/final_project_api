import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import models.CreateUserRequest;
import models.CreateUserResponse;
import models.RegisterUserRequest;
import models.RegisterUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.*;


@Owner("chudov-y")
@Feature("API test")
@Tags({@Tag("api")})

public class ReqresApiTests {

    @Test
    @Story("Create new user")
    @DisplayName("Create new user")
    @Description("POST /api/users")
    void createUsersPojoTest() {
        CreateUserRequest authBody = new CreateUserRequest();
        authBody.setName("morpheus");
        authBody.setJob("leader");

        CreateUserResponse response = step("Create user request", () ->
                given(request)
                        .body(authBody)
                        .when()
                        .post("/users")
                        .then()
                        .spec(createUserResponseSpec)
                        .extract().as(CreateUserResponse.class));

        step("Verify response", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("leader", response.getJob());
        });

    }

    @Test
    @Story("Registration")
    @DisplayName("Successful registration of new user")
    @Description("POST /api/register")
    void registerSuccessfulLombokTest() {
        RegisterUserRequest authBody = new RegisterUserRequest();
        authBody.setEmail("eve.holt@reqres.in");
        authBody.setPassword("pistol");

        RegisterUserResponse response = step("Make register request", () ->
                given(request)
                        .body(authBody)
                        .when()
                        .post("/register")
                        .then()
                        .spec(registerSuccessResponseSpec)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () -> {
            assertEquals("4", response.getId());
            assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

        });
    }

    @Test
    @Story("Registration")
    @DisplayName("Unsuccessful registration of new user")
    @Description("POST /api/register")
    void registerUnSuccessfulLombokTest() {
        RegisterUserRequest authBody = new RegisterUserRequest();
        authBody.setEmail("sydney@fife");

        RegisterUserResponse response = step("Make register request", () ->
                given(request)
                        .body(authBody)
                        .when()
                        .post("/register")
                        .then()
                        .spec(missingPasswordResponseSpec)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () ->
                assertEquals("Missing password", response.getError()));
    }

    @Test
    @DisplayName("Successful login")
    @Description("POST /api/login")
    void successLoginLombokTest() {

        RegisterUserRequest authBody = new RegisterUserRequest();
        authBody.setEmail("eve.holt@reqres.in");
        authBody.setPassword("cityslicka");

        RegisterUserResponse response = step("Make register request", () ->
                given()
                .spec(request)
                .body(authBody)
                .when()
                .post("/login")
                .then()
                .spec(registerSuccessResponseSpec)
                .extract().as(RegisterUserResponse.class));

        step("Verify response", () ->
            assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));

    }

    @Test
    @DisplayName("Unsuccessful login")
    @Description("POST /api/login")
    void unSuccessLoginLombokTest() {

        RegisterUserRequest authBody = new RegisterUserRequest();
        authBody.setEmail("peter@klaven");

        RegisterUserResponse response = step("Make register request", () ->
                given()
                        .spec(request)
                        .body(authBody)
                        .when()
                        .post("/login")
                        .then()
                        .spec(missingPasswordResponseSpec)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () ->
            assertEquals("Missing password", response.getError()));

        }

}
