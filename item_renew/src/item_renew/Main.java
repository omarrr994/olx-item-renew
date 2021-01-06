package item_renew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

public class Main {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "sample");//Unesite svoju lokaciju Google Chrome WebDrivera umjesto sample	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.olx.ba");
		
		try {
			
			driver.findElement(By.id("loginbtn")).click();
			driver.findElement(By.id("username")).sendKeys("sample");//Unesite svoj email umjesto sample
			driver.findElement(By.id("password")).sendKeys("sample");//Unesite svoj password umjesto sample
			driver.findElement(By.id("btnlogin1")).click();
			System.out.println("Uspjesno ste se prijavili na svoj OLX.ba nalog!");
			
			
		}
		
		catch (Exception e) {
			
			System.out.println("Prijava na OLX.ba nije moguca, provjerite Vas username i password!");
			
		}
		
		driver.get("https://www.olx.ba/mojpik/obnovite");
		
		try {
			
			List<WebElement> torenew = driver.findElements(By.xpath("//a[contains(@class, 'btnmali') and contains(@class, 'preko')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			torenew.forEach(e -> {js.executeScript("arguments[0].click();", e);}
			);
			
			System.out.println("Svi istekli artikli su uspjesno obnovljeni!");
		}
		
		catch (Exception n) {
			
			System.out.println("Nemate artikala za obnoviti!");
		}
		

	}

}
