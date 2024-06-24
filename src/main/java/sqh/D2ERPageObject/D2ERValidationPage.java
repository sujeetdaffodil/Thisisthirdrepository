package sqh.D2ERPageObject;

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

import resources.reusableoperations.RandomStringGeneratorOperations;
import resources.reusableoperations.ReusableObjects;

public class D2ERValidationPage {
	
	@FindBy(id="loader-wrap")
	private WebElement loadingicon;
	
	@FindBy(css="#menutoggle")
	private WebElement sideMenuToggle;
	
	@FindBy(css="#sm-dashboard")
	private WebElement homeMenu;
	
	@FindBy(css="#sm-employee")
	private WebElement manageEmpMenu;
	
	@FindBy(css="#sm-activity-log")
	private WebElement activityLogMenu;
	
	@FindBy(css="#sm-account-info")
	private WebElement accountInfoMenu;
	
	@FindBy(css="#sm-my-profile")
	private WebElement myProfileMenu;
	
	@FindBy(css="#sm-mi-report")
	private WebElement miReportMenu;
	
	@FindBy(css="#sm-d2er")
	private WebElement d2erMenu;
	
	@FindBy(css="#menuHeader")
	private WebElement d2erHeader;
	
	@FindBy(css="#userNameDet")
	private WebElement userName;
	
	@FindBy(css="#employee_first_name")
	private WebElement firstNameField;
	
	@FindBy(css="#employee_last_name")
	private WebElement lastNameField;
	
	@FindBy(css="#employee_email_address")
	private WebElement emailField;
	
	@FindBy(xpath="//*[@data-id='employee_status']")
	private WebElement statusDropdown;
	
	@FindBy(xpath="//button[@data-id='employee_product_type']")
	private WebElement productTypeDropdown;
	
	@FindBy(css=".footer")
	private WebElement d2erFooter;
	
	@FindBy(css=".logo-div")
	private WebElement sqhLogo;
	
	@FindBy(css="#employee_search_button")
	private WebElement searchBtn;
	
	@FindBy(css="#dropdownMenutbMore")
	private WebElement moreActionBtn;
	
	@FindBy(css=".custom-checkbox input")
	private List<WebElement> customCheckBox;
	
	@FindBy(css="#edit-multiple-employee")
	private WebElement moreActionEditRef;
	
	@FindBy(css="#resend-invitation-multi-employee")
	private WebElement moreActionResendInv;
	
	@FindBy(css="#re-register-multi-employee")
	private WebElement moreActionReRegister;
	
	@FindBy(css="#de-register-from-products")
	private WebElement moreActionDeRegister;
	
	@FindBy(css="#bs-select-1 li")
	private List<WebElement> statusOptions;
	
	@FindBy(css="#bs-select-2 li")
	private List<WebElement> productOptions;
	
	@FindBy(css="#bs-select-1-0")
	private WebElement statusOptionActive;
	
	@FindBy(css="#bs-select-2-0")
	private WebElement productTypeOption;
	
	@FindBy(css="#search-customer-tb .odd:nth-child(1) .ellipse:nth-child(4) span")
	private WebElement firstRowEmail;
	
	@FindBy(css="#search-customer-tb .odd:nth-child(1) .ellipse:nth-child(8) span")
	private WebElement firstRowRefNumber;

	@FindBy(css="#total-count")
	private WebElement tableCount;
	
	@FindBy(css="#employee-clear-btn")
	private WebElement clearBtn;
	
	@FindBy(css="#clear-invoice-button")
	private WebElement clearInvoiceBtn;
	
	@FindBy(css="#search-invoice-button")
	private WebElement searchInvoiceBtn;
	
	@FindBy(css="#employee_reference_number")
	private WebElement referenceNumberField;
	
	@FindBy(css="#search-customer-tb td")
	private WebElement blankTable;
	
	@FindBy(css="#dropdown-logout-btn")
	private WebElement logoutBtn;
	
	@FindBy(css="#add_employee_modal")
	private WebElement addEmployeeBtn;

	@FindBy(css="#add-manually-select")
	private WebElement addManually;
	
	@FindBy(css="#bulk-de-register-btn1")
	private WebElement bulkDeregisterBtn;
	
	@FindBy(css="#csv_import_progress")
	private WebElement importHistoryBtn;
	
	@FindBy(css="#export_employee")
	private WebElement exportEmpBtn;
	
	@FindBy(css = "#add-employee-next")
	private WebElement addEmployeeNextBtn;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//input[@type='email']")
	private WebElement addEmpemailField;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//input[@type='text']")
	private WebElement addEmpRefField;
	
	@FindBy(css = ".inline-validation-error")
	private WebElement emailErrorMsg;
	
	@FindBy(css = "#employee-cancel-btn")
	private WebElement EmpModalCancelBtn;
	
	@FindBy(css = "#import-employees-select")
	private WebElement importEmpBtn;
	
	@FindBy(css = "#add-employee-back-btn")
	private WebElement backBtn;
	
	@FindBy(xpath = "//*[@id='add-employee-menu']//button[contains(text(),'Cancel')]")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//*[@type='button']")
	private WebElement empFirstRowProductType;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//a[@id='bs-select-5-0']")
	private WebElement productTypeGPFirst;
	
	@FindBy(css = "#add-employee-manually")
	private WebElement inviteBtn;
	
	@FindBy(css = "#nav_billing_account")
	private WebElement billingAccountMenu;
	
	@FindBy(css = "#nav_finance_heading")
	private WebElement manageFinanceSection;
	
	@FindBy(css = "#nav_manage_payment_method")
	private WebElement paymentMethodMenu;
	
	@FindBy(css = "#nav_manage_invoice")
	private WebElement invoiceMenu;
	
	@FindBy(css="#d2er-billing-accounts-table thead th")
	private List<WebElement> billingAccHeader;
	
	@FindBy(css="#d2er-mf-paym-tbody #dropdownMenutb1")
	private List<WebElement> billingAccountActionBtn;
	
	@FindBy(css=".dropdown-item.manage-btn")
	private List<WebElement> manageAccountBtn;
	
	@FindBy(css=".pg-top-cont h2")
	private WebElement manageFinanceHeader;
	
	@FindBy(css="#edit-vat-number")
	private WebElement editVatNumber;
	
	@FindBy(css="#view-agreement-btn")
	private WebElement viewAgreementBtn;
	
	@FindBy(css=".d2er-man-biling p")
	private List<WebElement> ManageBillingAccHeadings;
	
	@FindBy(css="#vat-number-input")
	private WebElement editVatField;
	
	@FindBy(css="#vat-update-cancel")
	private WebElement vatUpdateCancel;
	
	@FindBy(css="#vat-update-save")
	private WebElement vatUpdateSaveBtn;
	
	@FindBy(xpath="//*[@id='edit-vat-number']/preceding-sibling::span")
	private WebElement vatNumber;
	
	@FindBy(css=".inline-validation-error")
	private WebElement vatErrorMsg;
	
	@FindBy(css="#viewerviewer")
	private WebElement pdfPreview;
	
	@FindBy(xpath="//button[@data-id='contract_id']")
	private WebElement contractID;
	
	@FindBy(css="#invoice-from")
	private WebElement invoiceFromDate;
	
	@FindBy(css="#invoice-to")
	private WebElement invoiceToDate;
	
	@FindBy(xpath="//button[@data-id='invoice_status']")
	private WebElement invoiceStatus;
	
	@FindBy(css="#bs-select-2-0")
	private WebElement invoicePaidStatus;
	
	@FindBy(css="#bs-select-2-1")
	private WebElement invoicePendingStatus;
	
	@FindBy(css="#bs-select-2-2")
	private WebElement invoiceOverdueStatus;

	@FindBy(css="#bs-select-1-0")
	private WebElement contractIDFirst;
	
	@FindBy(css="#bs-select-1-1")
	private WebElement contractIDSecond;
	
	@FindBy(css="#total-count")
	private WebElement searchResultCount;
	
	@FindBy(css="#export_invoice_data")
	private WebElement invoiceExportCSV;
	
	@FindBy(css="#d2er-mf-invoice-tbody tr")
	private List<WebElement> d2erInvoiceTableRows;
	
	@FindBy(css="#d2er-mf-invoice-tbody tr td:nth-child(2)")
	private WebElement firstRowInvoiceNumber;
	
	@FindBy(css="#d2er-mf-invoice-tbody .odd td")
	private WebElement blankInvoiceTable;
	
	@FindBy(css="#d2er-mf-invoice-tabel")
	private WebElement resultTable;
	
	
	
	WebDriver driver;
	WebDriverWait wait;
	ReusableObjects reuse;
	RandomStringGeneratorOperations randomGenerate;
	
	public D2ERValidationPage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse=new ReusableObjects(driver);
		randomGenerate = new RandomStringGeneratorOperations();
	}
	
	public void SideMenuValidations()
	{
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(sideMenuToggle));
		wait.until(ExpectedConditions.visibilityOf(homeMenu));
		wait.until(ExpectedConditions.visibilityOf(manageEmpMenu));
		wait.until(ExpectedConditions.visibilityOf(activityLogMenu));
		wait.until(ExpectedConditions.visibilityOf(accountInfoMenu));
		wait.until(ExpectedConditions.visibilityOf(myProfileMenu));
		wait.until(ExpectedConditions.visibilityOf(miReportMenu));
		wait.until(ExpectedConditions.visibilityOf(d2erMenu));
	}
	
	public void D2ERPageValidations()
	{	
		d2erHeader.isDisplayed();
		sqhLogo.isDisplayed();
		userName.isDisplayed();
		userName.click();
		logoutBtn.isDisplayed();
		firstNameField.isDisplayed();
		firstNameField.click();
		lastNameField.isDisplayed();
		emailField.isDisplayed();
		statusDropdown.isDisplayed();
		statusDropdown.click();
		Assert.assertTrue(statusOptions.size()>0);
		productTypeDropdown.isDisplayed();
		productTypeDropdown.click();
		Assert.assertTrue(productOptions.size()>0);
		bulkDeregisterBtn.isDisplayed();
		bulkDeregisterBtn.isEnabled();
		addEmployeeBtn.isDisplayed();
		addEmployeeBtn.isEnabled();
		importHistoryBtn.isDisplayed(); 
		importHistoryBtn.isEnabled();
		exportEmpBtn.isDisplayed();
		exportEmpBtn.isEnabled();
		d2erFooter.isDisplayed();
	}
	
	public void D2ERTableValidations()
	{	driver.navigate().refresh();
		moreActionBtn.isDisplayed();
		Assert.assertTrue(customCheckBox.size()>0);
		customCheckBox.get(0).click();
			Assert.assertTrue(customCheckBox.get(0).isSelected());
		customCheckBox.get(1).click();
		Assert.assertTrue(customCheckBox.get(1).isSelected());
		Assert.assertEquals(true, moreActionBtn.isEnabled());
		moreActionBtn.click();
		moreActionEditRef.isDisplayed();
		moreActionResendInv.isDisplayed();
		moreActionReRegister.isDisplayed();
		moreActionDeRegister.isDisplayed();
	}

	public void D2ERSearchFiltersValidations()
	{
	driver.navigate().refresh();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	wait.until(ExpectedConditions.visibilityOf(productTypeDropdown));
	productTypeDropdown.click();
	String checkSelection = productTypeOption.getAttribute("aria-selected");
	Assert.assertFalse(false, checkSelection);
	productTypeOption.click();
	Assert.assertTrue(true, checkSelection);
	productTypeOption.click();
	Assert.assertFalse(false, checkSelection);
	productTypeOption.click();
	Assert.assertTrue(true, checkSelection);
	}
	
	public void EmailSearchValidation()
	{
	driver.navigate().refresh();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	String emailFirstRow = firstRowEmail.getText();
	emailField.clear();
	emailField.sendKeys(emailFirstRow);
	searchBtn.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	String msg[] = tableCount.getText().split(" ");
	Assert.assertEquals(msg[0], "1");
	Assert.assertEquals(firstRowEmail.getText(), emailFirstRow);
	clearBtn.click();
	}
	
	public void BlankSearchValidation()
	{
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	referenceNumberField.isDisplayed();
	referenceNumberField.sendKeys("Test");
	searchBtn.click();
	String blankText = blankTable.getText();
	blankText.equalsIgnoreCase("No matching records found");
	}
	
	public void AddEmployeeValidations()
	{
	driver.navigate().refresh();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	addEmployeeBtn.click();
	importEmpBtn.isDisplayed();
	addManually.isDisplayed();
	cancelBtn.click();
	reuse.CancelNoModal();
	addManually.click();
	addEmployeeNextBtn.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	addEmpemailField.isDisplayed();
	backBtn.isDisplayed();
	addEmpemailField.sendKeys("test");
	addEmpRefField.click();
	emailErrorMsg.isDisplayed();
	EmpModalCancelBtn.isDisplayed();
	EmpModalCancelBtn.click();
	reuse.CancelYesModal();
	Assert.assertTrue(d2erHeader.isDisplayed());
	}
	
	public void EmpReferenceNumberValidations(String randomEmail)
	{
	driver.navigate().refresh();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	String duplicateRef = firstRowRefNumber.getText();
	addEmployeeBtn.click();
	addManually.click();
	addEmployeeNextBtn.click();
	addEmpemailField.sendKeys(randomEmail);
	addEmpRefField.sendKeys(duplicateRef);
	empFirstRowProductType.click();
	productTypeGPFirst.click();
	inviteBtn.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	emailErrorMsg.isDisplayed();
	Assert.assertEquals(emailErrorMsg.getText(), "Employee reference number already exists");
	}
	
	public void FinanceSectionValidations() 
	{
	billingAccountMenu.isDisplayed();
	manageFinanceSection.isDisplayed();
	paymentMethodMenu.isDisplayed();
	invoiceMenu.isDisplayed();
	}
	
	public void BillingAccountValidations() 
	{
	driver.navigate().refresh();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	billingAccountMenu.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	String[] BillingAccountHeading =new String[billingAccHeader.size()];
		for(int i=0;i<billingAccHeader.size();i++)
		{
		BillingAccountHeading[i] = billingAccHeader.get(i).getAttribute("aria-label");
		}
			BillingAccountHeading[0].equalsIgnoreCase("Contract ID");
			BillingAccountHeading[1].equalsIgnoreCase("Product Name");
			BillingAccountHeading[2].equalsIgnoreCase("Date ");
			BillingAccountHeading[3].equalsIgnoreCase("No. of Licences");
			BillingAccountHeading[4].equalsIgnoreCase("No. of Licences Issued");
			BillingAccountHeading[5].equalsIgnoreCase("No. of Consumed Licences ");
			BillingAccountHeading[6].equalsIgnoreCase("Status");
			BillingAccountHeading[7].equalsIgnoreCase("Actions");
		}
	
	public void ManageBillingAccountValidations() 
	{
	billingAccountMenu.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	billingAccountActionBtn.get(0).isDisplayed();
	billingAccountActionBtn.get(0).click();
	manageAccountBtn.get(0).isDisplayed();
	manageAccountBtn.get(0).click();
	wait.until(ExpectedConditions.visibilityOf(manageFinanceHeader));
	manageFinanceHeader.getText().equalsIgnoreCase("Manage Billing Account");
	vatNumber.isDisplayed();
	editVatNumber.isDisplayed();
	viewAgreementBtn.isDisplayed();
	String[] ManageBillingAccountHeading =new String[ManageBillingAccHeadings.size()];
		for(int i=0;i<ManageBillingAccHeadings.size();i++)
		{
			ManageBillingAccountHeading[i] = ManageBillingAccHeadings.get(i).getText();
		}
		ManageBillingAccountHeading[0].equalsIgnoreCase("Contract Details");
		ManageBillingAccountHeading[1].equalsIgnoreCase("Agreement");
		ManageBillingAccountHeading[2].equalsIgnoreCase("Services & Benefits");
	}
	
	public void ManageBillingAccFunctions() 
	{
	wait.until(ExpectedConditions.visibilityOf(editVatNumber));
	editVatNumber.click();
	editVatField.clear();
	String editVatClassname = editVatField.getAttribute("class");
	Assert.assertTrue(editVatClassname.contains("error"));
	String incorrectVatNumberGenerate = randomGenerate.generateRandomString(5);
	editVatField.sendKeys(incorrectVatNumberGenerate);
	wait.until(ExpectedConditions.visibilityOf(vatErrorMsg));
	vatErrorMsg.isDisplayed();
	Assert.assertEquals(vatErrorMsg.getText(), "VAT Number must contain 9 or 10 digits");

	String vatNumberGenerate = randomGenerate.generateUserNumber();
	editVatField.clear();
	editVatField.sendKeys(vatNumberGenerate);
	vatUpdateCancel.isDisplayed();
	vatUpdateCancel.click();
	reuse.CancelNoModalType2();
	vatUpdateSaveBtn.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	reuse.validateSuccessMsg();
	vatNumberGenerate.equalsIgnoreCase(vatNumber.getText());
		
	}

	public void viewAgreementValidations() throws InterruptedException 
	{
	viewAgreementBtn.isDisplayed();
	viewAgreementBtn.click();
	ArrayList<String> switchTabs= new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(switchTabs.get(1));
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	Thread.sleep(15000);	
	pdfPreview.isDisplayed();
	driver.close();
	driver.switchTo().window(switchTabs.get(0));
	wait.until(ExpectedConditions.visibilityOf(manageFinanceHeader));
	}

	public void InvoiceValidations() 
	{
	driver.navigate().refresh();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	invoiceMenu.click();
	wait.until(ExpectedConditions.visibilityOf(manageFinanceHeader));
	manageFinanceHeader.getText().equalsIgnoreCase("Invoices");
	contractID.isDisplayed();
	contractID.click();
		contractIDFirst.isDisplayed();
		contractIDSecond.isDisplayed();
	invoiceFromDate.isDisplayed();
	invoiceToDate.isDisplayed();
	invoiceStatus.isDisplayed();
	invoiceStatus.click();
		invoicePaidStatus.isDisplayed();
		invoicePendingStatus.isDisplayed();
		invoiceOverdueStatus.isDisplayed();
	clearInvoiceBtn.isDisplayed();
	searchInvoiceBtn.isDisplayed();
	Assert.assertFalse(searchResultCount.isDisplayed());	
	}

	public void InvoiceFunctionValidations() 
	{
	searchResultCount.isDisplayed();
	invoiceExportCSV.isDisplayed();
	contractID.click();
		contractIDFirst.click();
		contractIDSecond.click();
	searchInvoiceBtn.click();
	searchResultCount.isDisplayed();
	d2erInvoiceTableRows.get(0).isDisplayed();
	String firstRowInvoiceNo = firstRowInvoiceNumber.getText();
	paymentMethodMenu.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	invoiceMenu.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));	
	Assert.assertEquals(firstRowInvoiceNo, firstRowInvoiceNumber.getText());
	}
	
	public void InvoiceClearBtnCheck() 
	{
		clearInvoiceBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	}
	
	public void NoRecordInvoiceValidation() 
	{
	invoiceFromDate.sendKeys("01/11/1995");
	invoiceToDate.sendKeys("02/11/1995");
	searchInvoiceBtn.click();
	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	Assert.assertTrue(searchResultCount.getText().equalsIgnoreCase("0 Records found"));
	Assert.assertTrue(blankInvoiceTable.getText().equalsIgnoreCase("No matching records found"));
	}
	
}