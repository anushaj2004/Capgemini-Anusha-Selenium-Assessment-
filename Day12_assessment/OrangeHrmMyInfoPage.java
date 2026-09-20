package PomUtilities;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmMyInfoPage {

	WebDriver driver;

	public OrangeHrmMyInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(css = "[placeholder='First Name']")
	private WebElement fn;
	
	@FindBy(css = "[placeholder='Middle Name']" )
	private WebElement mn;
	
	@FindBy(name = "lastName")
	private WebElement ln;
	
	
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement empid;
	
	@FindBy(xpath="(//button[@type=\"submit\"])[1]")
	private WebElement save;
	
	

	public String getFn(String value) {
		fn.sendKeys(Keys.CONTROL+"a");
		fn.sendKeys(Keys.BACK_SPACE);
		fn.sendKeys(value);
		return value;
	}

	public void getMn(String value) {
		mn.sendKeys(Keys.CONTROL+"a");
		mn.sendKeys(Keys.BACK_SPACE);
		mn.sendKeys(value);
	}

	public void getLn(String value) {
		ln.sendKeys(Keys.CONTROL+"a");
		ln.sendKeys(Keys.BACK_SPACE);
		ln.sendKeys(value);
	}

	public void getEmpid(String value) {
		empid.sendKeys(Keys.CONTROL+"a");
		empid.sendKeys(Keys.BACK_SPACE);
		empid.sendKeys(value);
	}

	public void getSave() {
		save.click();
	}
	
	
}
