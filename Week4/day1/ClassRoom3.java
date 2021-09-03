package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		Thread.sleep(2000);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println(windowHandlesList.size());
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//a[@class='d-block font-weight-bold']")).getText();
		System.out.println("email : " + text);
		Thread.sleep(2000);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.close();
	}

}
