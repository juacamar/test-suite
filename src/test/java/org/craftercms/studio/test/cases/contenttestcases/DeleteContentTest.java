package org.craftercms.studio.test.cases.contenttestcases;

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

	private String createFormFrameElementCss;

	private String createFormMainTitleElementXPath;

	private String createFormSaveAndCloseElementId;

	private String homeElementXPath;

	private String testingItemURLXpath;

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
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormMainTitleElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformTitle");
		homeElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.home");
		testingItemURLXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.myrecentactivity.firstelementurl");
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
		driverManager.waitUntilPageLoad();
		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", createFormFrameElementCss));
		this.driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormMainTitleElementXPath)
				.sendKeys("MainTitle");

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();
		this.driverManager.isElementPresentByXpath(homeElementXPath);

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	@Test(priority = 0)

	public void deletePageUsingContextualClickDeleteOptionTest() {

		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to closes
		driverManager.waitUntilLoginCloses();

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

		String contentCopied = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", testingItemURLXpath).getText();
		Assert.assertEquals(contentCopied, "/test1");

	}

}
