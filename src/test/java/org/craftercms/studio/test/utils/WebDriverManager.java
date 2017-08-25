package org.craftercms.studio.test.utils;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

public class WebDriverManager {
	WebDriver driver;
	ConstantsPropertiesManager constantsPropertiesManager;

	public void openConnection() {
		constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		String webBrowserProperty = constantsPropertiesManager.getSharedExecutionConstants().getProperty("webBrowser");

		if (constantsPropertiesManager.getSharedExecutionConstants().getProperty("environmentToExecuteAutomation")
				.equalsIgnoreCase("MAC")) {
			if (webBrowserProperty.equalsIgnoreCase("PhantomJS")) {

				System.setProperty("phantomjs.binary.path",
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("phantomjsMacExec"));
				driver = new PhantomJSDriver();
			}

			else if (webBrowserProperty.equalsIgnoreCase("Chrome")) {

				System.setProperty("webdriver.chrome.driver",
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("chromeMacExec"));
				driver = new ChromeDriver();

			}

			else if (webBrowserProperty.equalsIgnoreCase("Safari"))
				driver = new SafariDriver();

			else {
				System.setProperty("webdriver.gecko.driver",
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("geckoMacExec"));
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				// capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);
			}

		} else {
			if (webBrowserProperty.equalsIgnoreCase("PhantomJS")) {

				System.setProperty("phantomjs.binary.path",
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("phantomjsWinExec"));
				driver = new PhantomJSDriver();
			}

			else if (webBrowserProperty.equalsIgnoreCase("Chrome")) {

				System.setProperty("webdriver.chrome.driver",
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("chromeWinExec"));
				driver = new ChromeDriver();

			}

			else if (webBrowserProperty.equalsIgnoreCase("Safari"))
				driver = new SafariDriver();

			else if (webBrowserProperty.equalsIgnoreCase("IE")) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				if (constantsPropertiesManager.getSharedExecutionConstants().getProperty("bitsVersionForIE")
						.equalsIgnoreCase("32"))
					System.setProperty("webdriver.ie.driver",
							constantsPropertiesManager.getSharedExecutionConstants().getProperty("IEexec32"));
				else
					System.setProperty("webdriver.ie.driver",
							constantsPropertiesManager.getSharedExecutionConstants().getProperty("IEexec64"));

				driver = new InternetExplorerDriver();
			} else {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);

				if (constantsPropertiesManager.getSharedExecutionConstants().getProperty("bitsVersionForFireFox")
						.equalsIgnoreCase("32"))
					System.setProperty("webdriver.gecko.driver",
							constantsPropertiesManager.getSharedExecutionConstants().getProperty("geckoMacExec32"));
				else
					System.setProperty("webdriver.gecko.driver",
							constantsPropertiesManager.getSharedExecutionConstants().getProperty("geckoMacExec64"));

				driver = new FirefoxDriver(capabilities);
			}

		}

		this.maximizeWindow();
		driver.get(constantsPropertiesManager.getSharedExecutionConstants().getProperty("baseUrl"));
	}


	public void closeConnection() {
		this.driver.close();
		this.driver.quit();
	}

	public void maximizeWindow() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth();
		int height = (int) toolkit.getScreenSize().getHeight();

		this.driver.manage().window().setPosition(new Point(0, 0));
		this.driver.manage().window().maximize();
		this.driver.manage().window().setSize(new Dimension(width, height));
		this.driverWait();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void driverWait() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}
	}

	public void dragAndDropElement(WebElement fromWebElement, WebElement toWebElement) {
		// Creating an actions builder
		Actions builder = new Actions(this.getDriver());

		// Creating the action for click and hold from the origin web element
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();

		// commit the actions above
		dragAndDrop.perform();

		// wait for a couple of secs
		this.driverWait();
	}

	public boolean isElementPresentByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {

			this.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			@SuppressWarnings("unused")

			WebElement webElement = this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public void setImplicitlyWaitTimeForFindElements() {
		this.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	public void contextClick(WebDriver driver, WebElement element) {
		if (driver instanceof PhantomJSDriver) {
			String script = "var element = arguments[0];" + "var event = document.createEvent('HTMLEvents');"
					+ "event.initEvent('contextmenu', true, false);" + "element.dispatchEvent(event);";
			((JavascriptExecutor) driver).executeScript(script, new Object[] { element });
		} else {
			(new Actions(driver)).contextClick(element).build().perform();
		}
	}

	
}
