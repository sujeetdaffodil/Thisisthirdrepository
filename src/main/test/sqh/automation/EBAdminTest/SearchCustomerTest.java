package sqh.automation.EBAdminTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;
import sqh.automation.EBAdminPage.SearchCustomerPage;

public class SearchCustomerTest extends WebDriverOperations{
	
	SearchCustomerPage scp;
	
	@Test(priority=1)
	public void ValidateLogin() throws Exception {
		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
	}
	
	  @Test(priority=2)
	  public void ValidateSearchCustomer() throws Exception 
	  {
		  scp = new SearchCustomerPage(driver);
		  String customername = ExcelReadOperations.GetDataFromExcel("SearchReferrer",4,1);
		  String schemename = ExcelReadOperations.GetDataFromExcel("SearchReferrer",4,2);
		  String policynumber = ExcelReadOperations.GetDataFromExcel("SearchReferrer",4,3);
		  String clientcode = ExcelReadOperations.GetDataFromExcel("SearchReferrer",4, 4);
		  String customeremail = ExcelReadOperations.GetDataFromExcel("SearchReferrer",4,5);
		  String creationdate = ExcelReadOperations.GetDataFromExcel("SearchReferrer",4,6);
		  scp.SearchCustomer(customername, schemename, policynumber, clientcode, customeremail, creationdate);
		  System.out.println("User navigated to Search Customer Page.");
		  Assert.assertEquals(scp.ValidateEmailFromResults(),customeremail);
		  System.out.println("Searched Results displayed.");
	  }
	  
	  
	  @Test(priority=3)
	  public void ValidateLaunchCustomer() throws InterruptedException, IOException 
	  {
		  scp.LaunchCustomer();
		  Assert.assertEquals(scp.getCustomerPortalTitle(), true);
	  }
}
