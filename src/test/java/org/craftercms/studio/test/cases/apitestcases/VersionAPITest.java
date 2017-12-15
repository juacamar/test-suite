package org.craftercms.studio.test.cases.apitestcases;

import org.craftercms.studio.test.api.objects.MonitoringAPI;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz
 */

public class VersionAPITest {

    private MonitoringAPI monitoringAPI;
    
    public VersionAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		JsonTester api = new JsonTester(apiConnectionManager.getProtocol(), apiConnectionManager.getHost(),
				apiConnectionManager.getPort());
    	
    	monitoringAPI = new MonitoringAPI(api, apiConnectionManager);
    }

    @Test(priority=1)
    public void testVersion(){
    	monitoringAPI.testVersion();
    }
}
