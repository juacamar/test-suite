package org.craftercms.studio.test.cases.api;

import org.craftercms.studio.test.api.objects.GroupManagementAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class GetGroupAPITest {

	private APIConnectionManager apiConnectionManager;
	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private GroupManagementAPI groupManagementAPI;
	private JsonTester api;

	public GetGroupAPITest() {
		apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api,apiConnectionManager);
		groupManagementAPI = new GroupManagementAPI(api,apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite();
		groupManagementAPI.testCreateStudioGroup01(siteManagementAPI.getSiteId());
	}

	@Test(priority = 1)
	public void testGetGroup() {
		groupManagementAPI.testGetGroup(siteManagementAPI.getSiteId());
	}

	@Test(priority = 2)
	public void testInvalidParameter() {
		groupManagementAPI.testGetGroupInvalidParameter(siteManagementAPI.getSiteId());
	}

	@Test(priority = 3)
	public void testGroupNotFound() {
		groupManagementAPI.testGetGroupGroupNotFound(siteManagementAPI.getSiteId());
	}

	@AfterTest
	public void afterTest() {
		siteManagementAPI.testDeleteSite();
		securityAPI.logOutFromStudioUsingAPICall();
	}

}
