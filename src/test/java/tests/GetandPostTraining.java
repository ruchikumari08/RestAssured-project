package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//import java.util.HashMap;
//import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


@Test
public class GetandPostTraining {
	
	public void tests()
{
	baseURI="https://reqres.in/api";
	given().get("/users?page=2").then().statusCode(200).body("data[2].first_name",equalTo("Tobias"))
	.body("data.first_name",hasItems("Tobias","Lindsay"));
			                                          
}
	@Test
	public void test_post()
	{
		
		//using map  for learning
		/*
		 * Map<String,Object> map = new HashMap<String,Object>();
		 * map.put("Name","Ruchi"); map.put("Name", "Rahul"); 
		 * //Ctrl+spacebar for Syso= System.out.println
		 *  System.out.println(map);
		 */
				
	//Using Json
				//Ctrl+space=tells which to import
				JSONObject req = new JSONObject();
				req.put("Job", "Tester");
				req.put("Name", "Ruchi");
				
				System.out.println(req +"only request");
				System.out.println(req.toJSONString());
				
				
		//another way
				baseURI="https://reqres.in/api";
				given().
				header("Content-Type","application/json"). //or
				contentType(ContentType.JSON).accept(ContentType.JSON).
				body(req.toJSONString()).
				 when().
				  post("/users").
				  then().statusCode(201).
				  log().all();
	}
	
	
}
