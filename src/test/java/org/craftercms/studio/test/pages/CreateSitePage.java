package org.craftercms.studio.test.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CreateSitePage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String siteName;
	private String siteID;
	private String descriptionSite;
	private String blueprintCombo;
	private String plutonBlueprint;
	private String createSiteButton;
	private String cancelButton;
	private String corporateBlueprint;
	private String AngMemGamBlueprint;
	private String usersOption;
	private String helpOption;
	private String aboutOption;
	private String documentationOption;
	private String adminDropdownOption;
	private String settingsOption;


	/**
	 * 
	 */
	public CreateSitePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		
		siteName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.site_name");
		siteID = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.id_name");
		descriptionSite = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.description_site");
		blueprintCombo = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.blueprint_combo");
		plutonBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.pluton_blueprint");
		createSiteButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.create_button");
		cancelButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.cancel_button");
		corporateBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.corporate_blueprint");
		AngMemGamBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.ang_mem_gam_blueprint");
		usersOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.users_option");
		helpOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create_help_option");
		aboutOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create_about_option");
		documentationOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create_documentation_option");
		adminDropdownOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create_admin_dropdown_option");
		settingsOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create_settings_option");
	}

	public CreateSitePage(WebDriver driver) {

		this.driver = driver;

	}

	// Set site name

	public void setSiteName() {
		WebElement nameNewSite = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				siteName);
		nameNewSite.sendKeys("testsite" + RandomStringUtils.randomAlphabetic(5).toLowerCase());

	}

	public void fillSiteName() {

		// Set site name

		this.setSiteName();

	}

	// Set site ID

	public void setSiteId(String strSiteID) {
		WebElement idSite = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", siteID);
		// driver.findElement(By.cssSelector(siteID));
		idSite.sendKeys(strSiteID);

	}

	public void fillIdSite(String strSiteID) {

		// Set site ID

		this.setSiteId(strSiteID);

	}

	// Set description

	public void setDescription(String strDescription) {

		WebElement description = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				descriptionSite);
		// driver.findElement(By.cssSelector(descriptionSite));
		description.sendKeys(strDescription);

	}

	public void fillDescription(String strDescription) {

		// Set description

		this.setDescription(strDescription);

	}

	// Open blueprint combo

	public void blueprintCombo() {

		WebElement comboBlueprint = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				blueprintCombo);
		// driver.findElement(By.cssSelector(blueprintCombo));
		comboBlueprint.click();

	}

	public void openBlueprintCombo() {

		// Open blueprint combo

		this.blueprintCombo();

	}

	// select blue pluton print

	public void plutonBlueprint() {

		WebElement blueprintPluton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				plutonBlueprint);
		// driver.findElement(By.xpath(plutonBlueprint));

		blueprintPluton.click();

	}

	public void selectPlutonBlueprint() {

		// select blue pluton print

		this.plutonBlueprint();

	}

	// select blue empty print

	public void selectEmptyBlueprint() {

		WebElement bluePrintCombo =  this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id",
				"blueprint");
				//driver.findElement(By.id("blueprint"));
		Select select = new Select(bluePrintCombo);
		select.selectByVisibleText("Empty");

	}

	public void selectEmptyBluePrintOption() {

		// select blue empty print

		this.selectEmptyBlueprint();

	}

	// select blue corporate print

	public void corporateBlueprint() {

		WebElement blueprintCorporate =  this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				corporateBlueprint);
				//driver.findElement(By.xpath(corporateBlueprint));
		blueprintCorporate.click();

	}

	public void selectComporateBlueprint() {

		// select blue corporate print

		this.corporateBlueprint();

	}

	// select blue angular memory game print

	public void angMemGamBlueprint() {
		
		WebElement blueprintCorporate = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath",
				AngMemGamBlueprint);
				//driver.findElement(By.xpath(AngMemGamBlueprint));
		blueprintCorporate.click();
	}

	public void selectAngMemGamBlueprint() {

		// select blue angular memory game print

		this.angMemGamBlueprint();

	}

	// Press on create site

	public void createButton() {
		
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				createSiteButton);
				//driver.findElement(By.cssSelector(createSiteButton));
		createButton.click();

	}

	public void clickOnCreateSiteButton() {

		// Press on create site

		this.createButton();

	}

	// Press on users option

	public void usersOption() {
		this.driverManager.isElementPresentAndClickableByXpath(usersOption);
		WebElement users = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "xpath",
				usersOption);
		users.click();

	}

	public void clickOnUsersOption() {

		// Press on users option

		this.usersOption();

	}

	// Press on Cancel button of the create site process.

	public void cancelButton() {
		
		WebElement createButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				cancelButton);
				//driver.findElement(By.cssSelector(cancelButton));
		createButton.click();

	}

	public void clickOnCancelButtonOfTheCreateSiteProcess() {

		// Press on Cancel button of the create site.

		this.cancelButton();

	}

	// Press on help option

	public void clickHelp() {
		this.driverManager.isElementPresentAndClickableById(helpOption);
		WebElement users = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "id",
				helpOption);
				//driver.findElement(By.cssSelector(helpOption));
		users.click();

	}

	public void clickOnHelpOption() {

		// Press on help option

		this.clickHelp();

	}

	// Press on about option

	public void clickAbout() {
		
		WebElement about = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				aboutOption);
				//driver.findElement(By.cssSelector(aboutOption));
		about.click();

	}

	public void clickOnAboutOption() {

		// Press on about option

		this.clickAbout();

	}

	// Press on documentation option

	public void clickDocumentation() {
		
		WebElement documentation = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				documentationOption);
				//driver.findElement(By.cssSelector(documentationOption));
		documentation.click();

	}

	public void clickOnDocumentationOption() {

		// Press on documentation option

		this.clickDocumentation();

	}

	// Press on admin option

	public void clickAdmin() {
		this.driverManager.isElementPresentAndClickableByXpath( adminDropdownOption);
		WebElement admin = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				adminDropdownOption);
				//driver.findElement(By.cssSelector(adminDropdownOption));
		admin.click();

	}

	public void clickOnAdminOption() {

		// Press on admin option

		this.clickAdmin();

	}

	// Press on settings option

	public void clickSettings() {
		this.driverManager.isElementPresentAndClickableBycssSelector( settingsOption);
		WebElement settings = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				settingsOption);
				//driver.findElement(By.cssSelector(settingsOption));
		settings.click();

	}

	public void clickOnSettingsOption() {

		// Press on settings option

		this.clickSettings();

	}

	public void createRandomSite() {
		// Filling the name of site
		this.fillSiteName();
		// Filling the description of the site
		this.fillDescription("Description");
		// Open blueprint combo
		// this.openBlueprintCombo();
		// Select empty blueprint
		this.selectEmptyBlueprint();
		// Click on Create button
		this.clickOnCreateSiteButton();
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

	public void selectWebSiteEditorialBluePrintOption() {
		// select blue corporate print
		this.selectWebSiteEditorialBluePrint();

	}

	private void selectWebSiteEditorialBluePrint() {
		
		WebElement bluePrintCombo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id",
				"blueprint");
				
		Select select = new Select(bluePrintCombo);
		select.selectByVisibleText("Website_editorial");
	}

}