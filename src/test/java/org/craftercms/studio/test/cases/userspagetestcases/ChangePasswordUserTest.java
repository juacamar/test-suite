package org.craftercms.studio.test.cases.userspagetestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AccountManagementPage;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class ChangePasswordUserTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreateSitePage createSitePage;

	private AccountManagementPage accountManagementPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.accountManagementPage = new AccountManagementPage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void changePasswordUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);
		//homePage.getDriverManager().driverWait();
		// click On admin option

		createSitePage.clickAdmin();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// click on settings

		createSitePage.clickOnSettingsOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// change password

		accountManagementPage.changeUserPassword("admin", "123456", "123456");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// login to application

		loginPage.loginToCrafter("admin", "123456");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// click On admin option

		createSitePage.clickAdmin();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// click on settings

		createSitePage.clickOnSettingsOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// change password

		accountManagementPage.changeUserPassword("123456", "admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert create button is present.

		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".btn.btn-default.btn-pill.btn-block");
				//driverManager.getDriver()
				//.findElement(By.cssSelector(".btn.btn-default.btn-pill.btn-block"));

		Assert.assertTrue(createButton.isDisplayed());

	}
}
