package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Sample {
	
	@Test
	public void Test()
	{
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().toString());
		System.out.println(res.getHeader("content-type"));
		
		int StatusCode=res.getStatusCode();
		Assert.assertEquals(StatusCode, 200);
	}

	
}
