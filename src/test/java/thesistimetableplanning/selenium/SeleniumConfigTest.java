package thesistimetableplanning.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumConfigTest {

	private WebDriver driverFirefox;
	//private WebDriver driverChrome;
	
	public SeleniumConfigTest() {
		Capabilities capabilities = DesiredCapabilities.firefox();
		Capabilities capabilitiesChrome = DesiredCapabilities.chrome();
		driverFirefox = new FirefoxDriver(capabilities);
		//driverChrome = new ChromeDriver(capabilitiesChrome);
		driverFirefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver() {
		return driverFirefox;
	}
	
	static {
		System.setProperty("webdriver.gecko.driver", findFile("geckodriver.exe"));
		//System.setProperty("webdriver.chrome.driver", findFile("chromedriver.exe"));
	}
	
	static private String findFile(String filename) {
		String paths[] = {"", "bin/", "target/classes", "webdrivers/"};
		for (String path : paths) {
			if (new File(path + filename).exists()) {
				return path + filename;
			}
		}
		return "";
	}
}
