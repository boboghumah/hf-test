//package hellofreshchallenge.baseSetupClass;
//
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Setup {
//	String timestamp = String.valueOf(new Date().getTime());
//
//	protected WebDriver driver;
//	protected WebDriverWait wait;
//
//	protected String name = "Firstname";
//	protected String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
//	protected String surname = "Lastname";
//
//	public void baseTearDown() {
//		this.driver.manage().deleteAllCookies();
//		this.driver.quit();
//		this.driver = null;
//		this.instance = null;
//	}
//
//	private Setup instance;
//
//	public Setup getInstance() {
//		if (instance == null) {
//			instance = new Setup(null);
//		}
//		return instance;
//	}
//
//	private Setup(WebDriver driver) {
//		this.driver = driver;
//	}
//}
