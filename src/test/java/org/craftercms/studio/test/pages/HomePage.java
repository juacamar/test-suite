package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
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
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;
	private String homePageUserName;
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
		this.uIElementsManager = UIElementsPropertiesManager;
		this.driver = this.driverManager.getDriver();
		homePageUserName = uIElementsManager.getSharedUIElementsLocators().getProperty("home.create_site_button");
		previewSite1 = uIElementsManager.getSharedUIElementsLocators().getProperty("home.preview_link");
		dashboardSite2 = uIElementsManager.getSharedUIElementsLocators().getProperty("home.dashboard_link");
		editRecentActivity = uIElementsManager.getSharedUIElementsLocators().getProperty("home.edit_my_recent_activty");
		seeThePageEdited = uIElementsManager.getSharedUIElementsLocators().getProperty("home.see_page_recent_activity");
		createSiteButton = uIElementsManager.getSharedUIElementsLocators().getProperty("home.create_site_button");
		deleteSiteIcon = uIElementsManager.getSharedUIElementsLocators().getProperty("home.delete_site_icon");
		yesDeleteButton = uIElementsManager.getSharedUIElementsLocators().getProperty("home.confirm_to_delete");
		logOutLink = uIElementsManager.getSharedUIElementsLocators().getProperty("home.expand_account");
		signOutLink = uIElementsManager.getSharedUIElementsLocators().getProperty("home.sign_out");
				
				

	}

	// Click on preview link

	public HomePage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void ClickPreviewOption() {

		WebElement previewLink = driverManager.getDriver().findElement(By.xpath(previewSite1));
		previewLink.click();

	}

	public void GoToPreviewPage() {

		// Click on preview link

		this.ClickPreviewOption();

	}

	// Click on dashboard link

	public void ClickDashboardOption() {

		WebElement dashboardLink = driver.findElement(By.xpath(dashboardSite2));
		dashboardLink.click();

	}

	public void GoToDashboardPage() {

		// Click on dashboard link

		this.ClickDashboardOption();

	}

	// Click on edit option of my recent activity senction

	public void ClickEditOptionOfRecentActivitySection() {

		WebElement editOptionMyRecentActivity = driver.findElement(By.xpath(editRecentActivity));
		editOptionMyRecentActivity.click();

	}

	public void ClickOnEditOptionRecentActivity() {

		// Click on edit option of my recent activity senction

		this.ClickEditOptionOfRecentActivitySection();

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

	public void ClickCreateSiteButton() {

		WebElement createSiteOption = driver.findElement(By.cssSelector(createSiteButton));
		createSiteOption.click();

	}

	public void ClickOnCreateSiteButton() {

		// Click on Create Site button

		this.ClickCreateSiteButton();

	}

	// Click on Delete icon to the site

	public void ClickDeleteSiteIcon() {

		WebElement deleteIcon = driver.findElement(By.xpath(deleteSiteIcon));
		deleteIcon.click();

	}

	public void ClickOnDeleteSiteIcon() {

		// Click on Delete icon to the site

		this.ClickDeleteSiteIcon();

	}

	// Click on YES button

	public void ClickYesButton() {

		WebElement yesButton = driver.findElement(By.cssSelector(yesDeleteButton));
		yesButton.click();

	}

	public void ClickOnYesToDeleteSite() {

		// Click on YES button

		this.ClickYesButton();

	}
	
	// Logout to the crafter

		public void ExpandAccount() {

			WebElement expandAccount = driver.findElement(By.cssSelector(logOutLink));
			expandAccount.click();
			
		}
		
		public void ClickSignOut() {

			
			WebElement signOut = driver.findElement(By.xpath(signOutLink));
			signOut.click();

		}

		public void ClickLogoutOutCrafter() {

			//Expand account

			this.ExpandAccount();
			
			//Click on SignOut
			
			this.ClickSignOut();
			

		}

	public String getHomePageDashboardUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}