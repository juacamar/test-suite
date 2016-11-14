package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 * Costa Rica Crafter Software team
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

	public void Validations_Of_Create_Site() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on the create site button

		homePage.ClickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on Name field.

		driverManager.getDriver().findElement(By.id("name"))
		.click();
		
		// Click on Site Id field.
		
		driverManager.getDriver().findElement(By.id("siteId"))
		.click();		
		
		// Assert name is required.
		
		WebElement name = driverManager.getDriver().findElement(By.xpath("/html/body/ui-view/section/div/div/div[2]/div/div/form/div[1]/div/small"));
		  
		Assert.assertTrue(name.isDisplayed());
		
	    // Assert Id site is required.
	    
		WebElement siteID = driverManager.getDriver().findElement(By.xpath("/html/body/ui-view/section/div/div/div[2]/div/div/form/div[2]/div/small"));
		  
		Assert.assertTrue(siteID.isDisplayed());
	    
	}

}
