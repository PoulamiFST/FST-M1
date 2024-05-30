package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity5 {


    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        String pagetitle= driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        //perform left click
        builder.click().pause(1000).build().perform();
        String firstText = driver.findElement(By.className("active")).getText();
        System.out.println("First text:" +firstText);

        //perform double click
        builder.doubleClick().pause(1000).build().perform();
        String secondText = driver.findElement(By.className("active")).getText();
        System.out.println("Second text:" +secondText);

        //perform right click

        builder.contextClick().pause(1000).build().perform();
        String thirdText = driver.findElement(By.className("active")).getText();
        System.out.println("Third text:" +thirdText);




        // Close the browser

        driver.quit();
    }
}


