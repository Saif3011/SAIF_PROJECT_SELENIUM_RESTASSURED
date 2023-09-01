package Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import Factory.DriverFactory;
import io.qameta.allure.Allure;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public static void setup() {
		
	driver= new DriverFactory().InitializeDriver();	
	
	}
	
	@AfterMethod
	public static void TearDown(ITestResult result) {
		//on a apporter le nom du testCase
	String TestCaseName=result.getMethod().getMethodName();
	//on a construit le destination File pour qu'il soit dynamique
	File destFile =new File("target" + File.separator + "screenshots" + File.separator + TestCaseName + ".png");
	// on a pris le screenShot
	TakeScreenShot(destFile);
	
		driver.quit();
	}
	
	public static void TakeScreenShot(File destFile) {
		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, destFile);
			//TRANSFORMER EN INPUTSTREAM
			InputStream is = new FileInputStream(destFile);
			//ATTACHER AU RAPPORT
			Allure.addAttachment("screenshots", is);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}	 
	}
}
