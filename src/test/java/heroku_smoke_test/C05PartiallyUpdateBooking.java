package heroku_smoke_test;

import base_urls.HerOkuAppBaseUrl;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import test_data.HerOkuAppTestData;

import java.util.Map;

import static heroku_smoke_test.C02CreateBooking.id;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C05PartiallyUpdateBooking extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
    "firstname" : "Naz",
    "lastname" : "Canan",
    "additionalneeds" : "Çay"
}
    When
        Send  patch request
    Then
        Status code is 200
    And
       Body:
{
    "firstname": "Naz",
    "lastname": "Canan",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Çay"
}
     */
    @Test
    public  void partiallyUpdateTest() {

        spec.pathParams("first", "booking"
                , "second", id);

        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Naz", "Canan", 999, true, bookingDates, "Çay");

        Map<String, Object> payLoad = HerOkuAppTestData.herokuAppMapper("Naz", "Canan", null, null
                , null, "Çay");

        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData = response.as(BookingPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDates.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());
    }
}