package base;


import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.CreateNewInterviewerPage;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.PageBase;

public class BaseTests {
     WebDriver driver;
    protected LoginPage loginPage;
    protected PageBase pageBase;
    @BeforeTest
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("");
        driver.manage().window().maximize();
        pageBase = new PageBase(driver);
        loginPage = new LoginPage(driver);
    }
    @BeforeMethod
    public void login(){
        loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }


    public String[] fakeData()
    {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String[] arr = {email,firstName, lastName};
        return arr;
    }

    public String[] type_in_fields(CreateNewInterviewerPage newInterviewerPage){
        String[] text_fields = fakeData();
        newInterviewerPage.setEmailFieldText(text_fields[0]);
        newInterviewerPage.setFirstNameFieldText(text_fields[1]);
        newInterviewerPage.setLastNameFieldText(text_fields[2]);
        newInterviewerPage.selectJobPosition("007");
        return text_fields;
    }

}

