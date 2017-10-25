package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
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

public class ContentTypesDragAndDropTest {

	WebDriver driver;

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private PreviewPage previewPage;
	private SiteConfigPage siteConfigPage;
	
	private String userName;
	private String password;


	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, uIElementsPropertiesManager);		
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void contentTypesDragAndDropTest() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager
		.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//a[@id='acn-dropdown-toggler']").click();

		// go to admin console page

		previewPage.goToAdminConsolePage();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable
		WebElement From = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", ".control-section");
		
		WebElement To = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#content-type-canvas .content-form-name");

		Actions builder = new Actions(driverManager.getDriver());

		Action dragAndDrop = builder.clickAndHold(From)

				.moveToElement(To)

				.release(To)

				.build();

		dragAndDrop.perform();

		// Save the drag and drop process

		siteConfigPage.saveDragAndDropProcess();
		// validate the control added

		Assert.assertTrue(driverManager.isElementPresentBycssSelector("#content-type-canvas .content-section-name"));
		
	}

}