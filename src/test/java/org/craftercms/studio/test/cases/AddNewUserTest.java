package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
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

public class AddNewUserTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private HomePage homePage;
	
	private CreatePage createPage;
	
	private UsersPage usersPage;




	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.createPage = new CreatePage(driverManager,
				 this.UIElementsPropertiesManager);
		this.usersPage = new UsersPage(driverManager, this.UIElementsPropertiesManager);

		
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void addNewUser() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		//click On Users option
		
		createPage.clickOnUsersOption();
		
		//click on new user button
		
		usersPage.clickOnNewUser();
		
		
		// Follow the form
		
		driverManager.getDriver().findElement(By.cssSelector("#firstName")).sendKeys("Name");
		
		driverManager.getDriver().findElement(By.cssSelector("#lastName")).sendKeys("Last Name");
		
		driverManager.getDriver().findElement(By.cssSelector("#email")).sendKeys("email@email.com");
		
		driverManager.getDriver().findElement(By.cssSelector("#username")).sendKeys("username");
		
		driverManager.getDriver().findElement(By.cssSelector("#password")).sendKeys("password");
		
		driverManager.getDriver().findElement(By.cssSelector("#passwordVerification")).sendKeys("password");
		
		// Save Button
		
		usersPage.clickOnSaveNewUser();
		
		// wait for element is clickeable

		homePage.getDriverManager().driverWait();
		
		// Assert new users created is present

				WebElement newUserCreated = driverManager.getDriver()
						.findElement(By.cssSelector("#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a"));

				Assert.assertTrue(newUserCreated.isDisplayed());
		





		
	}
}
