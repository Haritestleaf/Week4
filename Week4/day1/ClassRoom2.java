package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		String text = driver.findElement(By.id("demo")).getText();
		if (text.contains("OK")) {
			System.out.println("You pressed OK!");
		}

		
		else
			System.out.println("You pressed Cancel!");

	}

}
