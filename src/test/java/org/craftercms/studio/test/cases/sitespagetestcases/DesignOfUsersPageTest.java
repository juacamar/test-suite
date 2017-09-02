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

		homePage.getDriverManager().driverWait();

		// click On Users option

		createSitePage.clickOnUsersOption();

		// Assert header is present.

		WebElement header = driverManager.getDriver()
				.findElement(By.cssSelector("#container > div > div > div > div > div > h2"));

		Assert.assertTrue(header.isDisplayed());

		// Assert crafter logo is present.

		WebElement crafterLogo = driverManager.getDriver()
				.findElement(By.cssSelector("body > ui-view > header > nav > div > div.navbar-header > a > img"));

		Assert.assertTrue(crafterLogo.isDisplayed());

		// Assert user menu option is present.

		WebElement userMenuOption = driverManager.getDriver().findElement(By.cssSelector("#homeUsers"));

		Assert.assertTrue(userMenuOption.isDisplayed());

		// Assert sites menu option is present.

		WebElement sitesMenuOption = driverManager.getDriver().findElement(By.cssSelector("#homeSites"));

		Assert.assertTrue(sitesMenuOption.isDisplayed());

		// Assert help menu option is present.

		WebElement helpMenuOption = driverManager.getDriver().findElement(By.cssSelector("#homeHelp"));

		Assert.assertTrue(helpMenuOption.isDisplayed());

		// Assert admin dropdown option is present.

		WebElement adminOption = driverManager.getDriver().findElement(By.cssSelector(
				"body > ui-view > header > nav > div > div.collapse.navbar-collapse.ng-scope > ul > li:nth-child(4) > a"));

		Assert.assertTrue(adminOption.isDisplayed());

		// Assert users per page combo option is present.

		WebElement usersPerPage = driverManager.getDriver()
				.findElement(By.cssSelector("#container > div > div > div > div > div > div > input"));

		Assert.assertTrue(usersPerPage.isDisplayed());

		// Assert new user option is present.

		WebElement newUser = driverManager.getDriver()
				.findElement(By.cssSelector("#container > div > div > div > div > div > a"));

		Assert.assertTrue(newUser.isDisplayed());

		// Assert search option is present.

		WebElement search = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input"));

		Assert.assertTrue(search.isDisplayed());

	}
}
