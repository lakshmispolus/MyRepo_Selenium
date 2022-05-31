package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ProjectPage;
import Utilities.BaseClass;
import Utilities.ExcelRead;

public class ProjectTab extends BaseClass {
	ProjectPage projectpage;

	@Test(groups = { "Functional" }, enabled = true, priority = 19)
	public void verifyAddingNewLabel() throws InterruptedException, IOException {

		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(64, 1));
		projectpage.addlabel();
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 20)
	public void verifyDeletinglabel() throws InterruptedException, IOException {
		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(65, 1));
		int count = projectpage.deletelabel();
		if (count > 0) {
			extendTestPass(ExcelRead.readStringData(66, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(67, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 21)
	public void verifyAddProjectMandatoryValidations() throws IOException {

		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(68, 1));
		String errormsg = projectpage.projectMandatoryValidation();
		if (errormsg.equalsIgnoreCase(ExcelRead.readStringData(20, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(69, 1));
			extendTestPass(ExcelRead.readStringData(69, 1));

		} else {
			extendTestFail(ExcelRead.readStringData(70, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(70, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 22)
	public void verifyAddingNewProject() throws InterruptedException, IOException {
		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(71, 1));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"title\"]"))) .sendKeys("LaxProject");
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"select2-chosen-6\"]")).click();
		 * driver.findElement(By.xpath("//*[@id=\"s2id_autogen6_search\"]")).sendKeys(
		 * "successfully"); driver.findElement(By.xpath(
		 * "//ul[@class='select2-results']//*[text()='successfully']")).click();
		 * 
		 */
		projectpage.addingProject();
		Assert.assertTrue(true, ExcelRead.readStringData(72, 1));
		extendTestPass(ExcelRead.readStringData(72, 1));
		ExtentReportinfo(ExcelRead.readStringData(72, 1));
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 23)
	public void verifySearchingNewlyAddedProject() throws InterruptedException, IOException {

		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(73, 1));
		implicitlyWait();
		String projectsearchdata = projectpage.projectFilter();
		if (projectsearchdata.contains(ExcelRead.readStringData(74, 1))) {
			Assert.assertTrue(true, ExcelRead.readStringData(75, 1));
			extendTestPass(ExcelRead.readStringData(75, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(76, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(76, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 24)
	public void verifyEditingProject() throws InterruptedException, IOException {

		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(77, 1));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int count = projectpage.editProject();
		if (count > 0) {
			Assert.assertTrue(true, ExcelRead.readStringData(78, 1));
			extendTestPass(ExcelRead.readStringData(78, 1));
		} else {
			extendTestFail(ExcelRead.readStringData(79, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(79, 1));
		}
	}

	@Test(groups = { "Functional" }, enabled = true, priority = 25)
	public void verifyDeletingProject() throws Exception {

		projectpage = new ProjectPage(driver);
		ExtentReportcreateTest(ExcelRead.readStringData(80, 1));
		implicitlyWait();
		int count = projectpage.deleteProject();
		switch (count) {
		case 1:
			Assert.assertTrue(true, ExcelRead.readStringData(81, 1));
			extendTestPass(ExcelRead.readStringData(81, 1));
			break;
		case 0:
			Assert.assertTrue(true, ExcelRead.readStringData(82, 1));
			extendTestPass(ExcelRead.readStringData(82, 1));
			break;
		default:
			extendTestFail(ExcelRead.readStringData(83, 1));
			Assert.assertTrue(false, ExcelRead.readStringData(83, 1));
			break;
		}

	}
}
