package sqh.D2ERPageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class D2ERDashboardPage {

	WebDriver driver;

	@FindBy(id="menutoggle")
	private WebElement sideMenuToggle;

	@FindBy(xpath="//a[@id='sm-account-info']")
	private WebElement accountInformation;

	@FindBy(xpath="//a[@id='sm-employee']")
	private WebElement employee;
	
	@FindBy(id="loader-wrap")
	private WebElement loadingicon;
	
	@FindBy(css="#sm-customer")
	private WebElement customerTab;
	
	@FindBy(css="#sm-user")
	private WebElement usersTab;
	
	@FindBy(css="#sm-d2er")
	private WebElement d2erTab;
	
	

	
	private WebDriverWait wait;

	public D2ERDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public void openSideMenu()
	{	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(sideMenuToggle));
		sideMenuToggle.click();
		
	}

	public void AccountInformationClick()
	{
		wait.until(ExpectedConditions.visibilityOf(accountInformation));
		accountInformation.click();
	}

	public void EmployeeIconClick()
	{
		wait.until(ExpectedConditions.visibilityOf(employee));
		employee.click();
		
	}
	
	public void CustomerTabClick()
	{	
		wait.until(ExpectedConditions.visibilityOf(customerTab));
		customerTab.click();
	}
	
	public void UsersTabClick()
	{	
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		usersTab.click();
	}
	
	public void NavigatetoD2ER()
	{	wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(d2erTab));
		d2erTab.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	} 
	
}
