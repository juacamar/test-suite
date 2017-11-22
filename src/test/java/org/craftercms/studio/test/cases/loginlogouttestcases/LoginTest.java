package org.craftercms.studio.test.cases.loginlogouttestcases;

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
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class LoginTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private String userName;
	private String password;

	private String createSiteButtonXpath;
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createSiteButtonXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
	
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void loginInToStudioTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// Assert create button is present.
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				createSiteButtonXpath);

		Assert.assertTrue(createButton.isDisplayed());

	}

}
