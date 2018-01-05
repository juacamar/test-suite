package org.craftercms.studio.test.api.objects;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ClipboardAPI extends BaseAPI {

	public ClipboardAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testCopyItem(String siteId){
		
		api.post("studio/api/1/services/api/1/clipboard/copy-item.json").urlParam("site",siteId).execute().status(200).debug();
	}
	
	public void testGetItem(String siteId){
		
		api.get("studio/api/1/services/api/1/clipboard/get-items.json").urlParam("site",siteId).execute().status(200).debug();
	}
}
