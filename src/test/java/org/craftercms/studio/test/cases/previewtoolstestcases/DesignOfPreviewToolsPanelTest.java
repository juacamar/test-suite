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
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
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

	private HomePage homePage;

	private PreviewPage previewPage;
	
	private String userName;
	private String password;

	private String previewToolsPanel;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
	
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		previewToolsPanel = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.previewtools.mainpanel");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void verifyTheDesignOfPreviewToolsSectionTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to dashboard page

		homePage.goToPreviewPage();

		
		// Click on Preview Tools icon (show)
		previewPage.clickOnPreviewTools();

		// Assert
		WebElement previewToolsShow = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", previewToolsPanel);
		Assert.assertTrue(previewToolsShow.isDisplayed());

		// Click on Preview Tools icon (hide)
		previewPage.clickOnPreviewTools();

		// Assert
		Assert.assertFalse(this.driverManager.isElementPresentByXpath(previewToolsPanel));

	}

}