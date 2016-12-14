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

public class AdminConsolePage {

	private WebDriverManager driverManager;
    private UIElementsPropertiesManager uIElementsManager;
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
    /**
     * 
     */
    public AdminConsolePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.uIElementsManager = UIElementsPropertiesManager;
        this.driver = this.driverManager.getDriver();
        contentTypeOption = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.content_type_option");
        openExistingTypeOption = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.open_Existing_Type_Option");
        genericContentTypeOption = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.generic_Content_Type_Option");
        okButton = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.ok_Button");
        saveButton = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.save_Button");
        genericTitle = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.generic_title");
        displayTemplateField = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.display_Template_Field");
        editFTLOption = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.edit_FTL_Option");
        inputTitle = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Title");
        inputIceGroup = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Ice_Group");
        inputDescription = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Description");
        inputDefaultValue = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Default_Value");
        clickOnInputSection = uIElementsManager.getSharedUIElementsLocators().getProperty("adminconsole.click_On_Input_Section");
    }
	public AdminConsolePage(WebDriver driver) {

		this.driver = driver;

	}

	// Click on Content Type option

	public void ClickContentTypeOption() {

		 WebElement contentTypeOpt = driver.findElement(By.xpath(contentTypeOption));
		 contentTypeOpt.click();

	}

	public void SelectContentTypeOption() {

		// Click on Content Type option

		this.ClickContentTypeOption();

	}

	// Click on open existing Type option

	public void ClickOpenExistingTypeOption() {

		WebElement openExistingTypeOpt = driver.findElement(By.id(openExistingTypeOption));
		openExistingTypeOpt.click();

	}

	public void ClickExistingTypeOption() {

		// Click on open existing Type option

		this.ClickOpenExistingTypeOption();

	}

	// Select the generic content type

	public void SelectContentType() {

		WebElement selectGenericOption = driver.findElement(By.xpath(genericContentTypeOption));
		selectGenericOption.click();

	}

	public void SelectGenericContentType() {

		// Select the generic content type

		this.SelectContentType();

	}

	// Confirm the content type selected

	public void OkContentTypeSelected() {

		WebElement okButtonOpt = driver.findElement(By.id(okButton));
		okButtonOpt.click();

	}

	public void ConfirmContentTypeSelected() {

		// Confirm the content type selected

		this.OkContentTypeSelected();

	}

	// Save the section dropped.

	public void SaveSectionDropped() {

		WebElement okButtonOpt = driver.findElement(By.xpath(saveButton));
		okButtonOpt.click();

	}

	public void SaveDragAndDropProcess() {

		// Save the section dropped.

		this.SaveSectionDropped();

	}

	// Click on generic title to edit the context type selected.

	public void ClickOnGenericTitle() {

		WebElement ClickTitle = driver.findElement(By.cssSelector(genericTitle));
		ClickTitle.click();

	}

	public void DoClickOnGenericTitle() {

		// Click on generic title to edit the context type selected.

		this.ClickOnGenericTitle();

	}

	// Click on display template field.

	public void ClickOnDisplayTemplateField() {

		WebElement showTemplate = driver.findElement(By.cssSelector(displayTemplateField));
		showTemplate.click();

	}

	public void DoClickOnDisplayTemplateField() {

		// Click on display template field.

		this.ClickOnDisplayTemplateField();

	}

	// Edit ftl option

	public void ClickOnEditFTLOption() {

		WebElement editFLTopt = driver.findElement(By.cssSelector(editFTLOption));
		editFLTopt.click();

	}

	public void DoClickOnEditFTLOption() {

		// Edit ftl option

		this.ClickOnEditFTLOption();

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
	
	// Complete input fields basics
	
	public void CompleteInputFieldsBasics(String strTitle, String strICEGroup, String strDescription, String strDefaultValue) {

		// Fill title

		this.setTitle(strTitle);

		// Fill Ice group

		this.setIceGroup(strICEGroup);

		// Fill description
		
		this.setDescription(strDescription);
		
		// Fill default value
		
		this.setDefaultValue(strDefaultValue);

	}
	
	// Click on input section to can view the properties 

	public void clickOnInputSectionToViewTheProperties() {

		WebElement showInputSection = driver.findElement(By.cssSelector(clickOnInputSection));
		showInputSection.click();

	}

	public void clickInputSection() {

		// Confirm the content type selected

		this.clickOnInputSectionToViewTheProperties();

	}
}