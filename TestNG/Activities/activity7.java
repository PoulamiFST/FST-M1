package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class activity7 {

    WebDriver driver;
    WebDriverWait wait;



    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");

        Reporter.log("Browser opened");


    }


    @DataProvider(name = "creds")
    public Object[][] credentials(){
        return new Object[][]{
                {"admin", "password", "Welcome Back, admin"},
                {"admin12", "password", "Invalid Credentials"},
                {"  ", "----", "Invalid Credentials"}

        };

    }

    @Test(dataProvider = "creds" )
    public void loginTest(String username, String password, String message){


        //clear the fields

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();



        //Enter username and password

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);


        //Click log in

        driver.findElement(By.cssSelector("button[type='submit']")).click();


        //Get the confirmation message and assert
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage,message);

    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }

}
