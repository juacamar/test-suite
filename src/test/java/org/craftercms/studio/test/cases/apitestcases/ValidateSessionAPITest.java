package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Created by gustavo ortiz 
 */

public class ValidateSessionAPITest {

    private SecurityAPI securityAPI;
	
    public ValidateSessionAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	
    	securityAPI = new SecurityAPI(api, apiConnectionManager);
    }

    @BeforeTest
    public void beforeTest(){
    	securityAPI.logInIntoStudioUsingAPICall();
    }
    
    @Test(priority=1)
    public void validateSession(){
    	securityAPI.testValidateSession();
    }
    
    @Test(priority=2)
    public void testValidateSessionUnauthorized(){
    	securityAPI.logOutFromStudioUsingAPICall();
    	securityAPI.testValidateSessionUnauthorized();
    }
 
}
