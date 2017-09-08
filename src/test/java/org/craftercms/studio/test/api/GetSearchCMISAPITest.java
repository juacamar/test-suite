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

public class GetSearchCMISAPITest {

	private JsonTester api;
	private String headerLocationBase;

	private String username = "admin";
	private String password = "admin";
	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";
	private String groupName1 = "contributors01";
	private String groupName2 = "contributors02";

	public GetSearchCMISAPITest() {
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
				// .urlParam("username", username)
				// .urlParam("password", password)
				.json(json).execute().status(200);
	}

	@Test(priority = 1)
	public void testCreateSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);

		api.post("/studio/api/1/services/api/1/site/create.json")
				// .urlParam("site_id", siteId)
				// .urlParam("description", description)
				// .urlParam("blueprint", blueprint)
				.json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id=" + siteId))
				.json("$.message", is("OK")).debug();
	}

	@Test(priority = 2)
	public void testCreateStudioGroup01() {
		Map<String, Object> json = new HashMap<>();
		json.put("group_name", groupName1);
		json.put("site_id", siteId);
		json.put("description", description);

		api.post("/studio/api/1/services/api/1/group/create.json")
				// .urlParam("group_name", groupName)
				// .urlParam("site_id", siteId)
				// .urlParam("description", description)
				.json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/group/get.json?group_name=" + groupName1))
				.json("$.message", is("OK")).debug();
	}

	@Test(priority = 3)
	public void testCreateStudioGroup02() {
		Map<String, Object> json = new HashMap<>();
		json.put("group_name", groupName2);
		json.put("site_id", siteId);
		json.put("description", description);

		api.post("/studio/api/1/services/api/1/group/create.json")
				// .urlParam("group_name", groupName)
				// .urlParam("site_id", siteId)
				// .urlParam("description", description)
				.json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/group/get.json?group_name=" + groupName2))
				.json("$.message", is("OK")).debug();
	}

	@Test(priority = 4)
	public void testGetSearchCMIS() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("cmis_repo_id", "repo1");
		json.put("search_term", "*");
		json.put("path", "/assets`");

		api.get("/studio/api/1/services/api/1/cmis/search.json")
//		.urlParam("site_id", siteId)
//		.urlParam("cmis_repo_id", "repo1")
//		.urlParam("search_term", "*")
//		.urlParam("path", "/assets`")
		.json(json).execute().status(200);
		// .json("$.message", is("OK")).debug();

	}

	@Test(priority = 5)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("cmis_repo_idnonvalid", "repo1");
		json.put("search_term", "*");
		json.put("path", "/assets`");

		api.get("/studio/api/1/services/api/1/cmis/search.json")
//		.urlParam("site_id", siteId)
//		.urlParam("cmis_repo_idnonvalid", "repo1")
//	    .urlParam("search_term", "*")
//	    .urlParam("path", "/assets`")
	    .json(json).execute().status(400).json("$.message", is("Invalid parameter(s): [cmis_repo_id]")).debug();

	}

	// @Test(priority=6)
	// public void testUnauthorized() {
	// Map<String, Object> json = new HashMap<>();
	// api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=mySite").json(json).execute().status(401)
	// .json("$.message", is("Unauthorized")).debug();
	//
	// }

	// @Test(priority=7)
	// public void testSiteNotFound() {
	// Map<String, Object> json = new HashMap<>();
	// api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=gfgfdgfdgfdfgd").json(json).execute().status(404)
	// .json("$.message", is("Site not found")).debug();
	//
	// }

	// @Test(priority=8)
	// public void testInternalServerError() {
	// Map<String, Object> json = new HashMap<>();
	// api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=`````").json(json).execute().status(500)
	// .json("$.message", is("Internal server error")).debug();
	//
	// }

}
