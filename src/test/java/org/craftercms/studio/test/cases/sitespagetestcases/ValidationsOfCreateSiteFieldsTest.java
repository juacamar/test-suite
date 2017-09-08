package org.craftercms.studio.test.cases.sitespagetestcases;

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
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class ValidationsOfCreateSiteFieldsTest {

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
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Validations_Of_Create_Site() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Click on description to show the validations
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#description").click();

		// driverManager.getDriver().findElement(By.cssSelector("#description")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert Id site is required.

		WebElement siteID = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"body > div.modal.fade.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > form > div:nth-child(1) > div:nth-child(4) > small");

		Assert.assertTrue(siteID.isDisplayed());

	}

}
