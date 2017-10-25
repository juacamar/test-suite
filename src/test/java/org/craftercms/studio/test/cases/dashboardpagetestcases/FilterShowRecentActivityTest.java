package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
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

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;
	
	private String userName;
	private String password;
	

	private PreviewPage previewPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
	
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

		// Select Entry Content Type
		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected
		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				 "cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector( ".studio-ice-dialog > .bd iframe");

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("AboutUs", "AboutUs");

		// Set the title of main content
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.scrollUp();
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#cstudio-form-expand-all")
				.click();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", "cstudioSaveAndClose")
				.click();

		this.driverManager.isElementPresentByXpath( ".//span[text()='Home']");

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void createSecondContent() {
		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// Select Entry Content Type
		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				 "cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector( ".studio-ice-dialog > .bd iframe");

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("AboutUs1", "AboutUs1");

		// Set the title of main content
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.scrollUp();
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#cstudio-form-expand-all")
				.click();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", "cstudioSaveAndClose")
				.click();
		this.driverManager.isElementPresentByXpath( ".//span[text()='Home']");

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void filtersAndAsserts() {

		// clean filter
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").clear();

		// Show only 1 item edited
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").sendKeys("1", Keys.ENTER);

		this.driverManager.isElementPresentByXpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr/td[4]");
		// Assert filter 1
		String edit1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/section/div/div[4]/div[2]/table/tbody/tr/td[4]").getText();

		Assert.assertEquals(edit1, "/aboutus1");

		// clean filter
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").clear();

		// Show only 1 item edited
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#widget-showitems-MyRecentActivity.form-control.input-sm").sendKeys("2", Keys.ENTER);

		this.driverManager.isElementPresentBycssSelector("#MyRecentActivity-tbody > tr:nth-child(2) > td:nth-child(4)");
		
		// Assert filter 1
		String edit2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#MyRecentActivity-tbody > tr:nth-child(2) > td:nth-child(4)").getText();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(2) >
		// td:nth-child(4)")).getText();
		Assert.assertEquals(edit2, "/aboutus");
	}

	@Test(priority = 0)

	public void filterShowRecentActivity() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// body not requiered
		changeBodyToNotRequiredOnEntryContent();

		dashboardPage.expandPagesTree();

		// create content
		createContent();

		// expand home
		dashboardPage.expandHomeTree();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// create a content with level descriptor content type
		// create another content to use a filter
		createSecondContent();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// filters and asserts
		this.filtersAndAsserts();

	}

}
