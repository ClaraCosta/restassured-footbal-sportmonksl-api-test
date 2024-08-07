package tests;

import config.AuthConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FootballTests {

    private static FootballTests footballTests;

    public static Faker faker;

    public static RequestSpecification request;

    public static AuthConfig authConfig;


    //kj3s2po6MSHpLJzu1AfSylHXXfn8UhaeEFqOsrH47zfUAq5uQyzPWreIycS1


    @BeforeAll
    public static void setup () {
        RestAssured.baseURI = "https://api.sportmonks.com/v3/football";

        faker = new Faker();

    }

    @BeforeEach
    void setRequest() {
    request = given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
            .header("Authorization", "kj3s2po6MSHpLJzu1AfSylHXXfn8UhaeEFqOsrH47zfUAq5uQyzPWreIycS1")
            .contentType(ContentType.JSON);
}

    @DisplayName("Verify all leagues")
    @Order(1)
    @Test
    public void VerifyLeagues() {
        request
                .body("application/json")
                .when()
                .get("/leagues")
                .then().log().all();


    }

    @DisplayName("Verify Team by: Country Id")
    @Order(2)
    @Test
    public void VerifyTeamByCountryId() {
        request
                .body("application/json")
                .when()
                .get("/countries/320")
                .then().log().all();

    }

    @DisplayName("Verify Team by: Season")
    @Order(3)
    @Test
    public void VerifyTeamBySeason() {
        request
                .body("application/json")
                .when()
                .get("/seasons/196886")
                .then().log().all();

    }



}
