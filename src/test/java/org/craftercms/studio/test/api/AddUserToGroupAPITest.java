package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class AddUserToGroupAPITest {

	private JsonTester api;
	private String headerLocationBase;

	public AddUserToGroupAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
		headerLocationBase=apiConnectionManager.getHeaderLocationBase();
		
	}

	@BeforeTest
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}

	@Test(priority = 1)
	public void testCreateSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", "mySite");
		json.put("description", "My very first site!");
		json.put("blueprint", "Empty");
		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase+"/studio/api/1/services/api/1/site/get.json?site_id=mySite"))
				.json("$.message", is("OK")).debug();

	}
	
	@Test(priority=2)
	public void testCreateStudioGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("group_name", "contributors");
		json.put("site_id", "mySite");
		json.put("description", "Content Contributors");
		api.post("/studio/api/1/services/api/1/group/create.json").json(json).execute().status(201)
				.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/group/get.json?group_name=contributors"))
				.json("$.message", is("OK")).debug();

	}
	
	@Test(priority=3)
	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("password", "SuperSecretPassword123#");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("OK")).debug();

	}
	
	@Test(priority=4)
	public void testAddUserToGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("group_name", "contributors");
		json.put("site_id", "mysite");
		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
		.execute()
		.status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/group/get.json?group_name=contributors"))
		.json("$.message", is("OK")).debug();



	}
	
	
	@Test(priority=5)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernameInvalid", "jane.doe");
		json.put("group_name", "contributors");
		json.put("site_id", "mysite");
		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
		.execute()
		.status(400)
		.json("$.message", is("Invalid parameter(s): [username]")).debug();



	}
	
//	@Test(priority=6)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("group_name", "contributors");
//		json.put("site_id", "mysite");
//		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
//		.execute()
//		.status(401)
//		.json("$.message", is("Unauthorized")).debug();
//
//
//
//	}
	
	@Test(priority=6)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doeNOTEXIST");
		json.put("group_name", "contributors");
		json.put("site_id", "mysite");
		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
		.execute()
		.status(404)
		.json("$.message", is("User not found")).debug();



	}
	
	@Test(priority=6)
	public void testGroupNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doeNOTEXIST");
		json.put("group_name", "contributorsNOTEXIST");
		json.put("site_id", "mysite");
		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
		.execute()
		.status(404)
		.json("$.message", is("Group not found")).debug();



	}
	
	
	@Test(priority=4)
	public void testUserAlreadyInGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("group_name", "contributors");
		json.put("site_id", "mysite");
		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
		.execute()
		.status(409)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/group/get.json?group_name=contributors"))
		.json("$.message", is("User already in group")).debug();



	}
//	
//	@Test(priority=4)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("group_name", "contributors");
//		json.put("site_id", "mysite");
//		api.post("/studio/api/1/services/api/1/group/add-user.json").json(json)
//		.execute()
//		.status(500)
//		.json("$.message", is("Internal server error")).debug();
//
//
//
//	}
	
	
}
