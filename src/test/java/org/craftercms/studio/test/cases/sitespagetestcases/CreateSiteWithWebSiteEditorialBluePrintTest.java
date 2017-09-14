package org.craftercms.studio.test.cases.sitespagetestcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
 * @author luishernandez
 *
 */

public class CreateSiteWithWebSiteEditorialBluePrintTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private CreateSitePage createSitePage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(this.driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(this.driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(this.driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void createSiteWithWebSiteEditorialBluePrintTest() {

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

		// createSitePage.fillIdSite("");

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo
		// Select blueprint

		createSitePage.selectWebSiteEditorialBluePrintOption();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait(4000);
		// homePage.getDriverManager().driverWait();
		// homePage.getDriverManager().driverWait();
		// homePage.getDriverManager().driverWait();
		// homePage.getDriverManager().driverWait();
		//driverManager.getDriver().navigate().refresh();
		// Show site content panel

		homePage.getDriverManager().driverWait(8000);
		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(15,siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(5, "xpath", siteDropdownElementXPath)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Assert

		String head = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#activeContentActions > li:nth-child(1) > span").getText();

		// driverManager.getDriver()
		// .findElement(By.cssSelector("#activeContentActions > li:nth-child(1) >
		// span")).getText();
		AssertJUnit.assertEquals(head, "Live :");

	}

}
