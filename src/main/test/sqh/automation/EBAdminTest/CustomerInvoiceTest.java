package sqh.automation.EBAdminTest;

import java.io.IOException;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.CustomerInvoicePage;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;

public class CustomerInvoiceTest extends WebDriverOperations
{
  
	@Test(priority=1)
	public void ValidateLogin() throws Exception 
	{
		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginWithFinanceMangerRole();
	}
	
	@Test(priority=2)
	public void NavigateToCustomerInvoicePage()
	{
		CustomerInvoicePage cip = new CustomerInvoicePage(driver);
		cip.GoToCustomerInvoicePage();
	}
	
	@Test(priority = 3)
	public void ValidateSearchInvoice() throws IOException
	{
		CustomerInvoicePage cip = new CustomerInvoicePage(driver);
		String referrer = ExcelReadOperations.GetDataFromExcel("Customer Invoice", 1, 0);
		String customer = ExcelReadOperations.GetDataFromExcel("Customer Invoice", 1, 1);
		String fromdate = ExcelReadOperations.GetDataFromExcel("Customer Invoice", 1, 2);
		String todate = ExcelReadOperations.GetDataFromExcel("Customer Invoice", 1, 3);
		String invoicenumber = ExcelReadOperations.GetDataFromExcel("Customer Invoice", 1, 4);
		String status = ExcelReadOperations.GetDataFromExcel("Customer Invoice", 1, 5);
		cip.SearchInvoice(referrer,customer,fromdate,todate,invoicenumber,status);
	}
	
	@Test(priority=4)
	public void ExportInvoiceList() throws InterruptedException
	{
		CustomerInvoicePage cip = new CustomerInvoicePage(driver);
		cip.ExportCSV();
	}
	
	@Test(priority=5)
	public void ValidateDownloadInvoice() throws InterruptedException
	{
		CustomerInvoicePage cip = new CustomerInvoicePage(driver);
		cip.DownloadInvoice();
	}
	
	@Test(priority=6)
	public void ValidateLaunchCustomer() throws InterruptedException
	{
		CustomerInvoicePage cip = new CustomerInvoicePage(driver);
		cip.LaunchCustomer();
	}
}

