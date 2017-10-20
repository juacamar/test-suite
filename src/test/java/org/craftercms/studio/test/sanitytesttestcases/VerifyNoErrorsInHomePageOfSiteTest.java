/**
 * 
 */
package org.craftercms.studio.test.sanitytesttestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * @author luishernandez
 *
 */
public class VerifyNoErrorsInHomePageOfSiteTest {

	private WebDriverManager driverManager;
	private UIElementsPropertiesManager UIElementsPropertiesManager;
	private ConstantsPropertiesManager constantsPropertiesManager;

	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeMethod
	public void beforeTest() {
		this.driverManager = new WebDriverManager();

		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterMethod
	public void afterTest() {
		driverManager.closeConnection();
	}


	@Test(priority = 0, sequential = true)
	public void crafter3LoadTestTestUser1() {
	}


}
