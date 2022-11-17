package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigment6 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. selecting check box
		driver.findElement(By.id("checkBoxOption2")).click();
		//2.grab the text from selected check box
		String checkBoxText = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(checkBoxText);
		
		//3.selecting grabbed option in the dropdown
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(checkBoxText);
		
		//4. entering the grabbed checkbox text in to the alert textfield
		driver.findElement(By.id("name")).sendKeys(checkBoxText);
		
		//5.verifying the alert
		driver.findElement(By.cssSelector("#alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		
	}

}
