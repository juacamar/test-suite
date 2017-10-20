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

public class AddNewUserTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	
	private String userName;
	private String password;
	private int defaultTimeOut;
	
	private CreateSitePage createSitePage;
	private UsersPage usersPage;


	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void addNewUser() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// click On Users option

		createSitePage.clickOnUsersOption();

		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#firstName").sendKeys("Name");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#lastName").sendKeys("Last Name");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#email").sendKeys("email@email.com");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#username").sendKeys("username");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#password").sendKeys("password");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#passwordVerification").sendKeys("password");
		
		// Save Button

		usersPage.clickOnSaveNewUser();
		
		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");
		
		Assert.assertTrue(newUserCreated.isDisplayed());

	}
}
