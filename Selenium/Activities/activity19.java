package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity19 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));
        // Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        //Find the button to open a CONFIRM alert and click it

        driver.findElement(By.id("confirm")).click();

        //Switch the focus from the main window to the Alert box , get the text in it and print it.


        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("The alert text is: " + driver.switchTo().alert().getText());

        Thread.sleep(2000);

        //Close the alert once with Ok

        driver.switchTo().alert().accept();

        //Open the alert again and close it with cancel this time

        driver.findElement(By.id("confirm")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("The alert text is: " + driver.switchTo().alert().getText());
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();


        // Close the browser

        driver.quit();
    }
}
