package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import Utilities.ExcelRead;

public class ProjectPage extends BaseClass {
	WebDriver driver;
	

	public ProjectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"sidebar-menu\"]/li[4]/a/span")
	private WebElement project;

	@FindBy(xpath = "//*[@id=\"page-content\"]/div/div[1]/div/a[1]")
	private WebElement managelabel;

	@FindBy(xpath = "//*[@id=\"title\"]")
	private WebElement enterurlabel;

	@FindBy(xpath = "//span[@class='color-tag clickable mr15 'and @data-color='#aab7b7']")
	private WebElement labelcolor;

	@FindBy(xpath = "//div[@class='col-md-2']/button")
	private WebElement labelsavebtn;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//div[@id='label-show-area']/span")
	private List<WebElement> labelsize;

	@FindBy(xpath = "//*[@id=\"label-delete-btn\"]")
	private WebElement labeldelete;

	@FindBy(xpath = "//*[@id=\"labels-form\"]/div[2]/button[3]")
	private WebElement labelclosebtn;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"page-content\"]/div/div[1]/div/a[2]")
	private WebElement addproject;

	@FindBy(xpath = "//*[@id=\"project-form\"]/div[2]/button[3]")
	private WebElement addprojectsave;

	@FindBy(xpath = "//*[@id=\"title-error\"]")
	private WebElement error;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"title\"]")
	private WebElement title;

	@FindBy(xpath = "//span[@id='select2-chosen-6']")
	private WebElement client;

	@FindBy(xpath = "//input[@id=\"s2id_autogen3625_search\" and @class='select2-input']")
	private WebElement clientsearch;

	@FindBy(xpath = "//ul[@class='select2-results']//*[text()='PolusTest']")
	private WebElement clientsearchvalue; ///////////// value inside xpath

	@FindBy(xpath = "//*[@id=\"description\"]")
	private WebElement description;

	@FindBy(xpath = "//*[@id=\"start_date\"]")
	private WebElement start_date;

	@FindBy(xpath = "//*[@id=\"deadline\"]")
	private WebElement deadline;

	@FindBy(xpath = "//*[@id=\"price\"]")
	private WebElement price;

	@FindBy(xpath = "//*[@id=\"s2id_autogen10\"]")
	private WebElement label;

	@FindBy(xpath = "//*[@id=\"project-form\"]/div[2]/button[3]")
	private WebElement submit;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"project-table_filter\"]/label/input")
	private WebElement table_filter;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private WebElement tabledata;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//*[@id=\"project-table\"]/tbody/tr/td[9]/a[2]")
	private WebElement projectdelete;

	@FindBy(xpath = "//button[@id=\"confirmDeleteButton\" or @class='btn btn-danger']")
	private WebElement projectdeletepopup;

	@FindBy(xpath = "//table[@id='project-table']/tbody/tr")
	private List<WebElement> projectcount;

	@FindBy(xpath = "//table[@id='project-table']/tbody/tr/td[2]")
	private List<WebElement> projectdatacheck;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//table[@id='project-table']/tbody/tr/td[9]/a[1]")
	private WebElement projectedit;
	
	@FindBy(xpath = "//*[@id=\"project-form\"]/div[2]/button[2]")
	private WebElement editsubmit;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addlabel() throws IOException, InterruptedException {
		project.click();
		managelabel.click();
		Thread.sleep(1000);
		enterurlabel.sendKeys(ExcelRead.readStringData(84, 1));
		labelcolor.click();
		explicitwaitClick(labelsavebtn);

	}

	public int deletelabel() throws IOException {

		List<WebElement> allLinks = labelsize;
		int size = allLinks.size();
		WebElement labelselecting = null;
		int count = 0;
		for (int i = 1; i <= size; i++) {
			labelselecting = driver.findElement(By.xpath("//div[@id='label-show-area']/span[" + i + "]"));
			if (labelselecting.getText().contains(ExcelRead.readStringData(84, 1))) {
				driver.findElement(By.xpath("//div[@id='label-show-area']/span[" + i + "]")).click();
				JavascriptClick(labeldelete);			
				count++;
				break;
			}
		}

		labelclosebtn.click();
		return count;

	}

	public String projectMandatoryValidation() {
		
		project.click();
		addproject.click();
		explicitwaitClick(addprojectsave);
		explicitwaitClick(addprojectsave);
		String errormsg =explicitwaitgetText(error);
		return errormsg;

	}

	public void addingProject() throws IOException {

		JavascriptClick(addproject);
		explicitwaitSendkeys(title, ExcelRead.readStringData(74, 1));
		implicitlyWait();
		description.sendKeys(ExcelRead.readStringData(85, 1));
		start_date.sendKeys(ExcelRead.readIntegerData(86, 1));
		deadline.sendKeys(ExcelRead.readIntegerData(87, 1));
		implicitlyWait();
		price.sendKeys(ExcelRead.readIntegerData(88, 1));

		Actions actions = new Actions(driver);
		actions.moveToElement(label).click();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		label.sendKeys(ExcelRead.readStringData(89, 1));
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();

		implicitlyWait();
		explicitwaitClick(submit);
	}

	public String projectFilter() throws IOException {
		
		explicitwaitSendkeys(table_filter, ExcelRead.readStringData(74, 1));
		String projectsearchdata = tabledata.getText();
		table_filter.clear();
		return projectsearchdata;

	}

	public int editProject() throws IOException, InterruptedException {

		implicitlyWait();
	//	explicitwaitSendkeys(table_filter, ExcelRead.readStringData(74, 1));
		List<WebElement> Links = projectdatacheck;
		Iterator<WebElement> iter = Links.iterator();
		int count = 0;
		while (iter.hasNext()) {
			WebElement we = iter.next();
			String data = we.getText();
			if (data.contains(ExcelRead.readStringData(74, 1))) {
				Thread.sleep(1000);
				projectedit.click();
				title.sendKeys(ExcelRead.readStringData(90, 1));
				explicitwaitClick(editsubmit);
				count++;
				break;
			}
		}		
		return count;
	}

	public int deleteProject() throws Exception {
		
	//	explicitwaitSendkeysClear(table_filter);
		Thread.sleep(1000);
		implicitlyWait();
	//	explicitwaitSendkeys(table_filter, ExcelRead.readStringData(74, 1));
		List<WebElement> Links = projectdatacheck;
		int listcounts = Links.size();
		int count = 0;
		if (listcounts > 1) {
			List<WebElement> allLinks = projectcount;
			int listcount = allLinks.size();

			WebElement name = null;
			for (int i = 1; i <= listcount; i++) {
				name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]"));
				if (name.getText().contains(ExcelRead.readStringData(74, 1))) {
					explicitwaitClick(projectdelete);				
					explicitwaitClick(projectdeletepopup);
					Thread.sleep(1000);
					count++;
					break;
				}
			}
		}
		return count;
	}
}
