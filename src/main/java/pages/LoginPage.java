package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
    private WebDriver driver;
    private By emailField = By.id("admin_user_email");
    private By passwordField = By.id("admin_user_password");
    private By loginButton = By.id("admin_user_submit_action");

    public void setEmailField(String text){
        driver.findElement(emailField).sendKeys(text);
    }
    public void setPasswordField(String text){
        driver.findElement(passwordField).sendKeys(text);
    }


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public DashBoardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashBoardPage(driver);
    }
}
