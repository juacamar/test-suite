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
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CopyPasteContentTest {

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
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);
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
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "AboutUS");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);

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

		homePage.getDriverManager().driverWait(4000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	@Test(priority = 0)

	public void Copy_Paste_Content_test() {

		// login to application
		homePage.getDriverManager().driverWait(3000);

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// body not required
		this.changeBodyToNotRequiredOnEntryContent();

		// driverManager.getDriver().navigate().refresh();

		homePage.getDriverManager().driverWait(3000);

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		this.createContent();

		// Expand Home Tree

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		// homePage.getDriverManager().driverWait();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUs();
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait(2000);
		// Click on edit option of recent activity section

		homePage.clickOnEditOptionRecentActivity();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.driverWait(2000);
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", "#internal-name > div > input")
				.clear();
		// driverManager.getDriver().findElement(By.cssSelector("#internal-name > div >
		// input")).clear();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// edit internal name

		dashboardPage.editInternalName("COPY");

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait(4000);

		// Expand Home Tree

		// dashboardPage.expandHomeTree();

		// Assert of the content copied

		String contentCopied = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(4, "cssSelector", "#ygtvlabelel4").getText();
		// driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel4")).getText();
		Assert.assertEquals(contentCopied, "COPY");

	}

}
