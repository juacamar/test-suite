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

public class CutPasteContentTest {

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

	public void Cut_Paste_Content_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.goToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

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

				dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Expand all fields

				//driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

				// Set Main Content

				//dashboardPage.setMetadataFields("title", "keywords");
				
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
				
		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand home content

		dashboardPage.expandHomeTree();

		// right click to see the menu

		dashboardPage.rightClickToFolderOnHome();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Set the name of the folder

		dashboardPage.setFolderName("addnewfolder");

		// Create folder button

		dashboardPage.clickCreateButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// reload page

		driverManager.getDriver().navigate().refresh();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// expand home content

		//dashboardPage.expandHomeTree();

		// Right click and cut content.

		dashboardPage.rightClickToCutOption();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption2();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();
		
		//driverManager.getDriver().findElement(By.cssSelector("#ygtvt4 > a:nth-child(1)")).click();
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// Assert of the content copied

		String contentCopied = driverManager.getDriver().findElement(By.cssSelector("#MyRecentActivity-tbody > tr > td.urlCol"))
				.getText();
		Assert.assertEquals(contentCopied, "/addnewfolder/test1");


	}

}
