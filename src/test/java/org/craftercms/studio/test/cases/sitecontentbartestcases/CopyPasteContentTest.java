package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class CopyPasteContentTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;


	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, this.UIElementsPropertiesManager);
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Copy_Paste_Content_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// go to preview page
				homePage.goToPreviewPage();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();
				homePage.getDriverManager().driverWait();

				// reload page

				//driverManager.getDriver().navigate().refresh();

				// Show site content panel
				driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
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
				
				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// expand pages folder

				dashboardPage.expandPagesTree();

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

				dashboardPage.setBasicFieldsOfNewContent("Test1", "AboutUS");

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Expand all fields

				//driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

				// Set Main Content

				//dashboardPage.setMetadataFields("title", "keywords");
				
				// Set the title of main content
				
				driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// save and close

				driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Switch back to the dashboard page

				driverManager.getDriver().switchTo().defaultContent();
				
		
		// Expand Home Tree
		
		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		
		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUs();
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Click on edit option of recent activity section
		
		homePage.clickOnEditOptionRecentActivity();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.driverWait();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();
		
		driverManager.getDriver()
		.findElement(By.cssSelector("#internal-name > div > input")).clear();
		
		// wait for element

		homePage.getDriverManager().driverWait();
				
		// edit internal name

		dashboardPage.editInternalName("COPY");

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();
		
		// Expand Home Tree
		
		//dashboardPage.expandHomeTree();

		// Assert of the content copied

		String contentCopied = driverManager.getDriver()
				.findElement(By.cssSelector("#ygtvlabelel4")).getText();
		Assert.assertEquals(contentCopied, "COPY");

	

	}

}
