package com.practice.iquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement element = driver.findElement(By.id("name"));
		Actions actions = new Actions(driver);
		
		//Keyboard Actions
		actions.sendKeys(Keys.CONTROL).sendKeys(Keys.ALT).sendKeys(Keys.DELETE).build().perform();
		actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(element, Keys.ENTER).build().perform();

		//Mouse Actions
		actions.doubleClick(element).build().perform();
		actions.contextClick(element).build().perform();// Right click
		actions.dragAndDrop(element, null).build().perform();
		actions.moveToElement(element).moveToElement(null).build().perform();

		driver.quit();
	}

}
