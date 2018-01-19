package org.craftercms.studio.test.api.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class DependencyAPI extends BaseAPI{

	private String path = "/site/website";
	
	public DependencyAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testGetDependantItems(String siteId) {
		api.post("/studio/api/1/services/api/1/dependency/get-dependant.json")
		.urlParam("site", siteId)
		.urlParam("path", path)
		.execute().status(200);
	}
	
	public void testGetDependencies(String siteId) {
		
		Map<String, Object> jsonInner = new HashMap<>();
		jsonInner.put("uri", "/site/website/index.xml");
		List<Map<String, Object>> json = new ArrayList<Map<String, Object>>();
		json.add(jsonInner);
		
		api.post("/studio/api/1/services/api/1/dependency/get-dependencies.json")
		.urlParam("site", siteId).json(json).execute().status(200);
	}
	
	public void testGetSimpleDependencies(String siteId) {
		api.post("/studio/api/1/services/api/1/dependency/get-simple-dependencies.json")
		.urlParam("site", siteId)
		.urlParam("path", path)
		.execute().status(200);
	}
}
