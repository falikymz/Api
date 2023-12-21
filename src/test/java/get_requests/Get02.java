package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class Get02 {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/0
       When
           User send a GET Request to the url
       Then
           HTTP Status code should be 404
       And
           Status Line should be HTTP/1.1 404 Not Found
       And
           Response body contains "Not Found"
       And
           Response body does not contain "TechProEd"
       And
           Server is "Cowboy"
 */

    @Test
    public void get(){
        // i) Url kurulacak
        String url = "https://restful-booker.herokuapp.com/booking/0";

        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak
        Response response = given()
                .when()
                .get(url);
        response.prettyPrint();
        // iv) Doğrulamalar yapılacak

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Not Found"))
                .body(not(containsString("TechProEd")));


        String responseStr = response.asString();
        assertTrue(responseStr.contains("Not Found"));
        assertFalse(responseStr.contains("TechProEd"));

        String server = response.header("Server");
        assertEquals("Cowboy",server);
    }

}