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

public class AddNewUserTest {

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

	@Test(priority = 0)

	public void addNewUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);
		//homePage.getDriverManager().driverWait(300);
		// click On Users option

		createSitePage.clickOnUsersOption();

		// click on new user button
		this.driverManager.driverWait(1000);

		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#firstName").sendKeys("Name");
		//driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#lastName").sendKeys("Last Name");
		//driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#email").sendKeys("email@email.com");
		//driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#username").sendKeys("username");
		//driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#password").sendKeys("password");
		//driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#passwordVerification").sendKeys("password");
		//driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// wait for element is clickeable

		

		// Assert new users created is present
		homePage.getDriverManager().driverWait(300);
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");
				//driverManager.getDriver().findElement(By.cssSelector(
				//"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a"));

		Assert.assertTrue(newUserCreated.isDisplayed());

	}
}
