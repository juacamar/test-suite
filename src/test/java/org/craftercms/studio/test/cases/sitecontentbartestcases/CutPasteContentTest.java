package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
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

public class CutPasteContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;

	private String userName;
	private String password;
	
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager,UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Cut_Paste_Content_test() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to dashboard page

		homePage.goToDashboardPage();
		
		driverManager.getDriver().navigate().refresh();
		
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		
		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#admin-console").click();
		
		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//span[contains(text(),'Body')]").click();
		

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();

		// save
		siteConfigPage.saveDragAndDropProcess();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#cstudio-logo").click();
		
		// expand pages folder
		dashboardPage.expandPagesTree();
		
		// right click to see the the menu
		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type
		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected
		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		this.driverManager.isElementPresentBycssSelector( ".studio-ice-dialog > .bd iframe");
		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "id", "cstudioSaveAndClose").click();
		// save and close
		
		driverManager.getDriver().switchTo().defaultContent();
		
		//reload page
        driverManager.getDriver().navigate().refresh();

		// expand home content

		dashboardPage.expandHomeTree();

		// right click to see the menu

		dashboardPage.rightClickToFolderOnHome();

		// Set the name of the folder

		dashboardPage.setFolderName("addnewfolder");

		// Create folder button

		dashboardPage.clickCreateButton();


		// reload page
		driverManager.getDriver().navigate().refresh();

		
		// Right click and cut content.

		dashboardPage.rightClickToCutOption();

		
		// Right click and paste content.

		dashboardPage.rightClickToPasteIntoFolder();

		// reload page

		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().navigate().refresh();
		
		// Assert of the content copied
		String contentCopied = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#MyRecentActivity-tbody > tr > td.urlCol").getText();
		Assert.assertEquals(contentCopied, "/addnewfolder/test1");

	}

}

