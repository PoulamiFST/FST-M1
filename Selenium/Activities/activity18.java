package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity18 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/selects");

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        // Find  the Multi select WebElement
        Select dropdown = new Select(driver.findElement(By.id("multi-select")));

        //Select the "JavaScript" option using the visible text
        dropdown.selectByVisibleText("Javascript");


        //Select the 4th, 5th and 6th options using the index
        dropdown.selectByIndex(4);
        dropdown.selectByIndex(5);
        dropdown.selectByIndex(6);

        //Select the "NodeJS" option using the value
        dropdown.selectByValue("node");

        //Print all the selected options

        List<WebElement> selectedoptions = dropdown.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedoptions) {
            System.out.println(option.getText());
        }

        //Deselect the 5th option using index
        dropdown.deselectByIndex(5);

        //print the newly selected options
        selectedoptions = dropdown.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedoptions) {
            System.out.println(option.getText());
        }


        // Close the browser

        driver.quit();

    }


}
