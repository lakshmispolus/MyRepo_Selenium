package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ClientPage;
import Utilities.BaseClass;
import Utilities.ExcelRead;

public class ClientTab extends BaseClass {

	ClientPage clientpage;

	@Test(groups = { "Functional" }, enabled = false, priority = 9)
	public void verifyClientTabSubTabs() throws IOException, InterruptedException {
		ExtentReportcreateTest(ExcelRead.readStringData(116, 1));
		clientpage = new ClientPage(driver);
		Boolean result = clientpage.subTabsPresent();
		if (result) {
			Assert.assertTrue(true, ExcelRead.readStringData(117, 1));
			extendTestPass(ExcelRead.readStringData(117, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(118, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(118, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 10)
	public void verifyAddClientPopupMandatoryValidations() throws IOException {

		clientpage = new ClientPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(19, 1));
		String errormsg = clientpage.mandatoryValidations();
		if (errormsg.equalsIgnoreCase(ExcelRead.readStringData(20, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(21, 1));
			extendTestPass(ExcelRead.readStringData(21, 1));
			ExtentReportinfo(ExcelRead.readStringData(21, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(22, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(22, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 11)
	public void verifyAddingNewClient() throws Exception {

		clientpage = new ClientPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(23, 1));
		implicitlyWait();
		clientpage.addClients(ExcelRead.readStringData(24, 1));
		extendTestPass(ExcelRead.readStringData(25, 1));
		ExtentReportinfo(ExcelRead.readStringData(25, 1));
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 12)
	public void verifySearchingNewlyAddedClient() throws InterruptedException, IOException {

		clientpage = new ClientPage(driver);
		implicitlyWait();
		ExtentReportcreateTest(ExcelRead.readStringData(26, 1));
		String clientsearchdata = clientpage.clientsSearch(ExcelRead.readStringData(24, 1));
		if (clientsearchdata.contains(ExcelRead.readStringData(24, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(27, 1));
			extendTestPass(ExcelRead.readStringData(27, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(28, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(28, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 13)
	public void verifyEditingClient() throws InterruptedException, IOException {

		clientpage = new ClientPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ExtentReportcreateTest(ExcelRead.readStringData(29, 1));
		int count = clientpage.editClients(ExcelRead.readStringData(24, 1));
		if (count > 0) {
			Assert.assertTrue(true, ExcelRead.readStringData(30, 1));
			extendTestPass(ExcelRead.readStringData(30, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(31, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(31, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 14)
	public void verifyDeletingClient() throws Exception {

		clientpage = new ClientPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(32, 1));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		int count = clientpage.deleteClients(ExcelRead.readStringData(24, 1));
		switch (count) {

		case 1:
			Assert.assertTrue(true, ExcelRead.readStringData(33, 1));
			extendTestPass(ExcelRead.readStringData(33, 1));
			break;
		case 0:
			Assert.assertTrue(true, ExcelRead.readStringData(34, 1));
			extendTestPass(ExcelRead.readStringData(34, 1));
			break;
		default:
			extendTestFail(ExcelRead.readStringData(35, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(35, 1));
			break;
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 15)
	public void verifyAddingMultipleContacts() throws Exception {
		clientpage = new ClientPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ExtentReportcreateTest(ExcelRead.readStringData(36, 1));
		clientpage.addingMultipleContacts(ExcelRead.readStringData(37, 1));
		extendTestPass(ExcelRead.readStringData(38, 1));
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 16)
	public void verifySearchingMultipleContacts() throws Exception {

		clientpage = new ClientPage(driver);
		implicitlyWait();
		Thread.sleep(1000);
		ExtentReportcreateTest(ExcelRead.readStringData(39, 1));
		int count = clientpage.multiContactsSearch(ExcelRead.readStringData(58, 1));
		if (count > 0) {
			Assert.assertTrue(true, ExcelRead.readStringData(41, 1));
			extendTestPass(ExcelRead.readStringData(41, 1));
		} else {

			extendTestFail(ExcelRead.readStringData(42, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(42, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 17)
	public void verifyDeletingMultipleContacts() throws Exception {

		clientpage = new ClientPage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ExtentReportcreateTest(ExcelRead.readStringData(43, 1));
		clientpage.multiContactsDelete();
	}

	@Test(groups = { "Functional" }, enabled = false, priority = 18)
	public void verifyImportClient() throws Exception {

		clientpage = new ClientPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(44, 1));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		clientpage.importClient();
		String clientsearchdata = clientpage.clientsSearch(ExcelRead.readStringData(45, 1));
		if (clientsearchdata.contains(ExcelRead.readStringData(45, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(46, 1));
			extendTestPass(ExcelRead.readStringData(46, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(47, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(47, 1));
		}
	}
}
