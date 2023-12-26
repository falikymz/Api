package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){
        String BaseUrl = "https://restful-booker.herokuapp.com";
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BaseUrl)
                .build();
    }
}
