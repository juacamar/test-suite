/**
 * 
 */
package org.craftercms.studio.test.api.objects;


import static org.hamcrest.Matchers.is;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

/**
 * @author luishernandez
 *
 */
public class AuditAPI extends BaseAPI {


	public AuditAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		super(api, apiConnectionManager);
	}

 	public void testGetAuditLog(String siteId) {		
   		api.get("studio/api/1/services/api/1/audit/get.json")
   		.urlParam("site_id", siteId).execute().status(200)
   				.json("$.message", is("OK")).debug();

   	}
 	
 	
	public void testGetAuditLogInvalidParameter(String siteId) {
   		api.get("studio/api/1/services/api/1/audit/get.json")
   		.urlParam("site_idnonvalid", siteId).execute().status(400);

   	}
	
  	public void testGetAuditLogSiteNotFound(String siteId) {
  		api.get("studio/api/1/services/api/1/audit/get.json")
   		.urlParam("site_id", siteId+"nonvalid").execute().status(404);
   	}
  	
  	public void testGetAuditLogUnauthorized(String siteId) {
  		api.get("studio/api/1/services/api/1/audit/get.json")
   		.urlParam("site_id", siteId).execute().status(401);
   	}

}
