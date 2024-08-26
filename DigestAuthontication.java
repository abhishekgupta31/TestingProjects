package restAssuredDemo;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuthontication {
	@Test
	public void digestauth() 
	{
		
		//https://httpbin.org/digest-auth/undefined/abhi/abhi
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://httpbin.org");
		reqspec.basePath("/digest-auth/undefined/abhi/abhi");
		
		
		Response response=reqspec.auth().digest("abhi", "abhi").get();
		Assert.assertEquals(response.statusCode(),200);
		response.getStatusLine();
		response.body().asString();
		
	}

}
