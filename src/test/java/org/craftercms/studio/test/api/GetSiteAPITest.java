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
 * Created by Gustavo Ortiz Alfaro
 */

public class GetSiteAPITest {

    private JsonTester api;

    public GetSiteAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @BeforeTest
	public void login() {
     	Map<String, Object> json = new HashMap<>();
    		json.put("username", "admin");
    		json.put("password", "admin");
    		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}


    @Test(priority=1)
	public void testCreateSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", "mySite");
		json.put("description", "My very first site!");
		json.put("blueprint", "Empty");
		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/site/get.json?site_id=mySite"))
				.json("$.message", is("OK")).debug();

	}
    
    @Test(priority=2)
   	public void testGetSite() {
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/site/get.json?site_id=mySite")
		.json(json)
		.execute()
		.status(200)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/site/get.json?site_id=mySite"));


   	}
    
    @Test(priority=3)
   	public void testSiteNotFound() {
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/site/get.json?site_id=NOTEXIST")
		.json(json)
		.execute()
		.status(404)
		.json("$.message", is("Site not found")).debug();



   	}
    
    

    
    @Test(priority=4)
	public void testLogout() {
		Map<String, Object> json = new HashMap<>();
		api.post("/studio/api/1/services/api/1/user/logout.json").json(json).execute().status(200).debug();

	}
    
    
    
    
    @Test(priority=5)
   	public void testUnauthorized() {
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/site/get.json?site_id=NOTEXIST")
		.json(json)
		.execute()
		.status(401)
		.json("$.message", is("Unauthorized")).debug();

    }
}
