package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
    private WebDriver driver;
    private By statusAlert = By.className("flash");
    private By interviewerPageLink = By.linkText("Interviewers");


    public DashBoardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

    public InterviewerPage clickInterviewerPage(){
        driver.findElement(interviewerPageLink).click();
        return new InterviewerPage(driver);
    }
}
