package sqh.D2ERPageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.exceloperations.ExcelReadOperations;
import resources.reusableoperations.RandomStringGeneratorOperations;
import resources.reusableoperations.ReusableObjects;


public class D2ERFinancePage {
	
	@FindBy(id="menutoggle")
	private WebElement sideMenu;
	
	@FindBy(css="#nav_finance_heading")
	private WebElement manageFinance;
	
	@FindBy(xpath="//a[@id='nav_manage_invoice']")
	private WebElement Invoicesbutton;
	
	
	@FindBy(css="#nav_manage_payment_method")
	private WebElement managePaymentMethod;
	
	@FindBy(css="#nav_manage_invoice")
	private WebElement manageInvoices;
	
	@FindBy(css="#nav_billing_account")
	private WebElement billingAccount;
	
	@FindBy(css="#nav_manage_payment_method")
	private WebElement paymentMethods;	
	
	@FindBy(xpath="//a[@class='nav_link'][1]")
	private WebElement HomeIcon;
	
	@FindBy(xpath="//button[contains(@data-id,'invoice_status')]")
	private WebElement InvoiceStatus;
	
	@FindBy(xpath="//button[contains(@data-id,'invoice_status')]")
	private WebElement InvoicesStatus;
	
	@FindBy(xpath="//button[contains(@data-id,'payment_method')]")
	private WebElement Paymentmethod;
	
	@FindBy(xpath="//span[contains(text(),'Direct Debit')]")
	private WebElement PMethodDirectDebit;
	
	@FindBy(xpath="//span[contains(text(),'Pay by Invoice')]")
	private WebElement PMethodPaybyInvoice;
	
	@FindBy(id="bs-select-2-1")
	private WebElement StatusPending;
	
	@FindBy(id="menuHeader")
	private WebElement Menuhealder;
	
	@FindBy(id="search-invoice-button")
	private WebElement SearchInvoice;
	
	@FindBy(xpath="//td[@class='dt-control sorting_1'][1]")
	private WebElement ResultlintingInvoice;
	
	@FindBy(xpath="//tbody[@id='d2er-mf-invoice-tbody']//b[contains(text(),'PO Number')]")
	private WebElement POnumberNA;	
	
	@FindBy(xpath="//tbody[@id='d2er-mf-invoice-tbody']//span[contains(text(),'2342342333')]")
	private WebElement POnumberpresent;
	
//	@FindBy(xpath="//tbody[@id='d2er-mf-invoice-tbody']//span[contains(text(),'NA')]")
	//private WebElement NAponumberID;
	
	@FindBy(xpath="//div[@class='dropdown-menu show']//span[contains(text(),'00000272')]")
	private WebElement clickconid;
	
	//span[@class='badge-select']
	//div[@class='dropdown-menu show']//span//span[contains(text(),'00000367')]
	
	
	@FindBy(xpath="//tbody[@id='d2er-mf-invoice-tbody']//span[contains(text(),'NA')]")
	private WebElement ponumberID;
	
	@FindBy(xpath="//button[contains(@data-id,'contract_id')]")
	private WebElement Selectconid;
	
	@FindBy(xpath="//button[@id='clear-invoice-button']")
	private WebElement clearInvoice;
	
	@FindBy(id="invoice-from")
	private WebElement Invoicefromdate;
	
	@FindBy(id="invoice-to")
	private WebElement Invoicetodate;
	
	@FindBy(id="dropdownMenutb1")
	private WebElement actionbn;
	
	@FindBy(xpath="//tr[@class='even']//a[@id='dropdownMenutb1'][1]")
	private WebElement actionbn01;
	
	@FindBy(xpath="//a[@class='dropdown-item download-card download-invoice'][1]")
	private WebElement dwnloadbtn;
	
	@FindBy(xpath="//a[@class='dropdown-item view-payment-model'][1]")
	private WebElement Viewdetails;
	
	@FindBy(id="payment-close-btn")
	private WebElement closebtn;
	
	@FindBy(id="nav_manage_payment_method")
			private WebElement PaymentMethod;	
	
	@FindBy(xpath="//a[@class='dropdown-item replace-card url-confirm-modal']")
	private WebElement Updatebtn;
	
	@FindBy(xpath="//input[@id='DLaccountName']")
	private WebElement AccountName;	
	
	@FindBy(id="DLaccountNumber")
	private WebElement AccountNumbere;
	
	@FindBy(id="DLsclabel")
	private WebElement sortCode;	
	
	@FindBy(id="submitbutton")
	private WebElement UpdateAutorization;	
	
	
	
	
	
	WebDriver driver;
	private WebDriverWait wait;
	RandomStringGeneratorOperations random;
	public ReusableObjects reuse;

	public D2ERFinancePage(WebDriver driver)throws IOException {
		//_driver = driver;
		PageFactory.initElements(driver, this);		
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse= new ReusableObjects(driver);
		this.random = new RandomStringGeneratorOperations();
	}
	
	public void ValidateFinanceTabs(String userName) {
		wait.until(ExpectedConditions.visibilityOf(sideMenu));
		sideMenu.click();
		reuse.waitForLoaderToBeClosed();
		sideMenu.click();
		wait.until(ExpectedConditions.visibilityOf(manageFinance));
		//manageFinance.click();
		//reuse.waitForLoaderToBeClosed();
	
	}
	
	public void POnumberInvoice() throws InterruptedException, IOException {
		
		
		
		String NAponumberID1 = ExcelReadOperations.GetDataFromExcel("D2ER",2,2);
		String ponumberID1 = ExcelReadOperations.GetDataFromExcel("D2ER",1,2);
       
		wait.until(ExpectedConditions.visibilityOf(manageFinance));
		wait.until(ExpectedConditions.visibilityOf(Invoicesbutton));
		Invoicesbutton.click();
		wait.until(ExpectedConditions.visibilityOf(InvoiceStatus));
		InvoiceStatus.click();
		wait.until(ExpectedConditions.visibilityOf(StatusPending));
		StatusPending.click();
		wait.until(ExpectedConditions.visibilityOf(Menuhealder));
		Menuhealder.click();
		wait.until(ExpectedConditions.visibilityOf(Selectconid));
		Selectconid.click();
		WebElement clickonID=driver.findElement(By.xpath("//div[@class='dropdown-menu show']//span[contains(text(),'"+ponumberID1+"')]"));   
		wait.until(ExpectedConditions.visibilityOf(clickonID));
		clickonID.click();
		wait.until(ExpectedConditions.visibilityOf(Menuhealder));
		Menuhealder.click();
		reuse.waitForLoaderToBeClosed();
		wait.until(ExpectedConditions.visibilityOf(Paymentmethod));
		Paymentmethod.click();
		wait.until(ExpectedConditions.visibilityOf(PMethodDirectDebit));
		PMethodDirectDebit.click();
		
		//Invoicefromdate.sendKeys(random.CurrentDate());
		//Invoicetodate.sendKeys(random.CurrentDate());
		
		wait.until(ExpectedConditions.visibilityOf(SearchInvoice));
		SearchInvoice.click();
		reuse.waitForLoaderToBeClosed();
		wait.until(ExpectedConditions.visibilityOf(ResultlintingInvoice));
		ResultlintingInvoice.click();
		WebElement NAponumberID=driver.findElement(By.xpath("//tbody[@id='d2er-mf-invoice-tbody']//span[contains(text(),'"+NAponumberID1+"')]"));
		wait.until(ExpectedConditions.visibilityOf(NAponumberID));
		wait.until(ExpectedConditions.visibilityOf(clearInvoice));
		clearInvoice.click();
		wait.until(ExpectedConditions.visibilityOf(InvoiceStatus));
		InvoiceStatus.click();
		wait.until(ExpectedConditions.visibilityOf(StatusPending));
		StatusPending.click();
		wait.until(ExpectedConditions.visibilityOf(Menuhealder));
		Menuhealder.click();
		wait.until(ExpectedConditions.visibilityOf(Selectconid));
		Selectconid.click(); 
		WebElement clickonID1=driver.findElement(By.xpath("//div[@class='dropdown-menu show']//span[contains(text(),'"+ponumberID1+"')]"));
		wait.until(ExpectedConditions.visibilityOf(clickonID1));
		clickonID1.click();
		wait.until(ExpectedConditions.visibilityOf(Menuhealder));
		Menuhealder.click();
		wait.until(ExpectedConditions.visibilityOf(SearchInvoice));
		SearchInvoice.click();
		wait.until(ExpectedConditions.visibilityOf(ResultlintingInvoice));
		ResultlintingInvoice.click();
		WebElement NAponumberID2=driver.findElement(By.xpath("//tbody[@id='d2er-mf-invoice-tbody']//span[contains(text(),'"+NAponumberID1+"')]"));
        wait.until(ExpectedConditions.visibilityOf(NAponumberID2));
		wait.until(ExpectedConditions.visibilityOf(Menuhealder));
		Menuhealder.click();
		NAponumberID2.isDisplayed();
	
	}
	
	public void InvoiceSearchPaybyInvoice() throws InterruptedException, IOException {
		
		
		
		String NAponumberID1 = ExcelReadOperations.GetDataFromExcel("D2ER",2,2);
		
       
		wait.until(ExpectedConditions.visibilityOf(manageFinance));
		wait.until(ExpectedConditions.visibilityOf(Invoicesbutton));
		Invoicesbutton.click();
		
		wait.until(ExpectedConditions.visibilityOf(Paymentmethod));
		Paymentmethod.click();
		wait.until(ExpectedConditions.visibilityOf(PMethodPaybyInvoice));
		PMethodPaybyInvoice.click();
		
		//Invoicefromdate.sendKeys(random.CurrentDate());
		//Invoicetodate.sendKeys(random.CurrentDate());
		
		wait.until(ExpectedConditions.visibilityOf(SearchInvoice));
		SearchInvoice.click();
		reuse.waitForLoaderToBeClosed();
		wait.until(ExpectedConditions.visibilityOf(ResultlintingInvoice));
		ResultlintingInvoice.click();
		reuse.waitForLoaderToBeClosed();
		Thread.sleep(5000);
		WebElement NAponumberID=driver.findElement(By.xpath("//tbody[@id='d2er-mf-invoice-tbody']//span[contains(text(),'"+NAponumberID1+"')]"));
		wait.until(ExpectedConditions.visibilityOf(NAponumberID));
		wait.until(ExpectedConditions.visibilityOf(actionbn));
		actionbn.click();
		wait.until(ExpectedConditions.visibilityOf(dwnloadbtn));
		dwnloadbtn.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(actionbn));
		actionbn.click();
		wait.until(ExpectedConditions.visibilityOf(Viewdetails));
		Viewdetails.click();
		wait.until(ExpectedConditions.visibilityOf(closebtn));
		closebtn.click();
		Thread.sleep(5000);
		
	}



public void ManageFinancePaymentMethod() throws InterruptedException, IOException {
	wait.until(ExpectedConditions.visibilityOf(manageFinance));
	wait.until(ExpectedConditions.visibilityOf(PaymentMethod));
	PaymentMethod.click();
	
	wait.until(ExpectedConditions.visibilityOf(actionbn01));
	actionbn01.click();
	wait.until(ExpectedConditions.visibilityOf(Updatebtn));
	Updatebtn.click();
	 ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(1));
	reuse.waitForLoaderToBeClosed();
	
	wait.until(ExpectedConditions.visibilityOf(AccountName));
	wait.until(ExpectedConditions.visibilityOf(AccountNumbere));
	wait.until(ExpectedConditions.visibilityOf(sortCode));
	wait.until(ExpectedConditions.visibilityOf(UpdateAutorization));
	UpdateAutorization.click();
	
	
}
}
