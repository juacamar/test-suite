package org.craftercms.studio.test.cases.contextualnavigationbartestcases;

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
import org.openqa.selenium.By;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PublishingSiteTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private PreviewPage previewPage;

	private DashboardPage dashboardPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);

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

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		// homePage.getDriverManager().driverWait();

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input")).sendKeys("MainTitle");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void approveAndPublish() {

		// approve and publish

		previewPage.clickOnApprovePublish();

		// wait for element is clickeable

		previewPage.getDriverManager().driverWait(1000);

		// submit

		previewPage.clickOnSubmitButtonOfApprovePublish();
		previewPage.getDriverManager().driverWait(1000);
	}

	public void reloadPage() {
		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		previewPage.getDriverManager().driverWait(3000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		previewPage.getDriverManager().driverWait(3000);

		driverManager.getDriver().navigate().refresh();
		previewPage.getDriverManager().driverWait(3000);

		driverManager.getDriver().navigate().refresh();

	}

	@Test(priority = 0)

	public void publishingSite() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		// driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		changeBodyToNotRequiredOnEntryContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(30, "cssSelector", "#cstudio-logo").click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		createContent();

		// Expand Home Tree
		this.driverManager.driverWait(2000);
		dashboardPage.expandHomeTree();

		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWait(2000);
		// this.driverManager.driverWait();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", ".//span[contains(text(),'Testing1')]")
				.click();
		// driverManager.getDriver().findElement(By.xpath(".//span[contains(text(),'Testing1')]")).click();

		homePage.getDriverManager().driverWait(1000);

		// approve and publish

		approveAndPublish();

		this.reloadPage();

		// Assert
		homePage.getDriverManager().driverWait(3000);
		
		
		String headStatusClass = this.driverManager.getDriver().findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span > div > span > span:nth-child(2)")).getAttribute("class");
//		String headClass = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
//				"#activeContentActions > li:nth-child(1) > span > div > span > span:nth-child(2)").getAttribute("class");
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#activeContentActions > li:nth-child(1) > span")).getText();
		Assert.assertTrue(headStatusClass.contains("live"));

	}

}
