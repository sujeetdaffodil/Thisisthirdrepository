package resources.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentManager {
	public static ExtentReports extent;
	static String reportpath = System.getProperty("user.dir")+"/Reports";

	public static ExtentReports createInstance(String fileName)
	{	
		ExtentSparkReporter spark = new ExtentSparkReporter(fileName).viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.LOG}).apply();
		spark.config().setReportName("SquareHealth Portal Automation Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("SQH Admin Report");
		
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Organization", "SquareHealth");
		
		return extent;
	}

	
}
