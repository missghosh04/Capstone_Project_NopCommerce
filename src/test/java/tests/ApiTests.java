package tests;

import api.ApiHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTests {

    @BeforeClass
    public void setup() {
        ApiHelper.setBaseURI("https://jsonplaceholder.typicode.com"); // Example API
    }

    @Test
    public void testGetRequest() {
        Response response = ApiHelper.getRequest("/posts/1");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Response: " + response.getBody().asString());
    }

    @Test
    public void testPostRequest() {
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Automation Test");
        body.put("body", "API Testing with RestAssured");
        body.put("userId", 1);

        Response response = ApiHelper.postRequest("/posts", body);
        Assert.assertEquals(response.statusCode(), 201);
        System.out.println("Created Resource: " + response.getBody().asString());
    }
}
