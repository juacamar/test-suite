package org.craftercms.studio.test.cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CreateSiteEmptyTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private CreatePage createPage;

	private PreviewPage previewPage;

	// The following code is for the QA needs to execute the test with phantomJS

//	@BeforeTest public void setup() throws Exception { 
//		  //Set phantomjs.exe executable file path using DesiredCapabilities. 
//		  DesiredCapabilities capability = new DesiredCapabilities();
//		  capability.setCapability(PhantomJSDriverService.
//		  PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//		  "/Users/gustavoortizalfaro/Documents/workspace/phantomjs-2.1.1-macosx/bin/phantomjs"
//		  ); driver = new PhantomJSDriver(capability);
//		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); }


	// This code shows the UI and the QA can see the steps executing in real
	// time.

	 @BeforeTest
	 public void beforeTest() {
	 this.driverManager = new WebDriverManager();
	 this.UIElementsPropertiesManager = new
	 org.craftercms.studio.test.utils.UIElementsPropertiesManager(
	 FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
	 this.constantsPropertiesManager = new
	 ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
	 this.loginPage = new LoginPage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.homePage = new HomePage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.createPage = new CreatePage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.previewPage = new PreviewPage(driverManager,
	 this.UIElementsPropertiesManager);
	
	 }

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void create_site_empty() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on the create site button

		homePage.ClickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Filling the name of site

		createPage.fillSiteName("AutomationSite");

		// Filling the Id of the site

		createPage.fillIdSite("");

		// Filling the description of the site

		createPage.fillDescription("Description");

		// Open blueprint combo

		createPage.openBlueprintCombo();

		// Select pluton blueprint

		createPage.selectEmptyBlueprint();

		// Click on Create button

		createPage.clickOnCreateSiteButton();

		// Show site content panel

		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert

		String URL = driverManager.getDriver().getCurrentUrl();
		Assert.assertEquals(URL, "http://localhost:8080/studio/preview/#/?page=/&site=automationsite");

	}

}
