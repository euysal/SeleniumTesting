

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class AutomationScripts extends ReUsableMethods{
	
public static String dtTablePath = "./excel/TestSuit.xls";
	
////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId01_A() throws IOException, InterruptedException {
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		String psswrd=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","password");
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);  // get this one from excel
			
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, username, "UserName");
			
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, psswrd, "Password");
	
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			
			sleepZzz(3000);
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();		
		}catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
	   }
	}
////////////////////////////////////////////////////////////////////////////////////////	
	
	public static void testId01_B() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		String Incorrect_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","Incorrect_password");
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);  // get this one from excel
			
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName,username, "UserName");
			
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, Incorrect_password, "Password");
	
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			
			sleepZzz(3000);
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();	
	    }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
	   }
	}
////////////////////////////////////////////////////////////////////////////////////////	
   
	public static void testId01_C() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String Incorrect_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","Incorrect_username");
		String passwordData=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","password");
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);  // get this one from excel
			
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, Incorrect_username, "UserName");
			
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, passwordData, "Password");
	
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			
			sleepZzz(3000);
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();	
		}catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
		}
	}	
 /////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId01_D() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);  // get this one from excel
			WebElement frgt=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a"));
			clickObj(frgt, "forgot your password");
			
			sleepZzz(500);
			WebElement email=driver.findElement(By.id("UserName"));
			enterText(email, username, "email address");
			
			sleepZzz(500);
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
		}catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
		}
		
	}	
///////////////////////////////////////////////////////////////////////////////////////////////
   
	public static void testId02_A() throws IOException, InterruptedException, AWTException{
		String url_us = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_us");
		String fnameExcel = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","first_name");
		String lnameExcel = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","last_name");
		String emailExcel = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","email");
		String phoneExcel = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","phone_number");
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url_us);
			WebElement free=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(free, "free trial button");
			sleepZzz(500);
			WebElement fname=driver.findElement(By.name("FirstName"));
			enterText(fname, fnameExcel, "first name");
			WebElement lname=driver.findElement(By.name("LastName"));
			enterText(lname, lnameExcel, "last name");
			WebElement email=driver.findElement(By.name("EmailAddress"));
			enterText(email, emailExcel, "email address");
			WebElement phone=driver.findElement(By.name("PhoneNumber"));
			enterText(phone, phoneExcel, "phone number");
			WebElement selectMenu=driver.findElement(By.name("LocationCode"));
			Select selectCountry=new Select(selectMenu);
			selectCountry.selectByValue("US");
			
			WebElement chckbox=driver.findElement(By.name("TermsAccepted"));
			is_selected(chckbox, "aggrement checkbox");
			
			WebElement started=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span"));
			clickObj(started, "get started button");
			sleepZzz(500);
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
	    }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
	  }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	// highlight learn it 
	public static void testId02_B() throws IOException, InterruptedException{
		String url_us = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_us");
		WebDriverWait wait=new WebDriverWait(driver, 60);
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_us);
			WebElement free=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(free, "free trial button");
			sleepZzz(500);
	
			WebElement started=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span"));
			clickObj(started, "get started button");
			//System.out.println("clickable..... "+started.isEnabled());
			//is_enabled(started, " get started button ");
			//is_displayed(started, " get started button ");
			
			sleepZzz(5000);
			WebElement fname=driver.findElement(By.id("signup-form-error-messege-1")); 
			is_displayed(fname, "first name error ");
			WebElement lname=driver.findElement(By.id("signup-form-error-messege-2")); 
			is_displayed(lname, "last name error ");
			WebElement email=driver.findElement(By.id("signup-form-error-messege-3")); 
			is_displayed(email, "email error ");
			WebElement phone=driver.findElement(By.id("signup-form-error-messege-4")); 
			is_displayed(phone, "phone error ");
			//System.out.println(phone.getText());
			
			WebElement emailbox=driver.findElement(By.name("EmailAddress"));
			enterText(emailbox, "#$%^&", "email address");
			WebElement emailInvalid=driver.findElement(By.id("signup-form-error-messege-3")); 
            is_displayed(emailInvalid, "Invalid email error");
            WebElement started2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span")));
			clickObj(started2, "get started button");
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
	    }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
	  }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId02_C() throws IOException, InterruptedException{
		String url_us = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_us");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("url_us");
			WebElement free=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(free, "free trial button");
			sleepZzz(500);
			WebElement terms=driver.findElement(By.linkText("terms of use"));
			clickObj(terms, "terms of use");
			js.executeScript("window.history.go(-1)");
			WebElement policy=driver.findElement(By.linkText("privacy policy"));
			clickObj(policy, "terms of use");
			js.executeScript("window.history.go(-1)");
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId02_D() throws IOException, InterruptedException{
		String url_us = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_us");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("url_us");
			WebElement free=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(free, "free trial button");
			sleepZzz(500);
			WebElement offer=driver.findElement(By.linkText("offer details"));
			clickObj(offer, "offer details link");
			js.executeScript("window.history.go(-1)");
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId02_E() throws IOException, InterruptedException{
		String url_us = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_us");
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("url_us");
			WebElement free=driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a"));
			clickObj(free, "free trial button");
			sleepZzz(500);
			WebElement bookkeeper=driver.findElement(By.linkText("accountant or bookkeeper"));
			clickObj(bookkeeper, "accountant or bookkeeper link");
			js.executeScript("window.history.go(-1)");
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId03_A() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		String psswrd=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","password");
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login); 
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, psswrd, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			WebElement dasb = driver.findElement(By.linkText("Dashboard"));
			clickObj(dasb, "Dashboard tab");
			WebElement account = driver.findElement(By.id("Accounts"));
			clickObj(account, "Accounts tab"); sleepZzz(500);
			WebElement report = driver.findElement(By.id("Reports"));
			clickObj(report, "Report tab"); sleepZzz(500);
			WebElement contacts = driver.findElement(By.id("Contacts"));
			clickObj(contacts, "Contacts tab"); sleepZzz(500);
			WebElement settings = driver.findElement(By.id("Settings"));
			clickObj(settings, "Settings tab"); sleepZzz(500);
			WebElement newtab = driver.findElement(By.id("quicklaunchTab"));
			clickObj(newtab, "+/New tab"); sleepZzz(500);
			WebElement files = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a"));
			clickObj(files, "Files button"); sleepZzz(500);
			WebElement noti = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a"));
			clickObj(noti, "Notification button"); sleepZzz(500);
			WebElement search = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a"));
			clickObj(search, "Search button"); sleepZzz(500);
			WebElement help = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a"));
			clickObj(help, "Help button"); sleepZzz(500);
				
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId04_A() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		String psswrd=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","password");
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login); 
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, psswrd, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			WebElement userdropdown = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
			clickObj(userdropdown, "User drop down menu");
			WebElement logout = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a"));
			clickObj(logout, "Logout");
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId05_A() throws IOException, InterruptedException{
		System.out.println("Thank you, this test case is empthy");
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	// upload picture  - new window trouble 
	public static void testId06_A() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		String psswrd=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","password");
		String image="./target/puppy.jpg";
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login); 
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, psswrd, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			WebElement userdropdown = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a"));
			clickObj(userdropdown, "User drop down menu");
			WebElement profile = driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[1]/a"));
			clickObj(profile, "Profile");
			String parentWindow=driver.getWindowHandle();
			WebElement uploadImage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='button-1041-btnInnerEl']")));
			clickObj(uploadImage, "Upload Image button");
			sleepZzz(1000);
			Set<String> handles=driver.getWindowHandles();
			for(String windowshandle: handles){
				if(!windowshandle.equals(parentWindow)){
					driver.switchTo().window(windowshandle);
					// perform operation in here on new window
					WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='filefield-1202-button-fileInputEl']"))); // buttonid=filefield-1202-button-fileInputEl
					browse.sendKeys(image);
					WebElement upload=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='button-1206-btnInnerEl']")));
					clickObj(upload, "Upload button");
					driver.close();
					
					driver.close();
					driver.switchTo().window(parentWindow);
				}
			
			}

			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId08_A() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String given_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_username");
		String given_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_password");
		String nameSelf=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_name");
		String nameUS=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_country");
		String timePST=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","time_zone");
		String whatdo=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","what_org_do");
		WebDriverWait wait=new WebDriverWait(driver, 60);
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, given_username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, given_password, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement topMenu=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			clickObj(topMenu, "Top Menu tab");
			WebElement myXero=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
			clickObj(myXero, "my Xero button");
			WebElement addOrg=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ext-gen1043']")));
			clickObj(addOrg, "Add an organization button");
			sleepZzz(500);
			
			WebElement orgName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='text-1022-inputEl']")));
			//orgName.sendKeys(nameSelf);
			sleepZzz(500);
			enterText(orgName,nameSelf, "Organization name");
			WebElement orgCountry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='countryCmb-inputEl']")));
			sleepZzz(500);
			enterText(orgCountry,nameUS, "Organization's country name");
			WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTimeZone-inputEl']")));
			sleepZzz(500);
			enterText(time,timePST, "Time zone");
			WebElement doing=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")));
			sleepZzz(500);
			enterText(doing,whatdo, "organization what to do ");
			
			//driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
			//driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[2]"));
			sleepZzz(1000);
			WebElement startTrial=driver.findElement(By.linkText("Start Trial"));
			clickObj(startTrial, "Start Trial button");
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId08_B() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String given_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_username");
		String given_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_password");
		String nameSelf=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_name");
		String nameUS=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_country");
		String timePST=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","time_zone");
		String whatdo=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","what_org_do");
		WebDriverWait wait=new WebDriverWait(driver, 60);
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, given_username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, given_password, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement topMenu=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			clickObj(topMenu, "Top Menu tab");
			WebElement myXero=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
			clickObj(myXero, "my Xero button");
			WebElement addOrg=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ext-gen1043']")));
			clickObj(addOrg, "Add an organization button");
            sleepZzz(500);
			
			WebElement orgName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='text-1022-inputEl']")));
			//orgName.sendKeys(nameSelf);
			sleepZzz(500);
			enterText(orgName,nameSelf, "Organization name");
			WebElement orgCountry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='countryCmb-inputEl']")));
			sleepZzz(500);
			enterText(orgCountry,nameUS, "Organization's country name");
			WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTimeZone-inputEl']")));
			sleepZzz(500);
			enterText(time,timePST, "Time zone");
			WebElement doing=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")));
			sleepZzz(500);
			enterText(doing,whatdo, "organization what to do ");
			
			// fill out the form copy, from 8-A
			
			WebElement buyNow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='simplebutton-1036']")));
			clickObj(buyNow, "Buy Now button");
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId08_C() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String given_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_username");
		String given_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_password");
		
		String nameSelf=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_name");
		String nameUS=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_country");
		String timePST=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","time_zone");
		String whatdo=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","what_org_do");
		
		String street_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","street");
		String city_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","city");
		String state_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","state");
		String zipcode_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","zipcode");
		
		String card_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_card_no");
		String name_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_owner_name");
		String expDate_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_exp_date");
		String security_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_security");
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, given_username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, given_password, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement topMenu=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			clickObj(topMenu, "Top Menu tab");
			WebElement myXero=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
			clickObj(myXero, "my Xero button");
			WebElement addOrg=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ext-gen1043']")));
			clickObj(addOrg, "Add an organization button");
            sleepZzz(500);
			
			WebElement orgName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='text-1022-inputEl']")));
			enterText(orgName,nameSelf, "Organization name");
			sleepZzz(1000);
			WebElement orgCountry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='countryCmb-inputEl']")));
			enterText(orgCountry,nameUS, "Organization's country name");
			sleepZzz(1000);
			WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTimeZone-inputEl']")));
			enterText(time,timePST, "Time zone");
			sleepZzz(1000);
			WebElement doing=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")));
			enterText(doing,whatdo, "organization what to do ");
			sleepZzz(1000);
	
			WebElement buyNow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='simplebutton-1036']")));
			clickObj(buyNow, "Buy Now button");
			sleepZzz(1000);

			WebElement radioplan=driver.findElement(By.id("StarterPlanId"));
			boolean status=radioplan.isDisplayed(); System.out.println(status + "  display");
			radioplan.click();
			WebElement continueNext=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button']")));
			clickObj(continueNext, "Continue to billing details");
			sleepZzz(1000);
			
			WebElement street=driver.findElement(By.id("POAddress"));
			enterText(street, street_data, "Street info"); 
			WebElement city=driver.findElement(By.id("POCity"));
			enterText(city, city_data, "City info");
			WebElement state=driver.findElement(By.id("PORegionDropdown"));
			enterText(state, state_data, "State info");
			WebElement zipcode=driver.findElement(By.id("POPostalCode"));
			enterText(zipcode, zipcode_data, "Zipcode info"); sleepZzz(5000);
			
			WebElement continueNext2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button")));
			clickObj(continueNext2, "Continue to billing details");
			sleepZzz(1000);
			
			WebElement cardno=driver.findElement(By.xpath(".//*[@id='root']/form/span[2]/label/input"));
			enterText(cardno, card_credit, "Card number");
			WebElement expiry=driver.findElement(By.id("card-expiry"));
			enterText(expiry, expDate_credit, "Expiration date"); 
			WebElement secure=driver.findElement(By.id("card-cvc"));
			enterText(secure, security_credit, "Security code"); 
			WebElement nameHolder=driver.findElement(By.id("cardholder-name"));
			enterText(nameHolder, name_credit, "Name on card-Owner"); 
			
			WebElement payment=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='authoriseStripeButton']")));
			clickObj(payment, "Authorize Payment");
			sleepZzz(1000);
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId08_D() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String given_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_username");
		String given_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_password");
		
		String nameSelf=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_name");
		String nameUS=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_country");
		String timePST=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","time_zone");
		String whatdo=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","what_org_do");
		
		String street_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","street");
		String city_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","city");
		String state_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","state");
		String zipcode_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","zipcode");
		
		String card_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_card_no");
		String name_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_owner_name");
		String expDate_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_exp_date");
		String security_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_security");
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, given_username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, given_password, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement topMenu=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			clickObj(topMenu, "Top Menu tab");
			WebElement myXero=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
			clickObj(myXero, "my Xero button");
			WebElement addOrg=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ext-gen1043']")));
			clickObj(addOrg, "Add an organization button");
            sleepZzz(500);
			
			WebElement orgName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='text-1022-inputEl']")));
			enterText(orgName,nameSelf, "Organization name"); sleepZzz(500);
			WebElement orgCountry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='countryCmb-inputEl']")));
			enterText(orgCountry,nameUS, "Organization's country name");  	sleepZzz(500);
			WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTimeZone-inputEl']")));
			enterText(time,timePST, "Time zone"); sleepZzz(500);
			WebElement doing=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")));
			enterText(doing,whatdo, "organization what to do ");	 sleepZzz(500);	
			
			WebElement buyNow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='simplebutton-1036']")));
			clickObj(buyNow, "Buy Now button");
			sleepZzz(1000);
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId08_E() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String given_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_username");
		String given_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_password");
		
		String nameSelf=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_name");
		String nameUS=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_country");
		String timePST=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","time_zone");
		String whatdo=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","what_org_do");
		
		String street_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","street");
		String city_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","city");
		String state_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","state");
		String zipcode_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","zipcode");
		
		String card_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_card_no");
		String name_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_owner_name");
		String expDate_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_exp_date");
		String security_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_security");
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, given_username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, given_password, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement topMenu=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			clickObj(topMenu, "Top Menu tab");
			WebElement myXero=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
			clickObj(myXero, "my Xero button");
			WebElement addOrg=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ext-gen1043']")));
			clickObj(addOrg, "Add an organization button");
            sleepZzz(500);
			
			WebElement orgName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='text-1022-inputEl']")));
			sleepZzz(500);
			enterText(orgName,nameSelf, "Organization name");
			WebElement orgCountry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='countryCmb-inputEl']")));
			sleepZzz(500);
			enterText(orgCountry,nameUS, "Organization's country name");
			WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTimeZone-inputEl']")));
			sleepZzz(500);
			enterText(time,timePST, "Time zone");
			WebElement doing=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")));
			sleepZzz(500);
			enterText(doing,whatdo, "organization what to do ");
					
			WebElement buyNow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='simplebutton-1036']")));
			clickObj(buyNow, "Buy Now button");
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	// software rool dropdown fix it
	public static void testId08_F() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String given_username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_username");
		String given_password=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","given_password");
		
		String nameSelf=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_name");
		String nameUS=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","organization_country");
		String timePST=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","time_zone");
		String whatdo=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","what_org_do");
		
		String street_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","street");
		String city_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","city");
		String state_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","state");
		String zipcode_data=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","zipcode");
		
		String card_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_card_no");
		String name_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_owner_name");
		String expDate_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_exp_date");
		String security_credit=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","credit_security");
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, given_username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, given_password, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement topMenu=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2"));
			clickObj(topMenu, "Top Menu tab");
			WebElement myXero=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div[1]/a"));
			clickObj(myXero, "my Xero button");
			WebElement addOrg=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ext-gen1043']")));
			clickObj(addOrg, "Add an organization button");
            sleepZzz(500);
			
			WebElement orgName=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='text-1022-inputEl']")));
			sleepZzz(500);
			enterText(orgName,nameSelf, "Organization name");
			WebElement orgCountry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='countryCmb-inputEl']")));
			sleepZzz(500);
			enterText(orgCountry,nameUS, "Organization's country name");
			WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTimeZone-inputEl']")));
			sleepZzz(500);
			enterText(time,timePST, "Time zone");
			WebElement doing=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")));
			sleepZzz(500);
			enterText(doing,whatdo, "organization what to do ");
			sleepZzz(700);
			// lu-li list
			WebElement softwareUL= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='combo-1029-inputEl']"))); 
			softwareUL.click();
			driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[3]"));
//			List<WebElement> toolList=softwareUL.findElements(By.tagName("li"));
//			for (WebElement li : toolList) {
//			if (li.getText().equals("QuickBooks Desktop")) {
//			     li.click();
//			   }
//			}
			sleepZzz(500);
			
			WebElement buyNow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='simplebutton-1036']")));
			clickObj(buyNow, "Buy Now button");
			sleepZzz(500);
			
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void testId10_A() throws IOException, InterruptedException{
		String url_login = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","url_login");
		String username = ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","username");
		String psswrd=ReUsableMethods.readExcelKeyValue(dtTablePath, "Sheet2","password");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url_login);
			WebElement userName = driver.findElement(By.id("email"));
			enterText(userName, username, "UserName");
			WebElement password = driver.findElement(By.id("password"));
			enterText(password, psswrd, "Password");
			WebElement login = driver.findElement(By.id("submitButton"));
			clickObj(login, "Login");
			sleepZzz(500);
			
			WebElement accountTab=driver.findElement(By.id("Accounts"));
			clickObj(accountTab, "Account tab");
			WebElement purchases=driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[3]/a"));
			clickObj(purchases, "Purchases Dropdown");
			
			System.out.println("I do not have paid bills yet");
				
			Update_Report("Pass", "last step execution", "Finishes succesfully");
			bw.close();
       }catch(Exception e){
			Update_Report("Fail", "last step execution", "It gives error, please check it again! ");
			bw.close();
       }
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
}
