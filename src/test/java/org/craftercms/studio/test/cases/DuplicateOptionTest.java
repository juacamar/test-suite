package org.craftercms.studio.test.cases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AdminConsolePage;
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

public class DuplicateOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private AdminConsolePage adminConsolePage;

	private DashboardPage dashboardPage;

	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);
		this.adminConsolePage = new AdminConsolePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	 @AfterTest
	 public void afterTest() {
	 driverManager.closeConnection();
	 }

	@Test(priority = 0)

	public void Publishing_Site() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.GoToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show site content panel

		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		previewPage.ExpandPagesTree();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand global entry content

	   previewPage.ClickGlobalEntryTree();

		// Select the content to duplicate.

		driverManager.getDriver()
				.findElement(By
						.id("ygtvlabelel11"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on duplicate

		previewPage.ClickOnDuplicateOption();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		previewPage.getDriverManager().driverWait();

		// set the name of the duplicate content

		previewPage.DuplicateName("contentduplicated");

		// click on save&close

		previewPage.ClickOnSaveAndClose();

		// Switch back to the preview page

		driverManager.getDriver().switchTo().defaultContent();
		
		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert
		
		String duplicate = driverManager.getDriver()
		.findElement(By.id("ygtvlabelel12")).getText();
		Assert.assertEquals(duplicate, "Home | English (US)contentduplicated *");

	}

}
