package heroku_smoke_test;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static heroku_smoke_test.C02CreateBooking.id;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06DeleteBooking extends HerOkuAppBaseUrl {
 /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Send delete request
    Then
        Status code is 201
    And
        Body should be : "Created"
     */


    @Test
    public void deleteBookingTest() {
        // url kurulur
        spec.pathParams("pp1","booking","pp2",id);

        //Beklenen data oluşturulur
        String expectedData="Created";
        //Request gönderilir response alınır
        Response response =given(spec).when().delete("{pp1}/{pp2}");
        response.prettyPrint();

        String actualData =response.asString();
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,actualData);







    }
}
