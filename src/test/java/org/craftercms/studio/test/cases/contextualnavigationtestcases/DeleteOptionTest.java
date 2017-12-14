package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.craftercms.studio.test.cases.BaseTest;
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
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteOptionTest extends BaseTest {
	
	private String userName;
	private String password;

	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElementId;
	private String createFormMainTitleElementXPath;
	private String homeElementXPath;
	private String testingItemURLXpath;
	private String studioLogo;

	private String testItemXpath;
	

	@BeforeClass
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormMainTitleElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformTitle");
		homeElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.home");
		testingItemURLXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.myrecentactivity.firstelementurl");
		studioLogo = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		testItemXpath = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general"
			+ ".testingcontentitem");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void deletePageUsingContextualNavigationDeleteOptionTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to closes
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();

	
		// reload page
		driverManager.getDriver().navigate().refresh();

		// body not required
		this.changeBodyToNotRequiredOnEntryContent();

		driverManager.getDriver().switchTo().defaultContent();

		// expand pages folder
		dashboardPage.expandPagesTree();

		this.createContent();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", studioLogo).click();

		// wait for element is clickeable
		dashboardPage.expandHomeTree();

		// Select the content to delete.
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", testItemXpath)
				.click();

		// click on delete option
		previewPage.clickOnDeleteOption();

		// Click on Delete dependencies

		previewPage.clickOnDeleteDependencies();

		// Click nn OK Delete dependencies

		previewPage.clickOnOKDeleteDependencies();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", studioLogo).click();

		String contentDelete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				testingItemURLXpath).getText();
		Assert.assertEquals(contentDelete, "/test1");
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
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", createFormFrameElementCss));
		this.driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);


		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", createFormMainTitleElementXPath)
				.sendKeys("MainTitle");
		
		// save and close

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormSaveAndCloseElementId).click();
		
		this.driverManager.isElementPresentByXpath(homeElementXPath);

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

}
