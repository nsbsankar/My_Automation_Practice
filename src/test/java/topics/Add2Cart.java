package topics;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Add2Cart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String[] items = {"Cauliflower","Beetroot","Carrot","Capsicum"};
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, items);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}
	public static void addItems(WebDriver driver,String[] items) {
		int j=0;
		List<WebElement> Products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<Products.size();i++) {
			//Brocolli - 1 Kg

			//Brocolli,    1 kg
			String[] name = Products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			//format it to get actual vegetable name

			//convert array into array list for easy search

			//  check whether name you extracted is present in arrayList or not-
			List itemsList = Arrays.asList(items);
			
			if(itemsList.contains(formattedName)) {
				j++;
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==items.length)
					break;
			}
		}
		//driver.quit();
	}

}
