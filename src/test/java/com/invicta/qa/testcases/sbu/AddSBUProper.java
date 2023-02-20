package com.invicta.qa.testcases.sbu;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuUIPage;

public class AddSBUProper extends DriverIntialization {

	static AddSbuFunPage addfunctionpg = new AddSbuFunPage();
	static AddSbuUIPage addfun = new AddSbuUIPage();
	static String sbu = null;
	
	
	public static void addDataIntoSbu() throws InterruptedException, IOException {

		
		PageFactory.initElements(driver, addfunctionpg);
		PageFactory.initElements(driver, addfun);
		
//		AddSbuUIPage.SBUbutton.click();
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\invicta\\qa\\excel\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sbu");

		
		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			sbu = (String) row.getCell(0).getStringCellValue();
			String description = (String) row.getCell(1).getStringCellValue();

			AddSbuFunPage.AddSBU.click();
			Thread.sleep(2000);
			AddSbuFunPage.SBUtext.sendKeys(sbu);
			AddSbuFunPage.SBUdestext.sendKeys(description);

			Thread.sleep(3000);

			AddSbuFunPage.SBUsavebutton.click();
			Thread.sleep(2000);

		}
	}
	
	
	public static  void checkLastAddvalue() throws InterruptedException, IOException {

		PageFactory.initElements(driver, addfunctionpg);
		
		//WebElement tableRow = driver.findElement(By.xpath("//*[@id=\\\"root\\\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]"));
		String actualdata = AddSbuFunPage.tableRow.getText();
		System.out.println("First row of table : " + actualdata);

		
		String expecteddata =sbu;

		boolean firstdata = true;
		testCase = extent.createTest("LAST-ADDED-DATA");
		try {
			AssertJUnit.assertEquals(actualdata, expecteddata);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//			testCase.log(Status.INFO, "").assignCategory("High Severity");
//			testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
//			testCase.log(Status.INFO, "").assignCategory("High Severity");
//			testCase.log(Status.INFO, "").assignCategory("High Priority");
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}	
}