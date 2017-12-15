package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.craftercms.studio.test.cases.BaseTest;

import org.openqa.selenium.By;

/**
 * 
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 * 
 * 
 */

public class PublishingSiteTest extends BaseTest {

	private String userName;

	private String password;

	private String createFormFrameElementCss;

	private String createFormMainTitleElementXPath;

	private String createFormSaveAndCloseElementId;

	private String testingContentItem;

	private String topNavStatusIcon;

	private String siteDropdownElementXPath;

	private String homeXpath;

	private String crafterLogoId;

	private static Logger logger = LogManager.getLogger(PublishingSiteTest.class);

	@BeforeMethod

	public void beforeTest() {

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");

		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()

				.getProperty("general.createformframe");

		createFormMainTitleElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()

				.getProperty("general.createformTitle");

		createFormSaveAndCloseElementId = uiElementsPropertiesManager.getSharedUIElementsLocators()

				.getProperty("general.saveandclosebutton");

		testingContentItem = uiElementsPropertiesManager.getSharedUIElementsLocators()

				.getProperty("general.testingcontentitem");

		topNavStatusIcon = uiElementsPropertiesManager.getSharedUIElementsLocators()

				.getProperty("general.statustopbaricon");

		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()

				.getProperty("complexscenarios.general.sitedropdown");

		homeXpath = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.home");

		crafterLogoId = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");

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

		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {

			// Set basics fields of the new content created

			logger.info("Set the fields of the new content");

			dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

			// Set the title of main content

			this.driverManager.sendText("xpath", createFormMainTitleElementXPath, "MainTitle");

			// save and close

			logger.info("Click on Save and close button");

			this.driverManager

					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", createFormSaveAndCloseElementId)
					.click();

		});

	}

	public void approveAndPublish() {

		// approve and publish

		previewPage.clickOnApprovePublish();

		// submit

		previewPage.clickOnSubmitButtonOfApprovePublish();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeXpath);

	}

	@Test(priority = 0)

	public void publishingSite() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// Wait for login page to closes

		driverManager.waitUntilLoginCloses();

		// goto preview page

		homePage.goToPreviewPage();

		// select the content type to the test

		changeBodyToNotRequiredOnEntryContent();

		// Switch to the form

		driverManager.getDriver().navigate().refresh();

		driverManager.getDriver().switchTo().defaultContent();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand home content

		dashboardPage.expandHomeTree();

		// create a new content

		createNewContent();

		// reload page
		driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", testingContentItem).click();

		// approve and publish
		approveAndPublish();

		driverManager.getDriver().navigate().refresh();

		driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", crafterLogoId).click();

		// expand pages folder
		dashboardPage.expandPagesTree();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", testingContentItem).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",topNavStatusIcon);
		this.driverManager.waitWhileElementIsDisplayedAndClickableByXpath(siteDropdownElementXPath);

		String isLifeContent = "";

		while (!(isLifeContent.contains("undefined live"))) {
			isLifeContent = this.driverManager.getDriver().findElement(By.xpath(topNavStatusIcon))
					.getAttribute("class");
			driverManager.getDriver().navigate().refresh();
			this.dashboardPage.expandHomeTree();
		}

		String elementClassValue = this.driverManager.getDriver().findElement(By.xpath(topNavStatusIcon))
				.getAttribute("class");
		Assert.assertTrue(elementClassValue.contains("undefined live"));

}
	
}
