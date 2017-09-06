package org.craftercms.studio.test.cases.userspagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class TryToDeleteUserConnectedTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;
	
	private UsersPage usersPage;



	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void try_to_delete_user() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		homePage.getDriverManager().driverWait();
		// Go to users tab
		
		driverManager.getDriver().findElement(By.cssSelector("body > ui-view > header > nav > div > div.collapse.navbar-collapse.ng-scope > ul > li:nth-child(1) > a"))
		.click();
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();

		// Try to delete the user current connected
		
		usersPage.clickOnDeleteUser();
		
		// wait for element is clickeable

				homePage.getDriverManager().driverWait();
		
		// Confirmation to delete user connected
		
		driverManager.getDriver().findElement(By.cssSelector("body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)"))
		.click();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Verify 
		
	    WebElement validation = driverManager.getDriver().findElement(By.cssSelector("body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button"));
	 
	    Assert.assertTrue(validation.isDisplayed());
		
	}

}
