package org.craftercms.studio.test.cases.loginpagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class WrongLoginTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;


	private HomePage homePage;


	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void wrong_login_Test() {

		// login to application

		loginPage.loginToCrafter("WrongUser", "admin");
		
		// MaximizeWindow
		//driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert No login for invalid user.

		WebElement signInWrongUser = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				".alert");
				//driverManager.getDriver().findElement(By.cssSelector(".alert"));

		Assert.assertTrue(signInWrongUser.isDisplayed());

		// login to application

		loginPage.loginToCrafter("Admin", "WrongPwd");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert No login for invalid password.

		WebElement signInWrongPwd = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				".btn.btn-primary");
				//driverManager.getDriver().findElement(By.cssSelector(".btn.btn-primary"));

		Assert.assertTrue(signInWrongPwd.isDisplayed());

	}

}