package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.BaseClass;
import Utilities.ExcelRead;

public class Login extends BaseClass {

	LoginPage loginpage;

	@Test(groups = { "Functional" }, enabled = true, priority = 1)
	public void verifyLoginPageMandatoryValidations() throws IOException {

		ExtentReportcreateTest(ExcelRead.readStringData(102, 1));
		loginpage = new LoginPage(driver);
		String errormsg = loginpage.mandatoryvalidations();
		if (errormsg.contains(ExcelRead.readStringData(20, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(100, 1));
			extendTestPass(ExcelRead.readStringData(100, 1));

		} else {
			extendTestFail(ExcelRead.readStringData(101, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(101, 1));
		}
	}

	@DataProvider(name = "usermail")
	public Object[][] dp() throws IOException {
		return new Object[][] { new Object[] { ExcelRead.readStringData(5, 1) }, };
	}

	@Test(dataProvider = "usermail", groups = { "Functional" }, enabled = true, priority = 2)
	public void verifyLogin(String usermail) throws IOException {

		ExtentReportcreateTest(ExcelRead.readStringData(9, 1));
		loginpage = new LoginPage(driver);
		String username = loginpage.login(usermail);
		if (username.contains(ExcelRead.readStringData(4, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(12, 1));
			extendTestPass(ExcelRead.readStringData(12, 1));

		} else {
			extendTestFail(ExcelRead.readStringData(13, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(13, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 3)
	public void verifyTitleVerification() throws IOException {

		ExtentReportcreateTest(ExcelRead.readStringData(10, 1));

		String title = driver.getTitle();
		if (title.contains(ExcelRead.readStringData(3, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(14, 1));
			extendTestPass(ExcelRead.readStringData(14, 1));

		} else {

			extendTestFail(ExcelRead.readStringData(15, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(15, 1));
		}

	}

	@Test(groups = { "Functional" }, enabled = true, priority = 4)
	public void verifyApplication_UrlVerification() throws IOException {
		ExtentReportcreateTest(ExcelRead.readStringData(11, 1));

		String url = driver.getCurrentUrl();
		if (url.contains(ExcelRead.readStringData(2, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(16, 1));
			extendTestPass(ExcelRead.readStringData(16, 1));

		} else {

			extendTestFail(ExcelRead.readStringData(17, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(17, 1));
		}
		ExtentReportinfo(ExcelRead.readStringData(18, 1));
	}

	@BeforeTest(groups = { "Functional" })
	@Parameters({ "Browser" })
	public void beforeTest(String Browser) throws InterruptedException, IOException {

		extendReportCreation();
		ExtentReportcreateTest(ExcelRead.readStringData(7, 1));
		ExtentReportinfo(ExcelRead.readStringData(8, 1));
		driver = launchBrowser1(Browser, ExcelRead.readStringData(1, 1));

	}

}





//<suiteXmlFile>TestSuites/${xmlfiles}</suiteXmlFile>
//<suiteXmlFile>TestSuites/testng.xml</suiteXmlFile>
