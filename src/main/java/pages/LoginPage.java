package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{
   // private WebDriver driver;
    private By emailField = By.id("admin_user_email");
    private By passwordField = By.id("admin_user_password");
    private By loginButton = By.id("admin_user_submit_action");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailField(String text){type(emailField,text);}
    public void setPasswordField(String text){type(passwordField,text);}
    //public LoginPage(WebDriver driver){this.driver = driver;}

    public DashBoardPage clickLoginButton(){
        click_on(loginButton);
        return new DashBoardPage(driver);
    }
}
