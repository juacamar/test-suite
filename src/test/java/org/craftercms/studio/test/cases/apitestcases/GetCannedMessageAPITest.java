package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCannedMessageAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private String siteId = "cannedMessageSiteTest";
	
	public GetCannedMessageAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);
	}

	@Test(priority = 1,groups={"getCannedMessage"})
	public void testGetCannedMessage() {
		siteManagementAPI.testGetCannedMessage(siteId);
	}

	@AfterGroups(groups={"getCannedMessage"})
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
