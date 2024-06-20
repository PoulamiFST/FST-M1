package stepDefinitions;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps extends BaseClass {


    @BeforeAll
    public static void setup() {
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


  @Given("User is on Google Home Page")
    public void openGooglepage(){
        driver.get("https://www.google.com");

  }

  @When("User types in Cheese and hits ENTER")
    public void TypeCheeseandEnter(){
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
  }

  @Then("Show how many search results were shown")
    public void showhowmanyresults (){
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
      String resultStats = driver.findElement(By.id("result-stats")).getText();
      System.out.println("Number of results found: " + resultStats);
  }

  @And("Close the browser")
    public void closebrowser(){
        driver.quit();
  }
}
