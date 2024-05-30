package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity2 {public static void main(String[] args) throws InterruptedException {
    // Setup the Firefox driver(GeckoDriver)
    WebDriverManager.firefoxdriver().setup();

    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();

    // Open the browser
    driver.get("https://v1.training-support.net/selenium/login-form");

    //print the title

    String pagetitle= driver.getTitle();
    System.out.println("Home page title:" + pagetitle);
    Thread.sleep(2000);

    // Find element usrname and enter "admin"

    driver.findElement(By.id("username")).sendKeys("admin");


    //Find element password and enter "password"

    driver.findElement(By.id("password")).sendKeys("password");


    //Find "Log in" button and click


    driver.findElement(By.xpath("//button[text()='Log in']")).click();

    //print the message

    System.out.println("The message after clicking on log in : " +driver.findElement(By.id("action-confirmation")).getText());

    Thread.sleep(2000);
    // Close the browser

    driver.quit();
}
}
