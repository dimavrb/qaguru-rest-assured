package reqres.api;

import reqres.models.AddBooksListModel;
import reqres.models.DeleteBookModel;
import reqres.models.LoginBodyResponseDemoqa;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BooksApi {
    public static void deleteAllBooks(LoginBodyResponseDemoqa loginResponse) {
        given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .statusCode(204);
    }

    public static void addBook(LoginBodyResponseDemoqa loginResponse, AddBooksListModel booksList) {
        given()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(booksList)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .statusCode(201);
    }


    public static void deleteOneBook(LoginBodyResponseDemoqa loginResponse, DeleteBookModel deleteBookModel) {
        given()
                .log().all()
                .contentType(JSON)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(deleteBookModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .log().all()
                .statusCode(204);


    }
}