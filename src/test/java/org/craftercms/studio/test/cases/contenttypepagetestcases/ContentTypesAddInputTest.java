package org.craftercms.studio.test.cases.contenttypepagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.SiteConfigPage;
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

public class ContentTypesAddInputTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private SiteConfigPage siteConfigPage;

	private String userName;
	private String password;

	private String controlsSectionFormSectionLocator;
	private String contentTypeContainerLocator;
	private String controlsSectionInputLocator;
	private String contentTypeContainerFormSectionContainerLocator;
	private String contentTypeContainerInputTitleLocator;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		

		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.siteConfigPage = new SiteConfigPage(driverManager, uIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

		this.controlsSectionFormSectionLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlssectionformsection");
		this.contentTypeContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainer");
		this.controlsSectionInputLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.controlsinput");
		this.contentTypeContainerFormSectionContainerLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerformsectioncontainer");
		this.contentTypeContainerInputTitleLocator = uIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerinputtitle");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void dragAndDrop() {

		// Getting the Form Section control input for drag and drop action
		WebElement FromControlSectionFormSectionElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
						controlsSectionFormSectionLocator);

		// Getting the Content Type Container for drag and drop action
		// (destination)
		WebElement ToContentTypeContainer = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", contentTypeContainerLocator);

		driverManager.dragAndDropElement(FromControlSectionFormSectionElement, ToContentTypeContainer);

		WebElement FromRepeatingGroup = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", controlsSectionInputLocator);

		WebElement ToDefaultSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", contentTypeContainerFormSectionContainerLocator);

		siteConfigPage.getDriverManager().dragAndDropElement(FromRepeatingGroup, ToDefaultSection);

		// Complete the input fields basics
		siteConfigPage.completeControlFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefault");

		// Save the data
		siteConfigPage.saveDragAndDropProcess();
	}

	@Test(priority = 0)
	public void contentTypeAddInputTest() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// go to preview page
		homePage.goToPreviewPage();

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				"/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a").click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//a[@id='admin-console']")
				.click();

		// Select the content type to the test
		siteConfigPage.selectEntryContentTypeFromAdminConsole();

		// drag and drop
		this.dragAndDrop();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// Click on input section to can view the properties
		siteConfigPage.clickInputSection();

		// Asserts that fields are not empty.
		this.driverManager.isElementPresentByXpath(contentTypeContainerInputTitleLocator);
		
		String titleText = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				contentTypeContainerInputTitleLocator).getText();

		Assert.assertTrue(titleText.contains("TestTitle"));

	}

}
