package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoProductPage {
 WebDriver driver=null;

 public SauceDemoProductPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
 }
   @FindBy(id = "add-to-cart-sauce-labs-backpack")
   private WebElement addToCart;
   
   @FindBy(css = "[class='shopping_cart_badge']")
   private WebElement item;

   public void getAddToCart() {
	addToCart.click();
   }
   
   public void getItem()
   {
	  if(item.getText().equals("1"))
	  {
		  System.out.println("Cart contains "+item.getText()+" item ");
		  item.click();
	  }
   }
   
 
}
