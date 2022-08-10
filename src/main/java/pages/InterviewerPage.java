package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InterviewerPage {
    private WebDriver driver;
    private By newInterviewerButton = By.linkText("New Interviewer");
    private By pageTitle = By.id("page_title");
    private By Alert = By.className("flashes");
    private By interviewerEmailList = By.className("col-email");


    public InterviewerPage(WebDriver driver){
        this.driver = driver;
    }


    public boolean isNewInterviewerButtonDisplayed(){
       return driver.findElement(newInterviewerButton).isDisplayed();
    }
    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public boolean isAlertDisplayed(){
        return driver.findElement(Alert).isDisplayed();
    }
    public String getAlertText(){
        return driver.findElement(Alert).getText();
    }
    public String getFirstInterviewerEmail(){
        List< WebElement> emailList = driver.findElements(interviewerEmailList);
        return emailList.get(1).getText();
    }

    public CreateNewInterviewerPage clickNewInterviewerButton(){
        driver.findElement(newInterviewerButton).click();
        return new CreateNewInterviewerPage(driver);
    }
}
