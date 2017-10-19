package org.craftercms.studio.test.cases.sitespagetestcases;

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
import org.openqa.selenium.NoSuchElementException;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PaginationOfListOfSitesTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreateSitePage createSitePage;

	private ConstantsPropertiesManager constantsPropertiesManager;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createSitesRandom() {

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

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

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait(8000);
		//driverManager.getDriver().navigate().refresh();
		// wait for element is clickeable

		// homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		// homePage.getDriverManager().driverWait();
		// homePage.getDriverManager().driverWait();
		// go to the sites page
		homePage.getDriverManager().driverWait(8000);
		String sitesNavOptionElementCssSelector = "#sitesRightNav";

		if (this.driverManager.isElementPresentBycssSelector(15,sitesNavOptionElementCssSelector))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", sitesNavOptionElementCssSelector)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

		//this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "cssSelector", "#sitesRightNav").click();
		// driverManager.getDriver().findElement(By.cssSelector("#sitesRightNav")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);
	}

	public void navigationOfPage() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();
		// driverManager.getDriver().findElement(By.cssSelector("#container > div > div
		// > div.pull-right.m10 > input"))
		// .clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("1");
		// driverManager.getDriver().findElement(By.cssSelector("#container > div > div
		// > div.pull-right.m10 > input"))
		// .sendKeys("1");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();
		// driverManager.getDriver().findElement(By.cssSelector("#container > div > div
		// > div.pull-right.m10 > input"))
		// .clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("2");
		// driverManager.getDriver().findElement(By.cssSelector("#container > div > div
		// > div.pull-right.m10 > input"))
		// .sendKeys("2");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// navigation
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div.ng-scope > dir-pagination-controls > ul > li:nth-child(3) > a")
				.click();
		// driverManager.getDriver()
		// .findElement(By.cssSelector(
		// "#container > div > div > div.ng-scope > dir-pagination-controls > ul >
		// li:nth-child(3) > a"))
		// .click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div.ng-scope > dir-pagination-controls > ul > li:nth-child(2) > a")
				.click();

		// driverManager.getDriver()
		// .findElement(By.cssSelector(
		// "#container > div > div > div.ng-scope > dir-pagination-controls > ul >
		// li:nth-child(2) > a"))
		// .click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div.ng-scope > dir-pagination-controls > ul >li:nth-child(4) > a")
				.click();

		// driverManager.getDriver()
		// .findElement(By.cssSelector(
		// "#container > div > div > div.ng-scope > dir-pagination-controls > ul >
		// li:nth-child(4) > a"))
		// .click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div.ng-scope > dir-pagination-controls > ul > li:nth-child(1) > a")
				.click();

		// driverManager.getDriver()
		// .findElement(By.cssSelector(
		// "#container > div > div > div.ng-scope > dir-pagination-controls > ul >
		// li:nth-child(1) > a"))
		// .click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").clear();

		// driverManager.getDriver().findElement(By.cssSelector("#container > div > div
		// > div.pull-right.m10 > input"))
		// .clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input").sendKeys("10");

		// driverManager.getDriver().findElement(By.cssSelector("#container > div > div
		// > div.pull-right.m10 > input"))
		// .sendKeys("10");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

	}

	public void deleteSite() {

		// Click on Delete icon

		homePage.clickOnDeleteSiteIcon();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// Click on YES to confirm the delete.

		homePage.clickOnYesToDeleteSite();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

	}

	@Test(priority = 0)

	public void paginationOfTheListOfSites() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		// Create user 1

		createSitesRandom();

		// Create user 2

		homePage.getDriverManager().driverWait(2000);
		createSitesRandom();

		// Create user 3

		homePage.getDriverManager().driverWait(2000);
		createSitesRandom();

		homePage.getDriverManager().driverWait(1000);

		// filters

		navigationOfPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Delete sites

		deleteSite();

		deleteSite();

		deleteSite();

	}

}
