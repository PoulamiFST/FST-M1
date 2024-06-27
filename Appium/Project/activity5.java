package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Activity.ActionBase.doSwipe;

public class activity5 {
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
    @Test(priority = 1)
    public void successlogin() throws InterruptedException{
        Dimension dims= driver.manage().window().getSize();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        Point start= new Point((int) (dims.getWidth() * 0.5),(int) (dims.getHeight() * 0.8));
        Point end=  new Point((int) (dims.getWidth() * 0.5), (int) (dims.getHeight() * 0.4));
        doSwipe(driver, start, end, 150);

        //wait for Login Form
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Login Form']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")));
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")).sendKeys("password");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, admin']")));
        String loginMessage = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Welcome Back, admin']")).getText();
        Assert.assertEquals(loginMessage,"Welcome Back, admin");

    }

    @Test(priority = 2)
    public void Failurelogin(){
        WebElement username = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        WebElement password = driver.findElement(AppiumBy.xpath("//android.webkit.WebView[@text='Login Form']/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        username.clear();
        password.clear();
        username.sendKeys("poulami");
        password.sendKeys("password12");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Invalid Credentials']")));
        String invalidMsg = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Invalid Credentials']")).getText();
        Assert.assertEquals(invalidMsg,"Invalid Credentials");
    }



    @AfterClass
    public void teardown(){

        driver.quit();
    }
}
