package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager, constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager,
				constantsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager, constantsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createUserToEdit() {
		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#firstName")
				.sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#lastName")
				.sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#email")
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#username")
				.sendKeys("username");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#password")
				.sendKeys("password");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#passwordVerification").sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();

	}

	public void editingUser() {
		// Click on edit option

		usersPage.clickOnEditUserCreated();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#firstName")
				.clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#firstName")
				.sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#lastName")
				.clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#lastName")
				.sendKeys("Test");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#email")
				.clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#email")
				.sendKeys("Test@email.com");

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#newPassword")
				.clear();
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector", "#newPassword")
				.sendKeys("passwordEdited");

		// Save Button
		usersPage.clickOnSaveNewUser();

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

		String nameElementText = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
						"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(2)")
				.getText();

		Assert.assertEquals(nameElementText, "Test");

		// Click on delete user
		driverManager.getDriver().navigate().refresh();
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// Assert new users created is deteled

		WebElement onlyAdminUserExist = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				this.defaultTimeOut, "cssSelector", "#container > div > div > div > div > div > table > tbody");

		Assert.assertTrue(onlyAdminUserExist.isDisplayed());

	}
}
