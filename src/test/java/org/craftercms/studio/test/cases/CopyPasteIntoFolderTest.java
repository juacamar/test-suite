package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

public class CopyPasteIntoFolderTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private DashboardPage dashboardPage;

	

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Copy_Folder_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// go to dashboard page

				homePage.goToDashboardPage();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// reload page

				driverManager.getDriver().navigate().refresh();

				// Show site content panel

				driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
						.click();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

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

				dashboardPage.setBasicFieldsOfNewContent("test", "ContentToCopy");

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Cancel button because path field is requeried

				driverManager.getDriver().findElement(By.id("cancelBtn")).click();

				// wait for element is clickeable

				homePage.getDriverManager().driverWait();

				// Switch back to the dashboard page

				driverManager.getDriver().switchTo().defaultContent();
				
				// Expand Home Tree
				
				dashboardPage.expandHomeTree();

		// right click to see the the menu

		dashboardPage.rightClickNewFolder();

		// Set the name of the folder

		dashboardPage.setFolderName("FolderToCopy");

		// Create folder button

		dashboardPage.clickCreateButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Copy the crafter component to the new folder created

		dashboardPage.rightClickToCopyComponentToNewFolder();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// paste the crafter component in the new folder created

		dashboardPage.rightClickToPasteToNewFolder();

		// Copy the new content  to the new folder created

		dashboardPage.rightClickToCopyNewContentToNewFolder();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// paste the content in the new folder created

		dashboardPage.rightClickToPasteToNewFolder();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Asserts of the new content created

		WebElement newContentMoved = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]"));

		Assert.assertTrue(newContentMoved.isDisplayed());

		WebElement componentMoved = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[2]/td[4]"));

		Assert.assertTrue(componentMoved.isDisplayed());

		

	}

}
