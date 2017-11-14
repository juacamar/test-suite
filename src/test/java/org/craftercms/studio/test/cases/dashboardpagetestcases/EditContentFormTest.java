package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import org.craftercms.studio.test.pages.SiteConfigPage;

import org.craftercms.studio.test.pages.DashboardPage;

import org.craftercms.studio.test.pages.HomePage;

import org.craftercms.studio.test.pages.LoginPage;

import org.craftercms.studio.test.pages.MyRecentActivityFramePage;

import org.craftercms.studio.test.pages.PreviewPage;

import org.craftercms.studio.test.utils.ConstantsPropertiesManager;

import org.craftercms.studio.test.utils.FilesLocations;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;

import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 * 
 * 
 */

public class EditContentFormTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;
	private HomePage homePage;
	private PreviewPage previewPage;
	private SiteConfigPage siteConfigPage;
	private MyRecentActivityFramePage myRecentActivityFramePage1;
	private DashboardPage dashboardPage;

	private String userName;
	private String password;
	private String controlsSectionFromSection;
	private String contentFormName;
	private String controlsSectionInputLocator;
	private String contentTypeContainerFormSectionContainerLocator;
	private String adminConsoleXpath;
	private String entryContentTypeBodyXpath;
	private String entryContentTypeBodyCheckCss;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElementId;
	private String myRecentActivityTestingItem;
	private String createFormTitle;
	private String siteDropDownXpath;
	private String crafterLogoId;

	private String createFormMainTitle;

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
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager
				);
		this.myRecentActivityFramePage1 = new MyRecentActivityFramePage(driverManager, UIElementsPropertiesManager
				);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		controlsSectionFromSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlssection");
		contentFormName = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contentformname");
		controlsSectionInputLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlsinput");
		contentTypeContainerFormSectionContainerLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerformsectioncontainer");
		adminConsoleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		myRecentActivityTestingItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.testingcontentitem.myrecentactivity");
		createFormTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformfiletitle");
		createFormMainTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformMainTitle");
		siteDropDownXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		crafterLogoId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.studiologo");
	}

	@AfterClass

	public void afterTest() {

		driverManager.closeConnection();

	}

	public void dragAndDrop() {

		// go to admin console page

		previewPage.goToAdminConsolePage();

		// select content types

		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// Drag and drop Form Section

		WebElement From = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",controlsSectionFromSection);

		WebElement To = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",contentFormName);

		Actions builder = new Actions(driverManager.getDriver());

		Action dragAndDrop = builder.clickAndHold(From)

				.moveToElement(To)

				.release(To)

				.build();

		dragAndDrop.perform();

		WebElement FromInput = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",controlsSectionInputLocator);

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",contentTypeContainerFormSectionContainerLocator);

		Action dragAndDropInput = builder.clickAndHold(FromInput)

				.moveToElement(ToDefaultSection)

				.release(ToDefaultSection)

				.build();

		dragAndDropInput.perform();

		// Complete the input fields basics

		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaultValue");

		siteConfigPage.saveDragAndDropProcess();

	}

	public void bodyNotRequiered() {

		// go to admin console page

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", adminConsoleXpath).click();

		// select content types

		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// select main content

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", entryContentTypeBodyXpath)
				.click();

		// Body not required

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",entryContentTypeBodyCheckCss).click();

		// save
		siteConfigPage.saveDragAndDropProcess();
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void createNewContent() {

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu2();

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

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", createFormMainTitle)
				.sendKeys("MainTitle");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();

		// wait for element is clickeable

		driverManager.getDriver().navigate().refresh();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element is clickeable

		driverManager.getDriver().navigate().refresh();

		// Assert of the test case is fine

		String contentURL = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",myRecentActivityTestingItem).getText();

		Assert.assertTrue(contentURL.contains(contentURL));

		// reload page

		driverManager.getDriver().navigate().refresh();

	}

	public void editFormCreated() {

		// Click on edit option of recent activity section

		homePage.clickEditOptionOfRecentActivitySection();

		// Switch to the iframe

		driverManager.getDriver().switchTo().defaultContent();

		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(

				"cssSelector", createFormFrameElementCss));
		driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);

		// Expand default section

		myRecentActivityFramePage1.expandDefaultSection();

		// Clealing title text field

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormTitle)
				.clear();

		// Typing new text on title text field

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormTitle)

				.sendKeys("TestQA");

		// Save and close button.

		myRecentActivityFramePage1.clickOnSaveAndCloseButton();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void clickOnEditOptionOfRecentActivitySection() {

		// Click on edit option of recent activity section

		homePage.clickEditOptionOfRecentActivitySection();

		// Switch to the iframe

		driverManager.getDriver().switchTo().defaultContent();

		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", createFormFrameElementCss));
		driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);

		// Expand default section

		myRecentActivityFramePage1.expandDefaultSection();

	}

	public void goToDashboard() {

		// Go to dashboard page

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",crafterLogoId).click();

	}

	@Test(priority = 0)

	public void verifyTheEditionOfAPageUsingEditLinkOfRecentActivityTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page

		homePage.goToPreviewPage();

		// Show site content panel

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropDownXpath).click();

		// Select the content type and drag and drop
		dragAndDrop();

		driverManager.getDriver().switchTo().defaultContent();

		goToDashboard();

		dashboardPage.expandPagesTree();

		dashboardPage.expandHomeTree();

		// Select an existing content type

		bodyNotRequiered();

		driverManager.getDriver().switchTo().defaultContent();

		// go to dashboard

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", crafterLogoId).click();

		// create a new content

		createNewContent();

		// edit the form created

		editFormCreated();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// click on edit option of recently activity section

		clickOnEditOptionOfRecentActivitySection();

		// Assert validation

		String textTitle = this.driverManager

				.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormTitle)

				.getAttribute("value");

		Assert.assertEquals(textTitle, "TestQA");

	}

}
