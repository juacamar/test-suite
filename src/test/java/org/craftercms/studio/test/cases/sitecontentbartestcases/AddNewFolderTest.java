package org.craftercms.studio.test.cases.sitecontentbartestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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

public class AddNewFolderTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Add_New_Folder_test() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to dashboard page

		homePage.goToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);
		// homePage.getDriverManager().driverWait();
		// homePage.getDriverManager().driverWait();
		// reload page

		// driverManager.getDriver().navigate().refresh();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();

		// driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
		// .click();

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(2000);
		// homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// right click to see the the menu

		dashboardPage.rightClickToFolderOnHome();

		// Set the name of the folder

		dashboardPage.setFolderName("addnewfolder");

		// Create folder button

		dashboardPage.clickCreateButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(2000);

		// Assert find the new folder created

		String folderName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"span.status-icon.folder.no-preview.no-preview.over-effect-set").getText();
		// driverManager.getDriver()
		// .findElement(By.cssSelector("span.status-icon.folder.no-preview.no-preview.over-effect-set")).getText();
		Assert.assertEquals(folderName, "addnewfolder");

	}

}
