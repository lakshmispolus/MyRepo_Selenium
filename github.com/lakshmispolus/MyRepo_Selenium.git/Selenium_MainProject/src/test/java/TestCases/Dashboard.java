package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Utilities.BaseClass;
import Utilities.ExcelRead;

public class Dashboard extends BaseClass {

	DashboardPage dashboardpage;

	@Test(groups = {"Functional"},enabled = true, priority = 5)
	public void verifyApplicationLogoIsPresent() throws IOException {
		ExtentReportcreateTest(ExcelRead.readStringData(103, 1));
		dashboardpage = new DashboardPage(driver);
		Boolean result = dashboardpage.applicationLogoPresent();
		if (result) {
			Assert.assertTrue(true, ExcelRead.readStringData(104, 1));
			extendTestPass(ExcelRead.readStringData(104, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(105, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(105, 1));
		}
	}

	@Test(groups = {"Functional"},enabled = true, priority = 6)
	public void verifyAllTheTabsArePresent() throws IOException {
		ExtentReportcreateTest(ExcelRead.readStringData(106, 1));
		dashboardpage = new DashboardPage(driver);
		Boolean result = dashboardpage.allTabsPresent();
		if (result) {
			Assert.assertTrue(true, ExcelRead.readStringData(107, 1));
			extendTestPass(ExcelRead.readStringData(107, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(108, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(108, 1));
		}
	}

	@Test(groups = {"Functional"},enabled = true, priority = 7)
	public void verifyAllHeaderbuttonsPresent() throws IOException {
		ExtentReportcreateTest(ExcelRead.readStringData(109, 1));
		dashboardpage = new DashboardPage(driver);
		Boolean result = dashboardpage.allbuttonsPresent();
		if (result) {
			Assert.assertTrue(true, ExcelRead.readStringData(110, 1));
			extendTestPass(ExcelRead.readStringData(110, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(111, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(111, 1));
		}
	}
	
	@Test(groups = {"Functional"},enabled = true, priority = 8)
	public void verifyAdminDetails() throws IOException {
		ExtentReportcreateTest(ExcelRead.readStringData(113, 1));
		dashboardpage = new DashboardPage(driver);
		String result = dashboardpage.admindetails();
		if (result.contains(ExcelRead.readStringData(112, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(114, 1));
			extendTestPass(ExcelRead.readStringData(114, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(115, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(115, 1));
		}
	}

}
