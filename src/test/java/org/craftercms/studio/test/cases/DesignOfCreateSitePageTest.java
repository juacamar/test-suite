package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.CreatePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class DesignOfCreateSitePageTest {

	WebDriver driver;

	LoginPage objLogin;

	HomePage objHomePage;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private CreatePage createPage;

	private PreviewPage previewPage;

	

	 @BeforeTest
	 public void beforeTest() {
	 this.driverManager = new WebDriverManager();
	 this.UIElementsPropertiesManager = new
	 org.craftercms.studio.test.utils.UIElementsPropertiesManager(
	 FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
	 this.constantsPropertiesManager = new
	 ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
	 this.loginPage = new LoginPage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.homePage = new HomePage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.createPage = new CreatePage(driverManager,
	 this.UIElementsPropertiesManager);
	 this.previewPage = new PreviewPage(driverManager,
	 this.UIElementsPropertiesManager);
	
	 }

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Design_of_create_site_page() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	    // Assert crafter studio logo is present.
		
	    WebElement logoCrafter = driverManager.getDriver().findElement(By.cssSelector(".navbar-brand > img"));
		  
		Assert.assertTrue(logoCrafter.isDisplayed());
	    
	    // Assert sites title is present.
	    
	    WebElement sitesLabel = driverManager.getDriver().findElement(By.cssSelector("h1.ng-binding"));
		  
		Assert.assertTrue(sitesLabel.isDisplayed());
	    
	    // Assert create button is present.
			    
	    WebElement createButton = driverManager.getDriver().findElement(By.cssSelector(".btn.btn-default.btn-pill.btn-block"));
		  
		Assert.assertTrue(createButton.isDisplayed());
		
        // Assert admin tools is present.
	    
	    WebElement adminTools = driverManager.getDriver().findElement(By.cssSelector(".nav > li:nth-child(1) > a:nth-child(1)"));
	    
		Assert.assertTrue(adminTools.isDisplayed());

	    // Assert sites option is present.
	    
	    WebElement sitesOption = driverManager.getDriver().findElement(By.cssSelector("li.active > a:nth-child(1)"));
		  
		Assert.assertTrue(sitesOption.isDisplayed());
	    
	    // Assert Help option is present.
	    
	    WebElement helpOption = driverManager.getDriver().findElement(By.cssSelector(".nav > li:nth-child(3) > a:nth-child(1)"));
		  
		Assert.assertTrue(helpOption.isDisplayed());
	    
	    // Assert account option is present.
	    
	    WebElement accountOption = driverManager.getDriver().findElement(By.cssSelector(".dropdown-toggle"));
		  
		Assert.assertTrue(accountOption.isDisplayed());
	    
	    // Assert all sites option is present.
	    
	    WebElement allSitesOption = driverManager.getDriver().findElement(By.cssSelector(".list-group-item"));
		  
		Assert.assertTrue(allSitesOption.isDisplayed());
	    
	    // Assert site name is present.
			    
	    WebElement siteName = driverManager.getDriver().findElement(By.cssSelector("th.ng-binding"));
		  
		Assert.assertTrue(siteName.isDisplayed());
	    
	    
	    
	}

}
