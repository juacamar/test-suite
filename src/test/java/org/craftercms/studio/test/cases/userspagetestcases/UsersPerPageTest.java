package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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

public class UsersPerPageTest {

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

	private String deleteYesButtonXpath;

	private String usersRowsXpath;

	private String newUserButtonXpath;

	private String lastNumberOfPaginationXpath;

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
		deleteYesButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		usersRowsXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersrows");
		newUserButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserbutton");
		lastNumberOfPaginationXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.lastnumberelement");
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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserFirstNameId).sendKeys("Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserLastNameId).sendKeys("Last Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserEmailId)
				.sendKeys("email@email.com");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserUserNameId)
				.sendKeys("testuser"+RandomStringUtils.randomAlphabetic(5));
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserPasswordId).sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserPasswordVerificationId)
				.sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();
		this.driverManager.isElementPresentAndClickableByXpath(newUserButtonXpath);
	}

	public void filters() {

		// Show 1 user
		this.driverManager.isElementPresentAndClickableByXpath( usersPerPageInputXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", usersPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", usersPerPageInputXpath).sendKeys("1");

		// Asser only 1 users displayed
		this.driverManager.isElementPresentAndClickableByXpath(lastNumberOfPaginationXpath);
		Assert.assertTrue(this.driverManager.elementHasChildsByXPath(usersRowsXpath));

		List<WebElement> usersList1item = this.driverManager.getDriver().findElements(By.xpath(usersRowsXpath));
		Assert.assertTrue(usersList1item.size() == 1);
		
		driverManager.getDriver().navigate().refresh();
		
		// Show 4 users
		this.driverManager.isElementPresentAndClickableByXpath( usersPerPageInputXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", usersPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", usersPerPageInputXpath).sendKeys("4");

		// Asser 4 users displayed
		this.driverManager.isElementPresentAndClickableByXpath(lastNumberOfPaginationXpath);
		Assert.assertTrue(this.driverManager.elementHasChildsByXPath(usersRowsXpath));

		List<WebElement> usersList4items = this.driverManager.getDriver().findElements(By.xpath(usersRowsXpath));
		Assert.assertTrue(usersList4items.size() == 4);

		this.driverManager.isElementPresentAndClickableByXpath( usersPerPageInputXpath);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", usersPerPageInputXpath).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", usersPerPageInputXpath).sendKeys("10");
	}

	public void deleteUsers() {
		// Click on delete user
		driverManager.getDriver().navigate().refresh();
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected

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

		// Confirmation to delete user
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();

		driverManager.getDriver().navigate().refresh();

	}

	@Test(priority = 0)

	public void usersPerPage() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// Create user 1

		createUserRandom();

		// Create user 2
		driverManager.getDriver().navigate().refresh();
		createUserRandom();

		// Create user 3
		driverManager.getDriver().navigate().refresh();
		createUserRandom();

		driverManager.getDriver().navigate().refresh();
		
		// filters

		filters();

		// Delete users block 1
		deleteUsers();

	}

}
