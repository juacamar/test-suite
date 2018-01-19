package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz 
 */

public class LogoutAPITest {

    private SecurityAPI securityAPI;
	
    public LogoutAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	
    	securityAPI = new SecurityAPI(api, apiConnectionManager);
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
    }
    
    @BeforeTest
    public void beforeTest(){
    	securityAPI.logInIntoStudioUsingAPICall();
    }
    
    @Test(priority = 1)
    public void testLogout(){
    	securityAPI.logOutFromStudioUsingAPICall();
    }


 
}
