package org.craftercms.studio.test.api.objects;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ClipboardAPI extends BaseAPI {

	public ClipboardAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testCopyItem(String siteId){
		Map<String, Object> json = new HashMap<>();
		json.put("site", siteId);
		
		api.post("studio/api/1/services/api/1/clipboard/copy-item.json").json(json).execute().debug();
	}
}
