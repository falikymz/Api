package homeworks;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.JsonPlaceHolderTestData;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static test_data.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class Task03 extends JsonPlaceHolderBaseUrl {
    /*
        Task 3:
    Given URL:
    https://jsonplaceholder.typicode.com/comments?postId=5
    Test Scenario:
    The user sends a GET request to the above URL.
    The HTTP status code should be 200.
    The response should be in "application/json" format.
    There should be at least 3 comments in the response.
    The value of the "email" field for the first comment should be "Lucio_Hettinger@annie.ca."
    The value of the "body" field for the second comment should contain "ipsa repellendus fugit nisi."
    The value of the "postId" field for the third comment should be 5.
    These tasks focus on testing specific endpoints or resources to verify the expected behaviors of the RESTful API.
     */

    @Test
    public void get() {
      //  i) Url kurulacak
        spec.pathParam("pp1","comments").queryParam("postId","5");
      //  ii)Beklenen data belirlenecek

      //  İİİ)Request gönderilip Response alınacak
            Response response = given(spec).when().get("{pp1}");

      //  iv) Doğrulamalar yapılacak
        SoftAssert softAssert = new SoftAssert();
            JsonPath json = response.jsonPath();
            response.then()
                    .statusCode(200)
                    .contentType(ContentType.JSON);
        softAssert.assertTrue(json.getList("findAll{it}").size()>3);
        softAssert.assertEquals("Lucio_Hettinger@annie.ca",json.getString("[0].email"),"email actualdata dont match expected data ");
        softAssert.assertTrue(json.getString("[1].body").contains("ipsa repellendus fugit nisi"));
        softAssert.assertEquals(5,json.getString("[2].postId"));
        softAssert.assertAll();
    }
}
