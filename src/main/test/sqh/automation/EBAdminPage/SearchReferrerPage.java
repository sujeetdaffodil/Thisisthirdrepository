package sqh.automation.EBAdminPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.reusableoperations.ReusableObjects;
import resources.webdriveroperations.WebDriverOperations;

public class SearchReferrerPage {

	WebDriver _driver;
	
	@FindBy(xpath="//span[contains(text(),'Search Referrer')]")
	private WebElement searchreferrerlink;
	
	@FindBy(id="referrer-name")
	private WebElement name;
	
	@FindBy(id="user-email")
	private WebElement email;
	
	@FindBy(id="referrer-search-btn")
	private WebElement searchbtn;
	
	@FindBy(id="dropdownMenutb-Aviva")
	private WebElement actionbtn;
	
	@FindBy(xpath="(//li//a[contains(text(),'Launch Referrer')])[1]")
	private WebElement launchreferrerlink;
	
	@FindBy(xpath="//p[contains(text(),'Welcome to Referrer Portal')]")
	private WebElement welcometext;
	
	@FindBy(css="#referrer_unique_0")
	private List<WebElement> firstrow;
	
	private WebDriverWait wait;
	ReusableObjects reuse;
	
	public SearchReferrerPage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public String SearchReferrerPageTitle() {
		return WebDriverOperations.GetTitle(_driver);
	}
	
	//Function for Searching Referrer
	public void SearchReferrer(String referrerName, String referrerEmail)
	{
		reuse = new ReusableObjects(_driver);
		wait.until(ExpectedConditions.visibilityOf(searchreferrerlink));
		searchreferrerlink.click();	
		reuse.waitForLoaderToBeClosed();
		name.sendKeys(referrerName);
		email.sendKeys(referrerEmail);
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
		searchbtn.click();
		reuse.waitForLoaderToBeClosed();
	}
	
	//Function to Launch Referrer Portal
	public void LaunchReferrer() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(actionbtn));
		actionbtn.click();
		wait.until(ExpectedConditions.visibilityOf(launchreferrerlink));
		launchreferrerlink.click();
		Thread.sleep(20000);
		ArrayList<String> tabs2 = new ArrayList<String> (_driver.getWindowHandles());
	    _driver.switchTo().window(tabs2.get(1));
	}
	
	public String getReferrerPortalTitle()
	{
		return _driver.getTitle().trim();
	}
	
	//Function to Validate Search results
	public void ValidateSearchResults(String email)
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(firstrow));
		for(int i=0;i<firstrow.size();)
		{
			firstrow.get(i).getText().contains(email);
			break;
		}
		System.out.println("Searched referrer results validated successfully..");
	}
	
}
