package org.craftercms.studio.test.cases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AdminConsolePage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class CTInputTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private AdminConsolePage adminConsolePage;

	

	@BeforeClass
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.previewPage = new PreviewPage(driverManager, this.UIElementsPropertiesManager);
		this.adminConsolePage = new AdminConsolePage(driverManager, this.UIElementsPropertiesManager);
	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void CT_Input() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element

		homePage.getDriverManager().driverWait();

		// go to admin console page

		previewPage.goToAdminConsolePage();

		// wait for element

		homePage.getDriverManager().driverWait();

		// select content types
		adminConsolePage.selectContentTypeOption();

		// open content types

		adminConsolePage.clickExistingTypeOption();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Select the generic content type
		adminConsolePage.selectGenericContentType();

		// Confirm the content type selected

		adminConsolePage.confirmContentTypeSelected();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Drag and drop Form Section

		driverManager.getDriver().manage().window().maximize();

		driverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement From = driverManager.getDriver().findElement(By.cssSelector(".control-section"));

		WebElement To = driverManager.getDriver()
				.findElement(By.cssSelector("#content-type-canvas .content-form-name"));

		Actions builder = new Actions(driverManager.getDriver());

		Action dragAndDrop = builder.clickAndHold(From)

		.moveToElement(To)

		.release(To)

		.build();

		dragAndDrop.perform();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Drag and drop Input

		driverManager.getDriver().manage().window().maximize();

		driverManager.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement FromInput = driverManager.getDriver()
				.findElement(By.cssSelector("#content-type-tools .control:nth-child(3)"));

		WebElement ToDefaultSection = driverManager.getDriver().findElement(
				By.cssSelector("#content-type-canvas .content-type-visual-section-container:nth-child(3)"));

		Action dragAndDropInput = builder.clickAndHold(FromInput)

		.moveToElement(ToDefaultSection)

		.release(ToDefaultSection)

		.build();

		dragAndDropInput.perform();

		// Complete the input fields basics

		adminConsolePage.CompleteInputFieldsBasics("TestTitle", "TestICEGroup", "TestDescription", "TestDefaultValue");

		// Save the data

		adminConsolePage.saveDragAndDropProcess();

		// Ok for the dialog window when appears

//		new WebDriverWait(driverManager.getDriver(), 10).until(ExpectedConditions.alertIsPresent());
//		driverManager.getDriver().switchTo().alert().accept();

		// open content types

		adminConsolePage.clickExistingTypeOption();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Select the generic content type

		driverManager.getDriver().findElement(By.id("wcm-content-types-dropdown")).sendKeys(Keys.DOWN);
		driverManager.getDriver().findElement(By.id("wcm-content-types-dropdown")).sendKeys(Keys.DOWN);

		// Confirm the content type selected

		adminConsolePage.confirmContentTypeSelected();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Click on input section to can view the properties

		adminConsolePage.clickInputSection();

		// Asserts that fields are not empty.

		String bodyText = driverManager.getDriver().findElement(By.cssSelector("#properties-container .no-update"))
				.getText();
		Assert.assertNotNull(bodyText.contains(bodyText));

	}

}
