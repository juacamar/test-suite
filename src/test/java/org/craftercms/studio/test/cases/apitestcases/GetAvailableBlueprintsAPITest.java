package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetAvailableBlueprintsAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	
	public GetAvailableBlueprintsAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
	}

	@Test(priority = 1,groups={"getAvailableBlueprints"})
	public void testGetAvailableBlueprints() {
		siteManagementAPI.testGetAvailableBlueprints();
	}

	@AfterGroups(groups={"getAvailableBlueprints"})
	public void afterTest() {
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
