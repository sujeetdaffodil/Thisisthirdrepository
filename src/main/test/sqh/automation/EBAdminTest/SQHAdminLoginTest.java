package sqh.automation.EBAdminTest;

import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.AdminHomePage;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;

public class SQHAdminLoginTest extends WebDriverOperations{
	
	@Test(priority=1)
	public void ValidateLoginWithCorrectCredentials() throws Exception {
		String username=ExcelReadOperations.GetDataFromExcel("SQHAdminLogin",1,0);
		String password=ExcelReadOperations.GetDataFromExcel("SQHAdminLogin",1,1);
		SQHAdminLoginPage login = new SQHAdminLoginPage(driver);	
		login.NavigateQALoginPage();
		login.LoginToSQHAdminPortal(username, password);
		AdminHomePage homePage = new AdminHomePage(driver);
		System.out.println("Current title is:"+homePage.HomePageTitle());
	}
}
