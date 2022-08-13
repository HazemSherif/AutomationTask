package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class JobPositionsPage extends PageBase{

    //private WebDriver driver;
    private By jobTitle = By.className("col-title");
    public JobPositionsPage(WebDriver driver) {
        super(driver);
    }

    public List getJobTitleList(){
       return find_list(jobTitle);
    }

}
