/**
 * 
 */
package org.craftercms.studio.test.cases.sanitytesttestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author luishernandez
 *
 */
public class VerifyNoErrorsInHomePageOfSiteTest {

//	private WebDriverManager driverManager;

//	private String userName;
//	private String password;
//	private int defaultTimeOut;

	@BeforeMethod
	public void beforeTest() {
		//this.driverManager = new WebDriverManager();

//		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
//				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
//		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
//		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
//		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
//		defaultTimeOut = Integer.parseInt(
//				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterMethod
	public void afterTest() {
		//driverManager.closeConnection();
	}


	@Test(priority = 0, sequential = true)
	public void crafter3LoadTestTestUser1() {
	}


}
