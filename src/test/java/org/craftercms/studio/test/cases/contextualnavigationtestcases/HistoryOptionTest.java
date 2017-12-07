package org.craftercms.studio.test.cases.contextualnavigationtestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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

public class HistoryOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private PreviewPage previewPage;

	private String userName;
	private String password;
	private String siteDropdownXpath;
	private String homeXpath;
	private String historyDialogTitle;
	private String studioLogo;
	private String createSiteButtonXpath;
	private String sitesTitleXpath;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
	
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitedropdown");
		homeXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.home");
		historyDialogTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.historydialogtitle");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.studiologo");
		createSiteButtonXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");
		sitesTitleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.pagetitle");
		
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)
	public void verifyThatTheHistoryDialogIsDisplayedTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);
		
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButtonXpath);
		this.driverManager.isElementPresentByXpath(sitesTitleXpath);
		
		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				siteDropdownXpath).click();
		
		// expand pages folder
		previewPage.expandPagesTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", studioLogo);
		
		// expand home content
		previewPage.expandHomeTree();

		driverManager.waitUntilPageLoad();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeXpath).click();

		// click on history option
		previewPage.clickOnHistoryOption();

		// Assert
		String historyPage = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", historyDialogTitle).getText();
		
		Assert.assertEquals(historyPage, "Version History");

	}

}
