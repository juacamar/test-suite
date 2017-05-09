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

public class GetUsersAPITest {

	private JsonTester api;

	public GetUsersAPITest() {
		api = new JsonTester("http", "localhost", 8080);
	}

	@BeforeTest
	public void login() {
		api.post("/studio/api/1/services/api/1/security/login.json").param("username", "admin").param("password", "admin")
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
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("OK"));

	}
	
	
	@Test(priority=2)
	public void testGetUsers() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/studio/api/1/services/api/1/user/get-all.json?start=0&number=25")
		.json(json)
		.execute()
		.status(200)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get-all.json?start=0&number=25"));
		
	}
	
	
	@Test(priority=3)
	public void testInternalServerError() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/studio/api/1/services/api/1/user/get-all.json?start=0&number=25")
		.json(json)
		.execute()
		.status(500)
		.debug();
		
	}
	
	@Test(priority=4)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/studio/api/1/services/api/1/user/get-all.json?start=0&number=25")
		.json(json)
		.execute()
		.status(400)
		.debug();
		
	}

}
