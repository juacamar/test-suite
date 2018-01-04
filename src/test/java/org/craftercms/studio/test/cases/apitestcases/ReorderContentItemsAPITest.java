package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.ContentAssetAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.SiteManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReorderContentItemsAPITest {
	
	private SiteManagementAPI siteManagementAPI;
	private SecurityAPI securityAPI;
	private ContentAssetAPI contentAssetAPI;

	public ReorderContentItemsAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	securityAPI = new SecurityAPI(api, apiConnectionManager);
    	contentAssetAPI = new ContentAssetAPI(api, apiConnectionManager);
    	siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
	}
	
	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteManagementAPI.getSiteId());
		contentAssetAPI.testCreateFolder(siteManagementAPI.getSiteId(),"testfolder1");
		contentAssetAPI.testCreateFolder(siteManagementAPI.getSiteId(),"testfolder2");
		contentAssetAPI.testWriteContent(siteManagementAPI.getSiteId(),contentAssetAPI.getContentPath()+"/testfolder1");
		contentAssetAPI.testWriteContent(siteManagementAPI.getSiteId(),contentAssetAPI.getContentPath()+"/testfolder2");
	}

	@Test(priority = 1)
	public void testReorderContentItems() {
		
		contentAssetAPI.testReorderContentItems(siteManagementAPI.getSiteId(),
				contentAssetAPI.getContentPath()+"/testfolder1/index.xml",
				contentAssetAPI.getContentPath()+"/testfolder2/index.xml");
	}
	
	@AfterTest
	public void afterTest(){
		siteManagementAPI.testDeleteSite(siteManagementAPI.getSiteId());
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
