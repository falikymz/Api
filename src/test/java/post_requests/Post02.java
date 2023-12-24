package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.JsonPlaceHolderTestData.jsonPlaceHolderMapper;

public class Post02 extends JsonPlaceHolderBaseUrl {

    @Test
    public void postMap() {
        //Post01 deki task map oluşturmayı method içinde hallederek geliştirildi
        //Url Oluştur
        spec.pathParam("pp1","todos");

        //Beklenen data oluşturma
        Map<String,Object>payLoad=jsonPlaceHolderMapper(55,"Tidy your room",false);

        //Request gönder response al
        Response response =given(spec).body(payLoad).when().post("{pp1}");
        response.prettyPrint();
        /*  IllegalStateException Jackson (Databind), Gson, Johnzon, or Yasson in the classpath
        body(payLoad) içinde ki dataları dönüştüremediği için hata veriyorsa (bize söylediği dependecyler eklenir);
        Serialization : Java objesini Json Objesine dönüştüme işlemine denir
         */

        //Doğrulamalar yapılır
        Map<String,Object>actualData =response.as(HashMap.class);
        System.out.println(actualData);//Desirialization:Json objesini Java objesine dönüştürme
        assertEquals(201,response.statusCode());
        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));
    }

}
