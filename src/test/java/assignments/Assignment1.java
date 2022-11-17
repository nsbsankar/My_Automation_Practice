package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	@Test
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify 
		//if it is successfully Unchecked
		WebElement firstcheckbox = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		firstcheckbox.click();
	
		Assert.assertTrue(firstcheckbox.isSelected());
		firstcheckbox.click();
		Assert.assertFalse(firstcheckbox.isSelected());
		
	//	2.How to get the Count of number of check boxes present in the page
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//label/input"));
		System.out.println("no of checkboxes present in the page" +checkboxes.size());
		
		driver.quit();
		
		
	}

}
