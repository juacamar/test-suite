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

public class CreateUserAPITest {

	private JsonTester api;
	private String headerLocationBase;

	private String username = "admin";
	private String password = "admin";
//	private String siteId = "mysite";
//	private String description = "Description!";
//	private String blueprint = "empty";

	private String newusername = "jane.doe";
	private String newpassword = "SuperSecretPassword123#";
	private String first_name = "Jane";
	private String last_name = "Doe";
	private String email = "jane@example.com";

	public CreateUserAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		headerLocationBase = apiConnectionManager.getHeaderLocationBase();
	}

	@BeforeTest
	public void login() {
	 	Map<String, Object> json = new HashMap<>();
			json.put("username", username);
			json.put("password", password);
			api.post("/studio/api/1/services/api/1/security/login.json")
			//.urlParam("username", username)
			//.urlParam("password", password)
			.json(json).execute().status(200);
	}

	@Test(priority = 1)
	public void testCreateUser() {

		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		
		api.post("/studio/api/1/services/api/1/user/create.json")
//		.urlParam("username", newusername)
//		.urlParam("password", newpassword)
//		.urlParam("first_name", first_name)
//		.urlParam("last_name", last_name)
//		.urlParam("email", email)
		.json(json).execute().status(201)
				.header("Location", is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?user="+newusername))
				.json("$.message", is("OK")).debug();
	}

	@Test(priority = 2)
	public void testUserExist() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", newusername);
		json.put("password", newpassword);
		json.put("first_name", first_name);
		json.put("last_name", last_name);
		json.put("email", email);
		
		
		api.post("/studio/api/1/services/api/1/user/create.json")
//		.urlParam("username", newusername)
//		.urlParam("password", newpassword)
//		.urlParam("first_name", first_name)
//		.urlParam("last_name", last_name)
//		.urlParam("email", email)
		.json(json).execute().status(409)
				.header("Location", is(headerLocationBase + "/studio/api/1/services/api/1/user/get.json?user="+newusername))
				.json("$.message", is("User already exists")).debug();

	}

	@Test(priority = 3)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamenonvalid", newusername);
		json.put("passwordnonvalid", newpassword);
		json.put("first_namenonvalid", first_name);
		json.put("last_namenonvalid", last_name);
		json.put("emailnonvalid", email);
		
		api.post("/studio/api/1/services/api/1/user/create.json")
//		.urlParam("usernamenonvalid", newusername)
//		.urlParam("passwordnonvalid", newpassword)
//		.urlParam("first_namenonvalid", first_name)
//		.urlParam("last_namenonvalid", last_name)
//		.urlParam("emailnonvalid", email)
		.json(json).execute().status(400)
				.json("$.message", is("Invalid parameter(s): [username, password, firstname, lastname, email]"))
				.debug();

	}

	// @Test(priority=4)
	// public void testInternalServerError(){
	// Map<String,Object> json=new HashMap<>();
	// json.put("usernamed", "jane.doe");
	// json.put("passwordd", "SuperSecretPassword123#");
	// json.put("first_named", "Jane");
	// json.put("last_named", "Doe");
	// json.put("emaild", "jane@example.com");
	// api.post("/studio/api/1/services/api/1/user/create.json")
	// .json(json)
	// .execute()
	// .status(500)
	// .header("Location",is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
	// .json("$.message", is("Internal server error")).debug();
	//
	//
	// }

	@Test(priority = 5)
	public void testLogout() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		
		api.post("/studio/api/1/services/api/1/security/logout.json")
//		.urlParam("username", username)
//		.urlParam("password", password)
		.json(json).execute().status(200).json("$.message", is("OK")).debug();
		

	}

}
