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

public class GetUserPerSiteAPITest {

	private JsonTester api;

	public GetUserPerSiteAPITest() {
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
    public void testCreateSite(){
        Map<String,Object> json=new HashMap<>();
        json.put("blueprintName","website_editorial");
        json.put("description", "test");
        json.put("siteId", "test");
        json.put("siteName", "test");
        api.post("/studio/api/1/services/api/1/site/create-site.json")
                .json(json)
                .execute()
                .status(200);
        api.get("/studio/api/1/services/api/1/site/exists.json")
                .urlParam("site", "test")
                .execute()
                .json("$.exists",is(true));
        
    }
	

	
	@Test(priority=2)
	public void testSiteNotFound() {
		Map<String, Object> json = new HashMap<>();
		api.get("studio/api/1/services/api/1/user/get-per-site.json?site_id=NotExist")
		.json(json)
		.execute()
		.status(404);
		//.json("$.message", is("Site not found")).debug();
		
	}
	
	@Test(priority=3)
	public void testGetUsersPerSite() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=test")
		.json(json)
		.execute()
		.status(200)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get-per-site.json?site_id=site&start=0&number=25"))
		.debug();
		
	}
	
	@Test(priority=4)
	public void testInternalServerError() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe")
		.json(json)
		.execute()
		.status(500)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"))
		.debug();
		
	}

}
