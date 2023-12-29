package heroku_smoke_test;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;


import static heroku_smoke_test.C02CreateBooking.id;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C03FindBooking extends HerOkuAppBaseUrl {
  /*
        Given
            https://restful-booker.herokuapp.com/booking/700
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
 	{
    "firstname": "Ali",
    "lastname": "Can",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "kahvalti"
}
     */
    @Test
    public void getBooking() {
        //url kurulur
        spec.pathParams("pp1","booking","pp2",id);

        //Beklenen data oluşturulur
        BookingDatesPojo dates = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo payLoad = new BookingPojo("Ali","Can",111,true,dates,"kahvalti");

       // Request gönderilir Response alınır
        Response response = given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //Doğrulamalar yapılır
        BookingPojo actualData =response.as(BookingPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getFirstname(),actualData.getFirstname());
        assertEquals(payLoad.getLastname(),actualData.getLastname());
        assertEquals(payLoad.getTotalprice(),actualData.getTotalprice());
        assertEquals(payLoad.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(dates.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(dates.getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(payLoad.getAdditionalneeds(),actualData.getAdditionalneeds());

    }
}
