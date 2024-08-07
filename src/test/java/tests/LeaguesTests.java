package tests;

import com.github.javafaker.Faker;
import config.AuthConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class LeaguesTests {

    private static LeaguesTests footballTests;

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

    @DisplayName("Verify: All Leagues and specific league")
    @Order(1)
    @Test
    public void VerifyLeagues() {
        request
                .body("application/json")
                .when()
                .get("/leagues")
                .then().log().all();

        request
                .body("application/json")
                .when()
                .get("/leagues/search/Sup")
                .then().log().all();


    }

    @DisplayName("Verify League by: Country Id")
    @Order(2)
    @Test
    public void VerifyLeagueByCountryId() {
        request
                .body("application/json")
                .when()
                .get("/leagues/countries/320")
                .then().log().all();

    }


    @DisplayName("Verify League by: Date")
    @Order(3)
    @Test
    public void VerifyLeagueByDate() {
        request
                .body("application/json")
                .when()
                .get("/leagues/date/2022-07-15")
                .then().log().all();

    }



}
