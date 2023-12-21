package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get07 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
                        {
                            "firstname": "John",
                            "lastname": "Smith",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }
     */


    @Test
    public void get() {

      // i) Url kurulacak
        spec.pathParams("pp1","booking","pp2","11");

      // ii)Beklenen data belirlenecek
      // İİİ)Request gönderilip Response alınacak
        Response response = given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();
      // iv) Doğrulamalar yapılacak
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",is(111),
                        "depositpaid",is(true),
                        "bookingdates.checkin",is("2018-01-01"),
                        "bookingdates.checkout",is("2019-01-01"),
                        "additionalneeds",containsString("Breakfast"));
    }
}
