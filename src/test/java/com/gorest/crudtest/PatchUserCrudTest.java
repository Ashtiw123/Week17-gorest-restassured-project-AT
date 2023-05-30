package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static com.gorest.utils.TestUtils.getRandomValue;
import static io.restassured.RestAssured.given;

public class PatchUserCrudTest {
    @Test
    public void updateUser() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("three monkeys");
        userPojo.setEmail("gandhimonkeys1" + getRandomValue() + "@gmail.com");
        userPojo.setStatus("active");
        userPojo.setGender("male");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .pathParam("id", 3966)
                .body(userPojo)
                .when()
                .patch("/users" + "/{id}")
                .then()
                .extract().response();
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
