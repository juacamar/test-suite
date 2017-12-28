package org.craftercms.studio.test.api.objects;

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
	
	public void testGetSimpleDependencies(String siteId) {
		api.post("/studio/api/1/services/api/1/dependency/get-simple-dependencies.json")
		.urlParam("site", siteId)
		.urlParam("path", path)
		.execute().status(200);
	}
}
