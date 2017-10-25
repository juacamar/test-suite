/**
 * 
 */
package org.craftercms.studio.test.cases.userspagetestcases;


import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Luis Alonso Hernandez Monge
 *
 */

public class ShowUsersPageTest {
	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private UsersPage usersPage;
	private DashboardPage dashboardPage;
	private APIConnectionManager apiConnectionManager;

	private String userName;
	private String password;
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);
		apiConnectionManager = new APIConnectionManager();
	}

	@AfterClass
	public void afterTest() {
		//closing the conection with the webdriver
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void showUsersPage() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// Click on the Users Contextual Navigation Option
		homePage.clickUsersContextualNavigationOption();

	
		// Checking if the UsersPage was Loaded
		Assert.assertTrue(usersPage.getDriverManager().getDriver().getCurrentUrl()
				.equals(apiConnectionManager.getHeaderLocationBase()+"/studio/#/users"));

		// Checking if the Users title is displayed on the current page
		Assert.assertTrue(usersPage.isUsersPageTitlePresent());

		// go back to Sites Page
		usersPage.clickOnCrafterLogo();

		// select the about us option
		homePage.goToDashboardPage();

		dashboardPage.clickUsersContextualNavigationOption();

		// Checking if the UsersPage was Loaded
		Assert.assertTrue(usersPage.getDriverManager().getDriver().getCurrentUrl()
				.equals(apiConnectionManager.getHeaderLocationBase()+"/studio/#/users"));

		// Checking if the Users title is displayed on the current page
		Assert.assertTrue(usersPage.isUsersPageTitlePresent());

		// go back to Sites Page
		usersPage.clickOnCrafterLogo();

	}
}
