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

public class GetUserAPITest {

	private JsonTester api;

	public GetUserAPITest() {
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
				.json("$.message", is("OK"));

	}
	
	@Test(priority=2)
	public void testGetUser() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe")
		.json(json)
		.execute()
		.status(200)
		.header("Location", is("/studio/api/1/services/api/1/user/get.json?username=jane.doe"));
		
	}
	
	@Test(priority=3)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/login.json")
		.json(json)
		.execute()
		.status(400)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
		.json("$.message", is("Invalid parameter(s)"));

		
	}
	
//	@Test(priority=4)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("/studio/api/1/services/api/1/user/login.json")
//		.json(json)
//		.execute()
//		.status(401)
//		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
//		.json("$.message", is("Unauthorized"));
//
//		
//	}
	
	@Test(priority=5)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/get.json?username=jane.doeX")
		.json(json)
		.execute()
		.status(404);

	}
	
	
	

	//Commented until you know how to invoke an internal server error.
//	@Test(priority=4)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe")
//		.json(json)
//		.execute()
//		.status(500)
//		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
//		.debug();
//		
//	}

}
