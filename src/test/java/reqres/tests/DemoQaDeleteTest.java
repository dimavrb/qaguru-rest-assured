package reqres.tests;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import reqres.api.AuthorizationApi;
import reqres.api.BooksApi;
import reqres.models.AddBooksListModel;
import reqres.models.DeleteBookModel;
import reqres.models.IsbnModel;
import reqres.models.LoginBodyResponseDemoqa;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static reqres.tests.TestData.credentials;


public class DemoQaDeleteTest extends TestBase {

    LoginBodyResponseDemoqa loginResponse = new LoginBodyResponseDemoqa();
    DeleteBookModel deleteBookModel = new DeleteBookModel();
    AddBooksListModel booksList = new AddBooksListModel();
    IsbnModel isbnModel = new IsbnModel();


    @Test
    void deleteTest() {
        step("Авторизация", () -> loginResponse = AuthorizationApi.login(credentials));

        step("Подготовка тестовых данных", () -> {
            isbnModel.setIsbn("9781449325862");
            List<IsbnModel> isbnList = new ArrayList<>();
            isbnList.add(isbnModel);
            booksList.setUserId(loginResponse.getUserId());
            booksList.setCollectionOfIsbns(isbnList);
            deleteBookModel.setIsbn("9781449325862");
            deleteBookModel.setUserId(loginResponse.getUserId());
        });
        step("Удаление всех книг перед тестом", () -> BooksApi.deleteAllBooks(loginResponse));
        step("Добавление книги", () -> BooksApi.addBook(loginResponse, booksList));
        step("Удаление книги", () -> BooksApi.deleteOneBook(loginResponse, deleteBookModel));
        step("Открытие браузера с добавлением авторизационных данных", () -> {
            open("/favicon.ico");
            getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
            getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
            getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        });
        step("Открытие страницы профиля", () -> open("/profile"));
        step("Проверка что книга отсутствует в профиле", () -> $(".rt-tbody").shouldNotHave(text("Git Pocket Guide")));

    }


}

