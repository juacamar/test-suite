/**
 * 
 */
package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author luishernandez
 *
 */
public class ContentTypesAddRichTextEditorTest {
	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;
	
	private String userName;
	private String password;
	private String controlsSectionFormSectionLocator;
	private String contentTypeContainerLocator;
	private String controlsSectionRichTextEditorLocator;
	private String contentTypeContainerFormSectionContainerLocator;
	private String contentTypeContainerRTETitleLocator;
	private String siteDropdownXpath;
	private String adminConsoleXpath;
	private String createSiteButtonXpath;
	private String sitesTitleXpath;

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
		
		this.controlsSectionFormSectionLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlssectionformsection");
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.controlsSectionRichTextEditorLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlsrte");
		this.contentTypeContainerFormSectionContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerformsectioncontainer");
		this.contentTypeContainerRTETitleLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerrtetitle");
		siteDropdownXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		adminConsoleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		createSiteButtonXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		sitesTitleXpath = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagetitle");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		// Getting the Form Section control input for drag and drop action
		WebElement FromControlSectionFormSectionElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", controlsSectionFormSectionLocator);

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer =this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", contentTypeContainerLocator);

		driverManager.dragAndDropElement(FromControlSectionFormSectionElement, ToContentTypeContainer);

		WebElement FromRTE = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", controlsSectionRichTextEditorLocator);

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", contentTypeContainerFormSectionContainerLocator);

		siteConfigPage.getDriverManager().dragAndDropElement(FromRTE, ToDefaultSection);

		// Complete the input fields basics
		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefault");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();

	}

	@Test(priority = 0)
	public void verifyThatStudioAllowsToAddARichTextEditorControlToExistingContentTypeTest() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);
		this.driverManager.isElementPresentByXpath(sitesTitleXpath);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",siteDropdownXpath)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", adminConsoleXpath).click();

		// Select the content type to the test
		siteConfigPage.selectEntryContentTypeFromAdminConsole();

		// drag and drop
		this.dragAndDrop();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// Click on input section to can view the properties
		this.driverManager.isElementPresentAndClickableByXpath(contentTypeContainerFormSectionContainerLocator);
		siteConfigPage.clickRTESection();
		
		// Asserts that fields are not empty.
		this.driverManager.isElementPresentByXpath(contentTypeContainerRTETitleLocator);
		String titleText = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",contentTypeContainerRTETitleLocator)
				.getText();

		Assert.assertTrue(titleText.contains("TestTitle"));

	}
}
