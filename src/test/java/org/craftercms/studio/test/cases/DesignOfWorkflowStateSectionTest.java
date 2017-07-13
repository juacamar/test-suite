package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DesignOfWorkflowStateSectionTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;



	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);


	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void workflowSection() {
		
		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.goToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Assert workflow guide section is present.

		WebElement workflowSection = driverManager.getDriver().findElement(By.cssSelector(".panel-body"));

		Assert.assertTrue(workflowSection.isDisplayed());

		// Assert navigation page is present.

//		WebElement navigationPage = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(1)"));
//
//		Assert.assertTrue(navigationPage.isDisplayed());

		// Assert edited is present.

		WebElement edited = driverManager.getDriver()
				.findElement(By.cssSelector("#iconGuide > div.panel-body > div > div:nth-child(6) > div"));

		Assert.assertTrue(edited.isDisplayed());

		// Assert floating page is present.

		WebElement floatingPage = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(2)"));

		Assert.assertTrue(floatingPage.isDisplayed());

		// Assert in workflow is present.

		WebElement inWorkflow = driverManager.getDriver()
				.findElement(By.cssSelector("#iconGuide > div.panel-body > div > div:nth-child(7) > div"));

		Assert.assertTrue(inWorkflow.isDisplayed());

		// Assert component is present.

		WebElement component = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(3)"));

		Assert.assertTrue(component.isDisplayed());

		// Assert scheduled is present.

		WebElement scheduled = driverManager.getDriver()
				.findElement(By.cssSelector("#iconGuide > div.panel-body > div > div:nth-child(8) > div"));

		Assert.assertTrue(scheduled.isDisplayed());

		// Assert document is present.

		WebElement siteName = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(4)"));

		Assert.assertTrue(siteName.isDisplayed());

		// Assert deleted is present.

		WebElement document = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(10)"));

		Assert.assertTrue(document.isDisplayed());

		// Assert Never published is present.

		WebElement neverPublished = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(5)"));

		Assert.assertTrue(neverPublished.isDisplayed());

		// Assert processing is present.

		WebElement processing = driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(11)"));

		Assert.assertTrue(processing.isDisplayed());

		// Assert disabled is present.

		WebElement disabled = driverManager.getDriver().findElement(By.cssSelector(".iconText"));

		Assert.assertTrue(disabled.isDisplayed());

		// Assert Locked for edit is present.

		WebElement locked = driverManager.getDriver().findElement(By.cssSelector("#iconGuide > div.panel-body > div > div:nth-child(11) > div"));

		Assert.assertTrue(locked.isDisplayed());

	}

}
