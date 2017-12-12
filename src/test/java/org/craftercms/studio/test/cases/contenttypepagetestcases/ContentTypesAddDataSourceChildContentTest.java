package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author luishernandez
 *
 */

public class ContentTypesAddDataSourceChildContentTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;
	
	private String userName;
	private String password;
	private String contentTypeContainerLocator;
	private String dataSourceSectionChildContentLocator;
	private String contentTypeContainerChildContentTitleLocator;
	private String siteDropdownXpath;
	private String adminConsoleXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
	
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.dataSourceSectionChildContentLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.datasourcechildcontent");
		this.contentTypeContainerChildContentTitleLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerchildcontenttitle");
		siteDropdownXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		adminConsoleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		// Getting the ChildContent for drag and drop action
		WebElement FromDataSourceChildContentElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", dataSourceSectionChildContentLocator);

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				contentTypeContainerLocator);
		
		driverManager.dragAndDropElement(FromDataSourceChildContentElement, ToContentTypeContainer);

		// Complete the input fields basics
		siteConfigPage.completeDataSourceFieldsBasics("TestTitle");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();
	}

	@Test(priority = 0)
	public void verifyThatStudioAllowsToAddADataSourceChildToExistingContentTypeTest() {

		// login to application
		loginPage.loginToCrafter(
			userName,password);
		
		//Wait for login page to closes
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();
	
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				siteDropdownXpath).click();
	
		// Show admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				adminConsoleXpath).click();
		
		// Select the content type to the test
		siteConfigPage.selectEntryContentTypeFromAdminConsole();

		// drag and drop
		this.dragAndDrop();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// Click on input section to can view the properties
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",contentTypeContainerLocator);
		siteConfigPage.clickDataSourceChildContentSection();

		// Asserts that fields are not empty.
		this.driverManager.isElementPresentByXpath(contentTypeContainerChildContentTitleLocator);
		
		String titleText = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				contentTypeContainerChildContentTitleLocator).getText();
		Assert.assertTrue(titleText.contains("TestTitle"));

	}

}
