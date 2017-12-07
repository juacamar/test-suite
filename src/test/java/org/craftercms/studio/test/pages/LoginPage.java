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

public class LoginPage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String userNameXpath;
	private String passwordXpath;
	private String loginXpath;
	private String sitesTitleXpath;
	
	public LoginPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driverManager.openConnection();
		this.driver = this.driverManager.getDriver();
		
		userNameXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("login.username");
		passwordXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("login.password");
		loginXpath = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("login.login");
		sitesTitleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("sites.pagetitle");
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Set user name in textbox
	public void setUserName(String strUserName) {
		WebElement userCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", userNameXpath);
		userCrafter.clear();
		userCrafter.sendKeys(strUserName);
	}

	// Set password in password textbox
	public void setPassword(String strPassword) {
		WebElement pwdCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", passwordXpath);
		pwdCrafter.clear();
		pwdCrafter.sendKeys(strPassword);

	}

	// Click on login button
	public void clickLogin() {
		WebElement loginButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", loginXpath);
		loginButton.click();
	}

	// Login to crafter
	public void loginToCrafter(String strUserName, String strPasword) {
		// Fill user name
		this.setUserName(strUserName);
		// Fill password
		this.setPassword(strPasword);
		// Click Login button
		this.clickLogin();
		
		this.driverManager.isElementPresentAndClickableByXpath(sitesTitleXpath);
		this.driverManager.waitUntilPageLoad();

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