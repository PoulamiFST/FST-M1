package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity12 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        //print the title

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);


        //Find the text field
        WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));

        //Check if the text field is enabled and print it

        System.out.println("Text field is enabled : " +textbox.isEnabled());

        //Click the "Enable Input" button to enable the input field

        driver.findElement(By.id("toggleInput")).click();
        Thread.sleep(2000);

        //Check if the text field is enabled again and print it

        System.out.println("Text field is enabled : " +textbox.isEnabled());


        // Close the browser

        driver.quit();
    }
}
