

package com.invicta.qa.testcases.sbu;

import com.invicta.qa.base.DriverIntialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class DeleteTeach extends DriverIntialization {

//// =======================================================================================
	static String xpath_getRowFirstPart = "//tbody/tr[";
	static String xpath_getRowLastPart = "]";

	static String xpath_getDeleteButtonFirstPart = "//tbody/tr[";
	static String xpath_getDeleteButtonLastPart = "]//a[@href='#']";

	static String xpath_clickNextPageButton = "//li[@title='Next Page']//button[@type='button']";

	static String xpath_firstDeleteButton = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]/span/a[2]";
	static String xpath_firstDeleteFirstCancellButton = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[1]";
	static String xpath_firstDeleteButtonCancellButton = "/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[1]";
	static String xpath_DeleteCancellButton = "//button[@class='ant-btn ant-btn-sm']";

	static String xpath_DeleteOkButton = "//button[@class='ant-btn ant-btn-primary ant-btn-sm']";

//// ======================================================================================

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

	public static void DeleteSbuByName(String sbuName) throws InterruptedException {
		boolean clickNextPage = true;
		while (clickNextPage) {

			for (int i = 2; i < 103; i++) {

				try {
					String text = driver.findElement(By.xpath(xpath_getRowFirstPart + i + xpath_getRowLastPart))
							.getText();

					System.out.println(text);

					if (text.equals(sbuName)) {
						driver.findElement(By.xpath(xpath_getDeleteButtonFirstPart + i + xpath_getDeleteButtonLastPart))
								.click();
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
	}

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

	@BeforeTest
	public static void beforeTest() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"usernameOrEmail\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tokyo@admin");
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[1]/form/div/div[3]/div/div/span/button"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div[1]/div/section/section/main/div/div/div/div[1]/a/div/div")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[1]/div/div[1]")).click();
		Thread.sleep(2000);
	}

//// 01. Test Click-able on delete button
////-----------------------------------------------------------------------------------------------
//	@Test(priority = 0)
	public static void DeleteSbuClickable() throws InterruptedException {
		try {
			driver.findElement(By.xpath(xpath_firstDeleteButton)).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath(xpath_firstDeleteButtonCancellButton)).click();
			TestCasePrint("Delete-SBU: Clickability", "element is clickable", "element is clickable");
		} catch (Exception e) {
			TestCasePrint("Delete-SBU: Clickability", "element is clickable", String.valueOf(e));
		}
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

////02. Test Cancel button of delete 
////-----------------------------------------------------------------------------------------------
//	@Test(priority = 1)
	public static void DeleteSbuCancelButtonClick() throws InterruptedException {
		try {
			driver.findElement(By.xpath(xpath_firstDeleteButton)).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath(xpath_DeleteCancellButton)).click();
			TestCasePrint("Delete-SBU: Cancell Button", "element is clickable", "element is clickable");
		} catch (Exception e) {
			TestCasePrint("Delete-SBU: Cancell Button", "element is clickable", String.valueOf(e));
		}
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

////03. Test Cancel button of delete outside
////-----------------------------------------------------------------------------------------------
//	@Test(priority = 2)
	public static void DeleteSbuCancelButtonOutside() throws InterruptedException {
		try {
			driver.findElement(By.xpath(xpath_firstDeleteButton)).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath(xpath_firstDeleteFirstCancellButton)).click();
			TestCasePrint("Delete-SBU: Cancell Outside the Button", "element is clickable", "element is clickable");
		} catch (Exception e) {
			TestCasePrint("Delete-SBU: Cancell Outside the Button", "element is clickable", String.valueOf(e));
		}
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

//// 04. Click on non linked element - OK button
//// -----------------------------------------------------------------------------------------------
//	@Test(priority = 3)
	public static void NonLinkedSbuDelete() throws InterruptedException {

		String delSbuName = "DF DF G";

		boolean sbubeforedelete = false;
		boolean sbuafterdelete = false;

		sbubeforedelete = CheckSbuByName(delSbuName);

		System.out.println(sbubeforedelete);
		driver.navigate().refresh();
		Thread.sleep(3000);

		DeleteSbuByName(delSbuName);

		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath(xpath_DeleteOkButton)).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		driver.navigate().refresh();
		Thread.sleep(3000);

		sbuafterdelete = CheckSbuByName(delSbuName);

		driver.navigate().refresh();
		Thread.sleep(3000);

		System.out.println("before delete:- " + sbubeforedelete);
		System.out.println("after delete:- " + sbuafterdelete);

		if (sbubeforedelete && !sbuafterdelete) {
			TestCasePrint("Delete-SBU: Delete Non Linked Element", "element is deleted successfully",
					"element is deleted successfully");
		} else {
			TestCasePrint("Delete-SBU: Delete Non Linked Element", "element is deleted successfully",
					"element is not deleted successfully");
		}
	}

//// 05. Click on linked element (Plant) - OK button
//// -------------------------------------------------------------------------------------------------
//	@Test(priority = 4)
	public static void LinkedSbuDelete() throws InterruptedException {

		String delSbuName = "INNOVATION";

		boolean sbubeforedelete = false;
		boolean sbuafterdelete = false;

		sbubeforedelete = CheckSbuByName(delSbuName);

		System.out.println(sbubeforedelete);
		driver.navigate().refresh();
		Thread.sleep(3000);

		DeleteSbuByName(delSbuName);

		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath(xpath_DeleteOkButton)).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		driver.navigate().refresh();
		Thread.sleep(3000);

		sbuafterdelete = CheckSbuByName(delSbuName);

		driver.navigate().refresh();
		Thread.sleep(3000);

		System.out.println("before delete:- " + sbubeforedelete);
		System.out.println("after delete:- " + sbuafterdelete);

		if (sbubeforedelete && sbuafterdelete) {
			TestCasePrint("Delete-SBU: Delete Linked Element (Plant)", "successfully - Linked element is not deleted",
					"successfully - Linked element is not deleted");
		} else {
			TestCasePrint("Delete-SBU: Delete Linked Element (Plant)", "successfully - Linked element is not deleted",
					"Error Happened");
		}

	}

////05. Click on linked element (Material) - OK button
////-------------------------------------------------------------------------------------------------
//	@Test(priority = 4)
	public static void LinkedSbuDelete02() throws InterruptedException {

		String delSbuName = "INNOVATION";

		boolean sbubeforedelete = false;
		boolean sbuafterdelete = false;

		sbubeforedelete = CheckSbuByName(delSbuName);

		System.out.println(sbubeforedelete);
		driver.navigate().refresh();
		Thread.sleep(3000);

		DeleteSbuByName(delSbuName);

		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath(xpath_DeleteOkButton)).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		driver.navigate().refresh();
		Thread.sleep(3000);

		sbuafterdelete = CheckSbuByName(delSbuName);

		driver.navigate().refresh();
		Thread.sleep(3000);

		System.out.println("before delete:- " + sbubeforedelete);
		System.out.println("after delete:- " + sbuafterdelete);

		if (sbubeforedelete && sbuafterdelete) {
			TestCasePrint("Delete-SBU: Delete Linked Element (Material)",
					"successfully - Linked element is not deleted", "successfully - Linked element is not deleted");
		} else {
			TestCasePrint("Delete-SBU: Delete Linked Element (Material)",
					"successfully - Linked element is not deleted", "Error Happened");
		}

	}
	
	@Test
	public static void test() throws InterruptedException {
		DeleteSbuByName("INNOVATION");
//		System.out.println(check);
	}

}

