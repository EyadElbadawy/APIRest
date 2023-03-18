package APITrial;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APITests {




    @Test
    public void test1(){
        Response response = get("https://reqres.in/api/users/2");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response" + response.asString());
        System.out.println("Body :" + response.getBody().asString());
        System.out.println("Time Taken :"+ response.getTime());
        System.out.println("Header : " + response.getHeader("content-type"));

        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode , 200);


    }

    @Test
    void test2(){
        Response response2 = RestAssured.put("https://reqres.in/api/users/2");
        System.out.println("Status code: " + response2.getStatusCode());
    }

    @Test
    void  test3(){
        baseURI = "https://reqres.in/api";
        Response response3 = get("/users/2");
        System.out.println(response3.getStatusCode());
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[1].id" , equalTo(8)).
                log().all();
    }
}
