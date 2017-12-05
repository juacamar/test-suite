package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.UserManagementAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.FakeSMTPServerManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class ForgotPasswordAndValidateTokenAndSetPasswordAPITest {

	private SecurityAPI securityAPI;
	private UserManagementAPI userManagementAPI;
	private FakeSMTPServerManager fakeSMTPServerManager;
    private boolean isTheLastPassed=false;
	private boolean isTheFirstTest=true;
    
	public ForgotPasswordAndValidateTokenAndSetPasswordAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api,apiConnectionManager);
		userManagementAPI = new UserManagementAPI(api,apiConnectionManager);
		fakeSMTPServerManager = new FakeSMTPServerManager();
	}

	@BeforeMethod
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
		if(isTheFirstTest) {
		userManagementAPI.testCreateUser();
		fakeSMTPServerManager.startFakeSMTPServer();}
		
	}
	
	@Test(priority=1)
	public void testForgotPassword() {
		
		userManagementAPI.testForgotPassword();
		
	}
	
	@Test(priority=2)
	public void testForgotPasswordUserNotFound() {
		userManagementAPI.testForgotPasswordUserNotFound();

	}
	
	@Test(priority=3)
	public void testForgotPasswordInternalServerError() {
		userManagementAPI.testForgotPasswordInternalServerError();
	}

	@Test(priority = 4)
	public void testValidateToken() {
		userManagementAPI.testValidateToken();
	}

	@Test(priority = 5)
	public void testValidateTokenInvalidParameters() {
		userManagementAPI.testValidateTokenInvalidParameters();
	}
	
	@Test(priority = 6)
	public void testSetPassword() {
		userManagementAPI.testSetPassword();
	}

	@Test(priority = 7)
	public void testSetPasswordInvalidParameters() {
		userManagementAPI.testSetPasswordInvalidParameters();
		isTheLastPassed=true;
	}
	@AfterMethod
	public void afterTest() {	
		if(isTheFirstTest)
		{
		userManagementAPI.setToken(fakeSMTPServerManager.getRecentlyGeneratedToken());
		fakeSMTPServerManager.stopFakeSMTPServer();
		isTheFirstTest=false;
		}
		
		if(isTheLastPassed) {
		userManagementAPI.testDeleteUser();
		securityAPI.logOutFromStudioUsingAPICall();
		}
	}
}
