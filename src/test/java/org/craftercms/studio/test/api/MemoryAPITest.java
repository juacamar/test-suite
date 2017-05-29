package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by gustavo ortiz 
 */

public class MemoryAPITest {

    private JsonTester api;

    public MemoryAPITest(){
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
    public void testMemory(){
    	Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/api/1/monitor/memory.json").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;
    }
    
    
    @Test(priority=3)
    public void testInternalServerError(){
    	Map<String, Object> json = new HashMap<>();
    	api.get("http://localhost:8080/studio/api/1/monitor/memory.json").json(json).execute().status(200)
		.json("$.message", is("Internal server error")).debug();;
    }

 
}
