package Week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignMouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement MouseOver = driver.findElement(By.xpath("//a[text()='TestLeaf Courses']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(MouseOver).perform();
		
		 //String text = driver.findElement(By.xpath("//a[@class='listener']")).getText();
		 List<WebElement> names = driver.findElementsByXPath("//a[@class='listener']");
		 for (WebElement course : names) {
			String name =course.getText();
			System.out.println("name of the Course : "+name );
			
		}
		
		 driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		 Alert alert = driver.switchTo().alert();
		 Thread.sleep(1000);
		 alert.accept();
		 
		}
	
		
	}


