package sqh.automation.EBAdminPage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.reusableoperations.RandomStringGeneratorOperations;
import resources.reusableoperations.ReusableObjects;
import resources.webdriveroperations.WebDriverOperations;

public class SystemUserPage {

	WebDriver _driver;
	ReusableObjects reuse;
	private WebDriverWait wait;
	RandomStringGeneratorOperations random;
	ReusableObjects modalValidation;
	
	@FindBy(xpath="//span[contains(text(),'Settings')]")
	private WebElement settingLink;
	
	@FindBy(xpath="//a[contains(text(),'System')]")
	private WebElement systemuser;
	
	@FindBy(id="add-system-user-modal-action")
	private WebElement adduser;
	
	@FindBy(id="next-step-1")
	private WebElement step1next;
	
	@FindBy(id="firstName")
	private WebElement firstname;
	
	@FindBy(id="lastName")
	private WebElement lastname;
	
	@FindBy(id="email")
	private WebElement adminemail;
	
	@FindBy(id="mobileNumber")
	private WebElement mobilenumber;
	
	@FindBy(id="next-step-2")
	private WebElement step2next;
	
	@FindBy(id="add-user")
	private WebElement adduserbtn;
	
	@FindBy(xpath="((//span[contains(text(),'Added On')])[1])")
	private WebElement addedon;
	
	@FindBy(id="system_user_unique_0")
	private List<WebElement> userlisting;
	
	@FindBy(css="#dropdownMenutb1")
	private List<WebElement> actionbtn;
	
	@FindBy(xpath="//a[@data-unique-id='edit-unique-id-1']")
	private WebElement edituser;
	
	@FindBy(xpath="//h5[contains(text(),'Edit User')]")
	private WebElement edituserpopup;
	
	@FindBy(id="edit_system_user_first_name")
	private WebElement editfirstname;
	
	@FindBy(id="edit_system_user_last_name")
	private WebElement editlastname;
	
	@FindBy(id="edit_system_user_mobile")
	private WebElement editmobilenumber;
	
	@FindBy(id="edit-system-user-update-btn")
	private WebElement savebtn;
	
	@FindBy(xpath="//div[contains(text(),'User details updated successfully.')]")
	private WebElement userupdatemsg;
	
	@FindBy(id="system_user_unique_0")
	private List<WebElement> firstrow;
	
	@FindBy(xpath="//a[@data-unique-id='resend-disable-id-1']")
	private WebElement disableuser;
	
	@FindBy(xpath="//div[contains(text(),'User enabled successfully.')]")
	private WebElement enabledmsg;
	
	@FindBy(xpath="//div[contains(text(),'User disabled successfully.')]")
	private WebElement disabledmsg;
	
	@FindBy(xpath="//a[@data-unique-id='enable-unique-id-1']")
	private WebElement enableuser;
	
	@FindBy(xpath="//tr[@id='system_user_unique_0']//td[6]")
	private WebElement userstatus;
	
	@FindBy(xpath="((//span[contains(text(),'Status')])[1])")
	private WebElement statuscolumn;
	
	@FindBy(xpath="(//a[@id='resend-invitation'])[1]")
	private WebElement resendinvite;
	
	@FindBy(xpath="//div[contains(text(),'Invitation sent successfully')]")
	private WebElement resendinvitemsg;
	
	@FindBy(css=".loader-common")
	private WebElement loadingicon;

	@FindBy(xpath="//tr[@id='system_user_unique_0']//td[3]")
	private WebElement getemail;
	
	public SystemUserPage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse = new ReusableObjects(_driver);
	}
	
	public String SystemUserPageTitle() {
		return WebDriverOperations.GetTitle(_driver);
	}
	
	//Function for Adding new user
	public void AddUser(String firstName, String lastName, String email, String mobileNumber) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(settingLink));
		settingLink.click();
		wait.until(ExpectedConditions.visibilityOf(systemuser));
		systemuser.click();
		reuse.waitForLoaderToBeClosed();
		wait.until(ExpectedConditions.visibilityOf(adduser));
		adduser.click();
		wait.until(ExpectedConditions.elementToBeClickable(step1next));
		step1next.click();
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		adminemail.sendKeys(email);
		mobilenumber.sendKeys(mobileNumber);
		wait.until(ExpectedConditions.visibilityOf(step2next));
		step2next.click();
		wait.until(ExpectedConditions.elementToBeClickable(adduserbtn));
		adduserbtn.click();
		reuse.waitForLoaderToBeClosed();
		reuse.validateSuccessMsg();
		addedon.click();
		reuse.waitForLoaderToBeClosed();
		addedon.click();
		reuse.waitForLoaderToBeClosed();
		for (WebElement ele: userlisting) 
		{
		 if(ele.getText().contentEquals(email))
		 {
		    System.out.println("System User added succesfully...");
		    break;
		 }
		 else
		 System.out.println("System User not added...");
		        
		}
	}
	
	//Function for Resending Invitation
	public void ResendInvitation()
	{
		actionbtn.get(0).click();
		wait.until(ExpectedConditions.elementToBeClickable(resendinvite));
		resendinvite.click();
		reuse.waitForLoaderToBeClosed();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(resendinvitemsg));
		reuse.validateSuccessMsg();
		System.out.println("Invitation sent successfully..");
	}
	
	//Function for validating Edit User details
	public void EditUser(String firstName, String lastName, String mobile) 
	{		
		actionbtn.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(edituser));
		edituser.click();
		wait.until(ExpectedConditions.visibilityOf(edituserpopup));
		editfirstname.clear();
		editlastname.clear();
		editmobilenumber.clear();
		editfirstname.sendKeys(firstName);
		editlastname.sendKeys(lastName);
		editmobilenumber.sendKeys(mobile);
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		savebtn.click();
		wait.until(ExpectedConditions.visibilityOf(userupdatemsg));
		reuse.validateSuccessMsg();
		System.out.println("User details updated successfully..");
	}

	//Function for Getting Last Name
	public void getLastName(String lastname)
	{
		addedon.click();
		reuse.waitForLoaderToBeClosed();
		addedon.click();
		reuse.waitForLoaderToBeClosed();
		firstrow.get(0).getText().contains(lastname);		
	}
	
	//Function for Disabling User
	public void DisableUser()
	{
		_driver.navigate().refresh();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		statuscolumn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		actionbtn.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(disableuser));
		disableuser.click();
		reuse.acceptConfirmationDialog();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.elementToBeClickable(disabledmsg));
		reuse.validateSuccessMsg();
		Assert.assertEquals(userstatus.getText(), "Inactive");
		System.out.println(getemail.getText()+":User marked as disabled");
	}
	
	//Function for Enabling User
	public void EnableUser()
	{
		reuse = new ReusableObjects(_driver);
		_driver.navigate().refresh();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		statuscolumn.click();
		reuse.waitForLoaderToBeClosed();
		markAsDisabled();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		actionbtn.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(enableuser));
		enableuser.click();
		reuse.acceptConfirmationDialog();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(enabledmsg));
		reuse.validateSuccessMsg();
		Assert.assertEquals(userstatus.getText(), "Active");
		System.out.println(getemail.getText()+":User marked as enabled");
	}

	//Enable user function
	public void markAsEnabled()
	{
		reuse = new ReusableObjects(_driver);
		actionbtn.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(enableuser));
		enableuser.click();
		reuse.validateConfirmBtnYes();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.visibilityOf(enabledmsg));
		reuse.validateSuccessMsg();
	}
	
	//Disable user
	public void markAsDisabled()
	{
		reuse.waitForLoaderToBeClosed();
		actionbtn.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(disableuser));
		disableuser.click();
		reuse.acceptConfirmationDialog();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		wait.until(ExpectedConditions.elementToBeClickable(disabledmsg));
		reuse.validateSuccessMsg();
	}
}
