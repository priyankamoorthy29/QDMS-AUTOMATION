package com.invicta.qa.testcases.sbu;

import java.io.IOException;

import org.testng.annotations.Test;

import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuUIPage;

public class AddSbuinitialTestCases extends AddSbuInitialTest {
	
	static AddSbuFunPage addfunctionpg = new AddSbuFunPage();
	static AddSbuUIPage addfun = new AddSbuUIPage();

	@Test
	public static void testcase() throws InterruptedException, IOException
	
	{
		// STEP-1 "ADD SBU BUTTON" PROPERTIES
		AddSbuInitialTest.addSbuButtonproperties();
		
		// STEP-2 CLICK ON "ADD SBU" BUTTON
		AddSbuUIPage.SBUbutton.click();
		
		// STEP-3 CHECK THE "ADD SBU" MODAL
		AddSbuInitialTest.addSbuModalproperties();
		
		// STEP-4 DATA FROM EXCEL
		AddSbuInitialTest.getdatefromExcel();
		
		// STEP-5 "SAVE BUTTON" PROPERTIES
		AddSbuInitialTest.saveButtonProperties();
		
		// STEP-6 CLICK ON "SAVE BUTTON"
		AddSbuFunPage.SBUsavebutton.click();
		
		//STEP-7 CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE
		AddSbuInitialTest.checkLastAddvalue();
		
		
		
	}
	
}

