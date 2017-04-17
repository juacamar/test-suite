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

public class ForgotPasswordAPITest {

	private JsonTester api;

	public ForgotPasswordAPITest() {
		api = new JsonTester("http", "localhost", 8080);
	}

	@BeforeTest
	public void login() {
		api.post("/studio/api/1/services/api/1/user/login.json").param("username", "admin").param("password", "admin")
				.execute().status(200).header("Content-Language", is("en-US"))
				.header("Content-Type", is("application/json;charset=UTF-8")).json("$", notNullValue())
				.json("$.user.email", not(empty())).json("$.user.username", is("admin"));
	}

	@Test(priority=1)
	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("password", "SuperSecretPassword123#");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "gustavo.ortiz@craftersoftware.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("OK"));

	}
	
	@Test(priority=2)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/forgot-password.json?username=jane.doeNOTEXIST")
		.json(json)
		.execute()
		.status(404)
		.json("$.message", is("User not found"));

	}
	
	@Test(priority=3)
	public void testForgotPassword() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/forgot-password.json?username=jane.doe")
		.json(json)
		.execute()
		.status(200)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"));
	}
	
	
	@Test(priority=4)
	public void testInternalServerError() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/status.json?username=jane.doe")
		.json(json)
		.execute()
		.status(500)
		.debug();
		
	}

}
