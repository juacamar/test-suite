package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AdminConsolePage;
import org.craftercms.studio.test.pages.DashboardPage;
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

public class DeleteOptionTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private AdminConsolePage adminConsolePage;

	private DashboardPage dashboardPage;

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
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	@Test(priority = 0)

	public void Delete_option() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		driverManager.maximizeWindow();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Expand Home Tree

		dashboardPage.expandHomeTree();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// create a content with level descriptor content type

		// right click to see the the menu

		WebElement home = driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel1"));

		Actions action = new Actions(driverManager.getDriver());
		action.contextClick(home).build().perform();

		WebElement addContent = driverManager.getDriver()
				.findElement(By.cssSelector("#ContextmenuWrapper0  ul li:nth-child(3)"));
		addContent.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select Entry Content Type

		dashboardPage.clickLevelDescriptorCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Set basics fields of the new content created

		dashboardPage.setFileName("Level");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select the content to delete.

		driverManager.getDriver().findElement(By.cssSelector("#ygtvcontentel3")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// click on delete option

		previewPage.clickOnDeleteOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on Delete dependencies

		previewPage.clickOnDeleteDependencies();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click nn OK Delete dependencies

		previewPage.clickOnOKDeleteDependencies();

		// wait for element is clickeable
		previewPage.getDriverManager().driverWait();

		
		driverManager.getDriver().findElement(By.id("cstudio-logo")).click();


		previewPage.getDriverManager().driverWait();

		String contentDelete = driverManager.getDriver().findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(1) > td:nth-child(4)"))
				.getText();
		Assert.assertEquals(contentDelete, "/level.html");

	}

}
