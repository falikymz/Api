package homeworks;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Task02 extends JsonPlaceHolderBaseUrl {
        /*Task 2:
    Given URL:
    https://jsonplaceholder.typicode.com/users/3
    Test Scenario:
    The user sends a GET request to the above URL.
    The HTTP status code should be 200.
    The response should be in "application/json" format.
    The value of the "name" field should be "Clementine Bauch."
    The value of the "username" field should be "Samantha."
    The value of the "email" field should be "Nathan@yesenia.net."
    The value of the "address" field under "suite" should be "Apt. 556."

     */

    @Test
    public void get() {

      // i) Url kurulacak
        spec.pathParams("pp1","users","pp2",3);

      // ii)Beklenen data belirlenecek

      // İİİ)Request gönderilip Response alınacak
        Response response =given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();
      // iv) Doğrulamalar yapılacak
        JsonPath json =response.jsonPath();
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        assertEquals("Clementine Bauch",json.getString("name"));
        assertEquals("Samantha",json.getString("username"));
        assertEquals("Nathan@yesenia.net",json.getString("email"));
        assertEquals("Apt. 556",json.getString("address.suite"));

    }
}
