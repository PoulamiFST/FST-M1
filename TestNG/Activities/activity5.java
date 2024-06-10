package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class activity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)

    public void setup(){
        //Installing Geckodriver
        //Initialize Firefox driver
        //Open the page

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");

        Reporter.log("Browser opened");
    }

    @Test(groups = {"HeaderTests","ButtonTests"})
    public void homepageTest(){
        System.out.println(driver.getTitle());

        //Get and assert the title of the page
        Assert.assertEquals(driver.getTitle(), "Target Practice");
        Reporter.log("Home page opened");
    }

    @Test(dependsOnMethods = {"homepageTest"}, groups = {"HeaderTests"})
    public void HeaderTestone(){
        //Find the third header
        String text = driver.findElement(By.id("third-header")).getText();
        //Assert the text
        Assert.assertEquals(text,"Third header");

    }

    @Test(dependsOnMethods = {"homepageTest"}, groups = {"HeaderTests"})
    public void HeaderTestTwo(){
        //Find the  header
        WebElement header= driver.findElement(By.cssSelector("h3#third-header"));
        //Assert the color
        String color = header.getCssValue("color");
        Assert.assertEquals(color,"rgb(251, 189, 8)");

    }

    @Test(dependsOnMethods = {"homepageTest"}, groups = {"ButtonTests"})
    public void ButtonTestone(){
        //Find the olive button
        String buttontext= driver.findElement(By.cssSelector("button.olive")).getText();
        //Assert the text
        Assert.assertEquals(buttontext,"Olive");

    }

    @Test(dependsOnMethods = {"homepageTest"}, groups = {"ButtonTests"})
    public void ButtonTestTwo(){
        //Find the first button of third row
        WebElement button = driver.findElement(By.cssSelector("button.brown"));
        String bgcolor= button.getCssValue("background-color");
        //Assert the color
        Assert.assertEquals(bgcolor,"rgb(165, 103, 63)");


    }


    @AfterClass(alwaysRun = true)

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }
}
