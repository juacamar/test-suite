package org.craftercms.studio.test.cases.previewpagetestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

	private HomePage homePage;
	
	private String userName;
	private String password;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Design_of_preview_page() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// reload page
		driverManager.getDriver().navigate().refresh();

		// Assert crafter studio logo is present.
		WebElement logoCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[1]/a/img");
		
		Assert.assertTrue(logoCrafter.isDisplayed());

	
		// Assert site content option is present.
		WebElement siteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a");
	

		Assert.assertTrue(siteContent.isDisplayed());


		// Assert search field is present.
		WebElement searchField = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id",
				"acn-searchtext");

		Assert.assertTrue(searchField.isDisplayed());

		
		// Assert account option is present.
		WebElement signUp = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#account-dropdown");
		
		Assert.assertTrue(signUp.isDisplayed());

		// Assert Edit option is present.
		WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[2]/a");

		Assert.assertTrue(editOption.isDisplayed());

		// Assert delete option is present.
		WebElement deleteOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[3]/a");
		
		Assert.assertTrue(deleteOption.isDisplayed());

		
		// Assert all schedule option is present.
		WebElement scheduleOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[4]/a");
		Assert.assertTrue(scheduleOption.isDisplayed());

	
		// Assert Approve publish is present.
		WebElement approvePublishOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[3]/li[5]/a");
		Assert.assertTrue(approvePublishOption.isDisplayed());

		
		// Assert dependencies option is present.
		WebElement duplicateOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#activeContentActions > li:nth-child(5) > a");
	
		Assert.assertTrue(duplicateOption.isDisplayed());

		
		// Assert history option is present.
		WebElement historyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#activeContentActions > li:nth-child(5) > a");
		Assert.assertTrue(historyOption.isDisplayed());

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();
		
		// Assert all Sites Dropdown option is present.
		WebElement dashboard = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#acn-dropdown-menu-inner > div.studio-view");
		Assert.assertTrue(dashboard.isDisplayed());

	
		// Assert Users option is present.
		WebElement usersOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#studioBar > nav > div div.collapse.navbar-collapse > div > ul  > li:nth-child(1) > a");
		Assert.assertTrue(usersOption.isDisplayed());

		// Assert sites option is present.
		WebElement sitesOption =this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#studioBar > nav > div div.collapse.navbar-collapse > div > ul  > li:nth-child(1) > a");
		Assert.assertTrue(sitesOption.isDisplayed());

		// Assert admin console option is present.
		WebElement adminConsoleOption =this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#admin-console.acn-admin-console");
		Assert.assertTrue(adminConsoleOption.isDisplayed());

	}

}
