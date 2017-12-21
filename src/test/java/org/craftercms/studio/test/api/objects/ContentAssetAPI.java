package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ContentAssetAPI extends BaseAPI{

	private String contentPath = "";
	private String folderName = "newFolder";
	
	public ContentAssetAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testContentExists(String siteId) {
				
		api.get("/studio/api/1/services/api/1/content/content-exists.json")
		.urlParam("site", siteId).urlParam("path",contentPath).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/content-exists.json?site="+siteId+"&path="+contentPath))
		.debug();
	}
	
	public void testCreateFolder(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site", siteId);
		json.put("path", contentPath);
		json.put("name", folderName);
		
		api.post("/studio/api/1/services/api/1/content/create-folder.json").json(json).execute().status(200).debug();
	}
}
