package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GmiBankAuthentication {

    public static String generateToken(){
        String credentials="{\n" +
                "  \"password\": \"Mark.123\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"mark_twain\"\n" +
                "}";
        Response response = given().
                body(credentials).
                contentType(ContentType.JSON).
                when().
                post("https://gmibank.com/api/authenticate");
        return response.jsonPath().getString("id_token");
    }
}
