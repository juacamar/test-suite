package org.craftercms.studio.test.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebDriverManager {
	WebDriver driver;
	ConstantsPropertiesManager constantsPropertiesManager;

	public void openConnection() {
		final Properties runtimeProperties = new Properties();
		try {
			runtimeProperties.load(WebDriverManager.class.getResourceAsStream("/runtime.properties"));
			String enviromentPropertiesPath = runtimeProperties.getProperty("crafter.test.location");
			final Properties envProperties = new Properties();
			try {
				envProperties.load(new FileInputStream(enviromentPropertiesPath));
				String webBrowserProperty = envProperties.getProperty("webBrowser");
				DesiredCapabilities capabilities;
				switch (webBrowserProperty.toLowerCase()) {
				case "phantomjs":
					capabilities = DesiredCapabilities.phantomjs();
					System.setProperty("phantomjs.binary.path", envProperties.getProperty("phantomjs.binary.path"));
					driver = new PhantomJSDriver(capabilities);
					break;
				case "firefox":
					capabilities = DesiredCapabilities.firefox();
					// capabilities.setCapability("marionette", true);
					System.setProperty("webdriver.gecko.driver", envProperties.getProperty("firefox.driver.path"));
					driver = new FirefoxDriver(capabilities);
					break;
				case "edge":
					capabilities = DesiredCapabilities.edge();
					System.setProperty("webdriver.edge.driver", envProperties.getProperty("edge.driver.path"));
					EdgeOptions options = new EdgeOptions();
					options.setPageLoadStrategy("eager");
					driver = new EdgeDriver();
					break;
				case "ie":
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					System.setProperty("webdriver.ie.driver", envProperties.getProperty("ie.driver.path"));
					driver = new InternetExplorerDriver(capabilities);
					break;
				case "chrome":
					capabilities = DesiredCapabilities.chrome();
					System.setProperty("webdriver.chrome.driver", envProperties.getProperty("chrome.driver.path"));
					driver = new ChromeDriver(capabilities);
					break;
				default:
					throw new IllegalArgumentException(
							"webBrowser property is needed, valid values are:" + "chrome,edge,ie,firefox,phantomjs");
				}

				driver.get(envProperties.getProperty("baseUrl"));

				if (!webBrowserProperty.equalsIgnoreCase("firefox")) {
					this.maximizeWindow();
				}

			} catch (IOException ex) {
				throw new FileNotFoundException("Unable to read runtime properties file");
			}
		} catch (IOException ex) {
			throw new TestException("Require Files are not found.");
		}

	}

	public void closeConnection() {
		//this.driver.close();
		 this.driver.quit();
	}

	public void maximizeWindow() {
		// Getting the size width and height
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int) toolkit.getScreenSize().getWidth();
		int height = (int) toolkit.getScreenSize().getHeight();
		// locating webdriver at coordinate 0,0
		this.driver.manage().window().setPosition(new Point(0, 0));
		// maximize the window at normal size
		// this.driver.manage().window().maximize();
		// //scaling to full screen
		this.driver.manage().window().setSize(new Dimension(width, height));

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void driverWait(int amoutOfMilliseconds) {
		try {
			Thread.sleep(amoutOfMilliseconds);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}
	}

	public WebElement driverWaitUntilElementIsPresentAndDisplayed(int waitTime, String typeOfSelector,
			String selectorValue) {
		WebElement element = null;
		switch (typeOfSelector.toLowerCase()) {
		case "cssselector":
			if ((new WebDriverWait(this.driver, waitTime)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selectorValue)))))
				element = this.driver.findElement(By.cssSelector(selectorValue));

			break;
		case "xpath":
			if ((new WebDriverWait(this.driver, waitTime))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.xpath(selectorValue)))))
				element = this.driver.findElement(By.xpath(selectorValue));
			break;
		case "id":
			if ((new WebDriverWait(this.driver, waitTime))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.id(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.id(selectorValue)))))
				element = this.driver.findElement(By.id(selectorValue));
			break;
		case "classname":
			if ((new WebDriverWait(this.driver, waitTime)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.className(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.className(selectorValue)))))
				element = this.driver.findElement(By.className(selectorValue));
			break;
		case "tagname":
			if ((new WebDriverWait(this.driver, waitTime)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.tagName(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.tagName(selectorValue)))))
				element = this.driver.findElement(By.tagName(selectorValue));
			break;
		case "linktext":
			if ((new WebDriverWait(this.driver, waitTime)).until(
					ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.linkText(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.linkText(selectorValue)))))
				element = this.driver.findElement(By.linkText(selectorValue));
			break;
		case "partialLinktext":
			if ((new WebDriverWait(this.driver, waitTime)).until(ExpectedConditions.and(
					ExpectedConditions.presenceOfElementLocated(By.partialLinkText(selectorValue)),
					ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(selectorValue)))))
				element = this.driver.findElement(By.partialLinkText(selectorValue));
			break;
		case "name":
			if ((new WebDriverWait(this.driver, waitTime))
					.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.name(selectorValue)),
							ExpectedConditions.visibilityOfElementLocated(By.name(selectorValue)))))
				element = this.driver.findElement(By.name(selectorValue));
			break;
		default:
			throw new IllegalArgumentException("selectortype is needed, valid values are:"
					+ "xpath,cssselector,id,tagname,classname,linktext,partiallinkText,name");
		}
		return element;
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
		this.driverWait(2000);
	}

	public boolean isElementPresentByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayed(2, "xpath", xpathOfTheElement);
			// this.getDriver().findElement(By.xpath(xpathOfTheElement));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentBycssSelector(String cssSelector) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused")
			WebElement webElement = this.driverWaitUntilElementIsPresentAndDisplayed(3, "cssSelector", cssSelector);
			// this.getDriver().findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
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

	public void scrollUp() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)", "");
	}

	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)", "");
	}
}