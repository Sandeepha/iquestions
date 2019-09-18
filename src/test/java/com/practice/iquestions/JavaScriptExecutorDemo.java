package com.practice.iquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement element = driver.findElement(By.id("name"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
		((JavascriptExecutor)driver).executeScript("arguments[0].value='sandeep';", element);
		((JavascriptExecutor)driver).executeAsyncScript(script, args);
}
