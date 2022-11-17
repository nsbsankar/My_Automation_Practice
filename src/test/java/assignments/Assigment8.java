package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigment8 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// entering text
		/*
		 * WebElement textfield = driver.findElement(By.cssSelector("#autocomplete"));
		 * textfield.sendKeys("ind");
		 * 
		 * Thread.sleep(2000);
		 * // selecting country Actions a = new Actions(driver); a.sendKeys(textfield,
		 * Keys.ARROW_DOWN,Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		 * 
		 * // validating country String text =
		 * driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value");
		 * System.out.println(text); // Assert.assertEquals(text, "India");
		 */		
		 driver.findElement(By.id("autocomplete")).sendKeys("ind");

		    Thread.sleep(2000);

		    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

		    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

		   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 

		       

		       
	}

}
