package test_data;
import java.util.HashMap;
import java.util.Map;
public class JsonPlaceHolderTestData {

    public static Map<String, Object> jsonPlaceHolderMapper(Integer userId,String title,Boolean completed){
        Map<String,Object>map=new HashMap<>();

        if (userId!=null){
            map.put("userId",userId);
        }
        if (title!=null){
            map.put("title",title);
        }
        if (completed!=null){
            map.put("completed",completed);
        }
        return map;
    }
}
