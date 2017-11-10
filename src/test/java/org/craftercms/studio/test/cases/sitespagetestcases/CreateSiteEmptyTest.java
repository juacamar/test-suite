package org.craftercms.studio.test.cases.sitespagetestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String createSiteButtonXpath;
	private String statusIconTopNavBar;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		createSiteButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		statusIconTopNavBar = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.statustopbaricon");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void createSiteEmpty() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Select empty blueprint

		createSitePage.selectEmptyBluePrintOption();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath);
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);
		this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteDropdownElementXPath);

		// Show site content panel
		if (this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath))
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

		// Assert
		String headStatusClass = this.driverManager.getDriver().findElement(By.xpath(statusIconTopNavBar))
				.getAttribute("class");
		Assert.assertTrue(headStatusClass.contains("live"));

	}

}
