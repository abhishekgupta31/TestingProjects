package restAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAuthorization {
	@Test
	public void Basicauthorization() 
	{
		RequestSpecification resp = RestAssured.given();
		resp.baseUri("https://postman-echo.com/");
		resp.basePath("/basic-auth");
		//NonPremtive 
		//Response response=resp.auth().basic("postman", "password").get();
		//System.out.println("responce Non pre emptive" +response.statusLine());
		//Premmtive
		Response response=resp.auth().preemptive().basic("postman", "password").get();
		System.out.println("responce Pre emptive" +response.statusLine());
		
		
	}

}
