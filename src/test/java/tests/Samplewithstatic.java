package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Samplewithstatic {
	@Test
	public void Test_2()
	{
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		 statusCode(200).
		body("data[1].id",equalTo(8)).log().all();
		
	}

}
