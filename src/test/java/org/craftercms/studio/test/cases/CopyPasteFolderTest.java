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

public class CopyPasteFolderTest {

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

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.goToDashboardPage();

		// reload page

		driverManager.getDriver().navigate().refresh();

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

		// expand global entry content

		dashboardPage.expandHomeTree();

		// expand home content

		dashboardPage.clickHomeTree();

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

		// Copy the about us page to the new folder created

		dashboardPage.rightClickToCopyAboutUsToNewFolder();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// paste the content in the new folder created

		dashboardPage.rightClickToPasteToNewFolder();

		// Copy the services page to the new folder created

		dashboardPage.rightClickToCopyServicesToNewFolder();

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

		// copy about us option

		dashboardPage.rightClickToCopyOptionAboutUs();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// paste about us to about us.

		dashboardPage.rightClickToPasteOptionAboutUsToAboutUs();

		// Asserts of the new content created

		WebElement aboutUsInToServices = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]"));

		Assert.assertTrue(aboutUsInToServices.isDisplayed());

		WebElement servicesInToFolderCopied = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[2]/td[4]"));

		Assert.assertTrue(servicesInToFolderCopied.isDisplayed());

		WebElement aboutUsInToFolderCopied = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[3]/td[4]"));

		Assert.assertTrue(aboutUsInToFolderCopied.isDisplayed());

	}

}
