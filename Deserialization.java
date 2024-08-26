package restAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Deserialization {
	@Test
	public void DeserializationTest() 
	{
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://reqres.in/");
		reqspec.basePath("/api/users");
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("name", "abhishek");
		jsonobj.put("job", "QA");
//		jsonobj.put("id", "313131");
//		jsonobj.put("createdAt", "null");
		
		//perform post request
		
		Response responce=reqspec.contentType(ContentType.JSON).
		body(jsonobj.toJSONString()).post();
		ResponseBody responsebody =  responce.getBody();
		
//      deserialize responsebody(JSON body to class)
		
		JSONPostRequestResponse responseClass = responsebody.as(JSONPostRequestResponse.class);
		Assert.assertEquals(responseClass.name,"check for name");
//		Assert.assertEquals(responseClass.job,"check for job");
		
		
		
		
	}
	
	
	

}
