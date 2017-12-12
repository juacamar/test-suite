package org.craftercms.studio.test.cases.sitestestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
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

public class SitesPerPageTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;

	private String userName;
	private String password;
	private CreateSitePage createSitePage;
	private String sitesPerPageInputXpath;
	private String firstSiteXpath;
	private String secondSiteXpath;
	private String thirdSiteXpath;
	private String createSiteButton;
	private String siteDropdownElementXPath;
	private String topNavDeleteOption;
	private String topNavEditOption;
	private String topNavSitesOption;

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
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

		sitesPerPageInputXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.sitesperpageinput");
		firstSiteXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.firstSiteNameOnList");
		secondSiteXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.secondSiteNameOnList");
		thirdSiteXpath= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.thirdSiteNameOnList");
		createSiteButton = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		siteDropdownElementXPath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		topNavDeleteOption = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.deletetopnavoption");
		topNavEditOption= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		topNavSitesOption= uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.preview.sitesoption");
		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();
		
		// Create site 1
		createSitesRandom();
		// Create site 2
		createSitesRandom();
		// Create site 3
		createSitesRandom();

	}

	@AfterClass
	public void afterTest() {
		// Delete Created site 1
		deleteSite();
		// Delete Created site 2
		deleteSite();
		// Delete Created site 3
		deleteSite();
		driverManager.closeConnection();
	}

	public void createSitesRandom() {

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Filling the name of site
		createSitePage.fillSiteName();

		// Filling the description of the site
		createSitePage.fillDescription("Description");

		// Open blueprint combo
		createSitePage.openBlueprintCombo();

		// Select empty blueprint
		createSitePage.selectEmptyBlueprint();

		// Click on Create button
		createSitePage.clickOnCreateSiteButton();
		
		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(siteDropdownElementXPath);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", topNavDeleteOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", topNavEditOption);

		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));
		
		this.driverManager.isElementPresentAndClickableById(topNavSitesOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", topNavSitesOption).click();
	}

	public void filters() {

		// Show 1 sites
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).sendKeys("1");

		// Assert only 1 sites displayed
		WebElement page1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				firstSiteXpath);
		Assert.assertTrue(page1.isDisplayed());

		// Show 2 sites
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).sendKeys("2");

		// Asser only 2 sites displayed
		WebElement page2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				secondSiteXpath);
		Assert.assertTrue(page2.isDisplayed());

		// Show 3 site
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).sendKeys("3");

		// Asser only 3 site displayed
		WebElement page3 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				thirdSiteXpath);
		Assert.assertTrue(page3.isDisplayed());

		// Show 10 sites
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				sitesPerPageInputXpath).sendKeys("10");
		
		driverManager.getDriver().navigate().refresh();
		//this.driverManager.waitForPageLoad(driverManager.getDriver());
	}

	public void deleteSite() {

		// Click on Delete icon
		//this.driverManager.isElementPresentAndClickableByXpath(createSiteButton);
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButton);
		homePage.clickOnDeleteSiteIcon();

		// Click on YES to confirm the delete.
		homePage.clickOnYesToDeleteSite();
		
		// Refresh the site
		driverManager.getDriver().navigate().refresh();
		//this.driverManager.waitForPageLoad(driverManager.getDriver());
	}

	@Test(priority = 0)
	public void verifyThatTheShowSitesPerPageWorksProperlyTest() {
		// filters
		filters();
	}
}
