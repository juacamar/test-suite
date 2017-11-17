package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class UsersPage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String deleteUserOption;
	private String newUserOption;
	private String saveNewUserOption;
	private String deleteUserOption2;
	private String editUserOption;
	private String usersPageTitle;
	private String crafterLogo;


	/**
	 * 
	 */
	public UsersPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager
			 ) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		

		deleteUserOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("users.delete_option");
		newUserOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("users.new_user");
		saveNewUserOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("users.save_new_user");
		deleteUserOption2 = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("users.delete_option2");
		editUserOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("users.edit_option");
		usersPageTitle = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("users.page_title");
		crafterLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("users.crafterlogo");

	}

	public UsersPage(WebDriver driver) {

		this.driver = driver;

	}

	// Try to delete the user connected

	public void clickDeleteOption() {
		WebElement previewLink = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", deleteUserOption);
		previewLink.click();

	}

	// Try to delete the user connected
	public void clickOnDeleteUser() {

		// Try to delete the user connected
		this.clickDeleteOption();

	}

	// Click on New User Button

	public void clickNewUserButton() {
		WebElement newUserButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"xpath", newUserOption);
		newUserButton.click();

	}

	// Click on New User Button

	public void clickOnNewUser() {

		// Click on New User Button
		this.clickNewUserButton();

	}

	// Click on Save New User Button

	public void clickSaveNewUserButton() {
		this.driverManager.isElementPresentBycssSelector(saveNewUserOption);
		WebElement saveNewUser = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", saveNewUserOption);
		saveNewUser.click();

	}

	// Click on Save New User Button
	public void clickOnSaveNewUser() {

		// Click on Save New User Button
		this.clickSaveNewUserButton();

	}

	// Delete User

	public void clickDeleteOptionCreated() {
		WebElement previewLink = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", deleteUserOption2);
		previewLink.click();

	}

	// Delete User

	public void clickOnDeleteUserCreated() {

		// Delete User
		this.clickDeleteOptionCreated();

	}

	// edit User

	public void clickEditOptionCreated() {
		WebElement edit = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", editUserOption);
		edit.click();

	}

	// edit User
	public void clickOnEditUserCreated() {
		// edit User
		this.clickEditOptionCreated();

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

	public Boolean isUsersPageTitlePresent() {
		return this.driverManager.isElementPresentByXpath( usersPageTitle);
	}

	public void clickOnCrafterLogo() {
		WebElement crafterLogoWebElement = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed( "xpath", crafterLogo);
		crafterLogoWebElement.click();

	}

}