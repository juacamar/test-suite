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

	/**
	 * 
	 */
	public PreviewPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.driverManager.getDriver();
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
		internalName = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("frame1.internal_Name");
		saveAndCloseiFrame = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("frame1.save_close");
		previewHistory = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.history");
		previewDependecies = uIElementsManager.getSharedUIElementsLocators()
				.getProperty("preview.dependencies");
		
				
	}

	public PreviewPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	// Click on admin console link

	public void clickAdminConsoleOption() {

		WebElement adminConsoleOption = driverManager.getDriver().findElement(By.cssSelector(adminConsole));
		adminConsoleOption.click();

	}

	public void goToAdminConsolePage() {

		// Click on admin console link

		this.clickAdminConsoleOption();

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

	public void previewTools() {

		WebElement toolsIcon = driverManager.getDriver().findElement(By.id(clickPreviewTools));
		toolsIcon.click();

	}

	public void clickOnPreviewTools() {

		// Click on preview tools icon

		this.previewTools();

	}

	// Expand the In Context Menu

	public void expandInContextEditing() {

		WebElement expandInContextMenu = driverManager.getDriver().findElement(By.xpath(expandInContextEditing));
		expandInContextMenu.click();

	}

	public void clickToExpandInContextEditing() {

		// Expand the In Context Menu

		this.expandInContextEditing();

	}

	// Enable/Diseble In-Context Editing

	public void inContextEditing() {

		WebElement inContextEditingOption = driverManager.getDriver().findElement(By.xpath(clickInContextEdit));
		inContextEditingOption.click();

	}

	public void clickToEnableDisableInContextEditing() {

		// Enable/Diseble In-Context Editing

		this.inContextEditing();

	}

	// Click on Approve&Publish option

	public void approvePublish() {

		WebElement toolsIcon = driverManager.getDriver().findElement(By.xpath(approvePublish));
		toolsIcon.click();

	}

	public void clickOnApprovePublish() {

		// Click on Approve&Publish option

		this.approvePublish();

	}

	// Click on submit button of Approve&Publish

	public void submitApprovePublish() {

		WebElement toolsIcon = driverManager.getDriver().findElement(By.id(submitButtonApprovePublish));
		toolsIcon.click();

	}

	public void clickOnSubmitButtonOfApprovePublish() {

		// Click on submit button of Approve&Publish

		this.submitApprovePublish();

	}

	// Click on duplicate button of the menu

	public void duplicateButton() {

		WebElement duplicateOption = driverManager.getDriver().findElement(By.xpath(previewDuplicate));
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

		WebElement deleteOption = driverManager.getDriver().findElement(By.xpath(previewDelete));
		deleteOption.click();

	}

	public void clickOnDeleteOption() {

		// Click on delete button of the menu

		this.deleteButton();

	}

	// Click on delete dependencies

	public void deleteDependencies() {

		WebElement deleteDepen = driverManager.getDriver().findElement(By.id(deleteDependencies));
		deleteDepen.click();

	}

	public void clickOnDeleteDependencies() {

		// Click on delete dependencies

		this.deleteDependencies();

	}

	// Click on OK to delete dependencies

	public void okDeleteDependencies() {

		WebElement OKdeleteDepen = driverManager.getDriver().findElement(By.cssSelector(OKdeleteDependencies));
		OKdeleteDepen.click();

	}

	public void clickOnOKDeleteDependencies() {

		// Click on OK to delete dependencies

		this.okDeleteDependencies();

	}

	// Click on edit button of the menu

	public void EditButton() {

		WebElement editOption = driverManager.getDriver().findElement(By.xpath(previewEdit));
		editOption.click();

	}

	public void clickOnEditOption() {

		// Click on edit button of the menu

		this.EditButton();

	}
	
	// Click on history button of the menu

	public void historyButton() {

		WebElement historyOption = driverManager.getDriver().findElement(By.cssSelector(previewHistory));   
		historyOption.click();

	}

	public void clickOnHistoryOption() {

		// Click on history button of the menu

		this.historyButton();

	}
	
	
	// Click on dependencies button of the menu

		public void dependenciesButton() {

			WebElement historyOption = driverManager.getDriver().findElement(By.cssSelector(previewDependecies));
			historyOption.click();

		}

		public void clickOnDependenciesOption() {

			// Click on dependencies button of the menu

			this.dependenciesButton();

		}

	// Set the new name duplicated

	public void duplicateName(String strDuplicateName) {

		WebElement internalName = driverManager.getDriver().findElement(By.xpath(duplicateName));
		internalName.sendKeys(strDuplicateName);

	}

	public void setDuplicateName(String strDuplicateName) {

		// Set the new name duplicated

		this.duplicateName(strDuplicateName);

	}

	// Click on save and close

	public void SaveAndClose() {

		WebElement saveClose = driverManager.getDriver().findElement(By.cssSelector(saveAndClose));
		saveClose.click();

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

	public void clickHomeContent() {

		WebElement homeContent = driverManager.getDriver().findElement(By.cssSelector(expandGlobalEntryContent));
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

			WebElement URLName = driverManager.getDriver().findElement(By.xpath(internalName));
			URLName.sendKeys(strNewInternalName);

		}

		public void setNewInternalName(String strNewInternalName) {

			// Set the new name of the URL

			this.changeInternalName(strNewInternalName);

		}
		
		// Click save and close
		
		public void saveAndCloseButton() {

			WebElement saveClose = driverManager.getDriver().findElement(By.cssSelector(saveAndCloseiFrame));
			saveClose.click();

		}

		public void clickOnSaveAndCloseButton() {

			// Click save and close

			this.saveAndCloseButton();

		}

}