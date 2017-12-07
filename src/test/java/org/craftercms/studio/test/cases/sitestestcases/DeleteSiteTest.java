package org.craftercms.studio.test.cases.sitestestcases;

import org.craftercms.studio.test.cases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DeleteSiteTest extends BaseTest {

	private String userName;
	private String password;
	private String deletedSiteRow;
	private String createSiteButton;

	@BeforeClass
	public void beforeTest() {
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		deletedSiteRow = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.deletedsiterow");
		createSiteButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.sites.createsitebutton");

	}

	@Test(priority = 0)
	public void deleteSiteTest() {

		// login to application
		loginPage.loginToCrafter(
				userName,password);

		// Click on Delete icon
        this.driverManager.isElementPresentAndClickableByXpath(createSiteButton);
		homePage.clickOnDeleteSiteIcon();
		
		// Click on YES to confirm the delete.
		homePage.clickOnYesToDeleteSite();
		
		driverManager.getDriver().navigate().refresh();
		
		// Assert
		this.driverManager.waitWhileElementIsNotDisplayedByXpath(deletedSiteRow);
		Assert.assertFalse(this.driverManager.isElementPresentAndClickableByXpath(deletedSiteRow));
	}
}




