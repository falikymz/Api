package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){
        String credential="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        Response response =given().
                body(credential).
                contentType(ContentType.JSON).
                when().
                post("https://restful-booker.herokuapp.com/auth");
      return   response.jsonPath().getString("token");
    }

}
