package Testcases;

import Utility.Base;
import io.restassured.RestAssured;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class TestcasesRestAssured extends Base {
    public static void getType(String value) {
        given().header("Pragma","no-cache")
                .when().get(value)
                .then().log().all().statusCode(200);
    }

    public static void baseUrl(String URL) {
        RestAssured.baseURI = URL;
    }

    public void firstId() throws IOException {
        baseUrl(propertyFile("BaseUrl"));
        getType(propertyFile("FirstId"));
        logInfo("---------- executing with First Id : "+propertyFile("BaseUrl")+propertyFile("FirstId"));
    }

    public void secondId() throws IOException {
        baseUrl(propertyFile("BaseUrl"));
        getType(propertyFile("secondId"));
        logInfo("---------- executing with First Id : "+propertyFile("BaseUrl")+propertyFile("secondId"));
    }

    public void thirdId() throws IOException {
        baseUrl(propertyFile("BaseUrl"));
        getType(propertyFile("ThirdId"));
        logInfo("---------- executing with First Id : "+propertyFile("BaseUrl")+propertyFile("ThirdId"));
    }
}
