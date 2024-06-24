package resources.reusableoperations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableObjects {

	WebDriver _driver;
	ReusableObjects reuseobj;
	private WebDriverWait wait;

	public ReusableObjects(WebDriver driver) {
		_driver = driver;
		PageFactory.initElements(driver, this);	
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}

	@FindBy(css="#user-success-modal-ok")
	WebElement usersuccess;

	@FindBy(id="loader-wrap")
	WebElement loader;

	@FindBy(xpath="//img[@src='images/actions.svg']")
	WebElement actionbtn;

	@FindBy(xpath="//button[@id='user-success-modal-ok']")
	WebElement confirmyesBtn;

	@FindBy(id="btn-confirm-no")
	WebElement confirmno;
	
	@FindBy(id="loader-wrap")
	private WebElement loadingicon;
	
	@FindBy(id = "btn-confirm-yes")
	private WebElement yesBtn;
	
	@FindBy(xpath = "//*[contains(text(),'revoke')]")
	private WebElement revokeAccess;
	
	@FindBy(xpath = "//*[@id='successModal']//h5")
	private WebElement successModalHeader;
	
	@FindBy(xpath = "//*[@id='confirmModal']//h4")	
	private WebElement confirmModalHeader;

	@FindBy(id="successModal")
	private WebElement successmodalcontent;

	@FindBy(xpath="//div[@id='confirmModal']//div[@class='modal-content']")
	private WebElement confirmmodalcontent;
	
	@FindBy(css="#confirmation-modal .modal-content")
	private WebElement confirmationModal;
	
	@FindBy(css="#confirmation-modal .modal-content h5")
	private WebElement confirmationModalHeader;
	
	@FindBy(css="#cancel-confimation-yes")
	private WebElement confirmationCancelYes;
	
	@FindBy(css="#cancel-confimation-no")
	private WebElement confirmationCancelNo;
	
	@FindBy(css="#confirmModal .modal-content")
	private WebElement confirmationModal2;
	
	@FindBy(css="#confirmModal h4")
	private WebElement confirmationModalHeader2;
	
	@FindBy(css="#btn-confirm-no")
	private WebElement confirmationCancelNo2;
	

	
	//This method is for closing loader
	public void waitForLoaderToBeClosed()
	{
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}
	
	public String CurrentDate()
	{
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date systemdate = new Date();
		String todaysdate = dateformat.format(systemdate);
		return todaysdate;
	}
	
	public void validateConfirmBtnYes()
	{
		wait.until(ExpectedConditions.visibilityOf(confirmyesBtn));
		confirmyesBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
	}

	//Confirm button Yes

	public void acceptConfirmationDialog() {
		
		wait.until(ExpectedConditions.visibilityOf(confirmmodalcontent));
		String modalHeading = confirmModalHeader.getText();
		if (modalHeading.equalsIgnoreCase("Confirmation")) {
			wait.until(ExpectedConditions.visibilityOf(yesBtn));
			yesBtn.click();
		} else {
			System.out.println("Success Modal not displayed");
		}
	}
	
	public void CancelYesModal() {
		
		wait.until(ExpectedConditions.visibilityOf(confirmationModal));
		wait.until(ExpectedConditions.visibilityOf(confirmationModalHeader));
		String modalHeading = confirmationModalHeader.getText();
		if (modalHeading.equalsIgnoreCase("Confirmation")) {
			confirmationCancelNo.isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(confirmationCancelYes));
			JavascriptExecutor executor = (JavascriptExecutor)_driver;
			executor.executeScript("arguments[0].click();", confirmationCancelYes);
		} else {
			System.out.println("Success Modal not displayed");
		}
	}
	public void CancelNoModal() {
		wait.until(ExpectedConditions.visibilityOf(confirmationModal));
		wait.until(ExpectedConditions.visibilityOf(confirmationModalHeader));
		String modalHeading = confirmationModalHeader.getText();
		if (modalHeading.equalsIgnoreCase("Confirmation")) {
			confirmationCancelNo.isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(confirmationCancelNo));
			JavascriptExecutor executor = (JavascriptExecutor)_driver;
			executor.executeScript("arguments[0].click();", confirmationCancelNo);
		} else {
			System.out.println("Success Modal not displayed");
		}
	}
	
	public void CancelNoModalType2() {
		wait.until(ExpectedConditions.visibilityOf(confirmationModal2));
		wait.until(ExpectedConditions.visibilityOf(confirmationModalHeader2));
		String modalHeading = confirmationModalHeader2.getText();
		if (modalHeading.equalsIgnoreCase("Confirmation")) {
			confirmationCancelNo2.isDisplayed();
			wait.until(ExpectedConditions.elementToBeClickable(confirmationCancelNo2));
			JavascriptExecutor executor = (JavascriptExecutor)_driver;
			executor.executeScript("arguments[0].click();", confirmationCancelNo2);
		} else {
			System.out.println("Success Modal not displayed");
		}
	}


	//Confirm button No
	public void validateConfirmBtnNo()
	{
		wait.until(ExpectedConditions.visibilityOf(confirmno));
		confirmno.click();
	}

	//This is method is for clicking action button in portal.
	public void validateActionBtn()
	{
		wait.until(ExpectedConditions.visibilityOf(actionbtn));
		actionbtn.click();
	}
	
	public void revokeAccessModalAccept()
	{
		wait.until(ExpectedConditions.visibilityOf(actionbtn));
		actionbtn.click();
		wait.until(ExpectedConditions.visibilityOf(revokeAccess));
		revokeAccess.click();
	}
	
	public void validateSuccessMsg() {
		wait.until(ExpectedConditions.visibilityOf(usersuccess));
		wait.until(ExpectedConditions.visibilityOf(successModalHeader));
		String modalHeading = successModalHeader.getText();
		if (modalHeading.equalsIgnoreCase("Success")) 
		{
			wait.until(ExpectedConditions.elementToBeClickable(confirmyesBtn));
			JavascriptExecutor executor = (JavascriptExecutor)_driver;
			executor.executeScript("arguments[0].click();", confirmyesBtn);
			wait.until(ExpectedConditions.invisibilityOf(loadingicon));
			
		} else {
			System.out.println("Success Modal not displayed");
		}
	}
}
