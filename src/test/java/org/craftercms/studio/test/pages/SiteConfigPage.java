package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class SiteConfigPage {

	private WebDriverManager driverManager;
	private String contentTypeOption;
	private String openExistingTypeOption;
	private String okButton;
	private String saveButton;
	private String genericTitle;
	private String displayTemplateField;
	private String editFTLOption;
	private String inputTitle;
	private String inputIceGroup;
	private String inputDescription;
	private String inputDefaultValue;
	private String clickOnInputSection;
	private String clickOnRepeatingGroupSection;
	private String clickOnTextAreaSection;
	private String pageArticleContentTypeOption;
	private String clickOnRTESection;
	private String clickOnDropdownSection;
	private String clickOnCheckBoxSection;
	private String clickOnGroupedCheckBoxesSection;
	private String clickOnItemSelectorSection;
	public String clickOnImageSection;
	public String clickOnVideoSection;
	public String clickOnLabelSection;
	public String clickOnPageOrderSection;
	public String clickOnFileNameSection;
	public String clickOnAutoFileNameSection;
	public String clickOnDataSourceChildContentSection;
	public String clickOnDataSourceImageUploadedFromDesktopSection;
	public String clickOnDataSourceImageUploadedFromRepositorySection;
	public String clickOnDataSourceImageUploadedFromCMISRepositorySection;
	
	

	/**
	 * 
	 */
	public SiteConfigPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		
		contentTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.content_type_option");
		openExistingTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.open_Existing_Type_Option");
		okButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.ok_Button");
		saveButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.save_Button");
		genericTitle = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.generic_title");
		displayTemplateField = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.display_Template_Field");
		editFTLOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.edit_FTL_Option");
		inputTitle = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Title");
		inputIceGroup = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.input_Ice_Group");
		inputDescription = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.input_Description");
		inputDefaultValue = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.input_Default_Value");
		clickOnInputSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerinput");
		clickOnRepeatingGroupSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerrepeatinggroup");
		clickOnTextAreaSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainertextarea");
		pageArticleContentTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.pagearticleoption");
		clickOnRTESection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerrte");
		clickOnDropdownSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerdropdown");
		clickOnCheckBoxSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainercheckbox");
		clickOnGroupedCheckBoxesSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainergroupedcheckboxes");
		clickOnItemSelectorSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontaineritemselector");
		clickOnImageSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerimage");
		clickOnVideoSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainervideo");
		clickOnLabelSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerlabel");
		clickOnPageOrderSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerpageorder");
		clickOnFileNameSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerfilename");
		clickOnAutoFileNameSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerautofilename");
		clickOnDataSourceChildContentSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerdatasourcechildcontent");
		clickOnDataSourceImageUploadedFromDesktopSection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.contenttype.entry.contenttypecontainerdatasourceimageuploadedfromdesktop");
		clickOnDataSourceImageUploadedFromRepositorySection = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty(
						"adminconsole.contenttype.entry.contenttypecontainerdatasourceimageuploadedfromrepository");
		clickOnDataSourceImageUploadedFromCMISRepositorySection = UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty(
						"adminconsole.contenttype.entry.contenttypecontainerdatasourceimageuploadedfromCMISrepository");
	}

	// Click on Content Type option

	public void clickContentTypeOption() {
		
		WebElement contentTypeOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				contentTypeOption);
		
		contentTypeOpt.click();
	}

	public void selectContentTypeOption() {

		// Click on Content Type option

		this.clickContentTypeOption();

	}

	// Click on open existing Type option

	public void clickOpenExistingTypeOption() {
		this.driverManager.isElementPresentAndClickableByXpath( openExistingTypeOption);
		WebElement openExistingTypeOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				openExistingTypeOption);
		
		openExistingTypeOpt.click();

	}

	public void clickExistingTypeOption() {

		// Click on open existing Type option

		this.clickOpenExistingTypeOption();

	}


	public void selectPageArticleContentTypeOption() {
		
		WebElement selectPageArticleOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", pageArticleContentTypeOption);
		
		selectPageArticleOption.click();

	}

	// Confirm the content type selected
	public void okContentTypeSelected() {
		this.driverManager.isElementPresentAndClickableById( okButton);
		WebElement okButtonOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", okButton);
		okButtonOpt.click();	
		
		this.driverManager.isElementPresentAndClickableByXpath( ".//div[contains(@class,'content-type-visual-container')]");
	}

	public void confirmContentTypeSelected() {
		// Confirm the content type selected
		this.okContentTypeSelected();
	}

	// Save the section dropped.
	public void saveSectionDropped() {
		WebElement okButtonOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", saveButton);
		okButtonOpt.click();
		this.driverManager.isElementPresentByXpath( ".//*[@class='notifyjs-corner']");
		
	}

	public void saveDragAndDropProcess() {
		// Save the section dropped.
		this.saveSectionDropped();

	}

	// Click on generic title to edit the context type selected.

	public void clickOnGenericTitle() {
		WebElement ClickTitle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				genericTitle);
		ClickTitle.click();
	}

	public void doClickOnGenericTitle() {

		// Click on generic title to edit the context type selected.
		this.clickOnGenericTitle();

	}

	// Click on display template field.

	public void clickOnDisplayTemplateField() {
		WebElement showTemplate = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				displayTemplateField);
		showTemplate.click();

	}

	public void doClickOnDisplayTemplateField() {

		// Click on display template field.
		this.clickOnDisplayTemplateField();

	}

	// Edit ftl option

	public void clickOnEditFTLOption() {
		WebElement editFLTopt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				editFTLOption);
		editFLTopt.click();

	}

	public void doClickOnEditFTLOption() {

		// Edit ftl option
		this.clickOnEditFTLOption();

	}

	// Set title

	public void setTitle(String strTitle) {
		WebElement typeTitle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				inputTitle);
		typeTitle.sendKeys(strTitle);

	}

	// Set ICE group

	public void setIceGroup(String strICEGroup) {
		WebElement typeIceGroup = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				inputIceGroup);
		typeIceGroup.sendKeys(strICEGroup);

	}

	// Set description

	public void setDescription(String strDescription) {
		WebElement typeDescription = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				inputDescription);
		typeDescription.sendKeys(strDescription);

	}

	// Set default value
	public void setDefaultValue(String strDefaultValue) {
		
		WebElement typeDefaultValue = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				inputDefaultValue);
		typeDefaultValue.sendKeys(strDefaultValue);

	}

	public void completeControlsFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		// Fill title
		this.setTitle(strTitle);
		// Fill Ice group
		this.setIceGroup(strICEGroup);
		// Fill description
		this.setDescription(strDescription);
		// Fill default value
		this.setDefaultValue(strDefaultValue);
	}

	public void completeControlsFieldsBasics2(String strTitle, String strICEGroup, String strDescription) {
		// Fill title
		this.setTitle(strTitle);
		// Fill Ice grou
		this.setIceGroup(strICEGroup);
		// Fill description
		this.setDescription(strDescription);
	}

	// Click on input section to can view the properties
	public void clickOnInputSectionToViewTheProperties() {
		this.driverManager.isElementPresentAndClickableByXpath( clickOnInputSection);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "xpath",
				clickOnInputSection);
		showSection.click();
	}

	public void clickInputSection() {

		// Confirm the content type selected
		this.clickOnInputSectionToViewTheProperties();

	}

	public void clickRepeatingGroupSection() {

		// Confirm the content type selected
		this.clickOnRepeatingGroupToViewTheProperties();

	}

	// Click on Repeating group to view the properties of it
	public void clickOnRepeatingGroupToViewTheProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnRepeatingGroupSection);
		showSection.click();

	}

	public void clickTectAreaSection() {

		// Confirm the content type selected
		this.clickOnTextAreaToViewTheProperties();

	}

	// Click on Repeating group to view the properties of it
	public void clickOnTextAreaToViewTheProperties() {

		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnTextAreaSection);
		
		showSection.click();

	}

	public void selectEntryContentTypeFromAdminConsole() {
		
		// select content types
		this.selectContentTypeOption();
		// open content types
		this.clickExistingTypeOption();
		// Confirm the content type selected
		this.confirmContentTypeSelected();
	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public void selectPageArticleContentType() {
		this.selectPageArticleContentTypeOption();
	}

	public void clickRTESectionToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnRTESection);
		showSection.click();
	}

	public void clickRTESection() {
		this.clickRTESectionToViewProperties();

	}

	public void clickDropdownSectionToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnDropdownSection);
		showSection.click();
	}

	public void clickDropdownSection() {
		this.clickDropdownSectionToViewProperties();

	}

	public void clickDateTimeSectionToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnDropdownSection);
		showSection.click();
	}

	public void clickDateTimeSection() {
		this.clickDateTimeSectionToViewProperties();

	}

	public void clickCheckBoxSectionToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnCheckBoxSection);
		showSection.click();
	}

	public void clickCheckBoxSection() {
		this.clickCheckBoxSectionToViewProperties();

	}

	public void clickGroupedCheckBoxesSectionToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnGroupedCheckBoxesSection);
		showSection.click();
	}

	public void clickGroupedCheckBoxSection() {
		this.clickGroupedCheckBoxesSectionToViewProperties();

	}

	public void clickItemSelectorToViewProperties() {
		WebElement showItemSelectorSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnItemSelectorSection);
		showItemSelectorSection.click();
	}

	public void clickItemSelectorSection() {
		this.clickItemSelectorToViewProperties();

	}

	public void clickImageToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnImageSection);
		showSection.click();
	}

	public void clickImageSection() {
		this.clickImageToViewProperties();

	}

	public void clickVideoToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnVideoSection);
		showSection.click();
	}

	public void clickVideoSection() {
		this.clickVideoToViewProperties();

	}

	public void clickLabelToViewProperties() {
		WebElement showLabelSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnLabelSection);
		showLabelSection.click();
	}

	public void clickLabelSection() {
		this.clickLabelToViewProperties();

	}

	public void clickPageOrderToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnPageOrderSection);
		showSection.click();
	}

	public void clickPageOrderSection() {
		this.clickPageOrderToViewProperties();

	}

	public void clickFileNameToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnFileNameSection);
		showSection.click();
	}

	public void clickFileNameSection() {
		this.clickFileNameToViewProperties();

	}

	public void completeControlFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void completeControlFieldsBasics2(String strTitle, String strICEGroup, String strDescription) {
		this.completeControlsFieldsBasics2(strTitle, strICEGroup, strDescription);
	}

	public void clickAutoFileNameToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnAutoFileNameSection);
		// driver.findElement(By.xpath(clickOnAutoFileNameSection));
		showSection.click();
	}

	public void clickAutoFileNameSection() {
		this.clickAutoFileNameToViewProperties();

	}

	public void completeDataSourcesFieldsBasics(String strTitle) {
		// Fill title
		this.setTitle(strTitle);
	}

	public void completeDataSourceFieldsBasics(String strTitle) {

		this.completeDataSourcesFieldsBasics(strTitle);
	}

	public void clickDataSourceChildContentToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnDataSourceChildContentSection);
		showSection.click();
	}

	public void clickDataSourceChildContentSection() {
		clickDataSourceChildContentToViewProperties();
	}

	public void clickDataSourceImageUploadedFromDesktopToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnDataSourceImageUploadedFromDesktopSection);
		showSection.click();
	}

	public void clickDataSourceImageUploadedFromDesktopSection() {
		clickDataSourceImageUploadedFromDesktopToViewProperties();
	}

	public void clickDataSourceImageUploadedFromRepositoryToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnDataSourceImageUploadedFromRepositorySection);
		showSection.click();
	}

	public void clickDataSourceImageUploadedFromRepositorySection() {
		clickDataSourceImageUploadedFromRepositoryToViewProperties();
	}

	public void clickDataSourceImageUploadedFromCMISRepositoryToViewProperties() {
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				clickOnDataSourceImageUploadedFromCMISRepositorySection);
		showSection.click();
	}

	public void clickDataSourceImageUploadedFromCMISRepositorySection() {
		clickDataSourceImageUploadedFromCMISRepositoryToViewProperties();
	}

}