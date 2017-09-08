package org.craftercms.studio.test.cases.userspagetestcases;

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

public class DesignOfUsersPageTest {

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

	@Test(priority = 0)

	public void desingOfUsersPageTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// click On Users option

		createSitePage.clickOnUsersOption();

		// Assert header is present.
		homePage.getDriverManager().driverWait(1000);
		WebElement header = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#container > div > div > div > div > div > h2");

		// driverManager.getDriver()
		// .findElement(By.cssSelector("#container > div > div > div > div > div >
		// h2"));

		Assert.assertTrue(header.isDisplayed());

		// Assert crafter logo is present.

		WebElement crafterLogo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"body > ui-view > header > nav > div > div.navbar-header > a > img");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("body > ui-view > header > nav > div >
		// div.navbar-header > a > img"));

		Assert.assertTrue(crafterLogo.isDisplayed());

		// Assert user menu option is present.

		WebElement userMenuOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#homeUsers");
				//driverManager.getDriver().findElement(By.cssSelector("#homeUsers"));

		Assert.assertTrue(userMenuOption.isDisplayed());

		// Assert sites menu option is present.

		WebElement sitesMenuOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#homeSites");
				//driverManager.getDriver().findElement(By.cssSelector("#homeSites"));

		Assert.assertTrue(sitesMenuOption.isDisplayed());

		// Assert help menu option is present.

		WebElement helpMenuOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#homeHelp");
				//driverManager.getDriver().findElement(By.cssSelector("#homeHelp"));

		Assert.assertTrue(helpMenuOption.isDisplayed());

		// Assert admin dropdown option is present.

		WebElement adminOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"body > ui-view > header > nav > div > div.collapse.navbar-collapse.ng-scope > ul > li:nth-child(4) > a");
				//driverManager.getDriver().findElement(By.cssSelector(
				//"body > ui-view > header > nav > div > div.collapse.navbar-collapse.ng-scope > ul > li:nth-child(4) > a"));

		Assert.assertTrue(adminOption.isDisplayed());

		// Assert users per page combo option is present.

		WebElement usersPerPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#container > div > div > div > div > div > div > input");
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#container > div > div > div > div > div > div > input"));

		Assert.assertTrue(usersPerPage.isDisplayed());

		// Assert new user option is present.

		WebElement newUser = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#container > div > div > div > div > div > a");
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#container > div > div > div > div > div > a"));

		Assert.assertTrue(newUser.isDisplayed());

		// Assert search option is present.

		WebElement search =  this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input");
				
				//driverManager.getDriver().findElement(By.cssSelector(
				//"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input"));

		Assert.assertTrue(search.isDisplayed());

	}
}
