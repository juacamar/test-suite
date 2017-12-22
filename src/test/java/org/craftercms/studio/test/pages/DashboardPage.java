package org.craftercms.studio.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DashboardPage {

	private WebDriverManager driverManager;
	private WebDriver driver;

	private String pagesTree;
	private String homeContent;
	private String addNewContent;
	private String okButton;
	private String setPageURL;
	private String setInternalName;
	private String saveCloseButton;
	private String saveDraft1;
	private String addNewFolder;
	private String createButton;
	private String setFolderName;
	private String copyContent;
	private String aboutUSContentPage;
	private String cutContent;
	private String pasteContentXpath;
	private String newContentCreated;
	private String clickOnSiteContent;
	private String deleteContentOK;
	private String submittalCompleteOK;
	private String editParentOption;
	private String editRecentlyContentCreated;
	private String selectEntryCT;
	private String pageArticleContentTypeLocator;
	private String homeTree;
	private String folderCreated;
	private String previewDuplicate;
	private String levelDescriptorContentType;
	private String pasteContent;
	private String newFolderCreated;
	private String deleteContent;
	private String usersContextualNavigationOption;
	private String articlesTitleLocator;
	private String copyOptionLocator;
	private String categoriesLocator;
	private String copyButonOnTreeSelector;
	private String pasteOptionLocator;
	private String cutOptionLocator;
	private String contextualNavigationEditLocator;
	private String contextualNavigationHistoryLocator;
	private String closeButtonLocator;
	private String historyCloseButtonLocator;
	private String publishOptionLocator;
	private String approveAndPublishPublishButtonLocator;
	private String deleteOptionLocator;
	private String deleteDeletButtonLocator;
	private String addNewFolderOption;
	private String addNewContentOption;
	private String deleteOKButtonLocator;
	private String copyOptionLocatorForContentPage;
	private String articlesSubjectInput;
	private String articlesAuthorInput;
	private String articlesSummaryInput;
	private String articleAddImageButton;
	private String compareButtonByXpath;
	private String existingImagesButton;
	private String addCloseGearImageButton;
	private String editRecentActivity;
	private String seeThePageEdited;
	private String copyContentButton;
	private static Logger logger = LogManager.getLogger(DashboardPage.class);

	/**
	 * 
	 */
	public DashboardPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();

		pagesTree = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Pages_Tree");
		homeTree = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");
		homeContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page");
		addNewContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_New_Content");
		addNewFolder = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_New_Folder");
		selectEntryCT = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.entry_Content_Type");
		okButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.ok_Button");
		setPageURL = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame2.page_URL");
		setInternalName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame2.internal_Name");
		saveCloseButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.save_Close_Button");
		saveDraft1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame2.save_Draft");
		createButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.create_Button");
		setFolderName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.folder_name");
		copyContent = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.copy_content");
		copyContentButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.copy_contentButton");
		aboutUSContentPage = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.aboutuscontentpage");
		pasteContent = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.paste_content");
		pasteContentXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.paste_contentXpath");
		deleteContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_content");
		cutContent = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.cut_content");
		newContentCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.new_content");
		clickOnSiteContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.site_content");
		deleteContentOK = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_content_OK");
		submittalCompleteOK = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.submitall.ok");
		editParentOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.edit_parent_option");
		editRecentlyContentCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.edit_recently_content_created");
		folderCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.folder_created");
		previewDuplicate = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.duplicate");
		levelDescriptorContentType = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.level_descriptor");
		newFolderCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_new_folder");
		pasteContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.paste_content_copied");
		usersContextualNavigationOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.userscontextualnavigationoption");
		pageArticleContentTypeLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.pageArticle_Content_Type");
		articlesTitleLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.articlestitlefield");
		categoriesLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.categoriesdropdownlist");
		copyOptionLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickcopyoption");
		copyButonOnTreeSelector = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.treeselectorcopybutton");
		pasteOptionLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickpasteoption");
		cutOptionLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickcutoption");
		contextualNavigationEditLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.edittopnavoption");
		contextualNavigationHistoryLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.historytopnavoption");
		compareButtonByXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.compare_button");
		closeButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.closebutton");
		historyCloseButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.historyClosebutton");
		publishOptionLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickpublish");
		approveAndPublishPublishButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.approveandpublishsubmitbutton");
		deleteOptionLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickdeleteoption");
		deleteDeletButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.deletedeletebutton");
		addNewFolderOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickaddnewfolderoption");
		addNewContentOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickaddnewcontentoption");
		deleteOKButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.deleteOkbutton");
		copyOptionLocatorForContentPage = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickcopyoptionforcontentpage");
		articlesSubjectInput = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_subject_input");
		articlesAuthorInput = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_author_input");
		articlesSummaryInput = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_summary_input");
		articleAddImageButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_add_image_button");
		existingImagesButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_existing_images_button");
		addCloseGearImageButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.article_addclose_gear_image");
		editRecentActivity = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivty.editoption");
		seeThePageEdited = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.myrecentactivty.viewpage");

	}

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Expand pages tree
	public void clickPagesTree() {
		this.driverManager.waitUntilSidebarOpens();
		WebElement expandPagesTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", pagesTree);
		if(!expandPagesTree.getAttribute("class").contains("open")) {
		expandPagesTree.click();
		driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
		}
	}

	public void expandPagesTree() {
		// Expand pages tree
		logger.info("Expanding Pages tree");
		this.clickPagesTree();
	}

	// Expand global entry content

	public void clickGlobalEntryContent() {
		this.driverManager.waitUntilSidebarOpens();
		WebElement globalEntry = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				homeTree);

		// Verify if the home tree is already expanded
		WebElement home = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", homeContent);
		if (!home.getAttribute("class").contains("open")) {
			globalEntry.click();
		}
	}

	public void expandHomeTree() {
		// Expand global entry content
		logger.info("Expanding Home tree");
		this.clickGlobalEntryContent();
	}

	// Expand home content
	public void clickHomeContent() {
		WebElement home = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", homeContent);
		home.click();
	}

	public void clickHomeTree() {
		// Expand home content
		this.clickHomeContent();
	}

	// Press right click and select new content
	public void rightClickHome() {
		this.driverManager.waitUntilPageLoad();
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");		
		this.driverManager.waitForAnimation();
		this.getDriverManager().contextClick("xpath", homeContent, false);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", homeContent);
		driverManager.usingContextMenu(() -> {
			WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					addNewContent);
			addContent.click();
		});
	}

	public void rightClickToSeeMenu() {
		logger.info("Right Click to see Menu");
		// Press right click and select new content
		this.rightClickHome();
	}

	public void rightClickToSeeMenuOfSpecificFolder(String folderLocation) {
		// Press right click and select new content
		this.rightClickSpecificFolder(folderLocation);
	}

	public void rightClickSpecificFolder(String folderLocation) {
		this.driverManager.isElementPresentAndClickableByXpath(folderLocation);
		WebElement folderLocationElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", folderLocation);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), folderLocationElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					addNewContent);
			addContent.click();
		});
	}

	// Press right click select new folder
	public void rightClickNewFolderOnHome() {
		// wait for the animation to end
		this.driverManager.waitUntilSidebarOpens();
		this.driverManager.waitUntilFolderOpens("xpath", ".//a[@id='pages-tree']");
		this.getDriverManager().contextClick("xpath", homeContent, false);

		driverManager.usingContextMenu(() -> {
			WebElement addFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					addNewFolder);
			addFolder.click();
		});
	}

	// Press right click select new folder
	public void rightClickNewFolderOnAPresentFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement addFolderOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					addNewFolderOption);
			addFolderOption.click();
		});
	}

	// Press right click to see the menu
	public void rightClickCreatePageOnAPresentFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					addNewContentOption);
			addContent.click();
		});
	}

	public void rightClickToFolderOnHome() {
		// Press right click select new folder
		logger.info("Right Click  on Folder Home");
		this.rightClickNewFolderOnHome();
	}

	// Select Entry Content type
	public void selectEntryCT() {
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		driverManager.waitUntilElementIsDisplayed("cssSelector", selectEntryCT);
		Assert.assertTrue(driverManager.isElementPresentBycssSelector(selectEntryCT));
	}

	public void selectPageArticleContentType() {
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		driverManager.waitUntilElementIsDisplayed("cssSelector", pageArticleContentTypeLocator);
		Assert.assertTrue(driverManager.isElementPresentBycssSelector(pageArticleContentTypeLocator));
	}

	public void clickEntryCT() {
		logger.info("Select Entry Content Type");
		// Select Generic Content type
		this.selectEntryCT();
	}

	// Select Level Descriptor Content type
	public void selectLDCT() {
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		WebElement levelDescriptorCT = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				levelDescriptorContentType);
		levelDescriptorCT.click();
	}

	public void clickLevelDescriptorCT() {
		// Select Level Descriptor Content type
		this.selectLDCT();
	}

	// Confirm the CT selected
	public void confirmCTSelected() {
		WebElement okButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", this.okButton);
		okButton.click();
	}

	public void clickOKButton() {
		// Confirm the CT selected
		this.confirmCTSelected();
	}

	// Set page URL
	public void setPageURL1(String strPageURL) {
		driverManager.sendText("xpath", setPageURL, strPageURL.toLowerCase());
	}

	// Set internal name
	public void setInternalName1(String strInternalName) {
		driverManager.sendText("xpath", setInternalName, strInternalName);
	}

	// Click on save and close button
	public void clickSaveClose() {
		this.driverManager.isElementPresentAndClickableById(this.saveCloseButton);
		WebElement saveCloseButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
				this.saveCloseButton);
		saveCloseButton.click();
	}

	// Click on save and close button
	public void clickSaveDraft() {
		this.driverManager.isElementPresentAndClickableById(saveDraft1);
		WebElement saveDraftButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
				saveDraft1);
		saveDraftButton.click();
	}

	// Setting basic fields of the nre content
	public void setBasicFieldsOfNewContent(String strPageURL, String strInternalName) {
		// Fill page URL
		this.setPageURL1(strPageURL);
		// Fill internal name
		this.setInternalName1(strInternalName);
	}

	// Click on save and close button
	public void clickSaveAndDraft() {
		WebElement saveDraftButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", saveDraft1);
		saveDraftButton.click();
	}

	public void setLevelDescriptorName(String strFileName) {
		// Fill page URL
		this.setPageURL1(strFileName);
		// Click on save and draft button
		this.clickSaveAndDraft();

	}

	// Set the name of the folder
	public void folderName(String strFolderName) {
		driverManager.usingYuiDialog(() -> {
			driverManager.sendText("id", setFolderName, strFolderName);
			createButton();
		});
	}

	public void setFolderName(String strFolderName) {
		// Set the name of the folder
		logger.info("Creating a new folder");
		this.folderName(strFolderName);
	}

	// create button
	public void createButton() {
		WebElement buttonCreate = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", createButton);
		buttonCreate.click();
	}

	public void clickCreateButton() {
		// create button
		this.createButton();
	}

	// Press right click and press copy option (about us page)
	public void rightClickCopyOptionAboutUs() {

		// wait for the animation to end
		driverManager.waitUntilSidebarOpens();

		WebElement copypasteContent = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", aboutUSContentPage);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent, false);

		driverManager.usingContextMenu(() -> {
			WebElement copyContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
					this.copyContent);
			copyContent.click();
		});

	}

	public void rightClickToCopyOptionAboutUs() {
		// Press right click and press copy option
		this.rightClickCopyOptionAboutUs();
	}

	// Press right click and press copy option (service page)
	public void rightClickCopyOptionService() {
		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				newContentCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent, false);
		driverManager.usingContextMenu(() -> {
			WebElement copyContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
					this.copyContent);
			copyContent.click();
		});
	}

	public void rightClickToCopyOptionService() {
		// Press right click and press copy option
		this.rightClickCopyOptionService();
	}

	// Press right click and press paste option
	public void rightClickPasteOption() {

		// wait for the animation to end
		driverManager.waitUntilSidebarOpens();

		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				homeContent);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent, false);

		driverManager.usingContextMenu(() -> {
			WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
					this.pasteContent);
			pasteContent.click();
		});
	}

	public void rightClickToPasteOption() {
		// Press right click and press paste option
		this.rightClickPasteOption();
	}

	// Press right click and press paste option
	public void rightClickToPasteIntoFolderToTest() {
		this.driverManager.isElementPresentAndClickableByXpath(newFolderCreated);
		WebElement newFolderElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newFolderCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), newFolderElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					pasteContentXpath);
			pasteContent.click();
		});
	}

	public void rightClickToPasteIntoFolder() {
		// Press right click and press paste option
		logger.debug("Right Click to Paste into Folder");
		this.rightClickToPasteIntoFolderToTest();
	}

	// edit internal name
	public void editInternalName(String strInternalName) {
		// Fill internal name
		this.setInternalName1(strInternalName);

		// Save and close button.
		this.clickSaveClose();
	}

	// Press right click and press cut option
	public void rightClickCutOption() {
		this.driverManager.isElementPresentAndClickableByName(newContentCreated);
		WebElement cutpasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newContentCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), cutpasteContent, false);
		driverManager.usingContextMenu(() -> {
			WebElement cutContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					this.cutContent);
			cutContent.click();
		});
	}

	public void rightClickToCutOption() {
		// Press right click and press cut option
		logger.debug("Right Click to Cut Option");
		this.rightClickCutOption();
	}

	// Press right click and copy the component to new folder created.
	public void rightClickCopyComponent() {
		WebElement copyComponent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newContentCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copyComponent, false);
		driverManager.usingContextMenu(() -> {
			WebElement copyComponentToNewFolder = this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", copyContent);
			copyComponentToNewFolder.click();
		});
	}

	public void rightClickToCopyComponentToNewFolder() {
		// Press right click and copy the component to new folder created.
		this.rightClickCopyComponent();
	}

	// Press right click and copy the new content to the new folder
	public void rightClickCopyNewContent() {

		WebElement copyNewContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newContentCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copyNewContent, false);
		driverManager.usingContextMenu(() -> {
			WebElement copyNewContentToNewFolder = this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", this.copyContent);
			copyNewContentToNewFolder.click();
		});
	}

	public void rightClickToCopyNewContentToNewFolder() {
		// Press right click and copy the new content to the new folder
		this.rightClickCopyNewContent();
	}

	// Press right click and press paste option to the new folder
	public void rightClickPaste() {
		this.driverManager.isElementPresentAndClickableByXpath(folderCreated);
		WebElement pasteAllContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				folderCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteAllContent, false);
		driverManager.usingContextMenu(() -> {
			WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					pasteContentXpath);
			pasteContent.click();
		});
	}

	public void rightClickToPasteToNewFolder() {
		// Press right click and press paste option to the new folder
		this.rightClickPaste();
	}

	// copy button
	public void copyButton() {
		WebElement buttonCopy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", copyContentButton);
		buttonCopy.click();
	}

	public void clickCopyButton() {
		// copy button
		this.copyButton();
	}

	public void clickCopyButtonOnTreeSelector() {
		WebElement buttonCopy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				copyButonOnTreeSelector);
		buttonCopy.click();
	}

	// click on Site Content
	public void clickSiteContent() {
		WebElement siteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				clickOnSiteContent);
		siteContent.click();
	}

	public void clickOnSiteContentOption() {
		// click on Site Content
		this.clickSiteContent();
	}

	// Press right click and select new content

	public void deleteContent() {
		WebElement showMenu = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				newContentCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), showMenu, false);
		driverManager.usingContextMenu(() -> {
			WebElement delContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					deleteContent);
			delContent.click();
		});
	}

	public void rightClickToDeleteContent() {
		// Press right click and select new content
		this.deleteContent();
	}

	// Ok delete content option
	public void deleteContentOK() {
		WebElement confirmDelete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				deleteContentOK);
		confirmDelete.click();
	}

	public void clicktoDeleteContent() {
		// Ok delete content option
		this.deleteContentOK();
	}

	// Ok submittal complete
	public void submittalCompleteOK() {
		WebElement submittalComplete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				submittalCompleteOK);
		submittalComplete.click();
	}

	public void clickOKSubmittalComplete() {
		// Ok submittal complete
		this.submittalCompleteOK();
	}

	// Press right click and select edit to the content created
	public void rightClickToEdit() {

		// wait for the animation to end
		driverManager.waitUntilSidebarOpens();

		WebElement editContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				newContentCreated);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), editContent, false);

		driverManager.usingContextMenu(() -> {
			WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
					editRecentlyContentCreated);
			editOption.click();
		});
	}

	public void rightClickToSelectEditOption() {
		// Press right click and select edit to the content created
		this.rightClickToEdit();
	}

	// Click on duplicate button of the menu
	public void duplicateButton() {
		WebElement duplicateOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				previewDuplicate);
		duplicateOption.click();
	}

	public void clickOnDuplicateOption() {
		// Click on duplicate button of the menu
		this.duplicateButton();
	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void clickUsersContextualNavigationOption() {
		WebElement usersContextualNavigationOptionWebElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("xpath", usersContextualNavigationOption);
		usersContextualNavigationOptionWebElement.click();
	}

	public void setBasicFieldsOfNewPageArticleContent(String strPageURL, String strInternalName,
			String strArticlesTitle) {
		// Fill page URL
		this.setPageURL1(strPageURL);
		// Fill internal name
		this.setInternalName1(strInternalName);
		// Fill the Subject field
		this.setArticlesTitle(strArticlesTitle);
		// select the Category
		this.selectFirstCategoryOfPagArticle();
	}

	public void updateBasicFieldsOfNewPageArticleContent(String strInternalName, String strArticlesTitle) {
		// Fill internal name
		this.setInternalName1(strInternalName);
		// Fill the Subject field
		this.setArticlesTitle(strArticlesTitle);
		// select the Category
		this.selectFirstCategoryOfPagArticle();
	}

	public void updateFieldsOfPageArticleContent(String strInternalName, String strArticlesTitle) {
		// Fill internal name
		this.setInternalName1(strInternalName);
		// Fill the Subject field
		this.setArticlesTitle(strArticlesTitle);

	}

	public void setArticlesTitle(String strArticlesTitle) {
		driverManager.sendText("xpath", articlesTitleLocator, strArticlesTitle);
	}

	public void setNewArticleContentSection(String subject, String author, String summary) {
		driverManager.sendText("xpath", articlesSubjectInput, subject);
		driverManager.sendText("xpath", articlesAuthorInput, author);
		driverManager.sendText("xpath", articlesSummaryInput, summary);
	}

	public void selectFirstCategoryOfPagArticle() {
		Select categoriesDropDown = new Select(
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", categoriesLocator));
		categoriesDropDown.selectByValue("style");
	}

	public void selectCategoriesOfNewPageArticle(String category) {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", category);
		WebElement categoryToCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", category);
		categoryToCheck.click();
	}

	public void selectSegmentsOfNewPageArticle(String segments) {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", segments);
		WebElement segmentToCheck = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", segments);
		segmentToCheck.click();
	}

	public void selectAllTreeOnSelector(String folderXPath) {
		WebElement checkAllTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", folderXPath);
		if (!checkAllTree.getAttribute("checked").equals("true"))
			checkAllTree.click();
	}

	public void clicOnHomeTree() {
		WebElement homeTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				this.homeTree);
		homeTree.click();
	}

	public void clickOnContextualNavigationEditOption() {
		WebElement contextualNavigationEdit = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", contextualNavigationEditLocator);
		contextualNavigationEdit.click();
	}

	public void clickOnContextualNavigationHistoryOption() {
		WebElement contextualNavigationHistory = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", contextualNavigationHistoryLocator);
		contextualNavigationHistory.click();
	}

	public void clickCompareButton() {
		WebElement compareButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				compareButtonByXpath);
		compareButton.click();
	}

	public void clickCloseButton() {
		WebElement closeButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				closeButtonLocator);
		closeButton.click();
	}

	public void clickHistoryCloseButton() {
		WebElement historyCloseButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				historyCloseButtonLocator);
		historyCloseButton.click();
	}

	public void clickOnPublishOption() {
		WebElement publishOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				publishOptionLocator);

		publishOption.click();
	}

	public void rightClickOnAContentPage(WebElement element) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), element, false);
	}

	public void rightClickOnAContentPageByJavascript(WebElement element) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), element, true);
	}

	public void clickApproveAndPublishSubmitButton() {
		this.driverManager.isElementPresentAndClickableById(approveAndPublishPublishButtonLocator);
		WebElement submitButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id",
				approveAndPublishPublishButtonLocator);
		submitButton.click();

		this.driverManager.isElementPresentAndClickableByXpath(homeTree);
	}

	public void clickDeleteDeleteSubmitButton() {
		this.driverManager.isElementPresentAndClickableById(deleteDeletButtonLocator);
		WebElement deleteButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				deleteDeletButtonLocator);
		deleteButton.click();
		this.acceptDeletionAction();
	}

	public void acceptDeletionAction() {
		// Switch to the dialog
		driverManager.getDriver().switchTo().activeElement();
		// Click on Publish button
		this.driverManager.isElementPresentAndClickableByXpath(deleteOKButtonLocator);
		WebElement okButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				deleteOKButtonLocator);
		okButton.click();
	}

	public void rightClickCopyFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement copyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					copyOptionLocator);
			copyOption.click();
		});
	}

	public void rightClickPasteOnAFolder(WebElement parentWebElement) {
		this.driverManager.contextClick(this.getDriverManager().getDriver(), parentWebElement, false);

		WebElement pasteOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				pasteOptionLocator);
		pasteOption.click();

	}

	public void rightClickCutAFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement cutOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					cutOptionLocator);
			cutOption.click();
		});
	}

	public void rightClickDeleteAFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, true);
		driverManager.usingContextMenu(() -> {
			WebElement deleteOption = this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", deleteOptionLocator);
			deleteOption.click();
		});
	}

	public void rightClickDeleteAPage(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement deleteOption = this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", deleteContent);
			deleteOption.click();
		});
	}

	public void expandParentFolder(WebElement parentElement) {
		if (!parentElement.getAttribute("class").contains("open")) {
			this.driverManager.waitUntilContentTooltipIsHidden();
			parentElement.click();
		}
	}

	public void switchToAFormByCssSelector(String cSSSelector) {
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", cSSSelector));
		this.driverManager.isElementPresentAndClickableBycssSelector(cSSSelector);
	}

	public void rightClickCopyContentPage(WebElement parentWebElement) {
		this.driverManager.isElementPresentAndClickableById(parentWebElement.getAttribute("id"));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement copyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					copyOptionLocatorForContentPage);
			copyOption.click();
		});
	}

	public void rightClickCreatePageOnAPresentPage(WebElement webElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), webElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					addNewContent);
			addContent.click();
		});
	}

	public void rightClickEditOnAPresentPage(WebElement webElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), webElement, false);
		driverManager.usingContextMenu(() -> {
			WebElement editContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					editParentOption);
			editContent.click();
		});
	}

	public void addAnImageToAnArticle() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", articleAddImageButton)
				.click();

		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", existingImagesButton)
				.click();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector(".studio-ice-dialog > .bd iframe");
		driverManager.getDriver().switchTo().defaultContent();
		this.driverManager.getDriver().switchTo().frame(2);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", addCloseGearImageButton)
				.click();

	}

	public void clickEditOptionOfRecentActivitySection() {
		WebElement editOptionMyRecentActivity = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				editRecentActivity);
		editOptionMyRecentActivity.click();
	}

	public void clickOnEditOptionRecentActivity() {
		// Click on edit option of my recent activity senction
		this.clickEditOptionOfRecentActivitySection();
	}

	// See the page edited
	public void displayPageEdited() {
		WebElement seeThePageMyRecentActivity = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				seeThePageEdited);
		seeThePageMyRecentActivity.click();
	}

	public void seeThePageEdited() {
		// See the page edited
		this.displayPageEdited();
	}

}