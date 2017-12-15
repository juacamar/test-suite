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

public class CreateUserAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;

	public CreateUserAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		userManagementAPI = new UserManagementAPI(api,apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
	}

	@Test(priority = 1,groups={"createUser"})
	public void testCreateUser() {
		userManagementAPI.testCreateUser();
	}

	@Test(priority = 2,groups={"createUser"})
	public void testUserExist() {
		userManagementAPI.testCreateUserUserExist();
	}

	@Test(priority = 3,groups={"createUser"})
	public void testInvalidParameters() {
		userManagementAPI.testCreateUserInvalidParameters();
	}
	
	@AfterGroups(groups={"createUser"})
	public void afterTest() {
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
	}
	
	@Test(dependsOnGroups={"createUser"})
	public void testCreateUserUnauthorized(){
		userManagementAPI.testCreateUserUnauthorized();
	}
}
