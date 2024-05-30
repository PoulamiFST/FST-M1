package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity15 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        //print the title

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        //Find the username input field and type credential as username: admin

        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        username.sendKeys("admin");

        //Find the password input field and type credential as password: password
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class, 'password')]"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Wait for login message to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        // print the login message to the console
        System.out.println("The login message is: "+driver.findElement(By.id("action-confirmation")).getText());


        // Close the browser

        driver.quit();

    }

}
