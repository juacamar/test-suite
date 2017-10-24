package org.craftercms.studio.test.cases.dashboardpagetestcases;

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

public class EditContentRecentlyCreatedTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private DashboardPage dashboardPage;
	private PreviewPage previewPage;

	private String userName;
	private String password;
	private int defaultTimeOut;

	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

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
				defaultTimeOut, "cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector(defaultTimeOut, ".studio-ice-dialog > .bd iframe");

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Expand all fields
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-form-expand-all")
				.click();

		// Set Main Content
		// Set the title of main content
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose")
				.click();

		this.driverManager.isElementPresentByXpath(defaultTimeOut, ".//span[text()='Home']");

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void editingContentRecentlyCreated() {

		dashboardPage.rightClickToSelectEditOption();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				defaultTimeOut, "cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector(defaultTimeOut, ".studio-ice-dialog > .bd iframe");
		
		// edit internal title
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#internal-name > div > input").sendKeys("EDITED");
	
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose")
				.click();

		this.driverManager.isElementPresentByXpath(defaultTimeOut, ".//span[text()='Home']");
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	@Test(priority = 0)

	public void editContentRecentlyCreated() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// body not required
		this.changeBodyToNotRequiredOnEntryContent();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create new content
		createNewContent();

		// Expand Home Tree
		dashboardPage.expandHomeTree();

		// Edited content recently created
		driverManager.getDriver().navigate().refresh();
		
		editingContentRecentlyCreated();

		// reload page
		driverManager.getDriver().navigate().refresh();
		
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(defaultTimeOut,
				".//tbody[@id='MyRecentActivity-tbody']/tr/td/div/a[contains(text(),'Testing1EDITED')]"));
	}

}
