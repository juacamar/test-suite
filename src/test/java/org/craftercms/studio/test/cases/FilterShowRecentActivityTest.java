package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AdminConsolePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.pages.AdminConsolePage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class FilterShowRecentActivityTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private DashboardPage dashboardPage;
	
	private AdminConsolePage adminConsolePage;


	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);
		this.adminConsolePage = new AdminConsolePage(driverManager, this.UIElementsPropertiesManager);

		

	}

	 @AfterTest
	 public void afterTest() {
	 driverManager.closeConnection();
	 }

	@Test(priority = 0)

	public void Filter_Show_Recent_Activity_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// go to preview page
				homePage.goToPreviewPage();

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
				adminConsolePage.selectContentTypeOption();

				// open content types

				adminConsolePage.clickExistingTypeOption();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Select the Entry content type

				adminConsolePage.selectEntryContentType();

				// Confirm the content type selected

				adminConsolePage.confirmContentTypeSelected();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// select main content

				driverManager.getDriver().findElement(By.cssSelector("#yui-gen7")).click();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Body not required

				driverManager.getDriver()
						.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// save

				adminConsolePage.saveDragAndDropProcess();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// go to dashboard

				driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

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

				dashboardPage.setBasicFieldsOfNewContent("AboutUs", "AboutUs");

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
				
				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				
		// expand home

		dashboardPage.expandHomeTree();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// reload page

		driverManager.getDriver().navigate().refresh();

		// create a content with level descriptor content type
		
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu3();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select Entry Content Type

		dashboardPage.clickLevelDescriptorCT();

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

		dashboardPage.setFileName("Level");


		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
		
		
				
		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// clean filter

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm")).clear();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Show only 1 item edited

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm"))
				.sendKeys("1", Keys.ENTER);
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// Assert filter 1

		String edit1 = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr/td[4]")).getText();
		Assert.assertEquals(edit1, "/level.html");
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// clean filter

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm")).clear();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Show only 1 item edited

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm"))
				.sendKeys("2", Keys.ENTER);
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// Assert filter 1

		String edit2 = driverManager.getDriver()
				.findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(2) > td:nth-child(4)")).getText();
		Assert.assertEquals(edit2, "/aboutus");
	}

}
