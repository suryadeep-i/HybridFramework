package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	private Properties prop;
	
	
	@Before(order =0)
	public void getProperty() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}
	
	@Before(order =1)
	public void launchBrowser() {
		String browserName=prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver=driverfactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
		}
	}

}
