package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity7 {public static void main(String[] args) throws InterruptedException {
    // Setup the Firefox driver(GeckoDriver)
    WebDriverManager.firefoxdriver().setup();

    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
    Actions builder = new Actions(driver);

    // Open the browser
    driver.get("https://v1.training-support.net/selenium/drag-drop");

    String pagetitle = driver.getTitle();
    System.out.println("Home page title:" + pagetitle);
    Thread.sleep(2000);

    //Find the ball

    WebElement ball = driver.findElement(By.id("draggable"));

    //Find dropzone1

    WebElement dropzone1 = driver.findElement(By.id("droppable"));

    //Find dropzone2

    WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

    //Find the ball and simulate a click and drag to move it into "Dropzone 1"

    builder.clickAndHold(ball).moveToElement(dropzone1).release().build().perform();

    //verify ball is dropped in dropzone1

    String verifydropzone1 = dropzone1.findElement(By.tagName("p")).getText();

    if(verifydropzone1.equals("Dropped!"))
    {
        System.out.println("The ball has dropped into dropzone1 now");
    }


    //Move the ball into "Dropzone 2"

    builder.dragAndDrop(ball,dropzone2).build().perform();


    //verify the ball is dropped into dropzone2 now

    String verifydropzone2 = dropzone2.findElement(By.tagName("p")).getText();

    if(verifydropzone2.equals("Dropped!"))
    {
        System.out.println("The ball has dropped into dropzone2 now");
    }

    // Close the browser

    driver.quit();
    }
}
