package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by Gustavo Ortiz Alfaro
 */

public class ChangePasswordAPITest {

    private JsonTester api;

    public ChangePasswordAPITest(){
        api = new JsonTester("http","localhost",8080);
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
		json.put("password", "1234");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("OK")).debug();

	}
	
	
	@Test(priority=2)
	public void testLogout() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/logout.json").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;

	}
	
	 @Test(priority=3)
		public void loginWithJane() {
			Map<String, Object> json = new HashMap<>();
			json.put("username", "jane.doe");
			json.put("password", "1234");
			api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
		}
	 

		  @Test(priority=4)
		public void testChangePassword() {
			Map<String, Object> json = new HashMap<>();
			json.put("username", "jane.doe");
			json.put("current", "1234");
			json.put("new", "SuperSecretPassword321#");
			api.post("/studio/api/1/services/api/1/user/change-password.json")
			.json(json)
			.execute()
			.status(200)
			.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
			.json("$.message", is("OK")).debug();

		}
		  
		  @Test(priority=5)
			public void testInvalidParameters() {
				Map<String, Object> json = new HashMap<>();
				json.put("username", "jane.doe");
				json.put("InvalidParameter", "1234");
				json.put("new", "SuperSecretPassword321#");
				api.post("/studio/api/1/services/api/1/user/change-password.json")
				.json(json)
				.execute()
				.status(400)
				.json("$.message", is("Invalid parameter(s): [current]")).debug();

			}
		  
		  @Test(priority=6)
			public void testUnauthorized() {
				Map<String, Object> json = new HashMap<>();
				json.put("username", "jane.doe");
				json.put("current", "InvalidPassword");
				json.put("new", "SuperSecretPassword321#");
				api.post("/studio/api/1/services/api/1/user/change-password.json")
				.json(json)
				.execute()
				.status(401)
				.json("$.message", is("Unauthorized")).debug();

			}
		  
//		  @Test(priority=7)
//			public void testExternallyManagedUser() {
//				Map<String, Object> json = new HashMap<>();
//				json.put("username", "jane.doe");
//				json.put("current", "1234");
//				json.put("new", "SuperSecretPassword321#");
//				api.post("/studio/api/1/services/api/1/user/change-password.json")
//				.json(json)
//				.execute()
//				.status(403)
//				.json("$.message", is("Externally managed user")).debug();
//
//			}
		  
		  @Test(priority=8)
			public void tesUserNotFound() {
				Map<String, Object> json = new HashMap<>();
				json.put("username", "jane.doe");
				json.put("current", "1234");
				json.put("new", "SuperSecretPassword321#");
				api.post("/studio/api/1/services/api/1/user/change-password.json")
				.json(json)
				.execute();
//				.status(404)
//				.json("$.message", is("User not found")).debug();

			} 
		  
		  
		  
//		  @Test(priority=9)
//			public void tesInternalServerError() {
//				Map<String, Object> json = new HashMap<>();
//				json.put("username", "jane.doe");
//				json.put("current", "InvalidPassword");
//				json.put("new", "SuperSecretPassword321#");
//				api.post("/studio/api/1/services/api/1/user/change-password.json")
//				.json(json)
//				.execute()
//				.status(500)
//				.json("$.message", is("Internal server error")).debug();
//
//			} 
		  
		  
}
