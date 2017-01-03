package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

public class DesignOfPreviewPageTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private CreatePage createPage;

	private PreviewPage previewPage;

	

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.createPage = new CreatePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Design_of_preview_page() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert crafter studio logo is present.

		WebElement logoCrafter = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[1]/a/img"));

		Assert.assertTrue(logoCrafter.isDisplayed());

		// Assert site content option is present.

		WebElement siteContent = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"));

		Assert.assertTrue(siteContent.isDisplayed());

		// Assert search field is present.

		WebElement searchField = driverManager.getDriver().findElement(By.id("acn-searchtext"));

		Assert.assertTrue(searchField.isDisplayed());

		// Assert sign up option is present.

		WebElement signUp = driverManager.getDriver().findElement(By.cssSelector(".navbar-text.navbar-right"));

		Assert.assertTrue(signUp.isDisplayed());

		// Assert Edit option is present.

		WebElement editOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[2]/a"));

		Assert.assertTrue(editOption.isDisplayed());

		// Assert delete option is present.

		WebElement deleteOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[3]/a"));

		Assert.assertTrue(deleteOption.isDisplayed());

		// Assert all schedule option is present.

		WebElement scheduleOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[4]/a"));

		Assert.assertTrue(scheduleOption.isDisplayed());

		// Assert Approve publish is present.

		WebElement approvePublishOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[5]/a"));

		Assert.assertTrue(approvePublishOption.isDisplayed());

		// Assert duplicate option is present.

		WebElement duplicateOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[6]/a"));

		Assert.assertTrue(duplicateOption.isDisplayed());

		// Assert history option is present.

		WebElement historyOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[7]/a"));

		Assert.assertTrue(historyOption.isDisplayed());

		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// Assert all Sites Dropdown option is present.

		WebElement allSitesDropdown = driverManager.getDriver().findElement(By.id("acn-site-dropdown"));

		Assert.assertTrue(allSitesDropdown.isDisplayed());

		// Assert analytics dashboard option is present.

		WebElement analyticsDashboardOption = driverManager.getDriver()
				.findElement(By.cssSelector("#analytics-dashboard.acn-analytics"));

		Assert.assertTrue(analyticsDashboardOption.isDisplayed());

		// Assert admin console option is present.

		WebElement adminConsoleOption = driverManager.getDriver()
				.findElement(By.cssSelector("#admin-console.acn-admin-console"));

		Assert.assertTrue(adminConsoleOption.isDisplayed());

		// Assert preview sync option is present.

		WebElement previewSyncOption = driverManager.getDriver()
				.findElement(By.cssSelector("#previewsync.acn-previewsync"));

		Assert.assertTrue(previewSyncOption.isDisplayed());

	}

}
