package org.craftercms.studio.test.cases.userspagetestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AccountManagementPage;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
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
	private CreateSitePage createSitePage;

	private String userName;
	private String password;
	private int defaultTimeOut;

	private AccountManagementPage accountManagementPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager, constantsPropertiesManager);
		this.accountManagementPage = new AccountManagementPage(driverManager, uIElementsPropertiesManager,
				constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager,
				constantsPropertiesManager);

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

	public void changePasswordUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// wait for element is clickeable
		createSitePage.clickAdmin();

		// click on settings

		createSitePage.clickOnSettingsOption();

		// change password

		accountManagementPage.changeUserPassword(userName, "123456", "123456");

		// login to application

		loginPage.loginToCrafter(userName, "123456");

		// click On admin option

		createSitePage.clickAdmin();

		// click on settings

		createSitePage.clickOnSettingsOption();

		// change password

		accountManagementPage.changeUserPassword("123456", userName, "admin");

		// login to application

		loginPage.loginToCrafter(userName, password);

		// Assert create button is present.

		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut,
				"cssSelector", ".btn.btn-default.btn-pill.btn-block");

		Assert.assertTrue(createButton.isDisplayed());

	}
}
