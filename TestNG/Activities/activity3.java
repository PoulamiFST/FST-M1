package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity3 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");

        Reporter.log("Browser opened");
    }
    @Test
    public void mainTest(){
        //Find the input field username and enter "admin"
        driver.findElement(By.id("username")).sendKeys("admin");

        //Find the input field password and enter "password"
        driver.findElement(By.id("password")).sendKeys("password");

        //Click the login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Read the confirmation message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        // make an assertion to check if the correct message has been printed
        Assert.assertEquals(message,"Welcome Back, admin");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
