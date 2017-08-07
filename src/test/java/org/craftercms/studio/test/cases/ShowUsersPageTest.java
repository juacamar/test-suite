/**
 * 
 */
package org.craftercms.studio.test.cases;

import org.craftercms.studio.test.pages.CreatePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Luis Alonso Hernandez Monge
 *
 */

public class ShowUsersPageTest {
	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreatePage createPage;

	private UsersPage usersPage;

	private DashboardPage dashboardPage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createPage = new CreatePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);
	}

	@AfterTest
	public void afterTest() {
		// deleting the previously created site
		homePage.deleteSite();
		//closing the conection with the webdriver
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void showUsersPage() {

		// login to application
		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		driverManager.maximizeWindow();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait();

		// Click on the Users Contextual Navigation Option
		homePage.clickUsersContextualNavigationOption();

		// wait for element is clickeable
		usersPage.getDriverManager().driverWait();

		// wait for element is clickeable
		usersPage.getDriverManager().driverWait();

		// Checking if the UsersPage was Loaded
		Assert.assertTrue(usersPage.getDriverManager().getDriver().getCurrentUrl()
				.equals("http://localhost:8080/studio/#/users"));

		// Checking if the Users title is displayed on the current page
		Assert.assertTrue(usersPage.isUsersPageTitlePresent());

		// go back to Sites Page
		usersPage.clickOnCrafterLogo();

		// wait for element is clickeable
		usersPage.getDriverManager().driverWait();

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait();

		// Creating a random site
		createPage.createRandomSite();

		// wait for element is clickeable
		createPage.getDriverManager().driverWait();

		// wait for element is clickeable
		createPage.getDriverManager().driverWait();

		// wait for element is clickeable
		createPage.getDriverManager().driverWait();

		// go to the sites page
		createPage.getDriverManager().getDriver().findElement(By.cssSelector("#sitesRightNav")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// select the about us option
		homePage.goToDashboardPage();

		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait();

		dashboardPage.clickUsersContextualNavigationOption();

		// wait for element is clickeable
		usersPage.getDriverManager().driverWait();

		// Checking if the UsersPage was Loaded
		Assert.assertTrue(usersPage.getDriverManager().getDriver().getCurrentUrl()
				.equals("http://localhost:8080/studio/#/users"));

		// Checking if the Users title is displayed on the current page
		Assert.assertTrue(usersPage.isUsersPageTitlePresent());

		// go back to Sites Page
		usersPage.clickOnCrafterLogo();

	}
}
