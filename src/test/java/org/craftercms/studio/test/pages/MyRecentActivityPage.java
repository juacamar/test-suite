package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class MyRecentActivityPage {

	private WebDriverManager driverManager;
    private String expandDefaultSection;
    private String tittleField1;
    private String saveCloseButton;
   
    /**
     * 
     */
    public MyRecentActivityPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.driverManager.getDriver();

        expandDefaultSection = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.expand_Default_Section");
        tittleField1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.tittle_Field1");
        saveCloseButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.save_Close_Button");
    }
	// Expand default section

	public void clickExpandOption() {
		WebElement expandOpt = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", expandDefaultSection);
		expandOpt.click();
	}

	public void expandDefaultSection() {
		// Expand default section
		this.clickExpandOption();
	}

	// Clear title field
	public void clearTitleField() {
		WebElement clearTitleField = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", tittleField1);
		clearTitleField.clear();
	}

	public void cleaningTitleField() {
		// Clear title field
		this.clearTitleField();
	}

	// Type new content on title text field.
	public void typeNewTextOnBodyField(String newText1) {
		WebElement clearTitleField = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", tittleField1);
		clearTitleField.sendKeys(newText1);
	}

	// Type new content on title text field.
	public void typingNewTextOnBodyField(String newText1) {
		// Typing
		this.typeNewTextOnBodyField(newText1);
	}

	// Save and close
	public void saveAndClose() {
		WebElement clearTitleField = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", saveCloseButton);
		clearTitleField.click();
	}

	public void clickOnSaveAndCloseButton() {
		// Save and close
		this.saveAndClose();
	}
}