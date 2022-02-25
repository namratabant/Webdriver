package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Logintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		
		WebDriver driver =new ChromeDriver();
		
		//WebDriver driver =new FirefoxDriver();
	driver.get("https://www.simplilearn.com/");
	
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
	WebElement LoginLink = driver.findElement(By.linkText("Log in"));
	
	LoginLink.click(); 
	
	WebElement UserName = driver.findElement(By.name("user_login"));
	
	WebElement password = driver.findElement(By.id("password"));
	WebElement LoginBtn = driver.findElement(By.name("btn_login"));
	WebElement Rememberme =driver.findElement(By.className("Rememberme"));
	UserName.sendKeys("xyz@abc.com");
	password.sendKeys("Abc@12345");
	Rememberme.click();
	LoginBtn.click();
	
	WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
	
	String ActualMsg =ErrorMsg.getText();
	String ExpMsg = "The email or password you have enterd is invalid.";
	

	if(ActualMsg.equals(ExpMsg)) {
		System.out.println("TC Passed");
	}else {
		System.out.println("TC Failed");
	}
	
	List<WebElement>links = driver.findElements(By.tagName("a"));
	System.out.println("Total Link are" + links.size());
	
	for (WebElement elm : links ) //array list method//
		{ 
		System.out.println(elm.getAttribute("href"));
	}
	

	
	//driver.close();
	}

}
