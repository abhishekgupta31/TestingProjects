package restAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthoorizationAPIKeys {

    @Test
    public void AuthorizationAPIKeys() {
        // Correct base URI with the HTTPS scheme
        RestAssured.baseURI = "https://api.openweathermap.org";
        
        // Create the request specification
        RequestSpecification reqspec = RestAssured.given();
        
        // Set the base path and query parameters
        reqspec.basePath("/data/2.5/weather")
               .queryParam("q", "Delhi")
               .queryParam("APPID", "e624f98baf5911e1e17fd6f31737bd4b");

        // Send the GET request and capture the response
        Response response = reqspec.get();

        // Validate the response
        Assert.assertEquals(response.statusCode(), 200, "Check for API Key authorization");

        // Print the status line and response body
        System.out.println("Authorization of API Keys: " + response.statusLine());
        System.out.println("Response Body: " + response.body().asString());
    }
}
