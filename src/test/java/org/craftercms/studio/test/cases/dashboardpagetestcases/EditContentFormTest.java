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

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		this.myRecentActivityFramePage1 = new MyRecentActivityFramePage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		// go to admin console page

		previewPage.goToAdminConsolePage();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Select the generic content type

		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// Drag and drop Form Section

		//driverManager.getDriver().manage().window().maximize();

		//driverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		
		WebElement From = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				".control-section");
				//driverManager.getDriver().findElement(By.cssSelector(".control-section"));

		WebElement To = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#content-type-canvas .content-form-name");
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#content-type-canvas .content-form-name"));

		Actions builder = new Actions(driverManager.getDriver());

		Action dragAndDrop = builder.clickAndHold(From)

		.moveToElement(To)

		.release(To)

		.build();

		dragAndDrop.perform();

		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// Drag and drop Input

		//driverManager.getDriver().manage().window().maximize();

		//driverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement FromInput = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#content-type-tools .control:nth-child(3)");
				//driverManager.getDriver()
				//.findElement(By.cssSelector("#content-type-tools .control:nth-child(3)"));

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#content-type-canvas .content-type-visual-section-container:nth-child(3)");
				//driverManager.getDriver().findElement(
				//By.cssSelector("#content-type-canvas .content-type-visual-section-container:nth-child(3)"));

		Action dragAndDropInput = builder.clickAndHold(FromInput)

		.moveToElement(ToDefaultSection)

		.release(ToDefaultSection)

		.build();

		dragAndDropInput.perform();

		// Complete the input fields basics

		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaultValue");

		// Save the data

		siteConfigPage.saveDragAndDropProcess();
	}

	public void bodyNotRequiered() {

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#admin-console").click();
		//driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

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

		homePage.getDriverManager().driverWait(1000);

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"#yui-gen9").click();
		//driverManager.getDriver().findElement(By.cssSelector("#yui-gen9")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();
		//driverManager.getDriver()
		//		.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// save

		siteConfigPage.saveDragAndDropProcess();

	}

	public void createNewContent() {

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu2();

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

		homePage.getDriverManager().driverWait(1000);

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

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

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// Assert of the test case is fine

		String contentURL = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"xpath", "/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]").getText();
				//driverManager.getDriver()
				//.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]")).getText();
		Assert.assertTrue(contentURL.contains(contentURL));

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait(1000);
	}

	public void editFormCreated() {

		// Click on edit option of recent activity section
		homePage.clickEditOptionOfRecentActivitySection();

		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
						"cssSelector", ".studio-ice-dialog > .bd iframe"));
						//driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// wait for element

		//homePage.getDriverManager().driverWait();

		// Expand default section
		myRecentActivityFramePage1.expandDefaultSection();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Clealing title text field
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#internal-name > div > input").clear();
		//driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).clear();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Typing new text on title text field
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#internal-name > div > input").sendKeys("TestQA");
		//driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).sendKeys("TestQA");

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Save and close button.
		myRecentActivityFramePage1.clickOnSaveAndCloseButton();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void clickOnEditOptionOfRecentActivitySection() {

		// Click on edit option of recent activity section
		homePage.clickEditOptionOfRecentActivitySection();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
						"cssSelector", ".studio-ice-dialog > .bd iframe"));
						//driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Expand default section
		myRecentActivityFramePage1.expandDefaultSection();

	}
	
	public void goToDashboard(){
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Go to dashboard page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"xpath", "/html/body/div[4]/div[1]/nav/div/div[1]/a/img").click();
		//driverManager.getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/nav/div/div[1]/a/img")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);
	}

	@Test(priority = 0)

	public void editContentTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);
		//homePage.getDriverManager().driverWait();
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"xpath", ".//a[@id='acn-dropdown-toggler']").click();
		//driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
		//		.click();

		// wait for element

		homePage.getDriverManager().driverWait(1000);

		// Select the content type and drag and drop

		dragAndDrop();

		// go to the dashboard page
		
		goToDashboard();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand global entry content

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// Select an existing content type

		bodyNotRequiered();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#cstudio-logo").click();
		//driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// create a new content

		createNewContent();

		// edit the form created

		editFormCreated();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// click on edit option of recently activity section

		clickOnEditOptionOfRecentActivitySection();

		// Assert validation
		String textTitle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", "#internal-name > div > input").getAttribute("value");
				//driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input"))
				//.getAttribute("value");
		Assert.assertEquals(textTitle, "TestQA");

	}
}
