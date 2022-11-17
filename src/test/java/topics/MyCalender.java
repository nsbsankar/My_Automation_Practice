package topics;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyCalender {

	public static void main(String[] args) {
		String monthandyear = "January 2023"; 
		String day = "5";

		////div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-title']")).getText());
		
		while(!driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div[@class='ui-datepicker-title']")).getText().equals(monthandyear)) {
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[@class='ui-datepicker-next ui-corner-all']")).click();
		}
		List<WebElement> days = driver.findElements(By.cssSelector(".ui-state-default"));
		for(int i=0;i<days.size();i++) {
			String text = driver.findElements(By.cssSelector(".ui-state-default")).get(i).getText();
			if(text.equals(day)) {
				driver.findElements(By.cssSelector(".ui-state-default")).get(i).click();
				break;
			}
		}
		
		
	}

}
