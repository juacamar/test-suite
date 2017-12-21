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

public class GetLoggersAPITest {

	private SecurityAPI securityAPI;
	private ServerAPI serverAPI;
	
	public GetLoggersAPITest() {
		APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
		securityAPI = new SecurityAPI(api, apiConnectionManager);
		serverAPI = new ServerAPI(api, apiConnectionManager);
	}

	@BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
	}
    
    @Test(priority=1)
    public void testGetLoggers(){
    	serverAPI.testGetLoggers();
    }
    
    @AfterTest
    public void afterTest() {
    	securityAPI.logOutFromStudioUsingAPICall();
    }
}
