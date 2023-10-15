package reqres.api;

import reqres.models.CredentialsModel;
import reqres.models.LoginBodyResponseDemoqa;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class AuthorizationApi {


    public static LoginBodyResponseDemoqa login(CredentialsModel credentials) {
        return given()
                .body(credentials)
                .contentType(JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .statusCode(200)
                .extract()
                .as(LoginBodyResponseDemoqa.class);
    }
}