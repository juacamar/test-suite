package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

/**
 * Created by gustavo ortiz
 */

public class ValidateTokenAPITest {

	private JsonTester api;
	private String username = "admin";
	private String password = "admin";
	private String token = "asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40";

	public ValidateTokenAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
	}

	@Test(priority = 1)
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json")
		//.urlParam("username", username)
		//.urlParam("password", password)
		.json(json).execute().status(200);
	}

	@Test(priority = 2)
	public void testValidateToken() {
		Map<String, Object> json = new HashMap<>();
		json.put("token", token);
		
		api.get("/studio/api/1/services/api/1/user/validate-token.json")
		//.urlParam("token", token)
		.json(json).execute().status(200)
				.json("$.message", is("OK")).debug();
	}

	@Test(priority = 3)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("tokennonvalid", token);
		
		api.get("/studio/api/1/services/api/1/user/validate-token.json")
		//.urlParam("tokennonvalid", token)
		.json(json).execute()
				.status(200).json("$.message", is("Invalid parameter(s)")).debug();
	}

	@Test(priority = 4)
	public void testUnauthorized() {
		Map<String, Object> json = new HashMap<>();
		json.put("token", token+ "nonvalid");
		
		api.get("/studio/api/1/services/api/1/user/validate-token.json")
		//.urlParam("token", token + "nonvalid")
		.json(json).execute().status(200).json("$.message", is("Unauthorized")).debug();
	}

	@Test(priority = 5)
	public void testExternallyManagedUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("token", "asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40");
		
		api.get("/studio/api/1/services/api/1/user/validate-token.json")
				.json(json).execute().status(200).json("$.message", is("Externally managed user")).debug();
	}

	@Test(priority = 5)
	public void testInternalServerError() {
		Map<String, Object> json = new HashMap<>();
		json.put("token", "asfopaiu02928s0980b98a098gs0fduoi2j341j448t735h1lk40");
		
		api.get("/studio/api/1/services/api/1/user/validate-token.json").json(json)
				.execute().status(200).json("$.message", is("Internal server error")).debug();	
	}

}
