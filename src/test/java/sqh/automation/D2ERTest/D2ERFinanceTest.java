package sqh.automation.D2ERTest;

import java.io.IOException;
import org.testng.annotations.Test;

import resources.webdriveroperations.WebDriverOperations;
import sqh.D2ERPageObject.D2ERDashboardPage;
import sqh.D2ERPageObject.D2EREmployeePage;
import sqh.D2ERPageObject.D2ERFinancePage;
import sqh.D2ERPageObject.D2ERLoginPage;

public class D2ERFinanceTest extends WebDriverOperations{
	D2EREmployeePage ep;
	D2ERLoginPage lp;
	D2ERDashboardPage dashboard ;
	 D2ERFinancePage yok;

	@Test(priority=1)
	public void LogintoCustomerAccount() throws IOException, InterruptedException{
		lp= new D2ERLoginPage(driver);
		lp.LoginwithUserQAEnv("First");
		
	}

	@Test(priority=2)
	public void NavigateToEmployeePage()
	{	
		dashboard = new D2ERDashboardPage(driver);
		WebDriverOperations.BrowserWindowScroll(driver);
		dashboard.openSideMenu();
		dashboard.NavigatetoD2ER();
	}
	
	@Test(priority=2)
	public void ValidateFinanceTabs()
	{	
		dashboard = new D2ERDashboardPage(driver);
		WebDriverOperations.BrowserWindowScroll(driver);
		
	}
	@Test(priority=3)
	public void ValidateInvoicesTabs()throws InterruptedException, IOException
	{	
		yok = new  D2ERFinancePage(driver);
		WebDriverOperations.BrowserWindowScroll(driver);
		//yok. POnumberInvoice();
		//yok.InvoiceSearchPaybyInvoice();
		yok.ManageFinancePaymentMethod();
	}
}