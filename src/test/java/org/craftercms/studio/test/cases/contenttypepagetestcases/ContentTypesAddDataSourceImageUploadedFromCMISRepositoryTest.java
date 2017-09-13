package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author luishernandez
 *
 */

public class ContentTypesAddDataSourceImageUploadedFromCMISRepositoryTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;

	private String contentTypeContainerLocator;
	private String dataSourceSectionImageUploadedFromCMISRepositoryLocator;
	private String contentTypeContainerImageUploadedFromCMISRepositoryTitleLocator;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.dataSourceSectionImageUploadedFromCMISRepositoryLocator = uIElementsPropertiesManager
				.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.datasourceimageuploadedfromCMISrepository");
		this.contentTypeContainerImageUploadedFromCMISRepositoryTitleLocator = uIElementsPropertiesManager
				.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerimageuploadedfromCMISrepositorytitle");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		driverManager.driverWait(4000);

		// Getting the ChildContent for drag and drop action
		WebElement FromDataSourceImageUploadedFromRepoElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
						dataSourceSectionImageUploadedFromCMISRepositoryLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(dataSourceSectionImageUploadedFromCMISRepositoryLocator));

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				contentTypeContainerLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(contentTypeContainerLocator));

		driverManager.dragAndDropElement(FromDataSourceImageUploadedFromRepoElement, ToContentTypeContainer);
		// wait for element

		homePage.getDriverManager().driverWait(2000);

		// Complete the input fields basics
		siteConfigPage.completeDataSourceFieldsBasics("TestTitle");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();
	}

	@Test(priority = 0)
	public void contentTypeAddDataSourceImageUploadedFromCMISRepositoryTest() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element
		homePage.getDriverManager().driverWait(1000);

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(4000);

		// reload page
		// driverManager.getDriver().navigate().refresh();

		// driverManager.driverWait();

		// Show site content panel
		// homePage.getDriverManager().driverWait();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();
		// driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
		// .click();

		// Show admin console page
		homePage.getDriverManager().driverWait(1000);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
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
		siteConfigPage.clickDataSourceImageUploadedFromCMISRepositorySection();

		// Asserts that fields are not empty.
		String titleText = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				contentTypeContainerImageUploadedFromCMISRepositoryTitleLocator).getText();
				//driverManager.getDriver()
				//.findElement(By.xpath(contentTypeContainerImageUploadedFromCMISRepositoryTitleLocator)).getText();

		Assert.assertTrue(titleText.contains("TestTitle"));

	}

}
