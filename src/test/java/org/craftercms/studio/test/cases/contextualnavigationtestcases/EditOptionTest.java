package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditOptionTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(EditOptionTest.class);

	private String userName;
	private String password;
	private String adminConsoleXpath;
	private String entryContentTypeBodyXpath;
	private String entryContentTypeBodyCheckCss;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElementId;
	private String createFormExpandAll;
	private String createFormMainTitleElementXPath;
	private String testingContentItem;
	private String topNavEditOption;
	private String createFormInternalNameTitle;
	private String siteDropDownXpath;
	private String crafterLogoId;
	private String testingItemEditedXpath;
	
	
	@BeforeClass
	public void beforeTest() {
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		adminConsoleXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormExpandAll= uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformexpandall");
		createFormMainTitleElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformMainTitle");
		testingContentItem = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.testingcontentitem");
		topNavEditOption= uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		createFormInternalNameTitle = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformfiletitle");
		siteDropDownXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		crafterLogoId = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.studiologo");
		testingItemEditedXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.testingcontentitemedited.sitecontent");
	}

	public void bodyNotRequiered() {
		logger.info("Changing body to not required");
		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", adminConsoleXpath).click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", entryContentTypeBodyXpath).click();
		

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				entryContentTypeBodyCheckCss).click();

		// save
		siteConfigPage.saveDragAndDropProcess();


	}

	public void createNewContent() {
		logger.info("Creating new content");
		driverManager.waitUntilPageLoad();
		driverManager.waitUntilSidebarOpens();
		// right click to see the the menu
		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// Set basics fields of the new content created
			dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

			// Expand all fields
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormExpandAll)
				.click();

			// Set the title of main content
			driverManager.sendText("cssSelector", createFormMainTitleElementXPath, "MainTitle");

			// save and close
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormSaveAndCloseElementId).click();
		});
	}

	public void editingContent() {
		logger.info("Editing existing content");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", testingContentItem)
				.click();

		// click edit option of the menu
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",topNavEditOption).click();


		// Switch to the iframe
		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			// edit internal title
			driverManager.sendText("xpath", createFormInternalNameTitle, "EDITED");

			// Expand all fields
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormExpandAll)
				.click();

			// save and close
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();
		});
	}

	@Test(priority = 0)

	public void verifyTheEditionOfAPageUsingContextualNavigationEditOptionTest() {
		logger.info("Starting test case");
		// login to application

		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();

		//driverManager.waitUntilSidebarOpens();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropDownXpath)
				.click();
		
		// Body Not requiered
		bodyNotRequiered();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", crafterLogoId).click();
		
		dashboardPage.expandPagesTree();

		// create a new content
		createNewContent();
		
		driverManager.getDriver().switchTo().defaultContent();
		
		//reload page
        driverManager.getDriver().navigate().refresh();
		
		dashboardPage.expandHomeTree();

		// wait for element is clickeable
		editingContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert find the new content created edited
		driverManager.waitUntilElementIsDisplayed("xpath", testingItemEditedXpath);
		 Assert.assertTrue(this.driverManager.isElementPresentByXpath(testingItemEditedXpath));

	}

}
