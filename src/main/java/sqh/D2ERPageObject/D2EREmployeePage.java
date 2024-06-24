package sqh.D2ERPageObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.exceloperations.ExcelReadOperations;
import resources.exceloperations.ExcelWriteOperations;
import resources.reusableoperations.RandomStringGeneratorOperations;
import resources.reusableoperations.ReusableObjects;
import resources.webdriveroperations.WebDriverOperations;

public class D2EREmployeePage {
	public WebDriver driver;

	@FindBy(xpath="//button[@class='btn btn-outline' and @id='add-employee-btn']")
	private WebElement checkStatus;

	@FindBy(css="#add_employee_modal")
	private WebElement addEmployee;

	@FindBy(css="#add-manually-select")
	private WebElement addManually;

	@FindBy(css="#import-employees-select")
	private WebElement importEmployees;

	@FindBy(xpath="//*[@id='add-employee-element']//*[contains(text(),'Email')]/preceding-sibling::input")
	private WebElement employeeEmailField;

	@FindBy(xpath="//*[@id='add-employee-element']//*[contains(text(),'Reference')]/preceding-sibling::input")
	private WebElement employeeReferenceField;

	@FindBy(xpath="//*[@id='add-employee-element']//*[contains(text(),'Reference')]/preceding-sibling::input")
	private List<WebElement> employeeReferenceFieldList;

	@FindBy(xpath = "//*[@id='add-employee-element']//child::button")
	private WebElement addNewEmployeeFieldBtn;

	@FindBy(xpath="//a[@class='dropdown-item']")
	private WebElement productType;

	@FindBy(id="add-employee-manually")
	private WebElement inviteEmp;

	@FindBy(id="btn-threshold-yes")
	private WebElement acceptModal;

	@FindBy(id="user-success-modal-ok")
	private WebElement SuccessModalOk;

	@FindBy(xpath="//a[@id='employee_add_btn']")
	private WebElement addUserRow;

	@FindBy(xpath="//*[@id= 'add_employee_row_0']//input")
	private WebElement firstEmpEmail;
	
	@FindBy(xpath="//*[@id= 'add_employee_row_1']//input")
	private WebElement secondEmpEmail;
	
	@FindBy(xpath="//*[@id= 'add_employee_row_2']//input")
	private WebElement thirdEmpEmail;
	
	@FindBy(xpath="//*[@id= 'add_employee_row_3']//input")
	private WebElement fourthEmpEmail;
	
	@FindBy(xpath="//*[@id= 'add_employee_row_4']//input")
	private WebElement fifthEmpEmail;

	@FindBy(xpath="//*[@id='add_employee_row_0']//li")
	private List<WebElement> selectAnotherProduct;

	@FindBy(xpath="//*[@id='add_employee_rows_container']//button")
	private List<WebElement> multipleProductFields;

	@FindBy(id="cr-upload-csv-btn")
	private WebElement uploadBtn;

	@FindBy(id="csvUploadModal")
	private WebElement csvUploadModal;

	@FindBy(className="eb-inline-error")
	private WebElement errorMsg;

	@FindBy(id="csv-upload-btn")
	private WebElement enabledUpload;

	@FindBy(id="upload-gip-progress-text")
	private WebElement uploadProgress;

	@FindBy(id="import-gip-progress-text")
	private WebElement validationProgress;

	@FindBy(css="#csv-import-completion-btn")
	private WebElement confirmDoneBtn;

	@FindBy(id="successModal")
	private WebElement successOkBtn;

	@FindBy(id="loader-wrap")
	private WebElement loadingicon;

	@FindBy(xpath="//td[contains(.,'Unregistered')][1]//following::div[@class='dropdown action-dropdown']")
	private WebElement actionItem;

	@FindBy(css="#csv-add-member-finish-btn")
	private WebElement csvImportCompleteBtn;

	@FindBy(css="#add_employee_row_remove_btn_4")
	private WebElement removeLastEmployeeField;

	@FindBy(css="#csvGipMember .filter-option")
	private WebElement modalProductType;

	@FindBy(xpath="//*[@class='upload-btn-wrapper']/child::button")
	private WebElement browseFilesBtn;

	@FindBy(xpath="//span[contains(text(),'@')]")
	private List<WebElement> emailDeregister;

	@FindBy(xpath="//*[@id='search-customer-tb']//*[@class=' text-center']/div")
	private List<WebElement> actionsBtnTable;

	@FindBy(xpath="//a[contains(text(),'De-Register User')]")
	private List<WebElement> deregisterGIPBtnTable;

	@FindBy(xpath="//input[@id='employee_email_address']")
	private WebElement searchEmailField;

	@FindBy(css="#employee_search_button")
	private WebElement searchBtn;
	
	@FindBy(xpath="//td[contains(text(), 'De-Registered')]")
	private WebElement emailDeregisteredText;

	@FindBy(xpath="//span[contains(text(), 'Unregistered')]")
	private WebElement searchUnregisteredDropdownList;

	@FindBy(css="[data-id='employee_status']")
	private WebElement searchStatusBtn;	
	
	@FindBy(css="#search-customer-tb td")
	private WebElement tableEmpty;	

	@FindBy(css="#search-customer-tb td:nth-child(4) span")
	private List<WebElement> tableEmailFields;	
	
	@FindBy(css="#search-customer-tb td:nth-child(8) span")
	private List<WebElement> tableEmpReferenceFields;	
	
	@FindBy(css="#search-customer-tb td:nth-child(5)")
	private List<WebElement> tablesStatusFields;	
	
	@FindBy(css="#bulk-de-register-btn1")
	private WebElement bulkDeregisterBtn;	

	@FindBy(css="[data-id='cr-product-type']>div")
	private WebElement modalProductTypeBtn;	

	@FindBy(css = "#bs-select-3-1")
	private WebElement productTypeGIP;	

	@FindBy(css = ".upload-btn-file.upload-csv")
	private WebElement csvUploadBtn;	

	@FindBy(css = "#browse-member-csv")
	private WebElement browseCsvBtn;

	@FindBy(css = ".csv-msg")
	private WebElement fileUploadValidation;

	@FindBy(xpath = "//span[contains(text(), 'validated')]")
	private WebElement fileUploadValidationSuccess;

	@FindBy(css = "#export_employee")
	private WebElement exportEmployeesBtn;
	
	@FindBy(css = ".edit-employee-btn")
	private WebElement editReferenceNumberBtn;

	@FindBy(css = "#employee-reference-0")
	private WebElement editReferenceTextField;
	
	@FindBy(css = "#save-employee-detail")
	private WebElement saveEmpDetailsBtn;
	
	@FindBy(css = ".employee-re-register-btn")
	private WebElement reRegisterBtn;
	
	@FindBy(css = ".employee-resend-invitation-btn")
	private WebElement resendInviteBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Import')]")
	private WebElement importHistoryBtn;
	
	@FindBy(css = "#add-employee-next")
	private WebElement addEmployeeNextBtn;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//*[@type='email']")
	private WebElement addEmpFirstRowEmail;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//*[@type='text']")
	private WebElement addEmpFirstRowRefNo;
	
	@FindBy(xpath = "//*[@id='add_employee_row_1']//*[@type='text']")
	private WebElement addEmpSecondRowRefNo;
	
	@FindBy(xpath = "//*[@id='add_employee_row_2']//*[@type='text']")
	private WebElement addEmpThirdRowRefNo;
	
	@FindBy(xpath = "//*[@id='add_employee_row_3']//*[@type='text']")
	private WebElement addEmpFourthRowRefNo;
	
	@FindBy(xpath = "//*[@id='add_employee_row_4']//*[@type='text']")
	private WebElement addEmpFifthRowRefNo;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//*[@type='button']")
	private WebElement empFirstRowProductType;
	
	@FindBy(xpath = "//*[@id='add_employee_row_1']//*[@type='button']")
	private WebElement empSecondRowProductType;
	
	@FindBy(xpath = "//*[@id='add_employee_row_2']//*[@type='button']")
	private WebElement empThirdRowProductType;
	
	@FindBy(xpath = "//*[@id='add_employee_row_3']//*[@type='button']")
	private WebElement empFourthRowProductType;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//a[@id='bs-select-5-0']")
	private WebElement productTypeGPFirst;
	
	@FindBy(xpath = "//*[@id='add_employee_row_1']//a[@id='bs-select-6-3']")
	private WebElement productTypeGPSecond;
	
	@FindBy(xpath = "//*[@id='add_employee_row_2']//a[@id='bs-select-7-3']")
	private WebElement productTypeGPThird;
	
	@FindBy(xpath = "//*[@id='add_employee_row_3']//a[@id='bs-select-8-3']")
	private WebElement productTypeGPFourth;
	
	@FindBy(xpath = "//*[@id='add_employee_row_0']//a[@id='bs-select-5-2']")
	private WebElement selectAnotherProductType;
	
	@FindBy(css = "#add-employee-manually")
	private WebElement inviteBtn;
	
	@FindBy(css = "#deregister-date")
	private WebElement deregisterDateField;
	
	@FindBy(css = "#deregister-reason")
	private WebElement deregisterReason;
	
	@FindBy(css = "#de-register-submit")
	private WebElement deregisterSubmitBtn;
	
	@FindBy(css = "body .themeHeaderInner")
	private WebElement eCommerceHeader;
	
	public ReusableObjects reuse;
	private WebDriverWait wait;
	private String pattern = "dd/MM/yyyy";
	static String workspacePath= System.getProperty("user.dir");
	public static JavascriptExecutor _js;
	public RandomStringGeneratorOperations randomGenerate;
	List<String> emails = new ArrayList<String>();
	List<String> multipleEmails = new ArrayList<String>();
	String empPageUrl = "https://dev-qa-sqheb-mfm-web.square-health.co.uk/employee";

	public D2EREmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		this.reuse = new ReusableObjects(driver);
		randomGenerate = new RandomStringGeneratorOperations();
	}

	//...below method used to Click Add Employee button on Employee page of website

	public void ClickAddEmployeeBtn()
	{	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(addEmployee));
		addEmployee.click();
	}

	//...below method used to click Add Manually button on Employee page of website
	public void ClickAddManuallyBtn()
	{	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(addManually));
		addManually.click();

	}

	//...below method used to Click Import Employees button on Employee page
	public void AddEmployeeImport()
	{	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.elementToBeClickable(importEmployees));
		importEmployees.click();
	}

	//Entering Reference Number in required field and variable 'i' is passed to identify correct employee reference field by index
	public void AddEmployeeRefrenceNumber(int i) {

		String EmpRefNumber=RandomStringGeneratorOperations.randomString(15);
		wait.until(ExpectedConditions.visibilityOf(employeeReferenceField));
		employeeReferenceField.sendKeys(EmpRefNumber);
	}

	public void AddEmployeeRefrenceNumberinList(int i) {

		String EmpRefNumber=RandomStringGeneratorOperations.randomString(15);
		wait.until(ExpectedConditions.visibilityOf(employeeReferenceField));
		employeeReferenceFieldList.get(i).sendKeys(EmpRefNumber);
	}

	//Entering Employee Email Id from EXCEL SHEET to field on Employee Page
	public void AddEmployeeEmail(String username) throws IOException
	{	wait.until(ExpectedConditions.visibilityOf(employeeEmailField));
	//	employeeEmailField.clear();
		employeeEmailField.sendKeys(username);

	}

	// Selecting Product Type while adding employee manually
	public void SelectProduct()
	{
		_js=WebDriverOperations.initiateJavaScriptExecutor( driver);
		_js.executeScript("arguments[0].click()", addNewEmployeeFieldBtn );
		wait.until(ExpectedConditions.visibilityOf(addNewEmployeeFieldBtn));
		wait.until(ExpectedConditions.elementToBeClickable(productType));
		_js.executeScript("arguments[0].click()", productType );				

	}

	//...Clicking on Invite button while adding employee manually	
	public void Invite()
	{
		_js=WebDriverOperations.initiateJavaScriptExecutor( driver);
		wait.until(ExpectedConditions.visibilityOf(inviteEmp));
		_js.executeScript("arguments[0].click()", inviteEmp);
	}

	//...Clicking on Return to Employee button displayed on Modal	
	public void Returntoemployee()
	{
		_js=WebDriverOperations.initiateJavaScriptExecutor( driver); 
		wait.until(ExpectedConditions.visibilityOf(SuccessModalOk));
		_js.executeScript("arguments[0].click()", SuccessModalOk);

	}
	//...Adding Multiple Employees email	
	public void AddMultipleEmployees(int numberOfEmployees) throws IOException, InterruptedException {
		driver.get(empPageUrl);
		ClickAddEmployeeBtn();
		ClickAddManuallyBtn();
		wait.until(ExpectedConditions.visibilityOf(addEmployeeNextBtn));
		addEmployeeNextBtn.click();
			
		//Saving Emails in array
		for (int i = 1; i < numberOfEmployees; i++)
			{	wait.until(ExpectedConditions.visibilityOf(addUserRow));
				addUserRow.click();
				String cell=ExcelReadOperations.GetDataFromExcel("EmpAddManually",i,0);
				multipleEmails.add(cell) ;
			}
		
		//Adding User Emails/Reference Number / Product Types
			firstEmpEmail.sendKeys(multipleEmails.get(0));
			addEmpFirstRowRefNo.sendKeys(randomGenerate.generateReferenceNumber());
			firstEmpEmail.click();
			empFirstRowProductType.click();
			productTypeGPFirst.click();
			
			secondEmpEmail.sendKeys(multipleEmails.get(1));
			addEmpSecondRowRefNo.sendKeys(randomGenerate.generateReferenceNumber());
			secondEmpEmail.click();
			empSecondRowProductType.click();
			productTypeGPSecond.click();
			
			thirdEmpEmail.sendKeys(multipleEmails.get(2));
			addEmpThirdRowRefNo.sendKeys(randomGenerate.generateReferenceNumber());
			thirdEmpEmail.click();
			empThirdRowProductType.click();
			productTypeGPThird.click();
			
			fourthEmpEmail.sendKeys(multipleEmails.get(3));
			addEmpFourthRowRefNo.sendKeys(randomGenerate.generateReferenceNumber());
			fourthEmpEmail.click();
			empFourthRowProductType.click();
			productTypeGPFourth.click();
			
			
		WebDriverOperations.BrowserWindowScroll(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(removeLastEmployeeField));
		removeLastEmployeeField.click();
		wait.until(ExpectedConditions.visibilityOf(inviteEmp));
		inviteEmp.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		Thread.sleep(10000);
		reuse.validateSuccessMsg();
	}

	public boolean checkstatus(){
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(checkStatus));
			return true;

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void SearchUnregisteredEmployees()
	{	driver.get(empPageUrl);
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(searchStatusBtn));
		searchStatusBtn.click();
		wait.until(ExpectedConditions.visibilityOf(searchUnregisteredDropdownList));
		searchUnregisteredDropdownList.click();
		searchStatusBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		WebDriverOperations.BrowserWindowScroll(driver);

	}	

	public void GenerateCsv() throws IOException	 
	{
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		for(int i=0; i<3; i++){	
		emails.add(tableEmailFields.get(i).getText());
		}
		ExcelWriteOperations.GenerateDeregisterCsv(emails);
	}
	
	public void BulkDeregisterFromCsv() throws IOException, InterruptedException	 
	{	driver.get(empPageUrl);
		String fileToUpload = workspacePath+"/Importing_files/Deregisteredemp.csv";
//		String uploadScriptPath = "Scripts\\uploadFilesScript.exe";
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(bulkDeregisterBtn));
		bulkDeregisterBtn.click();
		wait.until(ExpectedConditions.visibilityOf(modalProductTypeBtn));
		modalProductTypeBtn.click();
		wait.until(ExpectedConditions.visibilityOf(productTypeGIP));
		productTypeGIP.click();
		wait.until(ExpectedConditions.visibilityOf(csvUploadBtn));
		csvUploadBtn.click();
		Thread.sleep(10000);
	//	Actions a = new Actions(driver);
	//	a.moveToElement(browseCsvBtn).build().perform();
	//	a.click(browseCsvBtn).build().perform();
		
		browseCsvBtn.sendKeys(fileToUpload);

	//	Runtime.getRuntime().exec(uploadScriptPath+" "+fileToUpload);
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", enabledUpload);
		enabledUpload.click();
		Assert.assertFalse(browseCsvBtn.isEnabled());
			if(fileUploadValidationSuccess.isDisplayed())
			{
				csvImportCompleteBtn.click();
			}
			else { 
				Assert.assertFalse(false, "File Upload failed");
			}
		wait.until(ExpectedConditions.visibilityOf(confirmDoneBtn));
		confirmDoneBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		Thread.sleep(3000);
		reuse.validateSuccessMsg();
	}

	public void AddEmployeeFromCsv(String emailForImport) throws IOException, InterruptedException
	{	driver.get(empPageUrl);
		ExcelWriteOperations.GenerateImportCsv(emailForImport);
		String fileToUpload = workspacePath+"/Importing_files/ImportEmployees.csv";
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(addEmployee));
		addEmployee.click();
		wait.until(ExpectedConditions.visibilityOf(importEmployees));
		importEmployees.click();
		wait.until(ExpectedConditions.visibilityOf(addEmployeeNextBtn));
		addEmployeeNextBtn.click();
		wait.until(ExpectedConditions.visibilityOf(modalProductTypeBtn));
		modalProductTypeBtn.click();
		wait.until(ExpectedConditions.visibilityOf(productTypeGIP));
		productTypeGIP.click();
		wait.until(ExpectedConditions.visibilityOf(csvUploadBtn));
		csvUploadBtn.click();
		Thread.sleep(4000);
	//	Actions a = new Actions(driver);
	//	a.moveToElement(browseCsvBtn).build().perform();
	//	a.click(browseCsvBtn).build().perform();
		
		browseCsvBtn.sendKeys(fileToUpload);

		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", enabledUpload);
		enabledUpload.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		Thread.sleep(3000);
		enabledUpload.click();

		if(fileUploadValidationSuccess.isDisplayed())
		{
			csvImportCompleteBtn.click();
		}
		else { 
			Assert.assertFalse(false, "File Upload failed");
		}
		wait.until(ExpectedConditions.visibilityOf(confirmDoneBtn));
		
		confirmDoneBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		Thread.sleep(3000);
		reuse.validateSuccessMsg();
	}

	public void ValidateExportEmployees() throws InterruptedException{	
		driver.get(empPageUrl);
		String exportFilepath= workspacePath+"/Exporting_files/Employees.csv";
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(exportEmployeesBtn));
		exportEmployeesBtn.click();
		Thread.sleep(4000);
		File fileHandler = new File(exportFilepath);
			if(fileHandler.exists())
			{
				Assert.assertTrue(fileHandler.exists());
				if(fileHandler.delete());
					{System.out.println("File Deleted");}
			}
	}
	
	public void ValidateEditEmployeeRefNumber() {
		driver.get(empPageUrl);
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		String existingRefNumber = tableEmpReferenceFields.get(0).getText();
		String emailOfUser = tableEmailFields.get(0).getText();
		wait.until(ExpectedConditions.visibilityOfAllElements(actionsBtnTable));
		Actions action = new Actions(driver);
		action.moveToElement(actionsBtnTable.get(0)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(editReferenceNumberBtn));
		editReferenceNumberBtn.click();
		String updatedRefNumber = randomGenerate.generateReferenceNumber();
		wait.until(ExpectedConditions.visibilityOf(editReferenceTextField));
		editReferenceTextField.clear();
		editReferenceTextField.sendKeys(updatedRefNumber);
		wait.until(ExpectedConditions.visibilityOf(saveEmpDetailsBtn));
		saveEmpDetailsBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		reuse.validateSuccessMsg();
		
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		searchEmailField.clear();
		searchEmailField.sendKeys(emailOfUser);
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		String newRefNumber = tableEmpReferenceFields.get(0).getText();
		if(!existingRefNumber.equalsIgnoreCase(updatedRefNumber))	
			{	newRefNumber.equalsIgnoreCase(updatedRefNumber);
			}
	}

	public void ImportHistory() {
		driver.get(empPageUrl);
		wait.until(ExpectedConditions.visibilityOf(importHistoryBtn));
		importHistoryBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	}
	
	public void AddSingleEmployee(String Email) throws InterruptedException
	{	driver.get(empPageUrl);
		ClickAddEmployeeBtn();
		ClickAddManuallyBtn();
		wait.until(ExpectedConditions.visibilityOf(addEmployeeNextBtn));
		addEmployeeNextBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		addEmpFirstRowEmail.sendKeys(Email);
		String refNumberGenerate = randomGenerate.generateUserNumber();
		addEmpFirstRowRefNo.sendKeys(refNumberGenerate);
		empFirstRowProductType.click();
		wait.until(ExpectedConditions.visibilityOf(productTypeGPFirst));
		productTypeGPFirst.click();
		selectAnotherProductType.click();
		WebDriverOperations.BrowserWindowScroll(driver);
		inviteBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		reuse.validateSuccessMsg();
	}
	
	public String SearchEmployeeViaEmail(String Email) throws InterruptedException
	{	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(searchEmailField));
		searchEmailField.sendKeys(Email);
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		Thread.sleep(15000);
			driver.navigate().refresh();
			wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		
		String emailMatch = tableEmailFields.get(0).getText();
		searchEmailField.clear();
		return emailMatch;
	}
	
	public void DeregisterUserFromAllProducts(String emailForDeregisterCheck) throws InterruptedException
	{  	driver.get(empPageUrl);
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		searchEmailField.clear();
		searchEmailField.sendKeys(emailForDeregisterCheck);
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		WebDriverOperations.BrowserWindowScroll(driver);
		String userCurrentStatus = tablesStatusFields.get(0).getText();
			if(userCurrentStatus.equalsIgnoreCase("De-Registered") || userCurrentStatus.equalsIgnoreCase("Registered"))
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(actionsBtnTable));
				actionsBtnTable.get(0).click();
				wait.until(ExpectedConditions.visibilityOf(reRegisterBtn));
				reRegisterBtn.click(); 
				reuse.acceptConfirmationDialog();
				wait.until(ExpectedConditions.invisibilityOf(loadingicon));
				reuse.validateSuccessMsg();
				Thread.sleep(10000);
				driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOf(searchBtn));
				searchBtn.click();
			}
		
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		WebDriverOperations.BrowserWindowScroll(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(actionsBtnTable));
		Actions a = new Actions(driver);
		a.moveToElement(actionsBtnTable.get(0)).build().perform();
		
		actionsBtnTable.get(0).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(deregisterGIPBtnTable));
		deregisterGIPBtnTable.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(deregisterDateField));
		
		String dateInString =new SimpleDateFormat(pattern).format(new Date());
		deregisterDateField.sendKeys(dateInString);
		Select objSelect =new Select((deregisterReason));
		objSelect.selectByIndex(1);
		
		deregisterSubmitBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		
		reuse.validateSuccessMsg();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(searchEmailField));
		searchEmailField.clear();
		SearchEmployeeViaEmail(emailForDeregisterCheck);
		Assert.assertEquals(emailDeregisteredText.getText(),("De-Registered"));

	}

	public void DeregisterUserFromSingleProduct(String emailForDeregisteringSingleProd) throws InterruptedException
	{  driver.get(empPageUrl);
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		searchEmailField.clear();
		searchEmailField.sendKeys(emailForDeregisteringSingleProd);
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		WebDriverOperations.BrowserWindowScroll(driver);
		String userCurrentStatus = tablesStatusFields.get(0).getText();
			if(userCurrentStatus.contentEquals("De-Registered") || userCurrentStatus.contentEquals("Registered"))
			{
				wait.until(ExpectedConditions.visibilityOfAllElements(actionsBtnTable));
				actionsBtnTable.get(0).click();
				wait.until(ExpectedConditions.visibilityOf(reRegisterBtn));
				reRegisterBtn.click(); 
				reuse.acceptConfirmationDialog();
				wait.until(ExpectedConditions.invisibilityOf(loadingicon));
				reuse.validateSuccessMsg();
				wait.until(ExpectedConditions.visibilityOf(searchBtn));
				searchBtn.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
			}
			
			
		
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		WebDriverOperations.BrowserWindowScroll(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(actionsBtnTable));
		Actions a = new Actions(driver);
		a.moveToElement(actionsBtnTable.get(0)).build().perform();
		
		actionsBtnTable.get(0).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(deregisterGIPBtnTable));
		deregisterGIPBtnTable.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(deregisterDateField));
		
		String dateInString =new SimpleDateFormat(pattern).format(new Date());
		deregisterDateField.sendKeys(dateInString);
		Select objSelect =new Select((deregisterReason));
		objSelect.selectByIndex(1);
		
		deregisterSubmitBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		
		reuse.validateSuccessMsg();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(searchEmailField));
		searchEmailField.clear();
		searchEmailField.sendKeys(emailForDeregisteringSingleProd);
		searchBtn.click();
		Assert.assertTrue(emailDeregisteredText.isDisplayed());

	}
	
	public void ResendInvitation() throws InterruptedException
	{
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		SearchUnregisteredEmployees();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOfAllElements(actionsBtnTable));
		Actions a = new Actions(driver);
		a.moveToElement(actionsBtnTable.get(0)).build().perform();
		actionsBtnTable.get(0).click();
		resendInviteBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		Thread.sleep(5000);
		reuse.validateSuccessMsg();
	}
	
	public void EcommerceRedirectValidation(String OrgEmail)
	{
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		String url = driver.getCurrentUrl();
			if(url.contains("communityprotal"))
					{	wait.until(ExpectedConditions.visibilityOf(eCommerceHeader));
					}
		
	}

}
