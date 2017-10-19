package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
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

	private ConstantsPropertiesManager constantsPropertiesManager;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager,constantsPropertiesManager);

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void workflowSection() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(1000);

		// go to dashboard page

		homePage.goToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait(4000);

		// Assert workflow guide section is present.

		WebElement workflowSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".panel-body");
		// driverManager.getDriver().findElement(By.cssSelector(".panel-body"));

		Assert.assertTrue(workflowSection.isDisplayed());

		// Assert navigation page is present.

		// WebElement navigationPage =
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(1)"));
		//
		// Assert.assertTrue(navigationPage.isDisplayed());

		// Assert edited is present.

		WebElement edited = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#iconGuide > div.panel-body > div > div:nth-child(6) > div");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#iconGuide > div.panel-body > div >
		// div:nth-child(6) > div"));

		Assert.assertTrue(edited.isDisplayed());

		// Assert floating page is present.

		WebElement floatingPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.col-xs-6:nth-child(2)");
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(2)"));

		Assert.assertTrue(floatingPage.isDisplayed());

		// Assert in workflow is present.

		WebElement inWorkflow = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#iconGuide > div.panel-body > div > div:nth-child(7) > div");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#iconGuide > div.panel-body > div >
		// div:nth-child(7) > div"));

		Assert.assertTrue(inWorkflow.isDisplayed());

		// Assert component is present.

		WebElement component = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.col-xs-6:nth-child(3)");
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(3)"));

		Assert.assertTrue(component.isDisplayed());

		// Assert scheduled is present.

		WebElement scheduled = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#iconGuide > div.panel-body > div > div:nth-child(8) > div");
		// driverManager.getDriver()
		// .findElement(By.cssSelector("#iconGuide > div.panel-body > div >
		// div:nth-child(8) > div"));

		Assert.assertTrue(scheduled.isDisplayed());

		// Assert document is present.

		WebElement siteName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.col-xs-6:nth-child(4)");
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(4)"));

		Assert.assertTrue(siteName.isDisplayed());

		// Assert deleted is present.

		WebElement document = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.col-xs-6:nth-child(10)");
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(10)"));

		Assert.assertTrue(document.isDisplayed());

		// Assert Never published is present.

		WebElement neverPublished = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.col-xs-6:nth-child(5)");
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(5)"));

		Assert.assertTrue(neverPublished.isDisplayed());

		// Assert processing is present.

		WebElement processing = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"div.col-xs-6:nth-child(11)");
		// driverManager.getDriver().findElement(By.cssSelector("div.col-xs-6:nth-child(11)"));

		Assert.assertTrue(processing.isDisplayed());

		// Assert disabled is present.

		WebElement disabled = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				".iconText");
		// driverManager.getDriver().findElement(By.cssSelector(".iconText"));

		Assert.assertTrue(disabled.isDisplayed());

		// Assert Locked for edit is present.

		WebElement locked = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#iconGuide > div.panel-body > div > div:nth-child(11) > div");
		// driverManager.getDriver().findElement(By.cssSelector("#iconGuide >
		// div.panel-body > div > div:nth-child(11) > div"));

		Assert.assertTrue(locked.isDisplayed());

	}

}
