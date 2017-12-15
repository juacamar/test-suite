package org.craftercms.studio.test.cases.contenttestcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteContentTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(DeleteContentTest.class);

	private String userName;
	private String password;

	private String createFormFrameElementCss;

	private String createFormMainTitleElementXPath;

	private String createFormSaveAndCloseElementId;

	private String testingItemURLXpath;

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
		testingItemURLXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.myrecentactivity.firstelementurl");
	}

	public void changeBodyToNotRequiredOnEntryContent() {

		previewPage.changeBodyOfEntryContentPageToNotRequired();

	}

	public void createContent() {
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

			// Set the title of main content
			driverManager.sendText("xpath", createFormMainTitleElementXPath, "MainTitle");

			// save and close
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();
		});

	}

	@Test(priority = 0)

	public void deletePageUsingContextualClickDeleteOptionTest() {
		logger.info("Starting test case");
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to closes
		driverManager.waitUntilLoginCloses();

		// go to preview page
		homePage.goToPreviewPage();

		// body not required
		this.changeBodyToNotRequiredOnEntryContent();

		driverManager.waitUntilSidebarOpens();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create content

		createContent();

		driverManager.waitUntilSidebarOpens();

		// Expand Home Tree
		dashboardPage.expandHomeTree();

		// right click to delete

		dashboardPage.rightClickToDeleteContent();

		// confirmation

		dashboardPage.clicktoDeleteContent();

		// submittal complete ok
		dashboardPage.clickOKSubmittalComplete();

		String contentCopied = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", testingItemURLXpath).getText();
		Assert.assertEquals(contentCopied, "/test1");

	}

}
