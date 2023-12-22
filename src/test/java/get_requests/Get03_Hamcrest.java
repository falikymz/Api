package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Get03_Hamcrest {

    /*
            Given
                https://jsonplaceholder.typicode.com/todos/23
            When
                User send GET Request to the URL
            Then
                HTTP Status Code should be 200
            And
                Response format should be “application/json”
            And
                “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
            And
                “completed” is false
            And
                “userId” is 2
     */
    @Test
    public void get(){
        // i) Url kurulacak
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak
        Response response = given().when().get(url);
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("title",is("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));

        // Hard Assertion: Hata aldığımızda testimiz çalışmayı durdurur.
        // Body sorgularını farklı body metd yaparsak ---> Hard assertion

        // Soft Assertion: Tek bir body metd bütün assertionları yaparsak
        // soft assertion olur. ---> test çalışmayı sürdürür, bütün hataların log u alınır

        response
                .then()
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed",equalTo(false)
                        ,"userId",equalTo(2));
    }
}
