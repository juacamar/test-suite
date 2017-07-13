package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AdminConsolePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.MyRecentActivityFramePage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

import java.util.concurrent.TimeUnit;

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

	private AdminConsolePage adminConsolePage;

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
		this.adminConsolePage = new AdminConsolePage(driverManager, uIElementsPropertiesManager);
		this.myRecentActivityFramePage1 = new MyRecentActivityFramePage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		// go to admin console page

		previewPage.goToAdminConsolePage();

		// wait for element

		homePage.getDriverManager().driverWait();

		// select content types
		adminConsolePage.selectContentTypeOption();

		// open content types

		adminConsolePage.clickExistingTypeOption();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Select the generic content type

		adminConsolePage.selectEntryContentType();

		// Confirm the content type selected

		adminConsolePage.confirmContentTypeSelected();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Drag and drop Form Section

		driverManager.getDriver().manage().window().maximize();

		driverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement From = driverManager.getDriver().findElement(By.cssSelector(".control-section"));

		WebElement To = driverManager.getDriver()
				.findElement(By.cssSelector("#content-type-canvas .content-form-name"));

		Actions builder = new Actions(driverManager.getDriver());

		Action dragAndDrop = builder.clickAndHold(From)

		.moveToElement(To)

		.release(To)

		.build();

		dragAndDrop.perform();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Drag and drop Input

		driverManager.getDriver().manage().window().maximize();

		driverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement FromInput = driverManager.getDriver()
				.findElement(By.cssSelector("#content-type-tools .control:nth-child(3)"));

		WebElement ToDefaultSection = driverManager.getDriver().findElement(
				By.cssSelector("#content-type-canvas .content-type-visual-section-container:nth-child(3)"));

		Action dragAndDropInput = builder.clickAndHold(FromInput)

		.moveToElement(ToDefaultSection)

		.release(ToDefaultSection)

		.build();

		dragAndDropInput.perform();

		// Complete the input fields basics

		adminConsolePage.completeInputFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaultValue");

		// Save the data

		adminConsolePage.saveDragAndDropProcess();
	}

	public void bodyNotRequiered() {

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

		driverManager.getDriver().findElement(By.cssSelector("#yui-gen9")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Body not required

		driverManager.getDriver()
				.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save

		adminConsolePage.saveDragAndDropProcess();

	}

	public void createNewContent() {

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu2();

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

		// Assert of the test case is fine

		String contentURL = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]")).getText();
		Assert.assertTrue(contentURL.contains(contentURL));

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();
	}

	public void editFormCreated() {

		// Click on edit option of recent activity section
		homePage.clickEditOptionOfRecentActivitySection();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Expand default section
		myRecentActivityFramePage1.expandDefaultSection();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Clealing title text field
		driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).clear();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Typing new text on title text field
		driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).sendKeys("TestQA");

		// wait for element

		homePage.getDriverManager().driverWait();

		// Save and close button.
		myRecentActivityFramePage1.clickOnSaveAndCloseButton();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void clickOnEditOptionOfRecentActivitySection() {

		// Click on edit option of recent activity section
		homePage.clickEditOptionOfRecentActivitySection();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		// Expand default section
		myRecentActivityFramePage1.expandDefaultSection();

	}

	@Test(priority = 0)

	public void editContentOne() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element

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

		// wait for element

		homePage.getDriverManager().driverWait();

		// Select the content type and drag and drop

		dragAndDrop();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Go to dashboard page
		driverManager.getDriver().findElement(By.xpath("/html/body/div[4]/div[1]/nav/div/div[1]/a/img")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand global entry content

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select an existing content type

		bodyNotRequiered();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// create a new content

		createNewContent();

		// edit the form created

		editFormCreated();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// click on edit option of recently activity section

		clickOnEditOptionOfRecentActivitySection();

		// Assert validation
		String textTitle = driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input"))
				.getAttribute("value");
		Assert.assertEquals(textTitle, "TestQA");

	}
}
