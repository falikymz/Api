package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class Get06_QueryParams extends HerOkuAppBaseUrl {

     /*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL
       Then
           Status code is 200
       And
           Among the data there should be someone whose firstname is "John" and lastname is "Smith"
    */

    @Test
    public void name() {
        // i) Url kurulacak

        spec.pathParam("pp1","booking").queryParams("firstname","John","lastname","Smith");

        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak

        Response response = given(spec).when().get("{pp1}");
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak

        //1.yol
        response.
                then().
                statusCode(200).
                body("bookingid",hasSize(greaterThan(0))).
                body(containsString("bookingid"));




        //2.yol
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
