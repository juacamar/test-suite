package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private SiteConfigPage siteConfigPage;

	private DashboardPage dashboardPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void contextualNavigationDeleteOptionTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		// driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#admin-console").click();
		// driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Select the Entry content type

		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#yui-gen8").click();
		// driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("div.property-wrapper:nth-child(21) >
		// div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);

		// save

		siteConfigPage.saveDragAndDropProcess();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#cstudio-logo").click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// expand pages folder

		dashboardPage.expandPagesTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// create a content with level descriptor content type

		// right click to see the the menu

		WebElement home = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#ygtvlabelel1");
		// driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel1"));

		this.driverManager.contextClick(this.driverManager.getDriver(), home);
		this.driverManager.driverWait(1500);

		WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#ContextmenuWrapper0  ul li:nth-child(3)");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#ContextmenuWrapper0 ul li:nth-child(3)"));
		addContent.click();

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
		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		// homePage.getDriverManager().driverWait();

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input")).sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#cstudio-form-expand-all")
				.click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		// homePage.getDriverManager().driverWait();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudio-logo").click();
		// driverManager.getDriver().findElement(By.id("cstudio-logo")).click();

		// wait for element is clickeable
		dashboardPage.expandHomeTree();

		homePage.getDriverManager().driverWait(2000);

		// Select the content to delete.
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", ".//span[contains(text(),'Testing1')]")
				.click();
		// driverManager.getDriver().findElement(By.xpath(".//span[contains(text(),'Testing1')]")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// click on delete option

		previewPage.clickOnDeleteOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Click on Delete dependencies

		previewPage.clickOnDeleteDependencies();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Click nn OK Delete dependencies

		previewPage.clickOnOKDeleteDependencies();

		// wait for element is clickeable
		previewPage.getDriverManager().driverWait(2000);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudio-logo").click();
		// driverManager.getDriver().findElement(By.id("cstudio-logo")).click();

		// reload page
		driverManager.getDriver().navigate().refresh();
		// wait for element
		previewPage.getDriverManager().driverWait(300);
		// wait for element
		// driverManager.driverWait();
		driverManager.getDriver().navigate().refresh();
		driverManager.driverWait(4000);

		String contentDelete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "cssSelector",
				"#MyRecentActivity-tbody > tr:nth-child(1) > td:nth-child(4)").getText();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(1) >
		// td:nth-child(4)")).getText();
		Assert.assertEquals(contentDelete, "/test1");

	}

}
