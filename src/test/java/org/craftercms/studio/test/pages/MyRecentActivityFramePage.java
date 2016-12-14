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

public class MyRecentActivityFramePage {

	private WebDriverManager driverManager;
    private UIElementsPropertiesManager uIElementsManager;
    private WebDriver driver;
    private String expandDefaultSection;
    private String tittleField1;
    private String saveCloseButton;
    /**
     * 
     */
    public MyRecentActivityFramePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.uIElementsManager = UIElementsPropertiesManager;
        this.driver = this.driverManager.getDriver();
        expandDefaultSection = uIElementsManager.getSharedUIElementsLocators().getProperty("frame1.expand_Default_Section");
        tittleField1 = uIElementsManager.getSharedUIElementsLocators().getProperty("frame1.tittle_Field1");
        saveCloseButton = uIElementsManager.getSharedUIElementsLocators().getProperty("frame1.save_Close_Button");
    }
	// Expand default section

	public void ClickExpandOption() {
		
		WebElement expandOpt = driverManager.getDriver().findElement(By.id(expandDefaultSection));
		expandOpt.click();

	}

	public void ExpandDefaultSection() {

		// Expand default section

		this.ClickExpandOption();

	}

	// Clear title field

	public void ClearTitleField() {

		WebElement clearTitleField = driverManager.getDriver().findElement(By.xpath(tittleField1));
		clearTitleField.clear();


	}

	public void CleaningTitleField() {

		// Clear title field

		this.ClearTitleField();

	}

	// Type new content on title text field.

	public void TypeNewTextOnBodyField(String newText1) {

		WebElement clearTitleField = driverManager.getDriver().findElement(By.xpath(tittleField1));
		clearTitleField.sendKeys(newText1);

	}

	// Type new content on title text field.

	public void TypingNewTextOnBodyField(String newText1) {

		// Typing

		this.TypeNewTextOnBodyField(newText1);

	}

	// Save and close

	public void SaveAndClose() {

		WebElement clearTitleField = driverManager.getDriver().findElement(By.id(saveCloseButton));
		clearTitleField.click();

	}

	public void ClickOnSaveAndCloseButton() {

		// Save and close

		this.SaveAndClose();

	}
}