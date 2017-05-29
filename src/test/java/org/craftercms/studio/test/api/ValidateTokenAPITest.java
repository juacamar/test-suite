package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by gustavo ortiz 
 */

public class ValidateTokenAPITest {

    private JsonTester api;

    public ValidateTokenAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @Test(priority=1)
    public void login(){
    	Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
    }
    
    @Test(priority=2)
    public void testValidateToken(){
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/validate-token.json?token=asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;
    }
    
    @Test(priority=3)
    public void testInvalidParameters(){
    	Map<String, Object> json = new HashMap<>();
    	api.get("/studio/api/1/services/api/1/user/validate-token.json?token=asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40").json(json).execute().status(200)
		.json("$.message", is("Invalid parameter(s)")).debug();;
    }
    
    
    @Test(priority=4)
    public void testUnauthorized(){
    	Map<String, Object> json = new HashMap<>();
    	api.get("/studio/api/1/services/api/1/user/validate-token.json?token=asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40").json(json).execute().status(200)
		.json("$.message", is("Unauthorized")).debug();;
    }
    
    @Test(priority=5)
    public void testExternallyManagedUser(){
    	Map<String, Object> json = new HashMap<>();
    	api.get("/studio/api/1/services/api/1/user/validate-token.json?token=asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40").json(json).execute().status(200)
		.json("$.message", is("Externally managed user")).debug();;
    }
    
    @Test(priority=5)
    public void testInternalServerError(){
    	Map<String, Object> json = new HashMap<>();
    	api.get("/studio/api/1/services/api/1/user/validate-token.json?token=asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40").json(json).execute().status(200)
		.json("$.message", is("Internal server error")).debug();;
    }

 
}
