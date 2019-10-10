package webdriverMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void doLogin() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("nikunjtechhive@gmail.com");
		driver.findElement(By.id("identifierNext")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profileIdentifier")));
		WebElement element = driver.findElement(By.name("password"));
		element.sendKeys("test");
		driver.findElement(By.id("passwordNext")).click();
	}

	@AfterSuite
	public void tearDown() {
		// driver.quit();
	}
}
