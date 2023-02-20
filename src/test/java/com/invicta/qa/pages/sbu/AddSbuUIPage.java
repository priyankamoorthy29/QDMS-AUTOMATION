package com.invicta.qa.pages.sbu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddSbuUIPage {

	@FindBy(xpath = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[1]/div/div[2]/button")
	public static WebElement SBUbutton;
	
	@FindBy(xpath = "//div[@class='sc-VigVT jzVhIp']/p")
	public static WebElement AddSBUtext;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[1]/div/label")
	public static WebElement SBUText;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div/div[2]/div/label")
	public static WebElement DescriptionText;
	
	@FindBy(xpath = "//*[@id=\"sub_business_unit\"]")
	public static WebElement SBUtextbox;
	
	@FindBy(xpath = "//*[@id=\"description\"]")
	public static WebElement Descriptiontextbox;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]")
	public static WebElement addSbuModal;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/div[1]")
	public static WebElement addSbuModalHeader;
}

