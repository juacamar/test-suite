package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
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

	private CreatePage createPage;

	private UsersPage usersPage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createPage = new CreatePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createUserToEdit() {
		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

	}
	

	public void editingUser() {
		// Click on edit option

		usersPage.clickOnEditUserCreated();
		
		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Test");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Test");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("Test");

		// driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("Test");

		driverManager.getDriver().findElement(By.cssSelector("#newPassword")).sendKeys("passwordEdited");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Save Button

		usersPage.clickOnSaveNewUser();

	}
	
	@Test(priority = 0)

	public void editUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click On Users option

		createPage.clickOnUsersOption();

		// create a new user

		createUserToEdit();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// edit user

		editingUser();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert

		String contentCopied = driverManager.getDriver()
				.findElement(By.cssSelector(
						"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(2)"))
				.getText();
		Assert.assertEquals(contentCopied, "NameTest");

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert new users created is deteled

		WebElement onlyAdminUserExist = driverManager.getDriver()
				.findElement(By.cssSelector("#container > div > div > div > div > div > table > tbody"));

		Assert.assertTrue(onlyAdminUserExist.isDisplayed());

	}
}
