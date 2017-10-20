package org.craftercms.studio.test.api;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class DeleteSiteAPITest {

	private JsonTester api;
	
	private String username = "admin";
	private String password = "admin";
	private String siteId = "mysite";

	public DeleteSiteAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
	}

	@BeforeTest
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json")
		.json(json).execute().status(200);
	}

	@Test(priority = 1)
	public void testDeleteSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("siteId", siteId);
		
		api.post("/studio/api/1/services/api/1/site/delete-site.json")
		.json(json).execute().status(200).json("$", is(true))
		.debug();

	}
}
