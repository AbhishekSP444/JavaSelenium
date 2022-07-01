package Umrahme;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UmrahME { 

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/// Site will get open
		driver.get("https://www.umrahme.com/home/en-sa");

		/// Select Destination
		driver.findElement(
				By.xpath("//span[@aria-labelledby=\"select2-RouteCode-container\"]/parent::span/parent::span")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("Madinah Only Package", Keys.ENTER);

		/// Select Start date
		driver.findElement(By.id("StartDate")).clear();
		driver.findElement(By.id("StartDate")).sendKeys("11-08-2022", Keys.ENTER);

		/// Select Stay
		driver.findElement(By.id("select2-madinaCityNight-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("7  Nights", Keys.ENTER);

		/// Select occupancy

		/// Adult
		driver.findElement(By.xpath("//div[@class=\"all-traveller show-occupancy\"]")).click();
		WebElement A1 = driver.findElement(By.xpath("//select[@class=\"floating-select select-adult\"]"));
		Select Obj = new Select(A1);
		/// Give the value as number of Adult-1.
		int j = 0;
		Obj.selectByIndex(j);

		/// Child
		WebElement A2 = driver.findElement(By.xpath("//select[@class=\"floating-select select-child\"]"));
		Select Obj1 = new Select(A2);
		/// Give the number of child.
		int k = 3;
		Obj1.selectByIndex(k);

		for (int i = 1; i <= k; i++) {
			WebElement A3 = driver.findElement(By.xpath("//ul[@class=\"age-wrap\"]/descendant::li[" + i + "]/select"));
			Select Obj2 = new Select(A3);
			Obj2.selectByIndex(5);
		}

		/// Select COR
		driver.findElement(By.id("select2-CountryOfResidence-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("United States of America", Keys.ENTER);

		/// Select Nationality
		driver.findElement(By.id("select2-Nationality-container")).click();
		driver.findElement(By.className("select2-search__field")).sendKeys("India", Keys.ARROW_DOWN, Keys.ENTER);

		/// Search
		driver.findElement(By.id("btnSearchPackage")).click();

	}

}
