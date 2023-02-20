package com.invicta.qa.testcases.sbu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.login.LoginPage;
import com.invicta.qa.pages.sbu.EditSbuFunPage;

public class ArunanEditSBU extends DriverIntialization {
	LoginPage lp = new LoginPage();
	EditSbuFunPage esfp = new EditSbuFunPage();

	@BeforeTest
	public void NavigateSbu() throws InterruptedException {
		PageFactory.initElements(driver, lp);
		PageFactory.initElements(driver, esfp);

		LoginPage.Username.sendKeys("admin");
		Thread.sleep(1000);
		LoginPage.Password.sendKeys("tokyo@admin");
		Thread.sleep(1000);
		LoginPage.LoginButton.click();

//		Thread.sleep(5000);
//		EditSbuFunPage.Master.click();
//		Thread.sleep(1000);
//		EditSbuFunPage.Plant.click();
//		Thread.sleep(1000);
//		EditSbuFunPage.SBU.click();
//		Thread.sleep(5000);

	}

	@Test
	public void EditSbu() throws InterruptedException, IOException {
		int ActualTotalPage = 1;
//		boolean Enablity = EditSbuFunPage.NextPageBtn.isEnabled();
//		while (Enablity) {
			Thread.sleep(1000);
//			EditSbuFunPage.NextPageBtn.click();
			ActualTotalPage = ActualTotalPage + 1;
//			Enablity = EditSbuFunPage.NextPageBtn.isEnabled();
//		}
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		int TotalRow = EditSbuFunPage.SbuNameColumn.size();
//		***********************************************************************************
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel-sheets\\SampleExcel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test");

		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);

			boolean check = (boolean) row.getCell(0).getBooleanCellValue();
			String OldSBU = (String) row.getCell(1).getStringCellValue();
			String NewSBU = (String) row.getCell(2).getStringCellValue();
			String Des = (String) row.getCell(3).getStringCellValue();
//			Check checkbox 

			if (check == true) {
				boolean CheckAddedValue = false;
				for (int k = 1; k <= ActualTotalPage; k++) {
//					for (int j = 2; j <= TotalRow; j++) {
//						String name = driver
//								.findElement(By.xpath(EditSbuFunPage.SbuNameBefore + j + EditSbuFunPage.SbuNameAfter))
//								.getText();

//						if (name.contentEquals(OldSBU)) {
//							driver.findElement(By.xpath(EditSbuFunPage.EditBtnBefore + j + EditSbuFunPage.EditBtnAfter))
//									.click();
							Thread.sleep(3000);

//							EditSbuFunPage.SBUName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//							EditSbuFunPage.SBUName.sendKeys(NewSBU);
//							EditSbuFunPage.Des.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//							EditSbuFunPage.Des.sendKeys(Des);
//							EditSbuFunPage.UpdateBtn.click();

//							if (EditSbuFunPage.CancelBtn.isEnabled()) {
//								EditSbuFunPage.CancelBtn.click();
//							}
						}
					}
//					for (int j = 2; j <= TotalRow; j++) {
//						String name = driver
//								.findElement(By.xpath(EditSbuFunPage.SbuNameBefore + j + EditSbuFunPage.SbuNameAfter))
//								.getText();
//
//						if (name.contentEquals(OldSBU)) { 
//							driver.findElement(By.xpath(EditSbuFunPage.EditBtnBefore + j + EditSbuFunPage.EditBtnAfter))
//									.click();
//							Thread.sleep(3000);
//
//							EditSbuFunPage.SBUName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//							EditSbuFunPage.SBUName.sendKeys(NewSBU);
//							EditSbuFunPage.Des.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//							EditSbuFunPage.Des.sendKeys(Des);
//							EditSbuFunPage.UpdateBtn.click();
//Thread.sleep(5000);
//							if (EditSbuFunPage.CancelBtn.isEnabled()) {
//								EditSbuFunPage.CancelBtn.click();
//							}
//							Thread.sleep(2000);
//							 driver.navigate().refresh();
//							 Thread.sleep(2000);
//						}
//					}

//					for (WebElement ele : EditSbuFunPage.SbuNameColumn) {
//						String value = ele.getText();
//						Thread.sleep(1000);
//						if (value.contentEquals(OldSBU)) {
//							CheckAddedValue = true;
//							break;
//						}
//					}
//					if (CheckAddedValue) {
//						break;
//					}
//					Thread.sleep(2000);
//					if (EditSbuFunPage.NextPageBtn.isEnabled() == true) {
//						EditSbuFunPage.NextPageBtn.click();
//					}
//				}
			}
//				if (CheckAddedValue) {
//					for (int j = 2; j <= TotalRow; j++) {
//						String name = driver
//								.findElement(By.xpath(EditSbuFunPage.SbuNameBefore + j + EditSbuFunPage.SbuNameAfter))
//								.getText();
//
//						if (name.contentEquals(OldSBU)) {
//							driver.findElement(By.xpath(EditSbuFunPage.EditBtnBefore + j + EditSbuFunPage.EditBtnAfter)).click();
//							Thread.sleep(3000);
//							
//							EditSbuFunPage.SBUName.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//							EditSbuFunPage.SBUName.sendKeys(NewSBU);
//							EditSbuFunPage.Des.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
//							EditSbuFunPage.Des.sendKeys(Des);
//							EditSbuFunPage.UpdateBtn.click();
//							
//							if(EditSbuFunPage.CancelBtn.isEnabled()) {
//								EditSbuFunPage.CancelBtn.click();
//							}
//						}
//					} 
//				}
			Thread.sleep(2000);
			System.out.println("Total Pages :- " + ActualTotalPage);
		}
	}

//}

