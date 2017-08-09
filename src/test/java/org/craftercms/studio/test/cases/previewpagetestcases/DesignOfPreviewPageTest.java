package org.craftercms.studio.test.cases.previewpagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

	private HomePage homePage;


	

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
	
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Design_of_preview_page() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert crafter studio logo is present.

		WebElement logoCrafter = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[1]/a/img"));

		Assert.assertTrue(logoCrafter.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert site content option is present.

		WebElement siteContent = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"));

		Assert.assertTrue(siteContent.isDisplayed());

		// wait for element is clickeable

				homePage.getDriverManager().driverWait();
				
		// Assert search field is present.

		WebElement searchField = driverManager.getDriver().findElement(By.id("acn-searchtext"));

		Assert.assertTrue(searchField.isDisplayed());

		// wait for element is clickeable

				homePage.getDriverManager().driverWait();
				
		// Assert account option is present.

		WebElement signUp = driverManager.getDriver().findElement(By.cssSelector("#account-dropdown"));

		Assert.assertTrue(signUp.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert Edit option is present.

		WebElement editOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[2]/a"));

		Assert.assertTrue(editOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert delete option is present.

		WebElement deleteOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[3]/a"));

		Assert.assertTrue(deleteOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert all schedule option is present.

		WebElement scheduleOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[4]/a"));

		Assert.assertTrue(scheduleOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert Approve publish is present.

		WebElement approvePublishOption = driverManager.getDriver()
				.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[5]/a"));

		Assert.assertTrue(approvePublishOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert dependencies option is present.

		WebElement duplicateOption = driverManager.getDriver()
				.findElement(By.cssSelector("#activeContentActions > li:nth-child(5) > a"));

		Assert.assertTrue(duplicateOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert history option is present.

		WebElement historyOption = driverManager.getDriver()
				.findElement(By.cssSelector("#activeContentActions > li:nth-child(5) > a"));

		Assert.assertTrue(historyOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert all Sites Dropdown option is present.

		WebElement dashboard = driverManager.getDriver().findElement(By.cssSelector("#acn-dropdown-menu-inner > div.studio-view"));

		Assert.assertTrue(dashboard.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert Users option is present.

		WebElement usersOption = driverManager.getDriver()
				.findElement(By.cssSelector("#studioBar > nav > div > div.collapse.navbar-collapse > ul.nav.navbar-nav.navbar-right > li:nth-child(1) > a"));

		Assert.assertTrue(usersOption.isDisplayed());
		
		// Assert sites option is present.

				WebElement sitesOption = driverManager.getDriver()
						.findElement(By.cssSelector("#studioBar > nav > div > div.collapse.navbar-collapse > ul.nav.navbar-nav.navbar-right > li:nth-child(2) > a"));

				Assert.assertTrue(sitesOption.isDisplayed());
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Assert admin console option is present.

		WebElement adminConsoleOption = driverManager.getDriver()
				.findElement(By.cssSelector("#admin-console.acn-admin-console"));

		Assert.assertTrue(adminConsoleOption.isDisplayed());
		

	}

}
