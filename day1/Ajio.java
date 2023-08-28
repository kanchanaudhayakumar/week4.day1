package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions(); 
		//ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("searchVal")).sendKeys("bags",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		List<Integer> sortPrice = new ArrayList<Integer>();//syntax
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));
		
		 for(int i=0; i<price.size();i++)
		 {
			 String text = price.get(i).getText();
			 String replaceAll = text.replaceAll("[^0-9]","");//[//d]
			 int parseInt = Integer.parseInt(replaceAll);//replace integer
			 sortPrice.add(parseInt);//element add into list
		 }
		 Collections.sort(sortPrice);
		 System.out.println(sortPrice);
		 
		 System.out.println("lowest price :" +sortPrice.get(0));

	}

}
