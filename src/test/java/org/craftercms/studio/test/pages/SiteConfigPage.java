package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class SiteConfigPage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String contentTypeOption;
	private String openExistingTypeOption;
	private String genericContentTypeOption;
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

	/**
	 * 
	 */
	public SiteConfigPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		contentTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.content_type_option");
		openExistingTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.open_Existing_Type_Option");
		genericContentTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("adminconsole.generic_Content_Type_Option");
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
	}

	public SiteConfigPage(WebDriver driver) {

		this.driver = driver;

	}

	// Click on Content Type option

	public void clickContentTypeOption() {

		WebElement contentTypeOpt = driver.findElement(By.xpath(contentTypeOption));
		contentTypeOpt.click();
	}

	public void selectContentTypeOption() {

		// Click on Content Type option

		this.clickContentTypeOption();

	}

	// Click on open existing Type option

	public void clickOpenExistingTypeOption() {

		WebElement openExistingTypeOpt = driver.findElement(By.xpath(openExistingTypeOption));
		openExistingTypeOpt.click();

	}

	public void clickExistingTypeOption() {

		// Click on open existing Type option

		this.clickOpenExistingTypeOption();

	}

	// Select the generic content type

	public void selectContentType() {

		WebElement selectGenericOption = this.getDriverManager().getDriver()
				.findElement(By.xpath(genericContentTypeOption));
		selectGenericOption.click();

	}

	public void selectPageArticleContentTypeOption() {

		WebElement selectPageArticleOption = driver.findElement(By.cssSelector(pageArticleContentTypeOption));
		selectPageArticleOption.click();

	}

	public void selectEntryContentType() {

		// Select the generic content type

		this.selectContentType();

	}

	// Confirm the content type selected

	public void okContentTypeSelected() {

		WebElement okButtonOpt = driver.findElement(By.id(okButton));
		okButtonOpt.click();

	}

	public void confirmContentTypeSelected() {

		// Confirm the content type selected

		this.okContentTypeSelected();

	}

	// Save the section dropped.

	public void saveSectionDropped() {

		WebElement okButtonOpt = driver.findElement(By.xpath(saveButton));
		okButtonOpt.click();

	}

	public void saveDragAndDropProcess() {

		// Save the section dropped.
		this.saveSectionDropped();

	}

	// Click on generic title to edit the context type selected.

	public void clickOnGenericTitle() {

		WebElement ClickTitle = driver.findElement(By.cssSelector(genericTitle));
		ClickTitle.click();

	}

	public void doClickOnGenericTitle() {

		// Click on generic title to edit the context type selected.

		this.clickOnGenericTitle();

	}

	// Click on display template field.

	public void clickOnDisplayTemplateField() {

		WebElement showTemplate = driver.findElement(By.cssSelector(displayTemplateField));
		showTemplate.click();

	}

	public void doClickOnDisplayTemplateField() {

		// Click on display template field.

		this.clickOnDisplayTemplateField();

	}

	// Edit ftl option

	public void clickOnEditFTLOption() {

		WebElement editFLTopt = driver.findElement(By.cssSelector(editFTLOption));
		editFLTopt.click();

	}

	public void doClickOnEditFTLOption() {

		// Edit ftl option

		this.clickOnEditFTLOption();

	}

	// Set title

	public void setTitle(String strTitle) {

		WebElement typeTitle = driver.findElement(By.cssSelector(inputTitle));
		typeTitle.sendKeys(strTitle);

	}

	// Set ICE group

	public void setIceGroup(String strICEGroup) {

		WebElement typeIceGroup = driver.findElement(By.cssSelector(inputIceGroup));
		typeIceGroup.sendKeys(strICEGroup);

	}

	// Set description

	public void setDescription(String strDescription) {

		WebElement typeDescription = driver.findElement(By.cssSelector(inputDescription));
		typeDescription.sendKeys(strDescription);

	}

	// Set default value

	public void setDefaultValue(String strDefaultValue) {

		WebElement typeDefaultValue = driver.findElement(By.cssSelector(inputDefaultValue));
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
		// Fill Ice group
		this.setIceGroup(strICEGroup);
		// Fill description
		this.setDescription(strDescription);
	}

	// Complete input fields basics
	public void completeInputFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void completeRepeatingGroupFieldsBasics(String strTitle, String strICEGroup, String strDescription) {

		this.completeControlsFieldsBasics2(strTitle, strICEGroup, strDescription);

	}

	public void completeTextAreaFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	// Click on input section to can view the properties

	public void clickOnInputSectionToViewTheProperties() {

		WebElement showInputSection = driver.findElement(By.xpath(clickOnInputSection));
		showInputSection.click();

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

		WebElement showRepeatingGroupSection = driver.findElement(By.xpath(clickOnRepeatingGroupSection));
		showRepeatingGroupSection.click();

	}

	public void clickTectAreaSection() {

		// Confirm the content type selected

		this.clickOnTextAreaToViewTheProperties();

	}

	// Click on Repeating group to view the properties of it
	public void clickOnTextAreaToViewTheProperties() {

		WebElement showRepeatingGroupSection = driver.findElement(By.xpath(clickOnTextAreaSection));
		showRepeatingGroupSection.click();

	}

	public void selectEntryContentTypeFromAdminConsole() {
		// select content types
		this.selectContentTypeOption();
		// open content types
		this.clickExistingTypeOption();
		// wait for element
		this.driverManager.driverWait();
		// Select the entry content type
		this.selectEntryContentType();
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

	public void completeRTEFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);

	}

	public void clickRTESectionToViewProperties() {
		WebElement showRTESection = driver.findElement(By.xpath(clickOnRTESection));
		showRTESection.click();
	}

	public void clickRTESection() {
		this.clickRTESectionToViewProperties();

	}

	public void completeDropdonwFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickDropdownSectionToViewProperties() {
		WebElement showDropdownSection = driver.findElement(By.xpath(clickOnDropdownSection));
		showDropdownSection.click();
	}

	public void clickDropdownSection() {
		this.clickDropdownSectionToViewProperties();

	}

	public void completeaDateTimeFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickDateTimeSectionToViewProperties() {
		WebElement showDateTimeSection = driver.findElement(By.xpath(clickOnDropdownSection));
		showDateTimeSection.click();
	}

	public void clickDateTimeSection() {
		this.clickDateTimeSectionToViewProperties();

	}

	public void completeaCheckBoxFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickCheckBoxSectionToViewProperties() {
		WebElement showCheckBoxSection = driver.findElement(By.xpath(clickOnCheckBoxSection));
		showCheckBoxSection.click();
	}

	public void clickCheckBoxSection() {
		this.clickCheckBoxSectionToViewProperties();

	}

	public void completeaGroupedCheckBoxesFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickGroupedCheckBoxesSectionToViewProperties() {
		WebElement showGroupedCheckBoxesSection = driver.findElement(By.xpath(clickOnGroupedCheckBoxesSection));
		showGroupedCheckBoxesSection.click();
	}

	public void clickGroupedCheckBoxSection() {
		this.clickGroupedCheckBoxesSectionToViewProperties();

	}

	public void completeItemSelectorFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickItemSelectorToViewProperties() {
		WebElement showItemSelectorSection = driver.findElement(By.xpath(clickOnItemSelectorSection));
		showItemSelectorSection.click();
	}

	public void clickItemSelectorSection() {
		this.clickItemSelectorToViewProperties();

	}

	public void completeImageFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickImageToViewProperties() {
		WebElement showImageSection = driver.findElement(By.xpath(clickOnImageSection));
		showImageSection.click();
	}

	public void clickImageSection() {
		this.clickImageToViewProperties();

	}

	public void completeVideoFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickVideoToViewProperties() {
		WebElement showVideoSection = driver.findElement(By.xpath(clickOnVideoSection));
		showVideoSection.click();
	}

	public void clickVideoSection() {
		this.clickVideoToViewProperties();

	}

	public void completeLabelFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickLabelToViewProperties() {
		WebElement showLabelSection = driver.findElement(By.xpath(clickOnLabelSection));
		showLabelSection.click();
	}

	public void clickLabelSection() {
		this.clickLabelToViewProperties();

	}

	public void completePageOrderFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		this.completeControlsFieldsBasics(strTitle, strICEGroup, strDescription, strDefaultValue);
	}

	public void clickPageOrderToViewProperties() {
		WebElement showPageOrderSection = driver.findElement(By.xpath(clickOnPageOrderSection));
		showPageOrderSection.click();
	}

	public void clickPageOrderSection() {
		this.clickPageOrderToViewProperties();

	}
}