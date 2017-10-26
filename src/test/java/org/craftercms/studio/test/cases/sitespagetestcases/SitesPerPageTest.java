package org.craftercms.studio.test.cases.sitespagetestcases;

import org.openqa.selenium.NoSuchElementException;
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

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createSitesRandom() {

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the Id of the site

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		createSitePage.openBlueprintCombo();

		// Select empty blueprint

		createSitePage.selectEmptyBlueprint();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		// go to the sites page
		String sitesNavOptionElementCssSelector = "#sitesRightNav";

		if (this.driverManager.isElementPresentBycssSelector(sitesNavOptionElementCssSelector))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", sitesNavOptionElementCssSelector)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
		
		driverManager.getDriver().navigate().refresh();
	}

	public void filters() {

		// Show 8 sites
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("1");
	
		// Assert only 8 sites displayed

		WebElement page1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(1) > td.name.ng-binding");

		Assert.assertTrue(page1.isDisplayed());

		// Show 5 sites
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("2");

		// Asser only 5 sites displayed

		WebElement page2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(2) > td.name.ng-binding");

		Assert.assertTrue(page2.isDisplayed());
		
		// Show 1 site

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();
	
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("3");
	
		// Asser only 1 site displayed

		WebElement page3 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(3) > td.name.ng-binding");

		Assert.assertTrue(page3.isDisplayed());

		// Show 11 sites
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("10");
	}

	public void deleteSite() {

		// Click on Delete icon

		homePage.clickOnDeleteSiteIcon();

		// Click on YES to confirm the delete.

		homePage.clickOnYesToDeleteSite();
		
		
		//Refresh teh site
		driverManager.getDriver().navigate().refresh();

	}

	@Test(priority = 0)

	public void sitesPerPage() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Create user 1
		createSitesRandom();

		// Create user 2

		createSitesRandom();

		// Create user 3

		createSitesRandom();

		// filters

		filters();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

	}
}
