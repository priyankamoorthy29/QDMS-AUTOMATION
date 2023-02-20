package com.invicta.qa.testcases.dashboard;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.invicta.qa.base.DriverIntialization;



public class DashboardTest extends DriverIntialization {

	com.invicta.qa.pages.dashboard.DashboardPage Dashboardpage = new com.invicta.qa.pages.dashboard.DashboardPage();
	@Test
	
	public void Dashboard () throws InterruptedException,IOException
	{
		
		
		PageFactory.initElements(driver, Dashboardpage);
	
	Thread.sleep(2000);
	Dashboardpage.Master.click();
	
	Thread.sleep(2000);
	Dashboardpage.sub.click();
	
//	Thread.sleep(2000);
//	Dashboardpage.addsbu.click();
	
	

}
}
