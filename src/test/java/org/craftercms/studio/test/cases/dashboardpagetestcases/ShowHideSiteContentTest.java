package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
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

public class ShowHideSiteContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Show_Hide_Site_Content_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		// go to dashboard page

		homePage.goToDashboardPage();

		// Expand the site content panel
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		dashboardPage.clickOnSiteContentOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert that the site content is expanded

		String siteContentExpanded = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#admin-console").getText();
		// driverManager.getDriver().findElement(By.cssSelector("#admin-console")).getText();
		Assert.assertEquals(siteContentExpanded, "Site Config");

		// Collapse the site content panel

		dashboardPage.clickOnSiteContentOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert that the site content is Collapsed

		//String siteContentCollapsed = this.driverManager
			//	.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#admin-console").getText();
		// driverManager.getDriver().findElement(By.cssSelector("#admin-console")).getText();
		Assert.assertFalse(this.driverManager.isElementPresentBycssSelector("#admin-console"));
	}

}