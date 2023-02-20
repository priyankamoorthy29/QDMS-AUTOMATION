package com.invicta.qa.testcases.sbu;

import java.io.IOException;

import org.testng.annotations.Test;

public class AddSBUProperTestCases extends AddSBUProper {
	
	@Test(priority = 0)
	public static void SBU0167() throws InterruptedException, IOException
	{
	
		AddSBUProper.addDataIntoSbu();
		AddSBUProper.checkLastAddvalue();

}
}