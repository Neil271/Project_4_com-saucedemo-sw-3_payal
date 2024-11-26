package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    //Set up the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //Verify that user should login successfully with valid credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter “standard_user” for the username
        sendTextToElement(By.id("user-name"), "standard_user");

        //* Enter “secret_sauce” for the password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* Click on the ‘Login’ button
        clickOnElement(By.id("login-button"));

        //* Verify the text “Products”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Products text is not displayed", expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” for the username
        sendTextToElement(By.id("user-name"), "standard_user");

        //* Enter “secret_sauce” for the password
        sendTextToElement(By.id("password"), "secret_sauce");

        //* Click on the ‘Login’ button
        clickOnElement(By.id("login-button"));

        //* Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
        int expectedNoOfProduct = 6;
        Assert.assertEquals("There are more or less than six products displayed on the page ", expectedNoOfProduct, products.size());

    }


    //Close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
