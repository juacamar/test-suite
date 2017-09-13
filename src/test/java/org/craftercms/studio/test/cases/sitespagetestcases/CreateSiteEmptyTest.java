package org.craftercms.studio.test.cases.sitespagetestcases;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CreateSiteEmptyTest {

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreateSitePage createSitePage;



	 @BeforeClass
	 public void beforeTest() {
	 this.driverManager = new WebDriverManager();
	 UIElementsPropertiesManager uIElementsPropertiesManager = new
	 org.craftercms.studio.test.utils.UIElementsPropertiesManager(
	 FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
	 this.loginPage = new LoginPage(driverManager,
			 uIElementsPropertiesManager);
	 this.homePage = new HomePage(driverManager,
			 uIElementsPropertiesManager);
	 this.createSitePage = new CreateSitePage(driverManager,
			 uIElementsPropertiesManager);

	
	 }

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void createSiteEmpty() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		// MaximizeWindow
		//driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the Id of the site

		//createSitePage.fillIdSite("");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		//createSitePage.openBlueprintCombo();

		// Select empty blueprint

		createSitePage.selectEmptyBluePrintOption();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();
		
		// wait for element is clickeable

		//review the performance here, it is to much time aprox 38secs
		//homePage.getDriverManager().driverWait(1000);
//		homePage.getDriverManager().driverWait();
//		homePage.getDriverManager().driverWait();
//		homePage.getDriverManager().driverWait();
//		homePage.getDriverManager().driverWait();
		//driverManager.getDriver().navigate().refresh();
		// Show site content panel
		
		homePage.getDriverManager().driverWait(2000);
		
		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";
		
		if(this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(8, "xpath",
					siteDropdownElementXPath)
					.click();
		else throw new NoSuchElementException("Site creation process is taking too long time and the element was not found");
		

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert

		String head = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#activeContentActions > li:nth-child(1) > span").getText();
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span")).getText();
		Assert.assertEquals(head, "Live :");

	}

}
