package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get09_GroovyLang extends JsonPlaceHolderBaseUrl {
    /*
      Given
             https://jsonplaceholder.typicode.com/todos
      When
           I send GET Request to the URL
      Then
           1)Status code is 200
           2)Print all ids greater than 190 on the console
             Assert that there are 10 ids greater than 190
           3)Print all userIds whose ids are less than 5 on the console
             Assert that the number of userIds whose ids are less than 5 is 4
           4)Print all titles whose ids are less than 5
             Assert that "delectus aut autem" is one of the titles whose id is less than 5
   */

    @Test
    public void get() {

      // i) Url kurulacak
        spec.pathParam("pp1","todos");

      // ii)Beklenen data belirlenecek


      // İİİ)Request gönderilip Response alınacak
       Response response =given(spec).when().get("{pp1}");


      // iv) Doğrulamalar yapılacak
        JsonPath json =response.jsonPath();
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        // 2)Print all ids greater than 190 on the console
        //Assert that there are 10 ids greater than 190
        int count=0;
        List<Integer> idList=json.getList("id");
        List<Integer> idsGreaterThan190=new ArrayList<>();

        for (Integer w:idList){
            if (w>190){
               idsGreaterThan190.add(w);
            }
        }
        System.out.println(idsGreaterThan190);
        assertEquals(10,idsGreaterThan190.size());

        //2.YOL Groovy language , koleksiyonlarda şartlı sorgular ile uğraşıyorsak Groovy L. çok kullanışlıdır.

        List<Integer>idsGreater=json.getList("findAll{it.id>190}.id");
        System.out.println(idsGreater);
        assertEquals(10,idsGreater.size());

        //findAll{} tamamında ara it=item keyword logical operators
        //Syntax ==> findAll{it.id>190}.id
        //Syntax ==> findAll{it.title=='quo laboriosam deleniti aut qui'}. -->tüm bilgiyi getir filtreye göre

        //3-Print all userIds whose ids are less than 5 on the console
        List<Integer> idLessThanFive=json.getList("findAll{it.id<5}.userId");
        System.out.println(idLessThanFive);

      // 3-Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4,idLessThanFive.size());


        //4)Print all titles whose ids are less than 5
        List<String> titlesLessThanFive =json.getList("findAll{it.id<5}.title");
        System.out.println(titlesLessThanFive);
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titlesLessThanFive.contains("delectus aut autem"));


    }
}
