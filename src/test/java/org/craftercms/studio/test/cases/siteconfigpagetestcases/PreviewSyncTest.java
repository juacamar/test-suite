package org.craftercms.studio.test.cases.siteconfigpagetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PreviewSyncTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private ConstantsPropertiesManager constantsPropertiesManager;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Preview_Sync() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to dashboard page

		homePage.goToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		//homePage.getDriverManager().driverWait();
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"xpath", ".//a[@id='acn-dropdown-toggler']").click();
		//driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", "#admin-console").click();
		//driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// click on preview sync option

		dashboardPage.clickOnPreviewSyncOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", "#yui-gen0-button").click();
		//driverManager.getDriver().findElement(By.cssSelector("#yui-gen0-button")).click();

	}

}
