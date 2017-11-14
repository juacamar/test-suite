package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class AddNewContentSectionDefaultsTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private String userName;
	private String password;

	private String createFormFrameElementCss;

	private String createFormSaveAndCloseElementId;

	private String siteDropDownXpath;

	private String sectionDefaultsXpath;
	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		siteDropDownXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		sectionDefaultsXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.sectiondefaults");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createLevelDescriptorContent() {
		
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();
		
		// create a content with level descriptor content type
		// right click to see the the menu

		dashboardPage.selectLDCT(); 

		// Select Entry Content Type
		dashboardPage.clickLevelDescriptorCT();

		// Confirm the Content Type selected
		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", createFormFrameElementCss));

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormSaveAndCloseElementId).click();
	
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		// reload page
		driverManager.getDriver().navigate().refresh();
	}

	@Test(priority = 0)

	public void addLevelDescriptorItemUsingContextualClickOptionsTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", siteDropDownXpath)
				.click();

		// expand pages folder
		dashboardPage.expandPagesTree();
		
		// Expand Home Tree
		dashboardPage.expandHomeTree();

		// Create level descriptor content
		createLevelDescriptorContent();

		// Assert of the test case is fine
		String levelDescriptor = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", sectionDefaultsXpath).getText();

		
		Assert.assertEquals(levelDescriptor, "Section Defaults");

	}

}
