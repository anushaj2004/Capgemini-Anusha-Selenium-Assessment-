package BaseClassImplementation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClassSauceDemo;
import PomUtilities.SauceDemoCartPage;
import PomUtilities.SauceDemoCheckOutCompletePage;
import PomUtilities.SauceDemoCheckOutPage;
import PomUtilities.SauceDemoCheckoutOverviewPage;
import PomUtilities.SauceDemoProductPage;

public class SauceDemoTestNg extends BaseClassSauceDemo{
   @Test
   public void login() throws EncryptedDocumentException, IOException, InterruptedException
   {
	   if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("product page is displayed");
		}
		else
		{
			System.out.println("product page is not displayed");
		}
	    
   }
   @Test
   public void orderPlacementTest() throws InterruptedException, EncryptedDocumentException, IOException 
   {
	   SauceDemoProductPage s=new SauceDemoProductPage(driver);
	   Thread.sleep(2000);
	   s.getAddToCart();
	   Thread.sleep(2000);
	   s.getItem();
	   Thread.sleep(2000);
	   SauceDemoCartPage s1=new SauceDemoCartPage(driver);
	   Thread.sleep(2000);
	   s1.getItemDisplayed();
	   Thread.sleep(2000);
	   s1.getCheckOut();
	   Thread.sleep(2000);
	   SauceDemoCheckOutPage s2=new SauceDemoCheckOutPage(driver);
	   FileInputStream fis=new FileInputStream("src/test/resources/DDT/SauceDemoCheckout.xlsx");
	   Workbook wb = WorkbookFactory.create(fis);
	   String fn=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	   Thread.sleep(2000);
	   s2.getFirstName(fn);
	   Thread.sleep(2000);
	   String ln=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
	   Thread.sleep(2000);
	   s2.getLastName(ln);
	   Thread.sleep(2000);
	   DataFormatter df=new DataFormatter();
	   String zipcode=df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(2));
	   Thread.sleep(2000);
	   s2.getZipCode(zipcode);
	   Thread.sleep(2000);
	   s2.getContinueButton();
	   
	   SauceDemoCheckoutOverviewPage s3=new SauceDemoCheckoutOverviewPage(driver);
	   s3.CheckOutOverviewPageDisplayed();
	   Thread.sleep(1000);
	   s3.getFinishButton();
	   
	   SauceDemoCheckOutCompletePage s4=new SauceDemoCheckOutCompletePage(driver);
	   s4.getMessage();
	   
   }
   
   
   
  
}
