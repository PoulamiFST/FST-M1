package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity9 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/ajax");

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        // Find and click the "Change content" button on the page
        //WebElement checkcontent = driver.findElement(By.cssSelector("ui.violet.button"));

        WebElement checkcontent = driver.findElement(By.cssSelector("button.violet"));
                checkcontent.click();

        //Wait for the text to say "HELLO!"

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        //Print the visible text

        System.out.println("First text :" + driver.findElement(By.tagName("h1")).getText());

        //Wait for the text to change to contain "I'm late!"

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));

        //print the new text

        System.out.println("New test : " + driver.findElement(By.tagName("h3")).getText());



        // Close the browser

        driver.quit();
    }

}
