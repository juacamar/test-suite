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

public class ResetPasswordAPITest {


	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;

	public ResetPasswordAPITest() {
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
	
	@Test(priority=1,groups={"resetPassword"})
	public void testResetPassword() {
		userManagementAPI.testResetPassword();
	}
	
	@Test(priority=2,groups={"resetPassword"})
	public void testResetPasswordInvalidParameters() {
		userManagementAPI.testResetPasswordInvalidParameters();
	}
	
	@Test(priority=3,groups={"resetPassword"})
	public void testUserNotFound() {
		userManagementAPI.testResetPasswordUserNotFound();
	}
	
	@AfterGroups(groups={"resetPassword"})
	public void afterTest() {
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
	}
	
	@Test(dependsOnGroups={"resetPassword"})
	public void testResetPasswordUnauthorized(){
		userManagementAPI.testResetPasswordUnauthorized();
	}
}
