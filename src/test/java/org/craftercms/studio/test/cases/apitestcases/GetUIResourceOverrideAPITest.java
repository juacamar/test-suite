package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.api.objects.ServerAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by chris lim
 */

public class GetUIResourceOverrideAPITest {

    private ServerAPI serverAPI;
    private SecurityAPI securityAPI;
    
    public GetUIResourceOverrideAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	
		serverAPI = new ServerAPI(api, apiConnectionManager);
		securityAPI = new SecurityAPI(api, apiConnectionManager);
    }

    @BeforeTest
    public void beforeTest(){
    	securityAPI.logInIntoStudioUsingAPICall();
    }
    
    @Test(priority=1)
    public void testGetUIResourceOverride(){
    	serverAPI.testGetUIResourceOverride();
    }
    
    @AfterTest
    public void afterTest(){
    	securityAPI.logOutFromStudioUsingAPICall();
    }
}
