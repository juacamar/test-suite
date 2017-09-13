package org.craftercms.studio.test.cases.sitespagetestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.APIConnectionManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CreateSiteAngMemGamTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private CreateSitePage createSitePage;

	private APIConnectionManager apiConnectionManager;



	 @BeforeClass
	 public void beforeTest() {
	 this.driverManager = new WebDriverManager();
	 this.UIElementsPropertiesManager = new
	 org.craftercms.studio.test.utils.UIElementsPropertiesManager(
	 FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
	 this.loginPage = new LoginPage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.homePage = new HomePage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.createSitePage = new CreateSitePage(driverManager,
	 this.UIElementsPropertiesManager);
	 apiConnectionManager = new APIConnectionManager();
	
	 }

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
		
	}

	@Test(priority = 0)

	public void create_site_angular_memory_game() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the Id of the site

		createSitePage.fillIdSite("");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		createSitePage.openBlueprintCombo();

		// Select pluton blueprint

		createSitePage.selectAngMemGamBlueprint();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		// Show site content panel

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a")
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert

		String URL = driverManager.getDriver().getCurrentUrl();
		Assert.assertEquals(URL, apiConnectionManager+"/studio/preview/#/?page=/&site=automationsite");

	}

}
