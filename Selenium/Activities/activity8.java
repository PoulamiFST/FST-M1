package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity8 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(20));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        //print the title

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        //Find the checkbox toggle button and click it

        WebElement checkboxtoggle = driver.findElement(By.id("toggleCheckbox"));
        checkboxtoggle.click();

        //Wait till the checkbox disappears

        WebElement checkbox = driver.findElement(By.id("dynamicCheckbox"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        System.out.println("Checkbox is displayed :" + checkbox.isDisplayed());

        //Click toggle button again

        checkboxtoggle.click();

        //Wait till checkbox appears

        wait.until(ExpectedConditions.visibilityOf(checkbox));
        System.out.println("Checkbox is displayed :" +checkbox.isDisplayed());

        //Check the checkbox



        driver.findElement(By.xpath("//input[@class='willDisappear']")).click();
        Thread.sleep(2000);

        // Close the browser

        driver.quit();
    }

}
