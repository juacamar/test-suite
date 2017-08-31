package org.craftercms.studio.test.cases.sitespagetestcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
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

public class CreateSiteEmptyTest {

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreateSitePage createSitePage;



	 @BeforeTest
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

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void createSiteEmpty() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		// MaximizeWindow
		driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the Id of the site

		//createSitePage.fillIdSite("");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		createSitePage.openBlueprintCombo();

		// Select empty blueprint

		createSitePage.selectEmptyBlueprint();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();
		
		// wait for element is clickeable

		//review the performance here, it is to much time aprox 38secs
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();	
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();	
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
	
		// Show site content panel

		driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert

		String head = driverManager.getDriver()
				.findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span")).getText();
		Assert.assertEquals(head, "Live :");

	}

}
