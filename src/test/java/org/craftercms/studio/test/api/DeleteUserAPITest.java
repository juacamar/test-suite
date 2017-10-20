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

public class DeleteUserAPITest {

	private JsonTester api;
	
	private String username = "admin";
	private String password = "admin";
	private String newusername = "jane.doe";
	

	public DeleteUserAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
	}

	@BeforeTest
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json")
				.json(json).execute().status(200);
	}

	@Test(priority = 4)
	public void testDeleteUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		api.post("/studio/api/1/services/api/1/user/delete.json")
		.json(json).execute().status(204);
 
	}

	@Test(priority = 5)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);
		
		api.post("/studio/api/1/services/api/1/user/delete.json")
		.json(json).execute().status(400).json("$.message",
				is("Invalid parameter: username"));

	}


	@Test(priority = 6)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername+"nonvalid");
		
		api.post("/studio/api/1/services/api/1/user/delete.json")
		.json(json).execute().status(404).json("$.message",
				is("User not found"));

	}

}
