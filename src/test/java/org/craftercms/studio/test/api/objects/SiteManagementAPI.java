package org.craftercms.studio.test.api.objects;

import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

public class SiteManagementAPI extends BaseAPI {

	private String siteId = "mysite";
	private String description = "Description!";
	private String blueprint = "empty";

	public SiteManagementAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

	public void testCreateSite(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);
		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(201)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id=" + siteId))
				.json("$.message", is("OK")).debug();
		this.setSiteId(siteId);
	}

	public void testCreateSiteInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_idnonvalid", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);

		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(400)
				.json("$.message", is("Invalid parameter(s): [site_id]")).debug();
	}

	public void testCreateSiteSiteAlreadyExists() {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);

		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(409)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id=" + siteId))
				.json("$.message", is("Site already exists")).debug();
	}
	
	public void testCreateSiteUnauthorized(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", blueprint);
		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute().status(401)
				.header("Location",
						is(headerLocationBase + "/studio/api/1/services/api/1/site/get.json?site_id=" + siteId))
				.debug();
	}


	public void testDeleteSite(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("siteId", siteId);
		api.post("/studio/api/1/services/api/1/site/delete-site.json").json(json).execute().status(200);
				
	}
	
	public void testDeleteSiteUnauthorized(String siteId) {
		Map<String, Object> json = new HashMap<>();
		json.put("siteId", siteId);
		api.post("/studio/api/1/services/api/1/site/delete-site.json").json(json).execute().status(401);
				
	}

	public void testClearConfigurationCache() {
		api.get("/studio/api/1/services/api/1/site/clear-configuration-cache.json").urlParam("site", this.siteId)
				.execute().status(200);
	}

	public void testExistsSite() {
		api.get("/studio/api/1/services/api/1/site/exists.json").urlParam("site", this.siteId).execute().status(200);
	}

	public void testGetAvailableBlueprints() {
		api.get("/studio/api/1/services/api/1/site/get-available-blueprints.json").execute().status(200);
	}
	
	public void testGetConfigurationOfSite() {
		api.get("/studio/api/1/services/api/1/site/get-configuration.json")
		.urlParam("site", this.siteId)
		.urlParam("path", "/site-config.xml").execute().status(200);
	}
	
	public void testGetSite() {
		api.get("/studio/api/1/services/api/1/site/get.json")
		.urlParam("site_id", siteId).execute()
		.status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/site/get.json?site_id="+ siteId));
   	}
	
	public void testGetSiteUnauthorized() {
		api.get("/studio/api/1/services/api/1/site/get.json")
		.urlParam("site_id", siteId).execute()
		.status(401)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/site/get.json?site_id="+ siteId));
   	}
	
	public void testGetSiteInvalidParameters() {
		api.get("/studio/api/1/services/api/1/site/get.json")
		.urlParam("site_idnonvalid", siteId).execute()
		.status(400);
   	}
	
	public void testGetSiteSiteNotFound() {
    		api.get("/studio/api/1/services/api/1/site/get.json")
    		.urlParam("site_id", siteId+"nonvalid").execute()
		.status(404)
		.json("$.message", is("Site not found")).debug();
   	}

	public void testGetSitesPerUser(String userName) {
		api.get("/studio/api/1/services/api/1/site/get-per-user.json")
		.urlParam("username", userName).execute()
		.status(200)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/site/get-per-user.json?username="+ userName+"&start=0&number=25"));
   	}
	
	public void testGetSitesPerUserInvalidParameter(String userName) {
		api.get("/studio/api/1/services/api/1/site/get-per-user.json")
		.urlParam("usernamenonvalid", userName).execute()
		.status(400);
   	}
	
	public void testGetSitesPerUserUserNotFound(String userName) {
		api.get("/studio/api/1/services/api/1/site/get-per-user.json")
		.urlParam("username", userName+"nonvalid").execute()
		.status(404);
   	}
	
	public void testGetSitesPerUserUnauthorized(String userName) {
		api.get("/studio/api/1/services/api/1/site/get-per-user.json")
		.urlParam("username", userName).execute()
		.status(401)
		.header("Location", is(headerLocationBase+"/studio/api/1/services/api/1/site/get-per-user.json?username="+ userName+"&start=0&number=25"));
   	}
	
	public void testCreateSiteGitRepo(String siteId) throws Exception {
		
		
		// invoke the process, keeping a handle to it for later...
	    // note that we pass the command and its params as String's in
	    // the same String[]
	    Process _p = Runtime.getRuntime().exec("mkdir ./craftercms_temp");
	    int a = _p.waitFor();
	    System.out.println("asdf a "+ a);
	    
        
	    Process _p3 = Runtime.getRuntime().exec("cd ./craftercms_temp");
	    int c = _p3.waitFor();
	    System.out.println("asdf c "+ c);
		
	    //Process _p2 = Runtime.getRuntime().exec("git --bare init");
	    
	    String[] command = {"git", "--bare", "init"};
        ProcessBuilder probuilder = new ProcessBuilder( command );
        //You can set up your work directory
        probuilder.directory(new File("./craftercms_temp"));

        Process _p2 = probuilder.start();
	    
        //Read out dir output
        InputStream is = _p2.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.printf("Output of running mkdir ./craftercms_temp is:\n");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
	    
	    int b = _p2.waitFor();
	    System.out.println("asdf b "+ b);
	    
		
		Map<String, Object> json = new HashMap<>();
		json.put("site_id", siteId);
		json.put("description", description);
		json.put("blueprint", "empty");
		json.put("use_remote", "true");
		json.put("remote_name", "origin");
		json.put("remote_url", "./craftercms_temp/.git");
		json.put("remote_username", "");
		json.put("remote_password", "");
		json.put("create_option", "push");
		api.post("/studio/api/1/services/api/1/site/create.json").json(json).execute()
				.debug();
		this.setSiteId(siteId);
		
	    String[] command2 = {"rm", "./craftercms_temp"};
        probuilder = new ProcessBuilder( command2 );
        //You can set up your work directory
        probuilder.directory(new File("./"));

        Process _p4 = probuilder.start();
        
        InputStream is2 = _p4.getInputStream();
        InputStreamReader isr2 = new InputStreamReader(is2);
        BufferedReader br2 = new BufferedReader(isr2);
        String line2;
        System.out.printf("Output of running del is:\n");
        while ((line2 = br2.readLine()) != null) {
            System.out.println(line2);
        }
        
	    int d = _p4.waitFor();
	    System.out.println("asdf d "+ d);
	}
	
	/*
	 * 
	 *
	  "blueprint" : "empty",
      "use_remote" : true,		      "use_remote" : true,
      "remote_name" : "upstream",		      "remote_name" : "upstream",
 -    "remote_url" : "https://github.com/craftercms/remoterepo.git"		 +    "remote_url" : "https://github.com/craftercms/remoterepo.git",
 -    "username" : "joe.bloggs"		 +    "remote_username" : "joe.bloggs",
 -    "password" : "SuperSecret$$587"		 +    "remote_password" : "SuperSecret$$587",
      "create_option" : "push"		      "create_option" : "push"
	 */
	
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
}
