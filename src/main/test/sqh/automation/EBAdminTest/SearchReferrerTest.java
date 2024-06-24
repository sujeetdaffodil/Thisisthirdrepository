package sqh.automation.EBAdminTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;
import sqh.automation.EBAdminPage.SearchReferrerPage;

public class SearchReferrerTest extends WebDriverOperations {
 
  SearchReferrerPage srf;
  
	@Test(priority=1)
	public void ValidateLogin() throws Exception {
		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
	}

  
  @Test(priority=2)
  public void ValidateSearchReferrer() throws IOException 
  {
	  srf = new SearchReferrerPage(driver);
	  String expectedTitle = ExcelReadOperations.GetDataFromExcel("SearchReferrer", 1, 0);
	  String referrername = ExcelReadOperations.GetDataFromExcel("SearchReferrer", 1, 1);
	  String referreremail = ExcelReadOperations.GetDataFromExcel("SearchReferrer", 1, 2);
	  srf.SearchReferrer(referrername, referreremail);
	  Assert.assertEquals(srf.SearchReferrerPageTitle(), expectedTitle);
	  System.out.println("User navigated to Search Referrer Page.");
	  srf.ValidateSearchResults(referreremail);
  }
  
  @Test(priority=3)
  public void ValidateLaunchReferrrer() throws InterruptedException, IOException 
  {
	  String referrerPortalPageTitle = ExcelReadOperations.GetDataFromExcel("SearchReferrer", 1, 3);
	  srf.LaunchReferrer();
	  Assert.assertEquals(srf.getReferrerPortalTitle(), referrerPortalPageTitle);
  }
}
