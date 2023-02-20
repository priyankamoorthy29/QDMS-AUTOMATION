package com.invicta.qa.testcases.sbu;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.utils.UtilitiesMethods;

public class TestCase_AddSBU extends DriverIntialization {

	public static AddSbuFunPage AddSubFunpg = new AddSbuFunPage();

//	@Test
	public static void TestCase01(String SBUname, String Description) throws InterruptedException {

		AddSbuUITest.beforeTest();

		AddSbuUITest.addsbubutton();
		AddSbuUITest.addsbutext();
		AddSbuUITest.sbutext();
		AddSbuUITest.description();
		AddSbuUITest.sbutextbox();
		AddSbuUITest.descriptiontextbox();

		driver.findElement(By.xpath("//*[@id=\"sub_business_unit\"]")).sendKeys(SBUname);
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys(Description);
		SBUsavebuttonUI.save();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]")).click();

		Thread.sleep(3000);

//		String element = driver.findElement(By.xpath(
//				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[1]"))
//				.getText();
//
//		if (element.equals(SBUname)) {
//			UtilitiesMethods.TestCasePrint("----FINAL SBU ADD TEST CASE----",
//					"element " + SBUname + " added successfully", "element " + SBUname + " added successfully");
//		} else {
//			UtilitiesMethods.TestCasePrint("----FINAL SBU ADD TEST CASE----",
//					"element " + SBUname + " added successfully", "element " + SBUname + " is not added successfully");
//		}

	}

	@Test
	void FinalTest() throws InterruptedException {
		TestCase01("Volta SBU", "Volta Description");
	}
	
	

}
