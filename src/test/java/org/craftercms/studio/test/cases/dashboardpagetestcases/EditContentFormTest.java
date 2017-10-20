package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.MyRecentActivityFramePage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditContentFormTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private PreviewPage previewPage;

	private SiteConfigPage siteConfigPage;

	private MyRecentActivityFramePage myRecentActivityFramePage1;

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
		this.myRecentActivityFramePage1 = new MyRecentActivityFramePage(driverManager, UIElementsPropertiesManager,constantsPropertiesManager);
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

	public void dragAndDrop() {

		// go to admin console page
		previewPage.goToAdminConsolePage();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// Drag and drop Form Section
		WebElement From = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				".control-section");
	

		WebElement To = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#content-type-canvas .content-form-name");
	
		Actions builder = new Actions(driverManager.getDriver());

		Action dragAndDrop = builder.clickAndHold(From)

				.moveToElement(To)

				.release(To)

				.build();

		dragAndDrop.perform();


		WebElement FromInput = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#content-type-tools .control:nth-child(3)");
		

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector",
				"#content-type-canvas .content-type-visual-section-container:nth-child(3)");
		

		Action dragAndDropInput = builder.clickAndHold(FromInput)

				.moveToElement(ToDefaultSection)

				.release(ToDefaultSection)

				.build();

		dragAndDropInput.perform();

		// Complete the input fields basics

		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaultValue");

		siteConfigPage.saveDragAndDropProcess();
	}

	public void bodyNotRequiered() {

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
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void createNewContent() {

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu2();

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

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();
		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
		// wait for element is clickeable
		driverManager.getDriver().navigate().refresh();

		// Assert of the test case is fine
		String contentURL = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				".//tbody[@id='MyRecentActivity-tbody']/tr/td/div/a[contains(text(),'Testing1')]").getText();
		// driverManager.getDriver()
		// .findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]")).getText();
		Assert.assertTrue(contentURL.contains(contentURL));

		// reload page
		driverManager.getDriver().navigate().refresh();
	}

	public void editFormCreated() {

		// Click on edit option of recent activity section
		homePage.clickEditOptionOfRecentActivitySection();


		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));

		// Expand default section
		myRecentActivityFramePage1.expandDefaultSection();

		// Clealing title text field
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#internal-name > div > input")
				.clear();

		// Typing new text on title text field
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#internal-name > div > input")
				.sendKeys("TestQA");

		// Save and close button.
		myRecentActivityFramePage1.clickOnSaveAndCloseButton();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void clickOnEditOptionOfRecentActivitySection() {

		// Click on edit option of recent activity section
		homePage.clickEditOptionOfRecentActivitySection();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		// Expand default section
		myRecentActivityFramePage1.expandDefaultSection();

	}

	public void goToDashboard() {
		// Go to dashboard page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				"/html/body/div[4]/div[1]/nav/div/div[1]/a/img").click();
	}

	@Test(priority = 0)

	public void editContentTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		
		// Select the content type and drag and drop
		dragAndDrop();
		driverManager.getDriver().switchTo().defaultContent();
	
		goToDashboard();

		dashboardPage.expandPagesTree();

		dashboardPage.expandHomeTree();

		// Select an existing content type
		bodyNotRequiered();
		driverManager.getDriver().switchTo().defaultContent();

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-logo").click();
		
		// create a new content
		createNewContent();

		// edit the form created
		editFormCreated();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// click on edit option of recently activity section
		clickOnEditOptionOfRecentActivitySection();

		// Assert validation
		String textTitle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#internal-name > div > input")
				.getAttribute("value");
		// driverManager.getDriver().findElement(By.cssSelector("#internal-name > div >
		// input"))
		// .getAttribute("value");
		Assert.assertEquals(textTitle, "TestQA");

	}
}
