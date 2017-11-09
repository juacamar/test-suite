package org.craftercms.studio.test.cases.contextualnavigationbartestcases;

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

public class DependenciesOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private PreviewPage previewPage;

	private String userName;
	private String password;

	private String siteDropdownXpath;

	private String homeXpath;

	private String dependeciesDialogTitle;

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
		dependeciesDialogTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.dependeciesdialogtitle");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void dependenciesOptionTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				siteDropdownXpath).click();

		// expand pages folder
		previewPage.expandPagesTree();
		
		driverManager.getDriver().navigate().refresh();
		
		// expand home content
		previewPage.expandHomeTree();

		// Select the content to view the history.
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", homeXpath).click();
		
		// click on history option
		previewPage.clickOnDependenciesOption();

		// Assert
		String historyPage = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", dependeciesDialogTitle).getText();
		Assert.assertEquals(historyPage, "Dependencies");

	}

}
