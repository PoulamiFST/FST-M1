package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class activity17 {public static void main(String[] args) throws InterruptedException {
    // Setup the Firefox driver(GeckoDriver)
    WebDriverManager.firefoxdriver().setup();

    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();

    // Open the browser
    driver.get("https://v1.training-support.net/selenium/selects");

    String pagetitle= driver.getTitle();
    System.out.println("Home page title:" + pagetitle);
    Thread.sleep(2000);

    // Find  the select WebElement


    Select dropdown = new Select(driver.findElement(By.id("single-select")));

    //select second option using visible text
    dropdown.selectByVisibleText("Option 2");
    System.out.println(dropdown.getFirstSelectedOption().getText());

    //select 3rd option using Index

    dropdown.selectByIndex(3);
    System.out.println(dropdown.getFirstSelectedOption().getText());

    //selct 4th option using value

    dropdown.selectByValue("4");
    System.out.println(dropdown.getFirstSelectedOption().getText());


    //print all options

    System.out.println("The options are:");
    for(WebElement option : dropdown.getOptions()){
        System.out.println(option.getText());
    }


    // Close the browser

    driver.quit();
}
}
