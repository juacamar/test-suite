package org.craftercms.studio.test.cases.previewtoolstestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.craftercms.studio.test.cases.BaseTest;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DesignOfPreviewToolsPanelTest extends BaseTest {
	
	private String userName;
	private String password;

	private String previewToolsPanel;

	@BeforeMethod
	public void beforeTest() {
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		previewToolsPanel = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.previewtools.mainpanel");
	}

	@Test(priority = 0)

	public void verifyTheDesignOfPreviewToolsSectionTest() {
		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// go to dashboard page
		homePage.goToPreviewPage();
		
		// Click on Preview Tools icon (show)
		previewPage.clickOnPreviewTools();

		// Assert
		WebElement previewToolsShow = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", previewToolsPanel);
		Assert.assertTrue(previewToolsShow.isDisplayed(), "ERROR: Preview tools panel is not displayed");

		// Click on Preview Tools icon (hide)
		previewPage.clickOnPreviewTools();
		
		driverManager.getDriver().navigate().refresh();
		
		// Assert
		Assert.assertFalse(this.driverManager.isElementPresentByXpath(previewToolsPanel),
				"ERROR: Preview tools panel should not be displayed");

	}

}