package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Costa Rica Crafter Software team
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
		clickInContextEdit = uIElementsManager.getSharedUIElementsLocators().getProperty("preview.enable_disable_in_context_edit");

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

}