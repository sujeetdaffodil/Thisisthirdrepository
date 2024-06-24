package sqh.automation.EBAdminTest;

import java.io.IOException;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.MyProfilePage;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;

public class MyProfileTest extends WebDriverOperations {

	MyProfilePage mp;
	
	@Test(priority=1)
	public void ValidateLogin() throws Exception 
	{
		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
	}
	
	@Test(priority=2)
	public void ValidateMyProfile()
	{
		mp = new MyProfilePage(driver);
		mp.ValidateMyProfile();
	}
	
	@Test(priority=3)
	public void ChangePassword() throws IOException
	{
		String currentpwd = ExcelReadOperations.GetDataFromExcel("SQHAdminLogin", 1, 1);
		mp = new MyProfilePage(driver);
		mp.UpdatePassword(currentpwd);
	}
	
	@Test(priority=4)
	public void LoginAfterChangePassword() throws IOException
	{
		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
		System.out.println("User logged in successfully using updated password.");
	}
}
