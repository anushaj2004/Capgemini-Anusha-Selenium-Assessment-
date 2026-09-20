package Day12_assessment;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClassOrangeHrm;
import PomUtilities.OrangeHrmHomepage;
import PomUtilities.OrangeHrmMyInfoPage;
import PomUtilities.OrangeHrmRecruitment1Page;
import PomUtilities.OrangeHrmVacanciesPage;

public class OrangeHrmTestImplementation extends BaseClassOrangeHrm{

	

	@DataProvider
	public Object[][] MyInfoDetails() throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/orangeHrmVacancy.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet2");
		 int rowCount = sh.getLastRowNum();
		 Object[][] obj=new Object[rowCount][4];
		 DataFormatter df=new DataFormatter();
		 for(int row=1;row<=rowCount;row++)
		 {
			 for(int j=0;j<=3;j++)
			 {

				 obj[row-1][j]=df.formatCellValue(sh.getRow(row).getCell(j));		
			 }
		 }
		 return obj;
	}
	
	
	@Test
	public void recruitmentTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		OrangeHrmHomepage o1=new OrangeHrmHomepage(driver);
		o1.getRecuritment();
		Thread.sleep(2000);
		OrangeHrmRecruitment1Page o2=new OrangeHrmRecruitment1Page(driver);
		o2.getVacanciesClick();
		Thread.sleep(2000);
		o2.getAddButton();
		Thread.sleep(2000);
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/orangeHrmVacancy.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String vacancyName=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String vacancyDescription=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String HireManager=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		DataFormatter df=new DataFormatter();
		String NoOfPosition=df.formatCellValue( wb.getSheet("Sheet1").getRow(1).getCell(3));
		OrangeHrmVacanciesPage o3=new OrangeHrmVacanciesPage(driver);
		Thread.sleep(2000);
		o3.getVn(vacancyName);
		Thread.sleep(2000);
		o3.getJobTitleClick();
		Thread.sleep(2000);
		o3.getJobTitleSelect();
		Thread.sleep(2000);
		o3.getDescription(vacancyDescription);
		Thread.sleep(2000);
		o3.getHireMang(HireManager);
		Thread.sleep(2000);
		o3.getNoOfPos(NoOfPosition);
		Thread.sleep(2000);
		o3.getSave();
		Thread.sleep(5000);
		
	}
	
	@Test(dataProvider = "MyInfoDetails")
	public void testCase2(String fn,String mn,String ln,String empId) throws InterruptedException
	{
		OrangeHrmHomepage o1=new OrangeHrmHomepage(driver);
		o1.getMyInfo();
		Thread.sleep(2000);
		OrangeHrmMyInfoPage o2=new OrangeHrmMyInfoPage(driver);
		o2.getFn(fn);
		Thread.sleep(2000);
		o2.getMn(mn);
		Thread.sleep(2000);
		o2.getLn(ln);
		Thread.sleep(2000);
		o2.getEmpid(empId);
		Thread.sleep(2000);
		o2.getSave();
		Thread.sleep(3000);
		
		
	}
	
	@Test(dataProvider = "MyInfoDetails")
	
	public void VerifyTestCase2(String fn,String mn,String ln,String empid) throws InterruptedException
	{
		OrangeHrmHomepage o1=new OrangeHrmHomepage(driver);
		o1.getMyInfo();
		Thread.sleep(2000);
		OrangeHrmMyInfoPage o2=new OrangeHrmMyInfoPage(driver);
		String updatedFn=o2.getFn(fn);
        Assert.assertEquals(updatedFn, fn);
        
		
	}
	
}
