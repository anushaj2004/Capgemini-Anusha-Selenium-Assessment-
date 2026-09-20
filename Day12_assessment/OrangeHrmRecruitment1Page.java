package PomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHrmRecruitment1Page {
	 WebDriver driver;

	 public OrangeHrmRecruitment1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	 }
	 @FindBy(xpath = "//a[text()='Vacancies']")
	 private WebElement vacanciesClick;
	 
	 @FindBy(css = "[class='oxd-button oxd-button--medium oxd-button--secondary']")
	 private WebElement addButton;

	 public void getVacanciesClick() {
		 vacanciesClick.click();
	 }

	 public void getAddButton() {
		 addButton.click();
	 }
	 
	 
	 
	 
}
