package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

public class DuplicateOptionTest {

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
		this.previewPage = new PreviewPage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

//	public void selectContentTypeToTheTest() {
//		// go to admin console page
//
//		driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();
//
//		// wait for element is clickeable
//
//		homePage.getDriverManager().driverWait();
//
//		// select content types
//		siteConfigPage.selectContentTypeOption();
//
//		// open content types
//
//		siteConfigPage.clickExistingTypeOption();
//
//		// wait for element is clickeable
//
//		homePage.getDriverManager().driverWait();
//
//		// Select the Entry content type
//
//		siteConfigPage.selectEntryContentType();
//
//		// Confirm the content type selected
//
//		siteConfigPage.confirmContentTypeSelected();
//
//	}

	public void changeBodyToNotRequiredOnEntryContent() {

		previewPage.changeBodyOfEntryContentPageToNotRequired();

	}

//	public void bodyNotRequired() {
//		// select main content
//
//		driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();
//
//		// wait for element is clickeable
//
//		homePage.getDriverManager().driverWait();
//
//		// Body not required
//
//		driverManager.getDriver()
//				.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();
//
//		// wait for element is clickeable
//
//		homePage.getDriverManager().driverWait();
//
//		// save
//
//		siteConfigPage.saveDragAndDropProcess();
//	}

	public void createNewContent() {
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

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Set the title of main content

		driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

	}

	public void duplicateContentCreated() {
		// click on duplicate

		dashboardPage.clickOnDuplicateOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on duplicate in the popup
		driverManager.getDriver().findElement(By.id("yui-gen1-button")).click();
		driverManager.driverWait();
		
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).clear();

		// wait for element

		homePage.getDriverManager().driverWait();

		// edit internal name

		dashboardPage.editInternalName("COPY");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
	}

	public void goToPreviewPage() {
		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeabl
		homePage.getDriverManager().driverWait();

	}

	@Test(priority = 0)

	public void duplicateMenuOption() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// goto preview page

		goToPreviewPage();

		// select the content type to the test
		changeBodyToNotRequiredOnEntryContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand home content

		dashboardPage.expandHomeTree();

		// create a new content

		createNewContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select the content to duplicate.
		driverManager.getDriver().findElement(By.xpath(".//span[contains(text(),'Testing1')]")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Duplicate content created

		duplicateContentCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert
		String duplicate = driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel3")).getText();
		Assert.assertEquals(duplicate, "COPY");

	}

}
