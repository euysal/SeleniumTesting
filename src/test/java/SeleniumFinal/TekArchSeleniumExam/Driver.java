package SeleniumFinal.TekArchSeleniumExam;
/* Run 10 SFDC test cases back to back */


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

	static WebDriver driver;
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		/*AutomationScripts.Login_To_SalesForce();
		AutomationScripts.Login_Error_Message();*/
		String dtTablePath = "./excel/TestSuit.xls";

		String[][] recData = ReUsableMethods.readExcel(dtTablePath, "Sheet1");
		
		String testCase, flag, firefox, chrome;
       for(int i = 1; i <recData.length; i++){
			
			flag = recData[i][1];
			if(flag.equalsIgnoreCase("Y")){
				firefox = recData[i][3];
				if(firefox.equalsIgnoreCase("Y")){
					testCase = recData[i][2];
					ReUsableMethods.startReport(testCase, "./report/firefox");
					System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");
					driver = new FirefoxDriver();
					Method tc = AutomationScripts.class.getMethod(testCase);
					tc.invoke(tc);
					driver.quit();

					ReUsableMethods.bw.close();
				}
				
				chrome = recData[i][4];
				if(chrome.equalsIgnoreCase("Y")){
					testCase = recData[i][2];
					ReUsableMethods.startReport(testCase,"./report/chrome");
					System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
					driver = new ChromeDriver();
					Method tc = AutomationScripts.class.getMethod(testCase);
					tc.invoke(tc);
					driver.quit();

					ReUsableMethods.bw.close();
				}
				
				
				
			}
			


		}
		






		/*Method testCase = AutomationScripts.class.getMethod(tc);
		testCase.invoke(testCase); */


	}
}
	