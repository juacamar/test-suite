package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import java.io.File;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class ContentAssetAPI extends BaseAPI{

	private String contentPath = "/site/website";
	private String folderName = "newFolder";
	private String fileName = "index.xml";
	private String contentType = "/page/entry";
	
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
	
	public void testCreateFolder(String siteId, String folderName) {
		
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

	public void testGetContentType(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-content-type.json")
		.urlParam("site", siteId).urlParam("type",contentType).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-content-type.json?site="+siteId+"&type="+contentType))
		.debug();
	}
	
	public void testGetContentTypes(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-content-types.json")
		.urlParam("site", siteId).urlParam("path",contentPath).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-content-types.json?site="+siteId+"&path="+contentPath))
		.debug();
	}
	
	public void testGetContentItem(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-item.json")
		.urlParam("site", siteId).urlParam("path",contentPath+"/"+fileName).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-item.json?site="+siteId+"&path="+contentPath+"/"+fileName))
		.debug();
	}
	
	public void testGetItemOrders(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-item-orders.json")
		.urlParam("site", siteId).urlParam("path",contentPath+"/"+fileName).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-item-orders.json?site="+siteId+"&path="+contentPath+"/"+fileName))
		.debug();
	}
	
	public void testGetItemStates(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-item-states.json")
		.urlParam("site", siteId).urlParam("state","ALL").execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-item-states.json?site="+siteId+"&state=ALL"))
		.debug();
	}
	
	public void testGetItemVersions(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-item-versions.json")
		.urlParam("site", siteId).urlParam("path",contentPath+"/"+fileName).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-item-versions.json?site="+siteId+"&path="+contentPath+"/"+fileName))
		.debug();
	}
	
	public void testGetItemsTree(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-items-tree.json")
		.urlParam("site", siteId).urlParam("path",contentPath+"/"+fileName).urlParam("depth","1").execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-items-tree.json?site="+siteId+"&path="+contentPath+"/"+fileName+"&depth=1"))
		.debug();
	}
	
	public void testGetNextItemOrder(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-next-item-order.json")
		.urlParam("site", siteId).urlParam("parentpath",contentPath+"/"+fileName).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/get-next-item-order.json?site="+siteId+"&parentpath="+contentPath+"/"+fileName))
		.debug();
	}
	
	public void testGetPages(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/get-pages.json")
		.urlParam("site", siteId)
		.urlParam("path",contentPath+"/"+fileName)
		.urlParam("depth","1")
		.urlParam("order","default")
		.execute().status(200)
		.debug();
	}
	
	public void testDeleteContent(String siteId){
		
		api.get("/studio/api/1/services/api/1/content/delete-content.json")
		.urlParam("site", siteId)
		.urlParam("path", contentPath + "/" + fileName)
		.execute().status(200).debug();
	}
	
	public void testUnlockContent(String siteId) {
		
		api.get("/studio/api/1/services/api/1/content/unlock-content.json")
		.urlParam("site", siteId).urlParam("path",contentPath+"/"+fileName).execute().status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/unlock-content.json?site="+siteId+"&path="+contentPath+"/"+fileName))
		.debug();
	}
	
	public void testReorderContentItems(String siteId, String path, String before, String after) {
		
		api.get("/studio/api/1/services/api/1/content/reorder-items.json")
		.urlParam("site", siteId).urlParam("path",path).urlParam("before",before).urlParam("after",after).execute()
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/content/reorder-items.json?site="+siteId+"&path="+path+"&before="+before+"&after="+after))
		.debug();
	}
	
	public void testWriteContent(String siteId){
		
		File test = new File("src/test/resources/index.xml");
		
		api.post("/studio/api/1/services/api/1/content/write-content.json")
		.urlParam("site", siteId)
		.urlParam("path", "site/website/")
		.urlParam("phase", "onSave")
		.urlParam("fileName", fileName)
		.urlParam("contentType", contentType)
		.urlParam("unlock", "true")
		.file("file", test)
		.execute().status(200).debug();
	}
	
	public void testWriteContent(String siteId, String newPath){
		
		File test = new File("src/test/resources/index.xml");
		
		api.post("/studio/api/1/services/api/1/content/write-content.json")
		.urlParam("site", siteId)
		.urlParam("path", newPath)
		.urlParam("phase", "onSave")
		.urlParam("fileName", fileName)
		.urlParam("contentType", contentType)
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
