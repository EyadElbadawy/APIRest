package APITrial;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {
     //@Test
     public void testGet(){
         baseURI = "https://reqres.in/api";

         given().get("/users?page=2").
                 then().
                    statusCode(200).
                 body("data[4].first_name" , equalTo("George")).
                 body("data.first_name" , hasItems("George" , "Rachel" , "Michael"));

     }

     @Test
    public void testPost(){
         Map<String , String> map = new HashMap<String , String>();

       //  map.put("name" , "Eyad");
      //   map.put("job" , "Engineer");

        // System.out.println(map);

         JSONObject request = new JSONObject(map);
         request.put("name" , "Eyad");
         request.put("job" , "Engineer");

         System.out.println(request.toJSONString());

         baseURI = "https://reqres.in/api";

                 given().
                         body(request.toJSONString()).
                 when().
                         post("/users").
                 then().
                         statusCode(201).
                         log().all();
     }
}
