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

public class activity1 {
    WebDriver driver;

    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net");

        Reporter.log("Browser opened");
    }

    @Test

    public void homepageTest(){

        //System.out.println(driver.getTitle());

        //Get and assert the title of the page
        Assert.assertEquals(driver.getTitle(), "Training Support");
        Reporter.log("Home page opened");

        //find the "About Us" Button on the page and click it.

        driver.findElement(By.id("about-link")).click();

        //Get and assert the title of the new page

        Assert.assertEquals(driver.getTitle(), "About Training Support");
        Reporter.log("About Us page opened");

    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }

}
