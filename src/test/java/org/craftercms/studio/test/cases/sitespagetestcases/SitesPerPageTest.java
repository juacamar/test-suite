package org.craftercms.studio.test.cases.sitespagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

	private CreateSitePage createSitePage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createSitesRandom() {

		// MaximizeWindow
		//driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the Id of the site

		// createSitePage.fillIdSite("");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		createSitePage.openBlueprintCombo();

		// Select empty blueprint

		createSitePage.selectEmptyBlueprint();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		// go to the sites page

		driverManager.getDriver().findElement(By.cssSelector("#sitesRightNav")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
	}

	public void filters() {

		// Show 8 sites

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert only 8 sites displayed

		WebElement page1 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(1) > td.name.ng-binding"));

		Assert.assertTrue(page1.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 5 sites

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("2");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 5 sites displayed

		WebElement page2 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(2) > td.name.ng-binding"));

		Assert.assertTrue(page2.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 1 site

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("3");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 1 site displayed

		WebElement page3 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(3) > td.name.ng-binding"));

		Assert.assertTrue(page3.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 11 sites

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("10");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	public void deleteSite() {

		// Click on Delete icon

		homePage.clickOnDeleteSiteIcon();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on YES to confirm the delete.

		homePage.clickOnYesToDeleteSite();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	@Test(priority = 0)

	public void sitesPerPage() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// Create user 1
		homePage.getDriverManager().driverWait();
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
