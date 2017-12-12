package org.craftercms.studio.test.cases.contextualnavigationtestcases;

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

	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElementId;
	private String createFormMainTitleElementXPath;
	private String studioLogo;
	private String testItemXpath;
	private String createFormFileTitleElementCss;
	private String duplicateButtonXpath;

	private String copyTestItemXpath;
	

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
		
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormMainTitleElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformTitle");
		createFormFileTitleElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformfiletitle");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		testItemXpath = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.testingcontentitem");
		duplicateButtonXpath = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.duplicatedialog.duplicate");
		copyTestItemXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.copytestitem");
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
				"cssSelector", createFormFrameElementCss));
		
		this.driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);
		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath",createFormMainTitleElementXPath)
				.sendKeys("MainTitle");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormSaveAndCloseElementId)
				.click();
	}

	public void duplicateContentCreated() {
		dashboardPage.clickOnDuplicateOption();

		// click on duplicate in the popup
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", duplicateButtonXpath).click();
		
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				 "cssSelector",createFormFrameElementCss));
		this.driverManager.isElementPresentBycssSelector(createFormFrameElementCss);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", createFormFileTitleElementCss).clear();

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
	public void duplicatePageUsingContextualNavigationDuplicateOptionOption() {

		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to closes
		driverManager.waitUntilLoginCloses();

		// goto preview page
		goToPreviewPage();

		// select the content type to the test
		changeBodyToNotRequiredOnEntryContent();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
				"id", studioLogo).click();
		
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
				"xpath", testItemXpath).click();
		
		// Duplicate content created
		duplicateContentCreated();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"id", studioLogo).click();
	
		Assert.assertTrue(driverManager.isElementPresentByXpath(copyTestItemXpath));

	}

}
