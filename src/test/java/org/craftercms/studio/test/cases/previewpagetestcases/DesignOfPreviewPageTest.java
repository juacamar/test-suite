package org.craftercms.studio.test.cases.previewpagetestcases;

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

public class DesignOfPreviewPageTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private String userName;
	private String password;

	private String crafterLogoId;

	private String siteDropDownXpath;

	private String searchTopBarOptionId;

	private String accountDropdownTopBarOptionId;

	private String topNavDeleteOption;

	private String topNavEditOption;

	private String topNavHistoryOption;

	private String topNavDependenciesOption;

	private String dashboardOptionXpath;

	private String adminConsoleXpath;

	private String topNavUsersOption;

	private String topNavSitesOption;

	private String createSiteButtonXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();

		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		crafterLogoId = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		siteDropDownXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		searchTopBarOptionId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.preview.searchtopbaroption");
		accountDropdownTopBarOptionId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.preview.accountdropdowntopbaroption");
		topNavDeleteOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.deletetopnavoption");
		topNavEditOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		topNavHistoryOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.historytopnavoption");
		topNavDependenciesOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.dependenciestopnavoption");
		dashboardOptionXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.dashboard");
		adminConsoleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		topNavUsersOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.userstopnavoption");
		topNavSitesOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitestopnavoption");
		createSiteButtonXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void verifyTheDesignOfPreviewPageTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);
		homePage.goToPreviewPage();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// Assert crafter studio logo is present.
		WebElement logoCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", crafterLogoId);
		Assert.assertTrue(logoCrafter.isDisplayed());

		// Assert site content option is present.
		WebElement siteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				siteDropDownXpath);

		Assert.assertTrue(siteContent.isDisplayed());

		// Assert search field is present.
		WebElement searchField = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				searchTopBarOptionId);

		Assert.assertTrue(searchField.isDisplayed());

		// Assert account option is present.
		WebElement signUp = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				accountDropdownTopBarOptionId);

		Assert.assertTrue(signUp.isDisplayed());

		// Assert Edit option is present.
		WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				topNavEditOption);

		Assert.assertTrue(editOption.isDisplayed());

		// Assert delete option is present.
		WebElement deleteOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				topNavDeleteOption);

		Assert.assertTrue(deleteOption.isDisplayed());

		// Assert history option is present.
		WebElement historyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				topNavHistoryOption);
		Assert.assertTrue(historyOption.isDisplayed());

		// Assert history option is present.
		WebElement dependencies = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				topNavDependenciesOption);
		Assert.assertTrue(dependencies.isDisplayed());

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				siteDropDownXpath).click();

		// Assert all Sites Dropdown option is present.
		WebElement dashboard = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				dashboardOptionXpath);
		Assert.assertTrue(dashboard.isDisplayed());

		// Assert Users option is present.
		WebElement usersOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				topNavUsersOption);
		Assert.assertTrue(usersOption.isDisplayed());

		// Assert sites option is present.
		WebElement sitesOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				topNavSitesOption);
		Assert.assertTrue(sitesOption.isDisplayed());

		// Assert admin console option is present.
		WebElement adminConsoleOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				adminConsoleXpath);
		Assert.assertTrue(adminConsoleOption.isDisplayed());

	}

}
