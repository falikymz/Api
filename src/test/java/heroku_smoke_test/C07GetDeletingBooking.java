package heroku_smoke_test;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static heroku_smoke_test.C02CreateBooking.id;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C07GetDeletingBooking extends HerOkuAppBaseUrl {
        /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Send get request
    Then
        Status code is 404
    And
        Body is "Not Found"
     */

    @Test
    public void confirmDeleteTest() {
        //Url kurulur
        spec.pathParams("pp1","booking","pp2",id );

        //Beklenen data oluşturulur
        String expectedData="Not Found";

        //Request gönderilir Response alınır
        Response response =given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        String actualData = response.asString();
        assertEquals(404,response.statusCode());
        assertEquals(expectedData,actualData);

    }
}
