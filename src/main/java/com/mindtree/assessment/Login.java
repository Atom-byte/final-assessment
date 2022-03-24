package com.mindtree.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Sel_Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.nobroker.in/");
		driver.findElement(By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(5000L);
		
		driver.findElement(By.xpath("//*[@id=\"signUp-phoneNumber\"]")).sendKeys("9110813270");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//input[@value='password']")).click();
		
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys("Adam123");
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String alert = driver.findElement(By.xpath("//div[@id='alertMessageBox']")).getText();
		System.out.println(alert);
}
}