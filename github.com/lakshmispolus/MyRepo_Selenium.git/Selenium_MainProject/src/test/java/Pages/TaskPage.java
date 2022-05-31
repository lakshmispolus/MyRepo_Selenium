package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import Utilities.ExcelRead;

public class TaskPage extends BaseClass {
	WebDriver driver;

	public TaskPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"sidebar-menu\"]/li[5]/a")
	private WebElement tasktab;

	@FindBy(xpath = "//*[@id=\"page-content\"]/ul/div/div/a[5]")
	private WebElement tasktadd;

	@FindBy(xpath = "//*[@id=\"tasks-dropzone\"]/div[2]/button[4]")
	private WebElement tasktsave;

	@FindBy(xpath = "//*[@id=\"title-error\"]")
	private WebElement titleerror;

	@FindBy(xpath = "//*[@id=\"project_id-error\"]")
	private WebElement proerror;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"title\"]")
	private WebElement tasktitle;

	@FindBy(xpath = "//*[@id=\"description\"]")
	private WebElement description;

	@FindBy(xpath = "//*[@id=\"s2id_project_id\"]")
	private WebElement Project;

	@FindBy(xpath = "//*[@id=\"s2id_autogen26_search\"]")
	private WebElement Project1;

	@FindBy(xpath = "//ul[@class='select2-results']/li[2]")
	private WebElement Project2;

	@FindBy(xpath = "//div[@class='col-md-9']/div[@id='s2id_autogen41']")
	private WebElement Point;

	@FindBy(xpath = "//*[@id=\"s2id_autogen23_search\"]")
	private WebElement Point1;

	@FindBy(xpath = "//ul[@class='select2-results']/li[2]")
	private WebElement Point2;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]")
	private WebElement status1;

	@FindBy(xpath = "//*[@id=\"s2id_autogen44_search\"]")
	private WebElement status2;

	@FindBy(xpath = "//ul[@class='select2-results']/li[2]")
	private WebElement status3;

	@FindBy(xpath = "//button[@id='wcxgmzvmqdroeib' or @class='btn btn-default upload-file-button float-start me-auto btn-sm round dz-clickable']")
	private WebElement fileupload;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"task-table_filter\"]/label/input")
	private WebElement search;

	@FindBy(xpath = "//table[@id='task-table']/tbody/tr")
	private List<WebElement> tasktable;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"page-content\"]/ul/li[3]/a")
	private WebElement Kanban;

	@FindBy(xpath = "//a[normalize-space()='Gantt']")
	private WebElement Gantt;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//a[@class='btn btn-default'][normalize-space()='Add multiple tasks']")
	private WebElement Addmultipletasks;

	@FindBy(xpath = "//a[@class='btn btn-default'][normalize-space()='Add task']")
	private WebElement Addtask;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Boolean subTabsPresent() throws InterruptedException {
		implicitlyWait();
		if (Kanban.isDisplayed()) {
			Gantt.isDisplayed();
			return true;
		}
		return false;
	}

	public Boolean headerbtnsPresent() throws InterruptedException {
		implicitlyWait();
		if (Addmultipletasks.isDisplayed()) {
			Addtask.isDisplayed();
			return true;
		}
		return false;
	}

	public Boolean addTaskValidations() {

		tasktab.click();
		tasktadd.click();
		explicitwaitClick(tasktsave);
		String error = titleerror.getText();
		String error1 = proerror.getText();
		if (error.contains(error1)) {
			return true;
		}
		return false;
	}

	public void addTask() throws AWTException, Exception {

		tasktitle.sendKeys(ExcelRead.readStringData(98, 1));
		description.sendKeys(ExcelRead.readStringData(99, 1));
		Project.click();
		description.sendKeys(ExcelRead.readStringData(74, 1));
		Project2.click();
		explicitwaitClick(fileupload);
		String file_path = System.getProperty("user.dir") + "\\src\\test\\resources\\Get_Started_With_Smallpdf.pdf";
		fileUploadftn(file_path);
		explicitwaitClick(tasktsave);
	}

	public int taskSearch() throws IOException {
		search.sendKeys(ExcelRead.readStringData(98, 1));
		List<WebElement> allLinks = tasktable;
		Iterator<WebElement> iter = allLinks.iterator();
		int count = 0;
		while (iter.hasNext()) {
			WebElement we = iter.next();
			String data = we.getText();
			if (data.contains(ExcelRead.readStringData(98, 1))) {
				count++;
				break;
			}
		}
		return count;
	}
}
