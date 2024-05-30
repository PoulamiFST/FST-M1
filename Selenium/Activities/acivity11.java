package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class acivity11 {
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


        //Find the checkbox input element

        WebElement checkbox =  driver.findElement(By.xpath("//input[@class='willDisappear']"));

        //Check if it is selected on the page


        System.out.println("Checkbox is Selected: " + checkbox.isSelected());

        //Click the checkbox to select it

        checkbox.click();
        Thread.sleep(2000);


        //Check if the checkbox is selected again and print the result
        System.out.println("Checkbox is Selected: " + checkbox.isSelected());



        // Close the browser

        driver.quit();
    }
}
