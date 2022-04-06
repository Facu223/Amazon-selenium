package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected static WebDriver driver;
	private static WebDriverWait wait;
	
	static {
		//Indicamos donde se encuentra el driver
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		
		//Indicamos que abra una nueva ventana
		driver = new ChromeDriver(chromeOptions);
		
		//Maximizar la ventana
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Open the url
	public static void navigateTo(String url) {
		driver.get(url);
	}
	
	//Wait 10 secs for the locator and then return it
	private WebElement Find(String locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	//Click
	public void clickElement(String locator) {
		Find(locator).click();
	}
	
	//Set a text
	public void write(String locator, String textToWrite) {
		Find(locator).clear();
		Find(locator).sendKeys(textToWrite);
	}
	
	//If a element is displayed on the screen
	public boolean elementIsDisplayed(String locator) {
		return Find(locator).isDisplayed();
	}
	
	//Search a link by the link text and then click it
	public void goToLinkText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	
	//Close the browser
	public static void closeBrowser() {
		driver.quit();
	}
}