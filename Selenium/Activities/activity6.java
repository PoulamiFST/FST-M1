package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity6 {public static void main(String[] args) throws InterruptedException {
    // Setup the Firefox driver(GeckoDriver)
    WebDriverManager.firefoxdriver().setup();

    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
    Actions builder = new Actions(driver);

    // Open the browser
    driver.get("https://v1.training-support.net/selenium/input-events");

    //print the title

    String pagetitle = driver.getTitle();
    System.out.println("Home page title:" + pagetitle);
    Thread.sleep(2000);


    //Press the first letter of my name (P)
    builder.sendKeys("P").build().perform();

    //Paste Ctrl+a and Ctrl+c to copy all test on the page

    builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();

    //Print the text



    // Close the browser

    driver.quit();
    }
}
