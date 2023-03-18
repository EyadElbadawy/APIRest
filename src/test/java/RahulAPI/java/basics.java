package RahulAPI.java;


import Files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class basics {
    String newAddress = "70 winter walk, India";

      protected static String placeId;

    @Test(priority = 1)
    protected   void PostTest() {
        //Given - all input details
        //When - submit the API
        //Then - validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com" ;
        String response =
                given().
                     log().all().queryParam("key", "qaclick123").header("Content-Type" , "application/json")
                     .body(payLoad.AddPlace()).
                when().
                     post("/maps/api/place/add/json").
                then().
                     assertThat().statusCode(200).body("scope" , equalTo("APP"))
                    .header("Server" , "Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response); //for parsing json
        placeId =  js.getString("place_id");

        System.out.println(placeId);


    }
    @Test(priority = 2)
    public void UpdateCity (){


        //Update Place
        given().
                log().all().queryParam("key" , "qaclick123").header("Content-Type" , "application/json").
                body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").
        when().
                put("/maps/api/place/update/json").
        then().
                assertThat().log().all().statusCode(200).body("msg" , equalTo("Address successfully updated"));

    }
    @Test(priority = 3)
    public void GetCity(){
        //Get Address
        String getPlaceResponse =
        given().
                log().all().queryParam("key" , "qaclick123").queryParam("place_id" ,placeId).
        when().
                get("/maps/api/place/get/json").
        then().
                assertThat().log().all().statusCode(200).extract().response().asString();


        JsonPath js1 = ReusableMethod.rawToJson(getPlaceResponse);

         String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress,newAddress);

    }


    }
