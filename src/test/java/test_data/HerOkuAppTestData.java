package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {
    /*
     Map<String,String>bookingDateMap=new HashMap<>();
        bookingDateMap.put("checkin","2018-01-01");
        bookingDateMap.put("checkout","2019-01-01");
     */
    public static Map<String,String>bookingDatesMapper(String checkin,String checkout){
        Map<String,String>map=new HashMap<>();
        map.put("checkin",checkin);
        map.put("checkout",checkout);
        return map;
    }

    public static Map<String,Object>herokuAppMapper(String firstname,String lastname,Integer totalprice,
                                                    Boolean depositpaid,Map<String,String>bookingdates,String additionalneeds){
        Map<String,Object> map = new HashMap<>();
        if(firstname!=null){
            map.put("firstname",firstname);
        }
        if(lastname!=null){
            map.put("lastname",lastname);
        }
        if(totalprice!=null){
            map.put("totalprice",totalprice);
        }
        if(depositpaid!=null){
            map.put("depositpaid",depositpaid);
        }
        if(bookingdates!=null){
            map.put("bookingdates",bookingdates);
        }
        if(additionalneeds!=null){
            map.put("additionalneeds",additionalneeds);
        }
        return map;
    }


}
