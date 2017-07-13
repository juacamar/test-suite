package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class UpdateUserAPITest {

	private JsonTester api;

	public UpdateUserAPITest() {
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
		json.put("username", "jane.doe");
		json.put("password", "SuperSecretPassword123#");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("OK"))
				.debug();

	}
	
	@Test(priority=2)
	public void testUserUpdate() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		json.put("externally_managed", "false");
		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(200)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
				.json("$.message", is("OK"))
				.debug();

	}
	
//    TODO: pending because need LDAP	
//	@Test(priority=3)   
//	public void testExternallyManagedUser() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("first_name", "Jane");
//		json.put("last_name", "Doe");
//		json.put("email", "jane@example.com");
//		json.put("externally_managed", "true");
//		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(403)
//				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
//				.json("$.message", is("Externally managed user"))
//				.debug();
//
//	}
		
	@Test(priority=3)   
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doeNOTFOUND");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		json.put("externally_managed", "true");
		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(404)
				.json("$.message", is("User not found"))
				.debug();

	}	
	
	
//  TODO:  Commented until you know how to invoke an internal server error.

//	@Test(priority=4)   
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("usernamed", "jane.doed");
//		json.put("first_named", "Jane");
//		json.put("last_named", "Doe");
//		json.put("emaild", "jane@example.com");
//		json.put("externally_managed", "true");
//		api.post("/studio/api/1/services/api/1/user/update.json").json(json).execute().status(500)
//				.json("$.message", is("Internal server error"))
//				.debug();
//
//	}
	
	@Test(priority = 5)
	public void testDeleteUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		api.post("/studio/api/1/services/api/1/user/delete.json").json(json).execute();

	}
}
