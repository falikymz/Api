package heroku_smoke_test;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C01CreateToken extends HerOkuAppBaseUrl {
    /*

    Test Case : Token Oluşturma
     Given
      https://restful-booker.herokuapp.com/auth
     And
     {
     "username":"admin"
     "password":"password123"
     }
     When
        user send post request
     Then
        Validates Status code is 200

    */

    @Test
    public void name() {
        String url="https://restful-booker.herokuapp.com/auth";

        Map<String,Object>payLoad=new HashMap<>();
        payLoad.put("username","admin");
        payLoad.put("password","password123");

        Response response = given().body(payLoad).contentType(ContentType.JSON).when().post(url);
        assertEquals(200,response.statusCode());
    }

    public static String createToken() {
        String url="https://restful-booker.herokuapp.com/auth";

        Map<String,Object>payLoad=new HashMap<>();
        payLoad.put("username","admin");
        payLoad.put("password","password123");

        Response response = given().body(payLoad).contentType(ContentType.JSON).when().post(url);
        JsonPath json =response.jsonPath();
        String token = json.getString("token");
        return token;
    }

}
