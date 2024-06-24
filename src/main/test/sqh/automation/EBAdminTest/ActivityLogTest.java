package sqh.automation.EBAdminTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.ActivityLogPage;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;

public class ActivityLogTest extends WebDriverOperations{

	ActivityLogPage activitylogpage;
	
	@Test(priority=1)
	public void ValidateLogin() throws Exception {

		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
	}
	
	@Test(priority=2)
	public void ValidateActivityLogPage() throws IOException, InterruptedException  {
		
		String adminusername = ExcelReadOperations.GetDataFromExcel("AdminActivityLog", 1, 0);
		String referrername = ExcelReadOperations.GetDataFromExcel("AdminActivityLog", 1, 4);
		String customername = ExcelReadOperations.GetDataFromExcel("AdminActivityLog", 1, 5);
		String role = ExcelReadOperations.GetDataFromExcel("AdminActivityLog", 1, 1);
		String launchreferrermsg = ExcelReadOperations.GetDataFromExcel("AdminActivityLog", 1, 7);
		SearchReferrerTest searchref = new SearchReferrerTest();
		searchref.ValidateSearchReferrer();
		searchref.ValidateLaunchReferrrer();
		activitylogpage = new ActivityLogPage(driver);
		activitylogpage.ActivityLog(adminusername, referrername,customername,role);
		Assert.assertEquals(activitylogpage.LaunchReferrerActivityLog(), launchreferrermsg);
	}
}
