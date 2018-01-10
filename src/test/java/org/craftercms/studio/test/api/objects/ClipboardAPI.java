package org.craftercms.studio.test.api.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ClipboardAPI extends BaseAPI {

	public ClipboardAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testCopyItem(String siteId){
				
		Map<String, Object> json = getItemJson();
		
		api.post("studio/api/1/services/api/1/clipboard/copy-item.json").urlParam("site",siteId).json(json).execute().status(200).debug();
	}
	
	public void testCutItem(String siteId){
		
		Map<String, Object> json = getItemJson();
		
		api.post("studio/api/1/services/api/1/clipboard/cut-item.json").urlParam("site",siteId).json(json).execute().status(200).debug();
	}
	
	public void testGetItem(String siteId){
		
		api.get("studio/api/1/services/api/1/clipboard/get-items.json").urlParam("site",siteId).execute().status(200).debug();
	}
	
	public void testPasteItem(String siteId){
		
		api.get("studio/api/1/services/api/1/clipboard/paste-item.json")
		.urlParam("site",siteId).urlParam("parentPath","/site/website/folder2").
		execute().status(200).debug();
	}
	
	private Map<String, Object> getItemJson(){
		
		Map<String, Object> childURI = new HashMap<>();
		childURI.put("uri", "/site/website/folder1/index.xml");
		
		List<Map<String, Object>> children = new ArrayList<>();
		children.add(childURI);
		
		Map<String, Object> itemJson = new HashMap<>();
		itemJson.put("uri", "/site/website/folder1");
		itemJson.put("children", children);
		
		List<Map<String, Object>> item = new ArrayList<>();
		item.add(itemJson);
		
		Map<String, Object> json = new HashMap<>();
		json.put("item", item);
		
		return json;
	}
}
