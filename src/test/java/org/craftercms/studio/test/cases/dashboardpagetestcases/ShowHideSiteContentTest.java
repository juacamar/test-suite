package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class ShowHideSiteContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;
	
	private HomePage homePage;

	private DashboardPage dashboardPage;

	
	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		
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
	public void Show_Hide_Site_Content_test() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to dashboard page
		homePage.goToDashboardPage();

		dashboardPage.clickOnSiteContentOption();

		// Assert that the site content is expanded
		String siteContentExpanded = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#admin-console").getText();
		
		Assert.assertEquals(siteContentExpanded, "Site Config");

		// Collapse the site content panel
		dashboardPage.clickOnSiteContentOption();

		// Assert that the site content is Collapsed
		Assert.assertFalse(this.driverManager.isElementPresentBycssSelector(defaultTimeOut,"#admin-console"));
	}

}