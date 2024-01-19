import io.qameta.allure.Description;
import io.qameta.allure.Story;
import models.RegisterUserRequest;
import models.RegisterUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.Specs.request;
import static specs.Specs.responseSpec;

public class AuthApiTest {

    @Test
    @Story("User authorization")
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
                        .spec(responseSpec)
                        .statusCode(200)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () ->
                assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));

    }

    @Test
    @Story("User authorization")
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
                        .spec(responseSpec)
                        .statusCode(400)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () ->
                assertEquals("Missing password", response.getError()));

    }

}
