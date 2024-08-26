package restAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestValidResponceCoode {
	@Test
	public void validResponceCode() 
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";
		//Get Request Specification of the request
		RequestSpecification spec=RestAssured.given();
		//call get method
		Response res = spec.get();
		//get response code
		int statuscode =res.getStatusCode();
		//validate actual status code
		Assert.assertEquals(statuscode, 200,"correct status code recvd");
		
		String statusLine = res.getStatusLine();
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK","incorrect status line" );
	}

}
