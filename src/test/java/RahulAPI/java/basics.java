package RahulAPI.java;


import Files.UserAndParameters;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class basics {

    UserAndParameters AddUser = new UserAndParameters();
    UserAndParameters parameters = new UserAndParameters();



      //Get Booking Token
    @Test(priority = 1)
    protected void PostToken() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com" ;
        String token = given().
                     log().all().header("Content-Type","application/json").body(UserAndParameters.AddUser()).
                when().
                     post("/auth").
                then().
                     assertThat().statusCode(200).extract().response().asString();

        System.out.println("this is the token " + token);


    }


    @Test(priority = 2)
    public void GetBookingId(){
        //Get Address
        given().
                log().all().queryParam(UserAndParameters.parameters()).
                when().
                get("/booking").
                then().log().all().assertThat().statusCode(200);

    }

    @Test(priority = 3)
    public void GetBooking(){

    }


    }
