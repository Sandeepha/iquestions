package com.practice.iquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(null);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.switchTo().frame(index); //int 0 1 2
		driver.switchTo().frame(nameOrId);; // String 
		driver.switchTo().frame(frameElement); //WebElement
		
		int iframesCount = driver.findElements(By.tagName("/iframe")).size();
		driver.switchTo().defaultContent(); //Focus on the main page

	}
}
