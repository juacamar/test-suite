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
	private String userNameTextBoxLocator;
	private String passwordTextBoxLocator;
	private String loginButtonLocator;
	private String sitesPageTitleLocator;
	

	/**
	 * 
	 */
	public LoginPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driverManager.openConnection();
		this.driver = this.driverManager.getDriver();
		
		userNameTextBoxLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("login.txtbox_UserName");
		passwordTextBoxLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("login.txtbox_Password");
		loginButtonLocator = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("login.btn_Login");
		sitesPageTitleLocator = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.sites.pagetitle");
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Set user name in textbox

	public void setUserName(String strUserName) {
		WebElement userCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", userNameTextBoxLocator);
				//driver.findElement(By.cssSelector(userNameTextBoxLocator));
		userCrafter.clear();
		userCrafter.sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {
		WebElement pwdCrafter = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", passwordTextBoxLocator);
				//driver.findElement(By.id(passwordTextBoxLocator));
		pwdCrafter.clear();
		pwdCrafter.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {
		WebElement loginButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", loginButtonLocator);
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
		
		this.driverManager.isElementPresentByXpath(sitesPageTitleLocator);

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