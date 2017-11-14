package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 *
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PreviewPage {

	private WebDriverManager driverManager;
	private String adminConsole;
	private String openComboSites;
	private String clickPreviewTools;
	private String expandInContextEditing;
	private String clickInContextEdit;
	private String approvePublish;
	private String submitButtonApprovePublish;
	private String previewDuplicate;
	private String duplicateName;
	private String saveAndClose;
	private String pagesTree;
	private String expandGlobalEntryContent;
	private String previewDelete;
	private String deleteDependencies;
	private String OKdeleteDependencies;
	private String previewEdit;
	private String internalName;
	private String saveAndCloseiFrame;
	private String previewHistory;
	private String previewDependecies;

	private SiteConfigPage siteConfigPage;
	private String studioLogo;
	private String siteDropdownElementXPath;
	private String adminConsoleXpath;
	private String entryContentTypeBodyXpath;
	private String entryContentTypeBodyCheckCss;

	/**
	 * 
	 */
	public PreviewPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driverManager.getDriver();

		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager);

		adminConsole = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.admin_console_link");
		openComboSites = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.open_combo_sites");
		clickPreviewTools = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.preview_tools");
		expandInContextEditing = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.expand_in_context_editing");
		clickInContextEdit = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.enable_disable_in_context_edit");
		approvePublish = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish");
		submitButtonApprovePublish = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish_submit");
		previewDuplicate = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.duplicate");
		duplicateName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.duplicate_name");
		saveAndClose = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.save_close");
		pagesTree = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.expand_pages");
		expandGlobalEntryContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.expand_GlobalEntry_Tree");
		previewDelete = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.delete");
		deleteDependencies = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.delete_dependencies");
		OKdeleteDependencies = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.ok_delete_dependencies");
		previewEdit = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.edit");
		internalName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.internal_Name");
		saveAndCloseiFrame = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.save_close");
		previewHistory = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.history");
		previewDependecies = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.dependencies");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		siteDropdownElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		adminConsoleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");

	}

	// Click on admin console link

	public void clickAdminConsoleOption() {
		WebElement adminConsoleOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				adminConsole);

		adminConsoleOption.click();

	}

	public void goToAdminConsolePage() {

		// Click on admin console link

		this.clickAdminConsoleOption();

	}

	// Open combo all sites

	public void ComboAllSites() {

		WebElement openCombo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", openComboSites);

		openCombo.click();

	}

	public void OpenComboAllSites() {

		// Open combo all sites

		this.ComboAllSites();

	}

	// Click on preview tools icon

	public void previewTools() {
		WebElement toolsIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", clickPreviewTools);

		toolsIcon.click();

	}

	public void clickOnPreviewTools() {

		// Click on preview tools icon

		this.previewTools();

	}

	// Expand the In Context Menu

	public void expandInContextEditing() {
		WebElement expandInContextMenu = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				expandInContextEditing);

		expandInContextMenu.click();

	}

	public void clickToExpandInContextEditing() {

		// Expand the In Context Menu

		this.expandInContextEditing();

	}

	// Enable/Diseble In-Context Editing

	public void inContextEditing() {
		WebElement inContextEditingOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				clickInContextEdit);

		inContextEditingOption.click();

	}

	public void clickToEnableDisableInContextEditing() {

		// Enable/Diseble In-Context Editing

		this.inContextEditing();

	}

	// Click on Approve&Publish option

	public void approvePublish() {
		this.driverManager.isElementPresentAndClickableByXpath(approvePublish);
		WebElement publishIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				approvePublish);

		publishIcon.click();

	}

	public void clickOnApprovePublish() {

		// Click on Approve&Publish option

		this.approvePublish();

	}

	// Click on submit button of Approve&Publish

	public void submitApprovePublish() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", submitButtonApprovePublish);
		WebElement toolsIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				submitButtonApprovePublish);
		toolsIcon.click();

	}

	public void clickOnSubmitButtonOfApprovePublish() {

		// Click on submit button of Approve&Publish

		this.submitApprovePublish();

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

	// Click on delete button of the menu

	public void deleteButton() {

		WebElement deleteOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				previewDelete);

		deleteOption.click();

	}

	public void clickOnDeleteOption() {

		// Click on delete button of the menu

		this.deleteButton();

	}

	// Click on delete dependencies

	public void deleteDependencies() {

		WebElement deleteDepen = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				deleteDependencies);

		deleteDepen.click();

	}

	public void clickOnDeleteDependencies() {

		// Click on delete dependencies

		this.deleteDependencies();

	}

	// Click on OK to delete dependencies

	public void okDeleteDependencies() {

		WebElement OKdeleteDepen = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				OKdeleteDependencies);

		OKdeleteDepen.click();

	}

	public void clickOnOKDeleteDependencies() {

		// Click on OK to delete dependencies

		this.okDeleteDependencies();

	}

	// Click on edit button of the menu

	public void EditButton() {

		WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", previewEdit);

		editOption.click();

	}

	public void clickOnEditOption() {

		// Click on edit button of the menu

		this.EditButton();

	}

	// Click on history button of the menu

	public void historyButton() {

		WebElement historyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				previewHistory);

		historyOption.click();

	}

	public void clickOnHistoryOption() {

		// Click on history button of the menu
		this.historyButton();

	}

	// Click on dependencies button of the menu

	public void dependenciesButton() {

		WebElement historyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				previewDependecies);

		historyOption.click();

	}

	public void clickOnDependenciesOption() {

		// Click on dependencies button of the menu
		this.dependenciesButton();

	}

	// Set the new name duplicated

	public void duplicateName(String strDuplicateName) {

		WebElement internalName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				duplicateName);

		internalName.sendKeys(strDuplicateName);

	}

	public void setDuplicateName(String strDuplicateName) {

		// Set the new name duplicated

		this.duplicateName(strDuplicateName);

	}

	// Click on save and close

	public void SaveAndClose() {

		WebElement saveClose = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				saveAndClose);

		saveClose.click();

	}

	// Expand pages tree

	public void clickPagesTree() {

		WebElement expandPagesTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", pagesTree);

		expandPagesTree.click();

	}

	public void expandPagesTree() {

		// Expand pages tree
		this.clickPagesTree();

	}

	// Expand global entry content

	public void clickHomeContent() {
		this.driverManager.isElementPresentAndClickableByXpath(expandGlobalEntryContent);
		WebElement homeContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				expandGlobalEntryContent);
		homeContent.click();

	}

	public void expandHomeTree() {

		// Expand global entry content

		this.clickHomeContent();

	}

	public void clickOnSaveAndClose() {

		// Click on save and close

		this.SaveAndClose();

	}

	// Set the new name of the URL

	public void changeInternalName(String strNewInternalName) {

		WebElement URLName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", internalName);

		URLName.sendKeys(strNewInternalName);

	}

	public void setNewInternalName(String strNewInternalName) {

		// Set the new name of the URL

		this.changeInternalName(strNewInternalName);

	}

	// Click save and close

	public void saveAndCloseButton() {

		WebElement saveClose = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				saveAndCloseiFrame);

		saveClose.click();

	}

	public void clickOnSaveAndCloseButton() {

		// Click save and close

		this.saveAndCloseButton();

	}

	public void changeBodyOfEntryContentPageToNotRequired() {

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", siteDropdownElementXPath).click();

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", adminConsoleXpath).click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable
		driverManager.getDriver().switchTo().defaultContent();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", entryContentTypeBodyXpath).click();

		// Mark Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", entryContentTypeBodyCheckCss)
				.click();

		// save
		siteConfigPage.saveDragAndDropProcess();

		driverManager.getDriver().switchTo().defaultContent();

		// go to dashboard
		this.driverManager.isElementPresentAndClickableById(studioLogo);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", studioLogo).click();

	}

}