package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {
    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will click on login
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will get the text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
}
