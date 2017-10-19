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

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;

	private ConstantsPropertiesManager constantsPropertiesManager;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, this.UIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Create_Tree_Same_Content_Test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();
		// driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
		// .click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#admin-console").click();
		// driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Select the Entry content type

		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#yui-gen6").click();
		// driverManager.getDriver().findElement(By.cssSelector("#yui-gen6")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("div.property-wrapper:nth-child(21) >
		// div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save

		siteConfigPage.saveDragAndDropProcess();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#cstudio-logo").click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "services");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Expand all fields
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#cstudio-form-expand-all")
				.click();

		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// Set Main Content

		// dashboardPage.setMetadataFields("title", "keywords");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

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

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Click on edit option of recent activity section
		homePage.clickOnEditOptionRecentActivity();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// edit internal name

		dashboardPage.editInternalName("TREE");

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

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
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", "//tr/td[contains(span, 'About usTREE')]")
				.getText();
		// driverManager.getDriver()
		// .findElement(By.xpath("//tr/td[contains(span, 'About usTREE')]")).getText();
		Assert.assertEquals(contentCopied, "About usTREE *");

	}

}
