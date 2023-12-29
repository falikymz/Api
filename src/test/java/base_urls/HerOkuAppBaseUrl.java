package base_urls;

import heroku_smoke_test.C01CreateToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static heroku_smoke_test.C01CreateToken.createToken;
import static io.restassured.RestAssured.given;

public class HerOkuAppBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){

        String BaseUrl = "https://restful-booker.herokuapp.com";
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BaseUrl)
                .addHeader("Cookie","token="+createToken())
                .build();
    }


}
