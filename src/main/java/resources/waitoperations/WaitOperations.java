package resources.waitoperations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitOperations {
	WebDriver driver;
	public WaitOperations(WebDriver driver)
	{
		this.driver=driver;
	}

	public static WebElement WaitForElementToBeVisible(WebDriver driver, int timeOutInSeconds,
			int pollingIntervalInMilliSeconds, By by) {

		Wait<WebDriver> wait = WaitSetup(timeOutInSeconds, pollingIntervalInMilliSeconds, driver);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static WebElement WaitForElementToBeClickable(WebDriver driver, int timeOutInSeconds,
			int pollingIntervalInMilliSeconds, By by) {

		Wait<WebDriver> wait = WaitSetup(timeOutInSeconds, pollingIntervalInMilliSeconds, driver);

		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	private static Wait<WebDriver> WaitSetup(int timeOutInSeconds, int pollingIntervalInMilliSeconds,
			WebDriver driver) {

		Duration timeout = Duration.ofSeconds(timeOutInSeconds);
		Duration pollingInterval = Duration.ofMillis(pollingIntervalInMilliSeconds);

		return new FluentWait<WebDriver>(driver).pollingEvery(pollingInterval).withTimeout(timeout)
				.ignoring(NoSuchElementException.class);
	}
	public static WebElement WaitForElementToBeClickablePassingElement(WebDriver driver, int timeOutInSeconds,int pollingIntervalInMilliSeconds, WebElement e) {
		
		Wait<WebDriver> wait = WaitSetup(timeOutInSeconds, pollingIntervalInMilliSeconds, driver);

		return wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public static List<WebElement> WaitForAllElementsToBeVisible(WebDriver driver, int timeOutInSeconds,
			int pollingIntervalInMilliSeconds, By by) {

		Wait<WebDriver> wait = WaitSetup(timeOutInSeconds, pollingIntervalInMilliSeconds, driver);

      return  (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
}
