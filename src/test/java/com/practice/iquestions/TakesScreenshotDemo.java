package com.practice.iquestions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.practice.utils.TestBase;

public class TakesScreenshotDemo extends TestBase {

	@Test
	public void getScreenshot() {
		
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("Login")).click();
		if(driver.findElement(By.xpath("//div[@id='error']")).getText().contains("contact your Salesforce administrator")) {
			Assert.assertTrue(false);
		}
		
		/*
		 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); try {
		 * FileUtils.copyFile(src, new
		 * File(prop.getProperty("screenshot.path"+result.getName()+".png"))); } catch
		 * (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */
	}

}
