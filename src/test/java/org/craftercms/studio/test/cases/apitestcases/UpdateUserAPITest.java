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

public class UpdateUserAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;
	
	public UpdateUserAPITest() {
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

	@Test(priority=1,groups={"updateUser"})
	public void testUserUpdate() {
		userManagementAPI.testUpdateUser();
	}
	
	@Test(priority=2,groups={"updateUser"})
	public void testUpdateUserInvalidParameters() {
		userManagementAPI.testUpdateUserInvalidParameters();
	}
	
	@Test(priority=3,groups={"updateUser"})   
	public void testUserNotFound() {
		userManagementAPI.testUpdateUserUserNotFound();
	}	
	
	@AfterGroups(groups={"updateUser"})
	public void afterTest() {
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
	}
	
	@Test(dependsOnGroups={"updateUser"})
	public void testUpdateUserUnauthorized(){
		userManagementAPI.testUpdateUserUnauthorized();
	}
}
