package reqres.tests;


import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://demoqa.com";
        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remote = System.getProperty("remote","https://user1:1234@selenoid.autotests.cloud/wd/hub");
        String browserVersion = System.getProperty("browserVersion","100.0");
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = remote;
        Configuration.browserVersion = browserVersion;
    }


    @AfterEach
    void shutDown() {
        closeWebDriver();

    }

}
