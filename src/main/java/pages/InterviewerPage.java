package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InterviewerPage extends PageBase{
    //private WebDriver driver;
    private By newInterviewerButton = By.linkText("New Interviewer");
    private By pageTitle = By.id("page_title");
    private By Alert = By.className("flashes");
    private By interviewerEmailList = By.className("col-email");

    public InterviewerPage(WebDriver driver) {
        super(driver);
    }


    public boolean isNewInterviewerButtonDisplayed(){
       return displayed(newInterviewerButton);
    }
    public String getPageTitle(){
        return getFieldText(pageTitle);
    }
    public boolean isAlertDisplayed(){
        return displayed(Alert);
    }
    public String getAlertText(){return getFieldText(Alert);}
    public String getFirstInterviewerEmail(){
        List< WebElement> emailList = driver.findElements(interviewerEmailList);
        return emailList.get(1).getText();
    }

    public CreateNewInterviewerPage clickNewInterviewerButton(){
        click_on(newInterviewerButton);
        return new CreateNewInterviewerPage(driver);
    }
}
