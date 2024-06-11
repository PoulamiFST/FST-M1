package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Activity.ActionBase.doSwipe;

public class activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();

        //Set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize the Android driver

        driver = new AndroidDriver(serverURL, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium");


    }
    @Test
    public void WebAppTest() throws InterruptedException{
        Dimension dims= driver.manage().window().getSize();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        Point start= new Point((int) (dims.getWidth() * 0.5),(int) (dims.getHeight() * 0.8));
        Point end=  new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.5));
        doSwipe(driver, start, end, 70);

        //wait for To-do lost
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']"))).click();

        //wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        //Find the elements
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
       WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));


        addTaskInput.sendKeys("Task one");
        addTaskButton.click();
       Thread.sleep(1000);
        //Clear the list
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();



    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
