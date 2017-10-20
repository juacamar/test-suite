package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#firstName").sendKeys("Name");
		// driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#lastName")
				.sendKeys("Last Name");
		// driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last
		// Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#email")
				.sendKeys("email@email.com");
		// driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#username")
				.sendKeys(RandomStringUtils.randomAlphabetic(5));
		// driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#password")
				.sendKeys("password");
		// driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#passwordVerification")
				.sendKeys("password");
		// driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button
		usersPage.clickOnSaveNewUser();

	}

	public void filters() {

		// Show 8 users

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("1");


		// Asser only 8 users displayed

		WebElement user1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > a");

		Assert.assertTrue(user1.isDisplayed());


		// Show 5 users

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("2");


		// Asser only 5 users displayed

		WebElement user2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");

		Assert.assertTrue(user2.isDisplayed());


		// Show 11 users

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("3");


		// Asser only 1 user displayed

		WebElement user3 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(1) > a");

		Assert.assertTrue(user3.isDisplayed());


		// Show 11 users

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("4");


		// Asser only 1 users displayed

		WebElement user4 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > a");

		Assert.assertTrue(user4.isDisplayed());

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > div > input").sendKeys("4");
	}

	public void deleteUsers() {
		// Click on delete user
		driverManager.getDriver().navigate().refresh();
		usersPage.clickOnDeleteUserCreated();

		
		// Confirmation to delete user connected

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		driverManager.getDriver().navigate().refresh();
		
		// Click on delete user

		usersPage.clickOnDeleteUserCreated();

		
		// Confirmation to delete user
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();
		
		// Click on delete user
		usersPage.clickOnDeleteUserCreated();
		
		// Confirmation to delete user 
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

	}

	@Test(priority = 0)

	public void usersPerPage() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// Create user 1

		createUserRandom();

		// Create user 2

		createUserRandom();

		// Create user 3

		createUserRandom();

		// filters

		filters();

		// Delete users block 1
		deleteUsers();

	}

}
