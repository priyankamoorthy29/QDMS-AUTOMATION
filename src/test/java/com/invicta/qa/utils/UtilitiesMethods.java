package com.invicta.qa.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;

public class UtilitiesMethods extends DriverIntialization{

	
	public static void ExcelSheetWrite(String location, int sheetnum, int rownum, int columnnum, String printstatus) {
		Workbook workbook = null;
		FileOutputStream fileOut = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			workbook = WorkbookFactory.create(fileIn);
			fileIn.close();

			Sheet sheet = workbook.getSheetAt(sheetnum - 1);

			Row row = sheet.getRow(rownum - 1);
			if (row == null) {
				row = sheet.createRow(rownum - 1);
			}

			Cell cell = row.getCell(columnnum - 1);
			if (cell == null) {
				cell = row.createCell(columnnum - 1);
			}

			cell.setCellValue(printstatus);



			fileOut = new FileOutputStream(location);
			workbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOut != null)
					fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String ExcelSheetValue(String location, int sheetnum, int rownum, int columnnum) {
		String values = null;
		
		Workbook workbook = null;
		FileOutputStream fileOut = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			workbook = WorkbookFactory.create(fileIn);
			fileIn.close();

			Sheet sheet = workbook.getSheetAt(sheetnum - 1);

			Row row = sheet.getRow(rownum - 1);
			if (row == null) {
				row = sheet.createRow(rownum - 1);
			}

			Cell cell = row.getCell(columnnum - 1);
			if (cell == null) {
				cell = row.createCell(columnnum - 1);
			}

			values = cell.getStringCellValue();



			fileOut = new FileOutputStream(location);
			workbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOut != null)
					fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return values; 
	}

	public static void ExcelSheetColor(String location, int sheetnum, int rownum, int columnnum, String cellcolor) {
		Workbook workbook = null;
		FileOutputStream fileOut = null;
		try {
			FileInputStream fileIn = new FileInputStream(location);
			workbook = WorkbookFactory.create(fileIn);
			fileIn.close();

			Sheet sheet = workbook.getSheetAt(sheetnum - 1);

			Row row = sheet.getRow(rownum - 1);
			if (row == null) {
				row = sheet.createRow(rownum - 1);
			}

			Cell cell = row.getCell(columnnum - 1);
			if (cell == null) {
				cell = row.createCell(columnnum - 1);
			}

			if (cellcolor == "red") {
				//
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 0, 0)));
				style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				//
			} else if (cellcolor == "green") {
				//
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 255, 0)));
				style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				//
			}else if (cellcolor == "white") {
				//
				XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
				style.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 0, 0)));
				style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				cell.setCellStyle(style);
				//
			}

			fileOut = new FileOutputStream(location);
			workbook.write(fileOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOut != null)
					fileOut.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}
	}
	
	static String xpath_getRowFirstPart = "//tbody/tr[";
	static String xpath_getRowLastPart = "]";

	static String xpath_getDeleteButtonFirstPart = "//tbody/tr[";
	static String xpath_getDeleteButtonLastPart = "]//a[@href='#']";
	static String xpath_clickNextPageButton = "//li[@title='Next Page']//button[@type='button']";

	

	static String xpath_DeleteOkButton = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']";
	
	public static boolean CheckSbuByName(String sbuName) throws InterruptedException {

		boolean clickNextPage = true;
		boolean sbuExist = false;

		while (clickNextPage) {

			for (int i = 2; i < 103; i++) {

				try {
					String text = driver.findElement(By.xpath(xpath_getRowFirstPart + i + xpath_getRowLastPart))
							.getText();

					System.out.println(text);

					if (text.equals(sbuName)) {
						sbuExist = true;
						Thread.sleep(2000);
						clickNextPage = false;
						break;

					}
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				try {
					clickNextPage = driver.findElement(By.xpath(xpath_clickNextPageButton)).isEnabled();
					driver.findElement(By.xpath(xpath_clickNextPageButton)).click();
					Thread.sleep(2000);
				} catch (Exception e) {
					break;
				}
			} else {
				break;
			}
		}
		return sbuExist;
	}
}
