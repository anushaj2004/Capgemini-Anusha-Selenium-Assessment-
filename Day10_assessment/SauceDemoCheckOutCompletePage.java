package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckOutCompletePage {
WebDriver driver;

public SauceDemoCheckOutCompletePage(WebDriver driver) {
	
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//h2[text()='Thank you for your order!']")
private WebElement message;

public void getMessage() {
	
	if(message.getText().equals("Thank you for your order!"))
	{
	System.out.println(message.getText());
	}
	else
	{
		System.out.println("message didnt displayed");
	}
}


}
