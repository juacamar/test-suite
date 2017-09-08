package org.craftercms.studio.test.cases.previewtoolstestcases;

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

public class PresetEachDesignTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private PreviewPage previewPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, uIElementsPropertiesManager);

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

		homePage.getDriverManager().driverWait(2000);

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
						"cssSelector", ".studio-ice-dialog > .bd iframe"));
						//driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("PRESET", "PRESET TESTING");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait();

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#title > div > input").sendKeys("MainTitle");
		//driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#cstudio-form-expand-all").click();
		//driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"id", "cstudioSaveAndClose").click();
		//driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void presets() {

		// open publishing channel combo
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#medium-panel-elem > div.acn-accordion-header > a").click();
		//driverManager.getDriver().findElement(By.cssSelector("#medium-panel-elem > div.acn-accordion-header > a")).click();

		//desktop prese

		 String contentURL = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
					"cssSelector", "#engineWindow").getText();
				 //driverManager.getDriver()
		// .findElement(By.cssSelector("#engineWindow")).getText();
		 Assert.assertTrue(contentURL.contains(contentURL));
	}

	@Test(priority = 0)

	public void presetDesign() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
	//	driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// body not required

		changeBodyToNotRequiredOnEntryContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		createContent();

		// Expand Home Tree

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// select content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#ygtvlabelel3").click();
		//driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel3")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// open tools
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#acn-preview-tools-image").click();
		//driverManager.getDriver().findElement(By.cssSelector("#acn-preview-tools-image")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// presets and asserts

		presets();

	}

}
