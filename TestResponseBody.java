package restAssuredDemo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class TestResponseBody {
	@Test
	public void TestResponceBody() 
	{
		RequestSpecification reqspec = RestAssured.given();	
		reqspec.baseUri("https://reqres.in/");
		reqspec.basePath("/api/users?page=2");
		Response res= reqspec.get();
		ResponseBody responsebody = res.getBody();
//		String stringresponse= responsebody.asString();
//		System.out.println("responce body"+stringresponse);
//		Assert.assertEquals(stringresponse.contains("George"),true,"check of presence of George");;
		JsonPath jsonpathview=	responsebody.jsonPath();
		String jsonString =jsonpathview.get("data[0].first_name");
		Assert.assertEquals(jsonString,"George","check presence of George ");
	}
}
