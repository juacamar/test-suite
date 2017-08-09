package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

public class PresetEachDesignTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void notRequired() {
		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to admin console page

		driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select the Entry content type

		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// select main content

		driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Body not required

		driverManager.getDriver()
				.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save

		siteConfigPage.saveDragAndDropProcess();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

	}

	public void createContent() {
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("PRESET", "PRESET TESTING");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Set the title of main content

		driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");

		// click necessary to validate all fields required

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void presets() {

		// open publishing channel combo

		driverManager.getDriver().findElement(By.cssSelector("#medium-panel-elem > div.acn-accordion-header > a")).click();

		//desktop prese

		 String contentURL = driverManager.getDriver()
		 .findElement(By.cssSelector("#engineWindow")).getText();
		 Assert.assertTrue(contentURL.contains(contentURL));
	}

	@Test(priority = 0)

	public void presetDesign() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// body not required

		notRequired();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		createContent();

		// Expand Home Tree

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// select content

		driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel3")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// open tools

		driverManager.getDriver().findElement(By.cssSelector("#acn-preview-tools-image")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// presets and asserts

		presets();

	}

}
