package config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class AuthConfig {

    private static final String BASE_URL = "";

    public static RequestSpecification getRequestSpecification() {
        return RestAssured.given()

    }
}
