package com.mindtree.assessment;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Sel_Drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    driver.get("https://www.nobroker.in/");
	    WebElement dropdown=driver.findElement(By.xpath("//div[contains(@class,'_value-container--has-value')]"));
	    dropdown.click();
	   
	   
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    List<WebElement> list= driver.findElements(By.xpath("//div[@class='css-q4imyt nb-select__menu-list']//div[@class='css-mdf5j6-option nb-select__option']"));
	    for(WebElement li : list) {
	    	if("Bangalore".equals(li.getText())) {
	    		li.click();
	    		break;
	    	}
	    }
	   
	    driver.findElement(By.id("listPageSearchLocality")).click();
	    driver.findElement(By.id("listPageSearchLocality")).sendKeys("mallesh");
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    List<WebElement> suggestion= driver.findElements(By.xpath("//div[@class='suggestion-item']"));
	    for(WebElement suggest : suggestion) {
	    	if(suggest.getText().contains("malleshwaram"));
	    	{
	    		suggest.click();
	    		break;
	    	}
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.xpath("//button[@class='prop-search-button btn btn-primary btn-lg']")).click();
	}

}
