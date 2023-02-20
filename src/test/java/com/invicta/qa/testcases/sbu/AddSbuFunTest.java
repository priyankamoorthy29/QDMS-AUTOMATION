package com.invicta.qa.testcases.sbu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuUIPage;

public class AddSbuFunTest extends DriverIntialization {

	AddSbuFunPage getdata = new AddSbuFunPage();


	@Test(priority = 0)
	public void getdata() throws InterruptedException {
//
		PageFactory.initElements(driver, getdata);

		int ActualTotalPage = 1;
		Thread.sleep(2000);
		boolean ActualEnablity = AddSbuFunPage.NextPageBtn.isEnabled();
		boolean ExpectedEnablity = true;

		boolean enable = true;
		testCase = extent.createTest("PAGINATION-NAVIGATION-ENABLED");
		try {
			AssertJUnit.assertEquals(ActualEnablity, ExpectedEnablity);

		} catch (AssertionError e) {
			enable = false;
		}
		if (enable) {
			testCase.log(Status.INFO, "Actual Data :- " + ActualEnablity);
			testCase.log(Status.INFO, "Expected Data :- " + ExpectedEnablity);
			testCase.log(Status.PASS, "next page navigation enable");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + ActualEnablity);
			testCase.log(Status.INFO, "Expected Data :- " + ExpectedEnablity);
			testCase.log(Status.FAIL, "next page navigation not enable");
		}
		// Thread.sleep(2000);
		// System.out.println("Enable "+ Enablity);

		while (ActualEnablity) {
			// Thread.sleep(1000);
			AddSbuFunPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
			ActualEnablity = AddSbuFunPage.NextPageBtn.isEnabled();
			// System.out.println(Enablity);
		}
		// System.out.println("!!!!!!!!!!!!!!!!!"+ActualTotalPage);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

		int TotalColumnActual = AddSbuFunPage.SbuNameColumn.size();
		System.out.println("Number of columns " + TotalColumnActual);

		int TotalColumnExpected = 3;

		boolean column = true;
		testCase = extent.createTest("TOTAL-COLUMN");
		try {
			AssertJUnit.assertEquals(TotalColumnActual, TotalColumnExpected);

		} catch (AssertionError e) {
			column = false;
		}
		if (column) {
			testCase.log(Status.INFO, "Actual Data :- " + TotalColumnActual);
			testCase.log(Status.INFO, "Expected Data :- " + TotalColumnExpected);
			testCase.log(Status.PASS, "correct column number");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + TotalColumnActual);
			testCase.log(Status.INFO, "Expected Data :- " + TotalColumnExpected);
			testCase.log(Status.FAIL, "Wrong column number");
		}

		int TotalRowActual = AddSbuFunPage.SbuNameRow.size();
		System.out.println("Number of rows " + TotalRowActual);

		int TotalRowExpected = 11;

		boolean row = true;
		testCase = extent.createTest("TOTAL-ROW");
		try {
			AssertJUnit.assertEquals(TotalRowActual, TotalRowExpected);

		} catch (AssertionError e) {
			row = false;
		}
		if (row) {
			testCase.log(Status.INFO, "Actual Data :- " + TotalRowActual);
			testCase.log(Status.INFO, "Expected Data :- " + TotalRowExpected);
			testCase.log(Status.PASS, "correct row number");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + TotalRowActual);
			testCase.log(Status.INFO, "Expected Data :- " + TotalRowExpected);
			testCase.log(Status.FAIL, "Wrong row number");
		}

		String Actualvalue = null;
		boolean CheckAddedValue = false;
		for (int i = 1; i <= ActualTotalPage; i++) {
			for (WebElement ele : AddSbuFunPage.SbuNameRow) {
				Actualvalue = ele.getText();
				Thread.sleep(1000);
				// System.out.println(value);

				if (Actualvalue.contentEquals("RMC")) {
					CheckAddedValue = true;
					System.out.println("Searched Value is- " + Actualvalue);
					break;
				}
			}

			if (AddSbuFunPage.NextPageBtn.isEnabled() == true) {
				AddSbuFunPage.NextPageBtn.click();
				Thread.sleep(2000);

			}
		}
		String expectedValue = "RMC";

		boolean firstdata = true;
		testCase = extent.createTest("DATA-AVAILABLE");
		try {
			AssertJUnit.assertEquals(Actualvalue, expectedValue);

		} catch (AssertionError e) {
			firstdata = false;
		}
		if (firstdata) {
			testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectedValue);
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + Actualvalue);
			testCase.log(Status.INFO, "Expected Data :- " + expectedValue);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}

	@Test(priority = 1)
	public void firstdata() throws InterruptedException, IOException {

		PageFactory.initElements(driver, getdata);

		// enter the values to the add SBU

		Thread.sleep(2000);

		//AddSbuFunPage.AddSBU.click();
		Thread.sleep(2000);

//	        AddSbuFunPage.SBUtext.sendKeys("NewSBU");
//	        AddSbuFunPage.SBUdestext.sendKeys("New Description");

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\invicta\\qa\\excel\\Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sbu");

		String sbu = null;
		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			 sbu = (String) row.getCell(0).getStringCellValue();
			String description = (String) row.getCell(1).getStringCellValue();

			AddSbuFunPage.AddSBU.click();
			AddSbuFunPage.SBUtext.sendKeys(sbu);
			AddSbuFunPage.SBUdestext.sendKeys(description);

			//Thread.sleep(2000);
			
			AddSbuFunPage.SBUsavebutton.click();
			Thread.sleep(2000);

			//AddSbuFunPage.AddSBU.click();
			
		}
		
		
		// first row of table

		AddSbuFunPage.firstpage.click();

		Thread.sleep(2000);
		WebElement tableRow = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]"));
		String actualdata = tableRow.getText();
		System.out.println("First row of table : " + actualdata);

		String expecteddata = sbu;

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
			testCase.log(Status.PASS, "Correct last added data");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
			testCase.log(Status.FAIL, "Wrong last added data");
		}

	}

	@Test(priority = 2)
	public void emptyvalidation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, getdata);
		
		AddSbuFunPage.AddSBU.click();
		
		Thread.sleep(2000);
		
		AddSbuFunPage.SBUsavebutton.click();
		
		Thread.sleep(2000);
		String actualmsg= AddSbuFunPage.emptyvalidationmsg.getAttribute("textContent");
//		String actualmsg= AddSbuFunPage.emptyvalidationmsg.getText();
		System.out.println("empty valiation msg : " + actualmsg);
		String expectedmsg="Sub Business Unit can't be empty";		

				// button enabled
		boolean firstdata = true;
		testCase = extent.createTest("VALIDATION MSG");
				
				try {
					Assert.assertEquals(actualmsg, expectedmsg);
					testCase.log(Status.INFO, "Actual message Displayed :- " + actualmsg);
					testCase.log(Status.INFO, "Expected message Displayed :- " + expectedmsg);
					testCase.log(Status.PASS, " message is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual message Displayed :- " + actualmsg);
					testCase.log(Status.INFO, "Expected message Displayed :- " + expectedmsg);
					testCase.log(Status.FAIL, " message is not diplayed");
				}
				
				
				
				
		
		
		

}

}