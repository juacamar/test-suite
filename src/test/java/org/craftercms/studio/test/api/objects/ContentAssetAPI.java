package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ContentAssetAPI extends BaseAPI{

	private String contentPath = "/site/website";
	private String folderName = "newFolder";
	private String fileName = "index.xml";
	
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
		
		api.post("/studio/api/1/services/api/1/content/create-folder.json")
		.urlParam("site", siteId).urlParam("path", contentPath).urlParam("name", folderName)
		.execute().status(200).debug();
	}
	
	public void testRenameFolder(String siteId) {

		api.post("/studio/api/1/services/api/1/content/rename-folder.json")
		.urlParam("site", siteId).urlParam("path", contentPath+"/"+folderName).urlParam("name", "newer"+folderName)
		.execute().status(200).debug();
	}
	
	public void testGetContentAtPath(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-content-at-path.json")
		.urlParam("site", siteId).urlParam("path",contentPath).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-content-at-path.json?site="+siteId+"&path="+contentPath))
		.debug();
	}

	public void testWriteContent(String siteId){
		
		api.post("/studio/api/1/services/api/1/content/rename-folder.json")
		.urlParam("site", siteId)
		.urlParam("path", contentPath)
		.urlParam("fileName", fileName)
		.urlParam("contentType", "/page/home")
		.urlParam("unlock", "true")
		.execute().status(200).debug();
	}
	
	public String getContentPath() {
		return contentPath;
	}

	public String getFolderName() {
		return folderName;
	}

	public String getFileName() {
		return fileName;
	}
	
}
