package org.craftercms.studio.test.pages;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.craftercms.studio.test.utils.JsonTester;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.craftercms.studio.test.utils.datasourceslistxml.DataSourceCreatorXML;
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
	private JsonTester api;
	public String dataSourceXMLFileLocation;
	public String dataSourceXMLFileName;

	/**
	 * 
	 */
	public SiteConfigPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		// this.driver = this.driverManager.getDriver();
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
		api = new JsonTester("http", "localhost", 8080);
	}

	// Click on Content Type option

	public void clickContentTypeOption() {
		// this.driverManager.driverWait(300);
		this.driverManager.driverWait(2000);
		WebElement contentTypeOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				contentTypeOption);
		// driver.findElement(By.xpath(contentTypeOption));
		contentTypeOpt.click();
	}

	public void selectContentTypeOption() {

		// Click on Content Type option

		this.clickContentTypeOption();

	}

	// Click on open existing Type option

	public void clickOpenExistingTypeOption() {
		this.driverManager.driverWait(300);
		WebElement openExistingTypeOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				openExistingTypeOption);
		// driver.findElement(By.xpath(openExistingTypeOption));
		openExistingTypeOpt.click();

	}

	public void clickExistingTypeOption() {

		// Click on open existing Type option

		this.clickOpenExistingTypeOption();

	}

	// Select the generic content type

	public void selectContentType() {
		this.driverManager.driverWait(30);
		// its the default selected
		// WebElement selectGenericOption = this.getDriverManager().getDriver()
		// .findElement(By.xpath(genericContentTypeOption));
		//Assert.assertTrue(this.getDriverManager().isElementPresentByXpath(genericContentTypeOption));
		// selectGenericOption.click();

	}

	public void selectPageArticleContentTypeOption() {
		// this.driverManager.driverWait(300);
		this.driverManager.driverWait(2000);
		WebElement selectPageArticleOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", pageArticleContentTypeOption);
		// driver.findElement(By.cssSelector(pageArticleContentTypeOption));
		selectPageArticleOption.click();

	}

	public void selectEntryContentType() {

		// Select the generic content type

		this.selectContentType();

	}

	// Confirm the content type selected

	public void okContentTypeSelected() {
		this.driverManager.driverWait(300);
		WebElement okButtonOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", okButton);
		// driver.findElement(By.id(okButton));
		okButtonOpt.click();

	}

	public void confirmContentTypeSelected() {

		// Confirm the content type selected

		this.okContentTypeSelected();

	}

	// Save the section dropped.

	public void saveSectionDropped() {
		this.driverManager.driverWait(3000);
		WebElement okButtonOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "xpath", saveButton);
		// driver.findElement(By.xpath(saveButton));
		okButtonOpt.click();

	}

	public void saveDragAndDropProcess() {

		// Save the section dropped.
		this.saveSectionDropped();

	}

	// Click on generic title to edit the context type selected.

	public void clickOnGenericTitle() {
		this.driverManager.driverWait(2000);
		WebElement ClickTitle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				genericTitle);
		// driver.findElement(By.cssSelector(genericTitle));
		ClickTitle.click();

	}

	public void doClickOnGenericTitle() {

		// Click on generic title to edit the context type selected.

		this.clickOnGenericTitle();

	}

	// Click on display template field.

	public void clickOnDisplayTemplateField() {
		this.driverManager.driverWait(2000);
		WebElement showTemplate = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				displayTemplateField);
		// driver.findElement(By.cssSelector(displayTemplateField));
		showTemplate.click();

	}

	public void doClickOnDisplayTemplateField() {

		// Click on display template field.

		this.clickOnDisplayTemplateField();

	}

	// Edit ftl option

	public void clickOnEditFTLOption() {
		this.driverManager.driverWait(2000);
		WebElement editFLTopt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				editFTLOption);
		// driver.findElement(By.cssSelector(editFTLOption));
		editFLTopt.click();

	}

	public void doClickOnEditFTLOption() {

		// Edit ftl option

		this.clickOnEditFTLOption();

	}

	// Set title

	public void setTitle(String strTitle) {
		this.driverManager.driverWait(2000);
		WebElement typeTitle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				inputTitle);
		// driver.findElement(By.cssSelector(inputTitle));
		typeTitle.sendKeys(strTitle);

	}

	// Set ICE group

	public void setIceGroup(String strICEGroup) {
		this.driverManager.driverWait(2000);
		WebElement typeIceGroup = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				inputIceGroup);
		// driver.findElement(By.cssSelector(inputIceGroup));
		typeIceGroup.sendKeys(strICEGroup);

	}

	// Set description

	public void setDescription(String strDescription) {
		this.driverManager.driverWait(2000);
		WebElement typeDescription = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				inputDescription);
		// driver.findElement(By.cssSelector(inputDescription));
		typeDescription.sendKeys(strDescription);

	}

	// Set default value

	public void setDefaultValue(String strDefaultValue) {
		this.driverManager.driverWait(2000);
		WebElement typeDefaultValue = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				inputDefaultValue);
		// driver.findElement(By.cssSelector(inputDefaultValue));
		typeDefaultValue.sendKeys(strDefaultValue);

	}

	public void completeControlsFieldsBasics(String strTitle, String strICEGroup, String strDescription,
			String strDefaultValue) {
		// Fill title
		//this.driverManager.driverWait(2000);
		this.setTitle(strTitle);
		// Fill Ice group
		//this.driverManager.driverWait(2000);
		this.setIceGroup(strICEGroup);
		// Fill description
		//this.driverManager.driverWait(2000);
		this.setDescription(strDescription);
		// Fill default value
		//this.driverManager.driverWait(2000);
		this.setDefaultValue(strDefaultValue);
	}

	public void completeControlsFieldsBasics2(String strTitle, String strICEGroup, String strDescription) {
		// Fill title
		//this.driverManager.driverWait(2000);
		this.setTitle(strTitle);
		// Fill Ice group
		//this.driverManager.driverWait(2000);
		this.setIceGroup(strICEGroup);
		// Fill description
		//this.driverManager.driverWait(2000);
		this.setDescription(strDescription);
	}

	// Click on input section to can view the properties
	public void clickOnInputSectionToViewTheProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnInputSection);
		// driver.findElement(By.xpath(clickOnInputSection));
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
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnRepeatingGroupSection);
		// driver.findElement(By.xpath(clickOnRepeatingGroupSection));
		showSection.click();

	}

	public void clickTectAreaSection() {

		// Confirm the content type selected

		this.clickOnTextAreaToViewTheProperties();

	}

	// Click on Repeating group to view the properties of it
	public void clickOnTextAreaToViewTheProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnTextAreaSection);
		// driver.findElement(By.xpath(clickOnTextAreaSection));
		showSection.click();

	}

	public void selectEntryContentTypeFromAdminConsole() {
		this.driverManager.driverWait(1000);
		// select content types
		this.selectContentTypeOption();
		this.driverManager.driverWait(1000);
		// open content types
		this.clickExistingTypeOption();
		// wait for element
		this.driverManager.driverWait(1000);
		// Select the entry content type
		this.selectEntryContentType();
		this.driverManager.driverWait(1000);
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
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnRTESection);
		// driver.findElement(By.xpath(clickOnRTESection));
		showSection.click();
	}

	public void clickRTESection() {
		this.clickRTESectionToViewProperties();

	}

	public void clickDropdownSectionToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnDropdownSection);
		// driver.findElement(By.xpath(clickOnDropdownSection));
		showSection.click();
	}

	public void clickDropdownSection() {
		this.clickDropdownSectionToViewProperties();

	}

	public void clickDateTimeSectionToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnDropdownSection);
		// driver.findElement(By.xpath(clickOnDropdownSection));
		showSection.click();
	}

	public void clickDateTimeSection() {
		this.clickDateTimeSectionToViewProperties();

	}

	public void clickCheckBoxSectionToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnCheckBoxSection);
		// driver.findElement(By.xpath(clickOnCheckBoxSection));
		showSection.click();
	}

	public void clickCheckBoxSection() {
		this.clickCheckBoxSectionToViewProperties();

	}

	public void clickGroupedCheckBoxesSectionToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnGroupedCheckBoxesSection);
		// driver.findElement(By.xpath(clickOnGroupedCheckBoxesSection));
		showSection.click();
	}

	public void clickGroupedCheckBoxSection() {
		this.clickGroupedCheckBoxesSectionToViewProperties();

	}

	public void clickItemSelectorToViewProperties() {
		this.driverManager.driverWait(4000);
		WebElement showItemSelectorSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnItemSelectorSection);
		// driver.findElement(By.xpath(clickOnItemSelectorSection));
		showItemSelectorSection.click();
	}

	public void clickItemSelectorSection() {
		this.clickItemSelectorToViewProperties();

	}

	public void clickImageToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnImageSection);
		// driver.findElement(By.xpath(clickOnImageSection));
		showSection.click();
	}

	public void clickImageSection() {
		this.clickImageToViewProperties();

	}

	public void clickVideoToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnVideoSection);
		// driver.findElement(By.xpath(clickOnVideoSection));
		showSection.click();
	}

	public void clickVideoSection() {
		this.clickVideoToViewProperties();

	}

	public void clickLabelToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showLabelSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnLabelSection);
		// driver.findElement(By.xpath(clickOnLabelSection));
		showLabelSection.click();
	}

	public void clickLabelSection() {
		this.clickLabelToViewProperties();

	}

	public void clickPageOrderToViewProperties() {
		this.driverManager.driverWait(3000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(4, "xpath",
				clickOnPageOrderSection);
		// driver.findElement(By.xpath(clickOnPageOrderSection));
		showSection.click();
	}

	public void clickPageOrderSection() {
		this.clickPageOrderToViewProperties();

	}

	public void clickFileNameToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnFileNameSection);
		// driver.findElement(By.xpath(clickOnFileNameSection));
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
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
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

	// private void setName(String strName) {
	// WebElement typeName = driver.findElement(By.cssSelector(inputName));
	// typeName.sendKeys(strName);
	// }

	public void completeDataSourceFieldsBasics(String strTitle) {

		this.completeDataSourcesFieldsBasics(strTitle);
	}

	public void clickDataSourceChildContentToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnDataSourceChildContentSection);
		// driver.findElement(By.xpath(clickOnDataSourceChildContentSection));
		showSection.click();
	}

	public void clickDataSourceChildContentSection() {
		clickDataSourceChildContentToViewProperties();
	}

	public void clickDataSourceImageUploadedFromDesktopToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnDataSourceImageUploadedFromDesktopSection);
		// driver.findElement(By.xpath(clickOnDataSourceImageUploadedFromDesktopSection));
		showSection.click();
	}

	public void clickDataSourceImageUploadedFromDesktopSection() {
		clickDataSourceImageUploadedFromDesktopToViewProperties();
	}

	public void clickDataSourceImageUploadedFromRepositoryToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnDataSourceImageUploadedFromRepositorySection);
		// driver.findElement(By.xpath(clickOnDataSourceImageUploadedFromRepositorySection));
		showSection.click();
	}

	public void clickDataSourceImageUploadedFromRepositorySection() {
		clickDataSourceImageUploadedFromRepositoryToViewProperties();
	}

	public void clickDataSourceImageUploadedFromCMISRepositoryToViewProperties() {
		this.driverManager.driverWait(2000);
		WebElement showSection = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				clickOnDataSourceImageUploadedFromCMISRepositorySection);
		// driver.findElement(By.xpath(clickOnDataSourceImageUploadedFromCMISRepositorySection));
		showSection.click();
	}

	public void clickDataSourceImageUploadedFromCMISRepositorySection() {
		clickDataSourceImageUploadedFromCMISRepositoryToViewProperties();
	}

	public void createConfiguredListXML() {
		DataSourceCreatorXML creatorXML = new DataSourceCreatorXML();
		creatorXML.generateTestXMLFileForDataSource();
		this.dataSourceXMLFileLocation = creatorXML.getXMLFileLocation();
		this.dataSourceXMLFileName = creatorXML.getFileName();
	}

	public void createContentForXMLFileThroughAPI(String site, String path, String fileName, File file) {
		Map<String, String> json = new HashMap<>();
		json.put("site", site);
		json.put("path", path);
		json.put("filename", fileName);
		api.post("studio/api/1/services/api/1/content/write-content.json").params(json).file(fileName, file).execute()
				.status(200).debug();
	}

}