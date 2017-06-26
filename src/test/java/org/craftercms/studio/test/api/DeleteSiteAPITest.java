package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class DeleteSiteAPITest {

	private JsonTester api;

	public DeleteSiteAPITest() {
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
	public void testDeleteSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("siteId", "mySite");
		api.post("/studio/api/1/services/api/1/site/delete-site.json").json(json).execute().status(200).debug();

	}
}
