package restAssuredDemo;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestResponseHeader {
    @Test
    public void testHeader() {
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://reqres.in/");
        request.basePath("/api/users/2");
        
        Response response = request.get();
//        String connection = response.getHeader("Connection");
        String contentType = response.getHeader("Content-type");
//        System.out.println("Value of Connection type: " + connection);
        
      // Headers headerList = response.getHeaders();
        //for (Header header : headerList) {
          //  System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        //}
        Assert.assertEquals(contentType,"application/json; charset=utf-8");
    }
}
