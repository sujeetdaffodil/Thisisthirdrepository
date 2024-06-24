package sqh.automation.D2ERTest;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.D2ERPageObject.D2ERDashboardPage;
import sqh.D2ERPageObject.D2ERLoginPage;
import sqh.D2ERPageObject.D2ERValidationPage;

public class D2ERValidationTest extends WebDriverOperations{
	
	D2ERValidationPage vp;
	D2ERLoginPage lp;
	D2ERDashboardPage dashboard;
	
	@Test(priority=1)
	public void LogintoCustomerAccount() throws IOException, InterruptedException{
		lp= new D2ERLoginPage(driver);
		lp.LoginwithUserQAEnv("First");
		
	}

	@Test(priority=2)
	public void SideMenuValidations() {
		vp = new D2ERValidationPage(driver); 
		vp.SideMenuValidations();
		
	}
	
	@Test(priority=3)
	public void NavigateToEmployeePage()
	{	
		dashboard = new D2ERDashboardPage(driver);
		WebDriverOperations.BrowserWindowScroll(driver);
		dashboard.NavigatetoD2ER();
	}


	@Test(priority=4)
	public void D2ERPagevalidations() {
		vp = new D2ERValidationPage(driver); 
		vp.D2ERPageValidations();
	}
	
	@Test(priority=5)
	public void D2ERTableValidations() {
		vp = new D2ERValidationPage(driver); 
		vp.D2ERTableValidations();
	}
	
	@Test(priority=6)
	public void D2ERSearchFiltersValidations() {
		vp = new D2ERValidationPage(driver); 
		vp.D2ERSearchFiltersValidations();
	}
	
	@Test(priority=7)
	public void EmailSearchValidation() {
		vp = new D2ERValidationPage(driver); 
		vp.EmailSearchValidation();
		vp.BlankSearchValidation();
	}
	
	@Test(priority=8)
	public void AddEmployeeValidations() {
		vp = new D2ERValidationPage(driver); 
		vp.AddEmployeeValidations();
	}
	
	@Test(priority=9)
	public void EmpReferenceNumberValidations() throws IOException {
		vp = new D2ERValidationPage(driver); 
		String newEmpEmail =ExcelReadOperations.GetDataFromExcel("EmpAddManually",3,0);
		vp.EmpReferenceNumberValidations(newEmpEmail);
	}
	
	@Test(priority=10)
	public void FinanceSectionValidations() throws IOException {
		vp = new D2ERValidationPage(driver); 
		vp.FinanceSectionValidations();
		vp.BillingAccountValidations();
		
	}
	
	@Test(priority=10)
	public void InvoiceValidations() throws IOException {
		vp = new D2ERValidationPage(driver);
		vp.InvoiceValidations();
		vp.InvoiceFunctionValidations();
		vp.InvoiceClearBtnCheck();
		vp.NoRecordInvoiceValidation();
	}
	
	@Test(priority=11)
	public void ManageBillingAccValidations() throws IOException, InterruptedException {
		vp = new D2ERValidationPage(driver);
		vp.ManageBillingAccountValidations();
		vp.ManageBillingAccFunctions();
	//	vp.viewAgreementValidations();
	}
	



}
