package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class Get11_NestedMap extends HerOkuAppBaseUrl {
       /*
        Given
            https://restful-booker.herokuapp.com/booking/51
        When
            I send GET Request to the url
        Then
            Response body should be like that;
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
     */

    @Test
    public void get() {
       // i) Url kurulacak
        spec.pathParams("pp1","booking","pp2",453);

       // ii)Beklenen data belirlenecek
       //Nested yapılarda beklenen data oluşturulurken en iç yapıdan başlanır.

        Map<String,String>bookingDateMap=new HashMap<>();
        bookingDateMap.put("checkin","2018-01-01");
        bookingDateMap.put("checkout","2019-01-01");
        System.out.println("bookingDateMap = " + bookingDateMap);

        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDateMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println("expectedData = " + expectedData);
       // İİİ)Request gönderilip Response alınacak
        Response response = given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();

       // iv) Doğrulamalar yapılacak
     //  response.then()
     //          .statusCode(200)
     //          .body("firstname",equalTo(expectedData.get("firstname")),
     //                  "lastname",equalTo(expectedData.get("lastname")),
     //                  "totalprice",equalTo(expectedData.get("totalprice")),
     //                  "depositpaid",is(expectedData.get("depositpaid")),
     //                  "bookingdates.checkin",is(expectedData.get("checkin")),
     //                  "bookingdates.checkout",is(expectedData.get("checkout")),
     //                  "additionalneeds",is(expectedData.get("additionalneeds")));


        Map<String,Object> actualData=response.as(Map.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDateMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
      //  assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }

    @Test
    public void getb() {
        // i) Url kurulacak
        spec.pathParams("pp1","booking","pp2",698);

        // ii)Beklenen data belirlenecek
        //Nested yapılarda beklenen data oluşturulurken en iç yapıdan başlanır.
        Map<String,String> bookingDateMap =HerOkuAppTestData.bookingDatesMapper("2018-01-01","2019-01-01");
        System.out.println("bookingDateMap = " + bookingDateMap);
        Map<String,Object> expectedData =HerOkuAppTestData.herokuAppMapper("John",
                                                                            "Smith",
                                                                            111,
                                                                            true,
                                                                             bookingDateMap,
                                                                            "Breakfast");

        // İİİ)Request gönderilip Response alınacak
        Response response = given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak
        //  response.then()
        //          .statusCode(200)
        //          .body("firstname",equalTo(expectedData.get("firstname")),
        //                  "lastname",equalTo(expectedData.get("lastname")),
        //                  "totalprice",equalTo(expectedData.get("totalprice")),
        //                  "depositpaid",is(expectedData.get("depositpaid")),
        //                  "bookingdates.checkin",is(expectedData.get("checkin")),
        //                  "bookingdates.checkout",is(expectedData.get("checkout")),
        //                  "additionalneeds",is(expectedData.get("additionalneeds")));


        Map<String,Object> actualData=response.as(Map.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDateMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        //  assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }




}
