package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class CreateTreeSameContentTest {

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

	public void Create_Tree_Content_Test() {

		// login to application

		loginPage.loginToCrafter("admin", "1234");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to dashboard page

		homePage.GoToDashboardPage();

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

		dashboardPage.ExpandPagesTree();

		// expand global entry content

		dashboardPage.ClickGlobalEntryTree();

		// expand home content

		dashboardPage.ClickHomeTree();

		// Right click and copy content.

		dashboardPage.RightClickToCopyOptionAboutUs();

		// Right click and paste content.

		dashboardPage.RightClickToPasteOption();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Click on edit option of recent activity section
		homePage.ClickEditOptionOfRecentActivitySection();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element

		homePage.getDriverManager().driverWait();

		// edit internal name

		dashboardPage.editInternalName("TREE");

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

		// wait for element

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element

		homePage.getDriverManager().driverWait();

		// Right click and copy content.

		dashboardPage.RightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 1

		dashboardPage.RightClickToPasteToTheTree1();

		// Right click and copy content.

		dashboardPage.RightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 2

		dashboardPage.RightClickToPasteToTheTree2();

		// Right click and copy content.

		dashboardPage.RightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 3

		dashboardPage.RightClickToPasteToTheTree3();

		// Right click and copy content.

		dashboardPage.RightClickToCopyOptionAboutUsToTree();

		// Paste the about us to the tree 4

		dashboardPage.RightClickToPasteToTheTree4();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert of the tree created

		String contentCopied = driverManager.getDriver()
				.findElement(By.xpath("//tr/td[contains(span, 'About usTREE')]")).getText();
		Assert.assertEquals(contentCopied, "About usTREE *");
		
	}

}
