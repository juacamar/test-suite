package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
	private String usersTopNavOptionXpath;
	private String deleteYesButtonXpath;
	private String deleteNotAllowedMessageXpath;
	private String errorMessageXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		usersTopNavOptionXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.homeusers");
		deleteYesButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		deleteNotAllowedMessageXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deletenotallowedparagraph");
		errorMessageXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deletenotallowederrorparagraph");
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

		// Go to users tab
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", usersTopNavOptionXpath).click();

		// Try to delete the user current
		usersPage.clickOnDeleteUser();

		// Confirmation to delete user connected
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();
		
		// Verify
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(deleteNotAllowedMessageXpath));
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(errorMessageXpath));

		WebElement validation = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",deleteNotAllowedMessageXpath);
		Assert.assertTrue(validation.getText().contains("Unable to delete user"));

	}

}
