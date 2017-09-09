/**
 * 
 */
package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author luishernandez
 *
 */
public class ContentTypesAddGroupedCheckBoxesTest {
	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;

	private String controlsSectionFormSectionLocator;
	private String contentTypeContainerLocator;
	private String controlsSectionGroupedCheckBoxesLocator;
	private String contentTypeContainerFormSectionContainerLocator;
	private String contentTypeContainerGroupedCheckBoxesTitleLocator;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		this.controlsSectionFormSectionLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlssectionformsection");
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.controlsSectionGroupedCheckBoxesLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlsgroupedcheckboxes");
		this.contentTypeContainerFormSectionContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerformsectioncontainer");
		this.contentTypeContainerGroupedCheckBoxesTitleLocator = uIElementsPropertiesManager
				.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainergroupedcheckboxestitle");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		driverManager.driverWait(3000);

		// Getting the Form Section control input for drag and drop action
		WebElement FromControlSectionFormSectionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", controlsSectionFormSectionLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(controlsSectionFormSectionLocator));

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				contentTypeContainerLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(contentTypeContainerLocator));

		driverManager.dragAndDropElement(FromControlSectionFormSectionElement, ToContentTypeContainer);
		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// driverManager.driverWait();

		WebElement FromGroupedCheckBoxes = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				controlsSectionGroupedCheckBoxesLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(controlsSectionGroupedCheckBoxesLocator));

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				contentTypeContainerFormSectionContainerLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(contentTypeContainerFormSectionContainerLocator));

		siteConfigPage.getDriverManager().dragAndDropElement(FromGroupedCheckBoxes, ToDefaultSection);

		// Complete the input fields basics
		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaul");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();

	}

	@Test(priority = 0)
	public void contentTypeAddGroupedCheckBoxesTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element
		homePage.getDriverManager().driverWait(2000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(1000);

		// Show site content panel
		// homePage.getDriverManager().driverWait();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();
		//driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
		//		.click();

		// Show admin console page
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				".//a[@id='admin-console']").click();
		//driverManager.getDriver().findElement(By.xpath(".//a[@id='admin-console']")).click();

		// wait for element
		homePage.getDriverManager().driverWait(1000);

		// Select the content type to the test
		siteConfigPage.selectEntryContentTypeFromAdminConsole();

		// wait for element
		siteConfigPage.getDriverManager().driverWait(1000);

		// drag and drop
		this.dragAndDrop();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// wait for element
		siteConfigPage.getDriverManager().driverWait(1000);

		// Select the generic content type
		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// wait for element
		homePage.getDriverManager().driverWait(2000);

		// driverManager.driverWait();

		// Click on input section to can view the properties
		siteConfigPage.clickGroupedCheckBoxSection();

		// Asserts that fields are not empty.
		String titleText = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				contentTypeContainerGroupedCheckBoxesTitleLocator).getText();
				//driverManager.getDriver()
				//.findElement(By.xpath(contentTypeContainerGroupedCheckBoxesTitleLocator)).getText();

		Assert.assertTrue(titleText.contains("TestTitle"));

	}
}