/**
 * 
 */
package org.craftercms.studio.test.cases.complexscenariostestcases;

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

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void loginAndGoToSiteContentPagesStructure() {
		// login to application
		loginPage.loginToCrafter(userName, password);
		// go to preview page
		homePage.goToPreviewPage();
		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
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

	}

	private void selectOnlyOnePageToPublish(String pageName) {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", "approveSubmit");
		WebElement unSelectAllCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				"(//INPUT[@type='checkbox'])[1]");
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
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector(".studio-ice-dialog > .bd iframe");
		// creating random values for URL field and InternalName field
		String randomURL = pageName;
		String randomInternalName = pageName;
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, pageName);

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#title > div > input")
				.sendKeys(pageName);
		this.driverManager.scrollUp();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#cstudio-form-expand-all")
				.click();
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", "cstudioSaveAndClose").click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.isElementPresentByXpath(".//span[text()='Toggle navigation']");
	}

	public void editPageArticleContent(String pageName) {
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector(".studio-ice-dialog > .bd iframe");

		// creating random values for URL field and InternalName field
		String randomInternalName = pageName;
		// Set basics fields of the new content created
		dashboardPage.updateBasicFieldsOfNewPageArticleContent(randomInternalName, pageName);

		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#title > div > input")
				.sendKeys(pageName);
		this.driverManager.scrollUp();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#cstudio-form-expand-all")
				.click();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", "cstudioSaveAndClose").click();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.isElementPresentByXpath(".//span[text()='Toggle navigation']");

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
	}

	public void testScenario() {
		WebElement homeParent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", homeContent);
		this.createPageCategoryLandingPage(homeParent, parentPageName);

		WebElement expansorElementForHome = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[text()='Home']/../../td[1]");
		expansorElementForHome.click();

		WebElement parentPage;
		WebElement childPage1;
		WebElement childPage2;

		Assert.assertTrue(driverManager.isElementPresentByXpath(parentPageLocator));
		parentPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", parentPageLocator);
		this.createPageCategoryLandingPage(parentPage, childPage1Name);
		childPage1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", childPage1Locator);

		this.createPageCategoryLandingPage(childPage1, childPage2Name);
		childPage2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", childPage2Locator);

		this.renamePage(parentPage, parentPageNewName);
		this.childPage1Locator = this.parentPageNewLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage1Name + "')]";
		this.childPage2Locator = this.childPage1Locator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage2Name + "')]";

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childPage2Locator);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", childPage2Locator).click();

		this.publishElement(childPage2, childPage2Name);

		this.verifyPublishedItemsOnDashboard();

		// dashboardPage.rightClickDeleteAPage(parentPage);
		// this.confirmDeleteAction();

	}

	private void verifyPublishedItemsOnDashboard() {

		String iconNeverPublishedForParentPage = this.parentPageNewLocator
				+ "/div/span/span[contains(@class,'never-published')]";
		String iconNeverPublishedForChild1Page = this.childPage1Locator
				+ "/div/span/span[contains(@class,'never-published')]";

		while (this.driverManager.isElementPresentByXpath(iconNeverPublishedForParentPage)) {
			driverManager.getDriver().navigate().refresh();
		}
		while (this.driverManager.isElementPresentByXpath(iconNeverPublishedForChild1Page)) {
			driverManager.getDriver().navigate().refresh();
		}

		Assert.assertFalse(this.driverManager.isElementPresentByXpath(iconNeverPublishedForParentPage));
		Assert.assertFalse(this.driverManager.isElementPresentByXpath(iconNeverPublishedForChild1Page));

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