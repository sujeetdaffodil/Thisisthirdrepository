package sqh.automation.EBAdminPage;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.exceloperations.ExcelReadOperations;

public class SQHAdminLoginPage  	
{	
	WebDriver _driver;
	
	@FindBy(css=".burger_menu")
	private WebElement sqhpageburgermenu;
	
	@FindBy(xpath="//a[contains(text(),'QA Login')]")
	private WebElement qaloginlink;
	
	@FindBy(name="username")
	private WebElement userNameField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	private WebElement loginButton;

	@FindBy(xpath="//h2[contains(text(),'Hello')]")
	private WebElement dashboardMsg;

	
	private WebDriverWait wait;
	
	public SQHAdminLoginPage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	//Function for navigating to QA Login page
	public void NavigateQALoginPage()
	{
		wait.until(ExpectedConditions.visibilityOf(sqhpageburgermenu));
		sqhpageburgermenu.click();
		wait.until(ExpectedConditions.elementToBeClickable(qaloginlink));
		qaloginlink.click();	
	}
	
	//Function for Logging in to SQH Admin Portal
	public void LoginToSQHAdminPortal(String userName, String password)
	{
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.clear();
		userNameField.sendKeys(userName);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		if(_driver.getCurrentUrl().contains("user/dashboard"))
			{
			System.out.println("User logged in succesfully..!!");
			}
	}
	
	public void LoginToPortal() throws IOException
	{
		String username=ExcelReadOperations.GetDataFromExcel("SQHAdminLogin",1,0);
		String password=ExcelReadOperations.GetDataFromExcel("SQHAdminLogin",1,1);
		wait.until(ExpectedConditions.visibilityOf(userNameField));
		userNameField.clear();
		userNameField.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.clear();
		passwordField.sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		wait.until(ExpectedConditions.visibilityOf(dashboardMsg));
	}
	
	public void LoginWithFinanceMangerRole() throws IOException
	{
	String username=ExcelReadOperations.GetDataFromExcel("SQHAdminLogin",2,0);
	String password=ExcelReadOperations.GetDataFromExcel("SQHAdminLogin",2,1);
	wait.until(ExpectedConditions.visibilityOf(userNameField));
	userNameField.clear();
	userNameField.sendKeys(username);
	wait.until(ExpectedConditions.visibilityOf(passwordField));
	passwordField.clear();
	passwordField.sendKeys(password);
	wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	loginButton.click();
	wait.until(ExpectedConditions.visibilityOf(dashboardMsg));
	}
}

