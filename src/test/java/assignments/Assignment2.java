package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("BhavaniSankar");
		driver.findElement(By.name("email")).sendKeys("sankar@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("12345");
		driver.findElement(By.id("exampleCheck1")).click();
		Select gender= new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		gender.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("07151996");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		driver.quit();
		
	}

}
