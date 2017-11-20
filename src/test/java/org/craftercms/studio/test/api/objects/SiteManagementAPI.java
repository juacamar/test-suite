package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class SiteManagementAPI extends BaseAPI{
	
	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";

	
	public SiteManagementAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

	public void testCreateSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);

		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id=" + siteId))
				.json("$.message", is("OK")).debug();
	}
	
	public void testDeleteSite() {
		Map<String, Object> json = new HashMap<>();
		json.put("siteId", siteId);
		
		api.post("/studio/api/1/services/api/1/site/delete-site.json")
		.json(json).execute().status(200).json("$", is(true))
		.debug();

	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
}
