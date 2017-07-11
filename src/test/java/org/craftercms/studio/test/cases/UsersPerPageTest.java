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

public class UsersPerPageTest {

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

	@Test(priority = 0)

	public void addNewUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click On Users option

		createPage.clickOnUsersOption();

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

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username2");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username3");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username4");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username5");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username6");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username7");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username8");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username9");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username10");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username11");

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Some filters ramdom

		// Show 8 users

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.sendKeys("8");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 8 users displayed

		WebElement user8 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(8) > td:nth-child(6) > a"));

		Assert.assertTrue(user8.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 5 users

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.sendKeys("5");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 5 users displayed

		WebElement user5 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(5) > td:nth-child(6) > a"));

		Assert.assertTrue(user5.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 11 users

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.sendKeys("1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 1 user displayed

		WebElement user1 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(6) > a"));

		Assert.assertTrue(user1.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show 11 users

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.sendKeys("11");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Asser only 1 users displayed

		WebElement user11 = driverManager.getDriver().findElement(By.cssSelector(
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(11) > td:nth-child(6) > a"));

		Assert.assertTrue(user11.isDisplayed());

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

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

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Confirmation to delete user connected

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
				.click();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

}
