package com.practice.iquestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificateHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		
		
		  DesiredCapabilities handleSSL = DesiredCapabilities.chrome();
		  handleSSL.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);//Depricated
		 
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		

	}

}
