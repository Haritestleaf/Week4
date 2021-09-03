package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom1 {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(2000);
		alert.dismiss();
		String text = driver.findElement(By.id("result")).getText();
		if (text.contains("Cancel")) {
			System.out.println("Pressed Cancel button");
		} else

			System.out.println("Pressed Ok button");
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Thread.sleep(2000);
		alert.sendKeys("TestLeaf");
		alert.accept();
		String text2 = driver.findElement(By.id("result1")).getText();
		if (text2.contains("TestLeaf")) {
			System.out.println("Clicked OK");
		}
		else
			System.out.println("Clicked cancel");
	}

}
