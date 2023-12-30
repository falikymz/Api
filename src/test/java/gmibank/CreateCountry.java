package gmibank;

import base_urls.GmiBankBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPojo;
import pojos.StatePojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.*;

public class CreateCountry extends GmiBankBaseUrl {
        /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
            "id": null,
            "name": "Banana Republic",
            "states": [
                {
                    "id": 0,
                    "name": "Apple",
                    "tpcountry": null
                },
                {
                    "id": 1,
                    "name": "Orange",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Peach",
                    "tpcountry": null
                }
            ]
        }
    When
        Send post request
    Then
        Status code is 201
    And
        Response body is like:
        {
            "id": 189865,
            "name": "Banana Republic",
            "states": [
                {
                    "id": 0,
                    "name": "Apple",
                    "tpcountry": null
                },
                {
                    "id": 1,
                    "name": "Orange",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Peach",
                    "tpcountry": null
                }
            ]
        }
     */

    @Test
    public void createCountryTest() throws JsonProcessingException {
        spec.pathParams("first","api"
                ,"second","tp-countries");

        StatePojo state1 = new StatePojo(0,"Apple",null);
        StatePojo state2 = new StatePojo(1,"Orange",null);
        StatePojo state3 = new StatePojo(2,"Peach",null);

        List<StatePojo> states = new ArrayList<>();
        states.add(state1);
        states.add(state2);
        states.add(state3);
        System.out.println("states = " + states);

        CountryPojo payLoad = new CountryPojo(null,"Banana Republic",states);
        System.out.println("payLoad = " + payLoad);

        Response response =given(spec).body(payLoad).when().post("{first}/{second}");
        response.prettyPrint();

        // 1. Yol: body de Hamcrest Machers ile assertion yapmak:

        response
                .then()
                .statusCode(201)
                .body("name",equalTo(payLoad.getName()))
                .body("states.id",hasItem(state1.getId())
                        ,"states.id[0]",equalTo(state1.getId())
                        ,"states.name",hasItems(state1.getName(),state2.getName(),state3.getName()));

        // Ödev....

        // 2. Yol: JsonPath

        JsonPath json = response.jsonPath();
        assertEquals(payLoad.getName(),json.getString("name"));
        assertEquals(state1.getId(),json.getList("states.id").get(0));
        assertEquals(state1.getName(),json.getList("states.name").get(0));
        assertEquals(state2.getId(),json.getList("states.id").get(1));
        assertEquals(state2.getName(),json.getList("states.name").get(1));
        assertEquals(state3.getId(),json.getList("states.id").get(2));
        assertEquals(state3.getName(),json.getList("states.name").get(2));

        // 3. Yol: as() metoduyla Map' e dönüştürmek

        Map<String,Object> actualData =  response.as(HashMap.class);
        assertEquals(payLoad.getName(),actualData.get("name"));
        assertEquals(state1.getId(),((Map)((List)(actualData.get("states"))) .get(0)) .get("id"));
        assertEquals(state1.getName(),((Map)((List)(actualData.get("states"))) .get(0)) .get("name"));
        assertEquals(state2.getId(),((Map)((List)(actualData.get("states"))) .get(1)) .get("id"));
        assertEquals(state2.getName(),((Map)((List)(actualData.get("states"))) .get(1)) .get("name"));
        assertEquals(state3.getId(),((Map)((List)(actualData.get("states"))) .get(2)) .get("id"));
        assertEquals(state3.getName(),((Map)((List)(actualData.get("states"))) .get(2)) .get("name"));

        // 4. Yol: as() metoduyla POJO

        CountryPojo actualPojo = response.as(CountryPojo.class);

        assertEquals(payLoad.getName(),actualPojo.getName());
        assertEquals(state1.getId(),actualPojo.getStates().get(0).getId());


        // 5. Yol: ObjectMapper ile Map' e dönüştürmek...

        Map<String,Object> actualObjMapper = new ObjectMapper().readValue(response.asString(), HashMap.class);
        assertEquals(payLoad.getName(),actualObjMapper.get("name"));
        assertEquals(state1.getId(),((Map)((List)(actualObjMapper.get("states"))) .get(0)) .get("id"));
        assertEquals(state1.getName(),((Map)((List)(actualObjMapper.get("states"))) .get(0)) .get("name"));
        assertEquals(state2.getId(),((Map)((List)(actualObjMapper.get("states"))) .get(1)) .get("id"));
        assertEquals(state2.getName(),((Map)((List)(actualObjMapper.get("states"))) .get(1)) .get("name"));
        assertEquals(state3.getId(),((Map)((List)(actualObjMapper.get("states"))) .get(2)) .get("id"));
        assertEquals(state3.getName(),((Map)((List)(actualObjMapper.get("states"))) .get(2)) .get("name"));


        // 6. Yol: ObjectMapper ile POJO' ya dönüştürmek...
        CountryPojo actualPojo2 = new ObjectMapper().readValue(response.asString(), CountryPojo.class);
        assertEquals(payLoad.getName(),actualPojo2.getName());
        assertEquals(state1.getId(),actualPojo2.getStates().get(0).getId());


    }
}