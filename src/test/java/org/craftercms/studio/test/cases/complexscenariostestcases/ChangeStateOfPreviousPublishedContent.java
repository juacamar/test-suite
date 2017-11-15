/**
 * 
 */
package org.craftercms.studio.test.cases.complexscenariostestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.pages.UsersPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author Juan Camacho
 *
 */
public class ChangeStateOfPreviousPublishedContent {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private HomePage homePage;
	private DashboardPage dashboardPage;

	private String userName;
	private String password;
	private String selectAllSegmentsCheckBox;
	private String selectAllCategoriesCheckBox;
	private String siteconfigGroupsOption;
	private String userOptions;
	private String userOptionsLogout;
	private String requestPublishButton;
	private String publishSubmitButton;
	private String previewDependenciesButton;
	private String cancelWorkflowContinueButton;
	private String staticAssetsButton;
	private String homeTree;

	private CreateSitePage createSitePage;
	private UsersPage usersPage;
	private PreviewPage previewPage;
	private String articlesFolder;

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		this.createSitePage = new CreateSitePage(driverManager, UIElementsPropertiesManager);

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		this.usersPage = new UsersPage(driverManager, uIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, UIElementsPropertiesManager);
		articlesFolder = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		selectAllSegmentsCheckBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_select_all_segments_checkbox");
		selectAllCategoriesCheckBox = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.select_All_Categories_CheckBox");
		siteconfigGroupsOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("siteconfig.groups_option");
		userOptions = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.user_options");
		userOptionsLogout = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
		requestPublishButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.request_publish_button");
		publishSubmitButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish_submit");
		previewDependenciesButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.dependencies_button");
		cancelWorkflowContinueButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.workflow_cancellation_continue_Button");
		staticAssetsButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		homeTree = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void addNewUser() {

		// click On Users option
		createSitePage.clickOnUsersOption();

		// click on new user button
		usersPage.clickOnNewUser();

		// Follow the form
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#firstName").sendKeys("Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#lastName")
				.sendKeys("Last Name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#email")
				.sendKeys("email@email.com");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#username").sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#password").sendKeys("author");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#passwordVerification")
				.sendKeys("author");

		// Save Button

		usersPage.clickOnSaveNewUser();

		// Assert new users created is present
		WebElement newUserCreated = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				"#container > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a");

		Assert.assertTrue(newUserCreated.isDisplayed());
		
		// Switch to the form
		driverManager.getDriver().navigate().refresh();
		driverManager.getDriver().switchTo().defaultContent();

//		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", "homeSites");
//
//		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", "homeSites").click();
		
		 this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
		 "/html/body/ui-view/header/nav/div/div[1]/a/img");
		
		 this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
		 "/html/body/ui-view/header/nav/div/div[1]/a/img").click();

	}

	public void deleteUser() {

		// login to application
		loginPage.loginToCrafter(userName, password);

		// click On Users option

		createSitePage.clickOnUsersOption();

		// Click on delete user
		usersPage.clickOnDeleteUserCreated();

		// Confirmation to delete user connected
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				"body > div.modal.fade.ng-isolate-scope.centered-dialog.in > div > div > div.modal-footer.ng-scope > button:nth-child(1)")
				.click();

		// Assert new users created is deleted

		WebElement onlyAdminUserExist = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				"#container > div > div > div > div > div > table > tbody");

		Assert.assertTrue(onlyAdminUserExist.isDisplayed());

	}

	public void createSitesRandom() {

		// Click on the create site button

		homePage.clickOnCreateSiteButton();

		// Filling the name of site

		createSitePage.fillSiteName();

		// Filling the description of the site

		createSitePage.fillDescription("Description");

		// Open blueprint combo

		createSitePage.openBlueprintCombo();

		// Select empty blueprint

		createSitePage.selectEmptyBlueprint();

		// Click on Create button

		createSitePage.clickOnCreateSiteButton();

		// go to the sites page
		String sitesNavOptionElementCssSelector = "#sitesRightNav";

		if (this.driverManager.isElementPresentBycssSelector(sitesNavOptionElementCssSelector))
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", sitesNavOptionElementCssSelector)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
	}

	public void login(String user, String loginpassword) {
		// login to application
		loginPage.loginToCrafter(user, loginpassword);
		// go to preview page

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

		dashboardPage.updateFieldsOfPageArticleContent(randomInternalName, pageName);

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

	public void changeBodyToNotRequiredOnPageArticleContent() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();

		previewPage.changeBodyOfArticlePageToNotRequired();

	}

	public void addUserToAuthorGroup() {

		WebElement siteConfigButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				"admin-console");
		siteConfigButton.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteconfigGroupsOption)
				.click();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//iframe"));
		this.driverManager.isElementPresentAndClickableByXpath(".//iframe");

		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"(//i[@class='fa fa-pencil'])[2]");

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", "(//i[@class='fa fa-pencil'])[2]")
				.click();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//iframe"));
		this.driverManager.isElementPresentAndClickableByXpath(".//iframe");

		this.driverManager.getDriver().switchTo().activeElement();
		// id container

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", "//*[@id='users-tags-input']/div/div");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", "//*[@id='users-tags-input']/div/div")
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", "//*[@id='users-tags-input']/div/div/input")
				.sendKeys("author");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				"//*[@id='users-tags-input']/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/div/div[1]");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				"//*[@id='users-tags-input']/div/auto-complete/div/ul/li/ti-autocomplete-match/ng-include/div/div[1]")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//*[@id='container']/div/div/div[2]/div/a");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//*[@id='container']/div/div/div[2]/div/a").click();

		Assert.assertTrue(driverManager.isElementPresentByXpath("//*[@id='container']/div/div/div[2]/table/tbody/tr/td[1]"));

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", "navbar-site-name");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", "navbar-site-name").click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", "#admin-console");

	}

	private void goToSiteContentPagesStructure() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//SPAN[@class='ng-binding'][text()='Create Site']");

		homePage.goToPreviewPage();
		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

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

	private void renamePageWithWorkflowCancelation(WebElement parentPage, String newPageName) {
		dashboardPage.rightClickEditOnAPresentPage(parentPage);

		// Cancel the Workflow

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", cancelWorkflowContinueButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", cancelWorkflowContinueButton).click();

		// Edit PAge Article
		this.editPageArticleContent(newPageName);

	}

	private void logoutFromCrafter() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", userOptions).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", userOptionsLogout).click();

	}

	private void requestPublish(String newPageArticleName) {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'" + newPageArticleName + "')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'" + newPageArticleName + "')]").click();

		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", requestPublishButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", requestPublishButton)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", publishSubmitButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", publishSubmitButton)
				.click();

		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.isElementPresentByXpath(".//span[text()='Toggle navigation']");

	}

	public void testScenario() {
		// Related to the bug:
		// issue https://github.com/craftercms/craftercms/issues/1557

		this.login(userName, password);

		this.addNewUser();

		this.goToSiteContentPagesStructure();

		this.addUserToAuthorGroup();

		// body not required Page-Article
		this.changeBodyToNotRequiredOnPageArticleContent();

		// expand pages folder
		dashboardPage.expandPagesTree();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				homeTree);


		// expand Home tree
		dashboardPage.expandHomeTree();

		previewPage.createPageArticleContent("test", "Testing1", "test", articlesFolder, selectAllCategoriesCheckBox,
				selectAllSegmentsCheckBox, "ArticleSubject", "ArticleAuthor", "ArticleSummary");

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.getDriver().navigate().refresh();

		// Open dependencies for the previous created element
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'articles')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'articles')]").click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", "//*[@id='acn-dropdown-inner']")
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", "//*[@id='acn-dropdown-inner']")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]").click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", previewDependenciesButton);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", previewDependenciesButton).click();

		// check dependencies are listed
		previewPage.checkDependencies();

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.getDriver().navigate().refresh();

		// Bulk Publish
		previewPage.bulkPublish();

		// Verify Article is published

		previewPage.verifyPageArticleIsPublished();

		// logout from Crafter
		this.logoutFromCrafter();

		// login to application with author user
		loginPage.loginToCrafter("author", "author");

		this.driverManager.getDriver().switchTo().activeElement();

		// Go to the site page

		homePage.goToPreviewPage();
		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// expand Home tree
		dashboardPage.expandHomeTree();
		
		this.driverManager.getDriver().navigate().refresh();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'articles')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'articles')]").click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", "//*[@id='acn-dropdown-inner']")
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", "//*[@id='acn-dropdown-inner']")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]").click();

		WebElement articlePage;

		articlePage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'Testing1')]");

		// Edit content Page with the Author User
		String newPageArticleName = "Testing1Edited";
		this.renamePage(articlePage, newPageArticleName);

		// request publish
		this.requestPublish(newPageArticleName);

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().defaultContent();

		this.driverManager.getDriver().navigate().refresh();

		// Open dependencies for the previous created element
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//A[@class='cursor'][text()='Dependencies']");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//A[@class='cursor'][text()='Dependencies']").click();

		// check dependencies are listed
		previewPage.checkDependencies();

		// Cancel the Workflow and Edit again the Page Article Content

		newPageArticleName = "Testing1Edited2";
		articlePage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'Testing1Edited')]");
		this.renamePageWithWorkflowCancelation(articlePage, newPageArticleName);

		// Check on Static Assets that dependencies are not mark as edited

		// Collapse Home tree
		dashboardPage.expandHomeTree();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'static-assets')]");
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//span[contains(text(),'static-assets')]")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//span[contains(text(),'images')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//span[contains(text(),'images')]")
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'1-gear.png')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'1-gear.png')]").click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				"//A[@class='cursor'][text()='Dependencies']");

		String isLifeContent = "";

		while (!(isLifeContent.contains("undefined live"))) {
			isLifeContent = this.driverManager.getDriver()
					.findElement(By.xpath("//ul[@id='activeContentActions']/li/span/div/span/span[2]"))
					.getAttribute("class").toString();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					".//span[contains(text(),'1-gear.png')]").click();
			this.dashboardPage.expandHomeTree();
		}

		Assert.assertTrue(this.driverManager.getDriver()
				.findElement(By.xpath(".//ul[@id='activeContentActions']/li/span/div/span/span[2]"))
				.getAttribute("class").contains("undefined live"));

	}

	@Test
	public void changeStateOfPreviousPublishedContent() {
		this.testScenario();
	}

}