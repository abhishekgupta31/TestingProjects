package restAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPatchMethod {
	@Test
	public void testcase4()
	
	{
		JSONObject jsonobject= new JSONObject();
		jsonobject.put("name","dhrendra");
		jsonobject.put("job","tester");
		
		RestAssured.baseURI="https://reqres.in/api/users/511";
		RestAssured.given().header("Content-Type","application/json; charset=utf-8").
		contentType(ContentType.JSON).
		body(jsonobject.toJSONString()).
		when().patch().then().log().all();
		
	}

}
