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

public class DesignOfCreateSitePageTest {

	WebDriver driver;
	LoginPage objLogin;
	HomePage objHomePage;

	private WebDriverManager driverManager;
	private LoginPage loginPage;

	private String userName;
	private String password;
	private String crafterLogoXpath;
	private String sitesTitleXpath;
	private String createSiteButtonXpath;
	private String usersOptionId;
	private String sitesOptionId;
	private String helpOptionId;
	private String accountDropdownXpath;
	private String sitesPerPageLabelXpath;
	private String sitesPerPageInputXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		crafterLogoXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.crafterlogo");
		sitesTitleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagetitle");
		createSiteButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		usersOptionId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.homeusers");
		sitesOptionId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.homesites");
		helpOptionId = uIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.sites.homehelp");
		accountDropdownXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.accountdropdown");
		sitesPerPageLabelXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.sitesperpagelabel");
		sitesPerPageInputXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.sitesperpageinput");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void verifyTheDesignOfSitesPage() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// Assert crafter studio logo is present.
		WebElement logoCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				crafterLogoXpath);

		Assert.assertTrue(logoCrafter.isDisplayed());

		// Assert sites title is present.
		WebElement sitesLabel = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesTitleXpath);

		Assert.assertTrue(sitesLabel.isDisplayed());

		// Assert create button is present.
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				createSiteButtonXpath);

		Assert.assertTrue(createButton.isDisplayed());

		// Assert admin tools is present.
		WebElement homeUsers = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersOptionId);

		Assert.assertTrue(homeUsers.isDisplayed());

		// Assert sites option is present.
		WebElement sitesOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", sitesOptionId);

		Assert.assertTrue(sitesOption.isDisplayed());

		// Assert Help option is present.
		WebElement helpOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", helpOptionId);

		Assert.assertTrue(helpOption.isDisplayed());

		// Assert account option is present.
		WebElement accountOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				accountDropdownXpath);
		Assert.assertTrue(accountOption.isDisplayed());

		// Assert all sites option is present.
		WebElement sitesPerPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageLabelXpath);

		Assert.assertTrue(sitesPerPage.isDisplayed());

		// Assert site name is present.
		WebElement sitesPerPageCombo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath);
		Assert.assertTrue(sitesPerPageCombo.isDisplayed());

	}

}
