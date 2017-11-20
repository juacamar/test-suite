/**
 * 
 */
package org.craftercms.studio.test.api.objects;

import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.JsonTester;

/**
 * @author luishernandez
 *
 */
public class BaseAPI {
	protected JsonTester api;
	protected APIConnectionManager apiConnectionManager;
	protected String headerLocationBase;

	public BaseAPI(JsonTester api, APIConnectionManager apiConnectionManager) {
		this.api=api;
		this.apiConnectionManager=apiConnectionManager;
		headerLocationBase = this.apiConnectionManager.getHeaderLocationBase();
	}

	public JsonTester getApi() {
		return api;
	}

	public void setApi(JsonTester api) {
		this.api = api;
	}

}
