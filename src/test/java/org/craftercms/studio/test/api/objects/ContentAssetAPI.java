package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import java.io.File;
import java.io.IOException;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ContentAssetAPI extends BaseAPI{

	private String contentPath = "/site/website";
	private String folderName = "newFolder";
	private String fileName = "index.xml";
	
	public ContentAssetAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}
	
	public void testChangeContentType(String siteId){
		
		api.post("/studio/api/1/services/api/1/content/change-content-type.json")
		.urlParam("site", siteId)
		.urlParam("path", contentPath + "/" + fileName)
		.urlParam("contentType", "/page/entry")
		.execute().status(200).debug();
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

	public void testGetContent(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-content.json")
		.urlParam("site", siteId).urlParam("path",contentPath+"/"+fileName).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-content.json?site="+siteId+"&path="+contentPath+"/"+fileName))
		.debug();
	}
	
	public void testGetContentAtPath(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-content-at-path.json")
		.urlParam("site", siteId).urlParam("path",contentPath).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-content-at-path.json?site="+siteId+"&path="+contentPath))
		.debug();
	}

	public void testDeleteContent(String siteId){
		
		api.get("/studio/api/1/services/api/1/content/delete-content.json")
		.urlParam("site", siteId)
		.urlParam("path", contentPath + "/" + fileName)
		.execute().status(200).debug();
	}
	
	public void testWriteContent(String siteId){
		
		File test = new File("src/test/resources/index.xml");
		
		api.post("/studio/api/1/services/api/1/content/write-content.json")
		.urlParam("site", siteId)
		.urlParam("path", "site/website/")
		.urlParam("phase", "onSave")
		.urlParam("fileName", fileName)
		.urlParam("contentType", "/page/entry")
		.urlParam("unlock", "true")
		.file("file", test)
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
