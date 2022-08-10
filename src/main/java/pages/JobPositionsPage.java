package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class JobPositionsPage {

    private WebDriver driver;

    public JobPositionsPage(WebDriver driver){
        this.driver = driver;
    }
    private By jobTitle = By.className("col-title");

    public List getJobTitleList(){
       return driver.findElements(jobTitle);
    }

}
