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
 * Created by Gustavo Ortiz Alfaro.
 */

public class CreateUserAPITest {

    private JsonTester api;

    public CreateUserAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @BeforeTest
    public void login(){
        api.post("/studio/api/1/services/api/1/user/login.json")
                .param("username","admin")
                .param("password","admin")
                .execute()
                .status(200)
                .header("Content-Language",is("en-US"))
                .header("Content-Type",is("application/json;charset=UTF-8"))
                .json("$",notNullValue())
                .json("$.user.email",not(empty()))
                .json("$.user.username",is("admin"));
    }

    @Test
    public void testCreateUser(){
        //String siteName = RandomStringUtils.randomAlphabetic(5);
        Map<String,Object> json=new HashMap<>();
        json.put("username", "jane.doez");
        json.put("password", "SuperSecretPassword123#");
        json.put("first_name", "Jane");
        json.put("last_name", "Doe");
        json.put("email", "jane@example.com");
        api.post("/studio/api/1/services/api/1/user/create.json")
                .json(json)
                .execute()
                .status(201);    
        
    }
    
    
}
