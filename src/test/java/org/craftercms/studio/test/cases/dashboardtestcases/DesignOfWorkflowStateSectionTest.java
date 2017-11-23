package org.craftercms.studio.test.cases.dashboardtestcases;

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

	private String userName;
	private String password;
	private String workflowPanel;
	private String editedStateItem;
	private String neverPublishedItem;
	private String inWorkFlowItem;
	private String scheduledStateItem;
	private String processingStateItem;
	private String deletedStateItem;
	private String lockedStateItem;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();

		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		workflowPanel = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel");
		neverPublishedItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.neverpublishedstate");
		editedStateItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.editedstate");
		inWorkFlowItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.inworkflowstate");
		scheduledStateItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.scheduledstate");
		processingStateItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.processingstate");
		deletedStateItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.deletedstate");
		lockedStateItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.lockedstate");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void verifyAllWorkflowStatesOnIconGuideTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to dashboard page
		homePage.goToDashboardPage();

		// Assert workflow guide section is present.
		WebElement workflowSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				workflowPanel);
		Assert.assertTrue(workflowSection.isDisplayed());

		// Assert neverpub is present.
		WebElement neverPublished = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				neverPublishedItem);
		Assert.assertTrue(neverPublished.isDisplayed());

		// Assert edited is present.
		WebElement edited = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", editedStateItem);
		Assert.assertTrue(edited.isDisplayed());


		// Assert in workflow is present.
		WebElement inWorkflow = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", inWorkFlowItem);
		Assert.assertTrue(inWorkflow.isDisplayed());

		// Assert scheduled is present.
		WebElement scheduled = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				scheduledStateItem);
		Assert.assertTrue(scheduled.isDisplayed());

		// Assert processing is present.
		WebElement processing = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				processingStateItem);
		Assert.assertTrue(processing.isDisplayed());

		// Assert deleted for edit is present.
		WebElement deleted = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", deletedStateItem);
		Assert.assertTrue(deleted.isDisplayed());

		// Assert Locked for edit is present.
		WebElement locked = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", lockedStateItem);
		Assert.assertTrue(locked.isDisplayed());

	}

}
