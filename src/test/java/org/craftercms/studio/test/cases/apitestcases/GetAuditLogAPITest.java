package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.AuditAPI;
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

public class GetAuditLogAPITest {

	private SecurityAPI securityAPI;
	private SiteManagementAPI siteManagementAPI;
	private AuditAPI auditAPI;
	private String siteId="siteGetAuditLogAPITest";
	
	public GetAuditLogAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		siteManagementAPI = new SiteManagementAPI(api, apiConnectionManager);
		auditAPI = new AuditAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		siteManagementAPI.testCreateSite(siteId);

	}

	@Test(priority = 1,groups={"getAuditLog"})
	public void testGetAuditLog() {
		auditAPI.testGetAuditLog(siteManagementAPI.getSiteId());
	}

	@Test(priority = 2,groups={"getAuditLog"})
	public void testGetAuditLogInvalidParameters() {
		auditAPI.testGetAuditLogInvalidParameter(siteManagementAPI.getSiteId());
	}

	@Test(priority = 3,groups={"getAuditLog"})
	public void testGetAuditLogSiteNotFound() {
		auditAPI.testGetAuditLogSiteNotFound(siteManagementAPI.getSiteId());
	}

	@AfterGroups(groups={"getAuditLog"})
	public void afterTest() {
		siteManagementAPI.testDeleteSite(siteId);
		securityAPI.logOutFromStudioUsingAPICall();
	}

	@Test(dependsOnGroups={"getAuditLog"})
	public void testGetAuditLogUnauthorized() {
		auditAPI.testGetAuditLogUnauthorized(siteManagementAPI.getSiteId());
	}
}
