package com.yapo.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CaptureScreenShot {

	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "./report/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public void passedPrint(WebDriver driver, ExtentTest extentTest, String Name) throws IOException {
		String screenshotPath = getScreenshot(driver, Name);
		extentTest.log(LogStatus.PASS, Name , extentTest.addScreenCapture(screenshotPath));
	}

	public void leerHtml() {
		String rutaHtml = "./report/suite.html";
		try {
			File htmlTemplateFile = new File(rutaHtml);
			String htmlString = FileUtils.readFileToString(htmlTemplateFile);
			htmlString = htmlString.replace("./report", ".");
			File newHtmlFile = new File(rutaHtml);
			FileUtils.writeStringToFile(newHtmlFile, htmlString);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error " + e.toString());
		}
	}
}
