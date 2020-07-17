package com.yapo.config;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedDriver {
//Esta clase se instancia gracias a cucumber picoContainer y configura el o los drivers necesarios segun las properties
	//headless=true|false o browser=chrome|firefox
	public SharedDriver() {

		ChromeOptions options = new ChromeOptions();

		//Add headless option
		String headless = System.getProperty("headless", "false");
		if(headless.equals("true")) options.addArguments("headless");
		options.setExperimentalOption("useAutomationExtension", false);

		if (DriverFactory.getDriver() == null) {
			String webdriver = System.getProperty("browser", "chrome");
			switch(webdriver) {
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					DriverFactory.addDriver(new FirefoxDriver());
					break;
				case "chrome":
					System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, System.getProperty("user.dir") + "/target/chromedriver.log");
					WebDriverManager.chromedriver().setup();
					DriverFactory.addDriver(new ChromeDriver(options));
					break;
				default:
					throw new RuntimeException("Unsupported webdriver: " + webdriver);
			}
		}
	}
}
