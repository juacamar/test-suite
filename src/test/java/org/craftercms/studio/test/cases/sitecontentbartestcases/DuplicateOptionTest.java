package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DuplicateOptionTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private PreviewPage previewPage;
	
	private String userName;
	private String password;
	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void changeBodyToNotRequiredOnEntryContent() {

		previewPage.changeBodyOfEntryContentPageToNotRequired();

	}

	public void createNewContent() {
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();
		
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		
		this.driverManager.isElementPresentAndClickableBycssSelector( ".studio-ice-dialog > .bd iframe");
		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", "cstudioSaveAndClose")
				.click();
	}

	public void duplicateContentCreated() {
		dashboardPage.clickOnDuplicateOption();

		// click on duplicate in the popup
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", ".//div[@id='duplicate-dialog']/div/span/span/span/button[contains(text(),'Duplicate')]").click();
		
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				 "cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentBycssSelector( ".studio-ice-dialog > .bd iframe");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", "#internal-name > div > input").clear();

		// edit internal name
		dashboardPage.editInternalName("COPY");

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		// reload page
		driverManager.getDriver().navigate().refresh();
	}

	public void goToPreviewPage() {
		// go to preview page
		homePage.goToPreviewPage();
	}

	@Test(priority = 0)

	public void duplicateMenuOption() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// goto preview page
		goToPreviewPage();

		// select the content type to the test
		changeBodyToNotRequiredOnEntryContent();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", "#cstudio-logo").click();
		
		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand home content

		dashboardPage.expandHomeTree();

		// create a new content

		createNewContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Select the content to duplicate.
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", ".//span[contains(text(),'Testing1')]").click();
		
		// Duplicate content created

		duplicateContentCreated();

		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", "#cstudio-logo").click();
	
		Assert.assertTrue(driverManager.isElementPresentByXpath( ".//span[contains(text(),'COPY')]"));

	}

}
