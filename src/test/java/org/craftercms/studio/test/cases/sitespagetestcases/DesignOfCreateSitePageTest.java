package org.craftercms.studio.test.cases.sitespagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

public class DesignOfCreateSitePageTest {

	WebDriver driver;
	LoginPage objLogin;
	HomePage objHomePage;

	private WebDriverManager driverManager;
	private LoginPage loginPage;

	private String userName;
	private String password;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Design_of_create_site_page() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// Assert crafter studio logo is present.

		WebElement logoCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".navbar-brand > img");

		Assert.assertTrue(logoCrafter.isDisplayed());

		// Assert sites title is present.
		WebElement sitesLabel = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", "h1.ng-binding");

		Assert.assertTrue(sitesLabel.isDisplayed());

		// Assert create button is present.
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".btn.btn-default.btn-pill.btn-block");

		Assert.assertTrue(createButton.isDisplayed());

		// Assert admin tools is present.
		WebElement adminTools = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".nav > li:nth-child(1) > a:nth-child(1)");

		Assert.assertTrue(adminTools.isDisplayed());

		// Assert sites option is present.

		WebElement sitesOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", "li.active > a:nth-child(1)");

		Assert.assertTrue(sitesOption.isDisplayed());

		// Assert Help option is present.

		WebElement helpOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".nav > li:nth-child(3) > a:nth-child(1)");

		Assert.assertTrue(helpOption.isDisplayed());

		// Assert account option is present.
		WebElement accountOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".dropdown-toggle");
		Assert.assertTrue(accountOption.isDisplayed());

		// Assert all sites option is present.
		WebElement sitesPerPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", "#container > div > div > div.pull-right.m10 > label");

		Assert.assertTrue(sitesPerPage.isDisplayed());

		// Assert site name is present.
		WebElement sitesPerPageCombo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				 "cssSelector", "#container > div > div > div.pull-right.m10 > input");

		Assert.assertTrue(sitesPerPageCombo.isDisplayed());

	}

}
