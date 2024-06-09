package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity2 {
    WebDriver driver;

    @BeforeClass

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        Reporter.log("Browser opened");
    }

    @Test
    public void getpagetitle(){
     //Get abd asser the title of the page

        Assert.assertEquals(driver.getTitle(),"Target Practice");
        System.out.println("The title of the page is : "+driver.getTitle());
    }

    @Test
    public void findbalckbutton(){
        WebElement blackbutton= driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackbutton.isDisplayed());
        Assert.assertEquals(blackbutton.getText(),"White");
    }

    @Test(enabled = false)
    public void thirdtestcase(){
       Assert.assertTrue(driver.findElement(By.id("red-button")).isDisplayed());
    }

    @Test
    public void fourthtestcase(){
        throw new SkipException("Skipping this test case");
    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }

}
