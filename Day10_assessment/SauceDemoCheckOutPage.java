package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckOutPage {
  WebDriver driver;

  public SauceDemoCheckOutPage(WebDriver driver) {
	
	this.driver = driver;
	PageFactory.initElements(driver,this);
  }
  @FindBy(id = "first-name")
  private WebElement firstName;
  
  @FindBy(id = "last-name")
  private WebElement lastName;
  
  @FindBy(id = "postal-code")
  private WebElement zipCode;
  
  @FindBy(id = "continue")
  private WebElement continueButton;
  
  public void getFirstName(String value) {
	firstName.sendKeys(value);
}

  public void getLastName(String value) {
	lastName.sendKeys(value);
  }

  public void getZipCode(String value) {
	zipCode.sendKeys(value);
  }

  public void getContinueButton() {
	  continueButton.click();;
  }
  
}
