package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebDriver;
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

public class EnableDisableEditingInContextTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private PreviewPage previewPage;

	private String userName;
	private String password;

	private String previewToolsInContextualEditingButton;

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

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		previewToolsInContextualEditingButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.previewtools.incontextualeditingbutton");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void verifyThatTheInContextEditingIsEnabledOrDisabledTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to dashboard page
		homePage.goToPreviewPage();

		// Click on Preview Tools icon
		previewPage.clickOnPreviewTools();

		// Expand context editing section
		previewPage.clickToExpandInContextEditing();

		// Enable/disable In Context edit
		previewPage.clickToEnableDisableInContextEditing();

		// Assert
		String editIconActive = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", previewToolsInContextualEditingButton).getText();
		Assert.assertEquals(editIconActive, "In-Context Edit Off");

	}

}