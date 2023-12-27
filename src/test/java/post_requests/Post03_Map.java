package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.HerOkuAppTestData.bookingDatesMapper;
import static test_data.HerOkuAppTestData.herokuAppMapper;

public class Post03_Map extends HerOkuAppBaseUrl {
        /*
Given
1) https://restful-booker.herokuapp.com/booking
2) {
    "firstname": "John",
    "lastname": "Doe",
    "totalprice": 11111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2021-09-09",
        "checkout": "2021-09-21"
     }
  }
When
I send POST Request to the Url
Then
Status code is 200
And response body should be like {
                                   "bookingid": 5315,
                                   "booking": {
                                       "firstname": "John",
                                       "lastname": "Doe",
                                       "totalprice": 11111,
                                       "depositpaid": true,
                                       "bookingdates": {
                                           "checkin": "2021-09-09",
                                           "checkout": "2021-09-21"
                                       }
                                   }
                                }
*/

    @Test
    public void post() {
       //i) Url kurulacak
        spec.pathParam("pp1","booking");

       //ii)Beklenen data belirlenecek
        Map<String,String>bookings=bookingDatesMapper("2021-09-09","2021-09-21");
        Map<String,Object>payLoad=herokuAppMapper(
                "John", "Doe", 1111, true, bookings, null);
        System.out.println("payLoad = " + payLoad);


        //İİİ)Request gönderilip Response alınacak
        Response response=given(spec).body(payLoad).when().post("{pp1}");
        response.prettyPrint();


       //iv) Doğrulamalar yapılacak
         JsonPath json=response.jsonPath();
        Map<String,Object>actualData =response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("firstname"),json.getString("booking.firstname"));
        assertEquals(payLoad.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
        assertEquals(payLoad.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
        assertEquals(payLoad.get("totalprice"),((Map)actualData.get("booking")).get("totalprice"));
        assertEquals(payLoad.get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(bookings.get("checkin"),(((Map)((Map)actualData.get("booking")).get("depositpaid"))).get("checkin"));
        assertEquals(bookings.get("checkout"),(((Map)((Map)actualData.get("booking")).get("depositpaid"))).get("checkout"));
        



    }
}
