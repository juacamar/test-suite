/**
 * 
 */
package org.craftercms.studio.test.api.objects;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

/**
 * @author chris lim
 *
 */
public class ServerAPI extends BaseAPI {


	public ServerAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

 	public void testGetAvailableLanguages(){
   		api.get("studio/api/1/services/api/1/server/get-available-languages.json").execute().status(200).debug();
 	}
 	
 	public void testGetLoggers(){
   		api.get("studio/api/1/services/api/1/server/get-loggers.json").execute().status(200).debug();
 	}
 	
 	public void testGetUIResourceOverride(){

   		api.get("studio/api/1/services/api/1/server/get-ui-resource-override.json").urlParam("resource", "logo.jpg")
   		.execute().status(200).debug();
 	}
 	
 	public void testSetLoggerState(){
 		String logger = "org.craftercms.studio.impl.v1.service.content.ContentServiceImpl";
   		api.get("studio/api/1/services/api/1/server/set-logger-state.json").urlParam("logger", logger).urlParam("level", "debug")
   		.execute().status(200).debug();
 	}
}
