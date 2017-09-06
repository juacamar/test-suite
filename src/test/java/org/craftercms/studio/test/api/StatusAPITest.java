package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



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
    	Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/monitor/status.json").json(json).execute().status(200);
		//.json("$.message", is("OK")).debug();
    }


 
}
