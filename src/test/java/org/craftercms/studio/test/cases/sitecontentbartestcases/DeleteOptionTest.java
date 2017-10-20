package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
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

public class DeleteOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private PreviewPage previewPage;

	private SiteConfigPage siteConfigPage;

	private DashboardPage dashboardPage;
	
	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void contextualNavigationDeleteOptionTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		
		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#admin-console").click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", ".//span[contains(text(),'Body')]").click();

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();

		// save
		siteConfigPage.saveDragAndDropProcess();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-logo").click();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create a content with level descriptor content type
		// right click to see the the menu

		WebElement home = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#ygtvlabelel1");

		this.driverManager.contextClick(this.driverManager.getDriver(), home);
	
		WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#ContextmenuWrapper0  ul li:nth-child(3)");
		addContent.click();

		// Select Entry Content Type
		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected
		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");

		// click necessary to validate all fields required
		this.driverManager.scrollUp();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-form-expand-all")
				.click();
	
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose").click();
	
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		// reload page
		driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudio-logo").click();
		// driverManager.getDriver().findElement(By.id("cstudio-logo")).click();

		// wait for element is clickeable
		dashboardPage.expandHomeTree();

		// Select the content to delete.
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", ".//span[contains(text(),'Testing1')]")
				.click();

		// click on delete option
		previewPage.clickOnDeleteOption();

		// Click on Delete dependencies

		previewPage.clickOnDeleteDependencies();

		// Click nn OK Delete dependencies

		previewPage.clickOnOKDeleteDependencies();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudio-logo").click();
	
		// reload page
		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().navigate().refresh();

		String contentDelete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#MyRecentActivity-tbody > tr:nth-child(1) > td:nth-child(4)").getText();
		Assert.assertEquals(contentDelete, "/test1");

	}

}
