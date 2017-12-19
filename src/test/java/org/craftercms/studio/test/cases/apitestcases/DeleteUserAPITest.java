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

public class DeleteUserAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;
	
	public DeleteUserAPITest() {
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

	@Test(priority = 4,groups={"deleteUser"})
	public void testDeleteUser() {
		userManagementAPI.testDeleteUser();
	}

	@Test(priority = 5,groups={"deleteUser"})
	public void testInvalidParameters() {
		userManagementAPI.testDeleteUserInvalidParameters();
	}

	@Test(priority = 6,groups={"deleteUser"})
	public void testUserNotFound() {
		userManagementAPI.testDeleteUserUserNotFound();
	}

	@AfterGroups(groups={"deleteUser"})
	public void afterTest() {
		securityAPI.logOutFromStudioUsingAPICall();
	}
	
	@Test(dependsOnGroups={"deleteUser"})
	public void testDeleteUserUnauthorized(){
		userManagementAPI.testDeleteUserUnauthorized();
	}
}
