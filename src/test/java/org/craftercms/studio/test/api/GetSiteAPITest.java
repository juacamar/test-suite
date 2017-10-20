package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
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
	private String headerLocationBase;

	private String username = "admin";
	private String password = "admin";
	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";
	
    public GetSiteAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
		headerLocationBase=apiConnectionManager.getHeaderLocationBase();
    }

    @BeforeTest
	public void login() {
    	Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json")
				.json(json).execute().status(200);
	}


    @Test(priority=1)
	public void testCreateSite() {
    	Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);

		api.post("/studio/api/1/services/api/1/site/create.json")
				.json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id=" + siteId))
				.json("$.message", is("OK")).debug();
	}
    
    @Test(priority=2)
   	public void testGetSite() {
    	Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		
		api.get("/studio/api/1/services/api/1/site/get.json")
		.json(json).execute()
		.status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/site/get.json?site_id="+ siteId));
   	}
    
    @Test(priority=3)
   	public void testSiteNotFound() {
     	Map<String, Object> json = new HashMap<>();
    		json.put("site_id", siteId+"nonvalid");
    		
    		api.get("/studio/api/1/services/api/1/site/get.json")
    	  	.json(json).execute()
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
		json.put("site_id", siteId);
		
		api.get("/studio/api/1/services/api/1/site/get.json")
		.json(json).execute()
		.status(401)
		.json("$.message", is("Unauthorized")).debug();

    }
}
