package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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

public class FilterShowRecentActivityTest {

	WebDriver driver;

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private UIElementsPropertiesManager UIElementsPropertiesManager;

	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;

	private PreviewPage previewPage;

	private DashboardPage dashboardPage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new org.craftercms.studio.test.utils.UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

	}

	 @AfterTest
	 public void afterTest() {
	 driverManager.closeConnection();
	 }

	@Test(priority = 0)

	public void Filter_Show_Recent_Activity_test() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.goToDashboardPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Show site content panel

		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// expand global entry content

		dashboardPage.clickGlobalEntryTree();

		// expand home content

		dashboardPage.clickHomeTree();

		// Right click and copy content.

		dashboardPage.rightClickToCopyOptionAboutUs();

		// Right click and paste content.

		dashboardPage.rightClickToPasteOption();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Click on edit option of recent activity section

		homePage.clickOnEditOptionRecentActivity();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		// edit internal name

		dashboardPage.editInternalName("Edit");

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// go to edit

		dashboardPage.goToEditIframe();

		// Switch to the iframe

		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Click on Edit page URL button

		dashboardPage.clickOnEditPageURLButton();

		// Ok for the dialog window when appears

		new WebDriverWait(driverManager.getDriver(), 10).until(ExpectedConditions.alertIsPresent());
		driverManager.getDriver().switchTo().alert().accept();

		// Set the new url

		dashboardPage.setNewPageURL("urledited");

		// wait for element

		homePage.getDriverManager().driverWait();

		// Save and close

		dashboardPage.clickSaveClose();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// clean filter

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm")).clear();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Show only 1 item edited

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm"))
				.sendKeys("1", Keys.ENTER);
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// Assert filter 1

		String edit1 = driverManager.getDriver()
				.findElement(By.xpath("/html/body/section/div/div[4]/div[2]/table/tbody/tr/td[4]")).getText();
		Assert.assertEquals(edit1, "/en");
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// clean filter

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm")).clear();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Show only 1 item edited

		driverManager.getDriver()
				.findElement(By.cssSelector("#widget-showitems-MyRecentActivity.form-control.input-sm"))
				.sendKeys("2", Keys.ENTER);
		
		// wait for element

		homePage.getDriverManager().driverWait();

		// Assert filter 1

		String edit2 = driverManager.getDriver()
				.findElement(By.cssSelector("#MyRecentActivity-tbody > tr:nth-child(2) > td:nth-child(4)")).getText();
		Assert.assertEquals(edit2, "/about-us");
	}

}
