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

public class CreateTreeSameContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;
	
	private String userName;
	private String password;

	private String createFormFrameElementCss;

	private String createFormSaveAndCloseElementId;

	private String createFormExpandAll;

	private String studioLogo;

	private String siteDropdownElementXPath;

	private String adminConsoleXpath;

	private String entryContentTypeBodyXpath;

	private String entryContentTypeBodyCheckCss;


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
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		createFormExpandAll = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformexpandall");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		siteDropdownElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		adminConsoleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Create_Tree_Same_Content_Test() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();
		
		// reload page
		driverManager.getDriver().navigate().refresh();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				siteDropdownElementXPath).click();
		
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

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", studioLogo).click();

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


		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "services");

		// Expand all fields
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormExpandAll)
				.click();

		
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", createFormSaveAndCloseElementId).click();
		
		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// expand home content

		dashboardPage.clickHomeTree();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUs();

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Click on edit option of recent activity section
		homePage.clickOnEditOptionRecentActivity();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", createFormFrameElementCss));


		// edit internal name

		dashboardPage.editInternalName("TREE");

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 1

		dashboardPage.rightClickToPasteToTheTree1();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 2

		dashboardPage.rightClickToPasteToTheTree2();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 3

		dashboardPage.rightClickToPasteToTheTree3();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 4

		dashboardPage.rightClickToPasteToTheTree4();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert of the tree created

		String contentCopied = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", "//tr/td[contains(span, 'About usTREE')]")
				.getText();
		// driverManager.getDriver()
		// .findElement(By.xpath("//tr/td[contains(span, 'About usTREE')]")).getText();
		Assert.assertEquals(contentCopied, "About usTREE *");

	}

}
