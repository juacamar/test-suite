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
public class PreviewAPI extends BaseAPI {


	public PreviewAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

 	public void testPreviewSync(String siteId){
		Map<String, Object> json = new HashMap<>();
		json.put("site", siteId);

		api.post("/studio/api/1/services/api/1/preview/sync-site.json")
		.json(json).execute().status(200).debug();
 	}
 	
}
