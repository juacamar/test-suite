package org.craftercms.studio.test.cases.userstestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class TryToDeleteUserConnectedTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UsersPage usersPage;

	private String userName;
	private String password;
	private String deleteYesButtonXpath;
	private String deleteNotAllowedMessageXpath;
	private String errorMessageXpath;

	private CreateSitePage createSitePage;

	private String sitesTitleXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		deleteYesButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		deleteNotAllowedMessageXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deletenotallowedparagraph");
		errorMessageXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deletenotallowederrorparagraph");
		sitesTitleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagetitle");
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void tryToDeleteTheAdminUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);	
	
		this.driverManager.isElementPresentAndClickableByXpath(sitesTitleXpath);
		this.driverManager.waitUntilPageLoad();
		
		// click On Users option
		createSitePage.clickOnUsersOption();

		// Try to delete the user current
		usersPage.clickOnDeleteUser();

		// Confirmation to delete user connected
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();

		// Verify
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(deleteNotAllowedMessageXpath));
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(errorMessageXpath));

		WebElement validation = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				deleteNotAllowedMessageXpath);
		Assert.assertTrue(validation.getText().contains("Unable to delete user"));

	}

}
