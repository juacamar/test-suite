package org.craftercms.studio.test.cases.sitespagetestcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
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
	
	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(this.driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(this.driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.createSitePage = new CreateSitePage(this.driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		
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
	public void createSiteWithWebSiteEditorialBluePrintTest() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo
		// Select blueprint

		createSitePage.selectWebSiteEditorialBluePrintOption();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(this.defaultTimeOut,siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(this.defaultTimeOut, "xpath", siteDropdownElementXPath)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

		// Assert

		String headStatusClass = this.driverManager.getDriver().findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span > div > span > span:nth-child(2)")).getAttribute("class");
		Assert.assertTrue(headStatusClass.contains("live"));

	}

}
