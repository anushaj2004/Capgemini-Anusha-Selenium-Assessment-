package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCartPage {
  WebDriver driver;

  public SauceDemoCartPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
  }
  
  @FindBy(id = "item_4_title_link")
  private WebElement itemDisplayed;
  
  @FindBy(id = "checkout")
  private WebElement checkoutButton;

  public void getItemDisplayed()  {
	if(itemDisplayed.getText().contains("Sauce Labs Backpack"))
	{
		System.out.println(itemDisplayed.getText()+" is displayed ");
	}
	else
	{
		System.out.println("Product is not displayed");
	}
  }
  
  public void getCheckOut()
  {
	  checkoutButton.click();
  }
  
}
