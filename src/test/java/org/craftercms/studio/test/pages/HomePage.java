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

public class HomePage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String previewSite1;
	private String dashboardSite2;
	private String editRecentActivity;
	private String seeThePageEdited;
	private String createSiteButton;
	private String deleteSiteIcon;
	private String yesDeleteButton;
	private String logOutLink;
	private String signOutLink;

	/**
	 * 
	 */
	public HomePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.create_site_button");
		previewSite1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.preview_link");
		dashboardSite2 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.dashboard_link");
		editRecentActivity = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.edit_my_recent_activty");
		seeThePageEdited = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.see_page_recent_activity");
		createSiteButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.create_site_button");
		deleteSiteIcon = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.delete_site_icon");
		yesDeleteButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.confirm_to_delete");
		logOutLink = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.expand_account");
		signOutLink = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.sign_out");
				
				

	}

	// Click on preview link

	public HomePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void clickPreviewOption() {

		WebElement previewLink = driverManager.getDriver().findElement(By.xpath(previewSite1));
		previewLink.click();

	}

	public void goToPreviewPage() {

		// Click on preview link

		this.clickPreviewOption();

	}

	// Click on dashboard link

	public void clickDashboardOption() {

		WebElement dashboardLink = driver.findElement(By.cssSelector(dashboardSite2));
		dashboardLink.click();

	}

	public void goToDashboardPage() {

		// Click on dashboard link

		this.clickDashboardOption();

	}

	// Click on edit option of my recent activity senction

	public void clickEditOptionOfRecentActivitySection() {

		WebElement editOptionMyRecentActivity = driver.findElement(By.xpath(editRecentActivity));
		editOptionMyRecentActivity.click();

	}

	public void clickOnEditOptionRecentActivity() {

		// Click on edit option of my recent activity senction

		this.clickEditOptionOfRecentActivitySection();

	}

	// See the page edited

	public void DisplayPageEdited() {

		WebElement seeThePageMyRecentActivity = driver.findElement(By.xpath(seeThePageEdited));
		seeThePageMyRecentActivity.click();

	}

	public void SeeThePageEdited() {

		// See the page edited

		this.DisplayPageEdited();

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

	// Click on Create Site button

	public void clickCreateSiteButton() {

		WebElement createSiteOption = driver.findElement(By.cssSelector(createSiteButton));
		createSiteOption.click();

	}

	public void clickOnCreateSiteButton() {

		// Click on Create Site button

		this.clickCreateSiteButton();

	}

	// Click on Delete icon to the site

	public void clickDeleteSiteIcon() {

		WebElement deleteIcon = driver.findElement(By.cssSelector(deleteSiteIcon));
		deleteIcon.click();

	}

	public void clickOnDeleteSiteIcon() {

		// Click on Delete icon to the site

		this.clickDeleteSiteIcon();

	}

	// Click on YES button

	public void clickYesButton() {

		WebElement yesButton = driver.findElement(By.cssSelector(yesDeleteButton));
		yesButton.click();

	}

	public void clickOnYesToDeleteSite() {

		// Click on YES button

		this.clickYesButton();

	}
	
	// Logout to the crafter

		public void ExpandAccount() {

			WebElement expandAccount = driver.findElement(By.cssSelector(logOutLink));
			expandAccount.click();
			
		}
		
		public void clickSignOut() {

			
			WebElement signOut = driver.findElement(By.cssSelector(signOutLink));
			signOut.click();

		}

		public void clickLogoutOutCrafter() {

			//Expand account

			this.ExpandAccount();
			
			//Click on SignOut
			
			this.clickSignOut();
			

		}

	public String getHomePageDashboardUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}