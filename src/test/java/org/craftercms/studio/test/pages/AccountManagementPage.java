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

public class AccountManagementPage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String currentPassword;
	private String newPassword;
	private String confirmPassword;
	private String submitButton;

	/**
	 * 
	 */
	public AccountManagementPage(WebDriverManager driverManager,
			UIElementsPropertiesManager UIElementsPropertiesManager) {

		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		currentPassword = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("accountManagement.currentPass");
		newPassword = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("accountManagement.newPass");
		confirmPassword = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("accountManagement.confirmPass");
		submitButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("accountManagement.submitButton");
	}

	public AccountManagementPage(WebDriver driver) {

		this.driver = driver;

	}

	// Set the current pass

	public void setCurrentPassword(String strCurrentPass) {

		WebElement currentPass = driver.findElement(By.cssSelector(currentPassword));
		currentPass.sendKeys(strCurrentPass);

	}

	// Set the new pass

	public void setNewPassword(String strNewPassword) {

		WebElement newPass = driver.findElement(By.id(newPassword));
		newPass.sendKeys(strNewPassword);

	}

	// Set the new pass confirmation

	public void setConfirmNewPassword(String strConfNewPassword) {

		WebElement confPass = driver.findElement(By.id(confirmPassword));
		confPass.sendKeys(strConfNewPassword);

	}

	// Click on submit

	public void clickSubmit() {

		WebElement submitbtn = driver.findElement(By.cssSelector(submitButton));
		submitbtn.click();

	}

	// change the password
	public void changeUserPassword(String strCurrentPass, String strNewPassword, String strConfNewPassword) {

		// Fill current pass

		this.setCurrentPassword(strCurrentPass);

		// Fill new pass

		this.setNewPassword(strNewPassword);
		
		// confirm new pass
		
		this.setConfirmNewPassword(strConfNewPassword);

		// Click Login button

		this.clickSubmit();

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