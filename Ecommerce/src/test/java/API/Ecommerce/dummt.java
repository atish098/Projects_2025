package API.Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class dummt {
	
	@Test
	public void loginApi() {

		// RestAssured.baseURI("");
		
		
		

		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		loginRequest lp=new loginRequest();
		lp.setUserEmail("sumeet.c@gmail.com");
		lp.setUserPassword("Keka@1234");
	

		RequestSpecification req2=RestAssured.given().spec(req).body(lp);
		
		loginResponse loginresponse=req2.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(loginResponse.class);
		
		
	String Token=	loginresponse.getToken();
	String Message=	loginresponse.getMessage();
		
		System.out.println(Token);
		System.out.println(Message);
		

}
}