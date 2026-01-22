package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class BaseClass {

	PropertiesFileUtility putil = new PropertiesFileUtility();

	ExcelFileUtilitie eutil = new ExcelFileUtilitie();

	WebDriverUtility wutil = new WebDriverUtility();

	public WebDriver driver = null;
	// int a;
	public static WebDriver sDriver;

//int b;static driver
	@BeforeSuite(groups = { "smoke", "regression" })
	public void beforesuiteconfig() {
		System.out.println("--------Database connection established------");
	}

	// @Parameters("browser")
	// @BeforeTest
	@BeforeClass(groups = { "smoke", "regression" }) // launch the browser
	public void beforeclassCofig(/* String BROWSER */) throws IOException {
		// parameter passit here BROWSER IN THE TOP
		String BROWSER = putil.toReadDataFromPropertyfile("browser");
		String URL = putil.toReadDataFromPropertyfile("url");
		if (BROWSER.equals("chrome")) {
			// a=10;initialise the driver ;variable driver
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}//sdriver is static vaiable
		sDriver = driver;// listeners b=a   here driver is assigned to static driver
		System.out.println("Browser got launched");
		wutil.tomaximize(driver);
		System.out.println("Browser got maximized");
		wutil.toImplicitWait(driver);
		driver.get(URL);
	}

	@BeforeMethod(groups = { "smoke", "regression" }) // login//group excution run inciude
	// that time group before anotation time regrretion time smoke time

	public void beforeMethodConfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyfile("username");
		String PASSWORD = putil.toReadDataFromPropertyfile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextfield().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		System.out.println("Login in to vtiger succusfully");
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void aftermethodConfig() {// logout
		HomePage hp = new HomePage(driver);
		wutil.toMouseHover(driver, hp.getLogoutelement());
		hp.getSignout().click();
		System.out.println("logged from vtiger succusfully");
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void afterClassconfig() {
		System.out.println("Browser got closed succusfully");
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void afterSuiteConfig() {
		System.out.println("database connection dissconected");
	}
}
