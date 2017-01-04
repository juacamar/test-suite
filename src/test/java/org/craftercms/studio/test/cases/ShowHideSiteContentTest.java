package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
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

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private DashboardPage dashboardPage;

	private HomePage objHomePage;



	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);
	}

	@AfterTest
	public void afterTest() {
    driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Show_Hide_Site_Content_test() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.goToDashboardPage();

        //Expand the site content panel
		
		dashboardPage.clickOnSiteContentOption();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		//	Assert  that the site content is expanded

		String siteContentExpanded = driverManager.getDriver()
				.findElement(By.cssSelector(".acn-previewsync")).getText();
		Assert.assertEquals(siteContentExpanded, "Preview Sync");
		
		//Collapse the site content panel
		
		dashboardPage.clickOnSiteContentOption();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		//	Assert  that the site content is Collapsed

		String siteContentCollapsed = driverManager.getDriver()
				.findElement(By.cssSelector(".acn-previewsync")).getText();
		Assert.assertEquals(siteContentCollapsed, "");
	}
	
}