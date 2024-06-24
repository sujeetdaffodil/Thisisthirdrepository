package sqh.automation.EBAdminTest;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import resources.exceloperations.ExcelReadOperations;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.SQHAdminForgotPasswordPage;

public class SQHAdminForgotPasswordTest extends WebDriverOperations{

	@Test(priority=1)
	public void ValidateForgotPassword() throws InterruptedException, IOException
	{   
	SQHAdminForgotPasswordPage Fpass = new SQHAdminForgotPasswordPage(driver);
	String username=ExcelReadOperations.GetDataFromExcel("ForgetPassword",1,0);
	Fpass.FillForgotPasswordEmail(username);
	Fpass.PasswordResetEmailUsingMailinator(username);
	Fpass.VerificationCodeExtraction();
	WebElement ForgetPasswordSuccess=Fpass.SetNewPassword();
	Fpass.UpdateNewlyCreatedPasswordInExcel(); 
	assertEquals(ForgetPasswordSuccess.isDisplayed(), true);  

	}
}

