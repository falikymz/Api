package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class Get07_JsonPath extends HerOkuAppBaseUrl {
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
                body("firstname",equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                        "totalprice",is(111),
                        "depositpaid",is(true),
                        "bookingdates.checkin",is("2018-01-01"),
                        "bookingdates.checkout",is("2019-01-01"),
                        "additionalneeds",containsString("midnight snack"));

       //JsonPath response data çeşidini Java da tanımlanan bir data çeşidine çevirip,body içerisindeki
       //istenilen dataya erişebilmemizi sağlar(o datayı kaydedip kullanabilmeyi de sağlar)

    //  JsonPath json=response.jsonPath();
    //  assertEquals(200,response.statusCode());
    //  assertEquals("application/json; charset=utf-8",response.contentType());
    //  assertEquals("Josh",json.getString("firstname"));
    //  assertEquals("Allen",json.getString("lastname"));
    //  assertEquals(111,json.getInt("totalprice"));
    //  assertEquals(true,json.getBoolean("depositpaid"));
    //  assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
    //  assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
    //  assertEquals("midnight snack",json.getString("additionalneeds"));


        System.out.println(response.jsonPath().getString("firstname"));
        System.out.println(response.jsonPath().getInt("totalprice"));
        System.out.println(response.jsonPath().getString("booking.checkin"));

        //2.Yol
        JsonPath json=response.jsonPath();
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("midnight snack",json.getString("additionalneeds"));

        //3.Yol SoftAssertion (TestNg dependecy indirmemiz lazım)
        // Soft Assertion 3 adımda yapılır :
        //1.adım:Soft Assertion object oluşturulur
        //2.adım:Assertionlar bu obje ille yapılır
        //3.adım:assertAll ile assertionlar bitirilir




    }
}
