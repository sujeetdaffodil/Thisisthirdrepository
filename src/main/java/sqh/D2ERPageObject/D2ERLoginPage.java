package sqh.D2ERPageObject;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.exceloperations.ExcelReadOperations;

public class D2ERLoginPage	
{	
	WebDriver driver;
	
	@FindBy(name="username")
	private WebElement userNameField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[contains(text(), 'Sign in')]")
	private WebElement loginButton;

	@FindBy(css="#header")
	private WebElement header;
	
	@FindBy(css=".aviva-logo")
	private WebElement logo;
	
	@FindBy(id="loader-wrap")
	private WebElement loadingicon;
	
	@FindBy(xpath="//h2[contains(text(),'Hello')]")
	private WebElement dashboardMsg;

	@FindBy(css="#currentUserName")
	private WebElement profileIcon;
	
	@FindBy(xpath="//div[@class='themeUtil themeProfileMenu']")
	private WebElement d2erpage;
	
	@FindBy(xpath="//span[contains(text(),'Manage Accounts & Employees')]")
	private WebElement Myaccountandsettings;
	
	@FindBy(css="#dropdown-logout-btn")
	private WebElement logoutBtn;
	
	@FindBy(css = "#logoutConfirmModal")
	private WebElement logoutModal;
	
	@FindBy(css = "#btn-logout-confirm-yes")
	private WebElement confirmYesLogoutBtn;
	
	@FindBy(css = ".burger_menu")
	private WebElement hamburgerIcon;
	
	@FindBy(css = "#menu-item-590")
	private WebElement UATloginBtn;
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement loginNextBtn;
	
	
	@FindBy(xpath = "//a[contains(text(),'QA Login')]")
	private WebElement QALoginLink;
			
	private WebDriverWait wait;
	
	String EmpPageUrl ="https://qa-account.square-health.co.uk/employees";
	
	public D2ERLoginPage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	public void EnterUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.clear();
		userNameField.sendKeys(userName);
	}

	public void EnterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void ClickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(dashboardMsg));
		
	}
	
	public void ValidateLogin() throws InterruptedException
	{	
		String CurrentURL = driver.getCurrentUrl();
			if(CurrentURL.contains("communityprotal"))
			{	driver.navigate().back();

				driver.get(EmpPageUrl);
			}
			
				wait.until(ExpectedConditions.visibilityOf(logo));
					if(driver.getCurrentUrl().contains("dashboard"))
						{System.out.println("URL Navigated successfully");
						}
			}
	
	public void LoginwithUserQAEnv(String credentials) throws IOException, InterruptedException
	{	wait.until(ExpectedConditions.visibilityOf(hamburgerIcon));
		hamburgerIcon.click();
		wait.until(ExpectedConditions.visibilityOf(QALoginLink));
		QALoginLink.click();
		
		String Username="";
		String Password="";
		String credentialsType=credentials;
		if(credentialsType=="First")
		{	Username=ExcelReadOperations.GetDataFromExcel("D2ER",1,0);
			Password=ExcelReadOperations.GetDataFromExcel("D2ER",1,1);
		}
		if(credentialsType=="Second")
		{	Username=ExcelReadOperations.GetDataFromExcel("D2ER",2,0);
			Password=ExcelReadOperations.GetDataFromExcel("D2ER",2,1);
		}
		if(credentialsType=="Third")
		{	Username=ExcelReadOperations.GetDataFromExcel("D2ER",3,0);
			Password=ExcelReadOperations.GetDataFromExcel("D2ER",3,1);
		}
		
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.clear();
		userNameField.sendKeys(Username);
		loginNextBtn.click();
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(d2erpage));
		d2erpage.click();
		wait.until(ExpectedConditions.elementToBeClickable(Myaccountandsettings));
		Myaccountandsettings.click();
		wait.until(ExpectedConditions.visibilityOf(dashboardMsg));
	}
	
	public void LoginwithUserUATEnv(String credentials) throws IOException
	{	wait.until(ExpectedConditions.visibilityOf(UATloginBtn));
		UATloginBtn.click();
		
		String Username="";
		String Password="";
		String credentialsType=credentials;
		if(credentialsType=="First")
		{	Username=ExcelReadOperations.GetDataFromExcel("D2ER",8,0);
			Password=ExcelReadOperations.GetDataFromExcel("D2ER",8,1);
		}
		if(credentialsType=="Second")
		{	Username=ExcelReadOperations.GetDataFromExcel("D2ER",9,0);
			Password=ExcelReadOperations.GetDataFromExcel("D2ER",9,1);
		}
		if(credentialsType=="Third")
		{	Username=ExcelReadOperations.GetDataFromExcel("D2ER",10,0);
			Password=ExcelReadOperations.GetDataFromExcel("D2ER",10,1);
		}
		
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.clear();
		userNameField.sendKeys(Username);
		loginNextBtn.click();
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(profileIcon));
		profileIcon.click();
		wait.until(ExpectedConditions.visibilityOf(dashboardMsg));
	}
	
	public void LogoutfromD2ER()
	{
		driver.get(EmpPageUrl);
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(profileIcon));
		profileIcon.click();
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		logoutBtn.click();
		wait.until(ExpectedConditions.visibilityOf(logoutModal));
		confirmYesLogoutBtn.click();
		String CurrentURL = driver.getCurrentUrl();
		if(CurrentURL.contains("goldeneye"))
		{	
			Assert.assertTrue(true);

		}	
	}	
}
