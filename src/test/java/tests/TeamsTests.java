package tests;

import config.AuthConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TeamsTests {

    private static TeamsTests footballTests;

    public static Faker faker;

    public static RequestSpecification request;

    public static AuthConfig authConfig;



    @BeforeAll
    public static void setup () {
        RestAssured.baseURI = "https://api.sportmonks.com/v3/football";

        faker = new Faker();

    }

    @BeforeEach
    void setRequest() {
    request = given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
            .header("", "")
            .contentType(ContentType.JSON);
}

    @DisplayName("Verify teams: All teams and specific search")
    @Order(1)
    @Test
    public void VerifyTeams() {
        request
                .body("application/json")
                .when()
                .get("/teams")
                .then().log().all();

        request
                .body("application/json")
                .when()
                .get("/teams/search/Hors")
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
