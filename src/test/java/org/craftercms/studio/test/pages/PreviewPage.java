package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PreviewPage {

	private WebDriverManager driverManager;
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;
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

	/**
	 * 
	 */
	public PreviewPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.driver = this.driverManager.getDriver();
		adminConsole = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.admin_console_link");
		openComboSites = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.open_combo_sites");
		clickPreviewTools = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.preview_tools");
		expandInContextEditing = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.expand_in_context_editing");
		clickInContextEdit = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.enable_disable_in_context_edit");
		approvePublish = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.approve&publish");
		submitButtonApprovePublish = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish_submit");
		previewDuplicate = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.duplicate");
		duplicateName = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.duplicate_name");
		saveAndClose = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.save_close");
		pagesTree = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.expand_pages");
		expandGlobalEntryContent = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.expand_GlobalEntry_Tree");
		previewDelete = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.delete");
		deleteDependencies = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.delete_dependencies");
		OKdeleteDependencies = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.ok_delete_dependencies");
		previewEdit = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.edit");

	}

	public PreviewPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	// Click on admin console link

	public void ClickAdminConsoleOption() {

		WebElement adminConsoleOption = driverManager.getDriver().findElement(By.cssSelector(adminConsole));
		adminConsoleOption.click();

	}

	public void GoToAdminConsolePage() {

		// Click on admin console link

		this.ClickAdminConsoleOption();

	}

	// Open combo all sites

	public void ComboAllSites() {

		WebElement openCombo = driverManager.getDriver().findElement(By.id(openComboSites));
		openCombo.click();

	}

	public void OpenComboAllSites() {

		// Open combo all sites

		this.ComboAllSites();

	}

	// Click on preview tools icon

	public void PreviewTools() {

		WebElement toolsIcon = driverManager.getDriver().findElement(By.id(clickPreviewTools));
		toolsIcon.click();

	}

	public void ClickOnPreviewTools() {

		// Click on preview tools icon

		this.PreviewTools();

	}

	// Expand the In Context Menu

	public void ExpandInContextEditing() {

		WebElement expandInContextMenu = driverManager.getDriver().findElement(By.xpath(expandInContextEditing));
		expandInContextMenu.click();

	}

	public void ClickToExpandInContextEditing() {

		// Expand the In Context Menu

		this.ExpandInContextEditing();

	}

	// Enable/Diseble In-Context Editing

	public void InContextEditing() {

		WebElement inContextEditingOption = driverManager.getDriver().findElement(By.xpath(clickInContextEdit));
		inContextEditingOption.click();

	}

	public void ClickToEnableDisableInContextEditing() {

		// Enable/Diseble In-Context Editing

		this.InContextEditing();

	}

	// Click on Approve&Publish option

	public void ApprovePublish() {

		WebElement toolsIcon = driverManager.getDriver().findElement(By.xpath(approvePublish));
		toolsIcon.click();

	}

	public void ClickOnApprovePublish() {

		// Click on Approve&Publish option

		this.ApprovePublish();

	}

	// Click on submit button of Approve&Publish

	public void SubmitApprovePublish() {

		WebElement toolsIcon = driverManager.getDriver().findElement(By.id(submitButtonApprovePublish));
		toolsIcon.click();

	}

	public void ClickOnSubmitButtonOfApprovePublish() {

		// Click on submit button of Approve&Publish

		this.SubmitApprovePublish();

	}

	// Click on duplicate button of the menu

	public void DuplicateButton() {

		WebElement duplicateOption = driverManager.getDriver().findElement(By.xpath(previewDuplicate));
		duplicateOption.click();

	}

	public void ClickOnDuplicateOption() {

		// Click on duplicate button of the menu

		this.DuplicateButton();

	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	// Click on delete button of the menu

	public void DeleteButton() {

		WebElement deleteOption = driverManager.getDriver().findElement(By.xpath(previewDelete));
		deleteOption.click();

	}

	public void ClickOnDeleteOption() {

		// Click on delete button of the menu

		this.DeleteButton();

	}

	// Click on delete dependencies

	public void DeleteDependencies() {

		WebElement deleteDepen = driverManager.getDriver().findElement(By.id(deleteDependencies));
		deleteDepen.click();

	}

	public void ClickOnDeleteDependencies() {

		// Click on delete dependencies

		this.DeleteDependencies();

	}

	// Click on OK to delete dependencies

	public void OKDeleteDependencies() {

		WebElement OKdeleteDepen = driverManager.getDriver().findElement(By.cssSelector(OKdeleteDependencies));
		OKdeleteDepen.click();

	}

	public void ClickOnOKDeleteDependencies() {

		// Click on OK to delete dependencies

		this.OKDeleteDependencies();

	}

	// Click on edit button of the menu

	public void EditButton() {

		WebElement editOption = driverManager.getDriver().findElement(By.xpath(previewEdit));
		editOption.click();

	}

	public void ClickOnEditOption() {

		// Click on edit button of the menu

		this.EditButton();

	}

	// Set the new name of the URL

	public void DuplicateName(String strDuplicateName) {

		WebElement internalName = driverManager.getDriver().findElement(By.xpath(duplicateName));
		internalName.sendKeys(strDuplicateName);

	}

	public void SetDuplicateName(String strDuplicateName) {

		// Set the new name of the URL

		this.DuplicateName(strDuplicateName);

	}

	// Click on save and close

	public void SaveAndClose() {

		WebElement saveClose = driverManager.getDriver().findElement(By.cssSelector(saveAndClose));
		saveClose.click();

	}

	// Expand pages tree

	public void ClickPagesTree() {

		WebElement expandPagesTree = driverManager.getDriver().findElement(By.cssSelector(pagesTree));
		expandPagesTree.click();

	}

	public void ExpandPagesTree() {

		// Expand pages tree

		this.ClickPagesTree();

	}

	// Expand global entry content

	public void ClickGlobalEntryContent() {

		WebElement globalEntry = driverManager.getDriver().findElement(By.cssSelector(expandGlobalEntryContent));
		globalEntry.click();

	}

	public void ClickGlobalEntryTree() {

		// Expand global entry content

		this.ClickGlobalEntryContent();

	}

	public void ClickOnSaveAndClose() {

		// Click on save and close

		this.SaveAndClose();

	}

}