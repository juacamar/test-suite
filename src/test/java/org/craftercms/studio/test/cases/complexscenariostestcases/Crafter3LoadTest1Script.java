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
		this.driverManager.driverWait(1000);
		// Right click and click on New Folder option
		dashboardPage.rightClickNewFolderOnAPresentFolder(Parent);
		// Set the name of the folder
		dashboardPage.setFolderName(folderName);
		// Create folder button
		dashboardPage.clickCreateButton();

	}

	public void createFolderOnHome(String folderName) {
		this.driverManager.driverWait(300);
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
		homePage.getDriverManager().driverWait(2000);
		// go to preview page
		homePage.goToPreviewPage();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait(3000);

		String siteDropdownElementXPath = ".//a[@id='acn-dropdown-toggler']";

		if (this.driverManager.isElementPresentByXpath(10,siteDropdownElementXPath))
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", siteDropdownElementXPath)
					.click();
		else
			throw new NoSuchElementException(
					"Site creation process is taking too long time and the element was not found");
		// driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
		// .click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait(1000);
	}

	public void prepareTestArea() {
		// Create the parent folder on Home Step1 of Test Case
		this.createFolderOnHome(parentFolderName);
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait(2000);
		// dashboardPage.getDriverManager().driverWait();

		// Checking if parent folder is present
		dashboardPage.getDriverManager().driverWait(1000);
		Assert.assertTrue(driverManager.isElementPresentByXpath(12,parentFolderLocator));

		this.driverManager.driverWait(1000);
		WebElement parentFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				parentFolderLocator);
		// dashboardPage.getDriverManager().getDriver()
		// .findElement(By.xpath(parentFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(harnessFolderName, parentFolder);
		this.driverManager.driverWait(1500);
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				harnessFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(harnessFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(emptyFolderName, harnessFolder);
		this.driverManager.driverWait(1500);
		emptyFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", emptyFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(emptyFolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree1FolderName, harnessFolder);
		this.driverManager.driverWait(1500);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));

		// creating a new folder on a given parentFolder
		this.createFolderOnAPresentFolder(bigTree2FolderName, harnessFolder);
		this.driverManager.driverWait(3000);
		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree2FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));

		this.driverManager.driverWait(3000);
		WebElement styleCategoryLandingStyle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"xpath", styleLocator);
		// driverManager.getDriver().findElement(By.xpath(styleLocator));

		this.driverManager.driverWait(3000);
		dashboardPage.rightClickCopyContentPage(styleCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		this.driverManager.driverWait(3000);
		WebElement entertainmentCategoryLandingStyle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"xpath", entertainmentLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(entertainmentLocator));
		dashboardPage.rightClickCopyContentPage(entertainmentCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		this.driverManager.driverWait(3000);
		WebElement healthCategoryLandingStyle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"xpath", healthLocator);
		// driverManager.getDriver().findElement(By.xpath(healthLocator));
		dashboardPage.rightClickCopyContentPage(healthCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

		this.driverManager.driverWait(3000);
		WebElement technologyCategoryLandingStyle = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"xpath", technologyLocator);
		// driverManager.getDriver().findElement(By.xpath(technologyLocator));
		dashboardPage.rightClickCopyContentPage(technologyCategoryLandingStyle);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree1Folder);

	}

	public void createNewPageArticleContent() {

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3,
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		// driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog >
		// .bd iframe")));

		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait(1500);
		// creating random values for URL field and InternalName field
		String randomURL = "newPageURL" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		String randomInternalName = "newPageInternalName" + RandomStringUtils.randomAlphabetic(5).toLowerCase();

		// Set basics fields of the new content created
		dashboardPage.setBasicFieldsOfNewPageArticleContent(randomURL, randomInternalName, "newPageArticlesTitle");

		// wait for element is clickeable
		homePage.getDriverManager().driverWait(1000);
		// wait for element is clickeable
		// homePage.getDriverManager().driverWait();
		// Set the title of main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#title > div > input")
				.sendKeys("MainTitle");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input")).sendKeys("MainTitle");

		// click necessary to validate all fields required
		homePage.getDriverManager().driverWait(1000);
		this.driverManager.scrollUp();

		homePage.getDriverManager().driverWait(1000);
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", "#cstudio-form-expand-all")
				.click();
		// driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();
		// wait for element is clickeable

		homePage.getDriverManager().driverWait(3000);
		// wait for element is clickeable
		// homePage.getDriverManager().driverWait();
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "id", "cstudioSaveAndClose").click();
		// driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();
		// wait for element is clickeable
		homePage.getDriverManager().driverWait(2000);
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
		driverManager.driverWait(1000);
		this.createNewPageArticleContent();
	}

	public void editSelectedContent() {

		// switch to from
		dashboardPage.switchToAFormByCssSelector(".studio-ice-dialog > .bd iframe");
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);

		// Typing new text on title text field
		WebElement titleElement = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector",
				"#title > div > input");
		// driverManager.getDriver().findElement(By.cssSelector("#title > div >
		// input"));
		// clear the input totally
		titleElement.clear();
		// set new value for title
		titleElement.sendKeys(RandomStringUtils.randomAlphabetic(5).toLowerCase());
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// Save and close button.
		dashboardPage.clickSaveClose();
		// Switch back to the dashboard page
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void compareTwoVersionsOfAContentPage() {

		dashboardPage.getDriverManager().driverWait(1000);
		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// Checking the first row version
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
						".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[1]/td/div/input")
				.click();
		// driverManager.getDriver().findElement(By
		// .xpath(".//div[contains(@class,'bd
		// cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[1]/td/div/input"))
		// .click();

		// Checking the second row version
		this.driverManager
				.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
						".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[2]/td/div/input")
				.click();
		// driverManager.getDriver().findElement(By
		// .xpath(".//div[contains(@class,'bd
		// cstudio-dialogue-body')]/div/div[2]/table/tbody/tr[2]/td/div/input"))
		// .click();

		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// click on Compare button
		dashboardPage.clickCompareButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1500);
		// switching to the compare frame
		driverManager.getDriver().switchTo().frame("diffDialog");

		// checkin if is present the removed-red-highlight text
		Assert.assertTrue(driverManager
				.isElementPresentByXpath(4,".//td[text()='title']/../td[2]/span[contains(@class,'diff-html-removed')]"));

		// checkin if is present the added-green-highlight text
		Assert.assertTrue(driverManager
				.isElementPresentByXpath(4,".//td[text()='title']/../td[2]/span[contains(@class,'diff-html-added')]"));

		// click on close button
		dashboardPage.clickCloseButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void revertLastVersionChanges() {
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// Switch to the iframe
		// driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait(2000);

		// Clickin the revert changes option for the initial version
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				".//div[contains(@class,'bd cstudio-dialogue-body')]/div/div[2]/table/tbody/tr/td[3]/div[text()='Initial commit.']/../../td[4]/div/a[3]")
				.click();
		// driverManager.getDriver().findElement(By.xpath(
		// ".//div[contains(@class,'bd
		// cstudio-dialogue-body')]/div/div[2]/table/tbody/tr/td[3]/div[text()='Initial
		// commit.']/../../td[4]/div/a[3]"))
		// .click();

		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// Comparing first two versions of the content
		compareTwoVersionsOfAContentPage();
		// Click on close button
		dashboardPage.clickHistoryCloseButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void confirmPublishAction() {
		dashboardPage.getDriverManager().driverWait(1000);
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// Click on Publish button
		dashboardPage.clickApproveAndPublishSubmitButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		// switch to default content
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void publishAllPagesOnAFolder(String folderLocator) {
		// getting the entire list of content pages on a folder

		List<WebElement> unpublishedContentPages = driverManager.getDriver()
				.findElements(By.xpath(folderLocator + "/../../../../../div[1]/div/table/tbody/tr/td/span"));

		this.driverManager.driverWait(3100);

		for (WebElement element : unpublishedContentPages) {
			// right click to displays right click menu
			dashboardPage.rightClickOnAContentPage(element);
			// selecting the Publish option
			dashboardPage.clickOnPublishOption();
			// moving to the publish dialog, clicking on Submit and confirm action
			this.confirmPublishAction();
			dashboardPage.getDriverManager().driverWait(3000);
			// wait for element
			// dashboardPage.getDriverManager().driverWait();
		}

	}

	public void confirmDeleteAction() {
		dashboardPage.getDriverManager().driverWait(2000);
		// Switch to the form
		driverManager.getDriver().switchTo().activeElement();
		// wait for element
		dashboardPage.getDriverManager().driverWait(3000);
		// Click on delete button
		dashboardPage.clickDeleteDeleteSubmitButton();
		// wait for element
		dashboardPage.getDriverManager().driverWait(1000);
		driverManager.getDriver().switchTo().defaultContent();
	}

	public void createMultipleContentPagesOnFolder() {
		// wait for element is clickeable
		dashboardPage.getDriverManager().driverWait(1000);

		// creating multiple content pages
		for (int count = 0; count < 1; count++) {
			// reload page
			driverManager.getDriver().navigate().refresh();
			dashboardPage.getDriverManager().driverWait(1000);
			bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
					bigTree1FolderLocator);
			// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
			this.createPageCategoryLandingPage(bigTree1Folder);
		}
	}

	public void step1() {
		this.driverManager.driverWait(700);
		emptyFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", emptyFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(emptyFolderLocator));

		// Step 1
		this.createPageCategoryLandingPage(emptyFolder);

		// creating multiple content pages on bigtree1
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		this.createMultipleContentPagesOnFolder();
	}

	public void step2() {
		// Step2 a)
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		this.driverManager.driverWait(3000);
		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		// Step2 b)
		bigTree1FolderDivOnSelectorXPath = this.parentFolderDivOnTreeSelectorLocator + "/site/website/"
				+ parentFolderName + "/" + harnessFolderName + "/" + bigTree1FolderName + "']";
		this.driverManager.driverWait(300);
		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);

		this.driverManager.driverWait(300);
		dashboardPage.clickCopyButtonOnTreeSelector();

		// Step2 c)
		this.driverManager.driverWait(300);
		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree2FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));
		dashboardPage.rightClickPasteOnAFolder(bigTree2Folder);

		bigTree2BigTree1ChildFolderLocator = bigTree2FolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step3() {
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				harnessFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(harnessFolderLocator));
		this.createFolderOnAPresentFolder(myTestFolderName, harnessFolder);
		// myTestFolder =
		// driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
	}

	public void step4() {
		// Step4
		this.driverManager.driverWait(1000);
		bigTree1Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree1FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree1FolderLocator));
		dashboardPage.rightClickCopyFolder(bigTree1Folder);

		dashboardPage.selectAllTreeOnSelector(bigTree1FolderDivOnSelectorXPath);
		dashboardPage.clickCopyButtonOnTreeSelector();

		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", mytestFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
		dashboardPage.rightClickPasteOnAFolder(myTestFolder);

		myTestBigTreeChildFolderLocator = mytestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step5() {
		harnessFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				harnessFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(harnessFolderLocator));
		this.createFolderOnAPresentFolder(anotherTestFolderName, harnessFolder);
		this.driverManager.driverWait(1000);
		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				anotherTestFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(anotherTestFolderLocator));
	}

	public void step6() {
		// Step6
		dashboardPage.getDriverManager().driverWait(700);

		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", mytestFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
		dashboardPage.expandParentFolder(myTestFolder);

		this.driverManager.driverWait(1000);
		WebElement myTestBigTreeChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				myTestBigTreeChildFolderLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(myTestBigTreeChildFolderLocator));
		dashboardPage.rightClickCutAFolder(myTestBigTreeChildFolder);

		this.driverManager.driverWait(1000);
		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				anotherTestFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(anotherTestFolderLocator));
		dashboardPage.rightClickPasteOnAFolder(anotherTestFolder);

		this.driverManager.driverWait(1000);
		anotherTestBigTreeChildFolderLocator = anotherTestFolderLocator + UIElementsPropertiesManager
				.getSharedUIElementsLocators().getProperty("complexscenarios.crafter3loadtest.childfolder")
				+ this.bigTree1FolderName + "')]";
	}

	public void step7() {
		// Step7 a)
		dashboardPage.clicOnHomeTree();
		dashboardPage.getDriverManager().driverWait(1000);
		dashboardPage.clickOnContextualNavigationEditOption();
		dashboardPage.getDriverManager().driverWait(1000);

		// Step7 b)
		this.editSelectedContent();
	}

	public void step8() {
		// Step8
		dashboardPage.getDriverManager().driverWait(2000);
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

		bigTree2Folder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree2FolderLocator);
		// driverManager.getDriver().findElement(By.xpath(bigTree2FolderLocator));
		dashboardPage.expandParentFolder(bigTree2Folder);

		driverManager.driverWait(1000);
		bigTree2BigTree1ChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree2BigTree1ChildFolderLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(bigTree2BigTree1ChildFolderLocator));
		dashboardPage.expandParentFolder(bigTree2BigTree1ChildFolder);

		this.publishAllPagesOnAFolder(bigTree2BigTree1ChildFolderLocator);
	}

	public void step12() {
		// Step12
		myTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath", mytestFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(mytestFolderLocator));
		dashboardPage.rightClickDeleteAFolder(myTestFolder);
		this.confirmDeleteAction();

		anotherTestFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				anotherTestFolderLocator);
		// driverManager.getDriver().findElement(By.xpath(anotherTestFolderLocator));
		dashboardPage.rightClickDeleteAFolder(anotherTestFolder);
		this.confirmDeleteAction();

		bigTree2BigTree1ChildFolder = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(3, "xpath",
				bigTree2BigTree1ChildFolderLocator);
		// driverManager.getDriver()
		// .findElement(By.xpath(bigTree2BigTree1ChildFolderLocator));
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
		dashboardPage.getDriverManager().driverWait(2000);

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

	// @Test (priority=1, sequential = true)
	// public void crafter3LoadTestTestUser2() {
	// this.crafter3LoadTest();
	// }
	// @Test (priority=2, sequential = true)
	// public void crafter3LoadTestTestUser3() {
	// this.crafter3LoadTest();
	// }

}
