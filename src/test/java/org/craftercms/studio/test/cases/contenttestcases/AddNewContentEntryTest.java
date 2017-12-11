package org.craftercms.studio.test.cases.contenttestcases;

import org.craftercms.studio.test.cases.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class AddNewContentEntryTest extends BaseTest {

	private String userName;
	private String password;

	private String createFormFrameElementCss;

	private String createFormSaveAndCloseElementId;

	private String createFormMainTitleElementXPath;

	private String testingItemRecentActivity;

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
		testingItemRecentActivity = uiElementsPropertiesManager.getSharedUIElementsLocators()
			.getProperty("general.testingcontentitem.myrecentactivity");

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

		WebElement iframe = driverManager.waitUntilElementIsClickable(
			"cssSelector", createFormFrameElementCss);
		driverManager.getDriver().switchTo().frame(iframe);

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager.waitUntilElementIsDisplayed( "xpath", createFormMainTitleElementXPath)
				.sendKeys("MainTitle");
	
		// save and close
		this.driverManager.waitUntilElementIsClickable( "id", createFormSaveAndCloseElementId).click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		driverManager.waitUntilElementIsHidden(iframe);

	}

	@Test(priority = 0)
	public void addNewPageUsingEntryContentTypeAndContextualClickOptionTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

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

		dashboardPage.expandHomeTree();

		Assert.assertNotNull(driverManager.findElement("xpath", testingItemRecentActivity));
	}

}
