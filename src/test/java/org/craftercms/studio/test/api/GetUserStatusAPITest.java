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

public class GetUserStatusAPITest {

	private JsonTester api;
	private String headerLocationBase;
	private String username = "admin";
	private String password = "admin";
	private String newusername = "jane.doe";
	private String newpassword = "SuperSecretPassword123#";
	private String first_name = "Jane";
	private String last_name = "Doe";
	private String email = "jane@example.com";

	public GetUserStatusAPITest() {
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
	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		
		api.post("/studio/api/1/services/api/1/user/create.json")
		.json(json).execute().status(201)
				.header("Location", is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?user="+newusername))
				.json("$.message", is("OK")).debug();
	}
	
	@Test(priority=2)
	public void testGetUserStatus() {

		
		api.get("/studio/api/1/services/api/1/user/status.json")
		.urlParam("username", newusername)
		.execute()
		.status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/user/get.json?username="+newusername));
		
	}
	
	@Test(priority=3)
	public void testInvalidParameter() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);
		
		api.get("/studio/api/1/services/api/1/user/status.json")
		.json(json).execute()
		.status(400)
		.json("$.message", is("Invalid parameter: username"));

		

	}

	
	@Test(priority=5)
	public void testUserNotFound() {
		
		api.get("/studio/api/1/services/api/1/user/status.json")
		.urlParam("username", newusername+"nonvalid")
		.execute()
		.status(404);
		
	}
	
	
	
	
//	@Test(priority=6)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("/studio/api/1/services/api/1/user/status.json?username=jane.doe")
//		.json(json)
//		.execute()
//		.status(500)
//		.json("$.message", is("Internal server error"))
//
//		.debug();
//		
//	}

}
