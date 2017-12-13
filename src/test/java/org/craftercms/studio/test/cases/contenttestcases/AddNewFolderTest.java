package org.craftercms.studio.test.cases.contenttestcases;

import org.craftercms.studio.test.cases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class AddNewFolderTest extends BaseTest {

	private String userName;
	private String password;
	private String siteDropdownElementXPath;
	private String newFolderXpath;

	@BeforeClass
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		newFolderXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.newfolder");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void createANewFolderUsingContextualClickOptionTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		driverManager.waitUntilLoginCloses();

		// go to dashboard page

		homePage.goToDashboardPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// right click to see the the menu
		dashboardPage.rightClickToFolderOnHome();

		// Set the name of the folder
		dashboardPage.setFolderName("addnewfolder");
		
		driverManager.getDriver().navigate().refresh();

		dashboardPage.expandHomeTree();
		
		// Assert find the new folder created
		this.driverManager.waitUntilElementIsDisplayed("xpath", newFolderXpath);
		
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(newFolderXpath));

	}

}