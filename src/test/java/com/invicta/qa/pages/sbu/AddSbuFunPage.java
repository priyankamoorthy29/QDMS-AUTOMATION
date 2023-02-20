package com.invicta.qa.pages.sbu;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddSbuFunPage {
////
////	@FindBy (xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]")
////	public static WebElement addsbutable;
//	
//	@FindBy (xpath = "//tbody[@class='ant-table-tbody']/tr/td[1]")
//	public static List <WebElement> addsbutable;

	@FindBy(xpath = "//a[@class='sc-bdVaJa ieeiNp'][@href='#/master/plantlevel']")
	public static WebElement Master;
	@FindBy(xpath = "//*[@href='#/master/plantlevel']")
	public static WebElement Plant;

	@FindBy(xpath = "//div[@class='sc-dnqmqq bxMwVY']")
	public static WebElement SBU;
	@FindBy(id = "sub_business_unit")
	public static WebElement SBUName;
	@FindBy(id = "description")
	public static WebElement Des;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/div/button[2]")
	public static WebElement UpdateBtn;
	@FindBy(xpath = "//div[@class='ant-modal-footer']/div/button[1]")
	public static WebElement CancelBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td")
	public static List<WebElement> SbuNameColumn;

	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr")
	public static List<WebElement> SbuNameRow;

	@FindBy(xpath = "//li[@title='Next Page']/button")
	public static WebElement NextPageBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/ul/li[3]")
	public static WebElement firstpage;

	@FindBy(xpath = "//*[@id=\"sub_business_unit\"]")
	public static WebElement SBUtext;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button")
    public static WebElement AddSBU;
    
	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement SBUdestext;

	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[3]/div/button[2]")
	public static WebElement SBUsavebutton;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/div[1]")
	public static WebElement emptyvalidationmsg;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]")
	public static WebElement tableRow;
	
	

	public static String SbuNameBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String SbuNameAfter = "]/td[1]";

	public static String EditBtnBefore = "//tbody[@class='ant-table-tbody']/tr[";
	public static String EditBtnAfter = "]/td[3]/span/a[1]";
}
