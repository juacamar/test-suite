package org.craftercms.studio.test.api.objects;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class DeploymentAPI extends BaseAPI{

	public DeploymentAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testBulkGoLive(String siteId) {
		
		api.post("/studio/api/1/services/api/1/deployment/bulk-golive.json")
		.urlParam("site", siteId)
		.urlParam("path", "/site/website")
		.urlParam("environment", "Live")
		.execute().status(200)
		.debug();
	}
	
	public void testGetAvailablePublishingChannels(String siteId) {
		
		api.get("/studio/api/1/services/api/1/deployment/get-available-publishing-channels.json")
		.urlParam("site", siteId)
		.execute().status(200)
		.debug();
	}

	public void testGetDeploymentHistory(String siteId) {
	
		api.get("/studio/api/1/services/api/1/deployment/get-deployment-history.json")
		.urlParam("site", siteId)
		.urlParam("days", "30")
		.urlParam("num", "10")
		.urlParam("filterType", "all")
		.execute().status(200)
		.debug();
	}
	
	public void testGetScheduledItems(String siteId) {
		
		api.get("/studio/api/1/services/api/1/deployment/get-scheduled-items.json")
		.urlParam("site", siteId)
		.urlParam("sort", "eventDate")
		.urlParam("ascending", "false")
		.urlParam("filterType", "all")
		.execute().status(200)
		.debug();
	}

}
