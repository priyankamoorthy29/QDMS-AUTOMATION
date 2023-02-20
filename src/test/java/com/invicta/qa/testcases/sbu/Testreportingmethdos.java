package com.invicta.qa.testcases.sbu;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuUIPage;

public class Testreportingmethdos extends DriverIntialization {

	static AddSbuFunPage addfunctionpg = new AddSbuFunPage();
	static AddSbuUIPage addfun = new AddSbuUIPage();

	// TESTCASE REPOERTS FOR POINT

	public static void TestCasePrintPoint(String TestCaseName, Point expectedLocation, Point actualLocation) {

		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualLocation, expectedLocation);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualLocation);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedLocation);
			testCase.log(Status.PASS, "Correct value");

		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualLocation);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedLocation);
			testCase.log(Status.FAIL, "wrong value");

		}
	}

	// TESTCASE REPOERTS FOR DIMENSION

	public static void TestCasePrintDimension(String TestCaseName, Dimension expectedLocation,
			Dimension actualLocation) {

		boolean size = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualLocation, expectedLocation);
		} catch (AssertionError e) {
			size = false;
		}
		if (size) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualLocation);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedLocation);
			testCase.log(Status.PASS, "Correct value");

		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualLocation);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedLocation);
			testCase.log(Status.FAIL, "wrong value");

		}
	}

//TESTCASE REPOERTS FOR STRING 

	public static void TestCasePrintStirng(String TestCaseName, String expectedLocation, String actualLocation) {

		boolean property = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualLocation, expectedLocation);
		} catch (AssertionError e) {
			property = false;
		}
		if (property) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualLocation);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedLocation);
			testCase.log(Status.PASS, "Correct value");

		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualLocation);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedLocation);
			testCase.log(Status.FAIL, "wrong value");

		}
	}
	
	//SUB BUTTON POSITION

	@Test(priority = 0)
	public static void position() {

		PageFactory.initElements(driver, addfunctionpg);
		PageFactory.initElements(driver, addfun);

		Point ActualLocation = AddSbuUIPage.SBUbutton.getLocation();

		int actual_x = ActualLocation.getX();
		int actual_y = ActualLocation.getY();

		System.out.println("X axis: " + actual_x);
		System.out.println("Y axis: " + actual_y);
		Point ExpectedLocation = new Point(588, 93);

		TestCasePrintPoint("SBU-BUTTON-POSITION", ExpectedLocation, ActualLocation);
	}
	
	//SBU BUTTON SIZE

	@Test(priority = 1)
	public static void size() {

		PageFactory.initElements(driver, addfunctionpg);
		PageFactory.initElements(driver, addfun);

		Dimension ActualSize = AddSbuUIPage.SBUbutton.getSize();
		System.out.println("Size :" + ActualSize);
		Dimension ExpectedSize = new Dimension(180, 32);

		TestCasePrintDimension("SBU-BUTTON-SIZE", ExpectedSize, ActualSize);
	}
	
	//SBU BUTTON COLOUR

	@Test(priority = 2)

	public static void colour() {
		PageFactory.initElements(driver, addfunctionpg);
		PageFactory.initElements(driver, addfun);

		String ActualColour = AddSbuUIPage.SBUbutton.getCssValue("background-color");
		System.out.println("rgb :" + ActualColour);

		// String hexcolour = Color.fromString(ActualColour).asHex();
		String ExpectedColour = "rgba(0, 19, 40, 1)";

		TestCasePrintStirng("SBU-BUTTON-COLOUR", ExpectedColour, ActualColour);
	}
}
