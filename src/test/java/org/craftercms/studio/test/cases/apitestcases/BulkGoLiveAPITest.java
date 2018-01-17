package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.ContentAssetAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.api.objects.DeploymentAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BulkGoLiveAPITest {
	
	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private DeploymentAPI deploymentAPI;
	private ContentAssetAPI contentAssetAPI;
	
	public BulkGoLiveAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
		deploymentAPI = new DeploymentAPI(api, apiConnectionManager);
		contentAssetAPI = new ContentAssetAPI(api, apiConnectionManager);
	}
	
	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteManagementAPI.getSiteId());
		contentAssetAPI.testWriteContent(siteManagementAPI.getSiteId());
		contentAssetAPI.testWriteContent(siteManagementAPI.getSiteId(), "site/website/folder1");
	}

	@Test(priority = 1)
	public void testBulkGoLive() {
		deploymentAPI.testBulkGoLive(siteManagementAPI.getSiteId());
	}
	
	@AfterTest
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteManagementAPI.getSiteId());
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
