package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity10 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        //print the title

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);



        //Find the checkbox input element

        WebElement checkbox = driver.findElement(By.id("dynamicCheckbox"));

        //Check if it is visible on the page


        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());

        //Click the "Remove Checkbox" button

        WebElement checkboxtoggle = driver.findElement(By.id("toggleCheckbox"));

        checkboxtoggle.click();

        //Check if it is not visible  and print the result

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());


        //Click the toggle button again to make the checkbox visible
        checkboxtoggle.click();

        //Check if the checkbox  is  visible again and print the result

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());



        // Close the browser

        driver.quit();
    }
}
