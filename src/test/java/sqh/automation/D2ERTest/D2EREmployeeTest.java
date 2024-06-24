package sqh.automation.D2ERTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.D2ERPageObject.D2ERDashboardPage;
import sqh.D2ERPageObject.D2EREmployeePage;
import sqh.D2ERPageObject.D2ERLoginPage;

public class D2EREmployeeTest extends WebDriverOperations{
	D2EREmployeePage ep;
	D2ERLoginPage lp;
	D2ERDashboardPage dashboard ;

	@Test(priority=1)
	public void LogintoCustomerAccount() throws IOException, InterruptedException{
		lp= new D2ERLoginPage(driver);
		lp.LoginwithUserQAEnv("First");
		
	}

	@Test(priority=2)
	public void NavigateToEmployeePage()
	{	
		dashboard = new D2ERDashboardPage(driver);
		WebDriverOperations.BrowserWindowScroll(driver);
		dashboard.openSideMenu();
		dashboard.NavigatetoD2ER();
	}

	@Test(priority=3)
	public void AddSingleEmployee() throws Exception {
		ep= new D2EREmployeePage(driver);
		String newEmpEmail =ExcelReadOperations.GetDataFromExcel("EmpAddManually",3,0);
		ep.AddSingleEmployee(newEmpEmail);
		String emailMatch=	ep.SearchEmployeeViaEmail(newEmpEmail);
		Assert.assertEquals(emailMatch, newEmpEmail); 
	}
	
	@Test(priority=4)
	public void ValidateEditEmpRefNumber() throws Exception {
		ep= new D2EREmployeePage(driver);
		ep.ValidateEditEmployeeRefNumber();
	}
	
	@Test(priority=5)
	public void ValidateExportEmployees() throws InterruptedException
	{	ep= new D2EREmployeePage(driver);
		ep.ValidateExportEmployees();
	}
	
//	@Test(priority=6)
//	public void GenerateUnregisteredEmployeesCsv() throws IOException
//	{	ep= new D2EREmployeePage(driver);
//		ep.SearchUnregisteredEmployees();
//		ep.GenerateCsv();
//	}

	@Test(priority=7)
	public void AddMultipleEmployeesManually() throws Exception {
		ep= new D2EREmployeePage(driver);
		lp.LogoutfromD2ER();
		lp.LoginwithUserQAEnv("Second");
		NavigateToEmployeePage();
		int numberOfEmployees = 5;
		ep.AddMultipleEmployees(numberOfEmployees);
	}

//	@Test(priority=8)
//	public void BulkDeregisterEmployees() throws IOException, InterruptedException
//	{	ep= new D2EREmployeePage(driver);
//		lp.LogoutfromD2ER();
//		lp.LoginwithUserQAEnv("Third");
//		NavigateToEmployeePage();
//		ep.BulkDeregisterFromCsv();
//	}
	
	@Test(priority=9)
	public void ResendInvitation() throws Exception 
	{	ep= new D2EREmployeePage(driver);
		ep.ResendInvitation();
	}

//	@Test(priority=10)
//	public void AddEmployeeFromCsv() throws IOException, InterruptedException
//	{	ep= new D2EREmployeePage(driver);
//		lp.LogoutfromD2ER();
//		lp.LoginwithUserQAEnv("Third");
//		NavigateToEmployeePage();
//		String emailForImport=ExcelReadOperations.GetDataFromExcel("EmpAddManually",3,0);
//		ep.AddEmployeeFromCsv(emailForImport);
//	}
//
//	@Test(priority=11)
//	public void DeregisterSingleUserFromAllProducts() throws IOException, InterruptedException
//	{	ep= new D2EREmployeePage(driver);
//		lp.LogoutfromD2ER();
//		lp.LoginwithUserQAEnv("First");
//		NavigateToEmployeePage();
//		String emailForDeregistering=ExcelReadOperations.GetDataFromExcel("DeregisteredEmp",1,0);
//		ep.DeregisterUserFromAllProducts(emailForDeregistering);
//	}

	@Test(priority=12)
	public void EcommerceRedirectValidation() throws Exception 
	{	lp.LogoutfromD2ER();
		lp.LoginwithUserQAEnv("First");
		ep= new D2EREmployeePage(driver);
		String orgEmail=ExcelReadOperations.GetDataFromExcel("D2ER",11,0);
		ep.EcommerceRedirectValidation(orgEmail);
	}

}
