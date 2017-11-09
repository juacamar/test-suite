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

	private String navigationPageItem;

	private String floatingPageItem;

	private String componentItem;

	private String templateScriptItem;

	private String taxonomyItem;

	private String imageItem;

	private String videoItem;

	private String cssItem;

	private String fontItem;

	private String pdfItem;

	private String msPowerPointItem;

	private String msWordItem;

	private String msExcelItem;

	private String zipItem;

	private String groovyItem;

	private String otherItem;

	private String itemsTypePanel;

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
		navigationPageItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.navigationpage");
		floatingPageItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.floatingpage");
		componentItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.component");
		templateScriptItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.templatescript");
		taxonomyItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.taxonomy");
		imageItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.image");
		videoItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.video");
		cssItem = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.workflowpanel.css");
		fontItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.font");
		pdfItem = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.workflowpanel.pdf");
		msPowerPointItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.mspowerpoint");
		msWordItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.msword");
		msExcelItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.msexcel");
		zipItem = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("dashboard.workflowpanel.Zip");
		groovyItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.Groovy");
		otherItem = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.workflowpanel.Other");
		itemsTypePanel = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.itemtypespanel");

	}

	@AfterClass
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void verifyAllItemTypesOnIconGuide() {

		// Assert Item Types tittle is present.

		WebElement itemTypes = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				itemsTypePanel);
		Assert.assertTrue(itemTypes.isDisplayed());

		// Assert navigation page is present.
		WebElement navigationPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				navigationPageItem);
		Assert.assertTrue(navigationPage.isDisplayed());

		// Assert floating page is present.
		WebElement floatingPage = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				floatingPageItem);
		Assert.assertTrue(floatingPage.isDisplayed());

		// Assert component is present.
		WebElement component = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", componentItem);
		Assert.assertTrue(component.isDisplayed());

		// Assert template is present.
		WebElement template = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				templateScriptItem);
		Assert.assertTrue(template.isDisplayed());

		// Assert taxonomy is present.
		WebElement taxonomy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", taxonomyItem);
		Assert.assertTrue(taxonomy.isDisplayed());

		// Assert iamge is present.
		WebElement image = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", imageItem);
		Assert.assertTrue(image.isDisplayed());

		// Assert css is present.
		WebElement video = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", videoItem);
		Assert.assertTrue(video.isDisplayed());

		// Assert css is present.
		WebElement css = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", cssItem);
		Assert.assertTrue(css.isDisplayed());

		// Assert Font for edit is present.
		WebElement font = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", fontItem);
		Assert.assertTrue(font.isDisplayed());

		// Assert pdf is present.
		WebElement pdf = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", pdfItem);
		Assert.assertTrue(pdf.isDisplayed());

		// Assert MS Power Point for edit is present.
		WebElement msPowerPoint = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				msPowerPointItem);
		Assert.assertTrue(msPowerPoint.isDisplayed());

		// Assert MS Word is present.
		WebElement msWord = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", msWordItem);
		Assert.assertTrue(msWord.isDisplayed());

		// Assert MS Excel for edit is present.
		WebElement msExcel = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", msExcelItem);
		Assert.assertTrue(msExcel.isDisplayed());

		// Assert zip is present.
		WebElement zip = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", zipItem);
		Assert.assertTrue(zip.isDisplayed());

		// Assert zip is present.
		WebElement groovy = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", groovyItem);
		Assert.assertTrue(groovy.isDisplayed());

		// Assert other is present.
		WebElement other = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", otherItem);
		Assert.assertTrue(other.isDisplayed());

	}

	@Test(priority = 0)

	public void verifyAllItemTypesOnIconGuideTest() {

		// login to application

		loginPage.loginToCrafter(userName, password);

		// go to dashboard page
		homePage.goToDashboardPage();
		
		this.verifyAllItemTypesOnIconGuide();

	}
}
