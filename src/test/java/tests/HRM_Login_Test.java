package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRM_Login_Test {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void loginTest() {
		String loginPageTitle = "OrangeHRM";
		Assert.assertEquals(loginPageTitle, driver.getTitle());
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		String expectedDashboardText = "Dashboard";
		String actualDashboardText = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
		Assert.assertEquals(actualDashboardText, expectedDashboardText);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Execution completed");
	}

}
