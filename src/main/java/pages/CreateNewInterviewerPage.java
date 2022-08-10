package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewInterviewerPage {
    private WebDriver driver;
    private By emailField = By.id("interviewer_email");
    private By firstNameField = By.id("interviewer_first_name");
    private By lastnameField = By.id("interviewer_last_name");
    private By ddl = By.id("interviewer_job_position_id");
    public CreateNewInterviewerPage( WebDriver driver){ this.driver = driver;}
    private By createInterviewerButton = By.id("interviewer_submit_action");
    private By cancelButton = By.linkText("Cancel");
    private By updateButton = By.name("commit");
    private By errorMessages = By.className("inline-errors");
    private By jobPositionsButton = By.linkText("Job Positions");



    // set text fields
    public void setEmailFieldText(String text){
        driver.findElement(emailField).sendKeys(text);
    }
    public void setFirstNameFieldText(String text){
        driver.findElement(firstNameField).sendKeys(text);
    }
    public void setLastNameFieldText(String text){
        driver.findElement(lastnameField).sendKeys(text);
    }
    public String getUpdateButtonText(){
        return driver.findElement(updateButton).getAttribute("value");
    }

    // get data
    public String getErrorMessage(int i){
        List< WebElement> errorsList = driver.findElements(errorMessages);
        return errorsList.get(i).getText();
    }

    // clear fields
    public void clearEmailFieldText(){
        driver.findElement(emailField).clear();
    }
    public void clearFirstNameFieldText(){
        driver.findElement(firstNameField).clear();
    }
    public void clearLastNameFieldText(){
        driver.findElement(lastnameField).clear();
    }

   // dropdown menu
   public List getJobPositionList(){
       WebElement jobPositionDropDownMenu = driver.findElement(ddl);
       Select dropdown = new Select(jobPositionDropDownMenu);
       return dropdown.getOptions();

   }
    public void selectJobPosition(String text){
        WebElement jobPositionDropDownMenu = driver.findElement(ddl);
        Select dropdown = new Select(jobPositionDropDownMenu);
        dropdown.selectByVisibleText(text);
    }
    public void deselectJobPosition(String text){
        WebElement jobPositionDropDownMenu = driver.findElement(ddl);
        Select dropdown = new Select(jobPositionDropDownMenu);
        dropdown.deselectByValue(text);
    }

    public InterviewerPage clickCreateNewInterviewerButton(){
        driver.findElement(createInterviewerButton).click();
        return new InterviewerPage(driver);
    }
    public InterviewerPage clickCancelButton(){
        driver.findElement(cancelButton).click();
        return new InterviewerPage(driver);
    }

    public JobPositionsPage clickJobPositionsPage(){
        driver.findElement(jobPositionsButton).click();
        return new JobPositionsPage(driver);
    }

}
