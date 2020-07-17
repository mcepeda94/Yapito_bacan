package com.yapo.config;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;


//Se encarga de entregar el driver correspondiente según el hilo de ejecucion actual
public final class DriverFactory {

	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
	
	//To quit the drivers and browsers at the end only. 
	private static List<WebDriver> storedDrivers = new ArrayList<>();
	
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(){
		    public void run(){
		    	storedDrivers.stream().forEach(WebDriver::quit);
		    }
		  });
	}
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return drivers.get();
	}
	
	public static void addDriver(WebDriver driver) {
		storedDrivers.add(driver);
		drivers.set(driver);
	}
	
	public static void removeDriver() {
		storedDrivers.remove(drivers.get());
		drivers.remove();
	}	
}
