package org.craftercms.studio.test.cases.userspagetestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.pages.CreateSitePage;
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

	private CreateSitePage createSitePage;

	private UsersPage usersPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createUserRandom() {

		// click On Users option
		homePage.getDriverManager().driverWait(1000);
		createSitePage.clickOnUsersOption();

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
				.sendKeys(RandomStringUtils.randomAlphabetic(5));
		// driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#password")
				.sendKeys("password");
		// driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#passwordVerification")
				.sendKeys("password");
		// driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);
	}

	public void navigationOfPage() {

		// Show users
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();
		//driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
		//		.clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("1");
		//driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
		//		.sendKeys("1");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();
		//driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
		//		.clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("2");
		//driverManager.getDriver().findElement(By.cssSelector("#container > div > div > div > div > div > div > input"))
		//		.sendKeys("2");

		// navigation
		driverManager.driverWait(200);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(3) > a")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(2) > a")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(4) > a")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > dir-pagination-controls > ul > li:nth-child(1) > a")
				.click();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > div > input")
				.clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > div > input")
				.sendKeys("10");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

	}

	public void deleteUserBlockOne() {
		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();
	}

	@Test(priority = 0)

	public void paginationOfTheListOfUsers() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable	
		// Create user 1
		homePage.getDriverManager().driverWait(1000);
		createUserRandom();

		// Create user 2
		homePage.getDriverManager().driverWait(1000);
		createUserRandom();

		// Create user 3
		homePage.getDriverManager().driverWait(1000);
		createUserRandom();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// filters

		navigationOfPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Delete users block 1

		deleteUserBlockOne();

	}

}
