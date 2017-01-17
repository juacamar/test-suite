package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class DashboardPage {

	private WebDriverManager driverManager;
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;
	private String pagesTree;
	private String globalEntryContentTree;
	private String homeContentTree;
	private String homeContent;
	private String addNewContent;
	private String selectGenericCT;
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
	private String globalEntry;
	private String pasteContent1;
	private String aboutUsOption;
	private String aboutUsOptionCopied;
	private String deleteOptionCopied;
	private String unlockOptionCopied;
	private String deleteOptionCopiedPopup;
	private String deleteOK;
	private String cutContent1;
	private String aboutUsOptionCut;
	private String folderToCopy;
	private String copyContentButton;
	private String pasteContent2;
	private String servicesOption;
	private String aboutUSFolderToCopy;
	private String pasteContent3;
	private String aboutUsOptionToTree1;
	private String copyContent2;
	private String aboutUsOptionTreeLevel1;
	private String pasteContent4;
	private String aboutUsOptionTreeLevel2;
	private String aboutUsOptionTreeLevel3;
	private String aboutUsOptionTreeCreated;
	private String deleteAboutUsTreeCreated;
	private String clickOnSiteContent;
	private String deleteContentOK;
	private String submittalCompleteOK;
	private String editOption;
	private String ediPagetUrl;
	private String pageUrlField;
	private String previewSync;
	private String contentRecentlyCreated;
	private String editRecentlyContentCreated;

	/**
	 * 
	 */
	public DashboardPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.driver = this.driverManager.getDriver();
		pagesTree = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.expand_Pages_Tree");
		globalEntryContentTree = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.expand_GlobalEntry_Tree");
		homeContentTree = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.expand_Home_Tree");
		homeContent = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.home_Content_Page");
		addNewContent = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.add_New_Content");
		addNewFolder = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.add_New_Folder");
		selectGenericCT = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.generic_Content_Type");
		okButton1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.ok_Button");
		setPageURL1 = uIElementsManager.getSharedUIElementsLocators().getProperty("frame2.page_URL");
		setInternalName1 = uIElementsManager.getSharedUIElementsLocators().getProperty("frame2.internal_Name");
		setBodyText1 = uIElementsManager.getSharedUIElementsLocators().getProperty("frame2.bodyOne");
		saveCloseButton1 = uIElementsManager.getSharedUIElementsLocators().getProperty("frame2.save_Close_Button");
		saveDraft1 = uIElementsManager.getSharedUIElementsLocators().getProperty("frame2.save_Draft");
		createButton1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.create_Button");
		setFolderName1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.folder_name");
		copyContent1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.copy_content1");
		copyContent2 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.copy_content2");
		globalEntry = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.global_entry");
		pasteContent1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.paste_content1");
		pasteContent2 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.paste_content2");
		pasteContent3 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.paste_content3");
		pasteContent4 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.paste_content4");
		aboutUsOption = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.about_us");
		aboutUsOptionCopied = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.about_us_copied");
		deleteOptionCopied = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_about_us_copied");
		unlockOptionCopied = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.unlock_about_us_copied");
		deleteOptionCopiedPopup = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_about_us_panel");
		deleteOK = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.delete_OK");
		cutContent1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.cut_content1");
		aboutUsOptionCut = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.about_us_cut");
		folderToCopy = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.new_folder_created");
		copyContentButton = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.copy_content");
		servicesOption = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.services");
		aboutUSFolderToCopy = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_folderToCopy");
		aboutUsOptionToTree1 = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.about_us_tree1");
		aboutUsOptionTreeLevel1 = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_to_the_tree_leve1");
		aboutUsOptionTreeLevel2 = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_to_the_tree_leve2");
		aboutUsOptionTreeLevel3 = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_to_the_tree_leve3");
		aboutUsOptionTreeCreated = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.about_us_tree");
		deleteAboutUsTreeCreated = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.delete_about_us_tree");
		clickOnSiteContent = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.site_content");
		deleteContentOK = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.delete_content_OK");
		submittalCompleteOK = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("dashboard.submittal_complete");
		editOption = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.edit_iframe");
		ediPagetUrl = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.edit_url_button");
		pageUrlField = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.page_url_field");
		previewSync = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.preview_sync");
		contentRecentlyCreated = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.recently_content_created");
		editRecentlyContentCreated = uIElementsManager.getSharedUIElementsLocators().getProperty("dashboard.edit_recently_content_created");
		
		

	}

	public DashboardPage(WebDriver driver) {

		this.driver = driver;

	}

	// Expand pages tree

	public void clickPagesTree() {

		WebElement expandPagesTree = driverManager.getDriver().findElement(By.cssSelector(pagesTree));
		expandPagesTree.click();

	}

	public void expandPagesTree() {

		// Expand pages tree

		this.clickPagesTree();

	}

	// Expand global entry content

	public void clickGlobalEntryContent() {

		WebElement globalEntry = driverManager.getDriver().findElement(By.cssSelector(globalEntryContentTree));
		globalEntry.click();

	}

	public void clickGlobalEntryTree() {

		// Expand global entry content

		this.clickGlobalEntryContent();

	}

	// Expand home content

	public void clickHomeContent() {

		WebElement home = driverManager.getDriver().findElement(By.cssSelector(homeContentTree));
		home.click();

	}

	public void clickHomeTree() {

		// Expand home content

		this.clickHomeContent();

	}

	// Press right click and select new content

	public void rightClickHome() {

		WebElement newContent = driverManager.getDriver().findElement(By.id(homeContent));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(newContent).build().perform();

		WebElement addContent = driverManager.getDriver().findElement(By.cssSelector(addNewContent));
		addContent.click();

	}

	public void rightClickToSeeMenu() {

		// Press right click and select new content

		this.rightClickHome();

	}

	// Press right click select new folder

	public void rightClickNewFolder() {

		WebElement newFolder = driverManager.getDriver().findElement(By.id(homeContent));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(newFolder).build().perform();

		WebElement addFolder = driverManager.getDriver().findElement(By.cssSelector(addNewFolder));
		addFolder.click();

	}

	public void rightClickToNewContent() {

		// Press right click select new folder

		this.rightClickNewFolder();

	}

	// Select Generic Content type

	public void selectGenericCT() {

		WebElement genericCT = driverManager.getDriver().findElement(By.xpath(selectGenericCT));
		genericCT.click();

	}

	public void clickGenericCT() {

		// Select Generic Content type

		this.selectGenericCT();

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

		WebElement pageUrl = driver.findElement(By.cssSelector(setPageURL1));
		pageUrl.sendKeys(strPageURL);

	}

	// Set internal name

	public void setInternalName1(String strInternalName) {

		WebElement internalName = driver.findElement(By.xpath(setInternalName1));
		internalName.sendKeys(strInternalName);

	}

	// Set body text

	public void setBodyText1(String strBodyText) {

		WebElement bodyText1 = driver.findElement(By.cssSelector(setBodyText1));
		bodyText1.sendKeys(strBodyText);

	}

	// Click on save and close button

	public void clickSaveClose() {

		WebElement saveCloseButton = driver.findElement(By.id(saveCloseButton1));
		saveCloseButton.click();

	}

	// Click on save and close button

	public void clickSaveDraft() {

		WebElement saveDraftButton = driver.findElement(By.id(saveDraft1));
		saveDraftButton.click();

	}

	// Setting basic fields of the nre content
	public void setBasicFieldsOfNewContent(String strPageURL, String strInternalName) {

		// Fill page URL

		this.setPageURL1(strPageURL);

		// Fill internal name

		this.setInternalName1(strInternalName);

		// Click on save and draft button

		this.clickSaveDraft();

	}

	// Set the name of the folder

	public void folderName(String strFolderName) {

		WebElement folderName = driverManager.getDriver().findElement(By.id(setFolderName1));
		folderName.sendKeys(strFolderName);

	}

	public void setFolderName(String strFolderName) {

		// Set the name of the folder

		this.folderName(strFolderName);

	}

	// create button

	public void createButton() {

		WebElement buttonCreate = driverManager.getDriver().findElement(By.id(createButton1));
		buttonCreate.click();

	}

	public void clickCreateButton() {

		// create button

		this.createButton();

	}

	// Press right click and press copy option (about us page)

	public void rightClickCopyOptionAboutUs() {

		WebElement copypasteContent = driverManager.getDriver().findElement(By.id(aboutUsOption));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(copypasteContent).build().perform();

		WebElement copyContent = driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyContent.click();

	}

	public void rightClickToCopyOptionAboutUs() {

		// Press right click and press copy option

		this.rightClickCopyOptionAboutUs();

	}
	
	// Press right click and press copy option (service page)

		public void rightClickCopyOptionService() {

			WebElement copypasteContent = driverManager.getDriver().findElement(By.id(servicesOption));

			Actions action = new Actions(driverManager.getDriver());
			action.contextClick(copypasteContent).build().perform();

			WebElement copyContent = driverManager.getDriver().findElement(By.cssSelector(copyContent1));
			copyContent.click();

		}

		public void rightClickToCopyOptionService() {

			// Press right click and press copy option

			this.rightClickCopyOptionService();

		}

	// Press right click and press paste option

	public void rightClickPasteOption() {

		WebElement copypasteContent = driverManager.getDriver().findElement(By.id(globalEntry));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(copypasteContent).build().perform();

		WebElement pasteContent = driverManager.getDriver().findElement(By.cssSelector(pasteContent1));
		pasteContent.click();

	}

	public void rightClickToPasteOption() {

		// Press right click and press paste option

		this.rightClickPasteOption();

	}

	// Delete content copied

	public void rightClickDeleteOption() {

		WebElement delete = driverManager.getDriver().findElement(By.xpath(aboutUsOptionCopied));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(delete).build().perform();

		WebElement deletePanelOption = driverManager.getDriver().findElement(By.cssSelector(deleteOptionCopied));
		deletePanelOption.click();

	}

	public void rightClickToDeleteOption() {

		// Delete content copied

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

	public void RightClickUnlockOption() {

		WebElement unlockContentOption = driverManager.getDriver().findElement(By.xpath(aboutUsOptionCopied));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(unlockContentOption).build().perform();

		WebElement unlockContent = driverManager.getDriver().findElement(By.cssSelector(unlockOptionCopied));
		unlockContent.click();

	}

	public void RightClickToUnlockOption() {

		// Press right click and Unlock

		this.RightClickUnlockOption();

	}

	// Delete option

	public void deleteContentCopied() {

		WebElement deleteOption = driverManager.getDriver().findElement(By.id(deleteOptionCopiedPopup));
		deleteOption.click();

	}

	public void clickDelete() {

		// Delete option

		this.deleteContentCopied();

	}

	// Ok delete option

	public void deleteContentCopiedOK() {

		WebElement confirmDelete = driverManager.getDriver().findElement(By.cssSelector(deleteOK));
		confirmDelete.click();

	}

	public void clickToDelete() {

		// Ok delete option

		this.deleteContentCopiedOK();

	}

	// Press right click and press cut option

	public void rightClickCutOption() {

		WebElement cutpasteContent = driverManager.getDriver().findElement(By.id(aboutUsOption));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(cutpasteContent).build().perform();

		WebElement cutContent = driverManager.getDriver().findElement(By.cssSelector(cutContent1));
		cutContent.click();

	}

	public void rightClickToCutOption() {

		// Press right click and press cut option

		this.rightClickCutOption();

	}

	// Press right click and press cut option

	public void rightClickCutOptionAgain() {

		WebElement cutpasteContent = driverManager.getDriver().findElement(By.id(aboutUsOptionCut));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(cutpasteContent).build().perform();

		WebElement cutContent = driverManager.getDriver().findElement(By.cssSelector(cutContent1));
		cutContent.click();

	}

	public void rightClickToCutOptionAgain() {

		// Press right click and press cut option

		this.rightClickCutOptionAgain();

	}

	// Press right click and press paste option

	public void rightClickPasteOptionCut() {

		WebElement pasteCutContent = driverManager.getDriver().findElement(By.id(homeContent));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteCutContent).build().perform();

		WebElement pasteContent = driverManager.getDriver().findElement(By.cssSelector(pasteContent1));
		pasteContent.click();

	}

	public void rightClickToPasteOptionCut() {

		// Press right click and press paste option

		this.rightClickPasteOptionCut();

	}

	// Press right click and copy about us

	public void rightClickCopyAboutUs() {

		WebElement copyAbout = driverManager.getDriver().findElement(By.id(aboutUsOption));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(copyAbout).build().perform();

		WebElement copyAboutToNewFolder = driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyAboutToNewFolder.click();

	}

	public void rightClickToCopyAboutUsToNewFolder() {

		// Press right click and copy about us page

		this.rightClickCopyAboutUs();

	}

	// Press right click and copy services page

	public void rightClickCopyServices() {

		WebElement copyServices = driverManager.getDriver().findElement(By.id(servicesOption));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(copyServices).build().perform();

		WebElement copyServicesToNewFolder = driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyServicesToNewFolder.click();

	}

	public void rightClickToCopyServicesToNewFolder() {

		// Press right click and copy services page

		this.rightClickCopyServices();

	}

	// Press right click and press paste option to the new folder

	public void rightClickPaste() {

		WebElement pasteAllContent = driverManager.getDriver().findElement(By.cssSelector(folderToCopy));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteAllContent).build().perform();

		WebElement pasteContent = driverManager.getDriver().findElement(By.cssSelector(pasteContent2));
		pasteContent.click();

	}

	public void rightClickToPasteToNewFolder() {

		// Press right click and press paste option to the new folder

		this.rightClickPaste();

	}

	// copy button

	public void CopyButton() {

		WebElement buttonCopy = driverManager.getDriver().findElement(By.id(copyContentButton));
		buttonCopy.click();

	}

	public void ClickCopyButton() {

		// copy button

		this.CopyButton();

	}

	// Press right click and press paste option

	public void rightClickPasteOption1() {

		WebElement pasteAboutContent = driverManager.getDriver().findElement(By.id(servicesOption)); // aboutUSFolderToCopy

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteAboutContent).build().perform();

		WebElement pasteAboutUS = driverManager.getDriver().findElement(By.cssSelector(pasteContent1));
		pasteAboutUS.click();

	}

	public void rightClickToPasteOptionAboutUsToAboutUs() {

		// Press right click and press paste option

		this.rightClickPasteOption1();

	}

	// Press right click and press copy option to the tree
	public void rightClickCopyOptionTree() {

		WebElement copypasteContent = driverManager.getDriver().findElement(By.id(aboutUsOptionToTree1));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(copypasteContent).build().perform();

		WebElement copyContent = driverManager.getDriver().findElement(By.cssSelector(copyContent1));
		copyContent.click();

	}//// is ready 

	public void rightClickToCopyOptionAboutUsToTree() {

		// Press right click and press copy option to the tree

		this.rightClickCopyOptionTree();

	}

	// Press right click and press paste option to the "aboutoptionCOPY" to
	// start to create a tree

	public void rightClickPasteTreeLevel1() {
		WebElement pasteContentTree1 = driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel1));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteContentTree1).build().perform();

		WebElement pasteContentToTheTree1 = driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
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
		WebElement pasteContentTree2 = driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel2));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteContentTree2).build().perform();

		WebElement pasteContentToTheTree2 = driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
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
		WebElement pasteContentTree3 = driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel2));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteContentTree3).build().perform();

		WebElement pasteContentToTheTree3 = driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
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
		WebElement pasteContentTree4 = driverManager.getDriver().findElement(By.id(aboutUsOptionTreeLevel1));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(pasteContentTree4).build().perform();

		WebElement pasteContentToTheTree4 = driverManager.getDriver().findElement(By.cssSelector(pasteContent3));
		pasteContentToTheTree4.click();

	}

	public void rightClickToPasteToTheTree4() {

		// Press right click and press paste option to the "aboutoptionCOPY" to
		// start to create a tree

		this.rightClickPasteTreeLevel4();

	}

	// Press right click and press delete option to the "aboutoptionCOPY"
	public void RightClickDeleteTreeLevel1() {
		WebElement deleteContentTree = driverManager.getDriver().findElement(By.id(aboutUsOptionTreeCreated));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(deleteContentTree).build().perform();

		WebElement deleteTheTree = driverManager.getDriver().findElement(By.cssSelector(deleteAboutUsTreeCreated));
		deleteTheTree.click();

	}

	public void RightClickToDeleteTheTree() {

		// Press right click and press delete option to the "aboutoptionCOPY"

		this.RightClickDeleteTreeLevel1();

	}

	// click on Site Content

	public void ClickSiteContent() {

		WebElement siteContent = driverManager.getDriver().findElement(By.xpath(clickOnSiteContent));
		siteContent.click();

	}

	public void clickOnSiteContentOption() {

		// click on Site Content

		this.ClickSiteContent();

	}

	// Press right click and select new content

	public void deleteContent() {

		WebElement showMenu = driverManager.getDriver().findElement(By.id(homeContent));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(showMenu).build().perform();

		WebElement delContent = driverManager.getDriver().findElement(By.cssSelector(deleteOptionCopied));
		delContent.click();

	}

	public void rightClickToDeleteContent() {

		// Press right click and select new content

		this.deleteContent();

	}

	// Ok delete content option

	public void deleteContentOK() {

		WebElement confirmDelete = driverManager.getDriver().findElement(By.id(deleteContentOK));
		confirmDelete.click();

	}

	public void clicktoDeleteContent() {

		// Ok delete content option

		this.deleteContentOK();

	}

	// Ok submittal complete

	public void submittalCompleteOK() {

		WebElement submittalComplete = driverManager.getDriver().findElement(By.cssSelector(submittalCompleteOK));
		submittalComplete.click();

	}

	public void clickOKSubmittalComplete() {

		// Ok submittal complete

		this.submittalCompleteOK();

	}

	// Press right click and select edit

	public void editMenu() {

		WebElement showMenu = driverManager.getDriver().findElement(By.id(homeContent));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(showMenu).build().perform();

		WebElement goToEditIframe = driverManager.getDriver().findElement(By.cssSelector(editOption));
		goToEditIframe.click();

	}

	public void goToEditIframe() {

		// Press right click and select edit

		this.editMenu();

	}

	// click on edit page button

	public void editURLbutton() {

		WebElement editURLButton = driverManager.getDriver().findElement(By.cssSelector(ediPagetUrl));
		editURLButton.click();

	}

	public void clickOnEditPageURLButton() {

		// click on edit page button

		this.editURLbutton();

	}
	
	// Set the new name of the URL

	public void URLPageName(String strNewURL) {

		WebElement URLName = driverManager.getDriver().findElement(By.cssSelector(pageUrlField));
		URLName.sendKeys(strNewURL);

	}

	public void setNewPageURL(String strNewURL) {

		// Set the new name of the URL

		this.URLPageName(strNewURL);

	}
	
	// click on preview sync option

		public void previewSyncOption() {

			WebElement previewSyncOpt = driverManager.getDriver().findElement(By.cssSelector(previewSync));
			previewSyncOpt.click();

		}

		public void clickOnPreviewSyncOption() {

			// click on preview sync option

			this.previewSyncOption();

		}
		
		// Press right click and select edit to the content created

		public void rightClickToEdit() {

			WebElement editContent = driverManager.getDriver().findElement(By.id("ygtvcontentel15")); //contentRecentlyCreated
			Actions action = new Actions(driverManager.getDriver());
			action.contextClick(editContent).build().perform();

			WebElement editOption = driverManager.getDriver().findElement(By.cssSelector(editRecentlyContentCreated)); 
			editOption.click();

		}

		public void rightClickToSelectEditOption() {

			// Press right click and select edit to the content created

			this.rightClickToEdit();

		}

}