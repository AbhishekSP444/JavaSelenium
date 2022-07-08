package Ume;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class List {
	public Home Call;
	public WebDriver driver;

	@BeforeSuite 
	public void Open() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.umrahme.com/home/en-sa");
		Call = new Home(driver);
	}

	@Test
	public void Testing() {

		Call.Select_Destination();
		Call.Depart_Date();
		Call.Stay_In_Madinah();
		Call.Travellers();
		Call.Room1Adult();
		Call.Room1Child();
		Call.Room1C_Age();
		Call.Country();
		Call.Nation();
		try {
			Call.S_Button();
		} catch (Exception e) {
			System.out.println("Browser Exception");
		}
		Assert.assertEquals(Call.Transport(), "Transportation");
	}

	@AfterSuite
	public void quit() {
		driver.quit();
	}

}
