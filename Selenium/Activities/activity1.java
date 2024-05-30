package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity1 {public static void main(String[] args) throws InterruptedException {
    // Setup the Firefox driver(GeckoDriver)
    WebDriverManager.firefoxdriver().setup();

    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();

    // Open the browser
    driver.get("https://training-support.net/");

    //Print the title of the page

    String pagetitle= driver.getTitle();
    System.out.println("Home page title:" + pagetitle);
    Thread.sleep(2000);

    // Find element
    driver.findElement(By.linkText("About Us")).click();

    //Print the title of the page
    String newpagetitle= driver.getTitle();
    System.out.println("Next page title:" + newpagetitle);

    // Close the browser

    driver.quit();
}
}
