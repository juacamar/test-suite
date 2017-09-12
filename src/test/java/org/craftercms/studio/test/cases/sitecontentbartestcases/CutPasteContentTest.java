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

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Cut_Paste_Content_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to dashboard page

		homePage.goToDashboardPage();
		
		driverManager.getDriver().navigate().refresh();
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);
		// homePage.getDriverManager().driverWait();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		// driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
		// .click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		// go to admin console page

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#admin-console").click();
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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#yui-gen8").click();
		// driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();

		// driverManager.getDriver()
		// .findElement(By.cssSelector("div.property-wrapper:nth-child(21) >
		// div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save

		siteConfigPage.saveDragAndDropProcess();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#cstudio-logo").click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);
		//driverManager.getDriver().switchTo().defaultContent();
		// expand pages folder

		dashboardPage.expandPagesTree();
		
		homePage.getDriverManager().driverWait(1000);

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
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Expand all fields

		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// Set Main Content

		// dashboardPage.setMetadataFields("title", "keywords");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input")).sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#cstudio-form-expand-all")
				.click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);

		// wait for element is clickeable

		// homePage.getDriverManager().driverWait(3000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// expand home content

		dashboardPage.expandHomeTree();

		// right click to see the menu

		dashboardPage.rightClickToFolderOnHome();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set the name of the folder

		dashboardPage.setFolderName("addnewfolder");

		// Create folder button

		dashboardPage.clickCreateButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// expand home content

		// dashboardPage.expandHomeTree();

		// Right click and cut content.

		dashboardPage.rightClickToCutOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption2();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element
		homePage.getDriverManager().driverWait(3000);

		// wait for element
		// homePage.getDriverManager().driverWait(3000);
		driverManager.getDriver().navigate().refresh();
		homePage.getDriverManager().driverWait(3000);

		// Assert of the content copied
		String contentCopied = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#MyRecentActivity-tbody > tr > td.urlCol").getText();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#MyRecentActivity-tbody > tr >
		// td.urlCol")).getText();
		Assert.assertEquals(contentCopied, "/addnewfolder/test1");

	}

}
