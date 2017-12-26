/**
 * 
 */
package org.craftercms.studio.test.cases.generaltestcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.cases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author Juan Camacho
 *
 */
public class ChangeStateOfPreviousPublishedContent extends BaseTest {

	private String userName;
	private String password;
	private String selectAllSegmentsCheckBox;
	private String selectAllCategoriesCheckBox;
	private String siteconfigGroupsOption;
	private String userOptions;
	private String userOptionsLogout;
	private String requestPublishButton;
	private String publishSubmitButton;
	private String cancelWorkflowContinueButton;
	private String staticAssetsButton;
	private String homeTree;
	private String sidebarMenuOption;
	private String dependenciesMenuOption;
	private String staticAssetsChildFolder;
	private String staticAssetsImagesChildFolder;
	private String navigationElement;
	private String editAuthorGroupOption;
	private String groupsAddNewMembersCheckbox;
	private String groupsAddNewMembersInput;
	private String groupsAddNewMembersAutocompleteOption1;
	private String groupsAddNewMembersButton;
	private String navigationSitebarNameId;
	private String crafterLogo;
	private String generalSiteDropdown;
	private String pageStatus;
	private String staticAssetsGearImageId;
	private String articlesFolder;
	private String createFormFrameElementCss;
	private String generalEditOption;
	private static Logger logger = LogManager.getLogger(ChangeStateOfPreviousPublishedContent.class);

	@BeforeMethod
	public void beforeTest() {
		
		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		
		articlesFolder = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.articlesfolder");
		selectAllSegmentsCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_select_all_segments_checkbox");
		selectAllCategoriesCheckBox = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.select_All_Categories_CheckBox");
		siteconfigGroupsOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("siteconfig.groups_option");
		userOptions = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.user_options");
		userOptionsLogout = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.user_options_logout");
		requestPublishButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.requestpublishtopnavoption");
		publishSubmitButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.approve&publish.submit");
		cancelWorkflowContinueButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.workflow_cancellation_continue_Button");
		staticAssetsButton = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.static_assets_button");
		homeTree = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");
		sidebarMenuOption = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"complexscenarios.general.sitedropdownmenuinnerxpath");
		dependenciesMenuOption = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.dependenciestopnavoption");
		staticAssetsChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"preview.static_assets_child_folder");
		staticAssetsImagesChildFolder = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"preview.static_assets_images_child_folder");
		navigationElement = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"complexscenarios.general.togglenavigationelement");
		editAuthorGroupOption = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.edit_author_group_option");
		groupsAddNewMembersCheckbox = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_checkbox");
		groupsAddNewMembersInput = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_input");
		groupsAddNewMembersAutocompleteOption1= uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_autocomplete_option1");
		groupsAddNewMembersButton = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"groups.add_new_members_button");
		navigationSitebarNameId = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.navigation_sitebar_name_id"); 
		crafterLogo = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"users.crafterlogo"); 
		generalSiteDropdown = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.sitedropdown"); 
		pageStatus = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"general.pageStatus");
		staticAssetsGearImageId = uiElementsPropertiesManager.getSharedUIElementsLocators().getProperty(
				"preview.staticassets.gear.image.id");
		createFormFrameElementCss = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.createformframe");
		generalEditOption = uiElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
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

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				crafterLogo);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				crafterLogo).click();

	}

	public void login(String user, String loginpassword) {
		// login to application
		loginPage.loginToCrafter(user, loginpassword);
		// go to preview page
		//Wait for login page to close
		driverManager.waitUntilLoginCloses();

	}

	public void editPageArticleContent(String pageName) {
		
		
		driverManager.usingCrafterForm("cssSelector", createFormFrameElementCss, () -> {
			
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
			
		});

		this.driverManager.waitUntilSidebarOpens();		

	}

	public void changeBodyToNotRequiredOnPageArticleContent() {

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", generalSiteDropdown)
				.click();

		previewPage.changeBodyOfArticlePageToNotRequired();

	}

	public void addUserToAuthorGroup() {
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id","admin-console");

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
				editAuthorGroupOption);
		
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", editAuthorGroupOption)
				.click();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", ".//iframe"));
		this.driverManager.isElementPresentAndClickableByXpath(".//iframe");

		this.driverManager.getDriver().switchTo().activeElement();
		// id container

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersCheckbox)
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", groupsAddNewMembersInput)
				.sendKeys("author");
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				groupsAddNewMembersAutocompleteOption1);

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath",
						groupsAddNewMembersAutocompleteOption1)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				groupsAddNewMembersButton); 

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				groupsAddNewMembersButton).click();

		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", navigationSitebarNameId);

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", navigationSitebarNameId).click();

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

		this.driverManager.isElementPresentByXpath(navigationElement);

	}

	public void testScenario() {
		// Related to the bug:
		// issue https://github.com/craftercms/craftercms/issues/1557

		this.login(userName, password);

		logger.info("Adding New User");
		this.addNewUser();
		
		this.driverManager.getDriver().navigate().refresh();

		logger.info("Go to Site Preview");
		this.goToSiteContentPagesStructure();
		
		// expand pages folder
		this.dashboardPage.expandPagesTree();
		this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
		
		this.driverManager.waitUntilSidebarOpens();

		logger.info("Add previous created user to Author Group");
		this.addUserToAuthorGroup();

		// body not required Page-Article
		logger.info("Change Article Page body content to not required");
		this.changeBodyToNotRequiredOnPageArticleContent();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
				"admin-console");

		// expand Home tree
		this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
		this.dashboardPage.expandHomeTree();
		
		this.driverManager.getDriver().navigate().refresh();
		
		logger.info("Create Article Content");
		previewPage.createPageArticleContent("test", "Testing1", "test", articlesFolder, selectAllCategoriesCheckBox,
				selectAllSegmentsCheckBox, "ArticleSubject", "ArticleAuthor", "ArticleSummary");

		// Switch back to the dashboard page
		this.driverManager.getDriver().switchTo().activeElement();

		this.driverManager.getDriver().navigate().refresh();

		// Open dependencies for the previous created element
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder).click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();
		
		this.driverManager.waitUntilSidebarOpens();	

		// Bulk Publish
		logger.info("Executing bulk publish");
		previewPage.bulkPublish();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder).click();

		// Verify Article is published
		logger.info("Verify Article is published");
		previewPage.verifyPageArticleIsPublished();

		// logout from Crafter
		logger.info("logout from Crafter");
		this.logoutFromCrafter();

		// login to application with author user
		logger.info("login to application with author user");
		loginPage.loginToCrafter("author", "author");
        
		logger.info("Go to Preview Page");
		this.homePage.goToPreviewPage();
//		String siteDropdownElementXPath = sidebarMenuOption;
//
//		if (this.driverManager.isElementPresentByXpath(siteDropdownElementXPath))
//			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
//		else
//			throw new NoSuchElementException(
//					"Site creation process is taking too long time and the element was not found");
//
//		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();
		
		//this.driverManager.waitUntilSidebarOpens();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",generalEditOption);
		
		//waituntilfolderopens
		this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
//		this.dashboardPage.expandHomeTree();
//		this.dashboardPage.expandHomeTree();
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				articlesFolder).click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", sidebarMenuOption)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				".//span[contains(text(),'Testing1')]").click();

		WebElement articlePage;

		articlePage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'Testing1')]");

		// Edit content Page with the Author User
		logger.info("Edit content Page with the Author User");
		String newPageArticleName = "Testing1Edited";
		this.renamePage(articlePage, newPageArticleName);

		// request publish
		logger.info("Request Publish");
		this.requestPublish(newPageArticleName);

//		// Switch back to the dashboard page
//		this.driverManager.getDriver().switchTo().defaultContent();
//
		this.driverManager.getDriver().navigate().refresh();
		

		// Open dependencies for the previous created element
		logger.info("Open dependencies for the previous created element");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				dependenciesMenuOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				dependenciesMenuOption).click();
		

		// check dependencies are listed
		logger.info("Check Listed Dependencies");
		previewPage.checkDependencies();

		// Cancel the Workflow and Edit again the Page Article Content

		newPageArticleName = "Testing1Edited2";
		articlePage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				".//span[contains(text(),'Testing1Edited')]");
		logger.info("Edit again the Page Article Page");
		this.renamePageWithWorkflowCancelation(articlePage, newPageArticleName);

		// Collapse Home tree
		logger.info("Collapse Home tree");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",generalEditOption);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeTree);
		
		this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
		this.dashboardPage.expandHomeTree();

		logger.info("Click the Static Assets Button");
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", staticAssetsButton).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				staticAssetsChildFolder);
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", staticAssetsChildFolder)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", staticAssetsImagesChildFolder);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", staticAssetsImagesChildFolder)
				.click();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
				staticAssetsGearImageId);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
				staticAssetsGearImageId).click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				dependenciesMenuOption);

		String isLifeContent = "";
		int maxNumberofTries = 10;
		logger.info("Assert is lifecontent");
		
//		while (!(isLifeContent.contains("undefined live")&&(maxNumberofTries!=0))) {
//			isLifeContent = this.driverManager.getDriver()
//					.findElement(By.xpath(pageStatus)) 
//					.getAttribute("class").toString();
//			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
//					staticAssetsGearImageId).click();
////			this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
////			this.dashboardPage.expandHomeTree();
//			maxNumberofTries--;
//		}
//
//		Assert.assertTrue(this.driverManager.getDriver()
//				.findElement(By.xpath(pageStatus))
//				.getAttribute("class").contains("undefined live"));
		
		
		/////
		

		while (!(isLifeContent.contains("undefined live") && (maxNumberofTries != 0))) {
			isLifeContent = this.driverManager.getDriver()
					.findElement(By.xpath("//ul[@id='activeContentActions']/li/span/div/span/span[2]"))
					.getAttribute("class").toString();
			driverManager.getDriver().navigate().refresh();
			this.dashboardPage.expandHomeTree();
			maxNumberofTries--;
		}

		Assert.assertTrue(this.driverManager.getDriver()
				.findElement(By.xpath(pageStatus))
				.getAttribute("class").contains("undefined live"));
		
		
		
		
		
		
		

	}
	
	@Test
	public void changeStateOfPreviousPublishedContent() {
		this.testScenario();
	}

}