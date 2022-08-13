package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends PageBase{
    private By statusAlert = By.className("flash");
    private By interviewerPageLink = By.linkText("Interviewers");

  public DashBoardPage(WebDriver driver) { super(driver);}
    public String getAlertText(){return getFieldText(statusAlert);}
    public InterviewerPage clickInterviewerPage(){
        click_on(interviewerPageLink);
        return new InterviewerPage(driver);
    }
}
