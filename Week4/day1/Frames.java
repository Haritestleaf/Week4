package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id]/following-sibling::input")).sendKeys("Frames");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//select[@id='animals']")).click();
		driver.findElement(By.xpath("//select[@id='animals']/option[4]")).click();
		
		driver.switchTo().defaultContent();
		
		
	}
	

}
