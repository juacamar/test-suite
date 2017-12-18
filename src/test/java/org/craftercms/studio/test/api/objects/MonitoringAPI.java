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
public class MonitoringAPI extends BaseAPI {


	public MonitoringAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

 	public void testVersion(){
   		api.get("studio/api/1/services/api/1/monitor/version.json").execute().status(200).debug();
 	}
 	
 	public void testStatus(){
   		api.get("studio/api/1/services/api/1/monitor/status.json").execute().status(200).debug();
 	}

 	public void testMemory(){
   		api.get("studio/api/1/services/api/1/monitor/memory.json").execute().status(200).debug();
 	}
 	
}
