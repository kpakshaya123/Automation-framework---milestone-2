package orangehrm.basetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import orangehrm.configreader.ConfigReader;
import orangehrm.driverfactory.DriverFactory;
import org.testng.Reporter;

public class BaseTest {
	protected WebDriver driver;
//	@BeforeClass
	//public void beforeClass() {
		//try {
//			//WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
		//	driver.manage().window().maximize();
	//	}catch(Exception e) {
		//	e.printStackTrace();
	//	}
//	}
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser) {
		Reporter.log("Browser is opening "+browser,true);
		try {
			DriverFactory.initDriver(browser);
			driver = DriverFactory.getDriver();
			driver.get(ConfigReader.get("base.url"));
			Thread.sleep(5000);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		Reporter.log("Browser is closing",true);
		try {
			DriverFactory.quitDriver();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
	}
}

