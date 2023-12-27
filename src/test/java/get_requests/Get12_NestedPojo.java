package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingPojo;
import pojos.HerokuAppPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12_NestedPojo extends HerOkuAppBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/535
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
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
        //url kurulur
        spec.pathParams("pp1","booking","pp2","837");

        //Beklenen data oluşturulur
        BookingPojo bookings=new BookingPojo("2018-01-01","2019-01-01");
        HerokuAppPojo expectedData= new HerokuAppPojo("John","Smith",111,true,bookings,"Breakfast");

        //Request gönderilir response alınır
        Response response =given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //doğrulamalar yapılır
        HerokuAppPojo actualData =response.as(HerokuAppPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookings.getCheckout(),bookings.getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());





    }
}
