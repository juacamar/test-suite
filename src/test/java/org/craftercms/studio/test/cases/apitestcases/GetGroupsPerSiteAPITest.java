package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.GroupManagementAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class GetGroupsPerSiteAPITest {

	
	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private GroupManagementAPI groupManagementAPI;
	private String siteId="siteGetGroupsPerSiteAPITest";

	public GetGroupsPerSiteAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api,apiConnectionManager);
		groupManagementAPI = new GroupManagementAPI(api,apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);
		groupManagementAPI.testCreateStudioGroup01(siteManagementAPI.getSiteId());
		groupManagementAPI.testCreateStudioGroup02(siteManagementAPI.getSiteId());
	}

	@Test(priority = 1,groups={"getGroupsPerSite"})
	public void testGetGroupsPerSite() {
		groupManagementAPI.testGetGroupsPerSite(siteManagementAPI.getSiteId());
	}
	
	@Test(priority = 2,groups={"getGroupsPerSite"})
	public void testGetGroupsPerSiteInvalidParameters() {
		groupManagementAPI.testGetGroupsPerSiteInvalidParameters(siteManagementAPI.getSiteId());
	}
	
	@Test(priority = 3,groups={"getGroupsPerSite"})
	public void testGetGroupsPerSiteNotFound() {
		groupManagementAPI.testGetGroupsPerSiteNotFound(siteManagementAPI.getSiteId());
	}
	
	@AfterGroups(groups={"getGroupsPerSite"})
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}
	
	@Test(dependsOnGroups={"getGroupsPerSite"})
	public void testGetGroupsPerSiteUnauthorized(){
		groupManagementAPI.testGetGroupsPerSiteUnauthorized(siteManagementAPI.getSiteId());
	}
}
