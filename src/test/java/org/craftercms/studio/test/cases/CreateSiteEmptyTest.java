package org.craftercms.studio.test.cases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
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

	private CreatePage createPage;



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
	 this.createPage = new CreatePage(driverManager,
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

		createPage.fillSiteName();

		// Filling the Id of the site

		//createPage.fillIdSite("");

		// Filling the description of the site

		createPage.fillDescription("Description");

		// Open blueprint combo

		createPage.openBlueprintCombo();

		// Select empty blueprint

		createPage.selectEmptyBlueprint();

		// Click on Create button

		createPage.clickOnCreateSiteButton();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show site content panel

		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert

		String head = driverManager.getDriver()
				.findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span")).getText();
		Assert.assertEquals(head, "Live :");

	}

}
