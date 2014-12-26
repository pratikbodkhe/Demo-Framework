package com.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Don {

	public static void main(String[] args) {
		String url = "http://www.google.com";
		System.setProperty("webdriver.chrome.driver", "C:\\Impulse\\Data\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	
}
