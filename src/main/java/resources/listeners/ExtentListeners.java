package resources.listeners;

import java.util.Arrays;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


//All Extent Listeners are present in this Class
public class ExtentListeners implements ITestListener{
	static Date date = new Date();
	static String fileName = "Extent_D2ER_"+date.toString().replace(":", "_").replace(" ","_")+".html";
	
	private static ExtentReports spark = ExtentManager.createInstance(System.getProperty("user.dir")+"/Reports/"+fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>() ;
	
	ExtentTest test;
	
	@Override
	public void onFinish(ITestContext context) {

	ITestListener.super.onFinish(context);
		if(spark != null)
			{
			spark.flush();
			}
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		ITestListener.super.onTestFailure(result);
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail("<details>"+"<font color=" + "red>"+"Exception Occured"+"<\font>"+exceptionMessage.replaceAll(",","<br>")+"</details>");
		String failureLog = "Test Case Failed";
		Markup msg = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
		test.log(Status.FAIL, msg);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		ITestListener.super.onTestSkipped(result);
		String logtext = "<b>"+ "Test Case : - "+result.getMethod().getMethodName().toUpperCase()+"Skipped"+"</b>";
		test.skip(MarkupHelper.createLabel(logtext, ExtentColor.ORANGE));
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		ITestListener.super.onTestStart(result);
		test = spark.createTest(result.getTestClass().getName()+"@TestCase : "+result.getMethod().getMethodName());
		testReport.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		ITestListener.super.onTestSuccess(result);
		String logtext = "<b>"+ "Test Case : - "+result.getMethod().getMethodName().toUpperCase()+"Passed"+"</b>";
		test.pass(MarkupHelper.createLabel(logtext, ExtentColor.GREEN));
	
	}

}
