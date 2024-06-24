package sqh.automation.EBAdminTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;
import sqh.automation.EBAdminPage.SystemUserPage;

public class SystemUserTest extends WebDriverOperations {
  
	SystemUserPage sup;
	
	@Test(priority=1)
	public void ValidateLogin() throws Exception 
	{
		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
	}
	
	@Test(priority=2)
	public void ValidateAddSystemUser() throws IOException, InterruptedException
	{
		String firstname = ExcelReadOperations.GetDataFromExcel("SystemUsers", 2, 0);
		String lastname = ExcelReadOperations.GetDataFromExcel("SystemUsers", 2, 1);
		String email = ExcelReadOperations.GetDataFromExcel("SystemUsers", 2, 2);
		String mobilenumber = ExcelReadOperations.GetDataFromExcel("SystemUsers", 2, 3);
		sup = new SystemUserPage(driver);
		sup.AddUser(firstname, lastname, email, mobilenumber);
		Assert.assertEquals(sup.SystemUserPageTitle(), "SQH EB Admin Portal | System Users");
	}
	
	@Test(priority=3)
	public void ValidateEditSystemUser() throws IOException, InterruptedException
	{
		String firstname = ExcelReadOperations.GetDataFromExcel("AdminSystemUser", 1, 0);
		String lastname = ExcelReadOperations.GetDataFromExcel("AdminSystemUser", 1, 1);
		String mobilenumber = ExcelReadOperations.GetDataFromExcel("AdminSystemUser", 1, 2);
		sup = new SystemUserPage(driver);
		sup.EditUser(firstname, lastname, mobilenumber);
		sup.getLastName(lastname);
	}
	
	@Test(priority=4)
	public void ValidateResendInvite()
	{
		sup = new SystemUserPage(driver);
		sup.ResendInvitation();
		
	}
	
	@Test(priority=5)
	public void ValidateDisableSystemUser() 
	{
		sup = new SystemUserPage(driver);
		sup.DisableUser();
	}
	
	@Test(priority=6)
	public void ValidateEnableSystemUser()
	{
		sup = new SystemUserPage(driver);
		sup.EnableUser();
	}
}
