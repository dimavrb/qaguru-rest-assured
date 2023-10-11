package reqres;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;

public class SmokeTest {


    @Test
    void successfulLogin(){
    given()
            .log().all()
            .when()
            .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\" }")
            .contentType(JSON)
            .post("https://reqres.in/api/login")
            .then()
            .statusCode(200)
            .body("token",is("QpwL5tke4Pnpja7X4"));


    }

    @Test
    void unsuccessfulLogin(){
    given()
            .log().all()
            .when()
            .body("{\"email\": \"peter@klaven\" }")
            .contentType(JSON)
            .post("https://reqres.in/api/login")
            .then()
            .statusCode(400)
            .body("error",is("Missing password"));


    }


    @Test
    void successfulRegister(){
    given()
            .log().all()
            .when()
            .body("{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\" }")
            .contentType(JSON)
            .post("https://reqres.in/api/register")
            .then()
            .statusCode(200)
            .body("id",is(4))
            .body("token",is("QpwL5tke4Pnpja7X4"));


    }


    @Test
    void unsuccessfulRegister(){
    given()
            .log().all()
            .when()
            .body("{\"email\": \"sydney@fife\" }")
            .contentType(JSON)
            .post("https://reqres.in/api/register")
            .then()
            .statusCode(400)
            .body("error",is("Missing password"));


    }

    @Test
    void delayedResponse(){
    given()
            .log().all()
            .when()
            .get("https://reqres.in/api/users?delay=3")
            .then()
            .statusCode(200);


    }
}
