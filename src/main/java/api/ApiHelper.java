package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    // 🔹 Set Base URI
    public static void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    // 🔹 GET Request (no params)
    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    // 🔹 GET Request with Query Params
    public static Response getRequest(String endpoint, Map<String, String> queryParams) {
        return given()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    // 🔹 POST Request with JSON Body
    public static Response postRequest(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    // 🔹 POST Request with Headers
    public static Response postRequest(String endpoint, Object body, Map<String, String> headers) {
        return given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    // 🔹 PUT Request
    public static Response putRequest(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    // 🔹 DELETE Request
    public static Response deleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }
}
