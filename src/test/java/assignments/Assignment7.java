package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment7 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//scrolling to the table
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		// getting rows count
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product' and @name='courses']/tbody/tr"));
		int rowcount = rows.size();
		System.out.println("rows count : " + rowcount);
		
		// getting col count
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='product' and @name='courses']/tbody/tr/th"));
		int colCount = columns.size();
		System.out.println("col count : " + colCount);
		
		//printing 3nd row data
		List<WebElement> ThirdRow = driver.findElements(By.xpath("//table[@id='product' and @name='courses']/tbody/tr[3]/td"));
		for(int i=0; i<ThirdRow.size();i++) {
			System.out.print(ThirdRow.get(i).getText());
			System.out.print(" | ");
		
		}
	}

}
