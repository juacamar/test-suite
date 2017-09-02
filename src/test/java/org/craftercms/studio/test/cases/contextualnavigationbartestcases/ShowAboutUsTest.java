package org.craftercms.studio.test.cases.contextualnavigationbartestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class ShowAboutUsTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;
	
	private CreateSitePage createSitePage;


	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

		
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void showAboutUs() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		//click On help option
		
		createSitePage.clickOnHelpOption();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// select the about us option
		
		createSitePage.clickOnAboutOption();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// Assert new users created is present

				WebElement aboutUsInfo = driverManager.getDriver()
						.findElement(By.cssSelector("#container > div > div > div:nth-child(2) > div"));

				Assert.assertTrue(aboutUsInfo.isDisplayed());		
		
	}
}
