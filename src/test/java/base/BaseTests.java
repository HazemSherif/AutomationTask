package base;

import Drivers.DriverManager;
import Drivers.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;

public class BaseTests {
    DriverManager driverManager;
     WebDriver driver;
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverManagerFactory.DriverType.CHROME);
        driver = driverManager.getDriver();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://interns:interns@api.questionbank-test.espace.ws/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }
   /* @AfterTest
    public void teardown(){
        driver.quit();
    }*/

}

