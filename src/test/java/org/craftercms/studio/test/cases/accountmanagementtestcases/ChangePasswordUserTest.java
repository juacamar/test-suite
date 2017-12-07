package org.craftercms.studio.test.cases.accountmanagementtestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AccountManagementPage;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class ChangePasswordUserTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private CreateSitePage createSitePage;
	private AccountManagementPage accountManagementPage;
	
	private String userName;
	private String password;
	private String sitePageTitleXpath;
	private String createSiteButtonXpath;
	private String sitesPageTitleLocator;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.accountManagementPage = new AccountManagementPage(driverManager, uIElementsPropertiesManager
				);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		sitePageTitleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("sites.pagetitle");
		createSiteButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		sitesPageTitleLocator = uIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("sites.pagetitle");

	}
	
	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void changePasswordUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// wait for element is clickeable
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);
		this.driverManager.isElementPresentByXpath(sitesPageTitleLocator);
		createSitePage.clickAdmin();

		// click on settings
		createSitePage.clickOnSettingsOption();

		// change password
		accountManagementPage.changeUserPassword(userName, "123456", "123456");

		// login to application
		loginPage.loginToCrafter(userName, "123456");

		// reload page
		driverManager.getDriver().navigate().refresh();
		this.driverManager.isElementPresentByXpath(sitePageTitleXpath);
		
		// click On admin option
		createSitePage.clickAdmin();

		// click on settings
		createSitePage.clickOnSettingsOption();

		// change password
		accountManagementPage.changeUserPassword("123456", userName, "admin");

		// login to application
		loginPage.loginToCrafter(userName, password);

		// Assert create button is present.
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", createSiteButtonXpath);
		Assert.assertTrue(createButton.isDisplayed());

	}
}
