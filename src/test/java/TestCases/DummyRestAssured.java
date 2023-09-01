package TestCases;

import static io.restassured.RestAssured.given;

import Object.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DummyRestAssured {

	public static void main(String[] args) {
		

User user = new User("Saif Allah", "Dakhlaoui", "testk17@gmail.com","23775449");



Response Response= given()
    .baseUri("https://qacart-todo.herokuapp.com/")
    .header("Content-Type", "application/json")
    .body(user).log().all()
.when()
    .post("/api/v1/users/register")
.then()
.extract().response();

//String accessToken= Response.path("access_token");
String UserId = Response.path("userID");


//System.out.println(accessToken);
System.out.println(UserId);

//if(accessToken== null) {
	throw new RuntimeException("access token is not found");
}
		

	}

//}
