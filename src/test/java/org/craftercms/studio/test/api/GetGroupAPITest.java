package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class GetGroupAPITest {

	private JsonTester api;
	private String username = "admin";
	private String password = "admin";
	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";
	private String groupName = "contributors";
	private String headerLocationBase;

	public GetGroupAPITest() {
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
		//.urlParam("username", username)
		//.urlParam("password", password)
		.json(json).execute().status(200);
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
	public void testCreateStudioGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("group_name", groupName);
		json.put("site_id", siteId);
		json.put("description", description);
		
		api.post("/studio/api/1/services/api/1/group/create.json")
		//.urlParam("group_name", groupName)
		//.urlParam("site_id", siteId)
		//.urlParam("description", description)
		.json(json)
		.execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/group/get.json?group_name="+groupName))
				.json("$.message", is("OK")).debug();
	}

	@Test(priority = 3)
	public void testGetGroup() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("group_name", groupName);
//		json.put("site_id", siteId);
		
		api.get("/studio/api/1/services/api/1/group/get.json")
		.urlParam("group_name", groupName)
		.urlParam("site_id", siteId)
		//.json(json)
		.execute()
				.status(200).header("Location", is(
						headerLocationBase+"/studio/api/1/services/api/1/get/get.json?site_id="+siteId+"&group_name="+groupName));
		// .json("$.message", is("OK")).debug();

	}

	@Test(priority = 4)
	public void testInvalidParameter() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("group_name", groupName);
//		json.put("site_idnonvalid", siteId);
		
		api.get("/studio/api/1/services/api/1/group/get.json")
		.urlParam("group_name",groupName)
		.urlParam("site_idnonvalid", siteId)
		//.json(json)
		.execute().status(400)
				.json("$.message", is("Invalid parameter(s): [site_id]")).debug();

	}

	// @Test(priority = 5)
	// public void testUnauthorized() {
	// Map<String, Object> json = new HashMap<>();
	// api.get("http://localhost:8080/studio/api/1/services/api/1/group/get.json?group_name=contributors&site_id=mysite").json(json).execute().status(401)
	// .json("$.message", is("Unauthorized")).debug();
	//
	// }

	@Test(priority = 6)
	public void testGroupNotFound() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("group_name", groupName+"nonvalid");
//		json.put("site_id", siteId);
		
		api.get("/studio/api/1/services/api/1/group/get.json")
		.urlParam("group_name", groupName+"nonvalid")
		.urlParam("site_id", siteId)
		//.json(json)
		.execute().status(404)
				.json("$.message", is("Group not found")).debug();

	}

	// @Test(priority = 7)
	// public void testInternalServerError() {
	// Map<String, Object> json = new HashMap<>();
	// api.get("http://localhost:8080/studio/api/1/services/api/1/group/get.json?group_name=contributors&").json(json).execute().status(500)
	// .json("$.message", is("Internal server error")).debug();
	//
	// }

}
