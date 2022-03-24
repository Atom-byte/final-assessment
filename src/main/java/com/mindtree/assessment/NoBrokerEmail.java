package com.mindtree.assessment;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoBrokerEmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Sel_Drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.nobroker.in/");
		driver.findElement(By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div")).click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"signUp-phoneNumber\"]")).sendKeys("9110813270");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='password']")).click();
		
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys("Adam123");
		driver.findElement(By.id("login-signup-form__password-input")).sendKeys(Keys.ENTER);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//*[@id=\"navHeader\"]/div[5]/div[3]/div[1]/div/span")).click();
		
		Actions a = new Actions(driver);
		By hover =(By.xpath("//span[@class='nb__3-MNF']"));
		a.moveToElement(driver.findElement(hover)).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions b = new Actions(driver);
		By profile = (By.xpath("//div[@class='nb__qiCij'] //a[@class='nb__3Tx_U']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(profile));
		b.moveToElement(driver.findElement(profile)).click().build().perform();
		
		String adam = "bytea06@gmail.com";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.cssSelector("span[class='nb__wUGea']")).click();
		driver.findElement(By.id("emailText")).clear();
		
		driver.findElement(By.id("emailText")).sendKeys(adam);
		
		driver.findElement(By.cssSelector("span[class='nb__wUGea']")).click();
		
		try {
		String alert = driver.findElement(By.xpath("//div[@id='alertMessageBox']")).getText();
		System.out.println(alert);
		} catch(org.openqa.selenium.StaleElementReferenceException e){
			
		} 
		
	}

}
