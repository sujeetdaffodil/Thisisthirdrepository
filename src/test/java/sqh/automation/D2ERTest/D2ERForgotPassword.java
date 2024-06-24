package sqh.automation.D2ERTest;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.D2ERPageObject.D2ERForgotPasswordPage;


public class D2ERForgotPassword extends WebDriverOperations{

	@Test(priority=1)
	public void ValidateForgotPassword() throws InterruptedException, IOException
	{   
	D2ERForgotPasswordPage Fpass = new D2ERForgotPasswordPage(driver);
	String username=ExcelReadOperations.GetDataFromExcel("ForgetPassword",1,0);
	Fpass.FillForgotPasswordEmail(username);
	Fpass.PasswordResetEmailUsingMailinator(username);
	Fpass.VerificationCodeExtraction();
	WebElement ForgetPasswordSuccess=Fpass.SetNewPassword();
	//Writing newly set password to excel
	Fpass.UpdateNewlyCreatedPasswordInExcel(); 
	assertEquals(ForgetPasswordSuccess.isDisplayed(), true);  

	}
}

