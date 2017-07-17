package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
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

	private CreatePage createPage;

	private UsersPage usersPage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createPage = new CreatePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createSitesRandom() {

		// MaximizeWindow
		driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Filling the name of site

		createPage.fillSiteName();

		// Filling the Id of the site

		// createPage.fillIdSite("");

		// Filling the description of the site

		createPage.fillDescription("Description");

		// Open blueprint combo

		createPage.openBlueprintCombo();

		// Select empty blueprint

		createPage.selectEmptyBlueprint();

		// Click on Create button

		createPage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

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
				.sendKeys("8");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert only 8 sites displayed

		WebElement user8 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(8) > td.name.ng-binding"));

		Assert.assertTrue(user8.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 5 sites

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("5");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 5 sites displayed

		WebElement user5 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(5) > td.name.ng-binding"));

		Assert.assertTrue(user5.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 1 site

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 1 site displayed

		WebElement user1 = driverManager.getDriver().findElement(
				By.cssSelector("#container > div > div > div.ng-scope > table > tbody > tr > td.name.ng-binding"));

		Assert.assertTrue(user1.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 11 sites

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div.pull-right.m10 > input"))
				.sendKeys("11");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 1 site displayed

		WebElement user11 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div.ng-scope > table > tbody > tr:nth-child(11) > td.name.ng-binding"));

		Assert.assertTrue(user11.isDisplayed());

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

	public void deleteUsersBlockTwo() {

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page
		driverManager.getDriver().findElement(By.cssSelector("#homeSites")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		createPage.clickOnUsersOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	public void deleteUsersBlockThree() {

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	@Test(priority = 0)

	public void sitesPerPage() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		// Create user 1

		createSitesRandom();

		// Create user 2

		createSitesRandom();

		// Create user 3

		createSitesRandom();

		// Create user 4

		createSitesRandom();

		// Create user 5

		createSitesRandom();

		// Create user 6

		createSitesRandom();

		// Create user 7

		createSitesRandom();

		// Create user 8

		createSitesRandom();

		// Create user 9

		createSitesRandom();

		// Create user 10

		createSitesRandom();

		// Create user 11

		createSitesRandom();

		// filters

		filters();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();

		// Delete sites

		deleteSite();
	}
}
