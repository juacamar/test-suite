package org.craftercms.studio.test.cases.userstestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
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

public class DesignOfUsersPageTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private CreateSitePage createSitePage;

	private String userName;
	private String password;
	private String usersTitleXpath;
	private String crafterLogoXpath;
	private String accountTopNavOptionXpath;
	private String helpTopNavOptionXpath;
	private String sitesTopNavOptionXpath;
	private String usersTopNavOptionXpath;
	private String usersPerPageInputXpath;
	private String newUserButtonXpath;
	private String userSearchXpath;
	private String sitesTitleXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		usersTitleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.userstitle");
		crafterLogoXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.crafterlogo");
		usersTopNavOptionXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.homeusers");
		sitesTopNavOptionXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.homesites");
		helpTopNavOptionXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.homehelp");
		accountTopNavOptionXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.accountdropdown");
		usersPerPageInputXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersperpageinput");
		newUserButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserbutton");
		userSearchXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.userssearchinput");
		sitesTitleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagetitle");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void desingOfUsersPageTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// click On Users option
		this.driverManager.isElementPresentAndClickableByXpath(sitesTitleXpath);
		this.driverManager.waitUntilPageLoad();
		createSitePage.clickOnUsersOption();

		// Assert header is present.
		WebElement header = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersTitleXpath);
		Assert.assertTrue(header.isDisplayed());

		// Assert crafter logo is present.
		WebElement crafterLogo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				crafterLogoXpath);
		Assert.assertTrue(crafterLogo.isDisplayed());

		// Assert user menu option is present.
		WebElement userMenuOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				usersTopNavOptionXpath);
		Assert.assertTrue(userMenuOption.isDisplayed());

		// Assert sites menu option is present.
		WebElement sitesMenuOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				sitesTopNavOptionXpath);
		Assert.assertTrue(sitesMenuOption.isDisplayed());

		// Assert help menu option is present.
		WebElement helpMenuOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				helpTopNavOptionXpath);
		Assert.assertTrue(helpMenuOption.isDisplayed());

		// Assert admin dropdown option is present.
		WebElement adminOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				accountTopNavOptionXpath);
		Assert.assertTrue(adminOption.isDisplayed());

		// Assert users per page combo option is present.
		WebElement usersPerPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				usersPerPageInputXpath);
		Assert.assertTrue(usersPerPage.isDisplayed());

		// Assert new user option is present.
		WebElement newUser = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newUserButtonXpath);
		Assert.assertTrue(newUser.isDisplayed());
		
		// Assert search option is present.
		WebElement search = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				userSearchXpath);
		Assert.assertTrue(search.isDisplayed());

	}
}
