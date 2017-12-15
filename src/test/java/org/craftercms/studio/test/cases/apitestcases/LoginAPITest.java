package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz 
 */

public class LoginAPITest {

    private SecurityAPI securityAPI;
	
    public LoginAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	
    	securityAPI = new SecurityAPI(api, apiConnectionManager);
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
    }

    @Test(priority = 1)
    public void testLogin(){
    	securityAPI.logInIntoStudioUsingAPICall();
    }

    @AfterTest
    public void afterTest(){
    	securityAPI.logOutFromStudioUsingAPICall();
    }
 
}
