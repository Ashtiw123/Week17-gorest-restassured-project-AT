package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest extends TestBase {
    static ValidatableResponse response;
    public UserAssertionTest(){
        response = given()
                .queryParam("page",1)
                .queryParam("per_page",20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }
//1Verify the if the total record is 20
    @Test
    public void test001VerifyTheIfTheTotalRecordIs20(){
        response.body("size", equalTo(20));
    }
    @Test
    public void test002VerifyTheIfTheNameOfId2272608IsEqualToDeepankarAsan(){
        response.body("find{it.id==2272608}.name",equalTo("Vimal Pilla"));
      //  response.body("data.name",hasItem("Deepankar Asan"));

    }
    @Test
    public void test003CheckTheSingleNameInTheArrayListSenApsaraDubashi(){
        response.body("name", hasItem("Sen. Apsara Dubashi"));
    }
    @Test
    public void test004CheckTheMultipleNamesInTheArrayList(){
        response.body("name", hasItems("Digambar Chaturvedi PhD", "Ganaka Prajapat DVM", "Aasa Kaniyar II"));
    }
    @Test
    public void test005VerifyTheEmailOfUserid(){
        response.body("findAll{it.id=2272623}.email", equalTo(("dvm_prajapat_ganaka@ratke.test")));
    }
    @Test
    public void test006VerifyTheStatusIsActiveOfUserName(){
        response.body("find{it.name='Vishwamitra Abbott'}.status", equalTo("active"));
    }
@Test
    public void test007VerifyGenderOfUser(){
    response.body("find{it.name='Chandraswaroopa Joshi'}.gender", equalTo("female"));

}
}
