package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateNewInterviewerPage extends PageBase{
   // private WebDriver driver;
    private By emailField = By.id("interviewer_email");
    private By firstNameField = By.id("interviewer_first_name");
    private By lastnameField = By.id("interviewer_last_name");
    private By ddl = By.id("interviewer_job_position_id");
    private By createInterviewerButton = By.id("interviewer_submit_action");
    private By cancelButton = By.linkText("Cancel");
    private By updateButton = By.name("commit");
    private By errorMessages = By.className("inline-errors");
    private By jobPositionsButton = By.linkText("Job Positions");

    public CreateNewInterviewerPage(WebDriver driver) {
        super(driver);
    }


    // set text fields
    public void setEmailFieldText(String text){type(emailField,text);}
    public void setFirstNameFieldText(String text){
        type(firstNameField,text);
    }
    public void setLastNameFieldText(String text){
        type(lastnameField,text);
    }
    public String getUpdateButtonText(){
        return get_attribute(updateButton,"value");
    }

    // get data
    public String getErrorMessage(int i){
        List< WebElement> errorsList = driver.findElements(errorMessages);
        return errorsList.get(i).getText();
    }

    // clear fields
    public void clearEmailFieldText(){
        clear_field(emailField);
    }
    public void clearFirstNameFieldText(){clear_field(firstNameField);}
    public void clearLastNameFieldText(){
        clear_field(lastnameField);
    }

   // dropdown menu
   public List getJobPositionList(){
    /*   WebElement jobPositionDropDownMenu = driver.findElement(ddl);
       Select dropdown = new Select(jobPositionDropDownMenu);*/
       return create_select(ddl).getOptions();
   }
    public void selectJobPosition(String text){
       /* WebElement jobPositionDropDownMenu = driver.findElement(ddl);
        Select dropdown = new Select(jobPositionDropDownMenu);*/
        create_select(ddl).selectByVisibleText(text);
    }
    public void deselectJobPosition(String text){
       /* WebElement jobPositionDropDownMenu = driver.findElement(ddl);
        Select dropdown = new Select(jobPositionDropDownMenu);*/
        create_select(ddl).deselectByValue(text);
    }
    public InterviewerPage clickCreateNewInterviewerButton(){
        click_on(createInterviewerButton);
        return new InterviewerPage(driver);
    }
    public InterviewerPage clickCancelButton(){
        click_on(cancelButton);
        return new InterviewerPage(driver);
    }
    public JobPositionsPage clickJobPositionsPage(){
        click_on(jobPositionsButton);
        return new JobPositionsPage(driver);
    }

}
