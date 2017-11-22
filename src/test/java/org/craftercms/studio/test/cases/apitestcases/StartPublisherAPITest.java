package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gustavo ortiz
 */

public class StartPublisherAPITest {

	private JsonTester api;
	private String headerLocationBase;
	// private String username = "admin";
	// private String password = "admin";
	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";

	public StartPublisherAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		headerLocationBase = apiConnectionManager.getHeaderLocationBase();
	}

	@Test(priority = 1)
	public void testCreateSite() {
	 	Map<String, Object> json = new HashMap<>();
			json.put("site_id", siteId);
			json.put("description", description);
			json.put("blueprint", blueprint);
			
			api.post("/studio/api/1/services/api/1/site/create.json")
			//.urlParam("site_id", siteId)
		    //.urlParam("description", description)
			//.urlParam("blueprint", blueprint)
			.json(json).execute().status(201)
					.header("Location",
							is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id="+siteId))
					.json("$.message", is("OK")).debug();
	}

	@Test(priority = 2)
	public void startPublisher() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/publish/start.json")
		//.urlParam("site_id", siteId)
		.json(json).execute().status(200)
				// .json("$.message", is("OK"))
				.debug();
	}

	@Test(priority = 3)
	public void invalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_idnonvalid", siteId);
		
		api.post("/studio/api/1/publish/start.json")
		//.urlParam("site_idnonvalid", siteId)
		.json(json).execute().status(400)
				// .json("$.message", is("Invalid parameter(s)"))
				.debug();
	}

	// @Test(priority=4)
	// public void unauthorized(){
	// Map<String, Object> json = new HashMap<>();
	// json.put("site_id", "mySite");
	// api.post("http://localhost:8080/studio/api/1/publish/start.json?site_id=mySite").json(json).execute().status(401)
	// //.json("$.message", is("Unauthorized"))
	// .debug();
	// }

	@Test(priority = 5)
	public void siteNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId+"nonvalid");
		
		api.post("/studio/api/1/publish/start.json")
		//.urlParam("site_id", siteId+"nonvalid")
		.json(json).execute().status(404)
				// .json("$.message", is("site not found"))
				.debug();
	}

	// @Test(priority=6)
	// public void internalServerError(){
	// Map<String, Object> json = new HashMap<>();
	// json.put("site_id", "mySiteNOTFOUND");
	// api.post("http://localhost:8080/studio/api/1/publish/start.json?site_id=mySite").json(json).execute().status(500)
	// //.json("$.message", is("Internal server error.ACTUAL_EXCEPTION"))
	// .debug();
	// }

}
