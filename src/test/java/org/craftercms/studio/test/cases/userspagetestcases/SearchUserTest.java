package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class SearchUserTest {

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

	public void createUser() {

		// click On Users option

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
	}

	public void searchUsers() {

		// Search user recently created

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.sendKeys("username");

		// Assert to search is properly

		String searchUsername = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
						"#container > div > div > div > div > div > table > tbody > tr > td:nth-child(1) > a")
				.getText();
		Assert.assertEquals(searchUsername, "username");

		// Search user admin

		// Cleaning search field
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.clear();

		// Search admin
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.sendKeys("admin");

		// Assert to search is properly

		String searchAdminUser = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
						"#container > div > div > div > div > div > table > tbody > tr > td:nth-child(1) > a")
				.getText();
		Assert.assertEquals(searchAdminUser, "admin");

	}

	@Test(priority = 0)

	public void searchUser() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// create new user
		createUser();

		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");

		Assert.assertTrue(newUserCreated.isDisplayed());

		// search users

		searchUsers();

		// Cleaning search field
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.clear();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

	}
}
