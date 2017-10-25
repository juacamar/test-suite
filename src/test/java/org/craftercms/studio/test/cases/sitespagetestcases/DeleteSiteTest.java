package org.craftercms.studio.test.cases.sitespagetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteSiteTest {

	WebDriver driver;
	LoginPage objLogin;
	HomePage objHomePage;

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	
	private String userName;
	private String password;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void delete_site() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Click on Delete icon

		homePage.clickOnDeleteSiteIcon();
		
		// Click on YES to confirm the delete.

		homePage.clickOnYesToDeleteSite();

		// Assert
		Assert.assertFalse(this.driverManager.isElementPresentBycssSelector(".glyphicon.glyphicon-trash"));
	}
}
