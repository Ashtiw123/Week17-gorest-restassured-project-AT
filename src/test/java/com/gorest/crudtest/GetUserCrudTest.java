package com.gorest.crudtest;

import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserCrudTest extends TestBase {
    @Test
    public void getAllUserInfo(){
        Response response =  given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
