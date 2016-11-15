package org.craftercms.studio.test.pages;

import java.util.concurrent.TimeUnit;

import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
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

public class CreatePage {

	private WebDriverManager driverManager;
    private UIElementsPropertiesManager uIElementsManager;
    private WebDriver driver;
	private String siteName;
	private String siteID;
	private String descriptionSite;
	private String blueprintCombo;
	private String plutonBlueprint;
	private String createSiteButton;
	private String cancelButton;

    /**
     * 
     */
    public CreatePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.uIElementsManager = UIElementsPropertiesManager;
        this.driver = this.driverManager.getDriver();
        siteName = uIElementsManager.getSharedUIElementsLocators().getProperty("create.site_name");
        siteID = uIElementsManager.getSharedUIElementsLocators().getProperty("create.id_name");
        descriptionSite = uIElementsManager.getSharedUIElementsLocators().getProperty("create.description_site");
        blueprintCombo = uIElementsManager.getSharedUIElementsLocators().getProperty("create.blueprint_combo");
        plutonBlueprint = uIElementsManager.getSharedUIElementsLocators().getProperty("create.pluton_blueprint");
        createSiteButton = uIElementsManager.getSharedUIElementsLocators().getProperty("create.create_button");
        cancelButton = uIElementsManager.getSharedUIElementsLocators().getProperty("create.cancel_button");

        
 
    }
	public CreatePage(WebDriver driver) {

		this.driver = driver;

	}
    
   // Set site name

	public void setSiteName(String strSiteName) {

		WebElement nameNewSite = driver.findElement(By.cssSelector(siteName));
		nameNewSite.sendKeys(strSiteName);

	}

	public void fillSiteName(String strSiteName) {

		// Set site name

		this.setSiteName(strSiteName);

	}

 	// Set site ID 

 	public void setSiteId(String strSiteID) {

 		 WebElement idSite = driver.findElement(By.cssSelector(siteID));
 		idSite.sendKeys(strSiteID);

 	}
 	
 	public void fillIdSite(String strSiteID){
 		
 		// Set site ID 
 		
 		this.setSiteId(strSiteID);
 		
 	}
 	
	// Set description 

 	public void setDescription(String strDescription) {

 		 WebElement description = driver.findElement(By.cssSelector(descriptionSite));
 		description.sendKeys(strDescription);

 	}
 	
	public void fillDescription(String strDescription){
 		
 		// Set description
 		
 		this.setDescription(strDescription);
 		
 	}
	
	// Open blueprint combo

 	public void BlueprintCombo() {

 		 WebElement comboBlueprint = driver.findElement(By.cssSelector(blueprintCombo));
 		comboBlueprint.click();

 	}
 	
	public void openBlueprintCombo(){
 		
 		// Open blueprint combo
 		
 		this.BlueprintCombo();
 		
 	}
	
	// select blue pluton print

	 	public void PlutonBlueprint() {

	 		 WebElement blueprintPluton = driver.findElement(By.xpath(plutonBlueprint));
	 		 
	 		blueprintPluton.click();

	 	}
	 	
		public void selectPlutonBlueprint(){
	 		
			// select blue pluton print
	 		
	 		this.PlutonBlueprint();
	 		
	 	}

		// Press on create site

	 	public void CreateButton() {

	 		 WebElement createButton = driver.findElement(By.cssSelector(createSiteButton));
	 		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 		createButton.click();
	 		

	 	}
	 	
		public void clickOnCreateSiteButton(){
	 		
			
			// Press on create site
	 		
	 		this.CreateButton();
	 		
	 	}
		
		// Press on Cancel button of the create site process.

	 	public void CancelButton() {

	 		 WebElement createButton = driver.findElement(By.xpath(cancelButton));
	 		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 		createButton.click();
	 		

	 	}
	 	
		public void clickOnCancelButtonOfTheCreateSiteProcess(){
	 		
			
			// Press on Cancel button of the create site.
	 		
	 		this.CancelButton();
	 		
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