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
import java.util.List;

public class LMS_activity9 {
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

    public void coursecomplete(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Learn from Industry Experts ']")));
        WebElement allcourses = driver.findElement(By.xpath("//a[text()='All Courses']"));
        allcourses.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='All Courses']")));
        Assert.assertEquals(driver.getTitle(),"All Courses – Alchemy LMS");

        //login to enroll
        driver.findElement(By.xpath("//p//a[@href='https://alchemy.hguy.co/lms/courses/social-media-marketing/']")).click();
        Assert.assertEquals(driver.getTitle(), "Social Media Marketing – Alchemy LMS");
        driver.findElement(By.xpath("//a[text()='Login to Enroll']")).click();

        WebElement userName = driver.findElement(By.id("user_login"));
        WebElement passWord = driver.findElement(By.id("user_pass"));
        WebElement loginButton = driver.findElement(By.id("wp-submit"));

        userName.clear();
        userName.sendKeys("root");
        passWord.clear();
        passWord.sendKeys("pa$$w0rd");
        loginButton.click();

        //complete course and verify completion
        WebElement contentLink = driver.findElement(By.xpath("//div//a[@href='https://alchemy.hguy.co/lms/lessons/developing-strategy/']"));
        contentLink.click();
        Assert.assertEquals(driver.getTitle(), "Developing Strategy – Alchemy LMS");

        String completionStatus  = driver.findElement(By.xpath("//span[@class='ld-lesson-list-progress']")).getText();
        Assert.assertEquals(completionStatus, "100% COMPLETE");


        //logout
        driver.findElement(By.xpath("//span//img[contains(@class,'avatar-96')]")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Reporter.log("Newpage loaded");



    }


    @AfterClass

    public void tearDown() {
        //Close the browser
        Reporter.log("Browser closed");

        driver.quit();
    }
}
