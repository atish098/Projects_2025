package API.Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class eCommerceApi {

	@Test
	public void loginApi() {

		String userID;
		String token;

		// RestAssured.baseURI("");

		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		loginRequest lp = new loginRequest();
		lp.setUserEmail("sumeet.c@gmail.com");
		lp.setUserPassword("Keka@1234");
		
		
		// Login 

		RequestSpecification req2 = RestAssured.given().spec(req).body(lp);

		loginResponse loginresponse = req2.when().post("/api/ecom/auth/login").then().log().all().extract().response()
				.as(loginResponse.class);

		System.out.println(loginresponse);

		userID = loginresponse.getUserid();
		token = loginresponse.getToken();
		
		// Add Product

		RequestSpecification req3 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();

		RequestSpecification req4 = given().spec(req3).param("productName", "2026").log().all()
				.param("productAddedBy", userID).param("productCategory", "Electronics")
				.param("productSubCategory", "TV").param("productPrice", "19000")
				.param("productDescription", "Full HD Smart Tv").param("productFor", "All")
				.multiPart("productImage", new File("C://Users//HP//Downloads//TV.png"));

		String addProductResponse = req4.when().post("/api/ecom/product/add-product").then().log().all().extract()
				.response().asString();

		System.out.println(addProductResponse);

		JsonPath js = new JsonPath(addProductResponse);
		String ProdID = js.get("productId");
		System.out.println(ProdID);
		
		order o=new order();
		o.setCountry("British Indian Ocean Territory");
		o.setProductOrderedId(ProdID);
		
		List <order> orderList = new ArrayList<order>();
		orderList.add(o);
		
		orderDetails orderdet=new orderDetails();
		orderdet.setOrders(orderList);
		
		// Create Order
		RequestSpecification req5=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addHeader("Authorization", token).build();
		
		RequestSpecification req6=given().spec(req5).log().all().body(orderdet);
		
	String checkResponse=	req6.when().post("/api/ecom/order/create-order").then().log().all().extract().response().toString();
	System.out.println(checkResponse);
		
		
		
		

//		String res=req2.when().post("").then().extract().response().toString();
//		
//		JsonPath js=new JsonPath(res);
//		
//	String message=	js.getString("message");
//	String userId=js.getString("userId");
//	System.out.println(res);
//	System.out.println(message);
//	System.out.println(userId);

	}

}
