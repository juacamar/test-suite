/**
 * 
 */
package org.craftercms.studio.test.api.objects;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

/**
 * @author chris lim
 *
 */
public class PublishAPI extends BaseAPI {


	public PublishAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

	public void testStartPublisher(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/publish/start.json")
		.json(json).execute().status(200)
				.debug();
	}
	
	public void testStartPublisherInvalidParameters(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_idnonvalid", siteId);
		
		api.post("/studio/api/1/publish/start.json")
		.json(json).execute().status(400)
				.debug();
	}

	public void testStartPublisherSiteNotFound(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId+"nonvalid");
		
		api.post("/studio/api/1/publish/start.json")
		.json(json).execute().status(404)
		.debug();
	}
	
	public void testStopPublisher(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		
		api.post("/studio/api/1/publish/stop.json")
		.json(json).execute().status(200)
				.debug();
	}
	
	public void testStopPublisherInvalidParameters(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_idnonvalid", siteId);
		
		api.post("/studio/api/1/publish/stop.json")
		.json(json).execute().status(400)
				.debug();
	}

	public void testStopPublisherSiteNotFound(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId+"nonvalid");
		
		api.post("/studio/api/1/publish/stop.json")
		.json(json).execute().status(404)
				// .json("$.message", is("site not found"))
				.debug();
	}
}
