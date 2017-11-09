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

public class EditUserTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private CreateSitePage createSitePage;
	private UsersPage usersPage;
	private String userName;
	private String password;
	private String newUserLastNameId;
	private String newUserEmailId;
	private String newUserFirstNameId;
	private String newUserUserNameId;
	private String newUserPasswordId;
	private String newUserPasswordVerificationId;
	private String newUserButtonXpath;
	private String newUserNewPasswordId;
	private String newUserLastNameCellXpath;
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

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);

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
		newUserButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserbutton");
		newUserNewPasswordId = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newpassword");
		newUserLastNameCellXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserlastnamecell");
		deleteYesButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		usersRowsXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersrows");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createUserToEdit() {
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

	public void editingUser() {
		// Click on edit option

		usersPage.clickOnEditUserCreated();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserFirstNameId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserFirstNameId).sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserLastNameId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserLastNameId).sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserEmailId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserEmailId).sendKeys("Test@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserNewPasswordId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", newUserNewPasswordId)
				.sendKeys("passwordEdited");

		// Save Button
		usersPage.clickOnSaveNewUser();
		this.driverManager.isElementPresentAndClickableByXpath(newUserButtonXpath);

	}

	@Test(priority = 0)

	public void editUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// click On Users option
		createSitePage.clickOnUsersOption();

		// create a new user

		createUserToEdit();

		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();

		// edit user
		editingUser();

		// Assert
		this.driverManager.isElementPresentAndClickableByXpath(newUserButtonXpath);
		this.driverManager.isElementPresentAndClickableByXpath(newUserButtonXpath);
		
		this.driverManager.isElementPresentByXpath(newUserLastNameCellXpath);
		String nameElementText = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameCellXpath).getText();

		Assert.assertEquals(nameElementText, "Test");

		// Click on delete user
		driverManager.getDriver().navigate().refresh();
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user 
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deleteYesButtonXpath).click();

		// Assert new users created is deleted
		Assert.assertTrue(this.driverManager.elementHasChildsByXPath(usersRowsXpath));

		List<WebElement> usersList = this.driverManager.getDriver().findElements(By.xpath(usersRowsXpath));

		Assert.assertTrue(usersList.size() == 1);

	}
}
