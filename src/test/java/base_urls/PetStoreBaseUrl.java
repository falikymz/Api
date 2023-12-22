package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetStoreBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){
        String BaseUrl = "https://petstore.swagger.io/v2";
        spec = new RequestSpecBuilder().setBaseUri(BaseUrl).build();
    }
}
