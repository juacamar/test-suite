package org.craftercms.studio.test.cases.api;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.UserManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
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

	@Test(priority = 4)
	public void testDeleteUser() {
		userManagementAPI.testDeleteUser();
	}

	@Test(priority = 5)
	public void testInvalidParameters() {
		userManagementAPI.testDeleteUserInvalidParameters();
	}

	@Test(priority = 6)
	public void testUserNotFound() {
		userManagementAPI.testDeleteUserUserNotFound();
	}

	@AfterTest
	public void afterTest() {
		securityAPI.logOutFromStudioUsingAPICall();
	}

}
