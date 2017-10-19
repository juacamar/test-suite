package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
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

	private HomePage homePage;

	private CreateSitePage createSitePage;

	private UsersPage usersPage;

	private ConstantsPropertiesManager constantsPropertiesManager;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createUserToEdit() {
		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#firstName").sendKeys("Name");
		// driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#lastName")
				.sendKeys("Last Name");
		// driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last
		// Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#email")
				.sendKeys("email@email.com");
		// driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#username")
				.sendKeys("username");
		// driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#password")
				.sendKeys("password");
		// driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#passwordVerification")
				.sendKeys("password");
		// driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

	}

	public void editingUser() {
		// Click on edit option

		usersPage.clickOnEditUserCreated();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#firstName").clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#firstName").sendKeys("Test");
		// driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#lastName").clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#lastName").sendKeys("Test");
		// driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last
		// Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#email").clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#email")
				.sendKeys("Test@email.com");
		// driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#newPassword").clear();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#newPassword")
				.sendKeys("passwordEdited");
		// driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// Save Button

		usersPage.clickOnSaveNewUser();

	}

	@Test(priority = 0)

	public void editUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);
		// homePage.getDriverManager().driverWait();
		// click On Users option

		createSitePage.clickOnUsersOption();

		// create a new user

		createUserToEdit();

		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();
		homePage.getDriverManager().driverWait(3000);

		// edit user

		editingUser();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(3000);

		// Assert

		String nameElementText = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(6, "cssSelector",
						"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(2)")
				.getText();

		// driverManager.getDriver()
		// .findElement(By.cssSelector(
		// "#container > div > div > div > div > div > table > tbody > tr:nth-child(2) >
		// td:nth-child(2)"))
		// .getText();

		Assert.assertEquals(nameElementText, "Test");

		// Click on delete user
		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();
		homePage.getDriverManager().driverWait(300);

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Confirmation to delete user connected
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// driverManager.getDriver()
		// .findElement(By.cssSelector(
		// "body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div >
		// div.modal-footer.ng-scope > button:nth-child(1)"))
		// .click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert new users created is deteled

		WebElement onlyAdminUserExist = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > table > tbody");

		// driverManager.getDriver()
		// .findElement(By.cssSelector("#container > div > div > div > div > div > table
		// > tbody"));

		Assert.assertTrue(onlyAdminUserExist.isDisplayed());

	}
}
