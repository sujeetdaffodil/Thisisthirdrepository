package sqh.automation.EBAdminTest;

import org.testng.annotations.Test;
import resources.webdriveroperations.WebDriverOperations;
import sqh.automation.EBAdminPage.FAQScreenPage;
import sqh.automation.EBAdminPage.SQHAdminLoginPage;

public class FAQsTest extends WebDriverOperations
{
	FAQScreenPage faqpage;
	
	@Test(priority=1)
	public void ValidateLogin() throws Exception {

		SQHAdminLoginPage sqhlogin =new SQHAdminLoginPage(driver);
		sqhlogin.NavigateQALoginPage();
		sqhlogin.LoginToPortal();
	}
	
	@Test(priority=2)
	public void NavigateToFAQs() throws Exception {
		faqpage = new FAQScreenPage(driver);
		faqpage.ValidateFAQs();
	}
	
	
	
}
