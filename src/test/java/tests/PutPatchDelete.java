package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutPatchDelete {
	@Test
	public void Put()
	{
		JSONObject json = new JSONObject();
		
		json.put("Kumari K", "LName");
		json.put("Ruchi", "FName");
	
		baseURI="https://reqres.in/api";
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(json.toJSONString()).
		when().
		 put("/users/2").
		then().
		 statusCode(200).log().all();
		
	}
	@Test
	public void Patch()
	{
		JSONObject json = new JSONObject();
		json.put("FName", "Ruchi");
		json.put("Job", "QA");
		
		baseURI ="https://reqres.in/";
			given().
				contentType(ContentType.JSON).accept(ContentType.JSON).
				body(json.toJSONString()).
				when().
					patch("/api/users/2").
					then().
				    statusCode(200).log().all();
	}

}
