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
	private String usersContextualNavigationOption;

	/**
	 * 
	 */
	public HomePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		
		
		UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.create_site_button");
		previewSite1 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.preview_link");
		dashboardSite2 = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.dashboard_link");
		editRecentActivity = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.edit_my_recent_activty");
		seeThePageEdited = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.see_page_recent_activity");
		createSiteButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.create_site_button");
		deleteSiteIcon = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.delete_site_icon");
		yesDeleteButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.confirm_to_delete");
		logOutLink = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.expand_account");
		signOutLink = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("home.sign_out");
		usersContextualNavigationOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("home.userscontextualnavigationoption");

	}

	// Click on preview link

	public void clickPreviewOption() {
		WebElement previewLink = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				previewSite1);
		previewLink.click();

	}

	public void goToPreviewPage() {

		// Click on preview link

		this.clickPreviewOption();

	}

	// Click on dashboard link

	public void clickDashboardOption() {
		
		WebElement dashboardLink = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				dashboardSite2);
				//driver.findElement(By.cssSelector(dashboardSite2));
		dashboardLink.click();

	}

	public void goToDashboardPage() {

		// Click on dashboard
		this.clickDashboardOption();

	}

	// Click on edit option of my recent activity senction

	public void clickEditOptionOfRecentActivitySection() {
		
		WebElement editOptionMyRecentActivity = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				editRecentActivity);
				//driver.findElement(By.xpath(editRecentActivity));
		editOptionMyRecentActivity.click();

	}

	public void clickOnEditOptionRecentActivity() {

		// Click on edit option of my recent activity senction

		this.clickEditOptionOfRecentActivitySection();

	}

	// See the page edited

	public void displayPageEdited() {
		
		WebElement seeThePageMyRecentActivity = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				seeThePageEdited);
				//driver.findElement(By.xpath(seeThePageEdited));
		seeThePageMyRecentActivity.click();

	}

	public void seeThePageEdited() {

		// See the page edited

		this.displayPageEdited();

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
		
		this.driverManager.isElementPresentAndClickableByXpath(createSiteButton);
		WebElement createSiteOption =  this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				createSiteButton);
		createSiteOption.click();

	}

	public void clickOnCreateSiteButton() {

		// Click on Create Site button

		this.clickCreateSiteButton();

	}

	// Click on Delete icon to the site

		public void clickDeleteSiteIcon() {
        this.driverManager.isElementPresentAndClickableByXpath(deleteSiteIcon);
        WebElement deleteIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
                deleteSiteIcon);
        deleteIcon.click();

    }
	

	public void clickOnDeleteSiteIcon() {

		// Click on Delete icon to the site

		this.clickDeleteSiteIcon();

	}

	// Click on YES button

	public void clickYesButton() {
		
		WebElement yesButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				yesDeleteButton);
				//driver.findElement(By.cssSelector(yesDeleteButton));
		yesButton.click();

	}

	public void clickOnYesToDeleteSite() {

		// Click on YES button

		this.clickYesButton();

	}

	// Logout to the crafter

	public void expandAccount() {
		
		WebElement expandAccount =  this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				logOutLink);
				//driver.findElement(By.cssSelector(logOutLink));
		expandAccount.click();

	}

	public void clickSignOut() {
		
		WebElement signOut = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				signOutLink);
				//driver.findElement(By.cssSelector(signOutLink));
		signOut.click();

	}

	public void clickLogoutOutCrafter() {

		// Expand account

		this.expandAccount();

		// Click on SignOut

		this.clickSignOut();

	}

	public void clickUsersContextualNavigationOption() {
		
		WebElement usersContextualNavigationOptionWebElement =
				this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
						usersContextualNavigationOption);
				//driver
				//.findElement(By.xpath(usersContextualNavigationOption));
		usersContextualNavigationOptionWebElement.click();
	}

	public Boolean isUsersContextualNavigationOptionPresent() {
		
		return this.driverManager.isElementPresentByXpath(usersContextualNavigationOption);
	}

	public void deleteSite() {

		// Click on Delete icon
		this.clickOnDeleteSiteIcon();


		// Click on YES to confirm the delete.
		this.clickOnYesToDeleteSite();

	}
}