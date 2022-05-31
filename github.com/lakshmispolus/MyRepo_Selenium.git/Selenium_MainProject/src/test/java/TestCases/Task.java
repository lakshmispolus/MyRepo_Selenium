package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Pages.TaskPage;
import Utilities.BaseClass;
import Utilities.ExcelRead;

public class Task extends BaseClass {
	TaskPage taskpage;

	@Test(groups = {"Functional"},enabled = false, priority = 26)
	public void verifyTaskSubTabsPresent() throws InterruptedException, IOException {

		taskpage = new TaskPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(119, 1));
		Boolean value = taskpage.subTabsPresent();
		if (value) {
			Assert.assertTrue(true, ExcelRead.readStringData(120, 1));
			extendTestPass(ExcelRead.readStringData(120, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(121, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(121, 1));
		}
	}
	
	@Test(groups = {"Functional"},enabled = false, priority = 27)
	public void verifyTaskTabsHeaderbtnsPresent() throws InterruptedException, IOException {

		taskpage = new TaskPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(122, 1));
		Boolean value = taskpage.headerbtnsPresent();
		if (value) {
			Assert.assertTrue(true, ExcelRead.readStringData(123, 1));
			extendTestPass(ExcelRead.readStringData(123, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(124, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(124, 1));
		}
	}

	
	@Test(groups = {"Functional"},enabled = true, priority = 28)
	public void verifyAddTaskValidations() throws InterruptedException, IOException {

		taskpage = new TaskPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(91, 1));
		Boolean value = taskpage.addTaskValidations();
		if (value) {
			Assert.assertTrue(true, ExcelRead.readStringData(92, 1));
			extendTestPass(ExcelRead.readStringData(92, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(93, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(93, 1));
		}
	}

	@Test(groups = {"Functional"},enabled = true, priority = 29)
	public void verifyAddingNewTask() throws AWTException, Exception   {

		taskpage = new TaskPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(94, 1));
		taskpage.addTask();
	}

	@Test(groups = {"Functional"},enabled = true, priority = 30)
	public void verifySearchingNewlyAddedTask() throws InterruptedException, IOException {

		taskpage = new TaskPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(95, 1));
		int count = taskpage.taskSearch();
		if (count > 0) {
			Assert.assertTrue(true, ExcelRead.readStringData(96, 1));
			extendTestPass(ExcelRead.readStringData(96, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(97, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(97, 1));
		}
	}

	@AfterTest(groups = {"Functional"})
	public void afterTest() {
		extent.flush();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.close();
	}
}
