package org.craftercms.studio.test.cases.sitespagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Design_of_create_site_page() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait(300);
		// Assert crafter studio logo is present.

		WebElement logoCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".navbar-brand > img");
		// driverManager.getDriver().findElement(By.cssSelector(".navbar-brand > img"));

		Assert.assertTrue(logoCrafter.isDisplayed());

		// Assert sites title is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement sitesLabel = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"h1.ng-binding");
		// driverManager.getDriver().findElement(By.cssSelector("h1.ng-binding"));

		Assert.assertTrue(sitesLabel.isDisplayed());

		// Assert create button is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".btn.btn-default.btn-pill.btn-block");
		// driverManager.getDriver()
		// .findElement(By.cssSelector(".btn.btn-default.btn-pill.btn-block"));

		Assert.assertTrue(createButton.isDisplayed());

		// Assert admin tools is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement adminTools = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".nav > li:nth-child(1) > a:nth-child(1)");
		// driverManager.getDriver()
		// .findElement(By.cssSelector(".nav > li:nth-child(1) > a:nth-child(1)"));

		Assert.assertTrue(adminTools.isDisplayed());

		// Assert sites option is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement sitesOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"li.active > a:nth-child(1)");
		// driverManager.getDriver().findElement(By.cssSelector("li.active >
		// a:nth-child(1)"));

		Assert.assertTrue(sitesOption.isDisplayed());

		// Assert Help option is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement helpOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".nav > li:nth-child(3) > a:nth-child(1)");
		// driverManager.getDriver()
		// .findElement(By.cssSelector(".nav > li:nth-child(3) > a:nth-child(1)"));

		Assert.assertTrue(helpOption.isDisplayed());

		// Assert account option is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement accountOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".dropdown-toggle");
		// driverManager.getDriver().findElement(By.cssSelector(".dropdown-toggle"));

		Assert.assertTrue(accountOption.isDisplayed());

		// Assert all sites option is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement sitesPerPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > label");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#container > div > div > div.pull-right.m10 >
		// label"));

		Assert.assertTrue(sitesPerPage.isDisplayed());

		// Assert site name is present.
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		WebElement sitesPerPageCombo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div.pull-right.m10 > input");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#container > div > div > div.pull-right.m10 >
		// input"));

		Assert.assertTrue(sitesPerPageCombo.isDisplayed());

	}

}
