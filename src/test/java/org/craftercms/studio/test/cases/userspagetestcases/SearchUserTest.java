package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
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

	private String newUserFirstNameId;

	private String newUserLastNameId;

	private String newUserEmailId;

	private String newUserUserNameId;

	private String newUserPasswordId;

	private String newUserPasswordVerificationId;

	private String userSearchXpath;

	private String newUserUserNameXpath;

	private String searchResultUserNameXpath;

	private String deleteYesButtonXpath;

	private String usersRowsXpath;

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
		newUserFirstNameId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.firstname");
		newUserLastNameId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.lastname");
		newUserEmailId = uIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.users.email");
		newUserUserNameId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.username");
		newUserPasswordId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.password");
		newUserPasswordVerificationId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.passwordVerification");
		userSearchXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.userssearchinput");
		searchResultUserNameXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserusernamecell");
		newUserUserNameXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usernamecreated");
		deleteYesButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		usersRowsXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersrows");
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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserFirstNameId).sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserLastNameId).sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserEmailId)
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserUserNameId).sendKeys("username");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserPasswordId).sendKeys("password");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserPasswordVerificationId)
				.sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();
	}

	public void searchUsers() {

		// Search user recently created

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userSearchXpath).sendKeys("username");

		// Assert to search is properly

		String searchUsername = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", searchResultUserNameXpath).getText();
		Assert.assertEquals(searchUsername, "username");

		// Search user admin

		// Cleaning search field
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userSearchXpath).clear();

		// Search admin
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userSearchXpath).sendKeys("admin");

		// Assert to search is properly

		String searchAdminUser = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", searchResultUserNameXpath).getText();

		Assert.assertEquals(searchAdminUser, "admin");

	}

	@Test(priority = 0)

	public void searchUser() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// create new user
		createUser();

		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newUserUserNameXpath);

		Assert.assertTrue(newUserCreated.isDisplayed());

		// search users

		searchUsers();

		// Cleaning search field
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userSearchXpath).clear();

		// Click on delete user
		driverManager.getDriver().navigate().refresh();
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();

		// Assert new users created is deleted

		Assert.assertTrue(this.driverManager.elementHasChildsByXPath(usersRowsXpath));

		List<WebElement> usersList = this.driverManager.getDriver().findElements(By.xpath(usersRowsXpath));

		Assert.assertTrue(usersList.size() == 1);

	}
}
