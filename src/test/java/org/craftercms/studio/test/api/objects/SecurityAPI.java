/**
 * 
 */
package org.craftercms.studio.test.api.objects;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.JsonTester;

/**
 * @author luishernandez
 *
 */
public class SecurityAPI extends BaseAPI{
	
	private String password;
	private String userName;

	public SecurityAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.api.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.api.password");
	}
	
	public void logInIntoStudioUsingAPICall() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", userName);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}

	public void logOutFromStudioUsingAPICall() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", userName);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/logout.json").json(json).execute().status(200);
	}
	
	public void loginWithOtherUser(String username, String password) {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}
	
	public void logOutFromStudioOtherUserUsingAPICall(String username, String password) {
		Map<String, Object> json = new HashMap<>();
		json.put("username", username);
		json.put("password", password);
		api.post("/studio/api/1/services/api/1/security/logout.json").json(json).execute().status(200);
	}
}
