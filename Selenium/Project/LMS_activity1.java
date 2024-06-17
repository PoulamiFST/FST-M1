package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LMS_activity1 {
    WebDriver driver;

    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/lms/");

        Reporter.log("Browser opened");
    }

    @Test
    public void getpagetitle(){
        Assert.assertEquals(driver.getTitle(), "Alchemy LMS – An LMS Application");
    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }
}
