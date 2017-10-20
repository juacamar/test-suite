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
	private int defaultTimeOut;
	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterClass
	public void afterTest() {
    driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Enable_Disable_Editing_In_Context_Test() {

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
		
		//Assert 
		String editIconActive = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				"/html/body/div[3]/div[1]/div[2]/div/div[2]/div/div[1]/button").getText();
		Assert.assertEquals(editIconActive, "In-Context Edit Off");
		
	}
	
}