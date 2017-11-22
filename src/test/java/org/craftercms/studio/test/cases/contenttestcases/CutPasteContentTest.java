package org.craftercms.studio.test.cases.contenttestcases;

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

	private String siteDropdownElementXPath;
	private String adminConsoleXpath;
	private String entryContentTypeBodyXpath;
	private String entryContentTypeBodyCheckCss;
	private String studioLogo;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElementId;
	private String createFormMainTitleElementXPath;
	private String testingItemURLXpath;
	private String newFolderCreated;
	private String dashboardMenuOption;
	
	
	
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
		siteDropdownElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		adminConsoleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormMainTitleElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.createformTitle");
		testingItemURLXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.myrecentactivity.firstelementurl");
		newFolderCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_new_folder");
		dashboardMenuOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.dashboard_menu_option");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void cutAndPasteContentUsingContextualClickOptionsTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to dashboard page

		homePage.goToDashboardPage();
		
		driverManager.getDriver().navigate().refresh();
		
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", siteDropdownElementXPath)
				.click();
		
		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", adminConsoleXpath).click();
		
		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", entryContentTypeBodyXpath).click();
		

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				entryContentTypeBodyCheckCss).click();

		// save
		siteConfigPage.saveDragAndDropProcess();
		
		// Switch to the form
		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().switchTo().defaultContent();
		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "id", studioLogo);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "id", studioLogo).click();
		
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
				"cssSelector", createFormFrameElementCss));

		this.driverManager.isElementPresentBycssSelector(createFormFrameElementCss);
		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",createFormMainTitleElementXPath)
				.sendKeys("MainTitle");
		
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "id", createFormSaveAndCloseElementId).click();
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
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", newFolderCreated);
		
		// Right click and cut content.
		dashboardPage.rightClickToCutOption();
		
		// Right click and paste content.

		dashboardPage.rightClickToPasteIntoFolder();

		// reload page

		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().navigate().refresh();
		
		this.driverManager.isElementPresentByXpath(testingItemURLXpath);
		
		// Assert of the content copied
		this.driverManager.isElementPresentByXpath(testingItemURLXpath);
		String contentCopied = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				testingItemURLXpath).getText();
		
		while(!(contentCopied.contains("/addnewfolder/test1")))
		{
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", dashboardMenuOption);
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", dashboardMenuOption).click();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
					testingItemURLXpath);
			 contentCopied = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
					testingItemURLXpath).getText();
		}
		
		Assert.assertEquals(contentCopied, "/addnewfolder/test1");
	

	}

}

