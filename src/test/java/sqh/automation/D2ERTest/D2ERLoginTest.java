package sqh.automation.D2ERTest;

import org.testng.annotations.Test;
import resources.webdriveroperations.WebDriverOperations;
import sqh.D2ERPageObject.D2ERLoginPage;

public class D2ERLoginTest extends WebDriverOperations{
	@Test
	public void ValidateLoginWithCorrectCredentials() throws Exception {
		D2ERLoginPage login = new D2ERLoginPage(driver);	
		login.LoginwithUserQAEnv("Second");
		login.ValidateLogin();
		
	}

}
