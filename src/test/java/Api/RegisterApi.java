package Api;

import static io.restassured.RestAssured.given;

import java.util.List;

import Object.User;
import Utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class RegisterApi {
	
	private static List<Cookie> restAssuredCookies;
	private static String accesToken;
	private static String UserId;
	private static String firstName;
	
	public String GetToken() {
		return this.accesToken;
		
	}
	public List<Cookie> GetCookies() {
		return this.restAssuredCookies;
		
	}
	public String GetUserId() {
		return this.UserId;
		
	}
	public String GetfirstName() {
		return this.firstName;
		
	}
	
	
	
	
	
	public static void Register() {
		
		
		User user =  UserUtils.GeneretNewRandom();


		Response response= given()
		    .baseUri("https://qacart-todo.herokuapp.com/")
		    .header("Content-Type", "application/json")
		    .log().all()
		    .body(user)
		.when()
		    .post("/api/v1/users/register")
		.then()
		    .log()
		    .all()
		    .extract().response();
	restAssuredCookies = response.detailedCookies().asList();
	 accesToken = response.path("access_token");
	 UserId= response.path("userID");
	 firstName=response.path("firstName");
	
	
	if(response.statusCode()!=201) {
		
		throw new RuntimeException("very bad request");
	}
	
	
	
	}
	



	





	
	
	
	


}
