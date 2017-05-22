package org.craftercms.studio.test.api;

import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.utils.JsonTester;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class EnableUserAPITest {

	private JsonTester api;

	public EnableUserAPITest() {
		api = new JsonTester("http", "localhost", 8080);
	}

	@BeforeTest
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}

	@Test(priority=1)
	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "newuser");
		json.put("password", "SuperSecretPassword123#");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=newuser"))
				.json("$.message", is("OK"));

	}
	
	@Test(priority=2)
	public void testEnableUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "newuser");
		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(200)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=newuser"))
		.json("$.message", is("OK")).debug();
		
		
	}
	
	@Test(priority=3)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernameX", "newuser");
		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(400)
		.json("$.message", is("Invalid parameter: username")).debug();
		

	}
	
	
	
//	@Test(priority=4)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "newuserNotFound");
//		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(401)
//		.json("$.message", is("Unauthorized")).debug();
//
//
//	}
	
	
	
//	@Test(priority=5)
//	public void testExternallyManagedUser() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "newuserNotFound");
//		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(403)
//     	.json("$.message", is("Externally managed user")).debug();
//
//		
//
//	}
	
	
	@Test(priority=6)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "newuserNotFound");
		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(404)
		.json("$.message", is("User not found")).debug();

		

	}
	


//	@Test(priority=7)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("", "newuser");
//		api.post("/studio/api/1/services/api/1/user/enable.json").json(json).execute().status(500)
//		.json("$.message", is("Internal server error"));
//		
//
//	}
	
}
