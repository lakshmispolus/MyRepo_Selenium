package Pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import Utilities.ExcelRead;

public class ClientPage extends BaseClass {
	WebDriver driver;
	ClientPage clientpage;

	public ClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"sidebar-menu\"]/li[3]/a/span")
	private WebElement clientstab;

	@FindBy(xpath = "//*[@id=\"client-tabs\"]/div/div/a[2]")
	private WebElement addclientbtn;

	@FindBy(xpath = "//*[@id=\"client-form\"]/div[2]/button[3]")
	private WebElement addclientsave;

	@FindBy(xpath = "//*[@id=\"company_name-error\"]")
	private WebElement error;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(id = "company_name")
	private WebElement cmpyname;

	@FindBy(id = "address")
	private WebElement address;

	@FindBy(xpath = "//*[@id=\"city\"]")
	private WebElement city;

	@FindBy(xpath = "//*[@id=\"state\"]")
	private WebElement state;

	@FindBy(xpath = "//*[@id=\"zip\"]")
	private WebElement zip;

	@FindBy(xpath = "//*[@id=\"country\"]")
	private WebElement country;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	private WebElement phone;

	@FindBy(xpath = "//input[@id='website']")
	private WebElement website;

	@FindBy(xpath = "//input[@id='vat_number']")
	private WebElement vatnum;

	@FindBy(xpath = "//ul[@class='select2-choices']")
	private WebElement clientgroups;

	@FindBy(xpath = "//ul[@class='select2-results']//*[text()='Good clients']")
	private WebElement goodclients;

	@FindBy(xpath = "//*[@id=\"client-form\"]/div[2]/button[3]")
	private WebElement submitbtn;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//a[contains(text(),'Clients')]")
	private WebElement clientssubtab;

	@FindBy(xpath = "//*[@id=\"client-table_filter\"]/label/input")
	private WebElement clientssearch;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"client-tabs\"]/li[1]/a")
	private WebElement overview;

	@FindBy(xpath = "//*[@id=\"client-tabs\"]/div/div/a[1]")
	private WebElement importclient;

	@FindBy(xpath = "//*[@id=\"file-upload-dropzone\"]/div/button")
	private WebElement fileupload;

	@FindBy(xpath = "//button[@id='form-next' or @class='btn btn-info text-white']")
	private WebElement nextbtn;

	@FindBy(xpath = "//*[@id=\"form-submit\"]")
	private WebElement uploadbtn;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"client-table\"]/tbody/tr[1]/td[6]/a[2]")
	private WebElement clientdelete;

	@FindBy(xpath = "//button[@id=\"confirmDeleteButton\"]")
	private WebElement clientdeletepopup;

	@FindBy(xpath = "//table[@id='client-table']/tbody/tr/td[2]")
	private List<WebElement> clientdatacheck;

	@FindBy(xpath = "//table[@id='client-table']/tbody/tr")
	private List<WebElement> clientcount;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//table[@id='client-table']/tbody/tr/td[6]/a[1]")
	private WebElement clientedit;

	@FindBy(xpath = "//*[@id=\"app-alert-dtnlu\"]/div[1]")
	private WebElement clienteditalert;

	@FindBy(xpath = "//*[@id=\"client-form\"]/div[2]/button[2]")
	private WebElement clienteditsave;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

	@FindBy(xpath = "//*[@id=\"client-form\"]/div[2]/button[2]")
	private WebElement saveandcont;

	@FindBy(xpath = "//*[@id=\"first_name\"]")
	private WebElement fname;

	@FindBy(xpath = "//*[@id=\"last_name\"]")
	private WebElement lname;

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	private WebElement phone1;

	@FindBy(xpath = "//*[@id=\"skype\"]")
	private WebElement skype;

	@FindBy(xpath = "//*[@id=\"job_title\"]")
	private WebElement job_title;

	@FindBy(xpath = "//*[@id=\"gender_female\"]")
	private WebElement gender_female;

	@FindBy(xpath = "//*[@id=\"generate_password\"]")
	private WebElement generate_password;

	@FindBy(xpath = "//*[@id=\"show_hide_password\"]")
	private WebElement show_hide_password;

	@FindBy(xpath = "//*[@id=\"login_password\"]")
	private WebElement loginpassword;

	@FindBy(xpath = "//*[@id=\"save-and-add-button\"]")
	private WebElement saveaddmorebtn;

	@FindBy(xpath = "//*[@id=\"contact-form\"]/div[2]/button[1]")
	private WebElement closebtn;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"client-tabs\"]/li[3]/a")
	private WebElement contacttab;

	@FindBy(xpath = "//*[@id=\"contact-table_filter\"]/label/input")
	private WebElement contactsearch;

	@FindBy(xpath = "//table[@id='contact-table']/tbody/tr")
	private List<WebElement> contactsearchcount;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//*[@id=\"contact-table\"]/tbody/tr/td[8]/a")
	private WebElement contactdelete;

	@FindBy(xpath = "//*[@id=\"app-alert-7jdi9\"]/div[1]")
	private WebElement contactdeletealert;
	
	@FindBy(xpath = "//*[@id=\"confirmationModal\"]/div/div/div[3]/button[2]")
	private WebElement contactdeleteclose;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public Boolean subTabsPresent() throws InterruptedException {
			if (clientssubtab.isDisplayed()) {
				contacttab.isDisplayed();
				return true;
			}				
		
		return false;
	}


	public String mandatoryValidations() {

		clientstab.click();
		addclientbtn.click();
		explicitwaitClick(addclientsave);
		String errormsg = error.getText();
		return errormsg;

	}

	public void addClients(String Clientname) throws Exception {
		clientpage = new ClientPage(driver);
		clientpage.addingClients(Clientname);
		explicitwaitClick(submitbtn);
	}

	public void addingClients(String Clientname) throws Exception {

		cmpyname.sendKeys(Clientname);
		address.sendKeys(ExcelRead.readStringData(49, 1));
		city.sendKeys(ExcelRead.readStringData(50, 1));
		state.sendKeys(ExcelRead.readStringData(51, 1));
		zip.sendKeys(ExcelRead.readIntegerData(52, 1));
		country.sendKeys(ExcelRead.readStringData(53, 1));
		phone.sendKeys(ExcelRead.readIntegerData(54, 1));

		Actions actions = new Actions(driver);
		actions.moveToElement(clientgroups).click();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		click(driver, goodclients);
		website.sendKeys(ExcelRead.readStringData(55, 1));
		vatnum.sendKeys(ExcelRead.readStringData(56, 1));
	}

	public String clientsSearch(String Clientname) {
		JavascriptClick(clientssubtab);
		explicitwaitSendkeys(clientssearch, Clientname);
		String clientsearchdata = null;
		WebElement name = null;
		for (int i = 1; i <= 10; i++) {
			name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]"));
			if (name.getText().contains(Clientname)) {
				clientsearchdata = name.getText();
				return clientsearchdata;
			}
		}
		return clientsearchdata;
	}

	public int editClients(String Clientname) throws IOException, InterruptedException {

		// explicitwaitSendkeysClear(clientssearch);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// explicitwaitSendkeys(clientssearch, Clientname);
		implicitlyWait();
		Thread.sleep(1000);

		List<WebElement> Links = clientdatacheck;
		Iterator<WebElement> iter = Links.iterator();
		int count = 0;
		while (iter.hasNext()) {
			WebElement we = iter.next();
			String data = we.getText();
			if (data.contains(Clientname)) {
				clientedit.click();
				cmpyname.sendKeys(ExcelRead.readStringData(57, 1));
				explicitwaitClick(clienteditsave);
				count++;
				return count;
			}
		}
		return count;
	}

	public int deleteClients(String Clientname) throws InterruptedException, IOException {

		// explicitwaitSendkeysClear(clientssearch);
		// explicitwaitSendkeys(clientssearch, Clientname);
		implicitlyWait();
		int count = 0;
		WebElement name = null;
		for (int i = 2; i <= 10; i++) {
			name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]"));
			if (name.getText().contains("PSGTest")) {

				Thread.sleep(1000);
				// explicitwaitClick(clientdelete);
				// explicitwaitClick(clientdeletepopup);
				clientdelete.click();
				clientdeletepopup.click();
				Thread.sleep(2000);
				count++;
				return count;
			}
		}
		return count;
	}

	public void addingMultipleContacts(String Clientname) throws Exception {

		clientpage = new ClientPage(driver);
		Thread.sleep(2000);
		contactdeleteclose.click();
		explicitwaitClick(addclientbtn);
		clientpage.addingClients(Clientname);

		explicitwaitClick(saveandcont);
		explicitwaitSendkeys(fname, ExcelRead.readStringData(58, 1));
		lname.sendKeys(ExcelRead.readStringData(59, 1));
		
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);   
		email.sendKeys(ExcelRead.readStringData(60, 1)+randomInt+"@gmail.com");
		phone1.sendKeys(ExcelRead.readIntegerData(61, 1));
		skype.sendKeys(ExcelRead.readStringData(62, 1));
		job_title.sendKeys(ExcelRead.readStringData(63, 1));
		gender_female.click();
		explicitwaitClick(generate_password);
		explicitwaitgetText(loginpassword);
		explicitwaitClick(saveaddmorebtn);
		explicitwaitClick(closebtn);

	}

	public int multiContactsSearch(String Contactname) throws InterruptedException {
		JavascriptClick(contacttab);
		explicitwaitSendkeys(contactsearch, Contactname);
		Thread.sleep(1000);
		List<WebElement> listcount = contactsearchcount;
		int size = listcount.size();
		int count = 0;
		WebElement name = null;
		for (int i = 1; i <= size; i++) {
			name = driver.findElement(By.xpath("//table[@id='contact-table']/tbody/tr[" + i + "]/td[2]/a"));
			if (name.getText().contains(Contactname)) {
				count++;
				return count;
			}
		}
		return count;
	}

	public void multiContactsDelete() {

		explicitwaitClick(contactdelete);
		contactdelete.click();
	}

	public void importClient() throws Exception {
		explicitwaitClick(overview);
		explicitwaitClick(importclient);
		fileupload.click();
		String file_path = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\clients-sample-new.xlsx";
		fileUploadftn(file_path);		
		JavascriptExecutor objjavascript = (JavascriptExecutor) driver;
		objjavascript.executeScript("window.scrollBy(0,200)");
		explicitwaitClick(nextbtn);
		explicitwaitClick(uploadbtn);
	}

}
