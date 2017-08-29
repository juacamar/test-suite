/**
 * 
 */
package org.craftercms.studio.test.cases.complexscenariostestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author luishernandez
 *
 */
public class Crafter3LoadTest1Script {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private UIElementsPropertiesManager UIElementsPropertiesManager;
	private HomePage homePage;
	private DashboardPage dashboardPage;

	private String parentFolderName;
	private String harnessFolderName;
	private String emptyFolderName;
	private String bigTree1FolderName;
	private String bigTree2FolderName;
	private String myTestFolderName;
	private String anotherTestFolderName;
	private String parentFolderLocator;
	private String harnessFolderLocator;
	private String emptyFolderLocator;
	private String bigTree1FolderLocator;
	private String bigTree2FolderLocator;
	private String parentFolderDivOnTreeSelectorLocator;
	private String mytestFolderLocator;
	private String anotherTestFolderLocator;
	private String bigTree1FolderDivOnSelectorXPath;
	private String bigTree2BigTree1ChildFolderLocator;
	private String myTestBigTreeChildFolderLocator;
	private String anotherTestBigTreeChildFolderLocator;
	private String styleLocator;
	private String entertainmentLocator;
	private String healthLocator;
	private String technologyLocator;

	private WebElement harnessFolder;
	private WebElement emptyFolder;
	private WebElement bigTree1Folder;
	private WebElement bigTree2Folder;
	private WebElement myTestFolder;
	private WebElement anotherTestFolder;
	private WebElement bigTree2BigTree1ChildFolder;

	@BeforeMethod
	public void beforeTest() {
		this.driverManager = new WebDriverManager();

		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager);

		this.parentFolderName = "tester-" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		this.harnessFolderName = "harness";
		this.emptyFolderName = "empty-folder";
		this.bigTree1FolderName = "big-tree1";
		this.bigTree2FolderName = "big-tree2";
		this.myTestFolderName = "mytest";
		this.anotherTestFolderName = "anothertest";

		this.parentFolderLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.parentfolder") + this.parentFolderName + "')]";
		harnessFolderLocator = this.parentFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.harnessFolderName + "')]";
		emptyFolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.emptyFolderName + "')]";
		bigTree1FolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.bigTree1FolderName + "')]";
		bigTree2FolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.bigTree2FolderName + "')]";
		mytestFolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.myTestFolderName + "')]";
		anotherTestFolderLocator = harnessFolderLocator + UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.childfolder") + this.anotherTestFolderName + "')]";
		parentFolderDivOnTreeSelectorLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("dashboard.parentfolderdivontreeselector");
		styleLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.stylecontentpage");
		entertainmentLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.entertaimentcontentpage");
		healthLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.healthcontentpage");
		technologyLocator = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.crafter3loadtest.technologycontentpage");

	}

	@AfterMethod
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void createFolderOnAPresentFolder(String folderName, WebElement Parent) {
		// Right click and click on New Folder option
		dashboardPage.rightClickNewFolderOnAPresentFolder(Parent);
		// Set the name of the folder
		dashboardPage.setFolderName(folderName);
		// Create folder button
		dashboardPage.clickCreateButton();

	}

	public void createFolderOnHome(String folderName) {
		// right click to see the the menu
		dashboardPage.rightClickToFolderOnHome();
		// Set the name of the folder
		dashboardPage.setFolderName(folderName);
		// Create folder button
		dashboardPage.clickCreateButton();
	}

	public void loginAndGoToSiteContentPagesStructure() {
		// login to application
		loginPage.loginToCrafter("admin", "admin");
		// wait for element
		homePage.getDriverManager().driverWait();
		// go to preview page
		homePage.goToPreviewPage();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// reload page
		driverManager.getDriver().navigate().refresh();
		driverManager.setImplicitlyWaitTimeForFindElements();
		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
	}

	public void prepareTestArea() {
		// Create the parent folder on Home Step1 of Test Case
		this.createFolderOnHome(parentFolderName);
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait();

		driverManager.setImplicitlyWaitTimeForFindElements();

		// Checking if parent folder is present
		AssertJUnit.assertTrue(driverManager.isElementPresentByXpath(parentFolderLocator));
		this.driverManager.driverWait();
		WebElement parentFolder = dashboardPage.getDriverManager().getDriver()
				.findElement(By.xpath(parentFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(harnessFolderName, parentFolder);
		this.driverManager.driverWait();
		harnessFolder = driverManager.getDriver().findElement(By.xpath(harnessFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(emptyFolderName, harnessFolder);
		this.driverManager.driverWait();
		emptyFolder = driverManager.getDriver().findElement(By.xpath(emptyFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree1FolderName, harnessFolder);
		this.driverManager.driverWait();
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree2FolderName, harnessFolder);
		this.driverManager.driverWait();
		bigTree2Folder = driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));

		this.driverManager.driverWait();
		WebElement styleCategoryLandingStyle = driverManager.getDriver().findElement(By.xpath(styleLocator));
		dashboardPage.rightClickCopyContentPage(styleCategoryLandingStyle);
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		this.driverManager.driverWait();
		WebElement entertainmentCategoryLandingStyle = driverManager.getDriver()
				.findElement(By.xpath(entertainmentLocator));
		dashboardPage.rightClickCopyContentPage(entertainmentCategoryLandingStyle);
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		this.driverManager.driverWait();
		WebElement healthCategoryLandingStyle = driverManager.getDriver().findElement(By.xpath(healthLocator));
		dashboardPage.rightClickCopyContentPage(healthCategoryLandingStyle);
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		this.driverManager.driverWait();
		WebElement technologyCategoryLandingStyle = driverManager.getDriver().findElement(By.xpath(technologyLocator));
		dashboardPage.rightClickCopyContentPage(technologyCategoryLandingStyle);
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

	}

	public void createNewPageArticleContent() {

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait();
		// creating random values for URL field and InternalName field
		String randomURL = "newPageURL" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String randomInternalName = "newPageInternalName" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, "newPageArticlesTitle");
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// Set the title of main content
		driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");
		// click necessary to validate all fields required
		driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// save and close
		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();

	}

	public void createPageCategoryLandingPage(WebElement folderWebElement) {
		// right clicking and clikc on create New Content option
		dashboardPage.rightClickCreatePageOnAPresentFolder(folderWebElement);
		// selecting Page Category Landing Page
		dashboardPage.selectPageArticleContentType();
		// click on the Ok button to confirm the select content type above
		dashboardPage.clickOKButton();
		// creating new Page Article into the empty folder
		driverManager.getDriver().switchTo().defaultContent();
		this.createNewPageArticleContent();
	}

	public void editSelectedContent() {

		// switch to from
		dashboardPage.switchToAFormByCssSelector(".studio-ice-dialog > .bd iframe");
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Typing new text on title text field
		WebElement titleElement = driverManager.getDriver().findElement(By.cssSelector("#title > div > input"));
		// clear the input totally
		titleElement.clear();
		// set new value for title
		titleElement.sendKeys(RandomStringUtils.randomAlphabetic(5).toLowerCase());
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Save and close button.
		dashboardPage.clickSaveClose();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void compareTwoVersionsOfAContentPage() {

		dashboardPage.getDriverManager().driverWait();
		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Checking the first row version
		driverManager.getDriver().findElement(By
				.xpath(".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[1]/td/div/input"))
				.click();
		// Checking the second row version
		driverManager.getDriver().findElement(By
				.xpath(".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[2]/td/div/input"))
				.click();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// click on Compare button
		dashboardPage.clickCompareButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// switching to the compare frame
		driverManager.getDriver().switchTo().frame("diffDialog");
		// checkin if is present the removed-red-highlight text
		AssertJUnit.assertTrue(driverManager
				.isElementPresentByXpath(".//td[text()='title']/../td[2]/span[contains(@class,'diff-html-removed')]"));
		// checkin if is present the added-green-highlight text
		AssertJUnit.assertTrue(driverManager
				.isElementPresentByXpath(".//td[text()='title']/../td[2]/span[contains(@class,'diff-html-added')]"));
		// click on close button
		dashboardPage.clickCloseButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void revertLastVersionChanges() {
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Clickin the revert changes option for the initial version
		driverManager.getDriver().findElement(By.xpath(
				".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr/td[3]/div[text()='Initial commit.']/../../td[4]/div/a[3]"))
				.click();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Comparing first two versions of the content
		compareTwoVersionsOfAContentPage();
		// Click on close button
		dashboardPage.clickHistoryCloseButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void confirmPublishAction() {
		dashboardPage.getDriverManager().driverWait();
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void publishAllPagesOnAFolder(String folderLocator) {
		// getting the entire list of content pages on a folder
		List<WebElement> unpublishedContentPages = driverManager.getDriver()
				.findElements(By.xpath(folderLocator + "/../../../../../div[1]/div/table/tbody/tr/td/span"));

		for (WebElement element : unpublishedContentPages) {
			// right click to displays right click menu
			dashboardPage.rightClickOnAContentPage(element);
			// selecting the Publish option
			dashboardPage.clickOnPublishOption();
			// moving to the publish dialog, clicking on Submit and confirm action
			this.confirmPublishAction();
			// wait for element
			//dashboardPage.getDriverManager().driverWait();
		}

	}

	public void confirmDeleteAction() {
		dashboardPage.getDriverManager().driverWait();
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait();
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createMultipleContentPagesOnFolder() {
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait();

		// creating multiple content pages
		for (int count = 0; count < 1; count++) {
			// reload page
			driverManager.getDriver().navigate().refresh();
			dashboardPage.getDriverManager().driverWait();
			bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
			this.createPageCategoryLandingPage(bigTree1Folder);
		}
	}

	public void step1() {

		emptyFolder = driverManager.getDriver().findElement(By.xpath(emptyFolderLocator));

		// Step 1
		this.createPageCategoryLandingPage(emptyFolder);

		// creating multiple content pages on bigtree1
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		this.createMultipleContentPagesOnFolder();
	}

	public void step2() {
		// Step2 a)
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		// Step2 b)
		bigTree1FolderDivOnSelectorXPath = this.parentFolderDivOnTreeSelectorLocator + "/site/website/"
				+ parentFolderName + "/" + harnessFolderName + "/" + bigTree1FolderName + "']";
		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);
		dashboardPage.clickCopyButtonOnTreeSelector();

		// Step2 c)
		bigTree2Folder = driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree2Folder);

		bigTree2BigTree1ChildFolderLocator = bigTree2FolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step3() {
		harnessFolder = driverManager.getDriver().findElement(By.xpath(harnessFolderLocator));
		this.createFolderOnAPresentFolder(myTestFolderName, harnessFolder);
		// myTestFolder = driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
	}

	public void step4() {
		// Step4
		this.driverManager.driverWait();
		bigTree1Folder = driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);
		dashboardPage.clickCopyButtonOnTreeSelector();

		myTestFolder = driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
		dashboardPage.rightClickPasteOnAFolder(myTestFolder);

		myTestBigTreeChildFolderLocator = mytestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step5() {
		harnessFolder = driverManager.getDriver().findElement(By.xpath(harnessFolderLocator));
		this.createFolderOnAPresentFolder(anotherTestFolderName, harnessFolder);
		anotherTestFolder = driverManager.getDriver().findElement(By.xpath(anotherTestFolderLocator));
	}

	public void step6() {
		// Step6
		driverManager.setImplicitlyWaitTimeForFindElements();

		myTestFolder = driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
		dashboardPage.expandParentFolder(myTestFolder);

		WebElement myTestBigTreeChildFolder = driverManager.getDriver()
				.findElement(By.xpath(myTestBigTreeChildFolderLocator));
		dashboardPage.rightClickCutAFolder(myTestBigTreeChildFolder);

		anotherTestFolder = driverManager.getDriver().findElement(By.xpath(anotherTestFolderLocator));
		dashboardPage.rightClickPasteOnAFolder(anotherTestFolder);
		anotherTestBigTreeChildFolderLocator = anotherTestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step7() {
		// Step7 a)
		dashboardPage.clicOnHomeTree();
		dashboardPage.getDriverManager().driverWait();
		dashboardPage.clickOnContextualNavigationEditOption();
		dashboardPage.getDriverManager().driverWait();

		// Step7 b)
		this.editSelectedContent();
	}

	public void step8() {
		// Step8
		dashboardPage.getDriverManager().driverWait();
		dashboardPage.clickHomeTree();
		dashboardPage.clickOnContextualNavigationHistoryOption();
	}

	public void step9() {
		// Step9
		this.compareTwoVersionsOfAContentPage();
	}

	public void step10() {
		// Step10
		this.revertLastVersionChanges();
	}

	public void step11() {
		// Step11
		this.publishAllPagesOnAFolder(anotherTestBigTreeChildFolderLocator);

		bigTree2Folder = driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));
		dashboardPage.expandParentFolder(bigTree2Folder);

		bigTree2BigTree1ChildFolder = driverManager.getDriver()
				.findElement(By.xpath(bigTree2BigTree1ChildFolderLocator));
		dashboardPage.expandParentFolder(bigTree2BigTree1ChildFolder);

		this.publishAllPagesOnAFolder(bigTree2BigTree1ChildFolderLocator);
	}

	public void step12() {
		// Step12
		myTestFolder = driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
		dashboardPage.rightClickDeleteAFolder(myTestFolder);
		this.confirmDeleteAction();

		anotherTestFolder = driverManager.getDriver().findElement(By.xpath(anotherTestFolderLocator));
		dashboardPage.rightClickDeleteAFolder(anotherTestFolder);
		this.confirmDeleteAction();

		bigTree2BigTree1ChildFolder = driverManager.getDriver()
				.findElement(By.xpath(bigTree2BigTree1ChildFolderLocator));
		dashboardPage.rightClickDeleteAFolder(bigTree2BigTree1ChildFolder);
		this.confirmDeleteAction();
	}

	public void crafter3LoadTest() {
		// login and go to dashboard page, later open the content site (site
		// dropdown panel)
		this.loginAndGoToSiteContentPagesStructure();

		// expand pages folder
		dashboardPage.expandPagesTree();

		// create the folders structure according with script
		this.prepareTestArea();

		// expand pages folder
		// dashboardPage.expandPagesTree();

		// reload page
		driverManager.getDriver().navigate().refresh();
		dashboardPage.getDriverManager().driverWait();

		// Step1
		this.step1();

		// Step2
		this.step2();

		// Step3
		this.step3();

		// Step4
		this.step4();

		// Step5
		this.step5();

		// Step6
		this.step6();

		// Step7
		this.step7();

		// Step8
		this.step8();

		// Step9
		this.step9();

		// Step10
		this.step10();

		// Step11
		this.step11();

		// Step12
		this.step12();
	}

	@Test (priority=0, sequential = true)
	public void crafter3LoadTestTestUser1() {
		this.crafter3LoadTest();
	}
	
//	@Test (priority=1, sequential = true)
//	public void crafter3LoadTestTestUser2() {
//		this.crafter3LoadTest();
//	}
//	@Test (priority=2, sequential = true)
//	public void crafter3LoadTestTestUser3() {
//		this.crafter3LoadTest();
//	}
	
}
