package org.craftercms.studio.test.cases.previewtoolstestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DesignOfPreviewToolsPanelTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void design_preview_tools_panel() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to dashboard page

		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		//homePage.getDriverManager().driverWait();
		// Click on Preview Tools icon (show)

		previewPage.clickOnPreviewTools();

		// Assert

		WebElement previewToolsShow = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#preview-tools-panel-container.yui-module.yui-overlay.yui-panel");
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#preview-tools-panel-container.yui-module.yui-overlay.yui-panel"));

		Assert.assertTrue(previewToolsShow.isDisplayed());

		// Click on Preview Tools icon (hide)

		previewPage.clickOnPreviewTools();

		// Assert
		homePage.getDriverManager().driverWait(2000);
//		WebElement previewToolsHide = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
//				"cssSelector", "#preview-tools-panel-container.yui-module.yui-overlay.yui-panel");
//				//driverManager.getDriver()
//				//.findElement(By.cssSelector("#preview-tools-panel-container.yui-module.yui-overlay.yui-panel"));

		Assert.assertFalse(this.driverManager.isElementPresentBycssSelector( "#preview-tools-panel-container.yui-module.yui-overlay.yui-panel"));

	}

}