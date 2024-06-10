package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity9 {
    WebDriver driver;

    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        Reporter.log("Browser opened");
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }

    @Test(priority = 0)
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple alert opened | ");

        //Get text of the alert
        Reporter.log("The simple alert message is :"+driver.switchTo().alert().getText());

        //Assert the text of the alert
        Assert.assertEquals(driver.switchTo().alert().getText(),"This is a JavaScript Alert!");
        //close the alert
        driver.switchTo().alert().accept();
        Reporter.log("Simple alert closed");

    }

    @Test(priority = 1)
    public void confirmAlertTestCase(){
        driver.findElement(By.id("confirm")).click();
        Reporter.log(("Confirm alert opened |"));

        //Get text of the alert
        String confirmalerttext= driver.switchTo().alert().getText();
       Reporter.log("The confirm alert message is :"+confirmalerttext);
        //assert the text
        Assert.assertEquals(confirmalerttext,"This is a JavaScript Confirmation!");

        //close the alert
        driver.switchTo().alert().dismiss();
        Reporter.log("Confirm alert closed");

    }

    @Test(priority = 2)
    public void promptAlertTestCase(){
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt alert opened");

        //Get text of the alert
        String prompttext= driver.switchTo().alert().getText();
        Reporter.log("The prompt alert message is :"+prompttext);
        //assert the text
        Assert.assertEquals(prompttext,"This is a JavaScript Prompt!");
        //close the alert
        driver.switchTo().alert().accept();
        Reporter.log("Prompt alert closed");

    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }

}
