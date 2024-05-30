package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity22 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/popups");


        //Print the title of the page
        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);


        //Find the Sign in button and hover over it
        WebElement button = driver.findElement(By.className("orange"));
        builder.moveToElement(button).build().perform();

        //Print the tooltip message

        String tooltipmessage= button.getAttribute("data-tooltip");
        System.out.println("The tooltip message is :" +tooltipmessage);

        //Click the button to open the Sign in form

        button.click();

        //Enter username as admin

        driver.findElement(By.id("username")).sendKeys("admin");


        //Enter password as password

        driver.findElement(By.id("password")).sendKeys("password");

        //Click login

        driver.findElement(By.xpath("//button[text()= 'Log in']")).click();

        //print the message on the page after logging in

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());

        // Close the browser

        driver.quit();
    }

}
