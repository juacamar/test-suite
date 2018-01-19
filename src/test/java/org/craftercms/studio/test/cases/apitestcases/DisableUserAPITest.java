package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.UserManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class DisableUserAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;

	
	public DisableUserAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		userManagementAPI = new UserManagementAPI(api,apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		userManagementAPI.testCreateUser();
	}

	@Test(priority = 1,groups={"disableUser"})
	public void testDisableUser() {
		userManagementAPI.testDisableUser();
	}

	@Test(priority = 2,groups={"disableUser"})
	public void testInvalidParameters() {
		userManagementAPI.testDisableUserInvalidParameters();

	}

	@Test(priority = 3,groups={"disableUser"})
	public void testUserNotFound() {
		userManagementAPI.testDisableUserUserNotFound();
	}
	
	@AfterGroups(groups={"disableUser"})
	public void afterTest() {
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
	}

	@Test(dependsOnGroups={"disableUser"})
	public void testDisableUserUnauthorized(){
		userManagementAPI.testDisableUserUnauthorized();
	}
}
