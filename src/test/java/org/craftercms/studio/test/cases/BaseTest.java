package org.craftercms.studio.test.cases;

import org.craftercms.studio.test.pages.CreateSitePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.pages.PreviewPage;
import org.craftercms.studio.test.utils.ConstantsPropertiesManager;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * All Test Cases should extend this class
 */
public class BaseTest {

    protected WebDriverManager driverManager;
    protected UIElementsPropertiesManager uiElementsPropertiesManager;
    protected ConstantsPropertiesManager constantsPropertiesManager;

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected DashboardPage dashboardPage;
    protected PreviewPage previewPage;
    protected CreateSitePage createSitePage;

    @BeforeClass
    public void setUp() {
        driverManager = new WebDriverManager();
        uiElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
        constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
        driverManager.setConstantsPropertiesManager(constantsPropertiesManager);

        loginPage = new LoginPage(driverManager, uiElementsPropertiesManager);
        homePage = new HomePage(driverManager, uiElementsPropertiesManager);
        previewPage = new PreviewPage(driverManager, uiElementsPropertiesManager);
        dashboardPage = new DashboardPage(driverManager, uiElementsPropertiesManager);
        createSitePage = new CreateSitePage(driverManager, uiElementsPropertiesManager);
    }

    @AfterClass
    public void close() {
        driverManager.closeConnection();
    }

}
