package org.craftercms.studio.test.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.utils.JsonTester;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by cortiz on 3/15/17.
 */

public class LoginAPITest {

    private JsonTester api;

    public LoginAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @Test
    public void login(){
        api.post("/studio/api/1/services/api/1/security/login.json")
                .param("username","admin")
                .param("password","admin")
                .execute().status(200)
                .header("Content-Language",is("en-US"))
                .header("Content-Type",is("application/json;charset=UTF-8"))
                .json("$",notNullValue())
                .json("$.user.email",not(empty()))
                .json("$.user.username",is("admin"));
    }


 
}
