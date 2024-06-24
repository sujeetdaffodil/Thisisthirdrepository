package sqh.automation.EBAdminPage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.reusableoperations.ReusableObjects;

public class FAQScreenPage {


	WebDriver _driver;
	ReusableObjects reuse;
	private WebDriverWait wait;
	
	@FindBy(xpath="//span[contains(text(),'FAQs')]")
	private WebElement faqslink;
	
	@FindBy(id="faq-accord")
	private WebElement faqrecords;
	
	public FAQScreenPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse = new ReusableObjects(_driver);
	}
	
	public boolean ValidateFAQs()
	{
		wait.until(ExpectedConditions.visibilityOf(faqslink));
		faqslink.click();
		reuse.waitForLoaderToBeClosed();
		if(_driver.getCurrentUrl().contains("faq"))
		{
		System.out.println("User navigated to FAQs page succesfully..!!");
		}
		wait.until(ExpectedConditions.visibilityOf(faqrecords));
		return faqrecords.isDisplayed();
	}

	
}
