package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
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

public class PaginationOfListOfUsersTest {

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

	public void createUserRandom() {

		// click On Users option

		createPage.clickOnUsersOption();

		// click on new user button

		usersPage.clickOnNewUser();

		// Follow the form

		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");

		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");

		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");

		driverManager.getDriver().findElement(By.cssSelector("#username"))
				.sendKeys(RandomStringUtils.randomAlphabetic(5));

		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");

		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
	}

	public void navigationOfPage() {

		// Show 8 users

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.clear();

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.sendKeys("1");

		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
				.clear();
		
		driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
		.sendKeys("11");

		// navigation

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(3) > a"))
				.click();

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(2) > a"))
				.click();

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(4) > a"))
				.click();

		driverManager.getDriver()
				.findElement(By.cssSelector(
						"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(1) > a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	public void deleteUserBlockOne() {
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

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
	}

	public void deleteUsersBlockTwo() {

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

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page
		driverManager.getDriver().findElement(By.cssSelector("#homeSites")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		createPage.clickOnUsersOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	public void deleteUsersBlockThree() {

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

	}

	@Test(priority = 0)

	public void paginationOfTheListOfUsers() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Create user 1

		createUserRandom();

		// Create user 2

		createUserRandom();

		// Create user 3

		createUserRandom();

		// Create user 4

		createUserRandom();

		// Create user 5

		createUserRandom();

		// Create user 6

		createUserRandom();

		// Create user 7

		createUserRandom();

		// Create user 8

		createUserRandom();

		// Create user 9

		createUserRandom();

		// Create user 10

		createUserRandom();

		// Create user 11

		createUserRandom();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// filters

		navigationOfPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Delete users block 1

		deleteUserBlockOne();

		// delete users block 2

		deleteUsersBlockTwo();

		// delete users block 3

		deleteUsersBlockThree();
	}

}
