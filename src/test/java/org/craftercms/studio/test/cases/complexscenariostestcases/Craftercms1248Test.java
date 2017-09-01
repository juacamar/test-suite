/**
 * 
 */
package org.craftercms.studio.test.cases.complexscenariostestcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author luishernandez
 *
 */
public class Craftercms1248Test {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private UIElementsPropertiesManager UIElementsPropertiesManager;
	private HomePage homePage;
	private DashboardPage dashboardPage;

	private String parentPageName;
	private String childPage1Name;
	private String childPage2Name;
	private String parentPageNewName;
	private String parentPageLocator;
	private String childPage1Locator;
	private String childPage2Locator;
	private String parentPageNewLocator;
	private String homeContent;

	

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

		this.parentPageName = "1";
		this.childPage1Name = "2";
		this.childPage2Name = "3";
		this.parentPageNewName = "11";

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

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void loginAndGoToSiteContentPagesStructure() {
		// login to application
		loginPage.loginToCrafter("admin", "admin");
		// wait for element
		homePage.getDriverManager().driverWait();
		// go to preview page
		homePage.goToPreviewPage();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// reload page
		driverManager.getDriver().navigate().refresh();
	
		driverManager.setImplicitlyWaitTimeForFindElements();
		homePage.getDriverManager().driverWait();
		// Show site content panel
		driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']"))
				.click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
	}

	public void publishElement(WebElement element, String pageName) {
		// right click to displays right click menu
		dashboardPage.rightClickOnAContentPage(element);
		// selecting the Publish option
		dashboardPage.clickOnPublishOption();
		// moving to the publish dialog, clicking on Submit and confirm action
		this.selectOnlyOnePageToPublish(pageName);
		this.confirmPublishAction();
		// wait for element
	}

	private void selectOnlyOnePageToPublish(String pageName) {
		dashboardPage.getDriverManager().driverWait();
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();

		WebElement unSelectAllCheck = driverManager.getDriver()
				.findElement(By.xpath(".//table[@class='item-listing scroll-body']/thead/tr/th/input"));
		unSelectAllCheck.click();

		String pageNameCheckLocator = ".//table[@class='item-listing scroll-body']/tbody/tr/td/div/span[contains(text(),'"
				+ pageName + "')]/../../../td/input";
		WebElement pageNameCheck = driverManager.getDriver().findElement(By.xpath(pageNameCheckLocator));
		pageNameCheck.click();
	}

	public void confirmPublishAction() {
		dashboardPage.getDriverManager().driverWait();
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createNewPageArticleContent(String pageName) {

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait();
		// creating random values for URL field and InternalName field
		String randomURL = pageName;
		String randomInternalName = pageName;
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, pageName);
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// Set the title of main content
		driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys(pageName);
		// click necessary to validate all fields required
		driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// save and close
		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void editPageArticleContent(String pageName) {
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait();
		// creating random values for URL field and InternalName field
		String randomInternalName = pageName;
		// Set basics fields of the new content created
		dashboardPage.updateBasicFieldsOfNewPageArticleContent(randomInternalName, pageName);

		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// Set the title of main content
		driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys(pageName);
		// click necessary to validate all fields required
		driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// save and close
		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void createPageCategoryLandingPage(WebElement folderWebElement, String pageName) {
		// right clicking and clikc on create New Content option
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

		WebElement homeParent = driverManager.getDriver().findElement(By.xpath(homeContent));

		this.createPageCategoryLandingPage(homeParent, parentPageName);

		dashboardPage.getDriverManager().driverWait();
		driverManager.setImplicitlyWaitTimeForFindElements();

		WebElement expansorElementForHome = driverManager.getDriver()
				.findElement(By.xpath(".//span[text()='Home']/../../td[1]"));
		expansorElementForHome.click();

		WebElement parentPage;
		WebElement childPage1;
		WebElement childPage2;
		
		AssertJUnit.assertTrue(driverManager.isElementPresentByXpath(parentPageLocator));
		parentPage = dashboardPage.getDriverManager().getDriver().findElement(By.xpath(parentPageLocator));

		this.createPageCategoryLandingPage(parentPage, childPage1Name);
		childPage1 = driverManager.getDriver().findElement(By.xpath(childPage1Locator));

		this.createPageCategoryLandingPage(childPage1, childPage2Name);
		childPage2 = driverManager.getDriver().findElement(By.xpath(childPage2Locator));

		this.renamePage(parentPage, parentPageNewName);
		//parentPageNew = driverManager.getDriver().findElement(By.xpath(parentPageNewLocator));
		
		this.childPage1Locator = this.parentPageNewLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage1Name + "')]";
		this.childPage2Locator = this.childPage1Locator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.childPage2Name + "')]";

		this.publishElement(childPage2, childPage2Name);

		this.driverManager.driverWait();

		this.verifyPublishedItemsOnDashboard();

		dashboardPage.rightClickDeleteAPage(parentPage);
		this.confirmDeleteAction();

	}

	private void verifyPublishedItemsOnDashboard() {
		//driverManager.getDriver().navigate().refresh();
		driverManager.setImplicitlyWaitTimeForFindElements();

		String iconNeverPublishedForParentPage = this.parentPageNewLocator
				+ "/div/span/span[contains(@class,'never-published')]";
		String iconNeverPublishedForChild1Page = this.childPage1Locator
				+ "/div/span/span[contains(@class,'never-published')]";
		String iconPublishedForChild2Page = this.childPage2Locator + "/div/span/span[contains(@class,'live')]";

		Assert.assertFalse(this.driverManager.isElementPresentByXpath(iconNeverPublishedForParentPage));
		Assert.assertFalse(this.driverManager.isElementPresentByXpath(iconNeverPublishedForChild1Page));
		Assert.assertTrue(this.driverManager.isElementPresentByXpath(iconPublishedForChild2Page));

	}

	public void confirmDeleteAction() {
		dashboardPage.getDriverManager().driverWait();
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		driverManager.getDriver().switchTo().defaultContent();
	}

	private void renamePage(WebElement parentPage, String newPageName) {
		// right clicking and click on Edit option
		dashboardPage.rightClickEditOnAPresentPage(parentPage);
		// creating new Page Article into the empty folder
		driverManager.getDriver().switchTo().defaultContent();
		this.editPageArticleContent(newPageName);
	}

	@Test
	public void craftercms1248Test() {
		this.loginAndGoToSiteContentPagesStructure();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create the folders structure according with script
		this.testScenario();
	}
}