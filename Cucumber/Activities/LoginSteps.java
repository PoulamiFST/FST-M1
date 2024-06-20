package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends BaseClass{


    @BeforeAll
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }





    @Given("the user is on the login page")
    public void openPage(){
        //Open the login page
           driver.get("https://v1.training-support.net/selenium/login-form");

        //Asser the login page
        Assertions.assertEquals("Login Form",driver.getTitle());
    }


    @When("the user enters username and password")
    public void enterCredentials(){

        //Find the username field and enter username


        driver.findElement(By.id("username")).sendKeys("admin");


        //Find the password field and enter password

        driver.findElement(By.id("password")).sendKeys("password");

    }


    @When("the user enters {string} and {string}")
    public void enterCredentialsFromInput(String username, String password){


        //clear the files first
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();


        //Find the username field and enter username


        driver.findElement(By.id("username")).sendKeys(username);


        //Find the password field and enter password

        driver.findElement(By.id("password")).sendKeys(password);

    }


    @And("clicks the submit button")

    public void clickSubmit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("get the confirmation test and verify the message")

    public void confirmmessage(){

        //Find the confirmation message

        String message = driver.findElement(By.id("action-confirmation")).getText();


        //Asserts message

        Assertions.assertEquals("Welcome Back, admin",message);
    }


    @Then("get the confirmation test and verify the message as {string}")
    public void confirmmessagefromInput(String messageinUI){

        //Find the confirmation message

        String message = driver.findElement(By.id("action-confirmation")).getText();


        //Asserts message

        Assertions.assertEquals(messageinUI,message);
    }

    @Then("Read the page title and confirmation message")
        public void readTitleAndHeading() {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

            //Read the page title and heading
            String pageTitle = driver.getTitle();
            String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

            //Print the page title and heading
            System.out.println("Page title is: " + pageTitle);
            System.out.println("Login message is: " + confirmMessage);

            if(confirmMessage.contains("admin")) {
                Assert.assertEquals(confirmMessage, "Welcome Back, admin");
            } else {
                Assert.assertEquals(confirmMessage, "Invalid Credentials");
            }
        }



    @AfterAll
    public static void closeTheBrowser() {
        driver.quit();
    }


}
