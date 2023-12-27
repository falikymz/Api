package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class Patch01 extends JsonPlaceHolderBaseUrl {
    /*
        /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198

     */

    @Test
    public void patch() {

     //  i) Url kurulacak
        spec.pathParams("pp1","todos","pp2",198);


     //  ii)Beklenen data belirlenecek
       Map<String,Object>payLoad =jsonPlaceHolderMapper(null,"Wash the dishes",null);
        payLoad.put("userId",10);
        payLoad.put("completed",true);


     //  İİİ)Request gönderilip Response alınacak
        Response response=given(spec).body(payLoad).when().patch("{pp1}/{pp2}");
        response.prettyPrint();

     //  iv) Doğrulamalar yapılacak
        Map<String,Object>actualData=response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));

    }
}
