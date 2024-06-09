package Activity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity1 {
    AndroidDriver driver;

    public activity1() throws MalformedURLException {
    }


    @BeforeClass

    public void setUp() throws MalformedURLException {
        //Set the capabilities
        UiAutomator2Options caps = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.miui.calculator")
                .setAppActivity(".cal.CalculatorActivity")
                .noReset();

        //Set the server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Initialize the Android driver

        driver = new AndroidDriver(serverURL, caps);

    }

    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_7_s")).click();

        driver.findElement(AppiumBy.accessibilityId("multiply")).click();

        driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_5_s")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //Assertions
        String result = driver.findElement(AppiumBy.id("com.miui.calculator:id/result")).getText();
        Assert.assertEquals(result, "= 35");
    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }

}