package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class SearchUserTest {

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

	public void createUser() {

		// click On Users option

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
	}

	public void searchUsers() {

		// Search user recently created

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.sendKeys("username");

		// Assert to search is properly

		String searchUsername = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div > div > div > table > tbody > tr > td:nth-child(1) > a")
				.getText();
		Assert.assertEquals(searchUsername, "username");

		// Search user admin

		// Cleaning search field
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.clear();

		// Search admin
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.sendKeys("admin");

		// Assert to search is properly

		String searchAdminUser = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div > div > div > table > tbody > tr > td:nth-child(1) > a")
				.getText();
		Assert.assertEquals(searchAdminUser, "admin");

	}

	@Test(priority = 0)

	public void searchUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// create new user

		createUser();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert new users created is present

		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");

		Assert.assertTrue(newUserCreated.isDisplayed());

		// search users

		searchUsers();

		// Cleaning search field
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
						"#container > div > div > div > div > div > table > thead > tr:nth-child(2) > th > input")
				.clear();

		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

	}
}
