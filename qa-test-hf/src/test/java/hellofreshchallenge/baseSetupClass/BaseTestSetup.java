package hellofreshchallenge.baseSetupClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class BaseTestSetup {

	String timestamp = String.valueOf(new Date().getTime());

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected String baseUrl = "http://automationpractice.com/index.php";

	protected String existingUserEmail = "hf_challenge_123456@hf12345.com";
	protected String existingUserPassword = "12345678";
	protected String fullName = "Joe Black";

	protected String name = "Firstname";
	protected String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
	protected String surname = "Lastname";
	String webdriver = "chrome";

	private final String WORKING_DIRECTORY = "//Users/admin//Desktop//";

	public void baseSetup() {

		System.out.println("Running ::: " + webdriver);
		System.out.println("Basesetup called at: " + System.currentTimeMillis());
		switch (webdriver) {
		case "firefox":
			setup_firefox();
			break;
		case "chrome":
			setup_chrome();
			break;
		default:
			throw new RuntimeException("Unsupported webdriver: " + webdriver);
		}
		// setup_firefox();
	}

	public void setup_chrome() {

		if (this.driver != null)
			return;

		System.setProperty("webdriver.chrome.driver",
				WORKING_DIRECTORY + "qa-test-hf//src//test//java//com//hellofreshchallenge//resources//chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10, 50);
	}

	public void setup_firefox() {

		System.setProperty("webdriver.gecko.driver",
				WORKING_DIRECTORY + "qa-test-hf//src//test//java//com//hellofreshchallenge//resources//geckodriver");

		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", false);
		this.driver = new FirefoxDriver(firefoxOptions);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10, 50);

	}

	public void baseTearDown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	    
	}
	
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
	           final byte[] screenshot = ((TakesScreenshot) driver)
	                       .getScreenshotAs(OutputType.BYTES);
	           scenario.embed(screenshot, "image/png");
	   }
	}
	
	
}
