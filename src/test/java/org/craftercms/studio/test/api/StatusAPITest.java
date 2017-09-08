package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz
 */

public class StatusAPITest {

    private JsonTester api;

    public StatusAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
    }

    @Test
    public void testStatus(){
		api.get("/studio/api/1/services/api/1/monitor/status.json").execute().status(200);
		//.json("$.message", is("OK")).debug();
    }


 
}
