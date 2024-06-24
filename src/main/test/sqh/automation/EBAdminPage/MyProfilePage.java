package sqh.automation.EBAdminPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.exceloperations.ExcelReadOperations;
import resources.reusableoperations.RandomStringGeneratorOperations;
import resources.reusableoperations.ReusableObjects;

public class MyProfilePage {

	WebDriver _driver;
	ReusableObjects reuse;
	private WebDriverWait wait;
	RandomStringGeneratorOperations random;
	ReusableObjects modalValidation;
	
	public MyProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this._driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.reuse = new ReusableObjects(_driver);
		this.random = new RandomStringGeneratorOperations();
	}
	
	@FindBy(xpath="//span[contains(text(),'Settings')]")
	private WebElement settingLink;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	private WebElement myProfileLink;
	
	@FindBy(css=".prof-name")
	private WebElement profileName;
	
	@FindBy(css=".edit-pr-bt")
	private WebElement editProfileBtn;
	
	@FindBy(xpath="//button[contains(text(),'Change Password')]")
	private WebElement changePasswordBtn;
	
	@FindBy(css="#current-password")
	private WebElement currentPassField;
	
	@FindBy(css="#new-password")
	private WebElement newPassField;
	
	@FindBy(css="#confirm-password")
	private WebElement confirmPassField;
	
	@FindBy(css="#change-password-pop-btn")
	private WebElement savePasswordBtn;
	
	@FindBy(css="#update_my_profile_form")
	private WebElement updateProfileForm;
	
	@FindBy(id="my_profile_mobile")
	private WebElement editMobileNumberField;
	
	@FindBy(css="#my-profile-update-btn")
	private WebElement updateBtn;
	
	@FindBy(css=".loader-common")
	private WebElement loadingicon;
	
	@FindBy(id="uniqueMoblieNo_1")
	private WebElement mobileNumberHeader;
	

	//Function for Validating My Profile Section
	public void ValidateMyProfile() {
		wait.until(ExpectedConditions.visibilityOf(settingLink));
		settingLink.click();
		wait.until(ExpectedConditions.visibilityOf(myProfileLink));
		myProfileLink.click();
		wait.until(ExpectedConditions.visibilityOf(editProfileBtn));
		editProfileBtn.click();
		wait.until(ExpectedConditions.visibilityOf(updateProfileForm));
		String updatedNumber = random.generateRandomNumber(11);
		editMobileNumberField.clear();
		editMobileNumberField.sendKeys(updatedNumber);
		wait.until(ExpectedConditions.visibilityOf(updateBtn));
		updateBtn.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingicon));
		reuse.validateSuccessMsg();
		Assert.assertEquals(updatedNumber, mobileNumberHeader.getText());
	}
	
	//Function for validating Change Password functionality in My Profile
	public void UpdatePassword(String password) throws IOException
	{
		wait.until(ExpectedConditions.visibilityOf(changePasswordBtn));
		changePasswordBtn.click();
		currentPassField.sendKeys(password);
		RandomStringGeneratorOperations randompwd= new RandomStringGeneratorOperations();
		String newpwd = randompwd.generateStringWithAllowedSplChars(10, "ABC");		
		File file = new File("Login_Credentials/MasterDataSheet.xlsx");
		FileInputStream fis = new FileInputStream("Login_Credentials/MasterDataSheet.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet("SQHAdminLogin");
	    sheet.getRow(1).createCell(1).setCellValue(newpwd);
	    FileOutputStream fos = new FileOutputStream(file);
	    workbook.write(fos);
	    newPassField.sendKeys(ExcelReadOperations.GetDataFromExcel("SQHAdminLogin", 1, 1));
	    confirmPassField.sendKeys(ExcelReadOperations.GetDataFromExcel("SQHAdminLogin", 1, 1));
	    workbook.close();
	    wait.until(ExpectedConditions.visibilityOf(savePasswordBtn));
	    savePasswordBtn.click();
	    reuse.waitForLoaderToBeClosed();
	    reuse.validateSuccessMsg();
	    System.out.println("Password changed successfully...");
	}
	
}
