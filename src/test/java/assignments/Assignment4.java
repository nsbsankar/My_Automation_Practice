package assignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			if (!window.equals(windowHandle)) {
				driver.switchTo().window(window);
				System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
			}
		}
		driver.switchTo().window(windowHandle);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}

}
