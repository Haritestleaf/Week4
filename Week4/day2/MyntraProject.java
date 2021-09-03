package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraProject {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		Thread.sleep(2000);
		ChromeOptions Options = new ChromeOptions();
		Options.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver(Options);
		
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement Men = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		builder.moveToElement(Men).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();

		String CountJacket = driver.findElement(By.xpath("//span[@class='title-count']")).getText();

		String NumofCount = CountJacket.replaceAll("[^0-9]", "");
		int Total = Integer.parseInt(NumofCount);
		System.out.println("overall Count for jack of mens :" + Total);

		String SumOfJacket = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		String NoOfJacket = SumOfJacket.replaceAll("[^0-9]", "");
		int x = Integer.parseInt(NoOfJacket);
		String SumOfRainJacket = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String NoOfRainJacket = SumOfRainJacket.replaceAll("[^0-9]", "");
		int y = Integer.parseInt(NoOfRainJacket);
		int sum = x + y;
		if (Total == sum) {
			System.out.println("Sum of Count is matching");

		}

		else
			System.out.println("Sum of Count is not matching");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		Thread.sleep(2000);
		WebElement DukeChkBox = driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']"));
		DukeChkBox.sendKeys("Duke");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		String BrandName = driver.findElement(By.tagName("h3")).getText();
		if (BrandName.contains("Duke"))
			System.out.println("All brand are Duke");
		else
			System.out.println(" Not matching");
		WebElement Sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		builder.moveToElement(Sort).perform();
		driver.findElement(By.xpath("//ul[@class='sort-list']/li[3]")).click();
		Thread.sleep(2000);
		String Amount = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("price of first item : " + Amount);
		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		File Scr = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/seat1.png");
		FileUtils.copyFile(Scr, dst);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.findElement(By.xpath("//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo']")).click();
		

	}
}
