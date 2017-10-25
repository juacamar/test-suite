package org.craftercms.studio.test.cases.contextualnavigationbartestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class ShowAboutUsTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private CreateSitePage createSitePage;
	
	private String userName;
	private String password;


	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, UIElementsPropertiesManager);
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void showAboutUs() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// click On help option
		createSitePage.clickOnHelpOption();

		// select the about us option
		createSitePage.clickOnAboutOption();


		// Assert new users created is present
		WebElement aboutUsInfo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				"#container > div > div > div:nth-child(2) > div");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#container > div > div > div:nth-child(2) >
		// div"));

		Assert.assertTrue(aboutUsInfo.isDisplayed());

	}
}
