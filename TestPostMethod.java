package restAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class TestPostMethod {
	@Test
	public void testcase2()
	{
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("name","Apurv");
		jsonobject.put("job","Student");
		
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-Type","application/json; charset=utf-8").
		contentType(ContentType.JSON).
		body(jsonobject.toJSONString()).
		when().post().
		then().statusCode(201).log().all();
	}

}
