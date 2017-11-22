package org.craftercms.studio.test.cases.sitestestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class ValidationsOfCreateSiteFieldsTest {

	WebDriver driver;
	LoginPage objLogin;
	HomePage objHomePage;

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	
	private String userName;
	private String password;
	private String createSiteDescriptionId;
	private String validationMessageXpath;

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
		createSiteDescriptionId= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitedescription");
		validationMessageXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitevalidationmessage");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void verifyThatTheValidationsAreDisplayedForCreateSiteDialog() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Click on description to show the validations
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createSiteDescriptionId).click();

		// Assert Id site is required.
		WebElement siteID = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				validationMessageXpath);

		Assert.assertTrue(siteID.isDisplayed());

	}

}
