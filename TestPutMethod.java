package restAssuredDemo;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPutMethod {
	@Test
	public void testcase3() 
	
	{
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("name", "Saif");
		jsonobject.put("job", "Executive");
		
		RestAssured.baseURI="https://reqres.in/api/users/511";
		RestAssured.given().header("Content-Type","application/json; charset=utf-8").
		contentType(ContentType.JSON).
		body(jsonobject.toJSONString()).
		when().put().then().statusCode(200).log().all();
		
		
		
	}

}
