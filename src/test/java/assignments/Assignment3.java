package assignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] items = {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[text()=' User']/following-sibling::span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select option = new Select(options);
		option.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ProtoCommerce Home']")));
	
		System.out.println(driver.findElement(By.xpath("//a[text()='ProtoCommerce Home']")).getText());
		addItemsToCart(driver, items);
		
		
		
	}

	public static void addItemsToCart(WebDriver driver,String[] items){
		int j=0;
		List<WebElement> gadgets = driver.findElements(By.cssSelector("h4.card-title"));
		
		for(int i=0;i<gadgets.size();i++) {
			String gadgetNames = gadgets.get(i).getText();
			
			List<String> itemslist = Arrays.asList(items);
			if(itemslist.contains(gadgetNames)) {
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				if(j==items.length)
					break;
			}
		}
		driver.findElement(By.xpath("//div[@id='navbarResponsive']//a")).click();
		
	}

}
