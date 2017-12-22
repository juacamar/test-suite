package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.MonitoringAPI;
import org.craftercms.studio.test.api.objects.SecurityAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz
 */

public class StatusAPITest {

    private MonitoringAPI monitoringAPI;
    private SecurityAPI securityAPI;
    
    public StatusAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	
		securityAPI = new SecurityAPI(api, apiConnectionManager);
    	monitoringAPI = new MonitoringAPI(api, apiConnectionManager);
    }
    
    @BeforeTest
	public void beforeTest() {
		securityAPI.logInIntoStudioUsingAPICall();
	}

    @Test(priority=1)
    public void testStatus(){
    	monitoringAPI.testStatus();
    }
    
    @AfterTest
	public void afterTest() {
		securityAPI.logOutFromStudioUsingAPICall();
	}
}
