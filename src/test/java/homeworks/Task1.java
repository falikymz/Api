package homeworks;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Task1 extends JsonPlaceHolderBaseUrl {
            /*
            Task 1:
        Given URL:
        https://jsonplaceholder.typicode.com/posts/5

        Test Scenario:

        The user sends a GET request to the above URL.
        The HTTP status code should be 200.
        The response should be in "application/json" format.
        The value of the "title" field should be "nesciunt quas odio."
        The value of the "userId" field should be 1.
        The value of the "body" field should be "repudiandae veniam quaerat sunt sed."

        */

    @Test
    public void get() {
        //i) Url kurulacak
        spec.pathParams("pp1","posts","pp2",5);

        //ii)Beklenen data belirlenecek


        //İİİ)Request gönderilip Response alınacak
        Response response= given(spec).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //iv) Doğrulamalar yapılacak
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("nesciunt quas odio")
                ,"userId",is(1),
                  "body",containsString("repudiandae veniam quaerat sunt sed"));
    }
}
