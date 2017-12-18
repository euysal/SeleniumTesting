package SeleniumFinal.TekArchSeleniumExam;


import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class AutomationScripts extends ReUsableMethods{
	
	@Test
	public static void Login_To_SalesForce () throws IOException {
		System.out.println("------------------");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
		//enterText("Pass", "enterText", textVal+ " is entered in " + objName + " field");
		enterText(userName, "user@gmail.com", "UserName");
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		enterText(password, "Password123", "Password");

		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickObj(login, "Login");
		
		bw.close();			
	}
	
	@Test
	public static void Login_Error_Message() throws IOException{
		System.out.println("login error message method git hub");
	}
	
	@Test
	public static void Demo1(){
		System.out.println("Thank you. git hub.");
	}
	
	@Test
	public static void Demo2(){
		System.out.println("Thank you..");
	}
	
	@Test
	public static void Demo3(){
		System.out.println("Thank you..");
	}

}
