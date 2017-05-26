package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by gustavo ortiz 
 */

public class ValidateSessionAPITest {

    private JsonTester api;

    public ValidateSessionAPITest(){
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
    public void validateSession(){
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/security/validate-session.json").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;
    }
    
    @Test(priority=3)
    public void logout(){
    	Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/logout.json").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;
    }
    
    @Test(priority=4)
    public void validateSessionUnauthorized(){
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/security/validate-session.json").json(json).execute().status(401)
		.json("$.message", is("Unauthorized")).debug();;
    }

 
}
