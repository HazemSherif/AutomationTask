package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageBase {
    WebDriver driver;
    public PageBase(WebDriver driver){ this.driver = driver;}
    void click_on(By by){driver.findElement(by).click();}
    void type(By by,String text){ driver.findElement(by).sendKeys(text);}
    String getFieldText(By by){ return driver.findElement(by).getText();}
    Boolean displayed (By by){ return driver.findElement(by).isDisplayed();}
    void clear_field(By by){driver.findElement(by).clear();}

    Select create_select(By by){
        WebElement text = driver.findElement(by);
         Select dropdown = new Select(text);
         return dropdown;
    }
    String get_attribute(By by,String text){
       return driver.findElement(by).getAttribute(text);
    }

    void implicitWait(int i){
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }

    List find_list(By by){ return driver.findElements(by);}
}
