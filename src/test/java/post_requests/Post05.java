package post_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.HerokuAppPojo;
import pojos.HerokuRootPojo;

import static io.restassured.RestAssured.given;

public class Post05 extends HerOkuAppBaseUrl {

           /*
         Given
          1)  https://restful-booker.herokuapp.com/booking
          2)   {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        },
                                        "additionalneeds": "Breakfast"
                                     }
                                  }
     */

    @Test
    public void post() {
        spec.pathParam("pp1","booking");

        BookingPojo bookingDates =new BookingPojo("2021-09-21","2021-12-21");
        HerokuAppPojo payLoad =new HerokuAppPojo("Ali","Can",999,true,bookingDates,"Breakfast");

        Response response = given(spec).body(payLoad).when().post("{pp1}");
        response.prettyPrint();

        HerokuRootPojo actualData =response.as(HerokuRootPojo.class);
        System.out.println("actualData.getBookingid() = " + actualData.getBookingid());

    }
}
