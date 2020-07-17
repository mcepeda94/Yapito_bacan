package com.yapo.util;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.yapo.config.BaseConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class HtmlReport  extends BaseConfig   {
	public static ExtentReports extent;


	

	public ExtentReports getReport() throws Exception {
		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "/report/suite.html", true,
					NetworkMode.OFFLINE);
		}
		return extent;
	}

	public void generateStep(ExtentTest extentTest, ITestResult result, String message,WebDriver drivers) {
		this.driver = drivers;
		try {
			CaptureScreenShot screenshot = new CaptureScreenShot();
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotPath = screenshot.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath), result.getThrowable());
			} else if (result.getStatus() == ITestResult.SKIP) {
				String screenshotPath = screenshot.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.SKIP, extentTest.addScreenCapture(screenshotPath), result.getThrowable());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				String screenshotPath = screenshot.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.PASS, result.getName(), extentTest.addScreenCapture(screenshotPath));
			} else {
				String screenshotPath = screenshot.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FATAL, extentTest.addScreenCapture(screenshotPath), result.getThrowable());
			}
		} catch (Exception e) {
			System.out.println("Error al generar Paso " + e.toString());
			extentTest.log(LogStatus.FATAL, result.getName(), result.getThrowable());
		}
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

	public String returnStateCase(ITestResult result) {
		String resultado = "";
		System.out.println("result status=" + result.getStatus());
		;
		switch (result.getStatus()) {
		case 1:
			resultado = "PASSED";
			break;
		case 2:
			resultado = "FAILED";
			break;
		case 3:
			resultado = "SKIP";
			break;
		default:
			resultado = "SKIP";
			break;
		}
		return resultado;
	}
}
