package org.craftercms.studio.test.cases.dashboardpagetestcases;

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
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#admin-console").click();
		// driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Select the Entry content type

		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#yui-gen8").click();
		// driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("div.property-wrapper:nth-child(21) >
		// div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);

		// save

		siteConfigPage.saveDragAndDropProcess();
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

		homePage.getDriverManager().driverWait(2000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("AboutUs", "AboutUs");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

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

		homePage.getDriverManager().driverWait(2000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	public void createSecondContent() {
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu3();

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

		dashboardPage.setBasicFieldsOfNewContent("AboutUs1", "AboutUs1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input")).sendKeys("MainTitle");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(300);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
	}

	public void filtersAndAsserts() {

		// clean filter
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").clear();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm")).clear();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Show only 1 item edited
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").sendKeys("1", Keys.ENTER);

		// driverManager.getDriver()
		// .findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm"))
		// .sendKeys("1", Keys.ENTER);

		// wait for element

		homePage.getDriverManager().driverWait(4000);

		// Assert filter 1

		String edit1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "xpath",
				"/html/body/section/div/div[4]/div[2]/table/tbody/tr/td[4]").getText();
		// driverManager.getDriver()
		// .findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr/td[4]")).getText();
		Assert.assertEquals(edit1, "/aboutus1");

		// wait for element

		homePage.getDriverManager().driverWait(3000);

		// clean filter
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").clear();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm")).clear();

		// wait for element

		homePage.getDriverManager().driverWait(3000);

		// Show only 1 item edited
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").sendKeys("2", Keys.ENTER);
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm"))
		// .sendKeys("2", Keys.ENTER);

		// wait for element

		homePage.getDriverManager().driverWait(3000);

		// Assert filter 1

		String edit2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#MyRecentActivity-tbody > tr:nth-child(2) > td:nth-child(4)").getText();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(2) >
		// td:nth-child(4)")).getText();
		Assert.assertEquals(edit2, "/aboutus");
	}

	@Test(priority = 0)

	public void filterShowRecentActivity() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		// Show site content panel
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				".//a[@id='acn-dropdown-toggler']").click();
		//driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']")).click();

		// wait for element is clickeable

		driverManager.getDriver().navigate().refresh();

		// body not requiered

		bodyNotRequiered();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#cstudio-logo").click();
		//driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder

		homePage.getDriverManager().driverWait(3000);

		dashboardPage.expandPagesTree();

		// create content

		createContent();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// expand home

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// reload page

		driverManager.getDriver().navigate().refresh();

		// create a content with level descriptor content type

		// create another content to use a filter
		homePage.getDriverManager().driverWait(4000);
		createSecondContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait(300);

		// filters and asserts
		this.filtersAndAsserts();

	}

}
