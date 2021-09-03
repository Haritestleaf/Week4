package Week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssigntmentSortable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		WebElement findElement = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement findElement2 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		Point location = findElement2.getLocation();
		int x = location.getX();
		int y = location.getY();
		
		Actions builder = new Actions(driver);
		
		
		Thread.sleep(1000);
		builder.dragAndDropBy(findElement, x, y).perform();
		
		
		
		
	}

}