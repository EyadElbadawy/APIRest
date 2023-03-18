package APITrial;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.*;


public class PutPatchDeleteExamples {
    @Test
    public void testPut(){

        JSONObject request = new JSONObject();
        request.put("name" , "Eyad");
        request.put("job" , "Engineer");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";

        given().
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();
    }



    @Test
    public void testPatch(){

        JSONObject request = new JSONObject();
        request.put("name" , "Eyad");
        request.put("job" , "Engineer");

        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in";

        given().
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().all();
    }


    @Test
    public void testDelete(){

        baseURI = "https://reqres.in";


                when().
                delete("/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
