package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.PublishAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by chris lim
 */

public class StopPublisherAPITest {

	private SiteManagementAPI siteManagementAPI;
	private SecurityAPI securityAPI;
	private PublishAPI publishAPI;

	public StopPublisherAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	securityAPI = new SecurityAPI(api, apiConnectionManager);
    	publishAPI = new PublishAPI(api, apiConnectionManager);
    	siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteManagementAPI.getSiteId());
	}

	@Test(priority = 1,groups={"stopPublisher"})
	public void testStopPublisher() {
		publishAPI.testStopPublisher(siteManagementAPI.getSiteId());
	}

	@Test(priority = 2,groups={"stopPublisher"})
	public void testStopPublisherInvalidParameters() {
		publishAPI.testStopPublisherInvalidParameters(siteManagementAPI.getSiteId());
	}

	@Test(priority = 3,groups={"stopPublisher"})
	public void testStopPublisherSiteNotFound() {
		publishAPI.testStopPublisherSiteNotFound(siteManagementAPI.getSiteId());
	}
	
	@AfterGroups(groups={"stopPublisher"})
	public void afterTest(){
		siteManagementAPI.testDeleteSite(siteManagementAPI.getSiteId());
		securityAPI.logOutFromStudioUsingAPICall();
	}
	
	@Test(dependsOnGroups={"stopPublisher"})
	public void testStopPublisherUnauthorized(){
		publishAPI.testStopPublisherUnauthorized(siteManagementAPI.getSiteId());
	}

}
