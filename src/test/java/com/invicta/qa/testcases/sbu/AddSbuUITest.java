package com.invicta.qa.testcases.sbu;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.DriverIntialization;
import com.invicta.qa.pages.sbu.AddSbuFunPage;
import com.invicta.qa.pages.sbu.AddSbuUIPage;



public class AddSbuUITest extends DriverIntialization {

	AddSbuUIPage sbuui = new AddSbuUIPage();

	@Test(priority = 0)
	public void addsbubutton() throws InterruptedException {

		PageFactory.initElements(driver, sbuui);
		
		try {
			if (AddSbuUIPage.SBUbutton.isEnabled()) {

				// button enabled

				boolean ActualImageDisplay = AddSbuUIPage.SBUbutton.isDisplayed();
				boolean ExpectedImageDisplay = true;
				testCase = extent.createTest("ADD-SBU-BUTTON-ENABLED");
				try {
					Assert.assertEquals(ActualImageDisplay, ExpectedImageDisplay);
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
					testCase.log(Status.PASS, " Image Displayed is Correct");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
					testCase.log(Status.FAIL, " Image Displayed is Wrong");
				}

				// CHEKC THE CLICKABILITY

				boolean clickable = AddSbuUIPage.SBUbutton.isDisplayed();

				String originalURL = driver.getCurrentUrl();
				String originalPageSource = driver.getPageSource();

				AddSbuUIPage.SBUbutton.click();
				System.out.println("Element is clicked");

				String updatedURL = driver.getCurrentUrl();
				String updatedPageSource = driver.getPageSource();

				if (!originalURL.equals(updatedURL) || !originalPageSource.equals(updatedPageSource)) {

					System.out.println("Changes have happened on the page");

					clickable = true;
				}

				else {

					System.out.println("No changes have happened on the page");
				}

				boolean clickable1 = true;

				testCase = extent.createTest("BUTTON-CLICKABLE");
				try {
					AssertJUnit.assertEquals(String.valueOf(clickable), "true");
					// System.out.println(String.valueOf(clickable));

				} catch (AssertionError e) {
					clickable1 = false;
				}
				if (clickable1) {
					testCase.log(Status.INFO, "ActualClick :- " + String.valueOf(clickable));
					testCase.log(Status.INFO, "ExpectedClick :- " + "true");

					testCase.log(Status.PASS, "Clickable");
				} else {
					testCase.log(Status.INFO, "ActualClick  :- " + String.valueOf(clickable));
					testCase.log(Status.INFO, "ExpectedClick :- " + "true");

					testCase.log(Status.FAIL, "Not clickable");
				}

			} else {
				testCase = extent.createTest("ADD-SBU-BUTTON-NOT-ENABLED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("lOGIN-BUTTON Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();
	}

	@Test(priority = 1)
	public void addsbutext() throws InterruptedException {

		PageFactory.initElements(driver, sbuui);
//System.out.println(AddSbuUIPage.AddSBUtext.isDisplayed());

		try {
			if (AddSbuUIPage.AddSBUtext.isDisplayed()) {

//							Text Displayed

				boolean ActualTextDisplay = AddSbuUIPage.AddSBUtext.isDisplayed();
				boolean ExpectedTestDisplay = true;
				testCase = extent.createTest("ADD-SBU-TEXT-DISPLAYED");
				try {
					Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
					testCase.log(Status.INFO, "Actual text Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected text Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.PASS, " text is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.FAIL, " text is not displayed ");
				}

				// text font color

				String Actualtextcolor = AddSbuUIPage.AddSBUtext.getCssValue("font-color");

				String Expectedtextcolor = "";
				System.out.println("font colour :" + Actualtextcolor);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-COLOUR");
				try {
					Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
					testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.PASS, "Correct font colour");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.FAIL, "wrong font colour");
				}

				// text font size

				String Actualtextsize = AddSbuUIPage.AddSBUtext.getCssValue("font-size");

				String Expectedtextsize = "16px";
				System.out.println("font size :" + Actualtextsize);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-SIZE");
				try {
					Assert.assertEquals(Actualtextsize, Expectedtextsize);
					testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.PASS, "Correct font size");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.FAIL, "wrong font size");
				}

				// text font style

				String Actualtextstyle = AddSbuUIPage.AddSBUtext.getCssValue("font-style");

				String Expectedtextstyle = "normal";
				System.out.println("font style :" + Actualtextstyle);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-STYLE");
				try {
					Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
					testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.PASS, "Correct font style");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.FAIL, "wrong font style");
				}

				// text spelling

				String Actualtext = AddSbuUIPage.AddSBUtext.getText();

				String Expectedtext = "Add SBU";
				System.out.println("text :" + Actualtext);
				testCase = extent.createTest("ADD-SBU-TEXT");
				try {
					Assert.assertEquals(Actualtext, Expectedtext);
					testCase.log(Status.INFO, "Actual text:- " + Actualtext);
					testCase.log(Status.INFO, "Expected text :- " + Expectedtext);
					testCase.log(Status.PASS, "Correct text");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font text :- " + Actualtext);
					testCase.log(Status.INFO, "Expected font text :- " + Expectedtext);
					testCase.log(Status.FAIL, "wrong font text");
				}

				// text font family

				String Actualfontfamily = AddSbuUIPage.AddSBUtext.getCssValue("font-family");

				String Expectedfontfamily = "Roboto, sans-serif";
				System.out.println("text :" + Actualfontfamily);
				testCase = extent.createTest("ADD-SBU-TEXT-FONT-FAMILY");
				try {
					Assert.assertEquals(Actualfontfamily, Expectedfontfamily);
					testCase.log(Status.INFO, "Actual fontfamily:- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.PASS, "Correct fontfamily");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font fontfamily :- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected font fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.FAIL, "wrong font fontfamily");
				}

				// text position

				Point ActulaTitleLocation = AddSbuUIPage.AddSBUtext.getLocation();
				int actual_x = ActulaTitleLocation.getX();
				int actual_y = ActulaTitleLocation.getY();

				System.out.println("X axis: " + actual_x);
				System.out.println("Y axis: " + actual_y);

				Point ExpectedTitleLocation = new Point(397, 106);

				testCase = extent.createTest("ADD-SBU-TEXT-POSITION");
				try {
					Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);
					testCase.log(Status.INFO, "Actual TitleLocation:- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.PASS, "Correct TitleLocation");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual  TitleLocation :- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.FAIL, "wrong TitleLocation");
				}

				// padding

				String Actualpadding = AddSbuUIPage.AddSBUtext.getCssValue("padding");

				String Expectedpadding = "0px";
				System.out.println("padding :" + Actualpadding);
				testCase = extent.createTest("ADD-SBU-TEXT-PADDING");
				try {
					Assert.assertEquals(Actualpadding, Expectedpadding);
					testCase.log(Status.INFO, "Actual padding:- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedpadding);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text margin

				String Actualmargin = AddSbuUIPage.AddSBUtext.getCssValue("margin");

				String Expectedmargin = "0px 0px 16px";
				System.out.println("margin :" + Actualmargin);
				testCase = extent.createTest("ADD-SBU-TEXT-MARGIN");
				try {
					Assert.assertEquals(Actualmargin, Expectedmargin);
					testCase.log(Status.INFO, "Actual padding:- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedmargin);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedmargin);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text box shadow

				String Actualshadow = AddSbuUIPage.AddSBUtext.getCssValue("box-shadow");

				String Expectedshadow = "none";
				System.out.println("shadow :" + Actualshadow);
				testCase = extent.createTest("ADD-SUB-TEXT-SHADOW");
				try {
					Assert.assertEquals(Actualshadow, Expectedshadow);
					testCase.log(Status.INFO, "Actual shadow:- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow :- " + Expectedshadow);
					testCase.log(Status.PASS, "Correct shadow");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual shadow :- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow:- " + Expectedshadow);
					testCase.log(Status.FAIL, "wrong shadow");
				}

				// LETTER SPACING

				String ActualLetterSpacing = AddSbuUIPage.AddSBUtext.getCssValue("letter-spacing");
				System.out.println("Letter Spacing :" + ActualLetterSpacing);

				String ExpectedLetterSpacing = "normal";

				boolean letterspacing = true;
				testCase = extent.createTest("ADD-SBU-TEXT-LETTER-SPACING");
				try {
					AssertJUnit.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

				} catch (AssertionError e) {
					letterspacing = false;
				}
				if (letterspacing) {
					testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
					testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
					testCase.log(Status.PASS, "Letter spacing is as expected");
				} else {
					testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
					testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
					testCase.log(Status.FAIL, "Letter spacing is not as expected");
				}

				// WORD SPACING

				String ActualWordSpacing = AddSbuUIPage.AddSBUtext.getCssValue("word-spacing");
				System.out.println("Word Spacing :" + ActualWordSpacing);

				String ExpectedWordSpacing = "0px";

				boolean wordspacing = true;
				testCase = extent.createTest("ADD-SBU-TEXT-WORD-SPACING");
				try {
					AssertJUnit.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

				} catch (AssertionError e) {
					wordspacing = false;
				}
				if (wordspacing) {
					testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
					testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
					testCase.log(Status.PASS, "Word spacing is as expected");
				} else {
					testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
					testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
					testCase.log(Status.FAIL, "Word spacing is not as expected");
				}

				// ALIGNMENT (CENTER/LEFT/RIGHT)

				String ActualAlignment = AddSbuUIPage.AddSBUtext.getCssValue("text-align");
				System.out.println("Text Alignment :" + ActualAlignment);

				String ExpectedAlignment = "start";

				boolean alignment = true;
				testCase = extent.createTest("ADD-SBU-TEXT-ALIGNMENT");
				try {
					AssertJUnit.assertEquals(ActualAlignment, ExpectedAlignment);

				} catch (AssertionError e) {
					alignment = false;
				}
				if (alignment) {
					testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
					testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
					testCase.log(Status.PASS, "Alignment is as expected");
				} else {
					testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
					testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
					testCase.log(Status.FAIL, "Alignment is not as expected");
				}
				// TEXT TRANSFORMATION (UPERCASE/ LOWECASE)

				String ActualTextTransformation = AddSbuUIPage.AddSBUtext.getCssValue("text-transform");
				System.out.println("Text Transformation :" + ActualTextTransformation);

				String ExpectedTextTransformation = "none";

				boolean texttransformation = true;
				testCase = extent.createTest("ADD-SBU-TEXT-TRANSFORMATION");
				try {
					AssertJUnit.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

				} catch (AssertionError e) {
					texttransformation = false;
				}
				if (texttransformation) {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.PASS, "Transformation expected");
				} else {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.FAIL, "Transformation unexpected");
				}

				// LINE HEIGHT

				String ActualLineHeight = AddSbuUIPage.AddSBUtext.getCssValue("line-height");
				System.out.println("Line Height :" + ActualLineHeight);

				String ExpectedLineHeight = "22px";

				boolean lineheight = true;
				testCase = extent.createTest("ADD-SBU-TEXT-LINE-HEIGHT");
				try {
					AssertJUnit.assertEquals(ActualLineHeight, ExpectedLineHeight);

				} catch (AssertionError e) {
					lineheight = false;
				}
				if (lineheight) {
					testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
					testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
					testCase.log(Status.PASS, "Line height is as expected");
				} else {
					testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
					testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
					testCase.log(Status.FAIL, "Line height is not as expected");
				}

				// Text Decoration

				String ActualTextDecoration = AddSbuUIPage.AddSBUtext.getCssValue("text-decoration");
				System.out.println("Text Decoration :" + ActualTextDecoration);

				String ExpectedTextDecoration = "none solid rgb(255, 255, 255)";

				boolean textdecoration = true;
				testCase = extent.createTest("ADD-SBU-TEXT-DECORATION");
				try {
					AssertJUnit.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

				} catch (AssertionError e) {
					textdecoration = false;
				}
				if (textdecoration) {
					testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
					testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
					testCase.log(Status.PASS, "Text decoration is as expected");
				} else {
					testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
					testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
					testCase.log(Status.FAIL, "Text decoration is not as expected");
				}

				// VERTICAL ALIGN

				String actualVerticalAlignment = AddSbuUIPage.AddSBUtext.getCssValue("vertical-align");
				System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

				String expectedVerticalAlignment = "baseline";

				boolean verticalAlignment = true;
				testCase = extent.createTest("ADD-SBU-TEXT-VERTICAL-ALIGNMENT");
				try {
					Assert.assertEquals(actualVerticalAlignment, expectedVerticalAlignment);
				} catch (AssertionError e) {
					verticalAlignment = false;
				}

				if (verticalAlignment) {
					testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.PASS, "Text vertical Align is as expected");

				} else {
					testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text vertical Align is as expected");

				}

				// TEXT INDENT (To indent is to begin text with a blank space between it and the
				// margin)

				String ActualTextIndent = AddSbuUIPage.AddSBUtext.getCssValue("text-indent");
				System.out.println("Text Indent :" + ActualTextIndent);

				String ExpectedTextIndent = "0px";

				boolean textindent = true;
				testCase = extent.createTest("ADD-SBU-TEXT-INDENT");
				try {
					AssertJUnit.assertEquals(ActualTextIndent, ExpectedTextIndent);

				} catch (AssertionError e) {
					textindent = false;
				}
				if (textindent) {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
					testCase.log(Status.PASS, "Text Indent is as expected");

				} else {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text Indent is as expected");

				}
				// TEXT - ORIENTATION(text characters in a line. It only affects text in
				// vertical mode)

				String ActualTextOrientation = AddSbuUIPage.AddSBUtext.getCssValue("text-orientation");
				System.out.println("Text Orientation :" + ActualTextOrientation);

				String ExpectedTextOrientation = "mixed";

				boolean textorientation = true;
				testCase = extent.createTest("ADD-SBU-TEXT-ORIENTATION");
				try {
					AssertJUnit.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

				} catch (AssertionError e) {
					textorientation = false;
				}
				if (textorientation) {
					testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
					testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
					testCase.log(Status.PASS, "Text orientation is as expected");
				} else {
					testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
					testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
					testCase.log(Status.FAIL, "Text orientation is as unxpected");
				}

			} else {
				testCase = extent.createTest("TEXT NOT DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TEXT Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();

	}

	@Test(priority = 2)
	public void sbutext() throws InterruptedException {

		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuUIPage.SBUText.isDisplayed()) {

//							Text Displayed

				boolean ActualTextDisplay = AddSbuUIPage.SBUText.isDisplayed();
				boolean ExpectedTestDisplay = true;
				testCase = extent.createTest("SBU-TEXT-DISPLAYED");
				try {
					Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
					testCase.log(Status.INFO, "Actual text Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected text Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.PASS, " text is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.FAIL, " text is not displayed ");
				}

				// text font color

				String Actualtextcolor = AddSbuUIPage.SBUText.getCssValue("font-color");

				String Expectedtextcolor = "";
				System.out.println("font colour :" + Actualtextcolor);
				testCase = extent.createTest("SBU-TEXT-FONT-COLOUR");
				try {
					Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
					testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.PASS, "Correct font colour");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.FAIL, "wrong font colour");
				}

				// text font size

				String Actualtextsize = AddSbuUIPage.SBUText.getCssValue("font-size");

				String Expectedtextsize = "14px";
				System.out.println("font size :" + Actualtextsize);
				testCase = extent.createTest("SBU-TEXT-FONT-SIZE");
				try {
					Assert.assertEquals(Actualtextsize, Expectedtextsize);
					testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.PASS, "Correct font size");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.FAIL, "wrong font size");
				}

				// text font style

				String Actualtextstyle = AddSbuUIPage.SBUText.getCssValue("font-style");

				String Expectedtextstyle = "normal";
				System.out.println("font style :" + Actualtextstyle);
				testCase = extent.createTest("SBU-TEXT-FONT-STYLE");
				try {
					Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
					testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.PASS, "Correct font style");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.FAIL, "wrong font style");
				}

				// text spelling

				String Actualtext = AddSbuUIPage.SBUText.getText();

				String Expectedtext = "Sub Business Unit:";
				System.out.println("text :" + Actualtext);
				testCase = extent.createTest("SBU-TEXT");
				try {
					Assert.assertEquals(Actualtext, Expectedtext);
					testCase.log(Status.INFO, "Actual text:- " + Actualtext);
					testCase.log(Status.INFO, "Expected text :- " + Expectedtext);
					testCase.log(Status.PASS, "Correct text");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font text :- " + Actualtext);
					testCase.log(Status.INFO, "Expected font text :- " + Expectedtext);
					testCase.log(Status.FAIL, "wrong font text");
				}

				// text font family

				String Actualfontfamily = AddSbuUIPage.SBUText.getCssValue("font-family");

				String Expectedfontfamily = "Roboto";
				System.out.println("text :" + Actualfontfamily);
				testCase = extent.createTest("SBU-TEXT-FONT-FAMILY");
				try {
					Assert.assertEquals(Actualfontfamily, Expectedfontfamily);
					testCase.log(Status.INFO, "Actual fontfamily:- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.PASS, "Correct fontfamily");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font fontfamily :- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected font fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.FAIL, "wrong font fontfamily");
				}

				// text position

				Point ActulaTitleLocation = AddSbuUIPage.SBUText.getLocation();
				int actual_x = ActulaTitleLocation.getX();
				int actual_y = ActulaTitleLocation.getY();

				System.out.println("X axis: " + actual_x);
				System.out.println("Y axis: " + actual_y);

				Point ExpectedTitleLocation = new Point(417, 167);

				testCase = extent.createTest("SBU-TEXT-POSITION");
				try {
					Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);
					testCase.log(Status.INFO, "Actual TitleLocation:- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.PASS, "Correct TitleLocation");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual  TitleLocation :- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.FAIL, "wrong TitleLocation");
				}

				// padding

				String Actualpadding = AddSbuUIPage.SBUText.getCssValue("padding");

				String Expectedpadding = "0px";
				System.out.println("padding :" + Actualpadding);
				testCase = extent.createTest("SBU-TEXT-PADDING");
				try {
					Assert.assertEquals(Actualpadding, Expectedpadding);
					testCase.log(Status.INFO, "Actual padding:- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedpadding);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text margin

				String Actualmargin = AddSbuUIPage.SBUText.getCssValue("margin");

				String Expectedmargin = "0px";
				System.out.println("margin :" + Actualmargin);
				testCase = extent.createTest("SBU-TEXT-MARGIN");
				try {
					Assert.assertEquals(Actualmargin, Expectedmargin);
					testCase.log(Status.INFO, "Actual padding:- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedmargin);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedmargin);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text box shadow

				String Actualshadow = AddSbuUIPage.SBUText.getCssValue("box-shadow");

				String Expectedshadow = "none";
				System.out.println("shadow :" + Actualshadow);
				testCase = extent.createTest("SBU-TEXT-SHADOW");
				try {
					Assert.assertEquals(Actualshadow, Expectedshadow);
					testCase.log(Status.INFO, "Actual shadow:- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow :- " + Expectedshadow);
					testCase.log(Status.PASS, "Correct shadow");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual shadow :- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow:- " + Expectedshadow);
					testCase.log(Status.FAIL, "wrong shadow");
				}

				// LETTER SPACING

				String ActualLetterSpacing = AddSbuUIPage.SBUText.getCssValue("letter-spacing");
				System.out.println("Letter Spacing :" + ActualLetterSpacing);

				String ExpectedLetterSpacing = "normal";

				boolean letterspacing = true;
				testCase = extent.createTest("SBU-TEXT-LETTER-SPACING");
				try {
					AssertJUnit.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

				} catch (AssertionError e) {
					letterspacing = false;
				}
				if (letterspacing) {
					testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
					testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
					testCase.log(Status.PASS, "Letter spacing is as expected");
				} else {
					testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
					testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
					testCase.log(Status.FAIL, "Letter spacing is not as expected");
				}

				// WORD SPACING

				String ActualWordSpacing = AddSbuUIPage.SBUText.getCssValue("word-spacing");
				System.out.println("Word Spacing :" + ActualWordSpacing);

				String ExpectedWordSpacing = "0px";

				boolean wordspacing = true;
				testCase = extent.createTest("SBU-TEXT-WORD-SPACING");
				try {
					AssertJUnit.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

				} catch (AssertionError e) {
					wordspacing = false;
				}
				if (wordspacing) {
					testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
					testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
					testCase.log(Status.PASS, "Word spacing is as expected");
				} else {
					testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
					testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
					testCase.log(Status.FAIL, "Word spacing is not as expected");
				}

				// ALIGNMENT (CENTER/LEFT/RIGHT)

				String ActualAlignment = AddSbuUIPage.SBUText.getCssValue("text-align");
				System.out.println("Text Alignment :" + ActualAlignment);

				String ExpectedAlignment = "left";

				boolean alignment = true;
				testCase = extent.createTest("SBU-TEXT-ALIGNMENT");
				try {
					AssertJUnit.assertEquals(ActualAlignment, ExpectedAlignment);

				} catch (AssertionError e) {
					alignment = false;
				}
				if (alignment) {
					testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
					testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
					testCase.log(Status.PASS, "Alignment is as expected");
				} else {
					testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
					testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
					testCase.log(Status.FAIL, "Alignment is not as expected");
				}
				// TEXT TRANSFORMATION (UPERCASE/ LOWECASE)

				String ActualTextTransformation = AddSbuUIPage.SBUText.getCssValue("text-transform");
				System.out.println("Text Transformation :" + ActualTextTransformation);

				String ExpectedTextTransformation = "none";

				boolean texttransformation = true;
				testCase = extent.createTest("SBU-TEXT-TRANSFORMATION");
				try {
					AssertJUnit.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

				} catch (AssertionError e) {
					texttransformation = false;
				}
				if (texttransformation) {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.PASS, "Transformation expected");
				} else {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.FAIL, "Transformation unexpected");
				}

				// LINE HEIGHT

				String ActualLineHeight = AddSbuUIPage.SBUText.getCssValue("line-height");
				System.out.println("Line Height :" + ActualLineHeight);

				String ExpectedLineHeight = "22.001px";

				boolean lineheight = true;
				testCase = extent.createTest("SBU-TEXT-LINE-HEIGHT");
				try {
					AssertJUnit.assertEquals(ActualLineHeight, ExpectedLineHeight);

				} catch (AssertionError e) {
					lineheight = false;
				}
				if (lineheight) {
					testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
					testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
					testCase.log(Status.PASS, "Line height is as expected");
				} else {
					testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
					testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
					testCase.log(Status.FAIL, "Line height is not as expected");
				}

				// Text Decoration

				String ActualTextDecoration = AddSbuUIPage.SBUText.getCssValue("text-decoration");
				System.out.println("Text Decoration :" + ActualTextDecoration);

				String ExpectedTextDecoration = "none solid rgb(142, 142, 142)";

				boolean textdecoration = true;
				testCase = extent.createTest("SBU-TEXT-DECORATION");
				try {
					AssertJUnit.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

				} catch (AssertionError e) {
					textdecoration = false;
				}
				if (textdecoration) {
					testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
					testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
					testCase.log(Status.PASS, "Text decoration is as expected");
				} else {
					testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
					testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
					testCase.log(Status.FAIL, "Text decoration is not as expected");
				}

				// VERTICAL ALIGN

				String actualVerticalAlignment = AddSbuUIPage.SBUText.getCssValue("vertical-align");
				System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

				String expectedVerticalAlignment = "baseline";

				boolean verticalAlignment = true;
				testCase = extent.createTest("SBU-TEXT-VERTICAL-ALIGNMENT");
				try {
					Assert.assertEquals(actualVerticalAlignment, expectedVerticalAlignment);
				} catch (AssertionError e) {
					verticalAlignment = false;
				}

				if (verticalAlignment) {
					testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.PASS, "Text vertical Align is as expected");

				} else {
					testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text vertical Align is as expected");

				}

				// TEXT INDENT (To indent is to begin text with a blank space between it and the
				// margin)

				String ActualTextIndent = AddSbuUIPage.SBUText.getCssValue("text-indent");
				System.out.println("Text Indent :" + ActualTextIndent);

				String ExpectedTextIndent = "0px";

				boolean textindent = true;
				testCase = extent.createTest("SBU-TEXT-INDENT");
				try {
					AssertJUnit.assertEquals(ActualTextIndent, ExpectedTextIndent);

				} catch (AssertionError e) {
					textindent = false;
				}
				if (textindent) {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
					testCase.log(Status.PASS, "Text Indent is as expected");

				} else {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text Indent is as expected");

				}
				// TEXT - ORIENTATION(text characters in a line. It only affects text in
				// vertical mode)

				String ActualTextOrientation = AddSbuUIPage.SBUText.getCssValue("text-orientation");
				System.out.println("Text Orientation :" + ActualTextOrientation);

				String ExpectedTextOrientation = "mixed";

				boolean textorientation = true;
				testCase = extent.createTest("SUB-TEXT-ORIENTATION");
				try {
					AssertJUnit.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

				} catch (AssertionError e) {
					textorientation = false;
				}
				if (textorientation) {
					testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
					testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
					testCase.log(Status.PASS, "Text orientation is as expected");
				} else {
					testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
					testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
					testCase.log(Status.FAIL, "Text orientation is as unxpected");
				}

			} else {
				testCase = extent.createTest("SUB-TEXT-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TEXT Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();

	}

	@Test(priority = 3)
	public void description() throws InterruptedException {

		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuUIPage.DescriptionText.isDisplayed()) {

//							Text Displayed

				boolean ActualTextDisplay = AddSbuUIPage.DescriptionText.isDisplayed();
				boolean ExpectedTestDisplay = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-DISPLAYED");
				try {
					Assert.assertEquals(ActualTextDisplay, ExpectedTestDisplay);
					testCase.log(Status.INFO, "Actual text Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected text Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.PASS, " text is displayed");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualTextDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedTestDisplay);
					testCase.log(Status.FAIL, " text is not displayed ");
				}

				// text font color

				String Actualtextcolor = AddSbuUIPage.DescriptionText.getCssValue("font-color");

				String Expectedtextcolor = "";
				System.out.println("font colour :" + Actualtextcolor);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-COLOUR");
				try {
					Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
					testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.PASS, "Correct font colour");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
					testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
					testCase.log(Status.FAIL, "wrong font colour");
				}

				// text font size

				String Actualtextsize = AddSbuUIPage.DescriptionText.getCssValue("font-size");

				String Expectedtextsize = "14px";
				System.out.println("font size :" + Actualtextsize);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-SIZE");
				try {
					Assert.assertEquals(Actualtextsize, Expectedtextsize);
					testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.PASS, "Correct font size");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
					testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
					testCase.log(Status.FAIL, "wrong font size");
				}

				// text font style

				String Actualtextstyle = AddSbuUIPage.DescriptionText.getCssValue("font-style");

				String Expectedtextstyle = "normal";
				System.out.println("font style :" + Actualtextstyle);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-STYLE");
				try {
					Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
					testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.PASS, "Correct font style");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
					testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
					testCase.log(Status.FAIL, "wrong font style");
				}

				// text spelling

				String Actualtext = AddSbuUIPage.DescriptionText.getText();

				String Expectedtext = "Description:";
				System.out.println("text :" + Actualtext);
				testCase = extent.createTest("DESCRIPTION-TEXT");
				try {
					Assert.assertEquals(Actualtext, Expectedtext);
					testCase.log(Status.INFO, "Actual text:- " + Actualtext);
					testCase.log(Status.INFO, "Expected text :- " + Expectedtext);
					testCase.log(Status.PASS, "Correct text");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font text :- " + Actualtext);
					testCase.log(Status.INFO, "Expected font text :- " + Expectedtext);
					testCase.log(Status.FAIL, "wrong font text");
				}

				// text font family

				String Actualfontfamily = AddSbuUIPage.DescriptionText.getCssValue("font-family");

				String Expectedfontfamily = "Roboto";
				System.out.println("text :" + Actualfontfamily);
				testCase = extent.createTest("DESCRIPTION-TEXT-FONT-FAMILY");
				try {
					Assert.assertEquals(Actualfontfamily, Expectedfontfamily);
					testCase.log(Status.INFO, "Actual fontfamily:- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.PASS, "Correct fontfamily");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual font fontfamily :- " + Actualfontfamily);
					testCase.log(Status.INFO, "Expected font fontfamily :- " + Expectedfontfamily);
					testCase.log(Status.FAIL, "wrong font fontfamily");
				}

				// text position

				Point ActulaTitleLocation = AddSbuUIPage.DescriptionText.getLocation();
				int actual_x = ActulaTitleLocation.getX();
				int actual_y = ActulaTitleLocation.getY();

				System.out.println("X axis: " + actual_x);
				System.out.println("Y axis: " + actual_y);

				Point ExpectedTitleLocation = new Point(693, 167);

				testCase = extent.createTest("DESCRIPTION-TEXT-POSITION");
				try {
					Assert.assertEquals(ActulaTitleLocation, ExpectedTitleLocation);
					testCase.log(Status.INFO, "Actual TitleLocation:- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.PASS, "Correct TitleLocation");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual  TitleLocation :- " + ActulaTitleLocation);
					testCase.log(Status.INFO, "Expected TitleLocation :- " + ExpectedTitleLocation);
					testCase.log(Status.FAIL, "wrong TitleLocation");
				}

				// padding

				String Actualpadding = AddSbuUIPage.DescriptionText.getCssValue("padding");

				String Expectedpadding = "0px";
				System.out.println("padding :" + Actualpadding);
				testCase = extent.createTest("DESCRIPTION-TEXT-PADDING");
				try {
					Assert.assertEquals(Actualpadding, Expectedpadding);
					testCase.log(Status.INFO, "Actual padding:- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedpadding);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualpadding);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedpadding);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text margin

				String Actualmargin = AddSbuUIPage.DescriptionText.getCssValue("margin");

				String Expectedmargin = "0px";
				System.out.println("margin :" + Actualmargin);
				testCase = extent.createTest("DESCRIPTION-TEXT-MARGIN");
				try {
					Assert.assertEquals(Actualmargin, Expectedmargin);
					testCase.log(Status.INFO, "Actual padding:- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding :- " + Expectedmargin);
					testCase.log(Status.PASS, "Correct padding");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual padding :- " + Actualmargin);
					testCase.log(Status.INFO, "Expected padding:- " + Expectedmargin);
					testCase.log(Status.FAIL, "wrong padding");
				}

				// text box shadow

				String Actualshadow = AddSbuUIPage.DescriptionText.getCssValue("box-shadow");

				String Expectedshadow = "none";
				System.out.println("shadow :" + Actualshadow);
				testCase = extent.createTest("DESCRIPTION-TEXT-SHADOW");
				try {
					Assert.assertEquals(Actualshadow, Expectedshadow);
					testCase.log(Status.INFO, "Actual shadow:- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow :- " + Expectedshadow);
					testCase.log(Status.PASS, "Correct shadow");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual shadow :- " + Actualshadow);
					testCase.log(Status.INFO, "Expected shadow:- " + Expectedshadow);
					testCase.log(Status.FAIL, "wrong shadow");
				}

				// LETTER SPACING

				String ActualLetterSpacing = AddSbuUIPage.DescriptionText.getCssValue("letter-spacing");
				System.out.println("Letter Spacing :" + ActualLetterSpacing);

				String ExpectedLetterSpacing = "normal";

				boolean letterspacing = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-LETTER-SPACING");
				try {
					AssertJUnit.assertEquals(ActualLetterSpacing, ExpectedLetterSpacing);

				} catch (AssertionError e) {
					letterspacing = false;
				}
				if (letterspacing) {
					testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
					testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
					testCase.log(Status.PASS, "Letter spacing is as expected");
				} else {
					testCase.log(Status.INFO, "ActualLetterSpacing :- " + ActualLetterSpacing);
					testCase.log(Status.INFO, "ExpectedLetterSpacing :- " + ExpectedLetterSpacing);
					testCase.log(Status.FAIL, "Letter spacing is not as expected");
				}

				// WORD SPACING

				String ActualWordSpacing = AddSbuUIPage.DescriptionText.getCssValue("word-spacing");
				System.out.println("Word Spacing :" + ActualWordSpacing);

				String ExpectedWordSpacing = "0px";

				boolean wordspacing = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-WORD-SPACING");
				try {
					AssertJUnit.assertEquals(ActualWordSpacing, ExpectedWordSpacing);

				} catch (AssertionError e) {
					wordspacing = false;
				}
				if (wordspacing) {
					testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
					testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
					testCase.log(Status.PASS, "Word spacing is as expected");
				} else {
					testCase.log(Status.INFO, "ActualWordSpacing :- " + ActualWordSpacing);
					testCase.log(Status.INFO, "ExpectedWordSpacing :- " + ExpectedWordSpacing);
					testCase.log(Status.FAIL, "Word spacing is not as expected");
				}

				// ALIGNMENT (CENTER/LEFT/RIGHT)

				String ActualAlignment = AddSbuUIPage.DescriptionText.getCssValue("text-align");
				System.out.println("Text Alignment :" + ActualAlignment);

				String ExpectedAlignment = "left";

				boolean alignment = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-ALIGNMENT");
				try {
					AssertJUnit.assertEquals(ActualAlignment, ExpectedAlignment);

				} catch (AssertionError e) {
					alignment = false;
				}
				if (alignment) {
					testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
					testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
					testCase.log(Status.PASS, "Alignment is as expected");
				} else {
					testCase.log(Status.INFO, "ActualAlignment :- " + ActualAlignment);
					testCase.log(Status.INFO, "ExpectedAlignment :- " + ExpectedAlignment);
					testCase.log(Status.FAIL, "Alignment is not as expected");
				}
				// TEXT TRANSFORMATION (UPERCASE/ LOWECASE)

				String ActualTextTransformation = AddSbuUIPage.DescriptionText.getCssValue("text-transform");
				System.out.println("Text Transformation :" + ActualTextTransformation);

				String ExpectedTextTransformation = "none";

				boolean texttransformation = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-TRANSFORMATION");
				try {
					AssertJUnit.assertEquals(ActualTextTransformation, ExpectedTextTransformation);

				} catch (AssertionError e) {
					texttransformation = false;
				}
				if (texttransformation) {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.PASS, "Transformation expected");
				} else {
					testCase.log(Status.INFO, "ActualTextTransformation :- " + ActualTextTransformation);
					testCase.log(Status.INFO, "ExpectedTextTransformation :- " + ExpectedTextTransformation);
					testCase.log(Status.FAIL, "Transformation unexpected");
				}

				// LINE HEIGHT

				String ActualLineHeight = AddSbuUIPage.DescriptionText.getCssValue("line-height");
				System.out.println("Line Height :" + ActualLineHeight);

				String ExpectedLineHeight = "22.001px";

				boolean lineheight = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-LINE-HEIGHT");
				try {
					AssertJUnit.assertEquals(ActualLineHeight, ExpectedLineHeight);

				} catch (AssertionError e) {
					lineheight = false;
				}
				if (lineheight) {
					testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
					testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
					testCase.log(Status.PASS, "Line height is as expected");
				} else {
					testCase.log(Status.INFO, "ActualLineHeight :- " + ActualLineHeight);
					testCase.log(Status.INFO, "ExpectedLineHeight :- " + ExpectedLineHeight);
					testCase.log(Status.FAIL, "Line height is not as expected");
				}

				// Text Decoration

				String ActualTextDecoration = AddSbuUIPage.DescriptionText.getCssValue("text-decoration");
				System.out.println("Text Decoration :" + ActualTextDecoration);

				String ExpectedTextDecoration = "none solid rgb(142, 142, 142)";

				boolean textdecoration = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-DECORATION");
				try {
					AssertJUnit.assertEquals(ActualTextDecoration, ExpectedTextDecoration);

				} catch (AssertionError e) {
					textdecoration = false;
				}
				if (textdecoration) {
					testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
					testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
					testCase.log(Status.PASS, "Text decoration is as expected");
				} else {
					testCase.log(Status.INFO, "ActualTextDecoration :- " + ActualTextDecoration);
					testCase.log(Status.INFO, "ExpectedTextDecoration :- " + ExpectedTextDecoration);
					testCase.log(Status.FAIL, "Text decoration is not as expected");
				}

				// VERTICAL ALIGN

				String actualVerticalAlignment = AddSbuUIPage.DescriptionText.getCssValue("vertical-align");
				System.out.println("Actual Vertical Alignment: " + actualVerticalAlignment);

				String expectedVerticalAlignment = "baseline";

				boolean verticalAlignment = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-VERTICAL-ALIGNMENT");
				try {
					Assert.assertEquals(actualVerticalAlignment, expectedVerticalAlignment);
				} catch (AssertionError e) {
					verticalAlignment = false;
				}

				if (verticalAlignment) {
					testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.PASS, "Text vertical Align is as expected");

				} else {
					testCase.log(Status.INFO, "actualVerticalAlignment :- " + actualVerticalAlignment);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text vertical Align is as expected");

				}

				// TEXT INDENT (To indent is to begin text with a blank space between it and the
				// margin)

				String ActualTextIndent = AddSbuUIPage.DescriptionText.getCssValue("text-indent");
				System.out.println("Text Indent :" + ActualTextIndent);

				String ExpectedTextIndent = "0px";

				boolean textindent = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-INDENT");
				try {
					AssertJUnit.assertEquals(ActualTextIndent, ExpectedTextIndent);

				} catch (AssertionError e) {
					textindent = false;
				}
				if (textindent) {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "ExpectedTextIndent :- " + ExpectedTextIndent);
					testCase.log(Status.PASS, "Text Indent is as expected");

				} else {
					testCase.log(Status.INFO, "ActualTextIndent :- " + ActualTextIndent);
					testCase.log(Status.INFO, "expectedVerticalAlignment :- " + expectedVerticalAlignment);
					testCase.log(Status.FAIL, "Text Indent is as expected");

				}
				// TEXT - ORIENTATION(text characters in a line. It only affects text in
				// vertical mode)

				String ActualTextOrientation = AddSbuUIPage.DescriptionText.getCssValue("text-orientation");
				System.out.println("Text Orientation :" + ActualTextOrientation);

				String ExpectedTextOrientation = "mixed";

				boolean textorientation = true;
				testCase = extent.createTest("DESCRIPTION-TEXT-ORIENTATION");
				try {
					AssertJUnit.assertEquals(ActualTextOrientation, ExpectedTextOrientation);

				} catch (AssertionError e) {
					textorientation = false;
				}
				if (textorientation) {
					testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
					testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
					testCase.log(Status.PASS, "Text orientation is as expected");
				} else {
					testCase.log(Status.INFO, "ActualTextOrientation :- " + ActualTextOrientation);
					testCase.log(Status.INFO, "ExpectedTextOrientation :- " + ExpectedTextOrientation);
					testCase.log(Status.FAIL, "Text orientation is as unxpected");
				}

			} else {
				testCase = extent.createTest("TEXT IS NOT DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("TEXT Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}

		System.out.println();

	}

	@Test(priority = 4)
	public void sbutextbox() throws InterruptedException {

		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuUIPage.SBUtextbox.isDisplayed()) {

//						button Displayed

				boolean ActualbiuttonDisplay = AddSbuUIPage.SBUtextbox.isDisplayed();
				boolean ExpectedbuttonDisplay = true;
				testCase = extent.createTest("SUB-TEXTBOX-DISPLAYED");
				try {
					Assert.assertEquals(ActualbiuttonDisplay, ExpectedbuttonDisplay);
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.PASS, " Image Displayed is Correct");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.FAIL, " Image Displayed is Wrong");
				}

				try {
					if (AddSbuUIPage.SBUtextbox.isEnabled()) {

//								button enabled

						boolean ActualImageDisplay = AddSbuUIPage.SBUtextbox.isEnabled();
						boolean ExpectedImageDisplay = true;
						testCase = extent.createTest("SBU-TEXTBOX-ENABLED");
						try {
							Assert.assertEquals(ActualImageDisplay, ExpectedImageDisplay);
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.PASS, " Image Displayed is Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.FAIL, " Image Displayed is Wrong");
						}

						// Check Image Position
						Point ExpectedImageLocation = new Point(417, 189);
						Point actualImageLocation = AddSbuUIPage.SBUtextbox.getLocation();
						System.out.println("Position :" + actualImageLocation);
						testCase = extent.createTest("SBU-TEXTBOX-POSITION");
						try {
							Thread.sleep(1000);
							Assert.assertEquals(actualImageLocation, ExpectedImageLocation);
							Thread.sleep(3000);
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Correct Image Position");
							testCase.log(Status.PASS, " Image Position Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Wrong  Image Position");
							testCase.log(Status.FAIL, " Image Position Wrong");
						}

						// CHECK BACKGROUND COLOR

						String Actualbgcolor = AddSbuUIPage.SBUtextbox.getCssValue("background-color");

						String Expectedbgcolour = "rgba(255, 255, 255, 1)";
						System.out.println("text :" + Actualbgcolor);
						testCase = extent.createTest("SBU-TEXTBOX-BACKGROUND-COLOUR");
						try {
							Assert.assertEquals(Actualbgcolor, Expectedbgcolour);
							testCase.log(Status.INFO, "Actual bg colur:- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.PASS, "Correct bg colur");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual bg colur :- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.FAIL, "wrong bg colur");
						}

						// text font color

						String Actualtextcolor = AddSbuUIPage.SBUtextbox.getCssValue("font-color");

						String Expectedtextcolor = "";
						System.out.println("font colour :" + Actualtextcolor);
						testCase = extent.createTest("SBU-TEXTBOX-FONT-COLOUR");
						try {
							Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
							testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.PASS, "Correct font colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.FAIL, "wrong font colour");
						}

						// text font size

						String Actualtextsize = AddSbuUIPage.SBUtextbox.getCssValue("font-size");

						String Expectedtextsize = "14px";
						System.out.println("font size :" + Actualtextsize);
						testCase = extent.createTest("SBU-TEXTBOX-FONT-SIZE");
						try {
							Assert.assertEquals(Actualtextsize, Expectedtextsize);
							testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.PASS, "Correct font size");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.FAIL, "wrong font size");
						}

						// text font style

						String Actualtextstyle = AddSbuUIPage.SBUtextbox.getCssValue("font-style");

						String Expectedtextstyle = "normal";
						System.out.println("font style :" + Actualtextstyle);
						testCase = extent.createTest("SBU-TEXTBOX-FONT-STYLE");
						try {
							Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
							testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.PASS, "Correct font style");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.FAIL, "wrong font style");
						}

						// SIZE
						Dimension ActualSize = AddSbuUIPage.SBUtextbox.getSize();
						System.out.println("Size :" + ActualSize);
						Dimension ExpectedSize = new Dimension(256, 32);

						boolean size = true;
						testCase = extent.createTest("SBU-TEXTBOX-SIZE");
						try {
							AssertJUnit.assertEquals(ActualSize, ExpectedSize);
						} catch (AssertionError e) {
							size = false;
						}
						if (size) {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "Correct Size");
							testCase.log(Status.PASS, "Correct Size");
						} else {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "wrong Size");
							testCase.log(Status.FAIL, "wrong Size");
						}
						Thread.sleep(2000);
						
						// BORDER COLOUR
						
						String Actualbordercolour = AddSbuUIPage.SBUtextbox.getCssValue("border-color");

						String Expectedbordercolour = "rgb(217, 217, 217)";
						System.out.println("font style :" + Actualbordercolour);
						testCase = extent.createTest("SBU-TEXTBOX-BORDER-COLOUR");
						try {
							Assert.assertEquals(Actualbordercolour, Expectedbordercolour);
							testCase.log(Status.INFO, "Actual border colour:- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.PASS, "Correct border colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual border colour :- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.FAIL, "wrong border colour");
						}
						

					} else {
						testCase = extent.createTest("SBU-TEXTBOX-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("SBU-TEXTBOX Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("SBU-TEXTBOX-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("SBU-TEXTBOX Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
		System.out.println();
	}
	
	@Test(priority = 5)
	public void descriptiontextbox() throws InterruptedException {

		PageFactory.initElements(driver, sbuui);

		try {
			if (AddSbuUIPage.Descriptiontextbox.isDisplayed()) {

//						button Displayed

				boolean ActualbiuttonDisplay = AddSbuUIPage.Descriptiontextbox.isDisplayed();
				boolean ExpectedbuttonDisplay = true;
				testCase = extent.createTest("DESCRIPTION-TEXTBOX-DISPLAYED");
				try {
					Assert.assertEquals(ActualbiuttonDisplay, ExpectedbuttonDisplay);
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.PASS, " Image Displayed is Correct");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualbiuttonDisplay);
					testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedbuttonDisplay);
					testCase.log(Status.FAIL, " Image Displayed is Wrong");
				}

				try {
					if (AddSbuUIPage.SBUtextbox.isEnabled()) {

//								button enabled

						boolean ActualImageDisplay = AddSbuUIPage.Descriptiontextbox.isEnabled();
						boolean ExpectedImageDisplay = true;
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-ENABLED");
						try {
							Assert.assertEquals(ActualImageDisplay, ExpectedImageDisplay);
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.PASS, " Image Displayed is Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Displayed :- " + ActualImageDisplay);
							testCase.log(Status.INFO, "Expected Image Displayed :- " + ExpectedImageDisplay);
							testCase.log(Status.FAIL, " Image Displayed is Wrong");
						}

						// Check Image Position
						Point ExpectedImageLocation = new Point(693, 189);
						Point actualImageLocation = AddSbuUIPage.Descriptiontextbox.getLocation();
						System.out.println("Position :" + actualImageLocation);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-POSITION");
						try {
							Thread.sleep(1000);
							Assert.assertEquals(actualImageLocation, ExpectedImageLocation);
							Thread.sleep(3000);
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Correct Image Position");
							testCase.log(Status.PASS, " Image Position Correct");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual Image Position :- " + actualImageLocation);
							testCase.log(Status.INFO, "Expected Image Position :- " + ExpectedImageLocation);
							testCase.log(Status.INFO, "Wrong  Image Position");
							testCase.log(Status.FAIL, " Image Position Wrong");
						}

						// CHECK BACKGROUND COLOR

						String Actualbgcolor = AddSbuUIPage.Descriptiontextbox.getCssValue("background-color");

						String Expectedbgcolour = "rgba(255, 255, 255, 1)";
						System.out.println("text :" + Actualbgcolor);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-BACKGROUND-COLOUR");
						try {
							Assert.assertEquals(Actualbgcolor, Expectedbgcolour);
							testCase.log(Status.INFO, "Actual bg colur:- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.PASS, "Correct bg colur");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual bg colur :- " + Actualbgcolor);
							testCase.log(Status.INFO, "Expected bg colur :- " + Expectedbgcolour);
							testCase.log(Status.FAIL, "wrong bg colur");
						}

						// text font color

						String Actualtextcolor = AddSbuUIPage.Descriptiontextbox.getCssValue("font-color");

						String Expectedtextcolor = "";
						System.out.println("font colour :" + Actualtextcolor);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-FONT-COLOUR");
						try {
							Assert.assertEquals(Actualtextcolor, Expectedtextcolor);
							testCase.log(Status.INFO, "Actual font colour:- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.PASS, "Correct font colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font colour :- " + Actualtextcolor);
							testCase.log(Status.INFO, "Expected font colour :- " + Expectedtextcolor);
							testCase.log(Status.FAIL, "wrong font colour");
						}

						// text font size

						String Actualtextsize = AddSbuUIPage.Descriptiontextbox.getCssValue("font-size");

						String Expectedtextsize = "14px";
						System.out.println("font size :" + Actualtextsize);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-FONT-SIZE");
						try {
							Assert.assertEquals(Actualtextsize, Expectedtextsize);
							testCase.log(Status.INFO, "Actual font size:- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.PASS, "Correct font size");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font size :- " + Actualtextsize);
							testCase.log(Status.INFO, "Expected font size :- " + Expectedtextsize);
							testCase.log(Status.FAIL, "wrong font size");
						}

						// text font style

						String Actualtextstyle = AddSbuUIPage.Descriptiontextbox.getCssValue("font-style");

						String Expectedtextstyle = "normal";
						System.out.println("font style :" + Actualtextstyle);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-FONT-STYLE");
						try {
							Assert.assertEquals(Actualtextstyle, Expectedtextstyle);
							testCase.log(Status.INFO, "Actual font style:- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.PASS, "Correct font style");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual font style :- " + Actualtextstyle);
							testCase.log(Status.INFO, "Expected font style :- " + Expectedtextstyle);
							testCase.log(Status.FAIL, "wrong font style");
						}

						// SIZE
						Dimension ActualSize = AddSbuUIPage.Descriptiontextbox.getSize();
						System.out.println("Size :" + ActualSize);
						Dimension ExpectedSize = new Dimension(256, 32);

						boolean size = true;
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-SIZE");
						try {
							AssertJUnit.assertEquals(ActualSize, ExpectedSize);
						} catch (AssertionError e) {
							size = false;
						}
						if (size) {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "Correct Size");
							testCase.log(Status.PASS, "Correct Size");
						} else {
							testCase.log(Status.INFO, "ActualSize :- " + ActualSize);
							testCase.log(Status.INFO, "ExpectedSize :- " + ExpectedSize);
							testCase.log(Status.INFO, "wrong Size");
							testCase.log(Status.FAIL, "wrong Size");
						}
						Thread.sleep(2000);
						
						// BORDER COLOUR
						
						String Actualbordercolour = AddSbuUIPage.Descriptiontextbox.getCssValue("border-color");

						String Expectedbordercolour = "rgb(217, 217, 217)";
						System.out.println("font style :" + Actualbordercolour);
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-BORDER-COLOUR");
						try {
							Assert.assertEquals(Actualbordercolour, Expectedbordercolour);
							testCase.log(Status.INFO, "Actual border colour:- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.PASS, "Correct border colour");
						} catch (AssertionError e) {
							testCase.log(Status.INFO, "Actual border colour :- " + Actualbordercolour);
							testCase.log(Status.INFO, "Expected border colour :- " + Expectedbordercolour);
							testCase.log(Status.FAIL, "wrong border colour");
						}
						

					} else {
						testCase = extent.createTest("DESCRIPTION-TEXTBOX-NOT-ENABLED");
						testCase.log(Status.INFO, "Image Not Displayed");
						testCase.log(Status.FAIL, " Image Not Displayed");
					}
				} catch (NoSuchElementException e) {
					testCase = extent.createTest("DESCRIPTION-TEXTBOX Locator");
					testCase.log(Status.INFO, "Dont Have Image Locator");
					testCase.log(Status.FAIL, " Dont Have Image Locator");
				}

			} else {
				testCase = extent.createTest("DESCRIPTION-TEXTBOX-NOT-DISPLAYED");
				testCase.log(Status.INFO, "Image Not Displayed");
				testCase.log(Status.FAIL, " Image Not Displayed");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("DESCRIPTION-TEXTBOX Locator");
			testCase.log(Status.INFO, "Dont Have Image Locator");
			testCase.log(Status.FAIL, " Dont Have Image Locator");
		}
		System.out.println();
	}
	
	
}
