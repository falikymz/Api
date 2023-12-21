package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends JsonPlaceHolderBaseUrl {

 /*
        Given
            https://jsonplaceholder.typicode.com/todos
        And
	        Accept type is "application/json"
        When
	 	    I send a GET request to the Url
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void name() {
        // i) Url kurulacak
        int expectedSize=200;
        spec.pathParam("first","todos").accept(ContentType.JSON);

        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
              //  .body("[2].title",equalTo("fugiat veniam minus"));-->Json listi olarak dönen bir yapıda herhangi bir elemente index kullanarak ulaşabiliriz
              // hasSize() method list dönen yapının boyutunu ölçer.
              // hasItem() method listte verilen değerin var olup olmadığını kontrol eder
              // hasItems() method listter verilern değerlerin var olup olmadığını kontrol eder
                .body("title",hasSize(expectedSize),"title",hasItem("quis eius est sint explicabo"),"userId",hasItems(2,7,9));
    }
}
