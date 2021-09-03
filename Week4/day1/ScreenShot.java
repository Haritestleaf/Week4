package Week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.xpath("//button[@id='Click']"));
		File Scr = click.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/click.png");
		FileUtils.copyFile(Scr, dst);
		
		driver.switchTo().defaultContent();
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		System.out.println("Count of Frames: " + findElements.size());

	}

}
