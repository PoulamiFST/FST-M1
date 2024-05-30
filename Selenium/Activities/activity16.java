package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity16 {
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

        //Find the username input field and type credential as username: Poulatest

        WebElement username = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        username.sendKeys("Poulatest");

        //Find the password input field and type credential as password: passwordnew
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        password.sendKeys("passwordnew");

        //Find the confirm password field and re-type credential as password: passwordnew
        WebElement confirmpassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        confirmpassword.sendKeys("passwordnew");

        //Find the email field and type email id
        WebElement email = driver.findElement(By.xpath("//input[starts-with(@class, 'email-')]"));
        email.sendKeys("testpoulami12@gmail.com");

        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        //Wait for login message to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        // print the login message to the console
        System.out.println("The login message is: " + driver.findElement(By.id("action-confirmation")).getText());


        // Close the browser

        driver.quit();

    }

}
