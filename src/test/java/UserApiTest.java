import io.qameta.allure.Description;
import io.qameta.allure.Story;
import models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.Specs.request;
import static specs.Specs.responseSpec;

public class UserApiTest {
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
                        .spec(responseSpec)
                        .statusCode(201)
                        .extract().as(CreateUserResponse.class));

        step("Verify response", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("leader", response.getJob());
        });

    }

    @Test
    @Story("User registration")
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
                        .spec(responseSpec)
                        .statusCode(200)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () -> {
            assertEquals("4", response.getId());
            assertNotNull(response.getToken());

        });
    }

    @Test
    @Story("User registration")
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
                        .spec(responseSpec)
                        .statusCode(400)
                        .extract().as(RegisterUserResponse.class));

        step("Verify response", () ->
                assertEquals("Missing password", response.getError()));
    }

    @Test
    @Story("Delete user")
    @DisplayName("Delete user")
    void checkDeleteTest() {
        step("Delete user", () ->
                given(request)
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(responseSpec)
                        .statusCode(204)
        );
    }
    @Test
    @Story("List users")
    @DisplayName("List users")
    void listUsersTest() {
        ListUsersResponse response = step("Get users list", () ->
        given(request)
                .when()
                .get("/users?page=2")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(ListUsersResponse.class)
        );

        step("Verify users list", () -> {
            assertEquals(2, response.getPage());
            assertEquals(12, response.getTotal());
            assertEquals("https://reqres.in/#support-heading", response.getSupport().getUrl());
        });
    }
}
