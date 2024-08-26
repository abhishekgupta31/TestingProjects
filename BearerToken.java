package restAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class BearerToken {

    @Test
    public void testBearerToken() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://gorest.co.in/");
        request.basePath("/public/v2/users");  // Corrected path
        
        // JSON body
        JSONObject json = new JSONObject();
        json.put("name", "Abhishek");
        json.put("gender", "male");  // Corrected key "Gender" to "gender"
        json.put("email", "abhi.gupta31@gmail.com");
        json.put("status", "active");  // Corrected key "Status" to "status"
        
        String autoToken = "Bearer ead36b930657ac2020be21857e57d728792906e57825a6b43fdaff1e127060e4";
        
        request.header("Authorization", autoToken)
               .contentType(ContentType.JSON)
               .body(json.toJSONString());
        
        Response responseNew = request.post();
        
        // Assertions
        Assert.assertEquals(responseNew.statusCode(), 201, "Check for bearer token status");
        
        // Output the response details
        System.out.println("Status Line: " + responseNew.statusLine());
        System.out.println("Response Body: " + responseNew.getBody().asString());
    }
}
