package sqh.automation.EBAdminPage;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.reusableoperations.ReusableObjects;

public class CustomerInvoicePage {

	WebDriver _driver;
	private WebDriverWait wait;
	ReusableObjects reuse;
	static String workspacePath= System.getProperty("user.dir");

	
	public CustomerInvoicePage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse = new ReusableObjects(_driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'Customer Invoices')]")
	private WebElement customerinvoicelink;
	
	@FindBy(xpath="//button[@data-id='selectReferrer']")
	private WebElement referrernamedropdown;
	
	@FindBy(xpath="//div[@id='bs-select-1']//a//span")
	private List<WebElement> referrerlist;
	
	@FindBy(css="#customerName")
	private WebElement customernamefield;
	
	@FindBy(css="#invoice-from")
	private WebElement invoicefromdate;
	
	@FindBy(css="#invoice-to")
	private WebElement invoicetodate;
	
	@FindBy(css="#invoiceNumber")
	private WebElement invoicenumberfield;
	
	@FindBy(xpath="//button[@data-id='invoice_status']")
	private WebElement invoicestatusdropdown;
	
	@FindBy(xpath="//div[@id='bs-select-2']//a//span")
	private List<WebElement> invoicestatuslist;
	
	@FindBy(css="#search-invoice-button")
	private WebElement searchinvoicebtn;
	
	@FindBy(id="invoice_unique_0")
	private List<WebElement> searchresults; 
	
	@FindBy(id="export_invoices")
	private WebElement exportinvoice;
	
	@FindBy(id="loader-wrap")
	private WebElement loadingicon;
	
	@FindBy(xpath="//span//img[@src='/img/three-dot.svg']")
	private WebElement actionbtn;
	
	@FindBy(id="download-unique-id-1")
	private WebElement downloadinvoice;
	
	@FindBy(id="launch-unique-id-1")
	private WebElement launchcustomer;
	
	@FindBy(xpath="//tr[@id='invoice_unique_0']//td[2]")
	private WebElement getinvoicenumber;
	
	public void GoToCustomerInvoicePage()
	{
		wait.until(ExpectedConditions.visibilityOf(customerinvoicelink));
		customerinvoicelink.click();
		reuse.waitForLoaderToBeClosed();
		if(_driver.getCurrentUrl().contains("invoice"))
		{
			System.out.println("User navigated to customer invoice page succesfully..");
		}
	}
	
	public void SearchInvoice(String referrername, String customername, String fromDate, String toDate, String number, String status)
	{
		wait.until(ExpectedConditions.visibilityOf(referrernamedropdown));
		referrernamedropdown.click();
		for(int i=0;i<referrerlist.size();i++)
		{
			if(referrerlist.get(i).getText().contentEquals(referrername))
			{
				referrerlist.get(i).click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOf(customernamefield));
		customernamefield.sendKeys(customername);
		wait.until(ExpectedConditions.visibilityOf(invoicefromdate));
		invoicefromdate.sendKeys(fromDate);
		wait.until(ExpectedConditions.visibilityOf(invoicetodate));
		invoicetodate.sendKeys(toDate);
		wait.until(ExpectedConditions.visibilityOf(invoicenumberfield));
		invoicenumberfield.sendKeys(number);
		wait.until(ExpectedConditions.visibilityOf(invoicestatusdropdown));
		invoicestatusdropdown.click();
		for(int i=0;i<invoicestatuslist.size();i++)
		{
			if(invoicestatuslist.get(i).getText().contentEquals(status))
			{
				invoicestatuslist.get(i).click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOf(searchinvoicebtn));
		searchinvoicebtn.click();
		reuse.waitForLoaderToBeClosed();
		if(searchresults.get(0).getText().contains(number))
		{
			System.out.println("Customer invoice results displayed");
		}
		else
			System.out.println("No reults displayed.");
	}
	
	public void DownloadInvoice() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(actionbtn));
		actionbtn.click();
		wait.until(ExpectedConditions.visibilityOf(downloadinvoice));
		System.out.println(getinvoicenumber.getText());
		String exportFilepath= workspacePath+"\\Exporting_files\\Invoices_"+getinvoicenumber.getText()+".pdf";
		wait.until(ExpectedConditions.visibilityOf(downloadinvoice));
		downloadinvoice.click();
		reuse.waitForLoaderToBeClosed();
		Thread.sleep(7000);
		File fileHandler = new File(exportFilepath);
		if(fileHandler.exists())
		{
			Assert.assertTrue(fileHandler.exists());
			if(fileHandler.delete());
				{
					System.out.println("Invoice File Deleted");
				}
		}
	}
	
	public void LaunchCustomer() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(actionbtn));
		actionbtn.click();
		wait.until(ExpectedConditions.visibilityOf(launchcustomer));
		launchcustomer.click();
		Thread.sleep(30000);
		ArrayList<String> tabs2 = new ArrayList<String> (_driver.getWindowHandles());
	    _driver.switchTo().window(tabs2.get(1));
	    if(_driver.getCurrentUrl().contains("dashboard")||_driver.getCurrentUrl().contains("user-terms-and-conditions"))
		{
		System.out.println("Customer launched succesfully..!!");
		}
	}
	
	public void ExportCSV() throws InterruptedException
	{
		String exportFilepath= workspacePath+"\\Exporting_files\\invoice_report.csv";
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(exportinvoice));
		exportinvoice.click();
		Thread.sleep(7000);
		File fileHandler = new File(exportFilepath);
		if(fileHandler.exists())
		{
			Assert.assertTrue(fileHandler.exists());
			if(fileHandler.delete());
				{
					System.out.println("File Deleted");
				}
		}
	}
}

