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

public class ResetPasswordAPITest {

	private JsonTester api;

	public ResetPasswordAPITest() {
		api = new JsonTester("http", "localhost", 8080);
	}

	@BeforeTest
	public void login() {
		api.post("/studio/api/1/services/api/1/user/login.json").param("username", "admin").param("password", "admin")
				.execute().status(200).header("Content-Language", is("en-US"))
				.header("Content-Type", is("application/json;charset=UTF-8")).json("$", notNullValue())
				.json("$.user.email", not(empty())).json("$.user.username", is("admin")).debug();
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
				.json("$.message", is("OK")).debug();

	}
	
	@Test(priority=2)
	public void testResetPassword() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("new", "12345");
		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(200)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
				.json("$.message", is("OK")).debug();

	}

//	@Test(priority=3)
//	public void testInvalidParameters() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("usernameFAIL", "jane.doe");
//		json.put("new", "12345");
//		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(400)
//				.json("$.message", is("Invalid parameter(s)")).debug();
//
//	}
	

//	@Test(priority=4)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("new", "12345");
//		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(401)
//				.json("$.message", is("Unauthorized")).debug();
//
//	}
	
	
//	@Test(priority=5)
//	public void testExternallyManagedUser() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("new", "12345");
//		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(403)
//				.json("$.message", is("Unauthorized")).debug();
//
//	}
	
	
	@Test(priority=6)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doeXXX");
		json.put("new", "12345");
		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(404)
				.json("$.message", is("User not found")).debug();

	}
	
	
//	@Test(priority=7)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		json.put("username", "jane.doe");
//		json.put("new", "12345");
//		api.post("/studio/api/1/services/api/1/user/reset-password.json").json(json).execute().status(500)
//				.json("$.message", is("Internal server error")).debug();
//
//	}
	
	
	@Test(priority=8)
	public void testLogout() {
		Map<String, Object> json = new HashMap<>();
		api.post("/studio/api/1/services/api/1/user/logout.json").json(json).execute().status(200).debug();

	}


}
