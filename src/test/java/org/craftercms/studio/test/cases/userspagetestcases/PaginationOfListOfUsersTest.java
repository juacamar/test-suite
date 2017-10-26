package org.craftercms.studio.test.cases.userspagetestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PaginationOfListOfUsersTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private CreateSitePage createSitePage;

	private UsersPage usersPage;
	
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
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createUserRandom() {

		createSitePage.clickOnUsersOption();

		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#firstName").sendKeys("Name");	
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#lastName")
				.sendKeys("Last Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#email")
				.sendKeys("email@email.com");	
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#username")
				.sendKeys(RandomStringUtils.randomAlphabetic(5));	
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#password")
				.sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#passwordVerification")
				.sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();
		
		//Refresh the site
		driverManager.getDriver().navigate().refresh();
	}

	public void navigationOfPage() {

		// Show users
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();
	
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("1");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("2");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(3) > a")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(2) > a")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(4) > a")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(1) > a")
				.click();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > div > input")
				.clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > div > input")
				.sendKeys("10");

	}

	public void deleteUser() {
		// Click on delete user
		driverManager.getDriver().navigate().refresh();
		
		usersPage.clickOnDeleteUserCreated();
		
		// Confirmation to delete user
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		driverManager.getDriver().navigate().refresh();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user 
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// wait for element is clickeable

		driverManager.getDriver().navigate().refresh();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();
		driverManager.getDriver().navigate().refresh();
	}

	@Test(priority = 0)

	public void paginationOfTheListOfUsers() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		createUserRandom();
		
		createUserRandom();
		
		createUserRandom();
		
		// filters
		navigationOfPage();

		// Delete users
		deleteUser();

	}

}
