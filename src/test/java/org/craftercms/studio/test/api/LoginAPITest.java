package org.craftercms.studio.test.api;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;

/**
 * Created by gustavo ortiz 
 */

public class LoginAPITest {

    private JsonTester api;
    private String username = "admin";
	private String password = "admin";
	
    public LoginAPITest(){
    	APIConnectionManager apiConnectionManager = new APIConnectionManager();
		api = new JsonTester(apiConnectionManager.getProtocol()
				, apiConnectionManager.getHost(),apiConnectionManager.getPort());
    }

    @Test
    public void login(){
    	Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json")
		//.urlParam("username", username)
		//.urlParam("password", password)
		.json(json).execute().status(200);
    }


 
}
