package com.practice.iquestions;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow: " + parentWindow);

		Set<String> totalWindowsOpened = driver.getWindowHandles();
		System.out.println("childWindows" + totalWindowsOpened);
		
		ArrayList<String> tabs = new ArrayList<String>(totalWindowsOpened);
		driver.switchTo().window(tabs.get(2));
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		

		/*
		 * for (String window : totalWindowsOpened) { if (!parentWindow.equals(window))
		 * { driver.switchTo().window(window); driver.close(); } }
		 */

		driver.switchTo().window(tabs.get(1));
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.switchTo().window(tabs.get(0));
		driver.close();
		
		

	}

}
