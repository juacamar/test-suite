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

public class GetUserPerSiteAPITest {

	private JsonTester api;

	public GetUserPerSiteAPITest() {
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
		api.get("/studio/api/1/services/api/1/site/exists.json").urlParam("site", "mySite").execute().json("$.exists",
				is(true));

	}

	@Test(priority = 2)
	public void testSiteNotFound() {
		Map<String, Object> json = new HashMap<>();
		api.get("studio/api/1/services/api/1/user/get-per-site.json?site_id=NotExist").json(json).execute().status(404)
		.json("$.message", is("Site not found")).debug();

	}

	@Test(priority = 3)
	public void testGetUsersPerSite() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=test").json(json)
				.execute().status(200)
				.header("Location",
						is("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=site&start=0&number=25"))
				.debug();

	}

	// Commented until you know how to invoke an internal server error.

	// @Test(priority=4)
	// public void testInternalServerError() {
	// Map<String, Object> json = new HashMap<>();
	// api.get("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe")
	// .json(json)
	// .execute()
	// .status(500)
	// .header("Location",
	// is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
	// .debug();
	//
	// }

}
