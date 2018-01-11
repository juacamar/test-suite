package org.craftercms.studio.test.cases.sitestestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.craftercms.studio.test.cases.BaseTest;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PaginationOfListOfSitesTest extends BaseTest{
	
	private String userName;
	private String password;

	private String sitesPerPageInputXpath;
	private String lastNumberOfPaginationXpath;
	private String firstNumberOfPaginationXpath;
	private String lastArrowOfPaginationXpath;
	private String firstArrowOfPaginationXpath;
	private String siteDropdownElementXPath;
	private String topNavDeleteOption;
	private String topNavEditOption;
	private String topNavSitesOption;
	
	@BeforeMethod
	public void beforeTest() {
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		sitesPerPageInputXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.sitesperpageinput");
		lastNumberOfPaginationXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.lastnumberelement");
		firstNumberOfPaginationXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.firstnumberelement");
		lastArrowOfPaginationXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.lastarrowelement");
		firstArrowOfPaginationXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagination.firstarrowelement");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		topNavDeleteOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.deletetopnavoption");
		topNavEditOption= uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		topNavSitesOption= uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.preview.sitesoption");

		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();
		
		// Create Site 1
		createSitesRandom();
		// Create Site 2
		createSitesRandom();
		// Create Site 3
		createSitesRandom();
	}

	@AfterMethod
	public void afterTest() {
		// Delete Site 1
		deleteSite();
		// Delete Site 2
		deleteSite();
		// Delete Site 3
		deleteSite();
	}

	public void createSitesRandom() {

		// Click on the create site button
		homePage.clickOnCreateSiteButton();

		// Filling the name of site
		createSitePage.fillSiteName();

		// Filling the description of the site
		createSitePage.fillDescription("Description");

		// Open blueprint combo
		createSitePage.openBlueprintCombo();

		// Select empty blueprint
		createSitePage.selectEmptyBlueprint();

		// Click on Create button
		createSitePage.clickOnCreateSiteButton();

		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(siteDropdownElementXPath);
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", topNavDeleteOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", topNavEditOption);

		Assert.assertTrue(this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath));

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", topNavSitesOption).click();
	}

	public void navigationOfPage() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", sitesPerPageInputXpath).clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", sitesPerPageInputXpath).sendKeys("1");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", sitesPerPageInputXpath).clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", sitesPerPageInputXpath).sendKeys("2");

		// navigation
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", lastNumberOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", firstNumberOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", lastArrowOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", firstArrowOfPaginationXpath).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", sitesPerPageInputXpath).clear();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", sitesPerPageInputXpath).sendKeys("10");
		
		driverManager.getDriver().navigate().refresh();
		
	}

	public void deleteSite() {

		// Click on Delete icon
		homePage.clickOnDeleteSiteIcon();

		// Click on YES to confirm the delete.
		homePage.clickOnYesToDeleteSite();
		
		//Refresh the page
		driverManager.getDriver().navigate().refresh();

	}

	@Test(priority = 0)
	public void paginationOfTheListOfSites() {
		navigationOfPage();
	}

}
