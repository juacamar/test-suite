package org.craftercms.studio.test.cases.userstestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import org.craftercms.studio.test.cases.BaseTest;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteUserTest extends BaseTest{

	private String userName;
	private String password;
	private String deleteYesButtonXpath;
	private String usersRowsXpath;


	@BeforeMethod
	public void beforeTest() {

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		deleteYesButtonXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.deleteyesbutton");
		usersRowsXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.users.usersrows");
	}


	@Test(priority = 0)
	public void verifyThatStudioAllowsToDeleteAnUserTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();

		// click On Users option
		createSitePage.clickOnUsersOption();

		// Click on delete user
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath",
						deleteYesButtonXpath)
				.click();

		// Assert new users created is deleted
		this.driverManager.waitForAnimation();
		driverManager.getDriver().navigate().refresh();
		Assert.assertTrue(this.driverManager.elementHasChildsByXPath(usersRowsXpath));	
		
		this.driverManager.waitForAnimation();
		driverManager.getDriver().navigate().refresh();
		List<WebElement> usersList = this.driverManager.getDriver().findElements(By.xpath(usersRowsXpath));
		Assert.assertTrue(usersList.size()==1);

	}
}
