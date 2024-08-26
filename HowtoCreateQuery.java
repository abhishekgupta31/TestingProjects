package restAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class HowtoCreateQuery {
	@Test
	public void createUser() {
	
	
	JSONObject jsondata = new JSONObject();
	jsondata.put("name","abhishek");
	jsondata.put("job", "Developer");
	
	//https://reqres.in/api/users
	
		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://reqres.in").
		basePath("/api/users").contentType(ContentType.JSON).
		body(jsondata.toJSONString()).header("header1","headervalue");
		
		
		QueryableRequestSpecification queryrequest = SpecificationQuerier.query(reqspec);
		//get base URI
		String retriveBaseUri= queryrequest.getBaseUri();
		System.out.println("Base URI"+retriveBaseUri);
		//get base PATH
		String retriveBasepath= queryrequest.getBasePath();
		System.out.println("Base PATH"+retriveBasepath);
		//get request body 
		String retriveBody= queryrequest.getBody();
		System.out.println("Base Body"+retriveBody);
		
		//Get Headers retrieve
		Headers allHeaders=queryrequest.getHeaders();
		System.out.println("----Request HEader----");
		
		for(Header h:allHeaders) 
		{
			System.out.println("Headername"+h.getName()+"header value"+h.getValue());
			
		}
		
		
		
		
		
		
		
		
		
	}

}
