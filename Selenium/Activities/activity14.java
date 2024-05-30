package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class activity14 {
    public static void main(String[] args) throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tables");

        //print the title

        String pagetitle = driver.getTitle();
        System.out.println("Home page title:" + pagetitle);
        Thread.sleep(2000);

        //Find the number of rows in the table and print them

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

        //List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("The number of rows of the table is:" +rows.size());


        //Find the number of columns in the table and print them

        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("The number of columns of the table is :" +cols.size());


        //Find and print the cell value at the second row second column
        WebElement cellvalue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("The cell value of second row second column is: "+cellvalue.getText());


        //Click the header of the first column to sort by name

        WebElement tablehead = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"));
        tablehead.click();
        Thread.sleep(2000);

        //Find and print the cell value at the second row second column again- it is required to define the webelment cellvalue again-point to be noted
        cellvalue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("The cell value of second row second column is now : "+cellvalue.getText());

        //Print the cell values of the table footer
        List<WebElement> tablefooter = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        for(WebElement footercell : tablefooter){
            System.out.println("The footer cell values are :" +footercell.getText() );
        }


        // Close the browser

        driver.quit();
    }
}
