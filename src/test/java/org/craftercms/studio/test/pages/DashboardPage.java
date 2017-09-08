package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
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
	private String homeContentTree;
	private String homeContent;
	private String addNewContent;
	private String okButton1;
	private String setPageURL1;
	private String setInternalName1;
	private String saveCloseButton1;
	private String setBodyText1;
	private String saveDraft1;
	private String addNewFolder;
	private String createButton1;
	private String setFolderName1;
	private String copyContent1;
	private String aboutUSContentPage;
	private String pasteContent1;
	private String aboutUsOptionCopied;
	private String deleteOptionCopied;
	private String unlockOptionCopied;
	private String deleteOptionCopiedPopup;
	private String deleteOK;
	private String cutContent1;
	private String aboutUsOptionCut;
	private String copyContentButton;
	private String pasteContent2;
	private String newContentCreated;
	private String pasteContent3;
	private String aboutUsOptionToTree1;
	private String aboutUsOptionTreeLevel1;
	private String aboutUsOptionTreeLevel2;
	private String aboutUsOptionTreeCreated;
	private String deleteAboutUsTreeCreated;
	private String clickOnSiteContent;
	private String deleteContentOK;
	private String submittalCompleteOK;
	private String editOption;
	private String ediPagetUrl;
	private String pageUrlField;
	private String previewSync;
	private String editRecentlyContentCreated;
	private String selectEntryCT;
	private String pageArticleContentTypeLocator;
	private String homeTree;
	private String crafterComponent;
	private String folderCreated;
	private String copyContent3;
	private String cutCrafterComponent;
	private String titleMedatata;
	private String previewDuplicate;
	private String duplicateName;
	private String homeContent2;
	private String addNewContent2;
	private String levelDescriptorContentType;
	private String setFileName;
	private String homeContent3;
	private String contentCreatedToCut;
	private String pasteContent0;
	private String newFolderCreated;
	private String deleteCrafterComponent2;
	private String homeTreeDashbard;
	private String usersContextualNavigationOption;
	private String articlesTitleLocator;
	private String copyOptionLocator;
	private String categoriesLocator;
	private String copyButonOnTreeSelector;
	private String pasteOptionLocator;
	private String cutOptionLocator;
	private String homeTreeLocator;
	private String contextualNavigationEditLocator;
	private String contextualNavigationHistoryLocator;
	private String compareButtonLocator;
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
	private String addNewContentOption3;
	private String deleteOption2Locator;

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
		homeTreeDashbard = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Home_Tree2");
		homeContentTree = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_Home_Tree");
		homeContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page");
		homeContent2 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page2");
		addNewContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_New_Content");
		addNewContent2 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_New_Content2");
		addNewFolder = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_New_Folder");
		selectEntryCT = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.entry_Content_Type");
		okButton1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.ok_Button");
		setPageURL1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame2.page_URL");
		setInternalName1 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.internal_Name");
		setBodyText1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame2.bodyOne");
		saveCloseButton1 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("frame2.save_Close_Button");
		saveDraft1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame2.save_Draft");
		createButton1 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.create_Button");
		setFolderName1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.folder_name");
		copyContent1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.copy_content1");
		aboutUSContentPage = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.aboutuscontentpage");
		pasteContent0 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.paste_content");
		pasteContent1 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.paste_content1");
		pasteContent2 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.paste_content2");
		pasteContent3 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.paste_content3");
		aboutUsOptionCopied = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_copied");
		deleteOptionCopied = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_about_us_copied");
		UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.delete_crafter_component");
		deleteCrafterComponent2 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_crafter_component2");
		unlockOptionCopied = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.unlock_about_us_copied");
		deleteOptionCopiedPopup = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_about_us_panel");
		deleteOK = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.delete_OK");
		cutContent1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.cut_content1");
		aboutUsOptionCut = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_cut");
		copyContentButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.copy_content");
		newContentCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.new_content");
		aboutUsOptionToTree1 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_tree1");
		aboutUsOptionTreeLevel1 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_to_the_tree_leve1");
		aboutUsOptionTreeLevel2 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_to_the_tree_leve2");
		// UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.about_us_to_the_tree_leve3");
		aboutUsOptionTreeCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_tree");
		deleteAboutUsTreeCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_about_us_tree");
		clickOnSiteContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.site_content");
		deleteContentOK = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_content_OK");
		submittalCompleteOK = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.submittal_complete");
		editOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.edit_iframe");
		ediPagetUrl = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.edit_url_button");
		pageUrlField = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.page_url_field");
		previewSync = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.preview_sync");
		editRecentlyContentCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.edit_recently_content_created");
		crafterComponent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.crafter_component");
		cutCrafterComponent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.cut_crafter_component");
		folderCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.folder_created");
		copyContent3 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.copy_content3");
		titleMedatata = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.metadata_title");
		previewDuplicate = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.duplicate");
		duplicateName = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.duplicate_name");
		levelDescriptorContentType = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.level_descriptor");
		setFileName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.file_name");
		homeContent3 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.home_Content_Page3");
		contentCreatedToCut = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.content_created_testing");
		newFolderCreated = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_new_folder");
		pasteContent0 = UIElementsPropertiesManager.getSharedUIElementsLocators()
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
		homeTreeLocator = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.hometree");
		contextualNavigationEditLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.contextualnavigationeditoption");
		contextualNavigationHistoryLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.contextualnavigationhistoryoption");
		compareButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.comparebutton");
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
		addNewContentOption3 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.add_New_Content3");
		deleteOption2Locator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.rightclickdeleteoption2");
	}

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Expand pages tree
	public void clickPagesTree() {
		// this.driverManager.driverWait(1500);
		WebElement expandPagesTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath",
				pagesTree);
		// driverManager.getDriver().findElement(By.xpath(pagesTree));
		expandPagesTree.click();
		driverManager.driverWait(2000);
	}

	public void expandPagesTree() {
		// Expand pages tree
		this.clickPagesTree();
	}

	// Expand global entry content
	public void clickGlobalEntryContent() {
		// this.driverManager.driverWait(1500);
		WebElement globalEntry = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath", homeTree);
		// driverManager.getDriver().findElement(By.xpath(homeTree));
		globalEntry.click();
	}

	public void expandHomeTree() {
		// Expand global entry content
		this.clickGlobalEntryContent();
	}

	// Expand home tree
	public void clicHomeTree2() {
		// this.driverManager.driverWait(1500);
		WebElement homeTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath",
				homeTreeDashbard);
		// driverManager.getDriver().findElement(By.xpath(homeTreeDashbard));
		homeTree.click();
	}

	public void expandHomeTree2() {
		// Expand home tree
		this.clicHomeTree2();
	}

	// Expand home content
	public void clickHomeContent() {
	 this.driverManager.driverWait(2000);
		WebElement home = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				homeContentTree);
		// driverManager.getDriver().findElement(By.cssSelector(homeContentTree));
		home.click();
	}

	public void clickHomeTree() {
		// Expand home content
		this.clickHomeContent();
	}

	// Press right click and select new content
	public void rightClickHome() {
		// this.driverManager.driverWait(1500);
		WebElement home = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath", homeContent);
		// driverManager.getDriver().findElement(By.xpath(homeContent));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), home);

		// this.driverManager.driverWait(1500);
		WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				addNewContent);
		// driverManager.getDriver().findElement(By.xpath(addNewContent));
		addContent.click();
	}

	public void rightClickToSeeMenu() {
		// Press right click and select new content
		this.rightClickHome();
	}

	// Press right click and select new content
	public void rightClickHome2() {
		// this.driverManager.driverWait(1500);
		WebElement home2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath", homeContent2);
		// driverManager.getDriver().findElement(By.xpath(homeContent2));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), home2);

		// this.driverManager.driverWait(1500);
		WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				addNewContent2);
		// driverManager.getDriver().findElement(By.xpath(addNewContent2));
		addContent.click();
	}

	public void rightClickToSeeMenu2() {
		// Press right click and select new content
		this.rightClickHome2();
	}

	// Press right click and select new content
	public void rightClickHome3() {
		// this.driverManager.driverWait(1500);
		WebElement home3 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "cssSelector",
				homeContent3);
		// driverManager.getDriver().findElement(By.cssSelector(homeContent3));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), home3);

		// this.driverManager.driverWait(1500);
		WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				addNewContent);
		// driverManager.getDriver().findElement(By.xpath(addNewContent));
		addContent.click();
	}

	public void rightClickToSeeMenu3() {
		// Press right click and select new content
		this.rightClickHome3();
	}

	// Press right click select new folder
	public void rightClickNewFolderOnHome() {
		// this.driverManager.driverWait(1500);
		WebElement newFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath", homeContent);
		// driverManager.getDriver().findElement(By.xpath(homeContent));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), newFolder);

		// this.getDriverManager().driverWait(1500);
		WebElement addFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", addNewFolder);
		// driverManager.getDriver().findElement(By.xpath(addNewFolder));
		addFolder.click();
	}

	// Press right click select new folder
	public void rightClickNewFolderOnAPresentFolder(WebElement parentWebElement) {
		this.driverManager.driverWait(1500);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		// this.driverManager.driverWait(1500);
		WebElement addFolderOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				addNewFolderOption);
		// driverManager.getDriver().findElement(By.xpath(addNewFolderOption));
		addFolderOption.click();
	}

	// Press right click to see the menu
	public void rightClickCreatePageOnAPresentFolder(WebElement parentWebElement) {
		this.driverManager.driverWait(1500);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		// this.driverManager.driverWait(1500);
		WebElement addContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				addNewContentOption);
		// driverManager.getDriver().findElement(By.xpath(addNewContentOption));
		addContent.click();
	}

	public void rightClickToFolderOnHome() {
		// Press right click select new folder
		this.rightClickNewFolderOnHome();
	}

	// Select Entry Content type
	public void selectEntryCT() {
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// this.driverManager.driverWait(2000);
		// WebElement entryCT =
		// driverManager.getDriver().findElement(By.cssSelector(selectEntryCT));
		Assert.assertTrue(driverManager.isElementPresentBycssSelector(selectEntryCT));
		// entryCT.click();
	}

	public void selectPageArticleContentType() {
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// this.driverManager.driverWait(2000);
		// WebElement pageArticleContentType = driverManager.getDriver()
		// .findElement(By.cssSelector(pageArticleContentTypeLocator));
		Assert.assertTrue(driverManager.isElementPresentBycssSelector(pageArticleContentTypeLocator));
		// pageArticleContentType.click();
	}

	public void clickEntryCT() {
		// Select Generic Content type
		this.selectEntryCT();
	}

	// Select Level Descriptor Content type
	public void selectLDCT() {
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// this.driverManager.driverWait(2000);
		WebElement levelDescriptorCT = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				levelDescriptorContentType);
		// driverManager.getDriver().findElement(By.cssSelector(levelDescriptorContentType));
		levelDescriptorCT.click();
	}

	public void clickLevelDescriptorCT() {
		// Select Level Descriptor Content type
		this.selectLDCT();
	}

	// Confirm the CT selected
	public void confirmCTSelected() {
		WebElement okButton = driverManager.getDriver().findElement(By.id(okButton1));
		okButton.click();
	}

	public void clickOKButton() {
		// Confirm the CT selected
		this.confirmCTSelected();
	}

	// Set page URL
	public void setPageURL1(String strPageURL) {
		// this.driverManager.driverWait(2000);
		WebElement pageUrl = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", setPageURL1);
		// driver.findElement(By.xpath(setPageURL1));
		pageUrl.clear();
		pageUrl.sendKeys(strPageURL);
	}

	// Set internal name
	public void setInternalName1(String strInternalName) {
		// this.driverManager.driverWait(2000);
		WebElement internalName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				setInternalName1);
		// driver.findElement(By.xpath(setInternalName1));
		internalName.clear();
		internalName.sendKeys(strInternalName);
	}

	// Set body text
	public void setBodyText1(String strBodyText) {
		// this.driverManager.driverWait(2000);
		WebElement bodyText1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				setBodyText1);
		// driver.findElement(By.cssSelector(setBodyText1));
		bodyText1.sendKeys(strBodyText);
	}

	// Click on save and close button
	public void clickSaveClose() {
		// this.driverManager.driverWait(1500);
		WebElement saveCloseButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				saveCloseButton1);
		// driver.findElement(By.id(saveCloseButton1));
		saveCloseButton.click();
	}

	// Click on save and close button
	public void clickSaveDraft() {
		// this.driverManager.driverWait(1500);
		WebElement saveDraftButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				saveDraft1);
		// driver.findElement(By.id(saveDraft1));
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
		// this.driverManager.driverWait(1500);
		WebElement saveDraftButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				saveDraft1);
		// driver.findElement(By.id(saveDraft1));
		saveDraftButton.click();
	}

	// Set the LEVAL DESCRIPTOR NAME
	public void setLevelDescriptorName(String strFileName) {
		// Fill page URL
		this.setPageURL1(strFileName);
		// Click on save and draft button
		this.clickSaveAndDraft();

	}

	// Set the name of the folder
	public void folderName(String strFolderName) {
		// driverManager.driverWait(1500);
		WebElement folderName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id", setFolderName1);
		// driverManager.getDriver().findElement(By.id(setFolderName1));
		folderName.clear();
		folderName.sendKeys(strFolderName);
	}

	public void setFolderName(String strFolderName) {
		// Set the name of the folder
		this.folderName(strFolderName);
	}

	// create button
	public void createButton() {
		// this.driverManager.driverWait(1500);
		WebElement buttonCreate = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				createButton1);
		// driverManager.getDriver().findElement(By.id(createButton1));
		buttonCreate.click();
	}

	public void clickCreateButton() {
		// create button
		this.createButton();
	}

	// Set the name of the file
	public void fileName(String strFileName) {
		// this.driverManager.driverWait(1500);
		WebElement fileName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				setFileName);
		// driverManager.getDriver().findElement(By.cssSelector(setFileName));
		fileName.clear();
		fileName.sendKeys(strFileName);
	}

	public void setFileName(String strFileName) {
		// Set the name of the file
		this.fileName(strFileName);
	}

	// Press right click and press copy option (about us page)
	public void rightClickCopyOptionAboutUs() {
		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				aboutUSContentPage);
		// driverManager.getDriver().findElement(By.xpath(aboutUSContentPage));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent);

		// this.getDriverManager().driverWait(1500);
		WebElement copyContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				copyContent3);
		// driverManager.getDriver().findElement(By.cssSelector(copyContent3));
		copyContent.click();
	}

	public void rightClickToCopyOptionAboutUs() {
		// Press right click and press copy option
		this.rightClickCopyOptionAboutUs();
	}

	// Press right click and press copy option (service page)
	public void rightClickCopyOptionService() {
		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				newContentCreated);
		// driverManager.getDriver().findElement(By.id(newContentCreated));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent);

		// this.driverManager.driverWait(1500);
		WebElement copyContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				copyContent1);
		// driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyContent.click();
	}

	public void rightClickToCopyOptionService() {
		// Press right click and press copy option
		this.rightClickCopyOptionService();
	}

	// Press right click and press paste option
	public void rightClickPasteOption() {
		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				homeContent3);
		// driverManager.getDriver().findElement(By.cssSelector(homeContent3));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent);

		// this.getDriverManager().driverWait(1500);
		WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				pasteContent0);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent0));
		pasteContent.click();
	}

	public void rightClickToPasteOption() {
		// Press right click and press paste option
		this.rightClickPasteOption();
	}

	// Press right click and press paste option
	public void rightClickPasteOptionTwo() {
		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				newFolderCreated);
		// driverManager.getDriver().findElement(By.cssSelector(newFolderCreated));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent);

		// this.driverManager.driverWait(1500);
		WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				pasteContent2);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent2));
		pasteContent.click();
	}

	public void rightClickToPasteOption2() {
		// Press right click and press paste option
		this.rightClickPasteOptionTwo();
	}

	// edit content copied
	public void rightClickDeleteOption() {
		WebElement delete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				aboutUsOptionCopied);
		// driverManager.getDriver().findElement(By.cssSelector(aboutUsOptionCopied));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), delete);

		// this.driverManager.driverWait(1500);
		WebElement deletePanelOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				deleteOptionCopied);
		// driverManager.getDriver().findElement(By.cssSelector(deleteOptionCopied));
		deletePanelOption.click();
	}

	public void rightClickToDeleteOption() {
		// edit content copied
		this.rightClickDeleteOption();
	}

	// edit internal name
	public void editInternalName(String strInternalName) {
		// Fill internal name
		this.setInternalName1(strInternalName);
		// Click on save and draft button
		this.clickSaveDraft();
	}

	// Press right click and Unlock
	public void rightClickUnlockOption() {
		// this.driverManager.driverWait(1500);
		WebElement unlockContentOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				aboutUsOptionCopied);
		// driverManager.getDriver().findElement(By.xpath(aboutUsOptionCopied));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), unlockContentOption);

		// this.driverManager.driverWait(1500);
		WebElement unlockContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				unlockOptionCopied);
		// driverManager.getDriver().findElement(By.cssSelector(unlockOptionCopied));
		unlockContent.click();
	}

	public void rightClickToUnlockOption() {
		// Press right click and Unlock
		this.rightClickUnlockOption();
	}

	// Delete option
	public void deleteContentCopied() {
		// this.driverManager.driverWait(1500);
		WebElement deleteOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				deleteOptionCopiedPopup);
		// driverManager.getDriver().findElement(By.id(deleteOptionCopiedPopup));
		deleteOption.click();
	}

	public void clickDelete() {
		// Delete option
		this.deleteContentCopied();
	}

	// Ok delete option
	public void deleteContentCopiedOK() {
		// this.driverManager.driverWait(1500);
		WebElement confirmDelete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				deleteOK);
		// driverManager.getDriver().findElement(By.cssSelector(deleteOK));
		confirmDelete.click();
	}

	public void clickToDelete() {
		// Ok delete option
		this.deleteContentCopiedOK();
	}

	// Press right click and press cut option
	public void rightClickCutOption() {
		WebElement cutpasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				contentCreatedToCut);
		// driverManager.getDriver().findElement(By.cssSelector(contentCreatedToCut));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), cutpasteContent);

		// this.driverManager.driverWait(1500);
		WebElement cutContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				cutContent1);
		// driverManager.getDriver().findElement(By.cssSelector(cutContent1));
		cutContent.click();
	}

	public void rightClickToCutOption() {
		// Press right click and press cut option
		this.rightClickCutOption();
	}

	// Press right click and press cut option
	public void rightClickCutOptionAgain() {
		WebElement cutpasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionCut);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionCut));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), cutpasteContent);

		// this.driverManager.driverWait(1500);
		WebElement cutContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				cutContent1);
		// driverManager.getDriver().findElement(By.cssSelector(cutContent1));
		cutContent.click();
	}

	public void rightClickToCutOptionAgain() {
		// Press right click and press cut option
		this.rightClickCutOptionAgain();
	}

	// Press right click and press paste option
	public void rightClickPasteOptionCut() {
		WebElement pasteCutContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				homeContent);
		// driverManager.getDriver().findElement(By.id(homeContent));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteCutContent);

		// this.driverManager.driverWait(1500);
		WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				pasteContent1);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent1));
		pasteContent.click();
	}

	public void rightClickToPasteOptionCut() {
		// Press right click and press paste option
		this.rightClickPasteOptionCut();
	}

	// Press right click and copy the component to new folder created.
	public void rightClickCopyComponent() {
		WebElement copyComponent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				crafterComponent);
		// driverManager.getDriver().findElement(By.xpath(crafterComponent));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copyComponent);

		// this.driverManager.driverWait(1500);
		WebElement copyComponentToNewFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", copyContent1);
		// driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyComponentToNewFolder.click();
	}

	public void rightClickToCopyComponentToNewFolder() {
		// Press right click and copy the component to new folder created.
		this.rightClickCopyComponent();
	}

	// Press right click and copy the new content to the new folder
	public void rightClickCopyNewContent() {
		WebElement copyNewContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				newContentCreated);
		// driverManager.getDriver().findElement(By.cssSelector(newContentCreated));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copyNewContent);

		// this.getDriverManager().driverWait(1500);
		WebElement copyNewContentToNewFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", copyContent3);
		// driverManager.getDriver().findElement(By.cssSelector(copyContent3));
		copyNewContentToNewFolder.click();
	}

	public void rightClickToCopyNewContentToNewFolder() {
		// Press right click and copy the new content to the new folder
		this.rightClickCopyNewContent();
	}

	// Press right click and press paste option to the new folder
	public void rightClickPaste() {
		WebElement pasteAllContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				folderCreated);
		// driverManager.getDriver().findElement(By.cssSelector(folderCreated));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteAllContent);

		// this.getDriverManager().driverWait(1500);
		WebElement pasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				pasteContent2);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent2));
		pasteContent.click();
	}

	public void rightClickToPasteToNewFolder() {
		// Press right click and press paste option to the new folder
		this.rightClickPaste();
	}

	// copy button
	public void copyButton() {
		// this.driverManager.driverWait(1500);
		WebElement buttonCopy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				copyContentButton);
		// driverManager.getDriver().findElement(By.id(copyContentButton));
		buttonCopy.click();
	}

	public void clickCopyButton() {
		// copy button
		this.copyButton();
	}

	public void clickCopyButtonOnTreeSelector() {
		// this.driverManager.driverWait(1500);
		WebElement buttonCopy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				copyButonOnTreeSelector);
		// driverManager.getDriver().findElement(By.xpath(copyButonOnTreeSelector));
		buttonCopy.click();
	}

	// Press right click and press paste option
	public void rightClickPasteOption1() {
		WebElement pasteAboutContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				newContentCreated);
		// driverManager.getDriver().findElement(By.id(newContentCreated));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteAboutContent);

		// this.driverManager.driverWait(1500);
		WebElement pasteAboutUS = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				pasteContent1);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent1));
		pasteAboutUS.click();
	}

	public void rightClickToPasteOptionAboutUsToAboutUs() {
		// Press right click and press paste option
		this.rightClickPasteOption1();
	}

	// Press right click and press copy option to the tree
	public void rightClickCopyOptionTree() {
		WebElement copypasteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionToTree1);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionToTree1));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), copypasteContent);

		// this.driverManager.driverWait(1500);
		WebElement copyContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				copyContent1);
		// driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyContent.click();
	}

	public void rightClickToCopyOptionAboutUsToTree() {
		// Press right click and press copy option to the tree
		this.rightClickCopyOptionTree();
	}

	// Press right click and press paste option to the "aboutoptionCOPY" to
	// start to create a tree
	public void rightClickPasteTreeLevel1() {
		WebElement pasteContentTree1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionTreeLevel1);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel1));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteContentTree1);

		// this.driverManager.driverWait(1500);
		WebElement pasteContentToTheTree1 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", pasteContent3);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
		pasteContentToTheTree1.click();
	}

	public void rightClickToPasteToTheTree1() {
		// Press right click and press paste option to the "aboutoptionCOPY" to
		// start to create a tree
		this.rightClickPasteTreeLevel1();
	}

	// Press right click and press paste option to the "aboutoptionCOPY" to
	// start to create a tree
	public void rightClickPasteTreeLevel2() {
		WebElement pasteContentTree2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionTreeLevel2);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel2));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteContentTree2);

		// this.driverManager.driverWait(1500);
		WebElement pasteContentToTheTree2 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", pasteContent3);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
		pasteContentToTheTree2.click();
	}

	public void rightClickToPasteToTheTree2() {
		// Press right click and press paste option to the "aboutoptionCOPY" to
		// start to create a tree
		this.rightClickPasteTreeLevel2();
	}

	// Press right click and press paste option to the "aboutoptionCOPY" to
	// start to create a tree
	public void rightClickPasteTreeLevel3() {
		WebElement pasteContentTree3 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionTreeLevel2);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel2));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteContentTree3);

		// this.driverManager.driverWait(1500);
		WebElement pasteContentToTheTree3 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", pasteContent3);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
		pasteContentToTheTree3.click();
	}

	public void rightClickToPasteToTheTree3() {
		// Press right click and press paste option to the "aboutoptionCOPY" to
		// start to create a tree
		this.rightClickPasteTreeLevel3();
	}

	// Press right click and press paste option to the "aboutoptionCOPY" to
	// start to create a tree

	public void rightClickPasteTreeLevel4() {
		WebElement pasteContentTree4 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionTreeLevel1);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel1));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), pasteContentTree4);

		// this.driverManager.driverWait(1500);
		WebElement pasteContentToTheTree4 = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2,
				"cssSelector", pasteContent3);
		// driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
		pasteContentToTheTree4.click();
	}

	public void rightClickToPasteToTheTree4() {
		// Press right click and press paste option to the "aboutoptionCOPY" to
		// start to create a tree
		this.rightClickPasteTreeLevel4();
	}

	// Press right click and press delete option to the "aboutoptionCOPY"
	public void rightClickDeleteTreeLevel1() {
		WebElement deleteContentTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				aboutUsOptionTreeCreated);
		// driverManager.getDriver().findElement(By.id(aboutUsOptionTreeCreated));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), deleteContentTree);

		this.driverManager.driverWait(1500);
		WebElement deleteTheTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				deleteAboutUsTreeCreated);
		// driverManager.getDriver().findElement(By.cssSelector(deleteAboutUsTreeCreated));
		deleteTheTree.click();
	}

	public void rightClickToDeleteTheTree() {
		// Press right click and press delete option to the "aboutoptionCOPY"
		this.rightClickDeleteTreeLevel1();
	}

	// click on Site Content
	public void clickSiteContent() {
		// this.getDriverManager().driverWait(2000);
		WebElement siteContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				clickOnSiteContent);
		// driverManager.getDriver().findElement(By.xpath(clickOnSiteContent));
		siteContent.click();
	}

	public void clickOnSiteContentOption() {
		// click on Site Content
		this.clickSiteContent();
	}

	// Press right click and select new content
	public void deleteContent() {
		// this.getDriverManager().driverWait(2000);
		WebElement showMenu = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				cutCrafterComponent);
		// driverManager.getDriver().findElement(By.cssSelector(cutCrafterComponent));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), showMenu);

		// this.driverManager.driverWait(1500);
		WebElement delContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				deleteCrafterComponent2);
		// driverManager.getDriver().findElement(By.cssSelector(deleteCrafterComponent2));
		delContent.click();
	}

	public void rightClickToDeleteContent() {
		// Press right click and select new content
		this.deleteContent();
	}

	// Ok delete content option
	public void deleteContentOK() {
		// this.getDriverManager().driverWait(2000);
		WebElement confirmDelete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id",
				deleteContentOK);
		// driverManager.getDriver().findElement(By.id(deleteContentOK));
		confirmDelete.click();
	}

	public void clicktoDeleteContent() {
		// Ok delete content option
		this.deleteContentOK();
	}

	// Ok submittal complete
	public void submittalCompleteOK() {
		// this.getDriverManager().driverWait(2000);
		WebElement submittalComplete = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				submittalCompleteOK);
		// driverManager.getDriver().findElement(By.cssSelector(submittalCompleteOK));
		submittalComplete.click();
	}

	public void clickOKSubmittalComplete() {
		// Ok submittal complete
		this.submittalCompleteOK();
	}

	// Press right click and select edit
	public void editMenu() {
		// this.getDriverManager().driverWait(2000);
		WebElement showMenu = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "id", homeContent);
		// driverManager.getDriver().findElement(By.id(homeContent));
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), showMenu);

		// this.driverManager.driverWait(1500);
		WebElement goToEditIframe = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				editOption);
		// driverManager.getDriver().findElement(By.cssSelector(editOption));
		goToEditIframe.click();
	}

	public void goToEditIframe() {
		// Press right click and select edit
		this.editMenu();
	}

	// click on edit page button
	public void editURLbutton() {
		// this.driverManager.driverWait(2000);
		WebElement editURLButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				ediPagetUrl);
		// driverManager.getDriver().findElement(By.cssSelector(ediPagetUrl));
		editURLButton.click();
	}

	public void clickOnEditPageURLButton() {
		// click on edit page button
		this.editURLbutton();
	}

	// Set the new name of the URL
	public void uRLPageName(String strNewURL) {
		// this.driverManager.driverWait(2000);
		WebElement URLName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				pageUrlField);
		// driverManager.getDriver().findElement(By.cssSelector(pageUrlField));
		URLName.clear();
		URLName.sendKeys(strNewURL);
	}

	public void setNewPageURL(String strNewURL) {
		// Set the new name of the URL
		this.uRLPageName(strNewURL);
	}

	// click on preview sync option
	public void previewSyncOption() {
		// this.driverManager.driverWait(2000);
		WebElement previewSyncOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				previewSync);
		// driverManager.getDriver().findElement(By.cssSelector(previewSync));
		previewSyncOpt.click();
	}

	public void clickOnPreviewSyncOption() {
		// click on preview sync option
		this.previewSyncOption();
	}

	// Press right click and select edit to the content created

	public void rightClickToEdit() {
		WebElement editContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				crafterComponent);
		// driverManager.getDriver().findElement(By.xpath(crafterComponent)); //
		// contentRecentlyCreated
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), editContent);

		// this.getDriverManager().driverWait(1500);
		WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				editRecentlyContentCreated);
		// driverManager.getDriver().findElement(By.cssSelector(editRecentlyContentCreated));
		editOption.click();
	}

	public void rightClickToSelectEditOption() {
		// Press right click and select edit to the content created
		this.rightClickToEdit();
	}

	// Set metadata fields
	public void setTitle(String strTitle) {
		// this.driverManager.driverWait(1500);
		WebElement title = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				titleMedatata);
		// driverManager.getDriver().findElement(By.cssSelector(titleMedatata));
		title.clear();
		title.sendKeys(strTitle);
	}

	// Click on duplicate button of the menu
	public void duplicateButton() {
		// this.driverManager.driverWait(1500);
		WebElement duplicateOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				previewDuplicate);
		// driverManager.getDriver().findElement(By.xpath(previewDuplicate));
		duplicateOption.click();
	}

	public void clickOnDuplicateOption() {
		// Click on duplicate button of the menu
		this.duplicateButton();
	}

	// Set the new name duplicated
	public void duplicateName(String strDuplicateName) {
		// this.driverManager.driverWait(1500);
		WebElement duplicateName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath",
				this.duplicateName);
		// driverManager.getDriver().findElement(By.xpath(this.duplicateName));
		duplicateName.clear();
		duplicateName.sendKeys(strDuplicateName);

	}

	public void setDuplicateName(String strDuplicateName) {
		// Set the new name duplicated
		this.duplicateName(strDuplicateName);
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
		// this.driverManager.driverWait(1500);
		WebElement usersContextualNavigationOptionWebElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", usersContextualNavigationOption);
		// driver.findElement(By.xpath(usersContextualNavigationOption));
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

	public void setArticlesTitle(String strArticlesTitle) {
		//this.driverManager.driverWait(1000);
		WebElement articlesTitle =  this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", articlesTitleLocator);
				//driver.findElement(By.xpath(articlesTitleLocator));
		articlesTitle.clear();
		articlesTitle.sendKeys(strArticlesTitle);
	}

	public void selectFirstCategoryOfPagArticle() {
		//this.driverManager.driverWait(1000);
		Select categoriesDropDown = new Select(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", categoriesLocator));
				//driver.findElement(By.xpath(categoriesLocator)));
		categoriesDropDown.selectByValue("style");
	}

	public void selectAllTreeOnSelector(String folderXPath) {
		//this.driverManager.driverWait(2000);
		WebElement checkAllTree = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", folderXPath);
				//driver.findElement(By.xpath(folderXPath));
		if (!checkAllTree.getAttribute("checked").equals("true"))
			checkAllTree.click();
	}

	public void clicOnHomeTree() {
		//this.driverManager.driverWait(2000);
		WebElement homeTree = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", homeTreeLocator);
				//driverManager.getDriver().findElement(By.xpath(homeTreeLocator));
		homeTree.click();
	}

	public void clickOnContextualNavigationEditOption() {
		//this.driverManager.driverWait(200);
		WebElement contextualNavigationEdit =this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", contextualNavigationEditLocator);
				//driverManager.getDriver()
				//.findElement(By.xpath(contextualNavigationEditLocator));
		contextualNavigationEdit.click();
	}

	public void clickOnContextualNavigationHistoryOption() {
		//this.driverManager.driverWait(2000);
		WebElement contextualNavigationHistory = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", contextualNavigationHistoryLocator);
				//driverManager.getDriver()
				//.findElement(By.xpath(contextualNavigationHistoryLocator));
		contextualNavigationHistory.click();
	}

	public void clickCompareButton() {
		//this.driverManager.driverWait(1500);
		WebElement compareButton =  this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "id", compareButtonLocator);
				//driver.findElement(By.id(compareButtonLocator));
		compareButton.click();
	}

	public void clickCloseButton() {
		//this.driverManager.driverWait(1500);
		WebElement closeButton =  this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "id", closeButtonLocator);
				//driver.findElement(By.id(closeButtonLocator));
		closeButton.click();
	}

	public void clickHistoryCloseButton() {
		//this.driverManager.driverWait(2000);
		WebElement historyCloseButton = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "id", historyCloseButtonLocator);
				//driver.findElement(By.id(historyCloseButtonLocator));
		historyCloseButton.click();
	}

	public void clickOnPublishOption() {
		this.driverManager.driverWait(2000);
		WebElement publishOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector",
				publishOptionLocator);
				//driverManager.getDriver().findElement(By.cssSelector(publishOptionLocator));
		publishOption.click();
	}

	public void rightClickOnAContentPage(WebElement element) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), element);
		this.driverManager.driverWait(1500);
	}

	public void clickApproveAndPublishSubmitButton() {
		//this.driverManager.driverWait(2000);
		WebElement submitButton = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "id", approveAndPublishPublishButtonLocator);
				//driver.findElement(By.id(approveAndPublishPublishButtonLocator));
		submitButton.click();
	}

	public void clickDeleteDeleteSubmitButton() {
		//this.driverManager.driverWait(2000);
		WebElement deleteButton = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "id", deleteDeletButtonLocator);
				//driver.findElement(By.id(deleteDeletButtonLocator));
		deleteButton.click();
		this.acceptDeletionAction();
	}

	public void acceptDeletionAction() {
		driverManager.driverWait(2000);
		// Switch to the iframe
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		//driverManager.driverWait(1000);
		// Click on Publish button
		WebElement okButton = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(1, "xpath", deleteOKButtonLocator);
				//driver.findElement(By.xpath(deleteOKButtonLocator));
		okButton.click();
	}

	public void rightClickCopyFolder(WebElement parentWebElement) {
		this.driverManager.driverWait(1000);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		//this.driverManager.driverWait(1500);
		WebElement copyOption = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", copyOptionLocator);
				//driverManager.getDriver().findElement(By.cssSelector(copyOptionLocator));
		copyOption.click();
	}

	public void rightClickPasteOnAFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		//this.driverManager.driverWait(1500);
		WebElement pasteOption = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", pasteOptionLocator);
				//driverManager.getDriver().findElement(By.cssSelector(pasteOptionLocator));
		pasteOption.click();
	}

	public void rightClickCutAFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		//this.driverManager.driverWait(1500);
		WebElement cutOption =this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", cutOptionLocator);
				//driverManager.getDriver().findElement(By.cssSelector(cutOptionLocator));
		cutOption.click();
	}

	public void rightClickDeleteAFolder(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		//this.driverManager.driverWait(1500);
		WebElement deleteOption = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", deleteOptionLocator);
				//driverManager.getDriver().findElement(By.cssSelector(deleteOptionLocator));
		deleteOption.click();
	}

	public void rightClickDeleteAPage(WebElement parentWebElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		//this.driverManager.driverWait(1500);
		WebElement deleteOption =  this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", deleteOption2Locator);
				//driverManager.getDriver().findElement(By.xpath(deleteOption2Locator));
		deleteOption.click();
	}

	public void expandParentFolder(WebElement parentElement) {
		this.driverManager.driverWait(1500);
		parentElement.click();
	}

	public void switchToAFormByCssSelector(String cSSSelector) {
		//this.getDriverManager().driverWait(1000);
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", cSSSelector));
				//driverManager.getDriver().findElement(By.cssSelector(cSSSelector)));
	}

	public void rightClickCopyContentPage(WebElement parentWebElement) {
		this.driverManager.driverWait(1500);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), parentWebElement);

		//this.driverManager.driverWait(1500);
		WebElement copyOption = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", copyOptionLocatorForContentPage);
				//driverManager.getDriver().findElement(By.xpath(copyOptionLocatorForContentPage));
		copyOption.click();
	}

	public void rightClickCreatePageOnAPresentPage(WebElement webElement) {
		this.driverManager.driverWait(1500);
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), webElement);

		//this.driverManager.driverWait(1500);
		WebElement addContent =  this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", addNewContentOption3);
				//driverManager.getDriver().findElement(By.xpath(addNewContentOption3));
		addContent.click();
	}

	public void rightClickEditOnAPresentPage(WebElement webElement) {
		this.getDriverManager().contextClick(this.getDriverManager().getDriver(), webElement);

		//this.driverManager.driverWait(1500);
		WebElement editContent = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(2, "cssSelector", editOption);
				//driverManager.getDriver().findElement(By.cssSelector(editOption));
		editContent.click();
	}
}