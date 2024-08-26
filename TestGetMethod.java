package restAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.asserts.*;

public class TestGetMethod {
	@Test
	public void testcase1() 

	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code is: " +res.getStatusCode());
		System.out.println("Response Body is: " +res.getBody().asString());
		System.out.println("Response Time is: " +res.getTime());
		System.out.println("Response Header is: " +res.getHeader("Transfer-Encoding"));
		
		int Expectedresult = 200;
		int Actualresult = res.getStatusCode();
		Assert.assertEquals(Expectedresult, Actualresult);
	}
		@Test
		public void testcase2()
		
		{
			RestAssured.baseURI="https://reqres.in/api/users?page";
			RestAssured.given().when().get().then().statusCode(200);
				
		}
		
	
}
