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

public class HistoryOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private PreviewPage previewPage;

	private String userName;
	private String password;
	private int defaultTimeOut;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void history_option() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();

		// expand pages folder

		previewPage.expandPagesTree();

		// expand home content
		previewPage.expandHomeTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#ygtvlabelel1").click();

		// click on history option
		previewPage.clickOnHistoryOption();

		// Assert
		String historyPage = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", ".view-title").getText();
		// driverManager.getDriver().findElement(By.cssSelector(".view-title")).getText();
		Assert.assertEquals(historyPage, "Version History");

	}

}
