package Ume;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Home {
	@FindBy(xpath = "//*[@id='select2-RouteCode-container']")
	private WebElement Destination;

	@FindBy(id = "StartDate")
	private WebElement S_Date;

	@FindBy(xpath = "//*[@id='select2-meccaCityNight-container']")
	private WebElement Macca_Stay;

	@FindBy(xpath = "//*[@class='select2-search__field']")
	private WebElement SearchBox;

	@FindBy(xpath = "//*[@id='select2-madinaCityNight-container']")
	private WebElement Madina_Stay;

	@FindBy(xpath = "//*[@class='all-traveller show-occupancy']")
	private WebElement Occ_DD;

	@FindBy(xpath = "//*[@class='floating-select select-adult']")
	private WebElement Adult_1;

	@FindBy(xpath = "//*[@class='floating-select select-child']")
	private WebElement Child_1;

	@FindBy(xpath = "//*[@class='age-wrap']/descendant::li[1]/select")
	private WebElement C1_Age;

//	@FindBy(xpath = "//*[@class='addRoomLink']")
//	private WebElement Add_Room;
//	@FindBy(xpath = "//*[contains(text(),'Room 2')]/parent::div[@class='roomSection-inner']/descendant::li[@class='adult floating-label']/select")
//	private WebElement Adult_2;
//	@FindBy(xpath = "//*[contains(text(),'Room 2')]/parent::div[@class='roomSection-inner']/descendant::li[@class='child floating-label']/select")
//	private WebElement Child_2;
//	@FindBy(xpath = "//*[contains(text(),'Room 2')]/parent::div[@class='roomSection-inner']/descendant::li[@class='age floating-label']/select")
//	private WebElement C2_Age;

	@FindBy(xpath = "//*[@id='select2-CountryOfResidence-container']")
	private WebElement COR;

	@FindBy(xpath = "//*[@id='select2-Nationality-container']")
	private WebElement Nationality;

	@FindBy(xpath = "//*[@id='btnSearchPackage']")
	private WebElement SearchButton;

	@FindBy(xpath = ".//h6[contains(.,'Transportation')]")
	private WebElement Transportation;

	/****************************************/

	public WebDriver driver;

	public void Select_Destination() {
		Assert.assertTrue(Destination.isDisplayed());
		Destination.click();
		SearchBox.sendKeys("Madinah Only Package", Keys.ENTER);
	}

	public void Depart_Date() {
		Assert.assertTrue(S_Date.isDisplayed());
		S_Date.clear();
		S_Date.sendKeys("11-08-2022", Keys.ENTER);
	}

	public void Stay_In_Makkah() {
		Assert.assertTrue(Macca_Stay.isDisplayed());
		Macca_Stay.click();
		SearchBox.sendKeys("7  Nights", Keys.ENTER);
	}

	public void Stay_In_Madinah() {
		Assert.assertTrue(Madina_Stay.isDisplayed());
		Madina_Stay.click();
		SearchBox.sendKeys("7  Nights", Keys.ENTER);
	}

	public void Travellers() {
		Assert.assertTrue(Occ_DD.isDisplayed());
		Occ_DD.click();
	}

	public void Room1Adult() {
		Adult_1.click();
		Select Obj_A1 = new Select(Adult_1);
		int j = 0; // no. of adults
		Obj_A1.selectByIndex(j);
	}

	public void Room1Child() {
		Select Obj_C1 = new Select(Child_1);
		int k = 1; // no. of child
		Obj_C1.selectByIndex(k);
	}

	public void Room1C_Age() {
		Select Obj_Age1 = new Select(C1_Age);
		Obj_Age1.selectByIndex(5);
	}

	public void Country() {
		Assert.assertTrue(COR.isDisplayed());
		COR.click();
		SearchBox.sendKeys("United States of America", Keys.ENTER);
	}

	public void Nation() {
		Assert.assertTrue(Nationality.isDisplayed());
		Nationality.click();
		SearchBox.sendKeys("India", Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void S_Button() {
		Assert.assertTrue(SearchButton.isDisplayed());
		SearchButton.click();
	}

	public void S_Box() {

	}

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String Transport() {
		System.out.println(Transportation.getText());
		return Transportation.getText();
	}

}
