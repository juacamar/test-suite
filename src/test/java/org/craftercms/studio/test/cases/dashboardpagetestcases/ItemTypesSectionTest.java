package org.craftercms.studio.test.cases.dashboardpagetestcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
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

public class ItemTypesSectionTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;
	
	private String userName;
	private String password;
	
	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		
		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);
	

		this.driverManager.setConstantsPropertiesManager(constantsPropertiesManager);
		
		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager);
		

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		
	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void assertsBlockOne() {

		// Assert Item Types tittle is present.

		WebElement itemTypes = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div.col-md-12.title > p");

		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div.col-md-12.title > p"));

		Assert.assertTrue(itemTypes.isDisplayed());

		// Assert Navigation Page icon is present.

		WebElement navigationPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(2) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(2) > div"));

		Assert.assertTrue(navigationPage.isDisplayed());

		// Assert video icon is present.

		WebElement video = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(8) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(8) > div"));

		Assert.assertTrue(video.isDisplayed());

		// Assert excel icon is present.

		WebElement excel = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(14) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(14) > div"));

		Assert.assertTrue(excel.isDisplayed());

		// Assert floating page icon is present.

		WebElement floatingPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(3) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(3) > div"));

		Assert.assertTrue(floatingPage.isDisplayed());

		// Assert css icon is present.

		WebElement css = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(9) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(9) > div"));

		Assert.assertTrue(css.isDisplayed());

		// Assert zip icon is present.

		WebElement zip = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(15) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(15) > div"));

		Assert.assertTrue(zip.isDisplayed());

		// Assert component icon is present.

		WebElement component = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(4) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(4) > div"));

		Assert.assertTrue(component.isDisplayed());

		// Assert font icon is present.

		WebElement font = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(10) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(10) > div"));

		Assert.assertTrue(font.isDisplayed());

		// Assert groovy icon is present.

		WebElement groovy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(16) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(16) > div"));

		Assert.assertTrue(groovy.isDisplayed());

		// Assert Template/Script icon is present.

		WebElement templateScript = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(5) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(5) > div"));

		Assert.assertTrue(templateScript.isDisplayed());

	}

	public void assertsBlockTwo() {
		// Assert pdf icon is present.

		WebElement pdf = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(11) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(11) > div"));

		Assert.assertTrue(pdf.isDisplayed());

		// Assert other files icon is present.

		WebElement otherFiles = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(17) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(17) > div"));

		Assert.assertTrue(otherFiles.isDisplayed());

		// Assert taxonomy icon is present.

		WebElement taxonomy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(6) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(6) > div"));

		Assert.assertTrue(taxonomy.isDisplayed());

		// Assert power point icon is present.

		WebElement powerPoint = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(12) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(12) > div"));

		Assert.assertTrue(powerPoint.isDisplayed());

		// Assert image icon is present.

		WebElement image = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(7) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(7) > div"));

		Assert.assertTrue(image.isDisplayed());

		// Assert word icon is present.

		WebElement word = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"#iconGuide > div.panel-body > div.row.item-types > div:nth-child(13) > div");
		// driverManager.getDriver().findElement(
		// By.cssSelector("#iconGuide > div.panel-body > div.row.item-types >
		// div:nth-child(13) > div"));

		Assert.assertTrue(word.isDisplayed());
	}

	@Test(priority = 0)

	public void itemTypes() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to dashboard page
		homePage.goToDashboardPage();

	}
}
