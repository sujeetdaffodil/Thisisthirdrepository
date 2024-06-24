package sqh.automation.EBAdminPage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.reusableoperations.ReusableObjects;
import resources.webdriveroperations.WebDriverOperations;

public class AdminHomePage {

	public WebDriver _driver;
	ReusableObjects reuse ;
	private WebDriverWait wait;
	
	@FindBy(css=".user-name")
	private WebElement fullname;
	
	@FindBy(css=".loader-common")
	private WebElement loadingicon;
	
	public AdminHomePage(WebDriver driver) {
		_driver = driver;
		PageFactory.initElements(driver, this);	
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse = new ReusableObjects(_driver);
	}

	public String HomePageTitle() {
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		return WebDriverOperations.GetTitle(_driver);
	}
	
	public String GetUserName()
	{
		return fullname.getText();
	}

}
