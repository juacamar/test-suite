package org.craftercms.studio.test.cases.sitecontentbartestcases;

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

	@AfterClass
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

		homePage.getDriverManager().driverWait(2000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
						"cssSelector", ".studio-ice-dialog > .bd iframe"));
						//driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#title > div > input").sendKeys("MainTitle");
		//driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"id", "cstudioSaveAndClose").click();
		//driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

	}

	public void duplicateContentCreated() {
		// click on duplicate
		driverManager.driverWait(4000);
		dashboardPage.clickOnDuplicateOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		//driverManager.driverWait(3000);
		// click on duplicate in the popup
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"xpath", ".//div[@id='duplicate-dialog']/div/span/span/span/button[contains(text(),'Duplicate')]").click();
		//driverManager.getDriver().findElement(By.xpath(".//div[@id='duplicate-dialog']/div/span/span/span/button[contains(text(),'Duplicate')]")).click();
		
		
		// Switch to the iframe
		driverManager.driverWait(1000);
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
						"cssSelector", ".studio-ice-dialog > .bd iframe"));
						//driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#internal-name > div > input").clear();
		//driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).clear();

		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// edit internal name

		dashboardPage.editInternalName("COPY");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"id", "cstudioSaveAndClose").click();
		//driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait(3000);

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
	}

	public void goToPreviewPage() {
		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeabl
		homePage.getDriverManager().driverWait(2000);

	}

	@Test(priority = 0)

	public void duplicateMenuOption() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// goto preview page

		goToPreviewPage();

		// select the content type to the test
		changeBodyToNotRequiredOnEntryContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#cstudio-logo").click();
		//driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand home content

		dashboardPage.expandHomeTree();

		// create a new content

		createNewContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Select the content to duplicate.
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"xpath", ".//span[contains(text(),'Testing1')]").click();
		//driverManager.getDriver().findElement(By.xpath(".//span[contains(text(),'Testing1')]")).click();

		homePage.getDriverManager().driverWait(1000);

		// Duplicate content created

		duplicateContentCreated();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// wait for element is clickeable

		//homePage.getDriverManager().driverWait();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#cstudio-logo").click();
		//driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert
		String duplicate =this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#ygtvlabelel3").getText();
				//driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel3")).getText();
		Assert.assertEquals(duplicate, "COPY");

	}

}
