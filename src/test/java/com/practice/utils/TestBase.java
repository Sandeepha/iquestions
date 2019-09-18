package com.practice.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("./configurations/browser-config.properties"));
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	@BeforeClass
	public static void initialiseBrowser() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome.driver.path"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(GlobalConstants.PAGE_LOAD_TIMEOUT,
		// TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.IMPLICITE_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseURL"));
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

	@AfterMethod
	public void getScreenshot(ITestResult result) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\UX014784\\eclipse-workspace\\Practice\\screenshots"+result.getName()+".png"));
		} catch (Exception e) {

			e.getMessage();
		}
	}

}
