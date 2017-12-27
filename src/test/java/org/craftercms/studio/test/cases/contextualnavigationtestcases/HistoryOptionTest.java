package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.craftercms.studio.test.cases.BaseTest;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class HistoryOptionTest extends BaseTest{

	private String userName;
	private String password;
	private String siteDropdownXpath;
	private String homeXpath;
	private String historyDialogTitle;
	private String studioLogo;


	@BeforeMethod
	public void beforeTest() {

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		homeXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.home");
		historyDialogTitle = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.historydialogtitle");
		studioLogo = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.studiologo");
		
	}

	@Test(priority = 0)
	public void verifyThatTheHistoryDialogIsDisplayedTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();
		
		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				siteDropdownXpath).click();
		
		// expand pages folder
		previewPage.expandPagesTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", studioLogo);
		
		// expand home content
		previewPage.expandHomeTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeXpath).click();

		// click on history option
		previewPage.clickOnHistoryOption();

		// Assert
		this.driverManager.waitForAnimation();
		String historyPage = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", historyDialogTitle).getText();
		
		Assert.assertEquals(historyPage, "Version History");

	}

}
