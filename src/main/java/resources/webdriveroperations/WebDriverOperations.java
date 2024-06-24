package resources.webdriveroperations;

import java.util.HashMap;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import java.time.Duration;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverOperations {

	public static WebDriver driver; 
	static String workspacePath= System.getProperty("user.dir");

	@BeforeClass
	@Parameters({"browser","baseurl"})
	public void InitializeDriver(String browserName,String baseurl) throws InterruptedException {
		
		if (browserName.equalsIgnoreCase("chrome")) 
		{	WebDriverManager.chromedriver().setup();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", workspacePath+"/Exporting_files/");
			ChromeOptions options = new ChromeOptions();
			//options.setExperimentalOption("prefs", chromePrefs);
			//options.addArguments("--headless");
			//options.addArguments("--disable-gpu");
			//options.addArguments("--window-size=1920,1080");
			//options.addArguments("--allow-insecure-localhost");
			//options.addArguments("--disable-dev-shm-usage");
			//options.addArguments("--no-sandbox");
			driver=new ChromeDriver(options);
			Reporter.log("Chrome Browser launched", true);
			driver.manage().deleteAllCookies();
			Reporter.log("All Cookies Cleared", true);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{	WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("Firefox Browser launched", true);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{	WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			Reporter.log("Edge Browser launched", true);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to(baseurl);
		Reporter.log(baseurl+"  url navigated", true);
	}

	@AfterClass
	public void tearDown()
	{	
		driver.quit();
		Reporter.log("Browser closed", true);
	}

	public static void GotoUrl(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public static String GetTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void MaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static JavascriptExecutor initiateJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		return js;
	}

	public static void BrowserWindowScroll(WebDriver driver){
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
	}
}
