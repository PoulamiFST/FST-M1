package Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LMS_activity4 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        wait = new WebDriverWait (driver, Duration.ofSeconds(20));

        driver.get("https://alchemy.hguy.co/lms/");

        Reporter.log("Browser opened");
    }

    @Test

    public void getsecondcoursetitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Learn from Industry Experts ']")));
        WebElement firstinfobox = driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']"));
        Assert.assertEquals(firstinfobox.getText(),"Email Marketing Strategies");



    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }
}
