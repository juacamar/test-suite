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

public class RemoveUserFromGroupAPITest {

	private JsonTester api;
	private String headerLocationBase;
    private String username = "admin";
   	private String password = "admin";
   	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";
	private String groupName = "contributors";
	private String newusername = "jane.doe";
	private String newpassword = "SuperSecretPassword123#";
	private String first_name = "Jane";
	private String last_name = "Doe";
	private String email = "jane@example.com";

	public RemoveUserFromGroupAPITest() {
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
	
	@Test(priority=2)
	public void testCreateStudioGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("group_name", groupName);
		json.put("site_id", siteId);
		json.put("description", description);
		
		api.post("/studio/api/1/services/api/1/group/create.json")
//		.urlParam("group_name", groupName)
//		.urlParam("site_id", siteId)
//		.urlParam("description", description)
		.json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/group/get.json?group_name="+groupName))
				.json("$.message", is("OK")).debug();
	}
	
	@Test(priority=3)
	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		
		api.post("/studio/api/1/services/api/1/user/create.json")
//		.urlParam("username", newusername)
//		.urlParam("password", newpassword)
//		.urlParam("first_name", first_name)
//		.urlParam("last_name", last_name)
//		.urlParam("email", email)
		.json(json).execute().status(201)
				.header("Location", is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?user="+newusername))
				.json("$.message", is("OK")).debug();
	}
	
	@Test(priority=4)
	public void testAddUserToGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("group_name", groupName);
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/services/api/1/group/add-user.json")
		//.urlParam("username", newusername)
		//.urlParam("group_name", groupName)
		//.urlParam("site_id", siteId)
		.json(json).execute().status(200)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/group/get.json?group_name="+groupName))
				.json("$.message", is("OK")).debug();
	}
	
	@Test(priority=5)
	public void testRemoveUserFromGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("group_name", groupName);
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/services/api/1/group/remove-user.json")
		//.urlParam("username", newusername)
		//.urlParam("group_name", groupName)
		//.urlParam("site_id", siteId)
		.json(json).execute()
		.status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/group/get.json?group_name="+groupName))
		.json("$.message", is("null"));
	}
	
	
	@Test(priority=6)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);
		json.put("group_namenonvalid", groupName);
		json.put("site_idnonvalid", siteId);
		
		api.post("/studio/api/1/services/api/1/group/remove-user.json")
		//.urlParam("usernamenonvalid", newusername)
		//.urlParam("group_namenonvalid", groupName)
		//.urlParam("site_idnonvalid", siteId)
		.json(json).execute()
		.status(400)
		.json("$.message", is("Invalid parameter(s): [group_name, site_id, username]"));
	}
	
	
//	@Test(priority=7)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("group_name", "contributors");
//		json.put("site_id", "mysite");
//		api.post("/studio/api/1/services/api/1/group/remove-user.json").json(json)
//		.execute()
//		.status(401)
//		.json("$.message", is("Unauthorized"));
//
//	}
	
	
	@Test(priority=8)
	public void testGroupNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("group_name", groupName+"nonvalid");
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/services/api/1/group/remove-user.json")
		//.urlParam("username", newusername)
		//.urlParam("group_name", groupName+"nonvalid")
		//.urlParam("site_id", siteId)
		.json(json).execute()
		.status(404)
		.json("$.message", is("Group not found"));

	}
	
	@Test(priority=9)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername+"nonvalid");
		json.put("group_name", groupName);
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/services/api/1/group/remove-user.json")
		//.urlParam("username", newusername+"nonvalid")
		//.urlParam("group_name", groupName)
		//.urlParam("site_id", siteId)
		.json(json).execute()
		.status(404)
		.json("$.message", is("User not found"));

	}
	
//	@Test(priority=10)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doeNotExist");
//		json.put("group_name", "contributors");
//		json.put("site_id", "mysite");
//		api.post("/studio/api/1/services/api/1/group/remove-user.json").json(json)
//		.execute()
//		.status(500)
//		.json("$.message", is("Internal server error"));
//
//	}
	
	
	
}
