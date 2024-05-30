package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity21 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tab-opener");

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        System.out.println("Current tab is :" + driver.getWindowHandle());
        Thread.sleep(2000);


        //Find the button to open a new tab and click it

        driver.findElement(By.id("launcher")).click();

        //Wait for the new tab to open and print all the handles

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Current tabs are :" + driver.getWindowHandles());


        //Switch to the newly opened tab

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        //print it's title and heading

        System.out.println("Newly opened  page title:" + driver.getTitle());
        System.out.println("Current tab is :" + driver.getWindowHandle());
        Thread.sleep(2000);


        //Repeat the steps by clicking the button in the new tab page

        driver.findElement(By.id("actionButton")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        System.out.println("Current tabs are :" + driver.getWindowHandles());

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        System.out.println("Third opened  page title:" + driver.getTitle());
        System.out.println("Current tab is :" + driver.getWindowHandle());
        Thread.sleep(2000);



        // Close the browser

        driver.quit();
    }

}
