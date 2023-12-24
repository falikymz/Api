package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {
/*
       Given
         1) https://jsonplaceholder.typicode.com/todos
         2)  {
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
        //url hazırlanır
        spec.pathParam("pp1","todos");

        //beklenen datayı oluştur:
        String payLoad="{\n" +
                "\"userId\": 55,\n" +
                "\"title\": \"Tidy your room\",\n" +
                "\"completed\": false\n" +
                " }";
        //Request gönderip response alınır
        Response response =given(spec).body(payLoad).when().post("{pp1}");
        response.prettyPrint();

        //Doğrulamalar yapılır
        JsonPath json =response.jsonPath();
        response.then()
                .statusCode(201);
        assertEquals(55,json.getInt("userId"));
        assertEquals("Tidy your room",json.getString("title"));
        assertEquals(false,json.getBoolean("completed"));
    }

    @Test
    public void postMap() {
        //Url Oluştur
        spec.pathParam("pp1","todos");

        //Beklenen data oluşturma
        Map<String, Object> payLoad=new HashMap<>();
        payLoad.put("userId",55);
        payLoad.put("title","Tidy your room");
        payLoad.put("completed",false);
        System.out.println(payLoad);

        //Request gönder response al
        Response response =given(spec).body(payLoad).when().post("{pp1}");
        response.prettyPrint();
        /*  IllegalStateException Jackson (Databind), Gson, Johnzon, or Yasson in the classpath
        body(payLoad) içinde ki dataları dönüştüremediği için hata veriyorsa (bize söylediği dependecyler eklenir);
        Serialization : Java objesini Json Objesine dönüştüme işlemine denir
         */

        //Doğrulamalar yapılır
        Map<String,Object>actualData =response.as(HashMap.class);
        System.out.println(actualData);
       assertEquals(201,response.statusCode());
       assertEquals(payLoad.get("userId"),actualData.get("userId"));
       assertEquals(payLoad.get("title"),actualData.get("title"));
       assertEquals(payLoad.get("completed"),actualData.get("completed"));

    }
}
