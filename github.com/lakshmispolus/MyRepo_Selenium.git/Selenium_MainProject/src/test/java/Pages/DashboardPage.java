package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;


public class DashboardPage extends BaseClass {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"left-menu-toggle-mask\"]/div[1]/a[2]/img")
	private WebElement applogo;

	@FindBy(xpath = "//a[@href='https://buffalocart.com/demo/crm/index.php/events']")
	private WebElement eventstab;

	@FindBy(xpath = "//span[normalize-space()='Clients']")
	private WebElement clientstab;

	@FindBy(xpath = "//span[normalize-space()='Projects']")
	private WebElement projecttab;

	@FindBy(xpath = "//span[normalize-space()='Tasks']")
	private WebElement tasktab;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//a[@class='nav-link sidebar-toggle-btn']")
	private WebElement sidebartogglebtn;
	
	@FindBy(xpath = "//a[@class=' nav-link dropdown-toggle']")
	private WebElement dropdowntogglebtn;
	
	@FindBy(xpath = "//a[@data-real-target='#projects-quick-list-container']")
	private WebElement projectsquick;
	
	@FindBy(xpath = "//a[@data-real-target='#clients-quick-list-container']")
	private WebElement clientsquick;
	
	@FindBy(xpath = "//a[@data-real-target='#my-dashboards-list-container']")
	private WebElement dashboardquick;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//span[@class='user-name ml10']")
	private WebElement adminclick;
	
	@FindBy(xpath = "//a[normalize-space()='My Profile']")
	private WebElement myprofile;
	
	@FindBy(xpath = "//strong[normalize-space()='Admin']")
	private WebElement adminlabel;

	public Boolean applicationLogoPresent() {

		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0",
				applogo);
		if (p) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean allTabsPresent() {

		if (eventstab.isDisplayed()) {
			if (eventstab.isDisplayed()) {
				if (clientstab.isDisplayed()) {
					if (projecttab.isDisplayed()) {
						tasktab.isDisplayed();
						return true;
					}
				}
			}

		}
		return false;
	}

	public Boolean allbuttonsPresent() {

		if (sidebartogglebtn.isDisplayed()) {
			if (dropdowntogglebtn.isDisplayed()) {
				if (projectsquick.isDisplayed()) {
					if (clientsquick.isDisplayed()) {
						dashboardquick.isDisplayed();
						return true;
					}
				}
			}

		}
		return false;
	}
	
	public String admindetails()
	{
		adminclick.click();
		explicitwaitClick(myprofile);
		String text=explicitwaitgetText(adminlabel);
		return text;

	}
}
