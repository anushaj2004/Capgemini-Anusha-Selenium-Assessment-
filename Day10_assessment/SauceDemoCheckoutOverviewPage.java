package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckoutOverviewPage {
 WebDriver driver;

 public SauceDemoCheckoutOverviewPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
 }
 
 @FindBy(id = "finish")
 private WebElement finishButton;

 public void CheckOutOverviewPageDisplayed()
 {
	 if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html"))
	 {
		 System.out.println("Check Out Overview Page is Displayed");
	 }
	 else
	 {
		 System.out.println("check out overview page is displayed ");
	 }
 }
 public void getFinishButton() {
	finishButton.click();
 }
 
 
 
}
