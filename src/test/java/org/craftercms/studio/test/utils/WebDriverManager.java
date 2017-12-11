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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class WebDriverManager {

	WebDriver driver;
	private ConstantsPropertiesManager constantsPropertiesManager;
	private int defaultTimeOut;

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
						capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
						System.setProperty("webdriver.ie.driver", envProperties.getProperty("ie.driver.path"));
						driver = new InternetExplorerDriver(capabilities);
						break;
					case "chrome":
						capabilities = DesiredCapabilities.chrome();
						System.setProperty("webdriver.chrome.driver", envProperties.getProperty("chrome.driver.path"));
						driver = new ChromeDriver(capabilities);
						break;
					default:
						throw new IllegalArgumentException("webBrowser property is needed, valid values are:" + "chrome,edge,ie,firefox,phantomjs");
				}

				driver.get(envProperties.getProperty("baseUrl"));
				this.defaultTimeOut = Integer.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("crafter.defaulttimeout"));

				if (!webBrowserProperty.equalsIgnoreCase("firefox")) {
					this.maximizeWindow();
				}

			} catch (IOException ex) {
				throw new FileNotFoundException("Unable to read runtime properties file");
			}
		} catch (IOException ex) {
			throw new TestException("Required Files are not found.");
		}

	}

	public void closeConnection() {
		// this.driver.close();
		this.driver.quit();
	}

	public void maximizeWindow() {
		// Getting the size width and height
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int width = (int)toolkit.getScreenSize().getWidth();
		int height = (int)toolkit.getScreenSize().getHeight();
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

	protected By getSelector(String typeOfSelector, String selectorValue) {
		switch (typeOfSelector.toLowerCase()) {
			case "cssselector":
				return By.cssSelector(selectorValue);
			case "xpath":
				return By.xpath(selectorValue);
			case "id":
				return By.id(selectorValue);
			case "classname":
				return By.className(selectorValue);
			case "tagname":
				return By.tagName(selectorValue);
			case "linktext":
				return By.linkText(selectorValue);
			case "partialLinktext":
				return By.partialLinkText(selectorValue);
			case "name":
				return By.name(selectorValue);
			default:
				throw new IllegalArgumentException("selectortype is needed, valid values are:" + "xpath,cssselector,id,tagname,classname,linktext,partiallinkText,name");
		}
	}

	public WebElement waitUntilElementIsDisplayed(String typeOfSelector, String selectorValue) {
		By selector = getSelector(typeOfSelector, selectorValue);
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.visibilityOfElementLocated(selector));
		return driver.findElement(selector);
	}

	public WebElement waitUntilElementIsClickable(String typeOfSelector, String selectorValue) {
		By selector = getSelector(typeOfSelector, selectorValue);
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.elementToBeClickable(selector));
		return driver.findElement(selector);
	}

	public void waitUntilElementIsHidden(WebElement element) {
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitUntilAttributeIs(String selectorType, String selectorValue, String attributeName, String
		attributeValue) {
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.attributeToBe
			(getSelector(selectorType, selectorValue), attributeName, attributeValue));
	}

	public void waitUntilAttributeContains(String selectorType, String selectorValue, String attributeName, String
		attributeValue) {
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions
			.attributeContains(getSelector(selectorType, selectorValue), attributeName, attributeValue));
	}

	public void waitUntilElementIsRemoved(WebElement element) {
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.stalenessOf(element));
	}

	public WebElement waitUntilElementIsSelected(String selectorType, String selectorValue) {
		By selector = getSelector(selectorType, selectorValue);
		new WebDriverWait(driver, defaultTimeOut).until(ExpectedConditions.elementToBeSelected(selector));
		return driver.findElement(selector);
	}

	public WebElement findElement(String selectorType, String selectorValue) {
		return driver.findElement(getSelector(selectorType, selectorValue));
	}

	public void dragAndDropElement(WebElement fromWebElement, WebElement toWebElement) {
		// Creating an actions builder
		Actions builder = new Actions(this.getDriver());

		// Creating the action for click and hold from the origin web element
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement).build();

		// commit the actions above
		dragAndDrop.perform();
	}

	public boolean isElementPresentByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused") WebElement webElement = this.findElement("xpath", xpathOfTheElement);
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableByXpath(String xpathOfTheElement) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused") WebElement webElement = findElement("xpath", xpathOfTheElement);

		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentById(String id) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused") WebElement webElement = this.findElement("id", id);

		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableByName(String name) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused") WebElement webElement = this.findElement("name", name);

		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableById(String id) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused") WebElement webElement = this.findElement("id", id);

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
			@SuppressWarnings("unused") WebElement webElement = this.findElement("cssSelector", cssSelector);

		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public boolean isElementPresentAndClickableBycssSelector(String cssSelector) {
		boolean isElementPresent = true;

		try {
			@SuppressWarnings("unused") WebElement webElement = this.findElement("cssSelector", cssSelector);
			// this.getDriver().findElement(By.cssSelector(cssSelector));
		} catch (NoSuchElementException e) {
			isElementPresent = false;
		} catch (Exception e) {
			isElementPresent = false;
		}

		return isElementPresent;
	}

	public void contextClick(WebDriver driver, WebElement element, Boolean executeThroughJavaScript) {
		if (executeThroughJavaScript) {
			String script = "var element = arguments[0];" + "var event = document.createEvent('HTMLEvents');" + "event.initEvent('contextmenu', true, false);" + "element.dispatchEvent(event);";
			((JavascriptExecutor)driver).executeScript(script, new Object[] {element});
		} else {
			(new Actions(driver)).contextClick(element).build().perform();
		}
	}

	public void scrollUp() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)");
	}

	public void scrollDown() {
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,2000)");
	}

	public ConstantsPropertiesManager getConstantsPropertiesManager() {
		return constantsPropertiesManager;
	}

	public void setConstantsPropertiesManager(ConstantsPropertiesManager constantsPropertiesManager) {
		this.constantsPropertiesManager = constantsPropertiesManager;
	}

	public boolean elementHasChildsByXPath(String childsLocator) {
		boolean hasChilds = false;
		List<WebElement> childs = this.driver.findElements(By.xpath(childsLocator));

		if (!(childs.isEmpty()))
			hasChilds = true;

		return hasChilds;
	}

	public void moveMouseToElement(WebElement toElement) {
		// Creating an actions builder
		Actions builder = new Actions(this.getDriver());
		// Creating the action for click and hold from the origin web element
		Action action = builder.moveToElement(toElement).build();

		// commit the actions above
		action.perform();
	}

	public void waitUntilLoginCloses() {
		new WebDriverWait(this.driver, defaultTimeOut).until(ExpectedConditions.refreshed(ExpectedConditions.attributeToBe(By.tagName("body"), "class", "")));
	}

	public void waitUntilSidebarOpens() {
		waitUntilElementIsDisplayed("cssSelector", "div.acn-resize.ui-resizable");
	}

	// Wrappers

	public void sendText(String selectorType, String selectorValue, String text) {
		WebElement input = waitUntilElementIsClickable(selectorType, selectorValue);
		input.clear();
		input.sendKeys(text);
		waitUntilAttributeIs(selectorType, selectorValue, "value", text);
	}

	public void usingYuiDialog(Runnable actions) {
		String selector = ".//div[contains(@class, 'yui-panel-container') and contains(@class, 'yui-dialog') and contains(@style, 'visibility: visible;')]";
		WebElement dialog = waitUntilElementIsDisplayed("xpath", selector);
		waitUntilAttributeContains("xpath", selector, "style", "opacity: 1;");
		actions.run();
		waitUntilElementIsHidden(dialog);
	}

	public void usingYuiContainer(Runnable actions) {
		String selector = "div.yui-panel-container.yui-dialog.yui-simple-dialog.cstudio-dialogue";
		@SuppressWarnings("unused")
		WebElement dialog = waitUntilElementIsDisplayed("cssSelector", selector);
		waitUntilAttributeContains("cssSelector", selector, "style", "visibility: visible;");
		actions.run();
		//waitUntilElementIsHidden(dialog);
	}

	public void usingCrafterForm(String selectorType, String selectorValue, Runnable actions) {
		driver.switchTo().defaultContent();

		// Wait until animation completes
		WebElement frame = waitUntilElementIsDisplayed(selectorType, selectorValue);

		// Switch to iframe
		driver.switchTo().frame(frame);

		// Wait until the first input is selected
		WebElement firstInput = waitUntilElementIsClickable("xpath", ".//input[not(@disabled)]");
		new WebDriverWait(driver, defaultTimeOut)
			.until(webDriver -> firstInput.equals(webDriver.switchTo().activeElement()));

		// Do stuff
		actions.run();

		// Exit ifreame
		driver.switchTo().defaultContent();

		// Wait until iframe is hidden
		waitUntilElementIsHidden(frame);
	}

	// Same as previuous but without inputs
	public void usingCrafterDialog(String selectorType, String selectorValue, Runnable actions) {
		driver.switchTo().defaultContent();

		// Wait until animation completes
		WebElement frame = waitUntilElementIsDisplayed(selectorType, selectorValue);

		// Switch to iframe
		driver.switchTo().frame(frame);

		// Do stuff
		actions.run();

		// Exit ifreame
		driver.switchTo().defaultContent();

		// Wait until iframe is hidden
		waitUntilElementIsHidden(frame);
	}

	// Old API, kept to avoid a huge refactor

	
	public void waitUntilPageLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		Boolean isLoaded = new WebDriverWait(this.driver, this.defaultTimeOut).until(expectation);
		while (!isLoaded) {
			isLoaded = new WebDriverWait(this.driver, this.defaultTimeOut).until(expectation);
		}

	}

	
	public WebElement driverWaitUntilElementIsPresentAndDisplayed(String typeOfSelector, String selectorValue) {
		return waitUntilElementIsDisplayed(typeOfSelector, selectorValue);
	}


	public WebElement driverWaitUntilElementIsPresentAndDisplayedAndClickable(String typeOfSelector, String selectorValue) {
		return waitUntilElementIsClickable(typeOfSelector, selectorValue);
	}

	
	public void waitWhileElementIsDisplayedAndClickableByXpath(String xpath) {
		waitUntilElementIsClickable("xpath", xpath);
	}

	
	public void waitWhileElementIsPresentByXpath(String xpath) {
		waitUntilElementIsDisplayed("xpath", xpath);
	}

	
	public void waitWhileElementIsNotDisplayedByXpath(String xpath) {
		Boolean isPresent = this.isElementPresentAndClickableByXpath(xpath);

		while (isPresent) {
			isPresent = this.isElementPresentAndClickableByXpath(xpath);
			this.getDriver().navigate().refresh();
		}
	}

}