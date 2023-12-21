package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    1) Manuel testler için Postman kullanacağız
    2) Otomasyon testleri için Rest Assured Library kullanacağız
    3) Test caseler yazılırken şu adımları takip edelim:
        i) Önkoşullar iyi anlaşılamlı
        ii) Test case yazılırken Gherkin dili kullanılır
        Given: Önkoşullar--> url,body,authorzation...
        When: Aksyion-->get(),post()....
        Then: Doğrulamalar--> Assertion
        And: Çoklu durumları birbirine bağlamakda kullanılır
    4) Otomasyon testi yazarken aşağıdaki adımları izliyebiliriz:
     i) Url kurulacak
     ii)Beklenen data belirlenecek
     İİİ)Request gönderilip Response alınacak
     iv) Doğrulamalar yapılacak
     */
    public static void main(String[] args) {

        String url="https://petstore.swagger.io/v2/pet/5";
        //Base url :  https://petstore.swagger.io/v2
       // 1.Path parametresi : /pet
       // 2.Path parametresi : /5

        //ii)Beklenen data belirlenecek ---->şimdilik atlayacağız
        //iii)Request gönderilip Response alınacak
        Response response =given().when().get(url);
        response.prettyPrint();

        //status code a nasıl ulaşılır/yazdırılır:
        int statusCode =response.statusCode();
        System.out.println("statusCode : " + statusCode);

        //status line  nasıl ulaşılır/yazdırılır:
        System.out.println("statusLine : "+response.statusLine());

        //ContentType' nasıl ulaşılır
        System.out.println("ContentType :"+response.contentType());

        //Header değerlerine nasıl ulaşılır
        //response.header("Server") özel bir header çağırmak istersek mesela server
        //response.header("Date") özel bir header çağırmak istersek mesela date
        System.out.println(response.header("Server"));
        System.out.println(response.header("Date"));
        System.out.println("********************************");

        //Bütün headerslar nasıl alınır
        //response.headers() tüm header çağırmak için
        System.out.println("All Headers :"+response.headers());

        //Response süresi nasıl çağrılır
        //response.time()
        System.out.println(response.time());

    }
}
