package sqh.automation.EBAdminPage;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.reusableoperations.ReusableObjects;

public class SearchCustomerPage {

	WebDriver _driver;
	private WebDriverWait wait;
	ReusableObjects reuse;
	
	@FindBy(xpath="//span[contains(text(),'Search Customer')]")
	private WebElement searchcustomerlink;
	
	@FindBy(xpath="//select[@id='select-referrer']")
	private WebElement selectreferrer;
	
	@FindBy(id="customer-name")
	private WebElement customername;
	
	@FindBy(id="scheme-name")
	private WebElement schemename;
	
	@FindBy(id="policy-number")
	private WebElement policynumber;
	
	@FindBy(id="client-code")
	private WebElement clientcode;
	
	@FindBy(id="user-email")
	private WebElement customeremail;
	
	@FindBy(id="creation-date")
	private WebElement creationdate;
	
	@FindBy(id="customer-search-btn")
	private WebElement searchbtn;
	
	@FindBy(xpath="(//*[@id='search-customer-tb']//td//span)[3]")
	private WebElement resultemail;

	@FindBy(xpath="(//a[starts-with(@id,'dropdownMenutb')])[1]")
	private WebElement actionbtn;
	
	@FindBy(xpath="(//li//a[contains(text(),'Launch Customer')])[1]")
	private WebElement launchcustomerlink;
	
	public SearchCustomerPage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse = new ReusableObjects(_driver);
	}
	
	//Function to Search Customer
	public void SearchCustomer(String customerName, String schemeName, String policyNumner, String clientCode, String customerEmail, String creationDate) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(searchcustomerlink));
		searchcustomerlink.click();	
		reuse.waitForLoaderToBeClosed();
		customername.sendKeys(customerName);
		schemename.sendKeys(schemeName);
		policynumber.sendKeys(policyNumner);
		clientcode.sendKeys(clientCode);
		customeremail.sendKeys(customerEmail);
		creationdate.sendKeys(creationDate);
		wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
		searchbtn.click();
		reuse.waitForLoaderToBeClosed();
	}
	
	//Function for Search Validation
	public String ValidateEmailFromResults()
	{
		wait.until(ExpectedConditions.visibilityOf(resultemail));
		return resultemail.getText();
	}
	
	//Function for Launching Customer portal
	public void LaunchCustomer() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(actionbtn));
		actionbtn.click();
		wait.until(ExpectedConditions.visibilityOf(launchcustomerlink));
		launchcustomerlink.click();
		Thread.sleep(30000);
		ArrayList<String> tabs2 = new ArrayList<String> (_driver.getWindowHandles());
	    _driver.switchTo().window(tabs2.get(1));
	}
	
	public boolean getCustomerPortalTitle()
	{
		
		return _driver.getTitle().trim().contains("Customer");
	}
}
