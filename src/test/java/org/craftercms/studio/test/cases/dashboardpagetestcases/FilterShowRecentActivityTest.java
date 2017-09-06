package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

public class FilterShowRecentActivityTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private SiteConfigPage siteConfigPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void bodyNotRequiered() {

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

		dashboardPage.setBasicFieldsOfNewContent("AboutUs", "AboutUs");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

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

	}

	public void createSecondContent() {
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu3();

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

		dashboardPage.setBasicFieldsOfNewContent("AboutUs1", "AboutUs1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

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
	}

	public void filtersAndAsserts() {

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
		Assert.assertEquals(edit1, "/aboutus1");

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

	@Test(priority = 0)

	public void filterShowRecentActivity() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		// Show site content panel
		driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// body not requiered

		bodyNotRequiered();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create content

		createContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand home

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// create a content with level descriptor content type

		// create another content to use a filter
		homePage.getDriverManager().driverWait();
		createSecondContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// filters and asserts
		this.filtersAndAsserts();

	}

}
