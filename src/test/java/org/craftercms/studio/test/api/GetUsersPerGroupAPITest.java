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

public class GetUsersPerGroupAPITest {

	private JsonTester api;

	public GetUsersPerGroupAPITest() {
		api = new JsonTester("http", "localhost", 8080);
	}

	@BeforeTest
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}

	@Test(priority = 1)
	public void testCreateSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", "mySite");
		json.put("description", "My very first site!");
		json.put("blueprint", "Empty");
		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(201)
				.header("Location",
						is("http://localhost:8080/studio/api/1/services/api/1/site/get.json?site_id=mySite"))
				.json("$.message", is("OK")).debug();

	}
	
	@Test(priority=2)
	public void testCreateStudioGroup() {
		Map<String, Object> json = new HashMap<>();
		json.put("group_name", "mygroup");
		json.put("site_id", "mySite");
		json.put("description", "Content Contributors");
		api.post("studio/api/1/services/api/1/group/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/group/get.json?group_name=mygroup"))
				.json("$.message", is("OK")).debug();

	}
	
	
	@Test(priority=3)
	public void testGetGroupsPerSite() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=mySite").json(json).execute().status(200)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/group/get.json?group_name=mygroup"));
				//.json("$.message", is("OK")).debug();

	}
	
//	@Test(priority=4)
//	public void testInvalidParameters() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=mySite").json(json).execute().status(400)
//		.json("$.message", is("Invalid parameter(s)")).debug();
//
//	}

	
//	@Test(priority=5)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=mySite").json(json).execute().status(401)
//		.json("$.message", is("Unauthorized")).debug();
//
//	}
	
	
	@Test(priority=6)
	public void testSiteNotFound() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/get-per-site.json?site_id=mySite").json(json).execute().status(404)
		//.json("$.message", is("Group not found"))
		.debug();

	}
	
	
//	@Test(priority=7)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=mySite").json(json).execute().status(500)
//		.json("$.message", is("Internal server error")).debug();
//
//	}
	
	
	
}
