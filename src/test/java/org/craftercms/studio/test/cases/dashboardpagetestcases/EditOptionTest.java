package org.craftercms.studio.test.cases.dashboardpagetestcases;

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

public class EditOptionTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private SiteConfigPage siteConfigPage;

	private DashboardPage dashboardPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void bodyNotRequiered() {

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#admin-console").click();
		// driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

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

		homePage.getDriverManager().driverWait(2000);

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

		homePage.getDriverManager().driverWait(4000);

		// save

		siteConfigPage.saveDragAndDropProcess();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

	}

	public void createNewContent() {

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#cstudio-form-expand-all")
				.click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// Set Main Content

		// dashboardPage.setMetadataFields("title", "keywords");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input")).sendKeys("MainTitle");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.driverWait(3000);
	}

	public void editingContent() {
		// Select a content to edit
		homePage.getDriverManager().driverWait(2000);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", ".//span[text()='Testing1']")
				.click();
		// driverManager.getDriver().findElement(By.xpath(".//span[text()='Testing1']")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// click edit option of the menu
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				".//body/div/div[@id='studioBar']/nav/div/div/ul/li/a[contains(text(),'Edit')]").click();

		// driverManager.getDriver()
		// .findElement(By.xpath(".//body/div/div[@id='studioBar']/nav/div/div/ul/li/a[contains(text(),'Edit')]"))
		// .click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// edit internal title
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#internal-name > div > input")
				.sendKeys("EDITED");

		// driverManager.getDriver().findElement(By.cssSelector("#internal-name > div >
		// input")).sendKeys("EDITED");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Expand all fields
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#cstudio-form-expand-all")
				.click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
	}

	@Test(priority = 0)

	public void contextualNavigationEditOptionTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		// driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Body Not requiered

		bodyNotRequiered();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#cstudio-logo").click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder
		homePage.getDriverManager().driverWait(4000);
		dashboardPage.expandPagesTree();

		// create a new content

		createNewContent();

		// Expand Home Tree
		homePage.getDriverManager().driverWait(3000);
		dashboardPage.expandHomeTree2();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);

		// wait for element is clickeable

		editingContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert find the new content created edited

		String contentEdited = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#ygtvlabelel3").getText();
		// driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel3")).getText();
		Assert.assertEquals(contentEdited, "Testing1EDITED");

	}

}
