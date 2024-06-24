package sqh.automation.EBAdminPage;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.exceloperations.ExcelWriteOperations;
import resources.reusableoperations.RandomStringGeneratorOperations;
import resources.webdriveroperations.WebDriverOperations;

public class SQHAdminForgotPasswordPage {
	WebDriver _driver;
	private static String Rnum= "";
	private static String[] arrSplit;
	private static String finalCode;
	
	@FindBy(xpath="//a[contains(.,'Go to home')]")
	private WebElement goToHome;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement forgotPwdEmail;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//button[contains(text(),'GO')]")
	private WebElement goBtn;

	@FindBy(xpath="//td[contains(.,'Password reset request')]")
	private WebElement tempMailThread;
	
	@FindBy(xpath="//a[text()= 'reset link']/preceding::br[3]")
	private WebElement tempVerificationCode;
	
	@FindBy(xpath="//a[contains(.,'here')]")
	private WebElement resetLink;
	
	@FindBy(xpath="//td[contains(text(),'verification code')]")
	private WebElement mailContent;
	
	@FindBy(xpath="//input[@name='confirmationCode']")
	private WebElement verificationCode;
	
	@FindBy(xpath="//input[@name='newPassword']")
	private WebElement newPassword;
	
	@FindBy(xpath="//input[@name='confirmNewPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	private WebElement resetPasswordSubmit;
	
	@FindBy(id="search")
	private WebElement mailinatorSearchBox;
	
	@FindBy(xpath="//div[contains(text(),'Password changed successfully')]")
	private WebElement resetPasswordSuccessMessage;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	private WebElement forgotPasswordBtn;
	
	@FindBy(xpath="//*[@data-testid='success-popup-title']")
	private WebElement passwordResetEmailSentModal;
	
	private WebDriverWait wait;
	
	public SQHAdminForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	//For Entering Username on Forgot Password page on which reset email should be triggered 
	public void FillForgotPasswordEmail(String forgotPasswordEmail) throws IOException
	{   wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordBtn));
		forgotPasswordBtn.click();
		forgotPwdEmail.sendKeys(forgotPasswordEmail);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(passwordResetEmailSentModal));
	}
	
	// when Tempmail Email is used to Trigger Forgot Password Email
	public void PasswordResetEmailUsingTempmail(String forgotPwdUsername)
	{
		forgotPwdEmail.clear();
		forgotPwdEmail.sendKeys(forgotPwdUsername);
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.sendKeys(Keys.CONTROL,Keys.RETURN);

		Boolean IsEnteredTempmail = _driver.findElements(By.xpath("//p[contains(.,'Disposable address: ')]")).size()>0;

		if(IsEnteredTempmail==false)
		{ _driver.navigate(). refresh();
		PasswordResetEmailUsingTempmail(forgotPwdUsername);
		}	

	}
	// when Mailinator Email is used to Trigger Forgot Password Email	
	public void PasswordResetEmailUsingMailinator(String forgotPwdUsername)
	{	_driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL,Keys.RETURN);
		_driver.get("https://www.mailinator.com/");
		wait.until(ExpectedConditions.visibilityOf(mailinatorSearchBox));
		mailinatorSearchBox.clear();
		mailinatorSearchBox.sendKeys(forgotPwdUsername);
		wait.until(ExpectedConditions.elementToBeClickable(goBtn));
		goBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(tempMailThread));
		tempMailThread.click();

	}
	// Below Method is used to Extract Verification Code from Email Template
	public void VerificationCodeExtraction() throws InterruptedException
	{   
		WebDriverOperations.BrowserWindowScroll(_driver);
		_driver.switchTo().frame("html_msg_body");

		// Below is code for extracting Verification code from Email
		wait.until(ExpectedConditions.visibilityOf(resetLink));
		String verCodeText = mailContent.getText();
		arrSplit = verCodeText.split("is"); 
		finalCode = arrSplit[1].trim();
		System.out.println(finalCode);

	}
	// Below method to Set new Password to the email for which forget Password flow is triggered
	public WebElement SetNewPassword()
	{    Rnum= RandomStringGeneratorOperations.randomString(2);

	_driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL,Keys.RETURN);
	_driver.get(resetLink.getAttribute("href"));

	verificationCode.sendKeys(finalCode);
	wait.until(ExpectedConditions.visibilityOf(newPassword));
	newPassword.sendKeys("Password@1"+Rnum);
	wait.until(ExpectedConditions.visibilityOf(confirmPassword));
	confirmPassword.sendKeys("Password@1"+Rnum);
	WebDriverOperations.BrowserWindowScroll(_driver);
	wait.until(ExpectedConditions.visibilityOf(resetPasswordSubmit));
	resetPasswordSubmit.click();
	wait.until(ExpectedConditions.visibilityOf(resetPasswordSuccessMessage));
	return resetPasswordSuccessMessage;
	}

	public String ForgetPasswordPageTitle() {
		return WebDriverOperations.GetTitle(_driver);
	}

	public void UpdateNewlyCreatedPasswordInExcel() throws IOException
	{
		ExcelWriteOperations.UpdatePasswordInExcelSheet("Password@1"+Rnum ,"ForgetPassword");
	}

}
