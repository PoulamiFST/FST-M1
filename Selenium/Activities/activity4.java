package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4 {
    public static void main(String[] args) {

        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://v1.training-support.net/selenium/target-practice");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        //Find the 3rd header using Xpath and print the text
        WebElement thirdheader= driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("The text of the third header is :"+thirdheader.getText());

        //Find the 5th header using Xpath and print the color
        WebElement fifthheader= driver.findElement(By.xpath("//h5[text()='Fifth header']"));
        System.out.println("The color of the fifth header is :"+fifthheader.getCssValue("color"));

        //Find the violet button and print all classes
        WebElement violetbutton= driver.findElement(By.xpath("//button[text()='Violet']"));
        System.out.println("The classes of the violet button : "+violetbutton.getAttribute("class"));

        //Find the grey button and print the text
        WebElement greybutton= driver.findElement(By.xpath("//button[text()='Grey']"));
        System.out.println("The text of the grey button is: "+greybutton.getText());

        // Close the browser
        driver.quit();
    }
}
