/**
 * 
 */
package org.craftercms.studio.test.cases.complexscenariostestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author luishernandez
 *
 */
public class Crafter3LoadTest1Script {

	private WebDriverManager driverManager;
	private LoginPage loginPage;
	private UIElementsPropertiesManager UIElementsPropertiesManager;
	private ConstantsPropertiesManager constantsPropertiesManager;

	private HomePage homePage;
	private DashboardPage dashboardPage;

	private String userName;
	private String password;
	private int defaultTimeOut;

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

		UIElementsPropertiesManager UIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		ConstantsPropertiesManager constantsPropertiesManager = new ConstantsPropertiesManager(
				FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.loginPage = new LoginPage(driverManager, this.UIElementsPropertiesManager,
				this.constantsPropertiesManager);
		this.homePage = new HomePage(driverManager, this.UIElementsPropertiesManager, this.constantsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, this.UIElementsPropertiesManager,
				this.constantsPropertiesManager);

		this.parentFolderName = "tester-" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		this.harnessFolderName = "harness";
		this.emptyFolderName = "empty-folder";
		this.bigTree1FolderName = "big-tree1";
		this.bigTree2FolderName = "big-tree2";
		this.myTestFolderName = "mytest";
		this.anotherTestFolderName = "anothertest";

		userName = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.username");
		password = constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.password");
		defaultTimeOut = Integer.parseInt(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

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
		loginPage.loginToCrafter(userName, password);
		// go to preview page
		homePage.goToPreviewPage();

		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(defaultTimeOut, siteDropdownElementXPath))
			this.driverManager
					.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", siteDropdownElementXPath)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");

	}

	public void prepareTestArea() {
		// Create the parent folder on Home Step1 of Test Case
		this.createFolderOnHome(parentFolderName);

		// Checking if parent folder is present
		Assert.assertTrue(driverManager.isElementPresentByXpath(12, parentFolderLocator));

		WebElement parentFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"xpath", parentFolderLocator);
		// dashboardPage.getDriverManager().getDriver()
		// .findElement(By.xpath(parentFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(harnessFolderName, parentFolder);

		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				harnessFolderLocator);

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(emptyFolderName, harnessFolder);

		emptyFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				emptyFolderLocator);

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree1FolderName, harnessFolder);

		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree2FolderName, harnessFolder);

		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree2FolderLocator);

		WebElement styleCategoryLandingStyle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", styleLocator);

		dashboardPage.rightClickCopyContentPage(styleCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		WebElement entertainmentCategoryLandingStyle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", entertainmentLocator);

		dashboardPage.rightClickCopyContentPage(entertainmentCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		WebElement healthCategoryLandingStyle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", healthLocator);

		dashboardPage.rightClickCopyContentPage(healthCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		WebElement technologyCategoryLandingStyle = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", technologyLocator);
		dashboardPage.rightClickCopyContentPage(technologyCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

	}

	public void createNewPageArticleContent() {

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				defaultTimeOut, "cssSelector", ".studio-ice-dialog > .bd iframe"));

		// creating random values for URL field and InternalName field
		String randomURL = "newPageURL" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String randomInternalName = "newPageInternalName" + RandomStringUtils.randomAlphabetic(5).toLowerCase();

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, "newPageArticlesTitle");

		// Set the title of main content
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");

		this.driverManager.scrollUp();
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "cssSelector", "#cstudio-form-expand-all")
				.click();

		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "id", "cstudioSaveAndClose")
				.click();

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

		// Typing new text on title text field
		WebElement titleElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"cssSelector", "#title > div > input");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input"));
		// clear the input totally
		titleElement.clear();
		// set new value for title
		titleElement.sendKeys(RandomStringUtils.randomAlphabetic(5).toLowerCase());

		// Save and close button.
		dashboardPage.clickSaveClose();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void compareTwoVersionsOfAContentPage() {

		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();

		// Checking the first row version
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
						".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[1]/td/div/input")
				.click();

		// Checking the second row version
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
						".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[2]/td/div/input")
				.click();

		// click on Compare button
		dashboardPage.clickCompareButton();
		// switching to the compare frame
		driverManager.getDriver().switchTo().frame("diffDialog");

		// checkin if is present the removed-red-highlight text
		Assert.assertTrue(driverManager.isElementPresentByXpath(4,
				".//td[text()='title']/../td[2]/span[contains(@class,'diff-html-removed')]"));

		// checkin if is present the added-green-highlight text
		Assert.assertTrue(driverManager.isElementPresentByXpath(4,
				".//td[text()='title']/../td[2]/span[contains(@class,'diff-html-added')]"));

		// click on close button
		dashboardPage.clickCloseButton();

		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void revertLastVersionChanges() {

		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();

		// Clickin the revert changes option for the initial version
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr/td[3]/div[text()='Initial commit.']/../../td[4]/div/a[3]")
				.click();

		// Comparing first two versions of the content
		compareTwoVersionsOfAContentPage();
		// Click on close button
		dashboardPage.clickHistoryCloseButton();
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void confirmPublishAction() {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();
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
		}

	}

	public void confirmDeleteAction() {
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createMultipleContentPagesOnFolder() {

		// creating multiple content pages
		for (int count = 0; count < 1; count++) {
			// reload page
			driverManager.getDriver().navigate().refresh();
			bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
					bigTree1FolderLocator);
			this.createPageCategoryLandingPage(bigTree1Folder);
		}
	}

	public void step1() {
		emptyFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				emptyFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(emptyFolderLocator));

		// Step 1
		this.createPageCategoryLandingPage(emptyFolder);

		// creating multiple content pages on bigtree1
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);
		this.createMultipleContentPagesOnFolder();
	}

	public void step2() {
		// Step2 a)
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		// Step2 b)
		bigTree1FolderDivOnSelectorXPath = this.parentFolderDivOnTreeSelectorLocator + "/site/website/"
				+ parentFolderName + "/" + harnessFolderName + "/" + bigTree1FolderName + "']";
		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);

		dashboardPage.clickCopyButtonOnTreeSelector();

		// Step2 c)
		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree2FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree2Folder);

		bigTree2BigTree1ChildFolderLocator = bigTree2FolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step3() {
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				harnessFolderLocator);
		this.createFolderOnAPresentFolder(myTestFolderName, harnessFolder);

	}

	public void step4() {
		// Step4
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree1FolderLocator);

		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);
		dashboardPage.clickCopyButtonOnTreeSelector();

		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				mytestFolderLocator);

		dashboardPage.rightClickPasteOnAFolder(myTestFolder);

		myTestBigTreeChildFolderLocator = mytestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step5() {
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				harnessFolderLocator);

		this.createFolderOnAPresentFolder(anotherTestFolderName, harnessFolder);
		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				anotherTestFolderLocator);

	}

	public void step6() {
		// Step6

		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				mytestFolderLocator);

		dashboardPage.expandParentFolder(myTestFolder);

		WebElement myTestBigTreeChildFolder = this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath", myTestBigTreeChildFolderLocator);

		dashboardPage.rightClickCutAFolder(myTestBigTreeChildFolder);

		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				anotherTestFolderLocator);

		dashboardPage.rightClickPasteOnAFolder(anotherTestFolder);

		anotherTestBigTreeChildFolderLocator = anotherTestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step7() {
		// Step7 a)
		dashboardPage.clicOnHomeTree();
		dashboardPage.clickOnContextualNavigationEditOption();

		// Step7 b)
		this.editSelectedContent();
	}

	public void step8() {
		// Step8
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

		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				bigTree2FolderLocator);

		dashboardPage.expandParentFolder(bigTree2Folder);

		bigTree2BigTree1ChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"xpath", bigTree2BigTree1ChildFolderLocator);
		dashboardPage.expandParentFolder(bigTree2BigTree1ChildFolder);

		this.publishAllPagesOnAFolder(bigTree2BigTree1ChildFolderLocator);
	}

	public void step12() {
		// Step12
		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				mytestFolderLocator);

		dashboardPage.rightClickDeleteAFolder(myTestFolder);
		this.confirmDeleteAction();

		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut, "xpath",
				anotherTestFolderLocator);

		dashboardPage.rightClickDeleteAFolder(anotherTestFolder);
		this.confirmDeleteAction();

		bigTree2BigTree1ChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(defaultTimeOut,
				"xpath", bigTree2BigTree1ChildFolderLocator);

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

		// reload page
		driverManager.getDriver().navigate().refresh();

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

	@Test(priority = 0, sequential = true)
	public void crafter3LoadTestTestUser1() {
		this.crafter3LoadTest();
	}

}
