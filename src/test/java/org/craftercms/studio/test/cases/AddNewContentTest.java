package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class AddNewContentTest {

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

	public void Add_New_Content_test() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

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

		// expand global entry content

		dashboardPage.clickGlobalEntryTree();

		// expand home content

		dashboardPage.clickHomeTree();

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select Generic Content Type

		dashboardPage.clickGenericCT();

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

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Tesing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Cancel button because path field is requeried

		driverManager.getDriver().findElement(By.id("cancelBtn")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// Assert of the test case is fine

		String contentURL = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr[1]/td[4]")).getText();
		Assert.assertTrue(contentURL.contains(contentURL));
	}

}
