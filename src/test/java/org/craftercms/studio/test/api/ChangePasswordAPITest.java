package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Gustavo Ortiz Alfaro
 */

public class ChangePasswordAPITest {

    private JsonTester api;
	private String headerLocationBase;
	
	private String username = "admin";
	private String password = "admin";
//	private String siteId = "mysite";
//	private String description = "Description!";
//	private String blueprint = "empty";
//	private String groupName = "contributors";

	private String newusername = "jane.doe";
	private String newpassword= "SuperSecretPassword123#";
	private String first_name = "Jane";
	private String last_name= "Doe";
	private String email= "jane@example.com";
	
	
    public ChangePasswordAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
		headerLocationBase=apiConnectionManager.getHeaderLocationBase();
    }

    @BeforeTest
	public void login() {
    	this.loginAsAdmin();
	}

	@Test(priority=1)
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
	
	
	@Test(priority=2)
	public void testLogout() {
		logoutFromUser(username,password);
	}
	
	 @Test(priority=3)
		public void loginWithJane() {
		 Map<String, Object> json = new HashMap<>();
			json.put("username", newusername);
			json.put("password", newpassword);
			
			api.post("/studio/api/1/services/api/1/security/login.json")
//			.urlParam("username", newusername)
//			.urlParam("password", newpassword)
			.json(json).execute().status(200);
		}
	 

		  @Test(priority=4)
		public void testChangePassword() {
			  Map<String, Object> json = new HashMap<>();
				json.put("username", newusername);
				json.put("current", newpassword);
				json.put("new", newusername+"#");
				
			api.post("/studio/api/1/services/api/1/user/change-password.json")
//			.urlParam("username", newusername)
//			.urlParam("current", newpassword)
//			.urlParam("new", newusername+"#")
			.json(json).execute()
			.status(200)
			.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/user/get.json?username="+newusername))
			.json("$.message", is("OK")).debug();

		}
		  
		  @Test(priority=5)
			public void testInvalidParameters() {
			  Map<String, Object> json = new HashMap<>();
				json.put("username", newusername);
				json.put("currentnon-valid", newpassword);
				json.put("new", newusername+"#");
				
				api.post("/studio/api/1/services/api/1/user/change-password.json")
//				.urlParam("username", newusername)
//				.urlParam("currentnon-valid", newpassword)
//				.urlParam("new", newusername+"#")
				.json(json).execute()
				.status(400)
				.json("$.message", is("Invalid parameter(s): [current]")).debug();

			}
		  
		  @Test(priority=6)
			public void testUnauthorized() {
			  Map<String, Object> json = new HashMap<>();
				json.put("username", newusername);
				json.put("current", newpassword+"non-valid");
				json.put("new", newusername+"#");
				
				api.post("/studio/api/1/services/api/1/user/change-password.json")
//				.urlParam("username", newusername)
//				.urlParam("current", newpassword+"non-valid")
//				.urlParam("new", newusername+"#")
				.json(json).execute()
				.status(401)
				.json("$.message", is("Unauthorized")).debug();
				
				logoutFromUser(newusername,newusername+"#");

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
			  loginAsAdmin();
			  
			  Map<String, Object> json = new HashMap<>();
				json.put("username", newusername+"non-valid");
				json.put("new", newusername+"#");
				
				api.post("/studio/api/1/services/api/1/user/reset-password.json")
//				.urlParam("username", newusername+"non-valid")
//				.urlParam("current", newpassword)
//				.urlParam("new", newusername+"#")
				.json(json).execute()
				.status(404)
				.json("$.message", is("User not found")).debug();

			} 
		  
		  public void loginAsAdmin() {
			  	Map<String, Object> json = new HashMap<>();
				json.put("username", username);
				json.put("password", password);
				api.post("/studio/api/1/services/api/1/security/login.json")
				//.urlParam("username", username)
				//.urlParam("password", password)
				.json(json).execute().status(200);
		  }
		  
		  public void logoutFromUser(String username, String password) {
			  Map<String, Object> json = new HashMap<>();
				json.put("username", username);
				json.put("password", password);
				
				api.post("/studio/api/1/services/api/1/security/logout.json")
//				.urlParam("username", username)
//				.urlParam("password", password)
				.json(json).execute().status(200)
				.json("$.message", is("OK")).debug();
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
