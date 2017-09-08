package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;




/**
 * Created by gustavo ortiz
 */

public class VersionAPITest {

    private JsonTester api;

    public VersionAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
    }

    @Test
    public void version(){
		api.get("/studio/api/1/monitor/version.json").execute().status(200);
		//.json("$.message", is("OK")).debug();
    }


 
}
