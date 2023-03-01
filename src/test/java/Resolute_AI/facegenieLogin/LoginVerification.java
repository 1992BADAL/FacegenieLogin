package Resolute_AI.facegenieLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginVerification {

	public class TC_01_LoginPage {

		@Test
		public void verify_Login_page() throws InterruptedException {

			// Open web Browser(Chrome browser)
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			// Maximize Window
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Open Base URL
			driver.navigate().to("https://facegenie-ams-school.web.app/");
			// input Credentials(Email,Password, and click Login)
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testing@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("testing@123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			String Expected_Tittle = "Rai-Test-Bams";
			String Actual_Tittle = driver.getTitle();

			Assert.assertEquals(Expected_Tittle, Actual_Tittle);
			Thread.sleep(2000);
			
			
			// Logout submission
			driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();
			driver.findElement(By.xpath("//div[contains(@role,'dialog')]")).click();
			String LogoutPageTitle = driver.getTitle();
			System.out.println("Page Title :" + LogoutPageTitle);
			Thread.sleep(2000);
			driver.quit();

		}
	}

}
