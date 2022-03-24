package com.mindtree.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoBrokerName {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Sel_Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String expectedHeading = "Adam Mohammed Muzammil";
		
		driver.get("https://www.nobroker.in/");
		
		driver.findElement(By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(5000L);
		
		driver.findElement(By.xpath("//*[@id=\"signUp-phoneNumber\"]")).sendKeys("9110813270");
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//input[@value='password']")).click();
		
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys("Adam123");
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys(Keys.ENTER);
		Thread.sleep(5000L);
		
		Actions a = new Actions(driver);
		By hover =(By.xpath("//span[@class='nb__3-MNF']"));
		
		String User =  driver.findElement(By.xpath("//span[@class='nb__3-MNF']")).getText();
		a.moveToElement(driver.findElement(hover)).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions b = new Actions(driver);
		By profile = (By.xpath("//div[@class='nb__qiCij'] //a[@class='nb__3Tx_U']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(profile));
		b.moveToElement(driver.findElement(profile)).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[@class='form-group no-label '] //input[@id='nameText']")).clear();
		driver.findElement(By.xpath("//div[@class='form-group no-label '] //input[@id='nameText']")).sendKeys("Adam Mohammed");
		driver.findElement(By.xpath("//button[@id='saveProfile'")).click();
		
		if(expectedHeading.equalsIgnoreCase(User))
          	System.out.println("The expected heading is same as actual heading --- "+User);
    	else
          	System.out.println("The expected heading doesn't match the actual heading --- "+User);

	}

} 