package sqh.automation.EBAdminPage;

import java.util.ArrayList;
import java.util.List;
import java.time.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.reusableoperations.RandomStringGeneratorOperations;

public class ActivityLogPage {

	WebDriver _driver;
	private WebDriverWait wait;
	RandomStringGeneratorOperations generate;
	
	public ActivityLogPage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);
			this._driver=driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			this.generate = new RandomStringGeneratorOperations();
	}
	
	@FindBy(xpath="//span[contains(text(),'Activity Log')]")
	private WebElement activityloglink;
	
	@FindBy(id="floatingusName")
	private WebElement username;
	
	@FindBy(css=".ui-menu-item")
	private List<WebElement> usernamelist;
	
	@FindBy(id="fromdate")
	private WebElement activityfromdate;
	
	@FindBy(id="todate")
	private WebElement activitytodate;
	
	@FindBy(xpath="//button[@data-id='role']")
	private WebElement userrole;
	
	@FindBy(xpath="//*[@id='bs-select-1-1']")
	private WebElement sqhRole;
	
	@FindBy(xpath="//button[@data-id='customerName']")
	private WebElement customernamedropdown;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement customersearch;
	
	@FindBy(xpath="//button[@data-id='referrerName']")
	private WebElement referrernamedropdown;
	
	@FindBy(xpath="//div[@id='bs-select-2']//a//span")
	private List<WebElement> referrerlist;
	
	@FindBy(id="activity-log-search-btn")
	private WebElement searchbtn;
	
	@FindBy(xpath="//tr[@id='activity_log_unique_0']//td[4]")
	private WebElement msglog; 
	
	@FindBy(id="loader-wrap")
	private WebElement loadingicon;
	
	public String ActivityLogPageTitle()
	{
		return _driver.getTitle();
	}
	
	//Function to Validate Activity Log
	public void ActivityLog(String adminusername, String referrer, String customer, String role)
	{
		ArrayList<String> tabs2 = new ArrayList<String>(_driver.getWindowHandles());
	    _driver.switchTo().window(tabs2.get(0));
		activityloglink.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOfAllElements(userrole,username,activityfromdate,activitytodate,customernamedropdown));
		username.sendKeys(adminusername);
		wait.until(ExpectedConditions.visibilityOfAllElements(usernamelist));
		usernamelist.get(0).click();
		userrole.click();
		sqhRole.click();
		activityfromdate.sendKeys(generate.CurrentDate());
		activitytodate.sendKeys(generate.CurrentDate());
		referrernamedropdown.click();
		for(int i=0;i<referrerlist.size();i++)
		{
			if(referrerlist.get(i).getText().contains(referrer))
			{
				referrerlist.get(i).click();
				break;
			}
		}
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(searchbtn));
		searchbtn.isEnabled();
		searchbtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	}
	
	public String LaunchReferrerActivityLog() 
	{
		return msglog.getText();		
	}
}


