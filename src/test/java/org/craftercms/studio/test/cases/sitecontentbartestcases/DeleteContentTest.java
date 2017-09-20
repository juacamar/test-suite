package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private PreviewPage previewPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);
		//this.siteConfigPage = new SiteConfigPage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void changeBodyToNotRequiredOnEntryContent() {

		previewPage.changeBodyOfEntryContentPageToNotRequired();

	}

	public void createContent() {
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
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);

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

		homePage.getDriverManager().driverWait(4000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	@Test(priority = 0)

	public void deleteContentTest() {

		// login to application
		loginPage.getDriverManager().driverWait(1000);

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// body not required
		this.changeBodyToNotRequiredOnEntryContent();
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		createContent();
		
		// Expand Home Tree
		dashboardPage.expandHomeTree();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(2000);

		// right click to delete

		dashboardPage.rightClickToDeleteContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(130);

		// confirmation

		dashboardPage.clicktoDeleteContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// submittal complete ok
		dashboardPage.clickOKSubmittalComplete();

		// reload page
		driverManager.getDriver().navigate().refresh();
		// wait for element
		homePage.getDriverManager().driverWait(3000);
		// wait for element
		// driverManager.driverWait();
		driverManager.getDriver().navigate().refresh();
		driverManager.driverWait(3000);

		String contentCopied = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "cssSelector",
				"#MyRecentActivity-tbody > tr:nth-child(1) > td:nth-child(4)").getText();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(1) >
		// td:nth-child(4)")).getText();
		Assert.assertEquals(contentCopied, "/test1");

	}

}
