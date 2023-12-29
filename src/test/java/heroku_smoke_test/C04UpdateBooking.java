package heroku_smoke_test;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.HerokuRootPojo;

import static heroku_smoke_test.C02CreateBooking.id;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C04UpdateBooking extends HerOkuAppBaseUrl {


    @Test
    public void updateBookingTest() {
    spec.pathParams("pp1","booking","pp2",id);

        BookingDatesPojo bookingDates=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo payLoad=new BookingPojo("Peter","Parker",999,true,bookingDates,"kahve");

        // Request gönderilir response alınır
        Response response =given(spec).body(payLoad).when().put("{pp1}/{pp2}");
        response.prettyPrint();

        //Doğrulamalar yapılır
        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.getFirstname(),actualData.getFirstname());
        assertEquals(payLoad.getLastname(),actualData.getLastname());
        assertEquals(payLoad.getTotalprice(),actualData.getTotalprice());
        assertEquals(payLoad.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(),actualData.getBookingdates().getCheckout());

    }
}
