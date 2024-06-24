package resources.webdriveroperations;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotLib 
{
	WebDriver driver;
	
	public ScreenshotLib(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void takeScreenshot(String scriptName)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./screenshots/"+scriptName+".png");
		
		try 
		{	FileHandler.copy(srcFile, destFile);
			//FileUtils.copyFile(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
