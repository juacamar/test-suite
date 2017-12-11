package org.craftercms.studio.test.cases.contenttestcases;

import org.craftercms.studio.test.cases.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
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

public class AddNewFolderTest extends BaseTest {

	private String userName;
	private String password;

	private String siteDropdownElementXPath;

	private String newFolderXpath;
	private String newFolderDialogSelector;

	@BeforeClass
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		siteDropdownElementXPath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		newFolderXpath = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sitecontent.newfolder");
		newFolderDialogSelector = uiElementsPropertiesManager.getSharedUIElementsLocators()
			.getProperty("general.yui.dialog");
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

		// wait for the dialog to open
		WebElement dialog = driverManager.waitUntilElementIsDisplayed("cssSelector", newFolderDialogSelector);

		// wait for the animation to end
		driverManager.waitUntilAttributeContains("cssSelector", newFolderDialogSelector, "style",
			"opacity: 1;");

		// Set the name of the folder
		dashboardPage.setFolderName("addnewfolder");

		// Create folder button
		dashboardPage.clickCreateButton();

		// wait for animation to end
		driverManager.waitUntilElementIsRemoved(dialog);

		driverManager.getDriver().navigate().refresh();

		dashboardPage.clickHomeTree();

		// Assert find the new folder created
		this.driverManager.waitUntilElementIsDisplayed("xpath", newFolderXpath);
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(newFolderXpath));

	}

}