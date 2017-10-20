package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
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
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteContentTest {

	WebDriver driver;

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
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		
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

	public void createContent() {
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();


		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();


		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		
		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.scrollUp();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-form-expand-all")
				.click();
		
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose").click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	@Test(priority = 0)

	public void deleteContentTest() {

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// body not required
		this.changeBodyToNotRequiredOnEntryContent();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		createContent();
		
		// Expand Home Tree
		dashboardPage.expandHomeTree();
		
		// right click to delete

		dashboardPage.rightClickToDeleteContent();

		// confirmation

		dashboardPage.clicktoDeleteContent();

	
		// submittal complete ok
		dashboardPage.clickOKSubmittalComplete();

		// reload page
		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().navigate().refresh();
		

		String contentCopied = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#MyRecentActivity-tbody > tr:nth-child(1) > td:nth-child(4)").getText();
		Assert.assertEquals(contentCopied, "/test1");

	}

}
