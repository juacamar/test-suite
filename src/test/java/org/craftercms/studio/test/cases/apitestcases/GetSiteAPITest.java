package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro
 */

public class GetSiteAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private String siteId="siteGetSiteAPITest";
	
	public GetSiteAPITest() {
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

	@Test(priority = 1,groups={"getSite"})
	public void testGetSite() {
		siteManagementAPI.testGetSite();
	}

	@Test(priority = 2,groups={"getSite"})
	public void testGetSiteInvalidParameters() {
		siteManagementAPI.testGetSiteInvalidParameters();
	}
	
	@Test(priority = 3,groups={"getSite"})
	public void testGetSiteSiteNotFound() {
		siteManagementAPI.testGetSiteSiteNotFound();
	}

	@AfterGroups(groups={"getSite"})
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}

	@Test(dependsOnGroups={"getSite"}) 
	public void testGetSiteUnauthorized(){
		siteManagementAPI.testGetSiteUnauthorized();
	}
}
