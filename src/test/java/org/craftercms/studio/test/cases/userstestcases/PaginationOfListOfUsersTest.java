package org.craftercms.studio.test.cases.userstestcases;

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
	private String newUserFirstNameId;
	private String newUserLastNameId;
	private String newUserEmailId;
	private String newUserUserNameId;
	private String newUserPasswordId;
	private String newUserPasswordVerificationId;
	private String usersPerPageInputXpath;
	private String lastNumberOfPaginationXpath;
	private String firstNumberOfPaginationXpath;
	private String lastArrowOfPaginationXpath;
	private String firstArrowOfPaginationXpath;
	private String deleteYesButtonXpath;

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
		usersPerPageInputXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersperpageinput");
		lastNumberOfPaginationXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.lastnumberelement");
		firstNumberOfPaginationXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.firstnumberelement");
		lastArrowOfPaginationXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.lastarrowelement");
		firstArrowOfPaginationXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.firstarrowelement");
		deleteYesButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");

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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserFirstNameId).sendKeys("Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserLastNameId).sendKeys("Last Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserEmailId)
				.sendKeys("email@email.com");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserUserNameId)
				.sendKeys("testuser" + RandomStringUtils.randomAlphabetic(5));
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserPasswordId).sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserPasswordVerificationId)
				.sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();

		// Refresh the site
		driverManager.getDriver().navigate().refresh();
	}

	public void navigationOfPage() {

		// Show users
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersPerPageInputXpath).clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersPerPageInputXpath).sendKeys("1");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersPerPageInputXpath).clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersPerPageInputXpath).sendKeys("2");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", lastNumberOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", firstNumberOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", lastArrowOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", firstArrowOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersPerPageInputXpath).clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersPerPageInputXpath).sendKeys("10");

	}

	public void deleteUsers() {
		// Click on delete user
		driverManager.getDriver().navigate().refresh();

		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();

		driverManager.getDriver().navigate().refresh();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();

		// wait for element is clickeable

		driverManager.getDriver().navigate().refresh();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();
		driverManager.getDriver().navigate().refresh();
	}

	@Test(priority = 0)
	public void verifyThatThePaginationOfTheListOfUsersWorksProperlyTest() {
		// login to application
		loginPage.loginToCrafter(userName, password);

		createUserRandom();
		createUserRandom();
		createUserRandom();

		// filters
		navigationOfPage();

		// Delete users
		deleteUsers();

	}

}
