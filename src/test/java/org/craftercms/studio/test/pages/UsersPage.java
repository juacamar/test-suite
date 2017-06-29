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

public class UsersPage {

	private WebDriverManager driverManager;
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;
	private String deleteUserOption;
	private String newUserOption;
	private String saveNewUserOption;

	/**
	 * 
	 */
	public UsersPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.uIElementsManager = UIElementsPropertiesManager;
		this.driver = this.driverManager.getDriver();
		deleteUserOption = uIElementsManager.getSharedUIElementsLocators().getProperty("users.delete_option");
		newUserOption = uIElementsManager.getSharedUIElementsLocators().getProperty("users.new_user");
		saveNewUserOption = uIElementsManager.getSharedUIElementsLocators().getProperty("users.save_new_user");

	}

	public UsersPage(WebDriver driver) {

		this.driver = driver;

	}

	// Try to delete the user connected

	public void clickDeleteOption() {

		WebElement previewLink = driverManager.getDriver().findElement(By.cssSelector(deleteUserOption));
		previewLink.click();

	}

	// Try to delete the user connected

	public void clickOnDeleteUser() {

		// Try to delete the user connected

		this.clickDeleteOption();

	}

	// Click on New User Button

	public void clickNewUserButton() {

		WebElement newUserButton = driverManager.getDriver().findElement(By.cssSelector(newUserOption));
		newUserButton.click();

	}

	// Click on New User Button

	public void clickOnNewUser() {

		// Click on New User Button

		this.clickNewUserButton();

	}

	// Click on Save New User Button

	public void clickSaveNewUserButton() {

		WebElement saveNewUser = driverManager.getDriver().findElement(By.cssSelector(saveNewUserOption));
		saveNewUser.click();

	}

	// Click on Save New User Button

	public void clickOnSaveNewUser() {

		// Click on Save New User Button

		this.clickSaveNewUserButton();

	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}