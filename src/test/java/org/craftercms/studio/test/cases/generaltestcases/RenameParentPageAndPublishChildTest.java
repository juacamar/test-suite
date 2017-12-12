/**
 * 
 */
package org.craftercms.studio.test.cases.generaltestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author luishernandez
 *
 */
public class RenameParentPageAndPublishChildTest {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private UIElementsPropertiesManager UIElementsPropertiesManager;
	private HomePage homePage;
	private DashboardPage dashboardPage;

	private String userName;
	private String password;
	private String parentPageName;
	private String childPage1Name;
	private String childPage2Name;
	private String parentPageNewName;
	private String parentPageLocator;
	private String childPage1Locator;
	private String childPage2Locator;
	private String parentPageNewLocator;
	private String homeContent;
	private String siteDropdownElementXPath;
	private String approveSubmitId;
	private String unselectAllCheckBox;
	private String createFormFrameElementCss;
	private String createFormSaveAndCloseElementId;
	private String toggleNavigationXpath;
	private String homeExpansorXpath;
	private String createFormArticleMainTitleElementXPath;
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

		this.parentPageName = "1";
		this.childPage1Name = "2";
		this.childPage2Name = "3";
		this.parentPageNewName = "11";
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");

		homeContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page");
		this.parentPageLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.parentfolder") + this.parentPageName + "')]";
		this.childPage1Locator = this.parentPageLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage1Name + "')]";
		this.childPage2Locator = this.childPage1Locator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage2Name + "')]";
		this.parentPageNewLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.parentfolder") + this.parentPageNewName + "')]";
		siteDropdownElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		approveSubmitId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.renameparentpageandpublishchildtest.approvesubmitid");
		unselectAllCheckBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.renameparentpageandpublishchildtest.unselectallcheckbox");
		createFormFrameElementCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		createFormArticleMainTitleElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformMainTitle");
		createFormSaveAndCloseElementId = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.saveandclosebutton");
		toggleNavigationXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.togglenavigationelement");
		homeExpansorXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.homeexpansor");
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void loginAndGoToSiteContentPagesStructure() {
		// login to application
		loginPage.loginToCrafter(userName, password);
		
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();
		
		// go to preview page
		homePage.goToPreviewPage();
		
		if (this.driverManager.isElementPresentAndClickableByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
	}

	public void publishElement(WebElement element, String pageName) {

		dashboardPage.rightClickOnAContentPage(element);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.selectOnlyOnePageToPublish(pageName);
		this.confirmPublishAction();
		this.driverManager.isElementPresentAndClickableByXpath(toggleNavigationXpath);
	}

	private void selectOnlyOnePageToPublish(String pageName) {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", approveSubmitId);
		WebElement unSelectAllCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				unselectAllCheckBox);
		unSelectAllCheck.click();
		
		String pageNameCheckLocator = ".//table[@class='item-listing scroll-body']/tbody/tr/td/div/span[contains(text(),'"
				+ pageName + "')]/../../../td/input";
		WebElement pageNameCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				pageNameCheckLocator);
		pageNameCheck.click();
	}

	public void confirmPublishAction() {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();
		
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createNewPageArticleContent(String pageName) {

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();

		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", createFormFrameElementCss));
		this.driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);
		// creating random values for URL field and InternalName field
		String randomURL = pageName;
		String randomInternalName = pageName;
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, pageName);

		// Set the title of main content
		//this.driverManager.scrollDown();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormArticleMainTitleElementXPath)
				.sendKeys(pageName);
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void editPageArticleContent(String pageName) {
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",createFormFrameElementCss ));
		this.driverManager.isElementPresentAndClickableBycssSelector(createFormFrameElementCss);

		// creating random values for URL field and InternalName field
		String randomInternalName = pageName;
		// Set basics fields of the new content created
		dashboardPage.updateBasicFieldsOfNewPageArticleContent(randomInternalName, pageName);

		// Set the title of main content
		this.driverManager.scrollUp();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", createFormArticleMainTitleElementXPath)
				.sendKeys(pageName);

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createFormSaveAndCloseElementId).click();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createPageCategoryLandingPage(WebElement folderWebElement, String pageName) {
		dashboardPage.rightClickCreatePageOnAPresentPage(folderWebElement);
		// selecting Page Category Landing Page
		dashboardPage.selectPageArticleContentType();
		// click on the Ok button to confirm the select content type above
		dashboardPage.clickOKButton();
		// creating new Page Article into the empty folder
		driverManager.getDriver().switchTo().defaultContent();
		this.createNewPageArticleContent(pageName);
		this.driverManager.isElementPresentAndClickableByXpath(toggleNavigationXpath);
	}

	public void testScenario() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeContent);
		WebElement homeParent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", homeContent);
		this.createPageCategoryLandingPage(homeParent, parentPageName);

		this.driverManager.isElementPresentAndClickableByXpath(homeExpansorXpath);
		WebElement expansorElementForHome = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				homeExpansorXpath);
		expansorElementForHome.click();

		WebElement parentPage;
		WebElement childPage1;
		WebElement childPage2;

		Assert.assertTrue(driverManager.isElementPresentByXpath(parentPageLocator));
		parentPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", parentPageLocator);
		this.createPageCategoryLandingPage(parentPage, childPage1Name);
		//driverManager.waitUntilPageLoad();
		
		childPage1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", childPage1Locator);
		this.createPageCategoryLandingPage(childPage1, childPage2Name);
		//driverManager.waitUntilPageLoad();
		
		//childPage2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", childPage2Locator);

		this.renamePage(parentPage, parentPageNewName);
		//driverManager.waitUntilPageLoad();
		
		this.childPage1Locator = this.parentPageNewLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
		.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage1Name + "')]";
		this.childPage2Locator = this.childPage1Locator + UIElementsPropertiesManager.getSharedUIElementsLocators()
		.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage2Name + "')]";
		
		this.driverManager.isElementPresentAndClickableByXpath(childPage2Locator);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childPage2Locator).click();

		childPage2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childPage2Locator);
		this.publishElement(childPage2, childPage2Name);
        
		this.verifyPublishedItemsOnDashboard();

	}

	private void verifyPublishedItemsOnDashboard() {
		
		String iconNeverPublishedForParentPage = this.parentPageNewLocator
				+ "/div/span/span[contains(@class,'never-published')]";
		String iconNeverPublishedForChild1Page = this.childPage1Locator
				+ "/div/span/span[contains(@class,'never-published')]";

		this.driverManager.waitUntilPageLoad();
		
		boolean isPresent = this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForChild1Page);
		
		while (isPresent) {
			this.driverManager.waitUntilPageLoad();
			System.out.print("not yet");
			driverManager.getDriver().navigate().refresh();
			isPresent = this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForChild1Page);
		}

		Assert.assertFalse(this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForParentPage));
		Assert.assertFalse(this.driverManager.isElementPresentAndClickableByXpath(iconNeverPublishedForChild1Page));

	}

	public void confirmDeleteAction() {

		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		driverManager.getDriver().switchTo().defaultContent();
	}

	private void renamePage(WebElement parentPage, String newPageName) {
		dashboardPage.rightClickEditOnAPresentPage(parentPage);
		// creating new Page Article into the empty folder
		this.editPageArticleContent(newPageName);
	}

	@Test
	public void renameParentPageAndPublishChildTest() {
		// Related to the bug:
		// https://github.com/craftercms/craftercms/issues/1248
		this.loginAndGoToSiteContentPagesStructure();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create the folders structure according with script
		this.testScenario();
	}
}