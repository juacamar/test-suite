package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditOptionTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private SiteConfigPage siteConfigPage;

	private DashboardPage dashboardPage;

	private String userName;
	private String password;
	
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
	

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void bodyNotRequiered() {

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#admin-console").click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//span[contains(text(),'Body')]").click();
		

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();

		// save
		siteConfigPage.saveDragAndDropProcess();


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
		driverManager.isElementPresentAndClickableBycssSelector( ".studio-ice-dialog > .bd iframe");
		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Expand all fields
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#cstudio-form-expand-all")
				.click();

		
		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", "cstudioSaveAndClose").click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void editingContent() {
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//span[text()='Testing1']")
				.click();

		// click edit option of the menu
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//body/div/div[@id='studioBar']/nav/div/div/ul/li/a[contains(text(),'Edit')]").click();


		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		driverManager.isElementPresentAndClickableBycssSelector(".studio-ice-dialog > .bd iframe");
		
		
		// edit internal title
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#internal-name > div > input")
				.sendKeys("EDITED");

		
		// Expand all fields
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#cstudio-form-expand-all")
				.click();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", "cstudioSaveAndClose").click();
		
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	@Test(priority = 0)

	public void contextualNavigationEditOptionTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		
		// Body Not requiered
		bodyNotRequiered();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#cstudio-logo").click();
		
		dashboardPage.expandPagesTree();

		// create a new content
		createNewContent();
		
		driverManager.getDriver().switchTo().defaultContent();
		
		//reload page
        driverManager.getDriver().navigate().refresh();
		
		dashboardPage.expandHomeTree2();

		// wait for element is clickeable
		editingContent();

		// reload page

		driverManager.getDriver().navigate().refresh();


		// Assert find the new content created edited	
		 Assert.assertTrue(this.driverManager.isElementPresentByXpath( ".//span[contains(text(),'Testing1EDITED')]"));

	}

}
