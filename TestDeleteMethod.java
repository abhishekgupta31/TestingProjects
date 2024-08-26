package restAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestDeleteMethod {
	
	@Test
	public void testcase5()
	
	{
	RestAssured.baseURI="https://reqres.in/api/users/511"	;
	RestAssured.given().when().delete().then().log().all().statusCode(204);
	
		
	}
}
