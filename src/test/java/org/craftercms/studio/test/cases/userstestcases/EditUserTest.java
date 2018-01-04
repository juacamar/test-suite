package org.craftercms.studio.test.cases.userstestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import org.craftercms.studio.test.cases.BaseTest;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditUserTest extends BaseTest{

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

	@BeforeMethod
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		newUserFirstNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.firstname");
		newUserLastNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.lastname");
		newUserEmailId = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.users.email");
		newUserUserNameId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.username");
		newUserPasswordId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.password");
		newUserPasswordVerificationId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.passwordVerification");
		newUserButtonXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserbutton");
		newUserNewPasswordId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newpassword");
		newUserLastNameCellXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.newuserlastnamecell");
		deleteYesButtonXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		usersRowsXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersrows");
	}

	public void createUserToEdit() {
		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId).sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId).sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId)
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserUserNameId).sendKeys("username");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserPasswordId).sendKeys("password");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserPasswordVerificationId)
				.sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();
	

	}

	public void editingUser() {
		// Click on edit option

		usersPage.clickOnEditUserCreated();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserFirstNameId).sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameId).sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserEmailId).sendKeys("Test@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserNewPasswordId).clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserNewPasswordId)
				.sendKeys("passwordEdited");

		// Save Button
		usersPage.clickOnSaveNewUser();
		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(newUserButtonXpath);

	}

	@Test(priority = 0)
	public void verifyThatStudioAllowsToEditAnUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		//Wait for login page to close
		driverManager.waitUntilLoginCloses();
		
		// click On Users option
		createSitePage.clickOnUsersOption();

		// create a new user
		createUserToEdit();

		// wait for element is clickeable
		this.driverManager.waitUntilModalCloses();

		// edit user
		editingUser();

		this.driverManager.waitUntilModalCloses();
				
		String nameElementText = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", newUserLastNameCellXpath).getText();

		Assert.assertEquals(nameElementText, "Test");

		// Click on delete user
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user 
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", deleteYesButtonXpath).click();
		
		this.driverManager.waitUntilModalCloses();
	
		// Assert new users created is deleted
		Assert.assertTrue(this.driverManager.elementHasChildsByXPath(usersRowsXpath));

		List<WebElement> usersList = this.driverManager.getDriver().findElements(By.xpath(usersRowsXpath));
		Assert.assertTrue(usersList.size() == 1);

	}
}
