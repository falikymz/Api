package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04_Pojo extends JsonPlaceHolderBaseUrl {

   /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post() {

        //  i) Url kurulacak
        spec.pathParam("pp1","todos");


        // ii)Beklenen data belirlenecek
        JsonPlaceHolderPojo payLoad= new JsonPlaceHolderPojo(10,"Tidy your room",false);
        System.out.println("payLoad.getTitle() = " + payLoad.getTitle());
        System.out.println("payLoad.getUserId() = " + payLoad.getUserId());

        // İİİ)Request gönderilip Response alınacak
        Response response = given(spec).body(payLoad).when().post("{pp1}");
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak
        JsonPlaceHolderPojo actualData =response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(payLoad.getUserId(),actualData.getUserId());
        assertEquals(payLoad.getTitle(),actualData.getTitle());
        assertEquals(payLoad.getCompleted(),actualData.getCompleted());




    }
}
